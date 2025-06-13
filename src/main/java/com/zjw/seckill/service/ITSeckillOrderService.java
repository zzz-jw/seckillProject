package com.zjw.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zjw.seckill.pojo.TSeckillOrder;
import com.zjw.seckill.pojo.TUser;


/**
 * 秒杀订单表 服务类
 *
 * @author LiChao
 * @since 2022-03-03
 */
public interface ITSeckillOrderService extends IService<TSeckillOrder> {

    /**
     * 获取秒杀结果
     *
     * @param tUser
     * @param goodsId
     * @return orderId 成功 ；-1 秒杀失败 ；0 排队中
     * @author LiChao
     * @operation add
     * @date 7:07 下午 2022/3/8
     **/
    Long getResult(TUser tUser, Long goodsId);
}
