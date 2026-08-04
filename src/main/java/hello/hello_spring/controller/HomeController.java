package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    // 메인 주소(/)로 들어오면, home.html 화면
    @GetMapping("/")
    public String home(){
        return "home";
    }

}
