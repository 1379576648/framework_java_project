package com.trkj.framework.distinguish.pojo;

/**
 * 人脸注册实体类
 */

public class FaceAddEntity {
    /*图片信息(总数据大小应小于10M)，图片上传方式根据image_type来判断。
    注：组内每个uid下的人脸图片数目上限为20张*/
    private String image;
    /*图片类型
    BASE64:图片的base64值，base64编码后的图片数据，编码后的图片大小不超过2M；
    URL:图片的 URL地址( 可能由于网络等原因导致下载图片时间过长)；
    FACE_TOKEN：人脸图片的唯一标识，调用人脸检测接口时，会为每个人脸图片赋予一个唯一的FACE_TOKEN，同一张图片多次检测得到的FACE_TOKEN是同一个。*/
    private String image_type = "BASE64";
    /*用户组id，标识一组用户（由数字、字母、下划线组成），长度限制48B。产品建议：根据您的业务需求，
    可以将需要注册的用户，按照业务划分，分配到不同的group下，例如按照会员手机尾号作为groupid，
    用于刷脸支付、会员计费消费等，这样可以尽可能控制每个group下的用户数与人脸数，提升检索的准确率*/
    private String group_id;
    /*用户id（由数字、字母、下划线组成），长度限制128B*/
    private String user_id;
    /*用户资料，长度限制256B 默认空*/
    private String user_info;
    /*图片质量控制
     NONE: 不进行控制
     LOW:较低的质量要求
     NORMAL: 一般的质量要求
     HIGH: 较高的质量要求
     默认 NONE
     若图片质量不满足要求，则返回结果中会提示质量检测失败*/
    private String quality_control = "NONE";
    /*活体检测控制
  NONE: 不进行控制
  LOW:较低的活体要求(高通过率 低攻击拒绝率)
  NORMAL: 一般的活体要求(平衡的攻击拒绝率, 通过率)
  HIGH: 较高的活体要求(高攻击拒绝率 低通过率)
  默认NONE
  若活体检测结果不满足要求，则返回结果中会提示活体检测失败*/
    private String liveness_control = "NONE";
    /*操作方式
  APPEND: 当user_id在库中已经存在时，对此user_id重复注册时，新注册的图片默认会追加到该user_id下
  REPLACE : 当对此user_id重复注册时,则会用新图替换库中该user_id下所有图片
  默认使用APPEND*/
    private String action_type = "APPEND";
    /*人脸检测排序类型
    0:代表检测出的人脸按照人脸面积从大到小排列
    1:代表检测出的人脸按照距离图片中心从近到远排列
    默认为0*/
    private Integer face_sort_type = 0;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage_type() {
        return image_type;
    }

    public void setImage_type(String image_type) {
        this.image_type = image_type;
    }

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

    public String getUser_info() {
        return user_info;
    }

    public void setUser_info(String user_info) {
        this.user_info = user_info;
    }

    public String getQuality_control() {
        return quality_control;
    }

    public void setQuality_control(String quality_control) {
        this.quality_control = quality_control;
    }

    public String getLiveness_control() {
        return liveness_control;
    }

    public void setLiveness_control(String liveness_control) {
        this.liveness_control = liveness_control;
    }

    public String getAction_type() {
        return action_type;
    }

    public void setAction_type(String action_type) {
        this.action_type = action_type;
    }

    public Integer getFace_sort_type() {
        return face_sort_type;
    }

    public void setFace_sort_type(Integer face_sort_type) {
        this.face_sort_type = face_sort_type;
    }
}
