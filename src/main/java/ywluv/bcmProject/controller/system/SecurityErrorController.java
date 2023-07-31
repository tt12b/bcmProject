package ywluv.bcmProject.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecurityErrorController {

    @GetMapping("/AuthenticationError")
    public String AuthenticationError(
                                        @RequestParam(value="exception", required = false) String exception
                                     ,  @RequestParam(value="errorMessage", required = false) String errorMessage
                                     ,  Model model
                                      )
    {

        String redirectUrl = "/";
        model.addAttribute("exception",exception);
        model.addAttribute("errorMessage",errorMessage);

        return redirectUrl;
    }
}
