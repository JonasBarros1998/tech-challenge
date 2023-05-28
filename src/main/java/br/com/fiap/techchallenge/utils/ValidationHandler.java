package br.com.fiap.techchallenge.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ValidationHandler {

    private final MessageSource messageSource;

    @Value("${app.date.format}")
    private String dateFormat;

    @Autowired
    ValidationHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorForm> handler(MethodArgumentNotValidException exception) {
        List<ErrorForm> errorFormList = new ArrayList<>();

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErrorForm errorForm = new ErrorForm(e.getField(), message);
            errorFormList.add(errorForm);
        });

        return errorFormList;
    }



    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DateTimeParseException.class)
    public List<ErrorForm> handler(DateTimeParseException exception) {
        List<ErrorForm> errorFormList = new ArrayList<>();
        ErrorForm errorForm = new ErrorForm("date",  String.format("invalid Date: %s", this.dateFormat));
        errorFormList.add(errorForm);

        return errorFormList;
    }


    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NoSuchElementException.class)
    public List<ErrorForm> handler(NoSuchElementException exception) {
        List<ErrorForm> errorFormList = new ArrayList<>();
        ErrorForm errorForm = new ErrorForm("energyEfficiency", exception.getMessage());
        errorFormList.add(errorForm);

        return errorFormList;
    }

}
