package com.example.demo.controller;

import com.example.util.XmlConverter;
import com.example.util.XmlFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/xml")
public class XmlUtilController {

    Logger logger = LoggerFactory.getLogger(XmlUtilController.class);

    @GetMapping("/hello")
    String hello() {
        return "hello";
    }

    @PostMapping("/format")
    String formatXmlString(@RequestBody String xmlData) {
        logger.debug("Current Thread Name: " + Thread.currentThread().getName());
        try {
            String formattedData = XmlFormatter.formatXmlString(xmlData);

            return formattedData;
        } catch (Exception e) {
            return e.getLocalizedMessage();
        }
    }

    @PostMapping("/tojson")
    String toJson(@RequestBody String xmlData) {
        logger.debug("Current Thread Name: " + Thread.currentThread().getName());
        try {
            String formattedData = XmlConverter.toJson(xmlData);

            return formattedData;
        } catch (Exception e) {
            return e.getLocalizedMessage();
        }
    }
}
