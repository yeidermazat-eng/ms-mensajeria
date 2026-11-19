package com.plazoleta.mensajeria.domain.spi;

public interface ISmsSenderPort {
    void enviarSms(String telefonoDestino, String mensaje);
}
