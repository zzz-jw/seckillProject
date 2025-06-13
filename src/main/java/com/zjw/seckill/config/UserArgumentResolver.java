package com.zjw.seckill.config;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.zjw.seckill.pojo.TUser;
import com.zjw.seckill.service.ITUserService;
import com.zjw.seckill.utils.CookieUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 自定义用户参数校验解析器
 *
 */
@Component
public class UserArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private ITUserService itUserService;

    /*
    * 返回值为true则进行后续的resolveArgument校验方法
    * */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        Class<?> parameterType = parameter.getParameterType();
        return parameterType == TUser.class;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        //获取httpServletRequest和httpServletResponse
        HttpServletRequest nativeRequest = webRequest.getNativeRequest(HttpServletRequest.class);
        HttpServletResponse nativeResponse = webRequest.getNativeResponse(HttpServletResponse.class);
        //得到cookie
        String userTicket = CookieUtil.getCookieValue(nativeRequest, "userTicket");
        if (StringUtils.isEmpty(userTicket)) {
            return null;
        }
        //把校验后的参数对象返回出去
        return itUserService.getUserByCookie(userTicket, nativeRequest, nativeResponse);
    }

}
