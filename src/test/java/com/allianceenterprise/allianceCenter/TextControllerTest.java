package com.allianceenterprise.allianceCenter;

import com.allianceenterprise.allianceCenter.controller.TextController;
import com.allianceenterprise.allianceCenter.model.OutText;
import com.allianceenterprise.allianceCenter.service.TextService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;


import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(TextController.class)

public class TextControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TextService textService;


    @Test
    public void testFileProcess() throws Exception {
        String fileContent = "3\\the force is strong in this one\n7\\take what you can, give nothing back";

        MockMultipartFile file = new MockMultipartFile(
                "file",
                "archivo.txt",
                MediaType.TEXT_PLAIN_VALUE,
                fileContent.getBytes()
        );

        List<OutText> mockResult = List.of(
                new OutText("the force is strong in this one", false),
                new OutText("take what you can give nothing back", true)
        );

        Mockito.when(textService.textProcessor(Mockito.anyString())).thenReturn(mockResult);

        mockMvc.perform(multipart("/api/process").file(file))
                .andExpect(status().isOk())
                .andExpect(content().string("the force is strong in this one\\false\n" +
                        "take what you can give nothing back\\true\n"));
    }




    }




