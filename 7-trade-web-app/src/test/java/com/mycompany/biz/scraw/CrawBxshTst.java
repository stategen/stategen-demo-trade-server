package com.mycompany.biz.scraw;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.stategen.framework.lite.PageList;
import org.stategen.framework.spring.util.HttpsTrustManager;
import org.stategen.framework.spring.util.HttpsUtil;
import org.stategen.framework.util.BaseService;
import org.stategen.framework.util.CollectionUtil;
import org.stategen.framework.util.CopyUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.mycompany.biz.domain.AdvertisePicture;
import com.mycompany.biz.domain.Category;
import com.mycompany.biz.domain.CategorySub;
import com.mycompany.biz.domain.FloorGoods;
import com.mycompany.biz.domain.Goods;
import com.mycompany.biz.domain.GoodsComment;
import com.mycompany.biz.domain.GoodsWrap;
import com.mycompany.biz.domain.HomeAdvertise;
import com.mycompany.biz.domain.HomeGoods;
import com.mycompany.biz.domain.HomeShop;
import com.mycompany.biz.domain.HomeWrap;
import com.mycompany.biz.domain.Response;
import com.mycompany.biz.domain.Slide;
import com.mycompany.biz.service.AdvertisePictureService;
import com.mycompany.biz.service.CategoryService;
import com.mycompany.biz.service.CategorySubService;
import com.mycompany.biz.service.FloorGoodsService;
import com.mycompany.biz.service.FloorService;
import com.mycompany.biz.service.GoodsCommentService;
import com.mycompany.biz.service.GoodsService;
import com.mycompany.biz.service.HomeAdvertiseService;
import com.mycompany.biz.service.HomeGoodsService;
import com.mycompany.biz.service.HomeShopService;
import com.mycompany.biz.service.ShopService;
import com.mycompany.biz.service.SlideService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml" })
public class CrawBxshTst {
    final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CrawBxshTst.class);

    static final String serviceUrl = "https://wxmini.baixingliangfan.cn/baixing/";

    static final String homePageContent = serviceUrl + "wxmini/homePageContent";//商店首页信息
    static final String homePageBelowConten = serviceUrl + "wxmini/homePageBelowConten";//首页火爆专区
    static final String getCategory = serviceUrl + "wxmini/getCategory"; //商品类别信息
    static final String getMallGoods = serviceUrl + "wxmini/getMallGoods"; //商品分类的商品列表
    static final String getGoodDetailById = serviceUrl + "wxmini/getGoodDetailById"; //商品详情页面"

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
    FloorService floorService;

    @Resource
    FloorGoodsService floorGoodsService;

    //1
    //    @Test
    public void doGetCategory() throws IOException, GeneralSecurityException, InterruptedException {
        String responseStrOfCategories = HttpsUtil.doPost(getCategory);
        Response<List<com.mycompany.biz.domain.Category>> responseCategroies = JSONObject.parseObject(responseStrOfCategories,
            new TypeReference<Response<List<Category>>>() {
            });
        List<com.mycompany.biz.domain.Category> categories = responseCategroies.getData();
        if (CollectionUtil.isNotEmpty(categories)) {
            for (Category category : categories) {
                String categoryId = category.getCategoryId();
                Category categoryByMallCategoryId = categoryService.getCategoryByCategoryId(categoryId);
                if (categoryByMallCategoryId != null) {
                    this.categoryService.update(category);
                } else {
                    categoryService.insert(category);
                }

                List<CategorySub> bxMallSubDto = category.getCategorySubs();
                if (CollectionUtil.isNotEmpty(bxMallSubDto)) {
                    for (CategorySub categorySub : bxMallSubDto) {
                        String categorySubId = categorySub.getCategorySubId();
                        CategorySub categorySubByMallSubId = this.categorySubService.getCategorySubByCategorySubId(categorySubId);
                        if (categorySubByMallSubId != null) {
                            this.categorySubService.update(categorySub);
                        } else {
                            this.categorySubService.insert(categorySub);
                        }
                        Map<String, Object> params = new HashMap<String, Object>();

                        params.put("categoryId", categoryId);
                        params.put("categorySubId", categorySubId);

                        boolean doGet = true;
                        int page = 1;
                        while (doGet) {
                            params.put("page", page);
                            page++;
                            doGet = crawGoodsAndSave(getMallGoods, params, categorySubId, null);
                            Thread.sleep(1000l);
                        }
                    }

                }

            }
        }

        if (logger.isInfoEnabled()) {
            logger.info("商品抓取成功");
        }
    }

    //2
    //    @Test
    public void crawHotGoods() throws IOException, GeneralSecurityException, InterruptedException {
        Map<String, Object> params = new HashMap<String, Object>();
        boolean doGet = true;
        int page = 1;
        while (doGet) {
            params.put("page", page);
            page++;
            doGet = crawGoodsAndSave(homePageBelowConten, params, null, true);
            Thread.sleep(1000l);
        }
    }

    //3
    //getGoodDetailById : {goodId: 11a401e776e44414bd886f27a1def492}
    //@Test
    public void crawGoodDetailById() throws IOException, GeneralSecurityException, InterruptedException {
        List<String> goodsIds = this.goodsService.getGoodsIds();
        Map<String, Object> params = new HashMap<String, Object>();
        if (CollectionUtil.isNotEmpty(goodsIds)) {
            for (String goodsId : goodsIds) {
                params.put("goodId", goodsId);
                String responseStrOfGoods = HttpsUtil.doPost(getGoodDetailById, params);

                //反射出了问题，只能这样拿
                Response<?> responseGoods = JSONObject.parseObject(responseStrOfGoods, Response.class);
                Object goodsWrapData = responseGoods.getData();
                GoodsWrap goodsWrap = JSONObject.toJavaObject((JSON) goodsWrapData, GoodsWrap.class);
                if (goodsWrap != null) {
                    //
                    AdvertisePicture advertesPicture = goodsWrap.getAdvertesPicture();
                    if (advertesPicture != null) {
                        saveOrUpdateByBaseSerive(this.advertisePictureService, advertesPicture);
                    }
                    Long advertiseId = advertesPicture != null ? advertesPicture.getAdvertiseId() : null;
                    //
                    Goods goods = goodsWrap.getGoodInfo();
                    if (goods != null) {
                        goods.setAdvertiseId(advertiseId);
                        updateOrInsertGoods(null, null, goods);
                    }

                    //
                    List<GoodsComment> goodComments = goodsWrap.getGoodComments();
                    if (CollectionUtil.isNotEmpty(goodComments)) {
                        for (GoodsComment goodsComment : goodComments) {
                            goodsComment.setGoodsId(goodsId);
                            saveOrUpdateByBaseSerive(goodsCommentService, goodsComment);
                        }
                    }
                }

                Thread.sleep(1000L);
            }
        }
    }

    // 4 homePageContent : {lon: 104.050699, lat: 30.690167}
    //@Test
    public void crawHomePageContent() throws IOException, GeneralSecurityException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("lon", "104.050699");
        params.put("lat", "30.690167");
        String responseStrOfHomeWrap = HttpsUtil.doPost(homePageContent, params);
        Response<HomeWrap> responseHomeWrap = JSONObject.parseObject(responseStrOfHomeWrap, new TypeReference<Response<HomeWrap>>() {
        });
        HomeWrap homeWrap = responseHomeWrap.getData();

        //
        List<Slide> slides = homeWrap.getSlides();
        if (CollectionUtil.isNotEmpty(slides)) {
            Integer orderNo = 0;
            for (Slide slide : slides) {
                slide.setOrderNo(orderNo);
                orderNo++;
                saveOrUpdateByBaseSerive(slideService, slide);
            }
        }

        //
        HomeShop shopInfo = homeWrap.getShopInfo();
        if (shopInfo != null) {
            //insert时获得了shopId
            saveOrUpdateByBaseSerive(shopService, shopInfo);
            saveOrUpdateByBaseSerive(homeShopService, shopInfo);
        }

        //
        List<HomeGoods> recommends = homeWrap.getRecommend();
        if (CollectionUtil.isNotEmpty(recommends)) {
            Integer orderNo = 0;
            for (HomeGoods homeGoods : recommends) {
                homeGoods.setOrderNo(orderNo);
                orderNo++;
                //insert后拿到了goodsId
                saveOrUpdateByBaseSerive(goodsService, homeGoods);
                saveOrUpdateByBaseSerive(homeGoodsService, homeGoods);
            }
        }

        //
        HomeAdvertise advertesPicture = homeWrap.getAdvertesPicture();
        if (advertesPicture != null) {
            //insert时拿到advertiseId
            saveOrUpdateByBaseSerive(this.advertisePictureService, advertesPicture);
            saveOrUpdateByBaseSerive(this.homeAdvertiseService, advertesPicture);
        }

//        //
//        List<FloorGoods> floorGoodss1 = homeWrap.getFloor1();
//        List<FloorGoods> floorGoodss2 = homeWrap.getFloor2();
//        List<FloorGoods> floorGoodss3 = homeWrap.getFloor3();
//
//        Floor floor1Pic = homeWrap.getFloor1Pic();
//        Floor floor2Pic = homeWrap.getFloor2Pic();
//        Floor floor3Pic = homeWrap.getFloor3Pic();
//
//        FloorNames floorNames = homeWrap.getFloorName();
//
//        String floorName1 = floorNames.getFloor1();
//        String floorName2 = floorNames.getFloor2();
//        String floorName3 = floorNames.getFloor3();
//
//        floor1Pic.setFloorName(floorName1);
//        floor1Pic.setFloorGoodss(floorGoodss1);
//
//        floor2Pic.setFloorName(floorName2);
//        floor2Pic.setFloorGoodss(floorGoodss2);
//
//        floor3Pic.setFloorName(floorName3);
//        floor3Pic.setFloorGoodss(floorGoodss3);
//
//        Floor[] floorAdvertisePrictures = { floor1Pic, floor2Pic, floor3Pic };
//        Integer picNo = 0;
//        for (Floor floor : floorAdvertisePrictures) {
//            floor.setOrderNo(picNo);
//            picNo++;
//            saveOrUpdateByBaseSerive(advertisePictureService, floor);
//            saveOrUpdateByBaseSerive(floorAdvertisePrictureService, floor);
//
//            String floorId = floor.getFloorId();
//            List<FloorGoods> floorGoodss = floor.getFloorGoodss();
//            Integer orderNo = 0;
//            for (FloorGoods floorGoods : floorGoodss) {
//                floorGoods.setFloorId(floorId);
//                floorGoods.setOrderNo(orderNo);
//                orderNo++;
//                saveOrUpdateByBaseSerive(floorGoodsService, floorGoods);
//            }
//        }
    }

    //这个image做丢了
    //@Test
    public void crawFloorImages() {
        String floorImageString = "{        \"floor1\": [\r\n" + "            {\r\n"
                                  + "                \"image\": \"https://images.baixingliangfan.cn/homeFloor/20190116/20190116133522_9332.jpg\",\r\n"
                                  + "                \"goodsId\": \"faa86c6ee451445a9475870656f04192\"\r\n" + "            },\r\n"
                                  + "            {\r\n"
                                  + "                \"image\": \"https://images.baixingliangfan.cn/homeFloor/20190116/20190116135616_4151.jpg\",\r\n"
                                  + "                \"goodsId\": \"80817b9fd00b48f296ce939ae197030b\"\r\n" + "            },\r\n"
                                  + "            {\r\n"
                                  + "                \"image\": \"https://images.baixingliangfan.cn/homeFloor/20190116/20190116133626_1248.jpg\",\r\n"
                                  + "                \"goodsId\": \"00cee04d12474910bfeb7930f6251c22\"\r\n" + "            },\r\n"
                                  + "            {\r\n"
                                  + "                \"image\": \"https://images.baixingliangfan.cn/homeFloor/20190116/20190116133740_8452.jpg\",\r\n"
                                  + "                \"goodsId\": \"bdfa9a9a358f436594a740e486fd2060\"\r\n" + "            },\r\n"
                                  + "            {\r\n"
                                  + "                \"image\": \"https://images.baixingliangfan.cn/homeFloor/20190116/20190116133753_7874.jpg\",\r\n"
                                  + "                \"goodsId\": \"516f9db6ee8e499cb8a8758cf2e567c7\"\r\n" + "            }\r\n" + "        ],\r\n"
                                  + "        \"floor2\": [\r\n" + "            {\r\n"
                                  + "                \"image\": \"https://images.baixingliangfan.cn/homeFloor/20190710/20190710170952_4452.jpg\",\r\n"
                                  + "                \"goodsId\": \"ec3c55fb0d4a4f68beb80dc6d1fbf7eb\"\r\n" + "            },\r\n"
                                  + "            {\r\n"
                                  + "                \"image\": \"https://images.baixingliangfan.cn/homeFloor/20190116/20190116134314_7748.jpg\",\r\n"
                                  + "                \"goodsId\": \"ca055522081f4315a654384ebb524051\"\r\n" + "            },\r\n"
                                  + "            {\r\n"
                                  + "                \"image\": \"https://images.baixingliangfan.cn/homeFloor/20190117/20190117151627_6993.jpg\",\r\n"
                                  + "                \"goodsId\": \"c0999c03df344e1ab322b3ce6dffdeb1\"\r\n" + "            },\r\n"
                                  + "            {\r\n"
                                  + "                \"image\": \"https://images.baixingliangfan.cn/homeFloor/20190116/20190116134424_3185.jpg\",\r\n"
                                  + "                \"goodsId\": \"3236991d77754e47a5cbf8e5d1a04902\"\r\n" + "            },\r\n"
                                  + "            {\r\n"
                                  + "                \"image\": \"https://images.baixingliangfan.cn/homeFloor/20190116/20190116134608_5991.jpg\",\r\n"
                                  + "                \"goodsId\": \"1140c709d608439d8fc85b650e0c477b\"\r\n" + "            }\r\n" + "        ],\r\n"
                                  + "        \"floor3\": [\r\n" + "            {\r\n"
                                  + "                \"image\": \"https://images.baixingliangfan.cn/homeFloor/20190122/20190122143838_7004.jpg\",\r\n"
                                  + "                \"goodsId\": \"ec3c55fb0d4a4f68beb80dc6d1fbf7eb\"\r\n" + "            },\r\n"
                                  + "            {\r\n"
                                  + "                \"image\": \"https://images.baixingliangfan.cn/homeFloor/20190116/20190116135202_4384.jpg\",\r\n"
                                  + "                \"goodsId\": \"81f919f9719e4e7498a3a53f5b294376\"\r\n" + "            },\r\n"
                                  + "            {\r\n"
                                  + "                \"image\": \"https://images.baixingliangfan.cn/homeFloor/20190122/20190122144023_7291.jpg\",\r\n"
                                  + "                \"goodsId\": \"138f0836ea664544b06f0ddba5331564\"\r\n" + "            },\r\n"
                                  + "            {\r\n"
                                  + "                \"image\": \"https://images.baixingliangfan.cn/homeFloor/20190116/20190116135302_3912.jpg\",\r\n"
                                  + "                \"goodsId\": \"b7e06b8248f049d2a50ed727d5988558\"\r\n" + "            },\r\n"
                                  + "            {\r\n"
                                  + "                \"image\": \"https://images.baixingliangfan.cn/homeFloor/20190116/20190116135334_5716.jpg\",\r\n"
                                  + "                \"goodsId\": \"80cd0b81997d41ceacdf3781a36dc13d\"\r\n" + "            }\r\n" + "        ],\r\n"
                                  + "        }";
        HomeWrap homeWrap = JSONObject.parseObject(floorImageString, HomeWrap.class);
//        List<FloorGoods> floor1 = homeWrap.getFloor1();
//        List<FloorGoods> floor2 = homeWrap.getFloor2();
//        List<FloorGoods> floor3 = homeWrap.getFloor3();
//        updateFloorImage(floor1);
//        updateFloorImage(floor2);
//        updateFloorImage(floor3);
    }

    private void updateFloorImage(List<FloorGoods> floorGoods) {
        Map<String, FloorGoods> group = CollectionUtil.toMap(floorGoods, FloorGoods::getGoodsId);
        FloorGoods query = new FloorGoods();
        query.setGoodsIds(new ArrayList<String>(group.keySet()));
        PageList<FloorGoods> pageList = this.floorGoodsService.getPageList(query, 100, 1);
        List<FloorGoods> items = pageList.getItems();
        for (FloorGoods floorGoods2 : items) {
            String goodsId = floorGoods2.getGoodsId();
            FloorGoods floorGoods3 = group.get(goodsId);
            if (floorGoods3 != null) {
                CopyUtil.merge(floorGoods2, floorGoods3);
                this.floorGoodsService.update(floorGoods2);
            }
        }

    }

    //
    //@Test
    @SuppressWarnings("unchecked")
    public void downloadAndUpdateImages() throws IOException, InterruptedException {
        Date createTimeMax = new Date();
        //
        FloorGoods floorGoods = new FloorGoods();
        floorGoods.setCreateTimeMax(createTimeMax);
        updatePicByBaseSerivice(null, this.floorGoodsService, floorGoods,
            new GetSetMethodWrap<FloorGoods, String>(FloorGoods::getImage, FloorGoods::setImage));

        Category category = new Category();
        category.setCreateTimeMax(createTimeMax);
        updatePicByBaseSerivice(null, this.categoryService, category, new GetSetMethodWrap<Category, String>(Category::getImage, Category::setImage));

        //
        Goods goods = new Goods();
        goods.setCreateTimeMax(createTimeMax);
        updatePicByBaseSerivice(new GetSetMethodWrap<Goods, String>(Goods::getGoodsDetail, Goods::setGoodsDetail), this.goodsService, goods,
            new GetSetMethodWrap<Goods, String>(Goods::getImage, Goods::setImage),
            new GetSetMethodWrap<Goods, String>(Goods::getImage1, Goods::setImage1));
        //
        AdvertisePicture advertisePicture = new AdvertisePicture();
        advertisePicture.setCreateTimeMax(createTimeMax);
        updatePicByBaseSerivice(null, this.advertisePictureService, advertisePicture,
            new GetSetMethodWrap<AdvertisePicture, String>(AdvertisePicture::getPictureAddress, AdvertisePicture::setPictureAddress));

        //
        Slide slide = new Slide();
        slide.setCreateTimeMax(createTimeMax);
        updatePicByBaseSerivice(null, this.slideService, slide, new GetSetMethodWrap<Slide, String>(Slide::getImage, Slide::setImage));
    }

        @Test
    public void uploadToQiniu() throws IOException, InterruptedException {
        QiniuUtil.batchUpload("D:/uploads/bxsh", "bxsh");
    }

    private <T> void saveOrUpdateByBaseSerive(BaseService<T> baseService, T t) {
        PageList<T> pageList = baseService.getPageList(t, 10, 1);
        T first = CollectionUtil.getFirst(pageList.getItems());
        if (first != null) {
            CopyUtil.merge(first, t);
            baseService.update(first);
            CopyUtil.merge(t, first);
        } else {
            baseService.insert(t);
        }
    }

    private boolean crawGoodsAndSave(String url, Map<String, Object> params, String categorySubId,
                                     Boolean isHot) throws IOException, GeneralSecurityException {
        String goodsStr = HttpsUtil.doPost(url, params);

        Response<List<Goods>> parseObject = JSONObject.parseObject(goodsStr, new TypeReference<Response<List<Goods>>>() {
        });
        List<Goods> goodss = parseObject.getData();
        if (CollectionUtil.isEmpty(goodss)) {
            return false;
        }

        for (Goods goods : goodss) {
            updateOrInsertGoods(categorySubId, isHot, goods);
        }

        return true;
    }

    private void updateOrInsertGoods(String categorySubId, Boolean isHot, Goods goods) {
        Goods goodByGoodsId = this.goodsService.getGoodByGoodsId(goods.getGoodsId());
        if (categorySubId != null) {
            goods.setCategorySubId(categorySubId);
        }
        if (isHot != null) {
            goods.setIsHot(isHot);
        }
        if (goodByGoodsId != null) {
            this.goodsService.update(goods);
        } else {
            this.goodsService.insert(goods);
        }
    }

    @SuppressWarnings("unchecked")
    private <T> void updatePicByBaseSerivice(GetSetMethodWrap<T, String> htmlMethods, BaseService<T> baseService, T query,
                                             GetSetMethodWrap<T, String>... getSetMethodWraps) throws IOException, InterruptedException {

        Integer pageNum = 0;
        List<T> newItems = new ArrayList<T>();
        final String newDomain = "http://bxsh.inputhelp.com";
        final String savePath = "/uploads/bxsh";
        while (true) {
            pageNum++;
            PageList<T> pageList = baseService.getPageList(query, 100, pageNum);
            List<T> items = pageList.getItems();
            if (CollectionUtil.isEmpty(items)) {
                break;
            }
            for (T item : items) {
                newItems.add(item);
                if (htmlMethods != null) {
                    Function<? super T, String> destGetMethod = htmlMethods.getDestGetMethod();
                    BiConsumer<T, String> destSetMethod = htmlMethods.getDestSetMethod();
                    String imageStr = destGetMethod.apply(item);
                    List<ImageUrlChangeHandler> imageUrlChangeHandlers = new ArrayList<ImageUrlChangeHandler>();

                    String newHtml = ParseHtmlAndReplaceImgUtil.replaceImgTag(imageStr, imageUrlChangeHandlers, savePath, newDomain);
                    for (ImageUrlChangeHandler imageUrlChangeHandler : imageUrlChangeHandlers) {
                        boolean downloaded = HttpsTrustManager.downLoadFromUrlHttp(imageUrlChangeHandler.getOldImageUrl(),
                            imageUrlChangeHandler.getFileName(), imageUrlChangeHandler.getPath());
                        if (downloaded) {
                            System.out.println(imageUrlChangeHandler.getOldImageUrl() + "<===========>:" + imageUrlChangeHandler.getNewUrl());
                            Thread.sleep(50L);
                        }
                    }
                    destSetMethod.accept(item, newHtml);

                }

                for (GetSetMethodWrap<T, String> getSetMethodWrap : getSetMethodWraps) {
                    Function<? super T, String> destGetMethod = getSetMethodWrap.getDestGetMethod();
                    BiConsumer<T, String> destSetMethod = getSetMethodWrap.getDestSetMethod();

                    String imageStr = destGetMethod.apply(item);
                    ImageUrlChangeHandler imageUrlChangeHandler = new ImageUrlChangeHandler();
                    if (imageUrlChangeHandler.handleImg(imageStr, savePath, newDomain)) {
                        boolean downloaded = HttpsTrustManager.downLoadFromUrlHttp(imageUrlChangeHandler.getOldImageUrl(),
                            imageUrlChangeHandler.getFileName(), imageUrlChangeHandler.getPath());
                        destSetMethod.accept(item, imageUrlChangeHandler.getNewUrl());
                        if (downloaded) {
                            System.out.println(imageUrlChangeHandler.getOldImageUrl() + "<===========>:" + imageUrlChangeHandler.getNewUrl());
                            Thread.sleep(50L);
                        }
                    }
                }
            }
        }

        if (CollectionUtil.isNotEmpty(newItems)) {
            for (T t : newItems) {
                baseService.update(t);
            }
        }
    }

}
