package dg.littleweather.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

import static dg.littleweather.domain.constants.LittleWeatherConstants.HTTP_500;

@ControllerAdvice
public class GeneralException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(OpenWeatherServiceException.class)
    public ResponseEntity<Object> baseExceptionHandler(OpenWeatherServiceException ex){
        ErrorResponse response = new ErrorResponse();
        response.setStatus(HTTP_500);
        response.setMessage(ex.getMessage());
        response.setTimeStamp(new Date().getTime());
        return ResponseEntity
                .status(HTTP_500)
                .body(response);
    }

    @ExceptionHandler
    public ResponseEntity<Object> exceptionHandler(Exception ex) {
        ErrorResponse response = new ErrorResponse();
        response.setStatus(HTTP_500);
        response.setMessage(ex.getMessage());
        response.setTimeStamp(new Date().getTime());
        return ResponseEntity
                .status(HTTP_500)
                .body(response);
    }

}
