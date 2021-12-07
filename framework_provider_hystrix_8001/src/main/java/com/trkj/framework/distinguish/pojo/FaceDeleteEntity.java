package com.trkj.framework.distinguish.pojo;

/****
 * 人脸删除实体类
 */
public class FaceDeleteEntity {
    /*用户编号（由数字、字母、下划线组成），长度限制128B*/
    private String user_id;
    /*用户组编号（由数字、字母、下划线组成） 长度限制48B，删除指定group_id中的user_id信息*/
    private String group_id;
    /*需要删除的人脸图片token，（由数字、字母、下划线组成）长度限制64B*/
    private String face_token;
    /*请求标识码，随机数，唯一*/
    private String log_id;

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

    public String getFace_token() {
        return face_token;
    }

    public void setFace_token(String face_token) {
        this.face_token = face_token;
    }

    public String getLog_id() {
        return log_id;
    }

    public void setLog_id(String log_id) {
        this.log_id = log_id;
    }
}
