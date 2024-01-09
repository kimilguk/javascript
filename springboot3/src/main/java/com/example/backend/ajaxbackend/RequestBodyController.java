package com.example.backend.ajaxbackend;

import com.example.backend.domain.PersonVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
@Controller
@CrossOrigin(origins = "*")
public class RequestBodyController {
    @PostMapping("/rb1")
    @ResponseBody
    public String test1(@RequestParam("name") String name, @RequestParam("age") int age) {
        System.out.println(">>> " + name+":"+age);
        return "폼태그로 전달된 파라미터 : "+name+":"+age;
    }
    @PostMapping(value = "/rb2", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String test2(@RequestBody String param) {
        System.out.println(">>> " + param);
        return param;
    }
    @PostMapping(value = "/rb3", produces = "application/json; charset=utf-8")
    @ResponseBody
    public PersonVO test3(@RequestBody PersonVO vo) {
        System.out.println(">>> " + vo.getName()+":"+vo.getAge());
        return vo;
    }
    @PostMapping(value = "/rb4", produces = "application/json; charset=utf-8")
    @ResponseBody
    public Map test4(@RequestBody Map<String,String> map) {
        System.out.println(">>> " + map);
        return map;
    }
}
