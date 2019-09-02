package com.mycompany.biz.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.stategen.framework.annotation.ApiConfig;
import org.stategen.framework.annotation.ApiRequestMappingAutoWithMethodName;
import org.stategen.framework.annotation.State;
import org.stategen.framework.enums.DataOpt;
import org.stategen.framework.lite.PageList;

import com.mycompany.biz.domain.Category;
import com.mycompany.biz.domain.CategorySub;
import com.mycompany.biz.service.CategorySubService;

@ApiConfig
public class CategoryController extends CategoryControllerBase {
    
    @Resource
    CategorySubService categorySubService;
    
    @ApiRequestMappingAutoWithMethodName
    @State(init=true, dataOpt=DataOpt.FULL_REPLACE)
    public List<Category> getCategory() {
        Category category =new Category();
        category.setCreateTimeMax(new Date());
        PageList<Category> pageList = this.categoryService.getPageList(category, 100, 1);
        List<com.mycompany.biz.domain.Category> items = pageList.getItems();
        categorySubService.assignBeansTo(items, Category::getCategoryId, Category::setCategorySubs, CategorySub::setCategoryIds, CategorySub::getCategoryId);
        return items;
        
    }

}
