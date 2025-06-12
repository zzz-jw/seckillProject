package com.zjw.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zjw.seckill.pojo.TUser;
import com.zjw.seckill.vo.LoginVo;
import com.zjw.seckill.vo.RespBean;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author LiChao
 * @since 2022-03-02
 */

public interface ITUserService extends IService<TUser> {


    RespBean doLongin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response);


    TUser getUserByCookie(String userTicket, HttpServletRequest request, HttpServletResponse response);



    RespBean updatePassword(String userTicket, String password, HttpServletRequest request, HttpServletResponse response);
}
