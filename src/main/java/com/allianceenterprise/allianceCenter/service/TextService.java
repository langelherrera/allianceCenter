package com.allianceenterprise.allianceCenter.service;

import com.allianceenterprise.allianceCenter.model.OutText;
import com.allianceenterprise.allianceCenter.validator.TextValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TextService {

    @Autowired
    private TextValidator textValidator;

    public List<OutText> textProcessor(String inputText){

        textValidator.inputValidator(inputText);
        List<OutText> listOutText =new ArrayList<>();

        for(String line: inputText.split("\n")){

            String[] parts = line.split("\\\\");
            int number = Integer.parseInt(parts[0]);
            String phrase = parts[1].toLowerCase().replaceAll("[^a-z\\s]", "");
            boolean match = number == phrase.split("\\s+").length;
            listOutText.add(new OutText(phrase,match));
        }

        return listOutText;
    }


}
