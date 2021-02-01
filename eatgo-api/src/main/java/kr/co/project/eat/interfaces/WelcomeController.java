package kr.co.project.eat.interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController// Json 형태로 객체 데이터를 반환
public class WelcomeController {
    @GetMapping("/")
    public String hello(){

        return "Hello,World!!!!!!";
    }
}
