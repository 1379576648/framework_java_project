package com.trkj.framework.distinguish.pojo;

/**
 * 删除用户组实体类
 */
public class GroupDeleteEntity {
    /*用户组编号需明确（由数字、字母、下划线组成）长度限制48B。*/
    private String group_id;

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }
}
