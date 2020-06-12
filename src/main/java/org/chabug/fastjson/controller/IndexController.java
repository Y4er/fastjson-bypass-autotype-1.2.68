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

    @RequestMapping("/parseObject")
    @ResponseBody
    protected String parseObject(@RequestBody String json) {
        try {
            Object object = JSON.parseObject(json);
            return object.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    @RequestMapping("/parse")
    @ResponseBody
    protected String parse(@RequestBody String json) {
        try {
            Object object = JSON.parse(json);
            return object.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }

}
