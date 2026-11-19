package com.plazoleta.mensajeria.infrastructure.configuration;

import com.plazoleta.mensajeria.domain.api.IMensajeriaServicePort;
import com.plazoleta.mensajeria.domain.spi.ISmsSenderPort;
import com.plazoleta.mensajeria.domain.usecase.MensajeriaUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public IMensajeriaServicePort mensajeriaServicePort(ISmsSenderPort smsSenderPort) {
        return new MensajeriaUseCase(smsSenderPort);
    }
}
