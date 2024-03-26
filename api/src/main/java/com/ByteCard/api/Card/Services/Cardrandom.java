package com.ByteCard.api.Card.Services;

import java.util.concurrent.ThreadLocalRandom;

public interface Cardrandom {
    public static Long numbersCard(){
        String numero = "";
        while (true){
            for (int i = 0; i < 16; i++) {
                long numeros = ThreadLocalRandom.current().nextInt(9);
                numero +=numeros;
            }
            if (numero.length() ==16){
                break;
            }
        }
        Long aLong = Long.valueOf(numero);
        return aLong;

    }


    public static String numbercvv(){
        String numero = "";
        while (true) {
            for (int i = 0; i < 3; i++) {
                long numeros = ThreadLocalRandom.current().nextInt(9);

                numero += numeros;
            }
            if (numero.length() == 3){
                break;
            }
        }

        return numero;

    }
}
