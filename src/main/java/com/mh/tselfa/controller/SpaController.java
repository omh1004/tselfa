package com.mh.tselfa.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpaController {

    // Vue.js 라우터를 위한 폴백 컨트롤러
    // API 요청이 아닌 모든 GET 요청을 index.html로 전달
    @GetMapping(value = {"/", "/{path:^(?!api|assets).*$}/**"})
    public String forward() {
        return "forward:/index.html";
    }
}