package com.zjw.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjw.seckill.dao.TSeckillGoodsMapper;
import com.zjw.seckill.pojo.TSeckillGoods;
import com.zjw.seckill.service.ITSeckillGoodsService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * 秒杀商品表 服务实现类
 *
 * @author LiChao
 * @since 2022-03-03
 */
@Service
@Primary
public class TSeckillGoodsServiceImpl extends ServiceImpl<TSeckillGoodsMapper, TSeckillGoods> implements ITSeckillGoodsService {

}
