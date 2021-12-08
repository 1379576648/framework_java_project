package com.trkj.framework.distinguish.faces;

import com.trkj.framework.distinguish.Util.Base64Util;
import com.trkj.framework.distinguish.Util.GsonUtils;
import com.trkj.framework.distinguish.Util.HttpUtil;
import com.trkj.framework.distinguish.pojo.*;
import com.trkj.framework.distinguish.service.AuthService;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * 重要提示代码中所需工具类
 * FileUtil,Base64Util,HttpUtil,GsonUtils请从
 * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
 * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
 * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
 * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
 * 下载
 */
@Component
public class FaceMethod extends AuthService {
    /**
     * 人脸注册
     */
    public String faceAdd(FaceAddEntity faceAddEntity) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/add";
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(faceAddEntity.getImage()));
            String imagebase64 = Base64Util.encode(bytes);
            Map<String, Object> map = new HashMap<>();
            /*图片信息(总数据大小应小于10M)，图片上传方式根据image_type来判断。
            注：组内每个uid下的人脸图片数目上限为20张*/
            map.put("image", imagebase64);
            /*图片类型
            BASE64:图片的base64值，base64编码后的图片数据，编码后的图片大小不超过2M；
            URL:图片的 URL地址( 可能由于网络等原因导致下载图片时间过长)；
            FACE_TOKEN：人脸图片的唯一标识，调用人脸检测接口时，会为每个人脸图片赋予一个唯一的FACE_TOKEN，同一张图片多次检测得到的FACE_TOKEN是同一个。*/
            map.put("image_type", faceAddEntity.getImage_type());
            /*用户组id，标识一组用户（由数字、字母、下划线组成），长度限制48B。产品建议：根据您的业务需求，
            可以将需要注册的用户，按照业务划分，分配到不同的group下，例如按照会员手机尾号作为groupid，
            用于刷脸支付、会员计费消费等，这样可以尽可能控制每个group下的用户数与人脸数，提升检索的准确率*/
            map.put("group_id", faceAddEntity.getGroup_id());
            /*用户id（由数字、字母、下划线组成），长度限制128B*/
            map.put("user_id", faceAddEntity.getUser_id());
            /*用户资料，长度限制256B 默认空*/
            map.put("user_info", faceAddEntity.getUser_info());
            /*图片质量控制
            NONE: 不进行控制
            LOW:较低的质量要求
            NORMAL: 一般的质量要求
            HIGH: 较高的质量要求
            默认 NONE
            若图片质量不满足要求，则返回结果中会提示质量检测失败*/
            map.put("quality_control", faceAddEntity.getQuality_control());
            /*活体检测控制
            NONE: 不进行控制
            LOW:较低的活体要求(高通过率 低攻击拒绝率)
            NORMAL: 一般的活体要求(平衡的攻击拒绝率, 通过率)
            HIGH: 较高的活体要求(高攻击拒绝率 低通过率)
            默认NONE
            若活体检测结果不满足要求，则返回结果中会提示活体检测失败*/
            map.put("liveness_control", faceAddEntity.getLiveness_control());
            /*操作方式
            APPEND: 当user_id在库中已经存在时，对此user_id重复注册时，新注册的图片默认会追加到该user_id下
            REPLACE : 当对此user_id重复注册时,则会用新图替换库中该user_id下所有图片
            默认使用APPEND*/
            map.put("action_type", faceAddEntity.getAction_type());
            /*人脸检测排序类型
            0:代表检测出的人脸按照人脸面积从大到小排列
            1:代表检测出的人脸按照距离图片中心从近到远排列
            默认为0*/
            map.put("face_sort_type", faceAddEntity.getFace_sort_type());
            String param = GsonUtils.toJson(map);
            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = this.getAuth();
            String result = HttpUtil.post(url, accessToken, "application/json", param);
            Map resultmap = GsonUtils.fromJson(result, Map.class);
            System.out.println(resultmap);
        } catch (Exception e) {
            System.out.println("失败");
            e.printStackTrace();
        }
        return null;
    }

    /****
     * 人脸删除
     */
    public String faceDelete(FaceDeleteEntity faceDeleteEntity) {
        // 请求url
        String url = " https://aip.baidubce.com/rest/2.0/face/v3/faceset/face/delete";
        try {
            Map<String, Object> map = new HashMap<>();
            /*请求标识码，随机数，唯一*/
//            map.put("log_id","");
            /*用户编号（由数字、字母、下划线组成），长度限制128B*/
            map.put("user_id", faceDeleteEntity.getUser_id());
            /*用户组编号（由数字、字母、下划线组成） 长度限制48B，删除指定group_id中的user_id信息*/
            map.put("group_id", faceDeleteEntity.getGroup_id());
            /*需要删除的人脸图片token，（由数字、字母、下划线组成）长度限制64B*/
            map.put("face_token", faceDeleteEntity.getFace_token());

            String param = GsonUtils.toJson(map);
            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = this.getAuth();

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取用户人脸列表
     */
    public String faceGetList(FaceGetListEntity faceGetListEntity) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/face/getlist";
        try {
            Map<String, Object> map = new HashMap<>();
            /*用户编号（由数字、字母、下划线组成），长度限制48B*/
            map.put("user_id", faceGetListEntity.getUser_id());
            /*用户组编号 (由数字、字母、下划线组成），长度限制48B*/
            map.put("group_id", faceGetListEntity.getGroup_id());

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = this.getAuth();

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 人脸搜索
     */
    public String faceSelect(FaceSelectEntity faceSelectEntity) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/search";
        try {
//            byte[] bytes = Files.readAllBytes(Paths.get(""));
//            String imagebase64 = Base64Util.encode(bytes);
            Map<String, Object> map = new HashMap<>();
            /* 	图片信息(总数据大小应小于10M)，图片上传方式根据image_type来判断*/
            map.put("image", faceSelectEntity.getImage());
            /*活体检测控制
            NONE: 不进行控制
            LOW:较低的活体要求(高通过率 低攻击拒绝率)
            NORMAL:一般的活体要求(平衡的攻击拒绝率, 通过率)
            HIGH: 较高的活体要求(高攻击拒绝率 低通过率)
            默认NONE
            若活体检测结果不满足要求，则返回结果中会提示活体检测失败*/
            map.put("liveness_control", faceSelectEntity.getLiveness_control());
            /*从指定的group中进行查找 用逗号分隔，上限10个*/
            map.put("group_id_list", faceSelectEntity.getGroup_id_list());
            /*图片类型
            BASE64:图片的base64值，base64编码后的图片数据，编码后的图片大小不超过2M；
            URL:图片的 URL地址( 可能由于网络等原因导致下载图片时间过长)；
            FACE_TOKEN: 人脸图片的唯一标识，调用人脸检测接口时，会为每个人脸图片赋予一个唯一的FACE_TOKEN，同一张图片多次检测得到的FACE_TOKEN是同一个。*/
            map.put("image_type", faceSelectEntity.getImage_type());
            /*g 	图片质量控制
            NONE: 不进行控制
            LOW:较低的质量要求
            NORMAL: 一般的质量要求
            HIGH: 较高的质量要求
            默认 NONE
            若图片质量不满足要求，则返回结果中会提示质量检测失败*/
            map.put("quality_control", faceSelectEntity.getQuality_control());
            /*当需要对特定用户进行比对时，指定user_id进行比对。即人脸认证功能。*/
//            map.put("user_id","1");
            /*查找后返回的用户数量。返回相似度最高的几个用户，默认为1，最多返回50个。*/
            map.put("max_user_num", faceSelectEntity.getMax_user_num());
            /*人脸检测排序类型
            0:代表检测出的人脸按照人脸面积从大到小排列
            1:代表检测出的人脸按照距离图片中心从近到远排列
            默认为0*/
            map.put("face_sort_type", faceSelectEntity.getFace_sort_type());

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = this.getAuth();

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 人脸检测与属性分析
     */
    public String faceTesting(FaceTestingEntity faceTestingEntity) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/detect";
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(faceTestingEntity.getImage()));
            String imagebase64 = Base64Util.encode(bytes);
            Map<String, Object> map = new HashMap<>();
            /*图片信息(总数据大小应小于10M)，图片上传方式根据image_type来判断*/
            map.put("image", imagebase64);
            /*图片类型
            BASE64:图片的base64值，base64编码后的图片数据，编码后的图片大小不超过2M；
            URL:图片的 URL地址( 可能由于网络等原因导致下载图片时间过长)；
            FACE_TOKEN: 人脸图片的唯一标识，调用人脸检测接口时，会为每个人脸图片赋予一个唯一的FACE_TOKEN，同一张图片多次检测得到的FACE_TOKEN是同一个。*/
            map.put("image_type", faceTestingEntity.getImage_type());
            /*包括age,beauty,expression,face_shape,gender,glasses,landmark,landmark150,
            quality,eye_status,emotion,face_type,mask,spoofing信息
            逗号分隔. 默认只返回face_token、人脸框、概率和旋转角度*/
            map.put("face_field", faceTestingEntity.getFace_field());
            /*最多处理人脸的数目，默认值为1，根据人脸检测排序类型检测图片中排序第一的人脸（默认为人脸面积最大的人脸），最大值120*/
            map.put("max_face_num", faceTestingEntity.getMax_face_num());
            /*人脸的类型
            LIVE表示生活照：通常为手机、相机拍摄的人像图片、或从网络获取的人像图片等
            IDCARD表示身份证芯片照：二代身份证内置芯片中的人像照片
            WATERMARK表示带水印证件照：一般为带水印的小图，如公安网小图
            CERT表示证件照片：如拍摄的身份证、工卡、护照、学生证等证件图片
            默认LIVE*/
            map.put("face_type", faceTestingEntity.getFace_type());
            /*g 	活体控制 检测结果中不符合要求的人脸会被过滤
            NONE: 不进行控制
            LOW:较低的活体要求(高通过率 低攻击拒绝率)
            NORMAL: 一般的活体要求(平衡的攻击拒绝率, 通过率)
            HIGH: 较高的活体要求(高攻击拒绝率 低通过率)
            默认NONE*/
            map.put("liveness_control", faceTestingEntity.getLiveness_control());
            /*人脸检测排序类型
            0:代表检测出的人脸按照人脸面积从大到小排列
            1:代表检测出的人脸按照距离图片中心从近到远排列
            默认为0*/
            map.put("face_sort_type", faceTestingEntity.getFace_sort_type());
            String param = GsonUtils.toJson(map);
            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = this.getAuth();

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 人脸更新
     */
    public String faceUpdate(FaceUpdateEntity faceUpdateEntity) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/update";
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(faceUpdateEntity.getImage()));
            String imagebase64 = Base64Util.encode(bytes);
            Map<String, Object> map = new HashMap<>();
            /*图片信息(总数据大小应小于10M)，图片上传方式根据image_type来判断*/
            map.put("image", imagebase64);
            /*用户组编号，标识一组用户（由数字、字母、下划线组成），长度限制128B*/
            map.put("group_id", faceUpdateEntity.getGroup_id());
            /*用户编号（由数字、字母、下划线组成），长度限制48B*/
            map.put("user_id", faceUpdateEntity.getUser_id());
            /*用户资料，长度限制48B 默认空*/
            map.put("user_info", faceUpdateEntity.getUser_info());
            /*活体检测控制
            NONE: 不进行控制
            LOW:较低的活体要求(高通过率 低攻击拒绝率)
            NORMAL: 一般的活体要求(平衡的攻击拒绝率, 通过率)
            HIGH: 较高的活体要求(高攻击拒绝率 低通过率)
            默认NONE
            若活体检测结果不满足要求，则返回结果中会提示活体检测失败*/
            map.put("liveness_control", faceUpdateEntity.getLiveness_control());
            /*图片类型
             BASE64:图片的base64值，base64编码后的图片数据，编码后的图片大小不超过2M；
             URL:图片的 URL地址( 可能由于网络等原因导致下载图片时间过长)；
             FACE_TOKEN: 人脸图片的唯一标识*/
            map.put("image_type", faceUpdateEntity.getImage_type());
            /*图片质量控制
              NONE: 不进行控制
              LOW:较低的质量要求
              NORMAL: 一般的质量要求
              HIGH: 较高的质量要求
              默认 NONE
              若图片质量不满足要求，则返回结果中会提示质量检测失败*/
            map.put("quality_control", faceUpdateEntity.getQuality_control());
            /*操作方式
            UPDATE: 会使用新图替换库中该user_id下所有图片, 若user_id不存在则会报错
            REPLACE : 当user_id不存在时, 则会注册这个user_id的用户
            默认使用UPDATE*/
            map.put("action_type", faceUpdateEntity.getAction_type());

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = this.getAuth();

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
