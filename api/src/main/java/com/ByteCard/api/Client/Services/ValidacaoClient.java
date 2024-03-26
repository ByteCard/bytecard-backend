package com.ByteCard.api.Client.Services;

import com.ByteCard.api.Client.Dados.DadosClient;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface ValidacaoClient {
    static Boolean validacao(DadosClient dados) {
        //cpf
        String regex = "(\\d){11}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dados.cpf());

        //telefone
        String regextelefone = "(\\d){9}";
        Pattern pattertelefone = Pattern.compile(regextelefone);
        Matcher matchertelefone = pattertelefone.matcher(String.valueOf(dados.telephone()));
        if (matcher.find()&&dados.cpf().length()==11&&matchertelefone.find()&&dados.name().length()>2){
          return true;
        }else{
            return false;
        }
    }
    static String dadosClientLimpo(DadosClient dados){
        return dados.cpf().replaceAll("[^0-9]+", "");
    }
}
