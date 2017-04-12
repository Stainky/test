package com.test.controller;
/**
 * Created by sj on 17/1/15.
 */

import com.test.domain.Test;
import com.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    private TestService testService;

    @RequestMapping("/test/query")
    @ResponseBody
    public void testQuery() {
        Test test = testService.selectByPrimaryKey(1);
        System.out.println(test.getUserName());
    }

    @RequestMapping("/test")
    @ResponseBody
    public Map<String, String> test() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("sadf", "assf");
        return map;
    }
    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        System.out.println("there...");
        return "hello";
    }

}
