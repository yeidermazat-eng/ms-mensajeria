package com.plazoleta.mensajeria.domain.api;

import com.plazoleta.mensajeria.domain.model.MensajeSms;

public interface IMensajeriaServicePort {
    void enviarSms(MensajeSms mensajeSms);
}
