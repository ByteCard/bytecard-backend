package com.ByteCard.api.Card.Services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface Validacao {
    static boolean validacao(String cpf) {
        //cpf
        String regex = "(\\d){11}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cpf);



        if (matcher.find()&&cpf.length()==11){
            return true;
        }else{
            return false;
        }
    }
}
