package seu.sun.babytun.Model;

import java.io.Serializable;
import java.util.Date;

public class GoodsEvaluate implements Serializable {
    private Long evaluateId;

    private String content;

    /**
    * 5
    */
    private Integer stars;

    private Date createTime;

    /**
    * 0
    */
    private Long goodsId;

    public Long getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(Long evaluateId) {
        this.evaluateId = evaluateId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
}