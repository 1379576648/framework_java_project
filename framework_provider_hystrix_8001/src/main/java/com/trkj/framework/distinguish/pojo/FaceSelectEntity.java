package com.trkj.framework.distinguish.pojo;

/**
 * 人脸搜索实体类
 */
public class FaceSelectEntity {
    /* 	图片信息(总数据大小应小于10M)，图片上传方式根据image_type来判断*/
    private String image;
    /*活体检测控制
          NONE: 不进行控制
          LOW:较低的活体要求(高通过率 低攻击拒绝率)
          NORMAL: 一般的活体要求(平衡的攻击拒绝率, 通过率)
          HIGH: 较高的活体要求(高攻击拒绝率 低通过率)
          默认NONE
          若活体检测结果不满足要求，则返回结果中会提示活体检测失败*/
    private String liveness_control = "LOW";
    /*从指定的group中进行查找 用逗号分隔，上限10个*/
    private String group_id_list;
    /*图片类型
           BASE64:图片的base64值，base64编码后的图片数据，编码后的图片大小不超过2M；
           URL:图片的 URL地址( 可能由于网络等原因导致下载图片时间过长)；
           FACE_TOKEN: 人脸图片的唯一标识，调用人脸检测接口时，会为每个人脸图片赋予一个唯一的FACE_TOKEN，同一张图片多次检测得到的FACE_TOKEN是同一个。*/
    private String image_type;
    /*g 	图片质量控制
         NONE: 不进行控制
         LOW:较低的质量要求
         NORMAL: 一般的质量要求
         HIGH: 较高的质量要求
         默认 NONE
         若图片质量不满足要求，则返回结果中会提示质量检测失败*/
    private String quality_control = "HIGH";
    /*当需要对特定用户进行比对时，指定user_id进行比对。即人脸认证功能。*/
    private String user_id;
    /*查找后返回的用户数量。返回相似度最高的几个用户，默认为1，最多返回50个。*/
    private Integer max_user_num = 1;
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

    public String getLiveness_control() {
        return liveness_control;
    }

    public void setLiveness_control(String liveness_control) {
        this.liveness_control = liveness_control;
    }

    public String getGroup_id_list() {
        return group_id_list;
    }

    public void setGroup_id_list(String group_id_list) {
        this.group_id_list = group_id_list;
    }

    public String getImage_type() {
        return image_type;
    }

    public void setImage_type(String image_type) {
        this.image_type = image_type;
    }

    public String getQuality_control() {
        return quality_control;
    }

    public void setQuality_control(String quality_control) {
        this.quality_control = quality_control;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Integer getMax_user_num() {
        return max_user_num;
    }

    public void setMax_user_num(Integer max_user_num) {
        this.max_user_num = max_user_num;
    }

    public Integer getFace_sort_type() {
        return face_sort_type;
    }

    public void setFace_sort_type(Integer face_sort_type) {
        this.face_sort_type = face_sort_type;
    }
}
