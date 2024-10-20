package pos.spring.possystemmongo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/status")
public class StatusCheckController {
    @GetMapping
    public String statusTest(){
        return "Application status is good.........!";
    }
}
