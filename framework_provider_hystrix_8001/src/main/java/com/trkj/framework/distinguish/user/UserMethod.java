package com.trkj.framework.distinguish.user;


import com.trkj.framework.distinguish.Util.GsonUtils;
import com.trkj.framework.distinguish.Util.HttpUtil;
import com.trkj.framework.distinguish.pojo.UserGetEntity;
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
public class UserMethod extends AuthService {
    /**
     * 用户信息查询
     */
    public String userGet(UserGetEntity userGetEntity) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/get";
        try {
            Map<String, Object> map = new HashMap<>();
            //用户组编号 如传入“@ALL”则从所有组中查询用户信息 长度限制48B
            map.put("group_id", userGetEntity.getGroup_id());
            //用户编号需明确 长度限制48B
            map.put("user_id", userGetEntity.getUser_id());
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