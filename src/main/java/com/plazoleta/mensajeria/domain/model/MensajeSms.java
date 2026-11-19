package com.plazoleta.mensajeria.domain.model;

public class MensajeSms {
    private String telefonoDestino;
    private String mensaje;

    public MensajeSms() {}
    public MensajeSms(String telefonoDestino, String mensaje) {
        this.telefonoDestino = telefonoDestino;
        this.mensaje = mensaje;
    }

    public String getTelefonoDestino() { return telefonoDestino; }
    public void setTelefonoDestino(String telefonoDestino) { this.telefonoDestino = telefonoDestino; }
    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
}
