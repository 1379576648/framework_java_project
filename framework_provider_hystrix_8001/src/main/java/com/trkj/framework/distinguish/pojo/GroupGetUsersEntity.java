package com.trkj.framework.distinguish.pojo;

/**
 * 获取用户列表实体类
 */
public class GroupGetUsersEntity {
    /*用户组编号需明确（由数字、字母、下划线组成）长度限制48B。*/
    private String group_id;
    /*默认值0，起始序号*/
    private Integer start = 0;
    /*返回数量，默认值100，最大值1000*/
    private Integer length = 100;

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

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
