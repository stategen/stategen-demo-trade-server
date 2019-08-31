package com.mycompany.biz.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.stategen.framework.annotation.ApiConfig;
import org.stategen.framework.annotation.ApiRequestMappingAutoWithMethodName;
import org.stategen.framework.annotation.State;
import org.stategen.framework.annotation.Wrap;
import org.stategen.framework.lite.PageList;
import org.stategen.framework.util.CollectionUtil;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mycompany.biz.domain.Category;
import com.mycompany.biz.domain.CategorySub;
import com.mycompany.biz.domain.FloorAdvertisePricture;
import com.mycompany.biz.domain.FloorGoods;
import com.mycompany.biz.domain.FloorNames;
import com.mycompany.biz.domain.Goods;
import com.mycompany.biz.domain.HomeAdvertise;
import com.mycompany.biz.domain.HomeGoods;
import com.mycompany.biz.domain.HomeShop;
import com.mycompany.biz.domain.HomeWrap;
import com.mycompany.biz.domain.Slide;
import com.mycompany.biz.service.AdvertisePictureService;
import com.mycompany.biz.service.CategoryService;
import com.mycompany.biz.service.CategorySubService;
import com.mycompany.biz.service.FloorAdvertisePrictureService;
import com.mycompany.biz.service.FloorGoodsService;
import com.mycompany.biz.service.GoodsCommentService;
import com.mycompany.biz.service.GoodsService;
import com.mycompany.biz.service.HomeAdvertiseService;
import com.mycompany.biz.service.HomeGoodsService;
import com.mycompany.biz.service.HomeShopService;
import com.mycompany.biz.service.ShopService;
import com.mycompany.biz.service.SlideService;

@ApiConfig
@RequestMapping("api/home")
@Wrap
public class HomeController {
    @Resource
    CategoryService categoryService;

    @Resource
    CategorySubService categorySubService;

    @Resource
    GoodsService goodsService;

    @Resource
    GoodsCommentService goodsCommentService;

    @Resource
    AdvertisePictureService advertisePictureService;

    @Resource
    SlideService slideService;

    @Resource
    HomeGoodsService homeGoodsService;

    @Resource
    HomeAdvertiseService homeAdvertiseService;

    @Resource
    HomeShopService homeShopService;

    @Resource
    ShopService shopService;

    @Resource
    FloorAdvertisePrictureService floorAdvertisePrictureService;

    @Resource
    FloorGoodsService floorGoodsService;

    @ApiRequestMappingAutoWithMethodName
    public HomeWrap homePageContent(Float lon, Float lat) {
        HomeWrap homeWrap = new HomeWrap();
        Date createTimeMax = new Date();
        Slide slide = new Slide();
        slide.setCreateTimeMax(createTimeMax);
        //
        PageList<Slide> slidePageList = this.slideService.getPageList(slide, 10, 1);
        homeWrap.setSlides(slidePageList.getItems());

        //
        HomeShop homeShop = new HomeShop();
        homeShop.setCreateTimeMax(createTimeMax);
        PageList<HomeShop> homeShopPageList = this.homeShopService.getPageList(homeShop, 1, 1);
        shopService.mergeBeanTo(homeShopPageList.getItems(), HomeShop::getShopId);
        homeWrap.setShopInfo(CollectionUtil.getFirst(homeShopPageList.getItems()));

        //
        HomeGoods homeGoods = new HomeGoods();
        homeGoods.setCreateTimeMax(createTimeMax);
        PageList<HomeGoods> homeGoodsPageList = this.homeGoodsService.getPageList(homeGoods, 100, 1);
        this.goodsService.mergeBeanTo(homeGoodsPageList.getItems(), HomeGoods::getGoodsId);
        homeWrap.setRecommend(homeGoodsPageList.getItems());

        //
        HomeAdvertise homeAdvertise = new HomeAdvertise();
        homeAdvertise.setCreateTimeMax(createTimeMax);
        PageList<HomeAdvertise> homAdvPageList = this.homeAdvertiseService.getPageList(homeAdvertise, 1, 1);
        this.advertisePictureService.mergeBeanTo(homAdvPageList.getItems(), HomeAdvertise::getAdvertiseId);
        homeWrap.setAdvertesPicture(CollectionUtil.getFirst(homAdvPageList.getItems()));

        //
        FloorAdvertisePricture floorAdvertisePricture = new FloorAdvertisePricture();
        floorAdvertisePricture.setCreateTimeMax(createTimeMax);
        PageList<FloorAdvertisePricture> floorPageList = this.floorAdvertisePrictureService.getPageList(floorAdvertisePricture, 10, 1);
        List<FloorAdvertisePricture> floors = floorPageList.getItems();
        floorGoodsService.assignBeansTo(floors, FloorAdvertisePricture::getFloorId, FloorAdvertisePricture::setFloorGoodss, FloorGoods::setFloorIds,
            FloorGoods::getFloorId);
        List<FloorGoods> allfFloorGoods = new ArrayList<FloorGoods>();
        for (FloorAdvertisePricture floor : floors) {
            if (CollectionUtil.isNotEmpty(floor.getFloorGoodss())) {
                allfFloorGoods.addAll(floor.getFloorGoodss());
            }
        }
        advertisePictureService.mergeBeanTo(floors, FloorAdvertisePricture::getAdvertiseId);
        goodsService.mergeBeanTo(allfFloorGoods, FloorGoods::getGoodsId);
        FloorNames floorNames = new FloorNames();
        homeWrap.setFloorName(floorNames);

        if (floors.size() > 0) {
            FloorAdvertisePricture floor = floors.get(0);
            homeWrap.setFloor1(floor.getFloorGoodss());
            homeWrap.setFloor1Pic(floor);
            floorNames.setFloor1(floor.getFloorName());
        }
        if (floors.size() > 1) {
            FloorAdvertisePricture floor = floors.get(1);
            homeWrap.setFloor2(floor.getFloorGoodss());
            homeWrap.setFloor2Pic(floor);
            floorNames.setFloor2(floor.getFloorName());
        }
        if (floors.size() > 2) {
            FloorAdvertisePricture floor = floors.get(2);
            homeWrap.setFloor3(floor.getFloorGoodss());
            homeWrap.setFloor3Pic(floor);
            floorNames.setFloor3(floor.getFloorName());
        }

        Category category = new Category();
        category.setCreateTimeMax(createTimeMax);
        PageList<Category> categoryPageList = this.categoryService.getPageList(category, 100, 1);
        categorySubService.assignBeansTo(categoryPageList.getItems(), Category::getMallCategoryId, Category::setBxMallSubDto,
            CategorySub::setMallCategoryIds, CategorySub::getMallCategoryId);
        homeWrap.setCategory(categoryPageList.getItems());

        String result = JSONObject.toJSONString(homeWrap, SerializerFeature.DisableCircularReferenceDetect);
        System.out.println("result<===========>:\n" + result);
        return homeWrap;
    }

    @ApiRequestMappingAutoWithMethodName
    @State()
    public PageList<Goods> homePageBelowConten(@RequestParam(required=false,defaultValue = "10") Integer pageSize, @RequestParam(required=false,defaultValue = "1") Integer pageNum) {
        Goods goods = new Goods();
        goods.setCreateTimeMax(new Date());
        PageList<Goods> pageList = this.goodsService.getPageList(goods, pageSize, pageNum);
        return pageList;
    }

}
