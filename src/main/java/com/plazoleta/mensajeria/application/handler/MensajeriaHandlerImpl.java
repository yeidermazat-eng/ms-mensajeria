package com.plazoleta.mensajeria.application.handler;

import com.plazoleta.mensajeria.application.dto.request.EnviarSmsRequestDto;
import com.plazoleta.mensajeria.domain.api.IMensajeriaServicePort;
import com.plazoleta.mensajeria.domain.model.MensajeSms;
import org.springframework.stereotype.Service;

@Service
public class MensajeriaHandlerImpl implements IMensajeriaHandler {

    private final IMensajeriaServicePort mensajeriaServicePort;

    public MensajeriaHandlerImpl(IMensajeriaServicePort mensajeriaServicePort) {
        this.mensajeriaServicePort = mensajeriaServicePort;
    }

    @Override
    public void enviarSms(EnviarSmsRequestDto dto) {
        mensajeriaServicePort.enviarSms(new MensajeSms(dto.getTelefonoDestino(), dto.getMensaje()));
    }
}
