package com.plazoleta.mensajeria.application.handler;

import com.plazoleta.mensajeria.application.dto.request.EnviarSmsRequestDto;

public interface IMensajeriaHandler {
    void enviarSms(EnviarSmsRequestDto dto);
}
