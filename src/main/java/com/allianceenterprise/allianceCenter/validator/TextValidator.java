package com.allianceenterprise.allianceCenter.validator;

import org.springframework.stereotype.Component;

@Component
public class TextValidator {

    public void inputValidator(String inputText){

        if(inputText==null || inputText.isEmpty()){
            throw new RuntimeException("El texto de entrada no puede estar vacio");
        }

        String[] lines =inputText.split("\n");
        for (String line :lines){
            if(!line.contains("\\")){
                throw new RuntimeException("Formato Invalido en la Línea: "+ line);
            }
        }
    }
}
