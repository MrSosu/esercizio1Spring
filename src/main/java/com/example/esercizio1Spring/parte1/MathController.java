package com.example.esercizio1Spring.parte1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @Autowired
    private MathService mathService;

    @GetMapping("/sqrt/{n}")
    public ResponseEntity<String> sqrt(@PathVariable int n) {
        if (n < 0) return new ResponseEntity<>("non puoi fare la radice quadrata di un numero negativo!", HttpStatus.BAD_REQUEST);
        else {
            double radice = mathService.radiceQuadrata(n);
            return new ResponseEntity<>(String.valueOf(radice), HttpStatus.OK);
        }
    }

    @GetMapping("/fib/{n}")
    public ResponseEntity<String> fibonacci(@PathVariable int n) {
        if (n < 0) return new ResponseEntity<>("non puoi fare il fibonacci di un numero negativo!", HttpStatus.BAD_REQUEST);
        else {
            int fact = mathService.fibonacci(n);
            return new ResponseEntity<>(String.valueOf(fact), HttpStatus.OK);
        }
    }


}
