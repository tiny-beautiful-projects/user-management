package hello.hello_spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// Controller는 웹 브라우저의 접속 요청을 받아 적절한 데이타를 준비하고, 보여줄 화면(HTML)을 연결해 주는 핵심 창구
@Controller
public class HelloController {
    // 사용자가 브라우저 주소창에 /hello라고 입력하면 이 메소드를 실행
    @GetMapping("hello")
    public String hello(Model model){
        // 화면에 보여줄 데이터로 "YUNA"를 담아둡니다.
        model.addAttribute("data", "YUNA");
        return "hello";
    }
    // 사용자가 /hello-mvc?name=스프링 형태로 요청을 보내면, 파라미터(name)를 받아서 이 메소드를 실행
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        // 사용자가 넘겨준 이름 데이터를 화면으로 전달
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;
        public String getName(){
            return name;
        }
        public void setName(String name){
           this.name = name;
        }
    }



}
