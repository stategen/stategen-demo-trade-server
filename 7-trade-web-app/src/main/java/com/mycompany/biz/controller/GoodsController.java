package com.mycompany.biz.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestParam;
import org.stategen.framework.annotation.ApiConfig;
import org.stategen.framework.annotation.ApiRequestMappingAutoWithMethodName;
import org.stategen.framework.annotation.State;
import org.stategen.framework.lite.PageList;
import org.stategen.framework.util.BusinessAssert;
import org.stategen.framework.util.CollectionUtil;
import org.stategen.framework.util.StringUtil;

import com.mycompany.biz.domain.CategorySub;
import com.mycompany.biz.domain.Goods;
import com.mycompany.biz.service.CategoryService;
import com.mycompany.biz.service.CategorySubService;

@ApiConfig
public class GoodsController extends GoodsControllerBase {

    @Resource
    CategoryService categoryService;

    @Resource
    CategorySubService categorySubService;

    @ApiRequestMappingAutoWithMethodName
    @State()
    public PageList<Goods> getMallGoods(String categoryId, String categorySubId, @RequestParam(required=false, defaultValue = "10") Integer pageSize,
                                        @RequestParam(required=false,defaultValue = "1") Integer pageNum) {
        Goods goods = new Goods();
        if (StringUtil.isNotEmpty(categorySubId)) {
            goods.setCategorySubId(categorySubId);
        } else if (StringUtil.isNotEmpty(categoryId)) {
            CategorySub categorySub = new CategorySub();
            categorySub.setMallCategoryId(categoryId);
            PageList<CategorySub> pageList = categorySubService.getPageList(categorySub, 100, 1);
            List<String> ids = CollectionUtil.toList(pageList.getItems(), CategorySub::getMallSubId);
            goods.setCategorySubIds(ids);
        } else {
            BusinessAssert.throwException("categoryId 和 categorySubId 至少有一个不能为空");
        }
        PageList<Goods> pageList = this.goodsService.getPageList(goods, pageSize, pageNum);
        return pageList;
    }

}
