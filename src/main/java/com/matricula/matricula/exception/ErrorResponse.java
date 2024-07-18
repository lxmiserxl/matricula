package com.matricula.matricula.exception;

import java.time.LocalDateTime;

public record ErrorResponse(
        LocalDateTime datetime,
        String message,
        String path) {

}
