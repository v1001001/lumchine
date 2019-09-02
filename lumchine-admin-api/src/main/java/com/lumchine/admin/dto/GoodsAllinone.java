package com.lumchine.admin.dto;

import com.lumchine.db.domain.LumchineGoods;
import com.lumchine.db.domain.LumchineGoodsAttribute;
import com.lumchine.db.domain.LumchineGoodsProduct;
import com.lumchine.db.domain.LumchineGoodsSpecification;

public class GoodsAllinone {
    LumchineGoods goods;
    LumchineGoodsSpecification[] specifications;
    LumchineGoodsAttribute[] attributes;
    LumchineGoodsProduct[] products;

    public LumchineGoods getGoods() {
        return goods;
    }

    public void setGoods(LumchineGoods goods) {
        this.goods = goods;
    }

    public LumchineGoodsProduct[] getProducts() {
        return products;
    }

    public void setProducts(LumchineGoodsProduct[] products) {
        this.products = products;
    }

    public LumchineGoodsSpecification[] getSpecifications() {
        return specifications;
    }

    public void setSpecifications(LumchineGoodsSpecification[] specifications) {
        this.specifications = specifications;
    }

    public LumchineGoodsAttribute[] getAttributes() {
        return attributes;
    }

    public void setAttributes(LumchineGoodsAttribute[] attributes) {
        this.attributes = attributes;
    }

}
