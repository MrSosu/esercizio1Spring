package com.example.esercizio1Spring.parte2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/utente")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @PostMapping("/register")
    public ResponseEntity<Utente> registraUtente(@RequestBody Utente utente) {
        try{
            utenteService.registraUtente(utente);
            return ResponseEntity.ok(utente);
        } catch (IllegalArgumentException | EmailNotValidException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Utente> getUtenteById(@PathVariable Long id) {
        try {
            Utente u = utenteService.getUtenteById(id);
            return ResponseEntity.ok(u);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleRegisterException(IllegalArgumentException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmailNotValidException.class)
    public ResponseEntity<String> handleEmailException(EmailNotValidException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
