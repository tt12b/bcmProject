package ywluv.bcmProject.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesController2 {

    public String test(String test){
        System.out.println("test = " + test);
        System.out.println("\"12345\" = " + "12345");
        return null;
    }
}
