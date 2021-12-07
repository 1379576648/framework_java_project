package com.trkj.framework.distinguish.pojo;

/**
 * 用户信息查询实体类
 */
public class UserGetEntity {
    /* //用户组编号 如传入“@ALL”则从所有组中查询用户信息 长度限制48B*/
    private String group_id;
    /*  //用户编号需明确 长度限制48B*/
    private String user_id;

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
