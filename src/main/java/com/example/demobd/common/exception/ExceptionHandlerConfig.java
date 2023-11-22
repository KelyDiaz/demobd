package com.example.demobd.common.exception;

import com.example.demobd.common.utils.GeneralUtil;
import com.example.demobd.common.utils.SecurityConfigUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class ExceptionHandlerConfig {
    @ExceptionHandler({ChangeSetPersister.NotFoundException.class, ResponseStatusException.class})
    @ResponseBody
    public ResponseEntity<ExceptionDTO> handleNotFoundException(HttpServletRequest request) {
        return new ResponseEntity<>(ExceptionDTO.builder()
                .timestamp(SecurityConfigUtils.blindStrSec(GeneralUtil.getTimestampValue()))
                .message(SecurityConfigUtils.blindStrSec("El recurso solicitado no fue encontrado: " + request.getQueryString()))
                .path(SecurityConfigUtils.blindStrSec(request.getRequestURI()))
                .build(), HttpStatus.NOT_FOUND);
    }
}
