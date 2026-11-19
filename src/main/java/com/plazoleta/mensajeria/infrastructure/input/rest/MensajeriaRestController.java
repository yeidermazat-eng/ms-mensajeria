package com.plazoleta.mensajeria.infrastructure.input.rest;

import com.plazoleta.mensajeria.application.dto.request.EnviarSmsRequestDto;
import com.plazoleta.mensajeria.application.handler.IMensajeriaHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/mensajeria")
@Tag(name = "Mensajería SMS", description = "Notificación SMS con PIN de seguridad para pedidos listos (HU 14)")
public class MensajeriaRestController {

    private final IMensajeriaHandler mensajeriaHandler;

    public MensajeriaRestController(IMensajeriaHandler mensajeriaHandler) {
        this.mensajeriaHandler = mensajeriaHandler;
    }

    @Operation(summary = "Enviar SMS con PIN de seguridad")
    @PostMapping("/sms")
    public ResponseEntity<Map<String, String>> enviarSms(@Valid @RequestBody EnviarSmsRequestDto dto) {
        mensajeriaHandler.enviarSms(dto);
        return ResponseEntity.ok(Map.of("estado", "SMS enviado correctamente"));
    }
}
