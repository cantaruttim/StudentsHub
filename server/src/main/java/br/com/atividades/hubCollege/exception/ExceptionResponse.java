package br.com.atividades.hubCollege.exception;

import java.util.Date;


// format our exception in a friendly way
public record ExceptionResponse(
        Date timestamp,
        String message,
        String details) {
}
