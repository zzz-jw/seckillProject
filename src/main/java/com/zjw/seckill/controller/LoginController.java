package com.zjw.seckill.controller;

import com.zjw.seckill.service.ITUserService;
import com.zjw.seckill.vo.LoginVo;
import com.zjw.seckill.vo.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/login")
@Slf4j
@Api(value = "登录", tags = "登录")
public class LoginController {


    @Autowired
    private ITUserService tUserService;

    @ApiOperation("跳转登录页面")
    @RequestMapping(value = "/toLogin")
    public String toLogin() {
        return "login";
    }


    @ApiOperation("登录接口")
    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    @ResponseBody
    public RespBean doLogin(@Valid LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) {
        log.info("{}", loginVo);
        return tUserService.doLongin(loginVo, request, response);
    }
}
