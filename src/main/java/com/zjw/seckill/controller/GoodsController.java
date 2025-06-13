package com.zjw.seckill.controller;


import com.zjw.seckill.pojo.TUser;
import com.zjw.seckill.service.ITGoodsService;
import com.zjw.seckill.service.ITUserService;
import com.zjw.seckill.vo.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.WebContext;

import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.util.StringUtils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 商品
 *
 * @author: LC
 * @date 2022/3/2 5:56 下午
 * @ClassName: GoodsController
 */
@Controller
@RequestMapping("goods")
@Api(value = "商品", tags = "商品")
public class GoodsController {

    @Autowired
    private ITUserService itUserService;
    @Autowired
    private ITGoodsService itGoodsService;

@Autowired
private RedisTemplate redisTemplate;
@Autowired
private ThymeleafViewResolver thymeleafViewResolver;
/*

    @ApiOperation("商品列表")
    @RequestMapping(value = "/toList2", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    public String toList2(Model model, TUser user, HttpServletRequest request, HttpServletResponse response) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        String html = (String) valueOperations.get("goodsList");
        if (!StringUtils.isEmpty(html)) {
            return html;
        }

        model.addAttribute("user", user);
        model.addAttribute("goodsList", itGoodsService.findGoodsVo());

        WebContext webContext = new WebContext(request, response, request.getServletContext(), request.getLocale(), model.asMap());
        html = thymeleafViewResolver.getTemplateEngine().process("goodsList", webContext);
        if (!StringUtils.isEmpty(html)) {
            valueOperations.set("goodsList", html, 60, TimeUnit.SECONDS);
        }
        return html;
    }
*/


    /*@ApiOperation("商品列表")
    @RequestMapping(value = "/toList", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    public String toList(Model model, TUser user, HttpServletRequest request, HttpServletResponse response) {
       *//* ValueOperations valueOperations = redisTemplate.opsForValue();
        String html = (String) valueOperations.get("goodsList");
        if (!StringUtils.isEmpty(html)) {
            return html;
        }

        model.addAttribute("user", user);
        //model.addAttribute("goodsList", itGoodsService.findGoodsVo());

        //WebContext webContext = new WebContext(request, response, request.getServletContext(), request.getLocale(), model.asMap());
        //html = thymeleafViewResolver.getTemplateEngine().process("goodsList", webContext);
        if (!StringUtils.isEmpty(html)) {
            valueOperations.set("goodsList", html, 60, TimeUnit.SECONDS);
        }
        return html;*//*

        return  "goodsList";
    }*/
    @ApiOperation("商品列表")
    @RequestMapping(value = "/toList", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    public String toList(Model model, TUser user) {
        //使用了webMVC中自带的参数解析器提前对参数进行了校验
        /*if(userTicket == null)
            return "redirect:/login/toLogin";
        TUser user = itUserService.getUserByCookie(userTicket,request,response);
        if(user == null)
            return "redirect:/login/toLogin";
        */
        model.addAttribute("user", user);
        model.addAttribute("goodsList", itGoodsService.findGoodsVo());
        return  "goodsList";
    }

    /*@ApiOperation("商品详情")
    @RequestMapping(value = "/goodsDetail2/{goodsId}", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    public String toDetail2(Model model, TUser user, @PathVariable Long goodsId, HttpServletRequest request, HttpServletResponse response) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        String html = (String) valueOperations.get("goodsDetail:" + goodsId);
        if (!StringUtils.isEmpty(html)) {
            return html;
        }

        model.addAttribute("user", user);
        GoodsVo goodsVo = itGoodsService.findGoodsVobyGoodsId(goodsId);
        Date startDate = goodsVo.getStartDate();
        Date endDate = goodsVo.getEndDate();
        Date nowDate = new Date();
        //秒杀状态
        int seckillStatus = 0;
        //秒杀倒计时
        int remainSeconds = 0;

        if (nowDate.before(startDate)) {
            //秒杀还未开始0
            remainSeconds = (int) ((startDate.getTime() - nowDate.getTime()) / 1000);
        } else if (nowDate.after(endDate)) {
            //秒杀已经结束
            seckillStatus = 2;
            remainSeconds = -1;
        } else {
            //秒杀进行中
            seckillStatus = 1;
            remainSeconds = 0;
        }
        model.addAttribute("remainSeconds", remainSeconds);
        model.addAttribute("goods", goodsVo);
        model.addAttribute("seckillStatus", seckillStatus);

        WebContext webContext = new WebContext(request, response, request.getServletContext(), request.getLocale(), model.asMap());
        html = thymeleafViewResolver.getTemplateEngine().process("goodsDetail", webContext);
        if (!StringUtils.isEmpty(html)) {
            valueOperations.set("goodsDetail:" + goodsId, html, 60, TimeUnit.SECONDS);
        }

        return html;
    }
*/
    @ApiOperation("商品详情")
    @RequestMapping(value = "/detail/{goodsId}", method = RequestMethod.GET)
    public String toDetail(TUser user, Model model, @PathVariable Long goodsId) {
        /*ValueOperations valueOperations = redisTemplate.opsForValue();
//        String html = (String) valueOperations.get("goodsDetail:" + goodsId);
//        if (!StringUtils.isEmpty(html)) {
//            return html;
//        }

//        model.addAttribute("user", user);
        GoodsVo goodsVo = itGoodsService.findGoodsVobyGoodsId(goodsId);
        Date startDate = goodsVo.getStartDate();
        Date endDate = goodsVo.getEndDate();
        Date nowDate = new Date();
        //秒杀状态
        int seckillStatus = 0;
        //秒杀倒计时
        int remainSeconds = 0;

        if (nowDate.before(startDate)) {
            //秒杀还未开始0
            remainSeconds = (int) ((startDate.getTime() - nowDate.getTime()) / 1000);
        } else if (nowDate.after(endDate)) {
            //秒杀已经结束
            seckillStatus = 2;
            remainSeconds = -1;
        } else {
            //秒杀进行中
            seckillStatus = 1;
            remainSeconds = 0;
        }
//        model.addAttribute("remainSeconds", remainSeconds);
//        model.addAttribute("goods", goodsVo);
//        model.addAttribute("seckillStatus", seckillStatus);

//        WebContext webContext = new WebContext(request, response, request.getServletContext(), request.getLocale(), model.asMap());
//        html = thymeleafViewResolver.getTemplateEngine().process("goodsDetail", webContext);
//        if (!StringUtils.isEmpty(html)) {
//            valueOperations.set("goodsDetail:" + goodsId, html, 60, TimeUnit.SECONDS);
//        }
        DetailVo detailVo = new DetailVo();
        detailVo.setTUser(user);
        detailVo.setGoodsVo(goodsVo);
        detailVo.setRemainSeconds(remainSeconds);
        detailVo.setSecKillStatus(seckillStatus);
        return RespBean.success(detailVo);*/
        model.addAttribute("user", user);
        model.addAttribute("goods", itGoodsService.findGoodsVobyGoodsId(goodsId));
        return "goodsDetail";
    }

}
