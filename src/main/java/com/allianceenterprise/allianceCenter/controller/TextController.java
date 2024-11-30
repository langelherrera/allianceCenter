package com.allianceenterprise.allianceCenter.controller;

import com.allianceenterprise.allianceCenter.model.OutText;
import com.allianceenterprise.allianceCenter.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOError;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TextController {

    @Autowired
    private TextService textService;

    @PostMapping(value = "/process",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String fileProcessor(@RequestParam("file") MultipartFile file){
        try {
            if (file.isEmpty()) {
                throw new RuntimeException("El archivo está vacío");
            }

            String body = new String(file.getBytes());
            List<OutText> results=textService.textProcessor(body);
            String result = "";
            for(OutText outText: results){
                result+=outText.getPhrase().strip() +"\\"+ String.valueOf(outText.isMatch())+"\n";
            }

            return result;

        } catch (IOException e){
            throw new RuntimeException("Error al leer el archivo", e);
        }
    }
}
