package com.example.call_service.controller;

import com.example.call_service.service.CallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@CrossOrigin("*")
@RestController

public class CallController {
    @Autowired
    CallService callService;

    @PostMapping("/callImportService")
    public void uploadAndFillExcelFile(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("Đã nhận được api và gọi cổng service khác");


        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "http://localhost:8081/importExcel";

        try (InputStream inputStream = file.getInputStream()) {


            InputStream inputStream1 = inputStream;


            restTemplate.postForObject(apiUrl,inputStream1, Void.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}



