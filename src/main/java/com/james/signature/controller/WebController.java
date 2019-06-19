package com.james.signature.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.annotations.ApiIgnore;

/**
 *  配置静态页面URL， 目前静态页面未使用ajax
 */
@ApiIgnore
@Controller
public class WebController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLogin() {
        return "login";
    }

    @RequestMapping(value = "/userinit", method = RequestMethod.GET)
    public String getUserInit() {
        return "userinit";
    }

    @RequestMapping(value = "/usermanage", method = RequestMethod.GET)
    public String getUserManage() {
        return "usermanage";
    }
}
