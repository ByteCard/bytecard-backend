package com.ByteCard.api.controller;

import java.util.concurrent.ThreadLocalRandom;

public interface Cardrandom {
    public static Long numbers(int number){
        String numero = "";
        for (int i = 0; i <= number; i++) {
            long numeros = ThreadLocalRandom.current().nextInt(9);
            numero +=numeros;
        }
        Long aLong = Long.valueOf(numero);
        return aLong;

    }
    public static String numbersS(int number){
        String numero = "";
        for (int i = 0; i <= number; i++) {
            long numeros = ThreadLocalRandom.current().nextInt(9);
            numero +=numeros;
        }

        return numero;

    }
}
