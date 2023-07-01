package ywluv.bcmProject.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @GetMapping("/config")
    @ResponseBody
    public String managerConfig(){

        return "manager/config";
    }
}
