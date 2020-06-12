package org.chabug.fastjson.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @RequestMapping("/index")
    public String index() {
        return "hello fastjson!";
    }

    @RequestMapping("/json")
    @ResponseBody
    protected String json(@RequestBody String json) {
        Object object = JSON.parseObject(json);
        return object.toString();
    }

}
