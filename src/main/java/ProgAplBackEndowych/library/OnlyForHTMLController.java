package ProgAplBackEndowych.library;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class OnlyForHTMLController {


@GetMapping("/home2")
    public String home() {
        return "MainSite2";
    }


}
