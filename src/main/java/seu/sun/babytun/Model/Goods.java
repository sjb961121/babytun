package seu.sun.babytun.Model;

import java.io.Serializable;
import java.util.Date;

public class Goods implements Serializable {
    /**
    * 商品编号
    */
    private Integer goodsId;

    /**
    * 商品名称
    */
    private String title;

    /**
    * 子标题
    */
    private String subTitle;

    /**
    * 原价
    */
    private Float originalCost;

    /**
    * 折后价
    */
    private Float currentPrice;

    /**
    * 折扣(0~1)
    */
    private Float discount;

    /**
    * 是否包邮
    */
    private Integer isFreeDelivery;

    /**
    * 
    */
    private Integer categoryId;

    /**
    * 
    */
    private Date lastUpdateTime;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Float getOriginalCost() {
        return originalCost;
    }

    public void setOriginalCost(Float originalCost) {
        this.originalCost = originalCost;
    }

    public Float getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Float currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Integer getIsFreeDelivery() {
        return isFreeDelivery;
    }

    public void setIsFreeDelivery(Integer isFreeDelivery) {
        this.isFreeDelivery = isFreeDelivery;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}