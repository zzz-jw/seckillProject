package com.zjw.seckill.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjw.seckill.pojo.TGoods;
import com.zjw.seckill.vo.GoodsVo;


import java.util.List;

/**
 * 商品表 Mapper 接口
 *
 * @author LiChao
 * @since 2022-03-03
 */
public interface TGoodsMapper extends BaseMapper<TGoods> {

    /**
     * 返回商品列表
     * @author LC
     * @operation add
     * @date 5:50 下午 2022/3/3
     * @param
     * @return java.util.List<com.example.seckilldemo.vo.GoodsVo>
     **/
    List<GoodsVo> findGoodsVo();

    GoodsVo findGoodsVobyGoodsId(Long goodsId);
}
