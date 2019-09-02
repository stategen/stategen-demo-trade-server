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
    
    private List<Floor> floors;
    
//    private List<FloorGoods> floor1;
//    private List<FloorGoods> floor2;
//    private List<FloorGoods> floor3;
//    
//    private Floor floor1Pic;
//    private Floor floor2Pic;
//    private Floor floor3Pic;
//    
//    private FloorNames floorName;
    
    private List<Category> category;
    
    
}
