package com.trkj.framework.distinguish.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.trkj.framework.distinguish.error.BaiduCloud;
import com.trkj.framework.distinguish.faces.FaceMethod;
import com.trkj.framework.distinguish.group.GroupMethod;
import com.trkj.framework.distinguish.pojo.*;
import com.trkj.framework.distinguish.user.UserMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 13795
 */
@Service
public class MethodService {
    /***
     *  操作人脸
     */
    @Autowired
    private FaceMethod faceMethod;
    /***
     * 操作用户组
     */
    @Autowired
    private GroupMethod groupMethod;
    /***
     * 操作用户
     */
    @Autowired
    private UserMethod userMethod;
    /***
     * 百度云api错误码
     */
    @Autowired
    private BaiduCloud baiduCloud;

    /**
     * 人脸注册
     */
    public String faceAdd(FaceAddEntity faceAddEntity) {
        FaceAddEntity faceAddEntity1 = new FaceAddEntity();
        /*图片地址*/
        faceAddEntity1.setImage(faceAddEntity.getImage());
        /*图片格式*/
        faceAddEntity1.setImage_type(faceAddEntity.getImage_type());
        /*用户组编号*/
        faceAddEntity1.setGroup_id(faceAddEntity.getGroup_id());
        /*用户编号*/
        faceAddEntity1.setUser_id(faceAddEntity.getUser_id());
        /*用户信息*/
        faceAddEntity1.setUser_info(faceAddEntity.getUser_info());
        /*图片质量控制*/
        faceAddEntity1.setQuality_control(faceAddEntity.getQuality_control());
        /*活体检测控制*/
        faceAddEntity1.setLiveness_control(faceAddEntity.getLiveness_control());
        /*操作方式*/
        faceAddEntity1.setAction_type(faceAddEntity.getAction_type());
        /*人脸检测排序类型*/
        faceAddEntity1.setFace_sort_type(faceAddEntity.getFace_sort_type());
        String s = faceMethod.faceAdd(faceAddEntity);
        JSONObject jsonObject = JSONObject.parseObject(s);
        if (baiduCloud.baiduCloud(jsonObject.getString("error_code")).equals("成功")) {
            System.out.println(jsonObject.getString("result"));
            String str = jsonObject.getString("result");
            JSONObject jsonObject1 = JSONObject.parseObject(str);
            String s1 = jsonObject1.getString("user_list");
            JSONArray jsonObject2 = new JSONArray(Collections.singletonList(s1));
            Object s2 = jsonObject2.getJSONObject(0).get("score");
            if (Double.parseDouble(String.valueOf(s2)) > 70) {
                return "登录成功";
            } else {
                return "登录失败";
            }
        } else {
            return baiduCloud.baiduCloud(jsonObject.getString("error_code"));
        }
    }

    /****
     * 人脸删除
     */
    public void faceDelete() {
        FaceDeleteEntity faceDeleteEntity = new FaceDeleteEntity();
        faceDeleteEntity.setUser_id("2");
        faceDeleteEntity.setGroup_id("user");
        faceDeleteEntity.setFace_token("4c1b057241b1221f7659436979b005d3");
        String s = faceMethod.faceDelete(faceDeleteEntity);
        System.out.println(s);
    }

    /**
     * 获取用户人脸列表
     */
    public void faceGetList() {
        FaceGetListEntity faceGetListEntity = new FaceGetListEntity();
        /*用户编号*/
        faceGetListEntity.setUser_id("2");
        /*用户组编号*/
        faceGetListEntity.setGroup_id("user");
        String s = faceMethod.faceGetList(faceGetListEntity);
        JSONObject jsonObject = JSONObject.parseObject(s);
        if (baiduCloud.baiduCloud(jsonObject.getString("error_code")).equals("成功")) {
            String str = jsonObject.getString("result");
            JSONObject jsonObject1 = JSONObject.parseObject(str);
            String s1 = jsonObject1.getString("face_list");
            JSONArray jsonObject2 = new JSONArray(Collections.singletonList(s1));
//            /*遍历输出用户组*/
//            for (int i = 0; i <jsonObject2.length() ; i++) {
//                Object s2 = jsonObject2.get(i);
//                JSONObject jsonObject3 =JSONObject.parseObject(s2+"");
//                Object ctime = jsonObject3.getString("ctime");
//                Object face_token = jsonObject3.getString("face_token");
//                System.out.println(ctime);
//                System.out.println(face_token);
//            }
        } else {
            System.out.println(baiduCloud.baiduCloud(jsonObject.getString("error_code")));
        }

    }

    /**
     * 人脸搜索
     */
    public Map<String,Object> faceSelect(String base64) throws Exception {
        Map<String,Object> map =new HashMap<>();
        FaceSelectEntity faceSelectEntity = new FaceSelectEntity();
        faceSelectEntity.setImage(base64);
        faceSelectEntity.setImage_type("BASE64");
        faceSelectEntity.setGroup_id_list("user");
        String s = faceMethod.faceSelect(faceSelectEntity);
        JSONObject jsonObject = JSONObject.parseObject(s);
        if (baiduCloud.baiduCloud(jsonObject.getString("error_code")).equals("成功")) {
            String str = jsonObject.getString("result");
            JSONObject jsonObject1 = JSONObject.parseObject(str);
            String s1 = jsonObject1.getString("user_list");
            List<Object> list = JSON.parseArray(s1, Object.class);
            JSONObject jsonObject2 = new JSONObject((Map<String, Object>) list.get(0));
            if (Double.parseDouble(String.valueOf(jsonObject2.get("score"))) > 80) {
                String id = (String) jsonObject2.get("user_id");
                map.put("成功",id);
                return map;
            } else {
                map.put("失败","查无此信息");
                return map;
            }
        } else {
            map.put("失败",baiduCloud.baiduCloud(jsonObject.getString("error_code")));
            return map;
        }
    }

    /**
     * 人脸检测与属性分析
     */
    public void faceTesting() {
        FaceTestingEntity faceTestingEntity = new FaceTestingEntity();
        /*图片信息*/
        faceTestingEntity.setImage("src/image/1c2556b625a499c365e80cd72d9054f3.jpeg");
        /*图片类型*/
        faceTestingEntity.setImage_type("BASE64");
        faceTestingEntity.setFace_field("face_token");
        /*最多处理人脸的数目*/
        faceTestingEntity.setMax_face_num(1);
        /*人脸的类型*/
        faceTestingEntity.setFace_type("LIVE");
        /*活体控制 */
        faceTestingEntity.setLiveness_control("NONE");
        /*人脸检测排序类型*/
        faceTestingEntity.setFace_sort_type(0);
        String s = faceMethod.faceTesting(faceTestingEntity);
        JSONObject jsonObject = JSONObject.parseObject(s);
        if (baiduCloud.baiduCloud(jsonObject.getString("error_code")).equals("成功")) {
            System.out.println("成功");
        } else {
            System.out.println(baiduCloud.baiduCloud(jsonObject.getString("error_code")));
        }
    }

    /**
     * 人脸更新
     */
    public void faceUpdate() {
        FaceUpdateEntity faceUpdateEntity = new FaceUpdateEntity();
        /*图片信息(总数据大小应小于10M)，图片上传方式根据image_type来判断*/
        faceUpdateEntity.setImage("src/image/1c2556b625a499c365e80cd72d9054f3.jpeg");
        /*图片类型*/
        faceUpdateEntity.setImage_type("BASE64");
        /*用户组编号*/
        faceUpdateEntity.setGroup_id("user");
        /*用户编号*/
        faceUpdateEntity.setUser_id("1");
        /* 用户资料*/
        faceUpdateEntity.setUser_info("1");
        /*图片质量控制*/
        faceUpdateEntity.setQuality_control("NONE");
        /*操作方式*/
        faceUpdateEntity.setAction_type("UPDATE");
        /*活体检测控制*/
        faceUpdateEntity.setLiveness_control("NONE");
        String s = faceMethod.faceUpdate(faceUpdateEntity);
        JSONObject jsonObject = JSONObject.parseObject(s);
        if (baiduCloud.baiduCloud(jsonObject.getString("error_code")).equals("成功")) {
            System.out.println("成功");
        } else {
            System.out.println(baiduCloud.baiduCloud(jsonObject.getString("error_code")));
        }

    }

    /**
     * 创建用户组
     */
    public void groupAdd() {
        GroupAddEntity groupAddEntity = new GroupAddEntity();
        /*用户组编号*/
        groupAddEntity.setGroup_id("12");
        String s = groupMethod.groupAdd(groupAddEntity);
        JSONObject jsonObject = JSONObject.parseObject(s);
        if (baiduCloud.baiduCloud(jsonObject.getString("error_code")).equals("成功")) {
            System.out.println("成功");
        } else {
            System.out.println(baiduCloud.baiduCloud(jsonObject.getString("error_code")));
        }
    }

    /**
     * 删除用户组
     */
    public void groupDelete() {
        GroupDeleteEntity groupDeleteEntity = new GroupDeleteEntity();
        /*用户组编号*/
        groupDeleteEntity.setGroup_id("12");
        String s = groupMethod.groupDelete(groupDeleteEntity);
        JSONObject jsonObject = JSONObject.parseObject(s);
        if (baiduCloud.baiduCloud(jsonObject.getString("error_code")).equals("成功")) {
            System.out.println("成功");
        } else {
            System.out.println(baiduCloud.baiduCloud(jsonObject.getString("error_code")));
        }


    }

    /**
     * 组列表查询
     */
    public void groupGetList() {
        GroupGetListEntity groupGetListEntity = new GroupGetListEntity();
        groupGetListEntity.setStart(0);
        groupGetListEntity.setLength(1000);
        String s = groupMethod.groupGetList(groupGetListEntity);
        JSONObject jsonObject = JSONObject.parseObject(s);
        String str = jsonObject.getString("result");
        JSONObject jsonObject1 = JSONObject.parseObject(str);
        String s1 = jsonObject1.getString("group_id_list");
        JSONArray jsonObject2 = new JSONArray(Collections.singletonList(s1));
        /*遍历输出用户组*/
//        for (int i = 0; i <jsonObject2.length() ; i++) {
//            Object s2 = jsonObject2.get(i);
//            System.out.println(s2);
//        }


    }

    /**
     * 获取用户列表
     */
    public void groupGetUsers(HttpServletRequest request, HttpServletResponse response) {
        GroupGetUsersEntity groupGetUsersEntity = new GroupGetUsersEntity();
        /*用户组编号*/
        groupGetUsersEntity.setGroup_id("user");
        /*默认值0，起始序号*/
        groupGetUsersEntity.setStart(0);
        /*返回数量，默认值100，最大值1000*/
        groupGetUsersEntity.setLength(1000);
        String s = groupMethod.groupGetUsers(groupGetUsersEntity);
        JSONObject jsonObject = JSONObject.parseObject(s);
        String str = jsonObject.getString("result");
        JSONObject jsonObject1 = JSONObject.parseObject(str);
        String s1 = jsonObject1.getString("user_id_list");
        JSONArray jsonObject2 = new JSONArray(Collections.singletonList(s1));
        /*遍历输出用户组里面的用户编号*/
//        for (int i = 0; i <jsonObject2.length() ; i++) {
//            Object s2 = jsonObject2.get(i);
//            System.out.println(s2);
//        }
    }

    /**
     * 用户信息查询
     */
    public void userGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserGetEntity userGetEntity = new UserGetEntity();
        /*用户组名称*/
        userGetEntity.setGroup_id("user");
        /*用户编号*/
        userGetEntity.setUser_id("1");
        String s = userMethod.userGet(userGetEntity);
        JSONObject jsonObject = JSONObject.parseObject(s);
        if (baiduCloud.baiduCloud(jsonObject.getString("error_code")).equals("成功")) {
            String str = jsonObject.getString("result");
            JSONObject jsonObject1 = JSONObject.parseObject(str);
            String s1 = jsonObject1.getString("user_list");
            JSONArray jsonObject2 = new JSONArray(Collections.singletonList(s1));
            /*用户信息*/
            Object s2 = jsonObject2.getJSONObject(0).get("user_info");
            response.getWriter().write(s2 + toString());
        } else {
            response.getWriter().write(baiduCloud.baiduCloud(jsonObject.getString("error_code")));
        }
    }
}
