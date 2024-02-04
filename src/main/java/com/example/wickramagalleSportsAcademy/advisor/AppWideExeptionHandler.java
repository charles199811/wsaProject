package com.example.wickramagalleSportsAcademy.advisor;

import com.example.wickramagalleSportsAcademy.exeption.NotFoundExeption;
import com.example.wickramagalleSportsAcademy.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExeptionHandler {
    @ExceptionHandler(NotFoundExeption.class)
    public ResponseEntity<StandardResponse>handlerNotFoundExeption(NotFoundExeption e){
        ResponseEntity<StandardResponse> standardResponse = new ResponseEntity<StandardResponse>(
                new StandardResponse(404, "Error", e.getMessage ()),
                HttpStatus.NOT_FOUND
        );
        return standardResponse;
    }
}
