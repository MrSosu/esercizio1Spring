package com.example.esercizio1Spring.parte2;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UtenteService {

    List<Utente> utenti = new ArrayList<>();

    public Utente registraUtente(Utente utente) {
        if (utenti.stream().anyMatch(u -> u.getEmail().equals(utente.getEmail()))) throw new IllegalArgumentException("email già presente!");
        utenti.add(utente);
        System.out.println(utenti);
        return utente;
    }

    public Utente getUtenteById(Long id) {
        List<Utente> myUtenti = utenti.stream().filter(u -> u.getId() == id).toList();
        if (myUtenti.isEmpty()) throw new IllegalArgumentException("l'utente con id " + id + " non esiste!");
        return myUtenti.getFirst();
    }

}
