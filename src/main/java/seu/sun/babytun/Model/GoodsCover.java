package seu.sun.babytun.Model;

import java.io.Serializable;

public class GoodsCover implements Serializable {
    private Integer gcId;

    private Integer goodsId;

    private String gcPicUrl;

    private String gcThumbUrl;

    private Integer gcOrder;

    public Integer getGcId() {
        return gcId;
    }

    public void setGcId(Integer gcId) {
        this.gcId = gcId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGcPicUrl() {
        return gcPicUrl;
    }

    public void setGcPicUrl(String gcPicUrl) {
        this.gcPicUrl = gcPicUrl;
    }

    public String getGcThumbUrl() {
        return gcThumbUrl;
    }

    public void setGcThumbUrl(String gcThumbUrl) {
        this.gcThumbUrl = gcThumbUrl;
    }

    public Integer getGcOrder() {
        return gcOrder;
    }

    public void setGcOrder(Integer gcOrder) {
        this.gcOrder = gcOrder;
    }
}