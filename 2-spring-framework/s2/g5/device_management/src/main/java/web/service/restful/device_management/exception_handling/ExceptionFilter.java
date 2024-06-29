package web.service.restful.device_management.exception_handling;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import web.service.restful.device_management.Models.outputDto.HttpErrorRes;

import java.io.IOException;

@ControllerAdvice
public class ExceptionFilter extends ResponseEntityExceptionHandler {

    @Autowired
    private HttpServletRequest req;

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<HttpErrorRes> badRequestHandler(BadRequestException e) {
        return new ResponseEntity<>(new HttpErrorRes(HttpStatus.BAD_REQUEST,
                "Bad request", e.getMessage(), req.getRequestURI()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<HttpErrorRes> notFoundHandler(NotFoundException e) {
        return new ResponseEntity<>(new HttpErrorRes(HttpStatus.NOT_FOUND,
                "Not Found", e.getMessage(), req.getRequestURI()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<HttpErrorRes> genericErrorHandler(Exception e) {
        return new ResponseEntity<>(new HttpErrorRes(HttpStatus.INTERNAL_SERVER_ERROR,
                "Internal Server Error", e.getMessage(), req.getRequestURI()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<HttpErrorRes> ioExceptionHandler(IOException e) {
        return new ResponseEntity<>(new HttpErrorRes(HttpStatus.SERVICE_UNAVAILABLE,
                "Service Unavailable", e.getMessage(), req.getRequestURI()), HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<HttpErrorRes> internalServerErrorhandler(InternalServerErrorException e) {
        return genericErrorHandler(e);
    }


}
