package com.plazoleta.mensajeria.application.dto.request;

import jakarta.validation.constraints.NotBlank;

public class EnviarSmsRequestDto {
    @NotBlank(message = "El teléfono destino es obligatorio")
    private String telefonoDestino;

    @NotBlank(message = "El mensaje es obligatorio")
    private String mensaje;

    public String getTelefonoDestino() { return telefonoDestino; }
    public void setTelefonoDestino(String telefonoDestino) { this.telefonoDestino = telefonoDestino; }
    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
}
