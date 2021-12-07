package com.trkj.framework.distinguish.error;

import org.springframework.stereotype.Component;

/**
 * @author 周刘奇
 * 异常类
 */
@Component
public class BaiduCloud {
    public String baiduCloud(String name) {
        if (name.equals("0")) {
            return "成功";
        } else if (name.equals("4")) {
            return "集群超限额";
        } else if (name.equals("6")) {
            return "没有接口权限";
        } else if (name.equals("17")) {
            return "每天流量超限额";
        } else if (name.equals("18")) {
            return "QPS超限额";
        } else if (name.equals("19")) {
            return "请求总量超限额";
        } else if (name.equals("100")) {
            return "无效的access_token参数";
        } else if (name.equals("110")) {
            return "无效的access_token参数";
        } else if (name.equals("111")) {
            return "Access token过期";
        } else if (name.equals("222001")) {
            return "必要参数未传入";
        } else if (name.equals("222002")) {
            return "参数格式错误";
        } else if (name.equals("222003")) {
            return "参数格式错误";
        } else if (name.equals("222004")) {
            return "参数格式错误";
        } else if (name.equals("222005")) {
            return "参数格式错误";
        } else if (name.equals("222006")) {
            return "参数格式错误";
        } else if (name.equals("222007")) {
            return "参数格式错误";
        } else if (name.equals("222008")) {
            return "参数格式错误";
        } else if (name.equals("222009")) {
            return "参数格式错误";
        } else if (name.equals("222010")) {
            return "参数格式错误";
        } else if (name.equals("222011")) {
            return "参数格式错误";
        } else if (name.equals("222012")) {
            return "参数格式错误";
        } else if (name.equals("222013")) {
            return "参数格式错误";
        } else if (name.equals("222014")) {
            return "参数格式错误";
        } else if (name.equals("222015")) {
            return "参数格式错误";
        } else if (name.equals("222016")) {
            return "参数格式错误";
        } else if (name.equals("222017")) {
            return "参数格式错误";
        } else if (name.equals("222018")) {
            return "参数格式错误";
        } else if (name.equals("222019")) {
            return "参数格式错误";
        } else if (name.equals("222020")) {
            return "参数格式错误";
        } else if (name.equals("222021")) {
            return "参数格式错误";
        } else if (name.equals("222022")) {
            return "参数格式错误";
        } else if (name.equals("222023")) {
            return "参数格式错误";
        } else if (name.equals("222024")) {
            return "参数格式错误";
        } else if (name.equals("222025")) {
            return "参数格式错误";
        } else if (name.equals("222026")) {
            return "参数格式错误";
        } else if (name.equals("222027")) {
            return "验证码长度错误";
        } else if (name.equals("222028")) {
            return "参数格式错误";
        } else if (name.equals("222029")) {
            return "参数格式错误";
        } else if (name.equals("222030")) {
            return "参数格式错误";
        } else if (name.equals("222039")) {
            return "参数格式错误";
        } else if (name.equals("222200")) {
            return "该接口需使用application/json的格式进行请求";
        } else if (name.equals("222201")) {
            return "服务端请求失败";
        } else if (name.equals("222202")) {
            return "图片中没有人脸";
        } else if (name.equals("222203")) {
            return "无法解析人脸";
        } else if (name.equals("222204")) {
            return "从图片的url下载图片失败";
        } else if (name.equals("222205")) {
            return "服务端请求失败";
        } else if (name.equals("222206")) {
            return "服务端请求失败";
        } else if (name.equals("222207")) {
            return "未找到匹配的用户";
        } else if (name.equals("222208")) {
            return "图片的数量错误";
        } else if (name.equals("222209")) {
            return "face token不存在";
        } else if (name.equals("222210")) {
            return "人脸库中用户下的人脸数目超过限制";
        } else if (name.equals("222300")) {
            return "人脸图片添加失败";
        } else if (name.equals("222301")) {
            return "获取人脸图片失败";
        } else if (name.equals("222302")) {
            return "服务端请求失败";
        } else if (name.equals("222303")) {
            return "获取人脸图片失败";
        } else if (name.equals("222152")) {
            return "人脸属性编辑，target参数错误";
        } else if (name.equals("222514")) {
            return "人脸属性编辑v2调用服务失败，请重试";
        } else if (name.equals("223100")) {
            return "操作的用户组不存在";
        } else if (name.equals("223101")) {
            return "该用户组已存在";
        } else if (name.equals("223102")) {
            return "该用户已存在";
        } else if (name.equals("223103")) {
            return "找不到该用户";
        } else if (name.equals("223104")) {
            return "group_list包含组数量过多";
        } else if (name.equals("223105")) {
            return "该人脸已存在";
        } else if (name.equals("223106")) {
            return "该人脸不存在";
        } else if (name.equals("223110")) {
            return "uid_list包含数量过多";
        } else if (name.equals("223111")) {
            return "目标用户组不存在";
        } else if (name.equals("223112")) {
            return "quality_conf格式不正确";
        } else if (name.equals("223113")) {
            return "人脸有被遮挡";
        } else if (name.equals("223114")) {
            return "人脸模糊";
        } else if (name.equals("223115")) {
            return "人脸光照不好";
        } else if (name.equals("223116")) {
            return "人脸不完整";
        } else if (name.equals("223117")) {
            return "app_list包含app数量过多";
        } else if (name.equals("223118")) {
            return "质量控制项错误";
        } else if (name.equals("223119")) {
            return "活体控制项错误";
        } else if (name.equals("223120")) {
            return "活体检测未通过";
        } else if (name.equals("223121")) {
            return "左眼遮挡程度过高";
        } else if (name.equals("223122")) {
            return "右眼遮挡程度过高";
        } else if (name.equals("223123")) {
            return "左脸遮挡程度过高";
        } else if (name.equals("223124")) {
            return "右脸遮挡程度过高";
        } else if (name.equals("223125")) {
            return "下巴遮挡程度过高";
        } else if (name.equals("223126")) {
            return "鼻子遮挡程度过高";
        } else if (name.equals("223127")) {
            return "嘴巴遮挡程度过高";
        } else if (name.equals("222901")) {
            return "参数校验初始化失败";
        } else if (name.equals("222902")) {
            return "参数校验初始化失败";
        } else if (name.equals("222903")) {
            return "参数校验初始化失败";
        } else if (name.equals("222904")) {
            return "参数校验初始化失败";
        } else if (name.equals("222905")) {
            return "接口初始化失败";
        } else if (name.equals("222906")) {
            return "接口初始化失败";
        } else if (name.equals("222907")) {
            return "缓存处理失败";
        } else if (name.equals("222908")) {
            return "缓存处理失败";
        } else if (name.equals("222909")) {
            return "缓存处理失败";
        } else if (name.equals("222910")) {
            return "数据存储处理失败";
        } else if (name.equals("222911")) {
            return "数据存储处理失败";
        } else if (name.equals("222912")) {
            return "数据存储处理失败";
        } else if (name.equals("222913")) {
            return "接口初始化失败";
        } else if (name.equals("222914")) {
            return "接口初始化失败";
        } else if (name.equals("222915")) {
            return "后端服务连接失败";
        } else if (name.equals("222916")) {
            return "后端服务连接失败";
        } else if (name.equals("222304")) {
            return "图片尺寸太大";
        } else if (name.equals("222305")) {
            return "当前版本不支持图片存储";
        } else if (name.equals("223128")) {
            return "正在清理该用户组的数据";
        } else if (name.equals("223136")) {
            return "该组内存在关联图片，无法新建相同名称组";
        } else if (name.equals("222361")) {
            return "公安服务连接失败";
        } else if (name.equals("222046")) {
            return "参数格式错误";
        } else if (name.equals("222101")) {
            return "参数格式错误";
        } else if (name.equals("222102")) {
            return "参数格式错误";
        } else if (name.equals("222307")) {
            return "鉴黄未通过";
        } else if (name.equals("222308")) {
            return "含有政治敏感人物";
        } else if (name.equals("222211")) {
            return "模板图质量不合格";
        } else if (name.equals("222212")) {
            return "人脸融合失败";
        } else if (name.equals("223129")) {
            return "人脸未面向正前方";
        } else if (name.equals("223130")) {
            return "spoofing_control参数格式错误";
        } else if (name.equals("223131")) {
            return "合成图检测未通过";
        } else if (name.equals("222350")) {
            return "公安网图片不存在或质量过低";
        } else if (name.equals("222351")) {
            return "身份证号与姓名不匹配";
        } else if (name.equals("222352")) {
            return "身份证名字格式错误";
        } else if (name.equals("222353")) {
            return "身份证号码格式错误";
        } else if (name.equals("222354")) {
            return "公安库里不存在此身份证号";
        } else if (name.equals("222355")) {
            return "身份证号码正确，公安库里没有对应的照片";
        } else if (name.equals("222356")) {
            return "验证的人脸图片质量不符合要求";
        } else if (name.equals("222360")) {
            return "身份证号码或名字非法";
        } else if (name.equals("216600")) {
            return "输入身份证格式错误";
        } else if (name.equals("216601")) {
            return "身份证号和名字匹配失败";
        } else if (name.equals("216430")) {
            return "rtse/face 服务异常";
        } else if (name.equals("216431")) {
            return "语音识别服务异常";
        } else if (name.equals("216432")) {
            return "视频解析服务调用失败";
        } else if (name.equals("216433")) {
            return "视频解析服务发生错误";
        } else if (name.equals("216434")) {
            return "活体检测失败";
        } else if (name.equals("216500")) {
            return "验证码位数错误";
        } else if (name.equals("216501")) {
            return "没有找到人脸";
        } else if (name.equals("216502")) {
            return "当前会话已失效";
        } else if (name.equals("216505")) {
            return "redis连接失败";
        } else if (name.equals("216506")) {
            return "redis操作失败";
        } else if (name.equals("216507")) {
            return "视频中有多张人脸";
        } else if (name.equals("216508")) {
            return "没有找到视频信息";
        } else if (name.equals("216509")) {
            return "视频中的声音无法识别";
        } else if (name.equals("216510")) {
            return "动作活体模式验证时视频长度超过10s";
        } else if (name.equals("216511")) {
            return "语音文件不符合要求";
        } else if (name.equals("216512")) {
            return "使用动作活体验证时必须使用会话id";
        } else if (name.equals("216513")) {
            return "检测模型参数错误";
        } else if (name.equals("216612")) {
            return "系统繁忙";
        } else if (name.equals("216908")) {
            return "视频中人脸质量过低";
        } else if (name.equals("283421")) {
            return "应用不存在";
        } else if (name.equals("283435")) {
            return "方案不存在";
        } else if (name.equals("283436")) {
            return "Token生成失败，请重试";
        } else if (name.equals("283437")) {
            return "Token无效或已过期，请重新生成";
        } else if (name.equals("283451")) {
            return "认证处理中";
        } else if (name.equals("283455")) {
            return "超出查询有效期";
        }
        return null;
    }
}
