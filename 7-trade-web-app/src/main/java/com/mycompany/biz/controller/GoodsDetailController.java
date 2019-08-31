package com.mycompany.biz.controller;

import java.util.Arrays;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.stategen.framework.annotation.ApiConfig;
import org.stategen.framework.annotation.ApiRequestMappingAutoWithMethodName;
import org.stategen.framework.annotation.State;
import org.stategen.framework.enums.DataOpt;

import com.mycompany.biz.domain.Goods;
import com.mycompany.biz.domain.GoodsComment;
import com.mycompany.biz.service.GoodsCommentService;

@RequestMapping("/api/goodsDetail")
@ApiConfig
public class GoodsDetailController extends GoodsControllerBase {

    @Resource
    GoodsCommentService goodsCommentService;
    @ApiRequestMappingAutoWithMethodName
    @State(dataOpt=DataOpt.FULL_REPLACE)
    public Goods getGoodDetailById(String goodsId) {
        Goods goods = this.goodsService.getGoodByGoodsId(goodsId);
        goodsCommentService.assignBeansTo(Arrays.asList(goods), Goods::getGoodsId, Goods::setGoodComments, GoodsComment::setGoodsIds, GoodsComment::getGoodsId);
        return goods;
    }
}
