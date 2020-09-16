package seu.sun.babytun.Model;

import java.util.Date;

public class Order {
    private Integer orderId;

    /**
    * 订单业务编号
    */
    private String orderNo;

    /**
    * 0-已创建 1-已支付 3-已发货 4-已收货 5-已评价
    */
    private Integer orderStatus;

    /**
    * 用户id
    */
    private String userid;

    /**
    * 收件人
    */
    private String recvName;

    /**
    * 收件地址
    */
    private String recvAddress;

    /**
    * 联系电话
    */
    private String recvMobile;

    /**
    * 邮费
    */
    private Double postage;

    /**
    * 实付款
    */
    private Double amout;

    /**
    * 订单创建时间
    */
    private Date createTime;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getRecvName() {
        return recvName;
    }

    public void setRecvName(String recvName) {
        this.recvName = recvName;
    }

    public String getRecvAddress() {
        return recvAddress;
    }

    public void setRecvAddress(String recvAddress) {
        this.recvAddress = recvAddress;
    }

    public String getRecvMobile() {
        return recvMobile;
    }

    public void setRecvMobile(String recvMobile) {
        this.recvMobile = recvMobile;
    }

    public Double getPostage() {
        return postage;
    }

    public void setPostage(Double postage) {
        this.postage = postage;
    }

    public Double getAmout() {
        return amout;
    }

    public void setAmout(Double amout) {
        this.amout = amout;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}