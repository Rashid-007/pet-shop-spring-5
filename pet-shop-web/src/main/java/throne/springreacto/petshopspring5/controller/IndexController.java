package throne.springreacto.petshopspring5.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class IndexController {
    @RequestMapping({"", "/", "index", "index.html"})
    public String index(){
        return "index";
    }
}
