package com.trkj.framework.distinguish.group;

import com.trkj.framework.distinguish.Util.GsonUtils;
import com.trkj.framework.distinguish.Util.HttpUtil;
import com.trkj.framework.distinguish.pojo.GroupAddEntity;
import com.trkj.framework.distinguish.pojo.GroupDeleteEntity;
import com.trkj.framework.distinguish.pojo.GroupGetListEntity;
import com.trkj.framework.distinguish.pojo.GroupGetUsersEntity;
import com.trkj.framework.distinguish.service.AuthService;
import org.springframework.stereotype.Component;

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
public class GroupMethod extends AuthService {
    /**
     * 创建用户组
     */
    public String groupAdd(GroupAddEntity groupAddEntity) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/group/add";
        try {
            Map<String, Object> map = new HashMap<>();
            /*用户组编号需明确（由数字、字母、下划线组成）长度限制48B。*/
            map.put("group_id", groupAddEntity.getGroup_id());
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
     * 删除用户组
     */
    public String groupDelete(GroupDeleteEntity groupDeleteEntity) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/group/delete";
        try {
            Map<String, Object> map = new HashMap<>();
            /*用户组编号需明确（由数字、字母、下划线组成）长度限制48B。*/
            map.put("group_id", groupDeleteEntity.getGroup_id());

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
     * 组列表查询
     */
    public String groupGetList(GroupGetListEntity groupGetListEntity) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/group/getlist";
        try {
            Map<String, Object> map = new HashMap<>();
            /*默认值0，起始序号*/
            map.put("start", groupGetListEntity.getStart());
            /*返回数量，默认值100，最大值1000*/
            map.put("length", groupGetListEntity.getLength());

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
     * 获取用户列表
     */
    public String groupGetUsers(GroupGetUsersEntity groupGetUsersEntity) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/group/getusers";
        try {
            Map<String, Object> map = new HashMap<>();
            /*用户组编号需明确（由数字、字母、下划线组成）长度限制48B。*/
            map.put("group_id", groupGetUsersEntity.getGroup_id());
            /*默认值0，起始序号*/
            map.put("start", groupGetUsersEntity.getStart());
            /*返回数量，默认值100，最大值1000*/
            map.put("length", groupGetUsersEntity.getLength());

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
