package ywluv.bcmProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AttendanceController {


    @GetMapping("/attendance")
    public String attendance(Model model){

        System.out.println("ㅇㅇㅇㅇㅇㅇㅇ출석부");
        return "attendance/attendance";

    }
}
