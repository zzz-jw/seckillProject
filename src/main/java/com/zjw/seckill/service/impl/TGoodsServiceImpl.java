package com.zjw.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.zjw.seckill.dao.TGoodsMapper;
import com.zjw.seckill.pojo.TGoods;
import com.zjw.seckill.service.ITGoodsService;
import com.zjw.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品表 服务实现类
 *
 * @author LiChao
 * @since 2022-03-03
 */
@Service
@Primary
public class TGoodsServiceImpl extends ServiceImpl<TGoodsMapper, TGoods> implements ITGoodsService {

    @Autowired
    private TGoodsMapper tGoodsMapper;

    @Override
    public List<GoodsVo> findGoodsVo() {
        return tGoodsMapper.findGoodsVo();
    }

    @Override
    public GoodsVo findGoodsVobyGoodsId(Long goodsId) {
        return tGoodsMapper.findGoodsVobyGoodsId(goodsId);
    }
}
