package com.example.esercizio1Spring.parte1;

import org.springframework.stereotype.Service;

@Service
public class MathService {

    public double radiceQuadrata(int n) {
        return Math.sqrt((double) n);
    }

    public int fibonacci(int n) {
        if (n < 2) return n;
        int[] array = new int[n];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < n; i++) {
            array[i] = array[i-1] + array[i-2];
        }
        return array[n-1];
    }

}
