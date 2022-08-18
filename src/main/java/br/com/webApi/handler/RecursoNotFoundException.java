package br.com.webApi.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecursoNotFoundException extends RuntimeException{
    public  RecursoNotFoundException(){
        super();
    }
    public RecursoNotFoundException(String message){
        super(message);
    }
}
