package br.com.maquininha.cartao.maquininha.cartao.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MensagemDeErro manipularExcecoesDeValidacao(MethodArgumentNotValidException exception){
        List<FieldError> fildErros = exception.getBindingResult().getFieldErrors();
        List<Erro> erros = fildErros.stream().map(objeto -> new Erro(objeto.getField(), objeto.getDefaultMessage()))
                .collect(Collectors.toList());

        return new MensagemDeErro(400, erros);
    }


    @ExceptionHandler(VendaNaoLocalizadaException.class)
    public MensagemDeErro manipularVendaNaolocalizada(VendaNaoLocalizadaException exception){
        List<Erro> erros = Arrays.asList(new Erro(exception.getLocalizedMessage(), exception.getMessage()));


        return new MensagemDeErro(400, erros);
    }

    @ExceptionHandler(AcessoNegadoException.class)
    public ResponseEntity<?> runtimeHandler(AcessoNegadoException exception){
        HashMap<String, String> mensagem = new HashMap<>();
        mensagem.put("mensagemErro", exception.getMessage());

        return ResponseEntity.status(exception.getStatusCode()).body(mensagem);
    }

    @ExceptionHandler(TokenNotValidException.class)
    public ResponseEntity<?> runtimeHandler(TokenNotValidException exception){
        HashMap<String, String> mensagem = new HashMap<>();
        mensagem.put("mensagemErro", exception.getMessage());

        return ResponseEntity.status(exception.getStatusCode()).body(mensagem);
    }
}
