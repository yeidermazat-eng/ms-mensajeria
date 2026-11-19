package com.plazoleta.mensajeria.domain.usecase;

import com.plazoleta.mensajeria.domain.api.IMensajeriaServicePort;
import com.plazoleta.mensajeria.domain.exception.DatosInvalidosException;
import com.plazoleta.mensajeria.domain.model.MensajeSms;
import com.plazoleta.mensajeria.domain.spi.ISmsSenderPort;

public class MensajeriaUseCase implements IMensajeriaServicePort {

    private final ISmsSenderPort smsSenderPort;

    public MensajeriaUseCase(ISmsSenderPort smsSenderPort) {
        this.smsSenderPort = smsSenderPort;
    }

    @Override
    public void enviarSms(MensajeSms mensajeSms) {
        if (mensajeSms == null || mensajeSms.getTelefonoDestino() == null || mensajeSms.getTelefonoDestino().isBlank()) {
            throw new DatosInvalidosException("El teléfono destino es obligatorio.");
        }
        if (mensajeSms.getMensaje() == null || mensajeSms.getMensaje().isBlank()) {
            throw new DatosInvalidosException("El contenido del mensaje SMS es obligatorio.");
        }
        smsSenderPort.enviarSms(mensajeSms.getTelefonoDestino(), mensajeSms.getMensaje());
    }
}
