package com.geekaca.mall.geekmall.controller.vo;


public class PageVO {
    //当前第几页
    private Integer pageNumber;
    //每页显示条数
    private Integer pageRecord;
    //商品名称
    private String goodsName;
    //上架状态 0-上架 1-下架
    private Integer goodsSellStatus;
    //起始索引   limit的第一个参数
    private Integer startIndex;




    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsSellStatus() {
        return goodsSellStatus;
    }

    public void setGoodsSellStatus(Integer goodsSellStatus) {
        this.goodsSellStatus = goodsSellStatus;
    }




    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageRecord() {
        return pageRecord;
    }

    public void setPageRecord(Integer pageRecord) {
        this.pageRecord = pageRecord;
    }
}
