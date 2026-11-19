package com.plazoleta.mensajeria.domain.usecase;

import com.plazoleta.mensajeria.domain.exception.DatosInvalidosException;
import com.plazoleta.mensajeria.domain.model.MensajeSms;
import com.plazoleta.mensajeria.domain.spi.ISmsSenderPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MensajeriaUseCaseTest {

    @Mock
    private ISmsSenderPort smsSenderPort;

    @InjectMocks
    private MensajeriaUseCase mensajeriaUseCase;

    @Test
    void enviarSms_Exitoso() {
        mensajeriaUseCase.enviarSms(new MensajeSms("+573001112233", "Tu pedido está listo. PIN: 482910"));
        verify(smsSenderPort).enviarSms("+573001112233", "Tu pedido está listo. PIN: 482910");
    }

    @Test
    void enviarSms_SinTelefono_LanzaExcepcion() {
        assertThrows(DatosInvalidosException.class,
                () -> mensajeriaUseCase.enviarSms(new MensajeSms("", "Hola")));
    }
}
