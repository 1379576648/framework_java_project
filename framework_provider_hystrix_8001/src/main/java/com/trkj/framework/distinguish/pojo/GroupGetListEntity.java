package com.trkj.framework.distinguish.pojo;

/**
 * 组列表查询实体类
 */
public class GroupGetListEntity {
    /*默认值0，起始序号*/
    private Integer start = 0;
    /*返回数量，默认值100，最大值1000*/
    private Integer length = 100;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
