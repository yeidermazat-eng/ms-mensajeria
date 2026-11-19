package com.plazoleta.mensajeria.infrastructure.output.twilio;

import com.plazoleta.mensajeria.domain.spi.ISmsSenderPort;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TwilioSmsAdapter implements ISmsSenderPort {

    private static final Logger log = LoggerFactory.getLogger(TwilioSmsAdapter.class);

    @Value("${twilio.enabled:false}")
    private boolean twilioEnabled;

    @Value("${twilio.account-sid}")
    private String accountSid;

    @Value("${twilio.auth-token}")
    private String authToken;

    @Value("${twilio.phone-number}")
    private String fromNumber;

    @Override
    public void enviarSms(String telefonoDestino, String mensaje) {
        if (twilioEnabled) {
            Twilio.init(accountSid, authToken);
            Message.creator(
                    new PhoneNumber(telefonoDestino),
                    new PhoneNumber(fromNumber),
                    mensaje
            ).create();
            log.info("SMS enviado vía Twilio a {}", telefonoDestino);
        } else {
            log.info("[MODO SIMULADO SMS] Para: {} | Mensaje: {}", telefonoDestino, mensaje);
        }
    }
}
