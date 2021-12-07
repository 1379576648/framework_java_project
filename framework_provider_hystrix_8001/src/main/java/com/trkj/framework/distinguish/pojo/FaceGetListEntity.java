package com.trkj.framework.distinguish.pojo;

/**
 * 获取用户人脸列表实体类
 */
public class FaceGetListEntity {
    /*用户编号（由数字、字母、下划线组成），长度限制48B*/
    private String user_id;
    /*用户组编号 (由数字、字母、下划线组成），长度限制48B*/
    private String group_id;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }
}
