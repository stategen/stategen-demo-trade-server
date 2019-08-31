package com.mycompany.biz.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HomeWrap {
    private List<Slide> slides;
    private HomeShop shopInfo;
    private List<HomeGoods> recommend;
    private HomeAdvertise advertesPicture;
    
    private List<FloorGoods> floor1;
    private List<FloorGoods> floor2;
    private List<FloorGoods> floor3;
    
    private FloorAdvertisePricture floor1Pic;
    private FloorAdvertisePricture floor2Pic;
    private FloorAdvertisePricture floor3Pic;
    
    private FloorNames floorName;
    
    private List<Category> category;
    
    
}
