package com.mycompany.biz.domain;

import java.util.List;

import com.mycompany.biz.domain.AdvertisePicture;
import com.mycompany.biz.domain.Goods;
import com.mycompany.biz.domain.GoodsComment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoodsWrap implements java.io.Serializable {
    /**  */
    private static final long serialVersionUID = -8799614831709281215L;
    private Goods goodInfo;
    private List<GoodsComment> goodComments;
    private AdvertisePicture advertesPicture;
}