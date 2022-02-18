package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.entity.mybatisplus.DeptPost;
import com.trkj.framework.entity.mybatisplus.Notice;
import com.trkj.framework.entity.mybatisplus.Staff;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 公告表 服务类
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-29
 */
public interface NoticeService  {
    /***
     * 分页查询所有公告数据
     * @param registerLog
     * @return
     */
    Object selectNoticeAll(Notice registerLog);

    /***
     * 多选删除
     * @param list
     * @return
     */
     String checkNoticeDelete(ArrayList<Integer> list) throws ArithmeticException;

    /***
     * 查询所有部门列表
     * @return
     */
     List<Dept> selectDeptList();


    /***
     * 添加公告
     * @param notice
     * @return
     */
     String  insertNotice(Notice notice) throws ArithmeticException;

    /***
     * 查询当前公告绑定的部门
     * @param integer
     * @return
     */
     List<Dept> selectPossessDeptList(Integer integer);

    /***
     * 修改公告
     * @param notice
     * @return
     */
     String updateNotice(Notice notice) throws ArithmeticException;


    /***
     * 已看公告人员
     * @param integer
     * @return
     */
     List<Staff> peropleNoticeViewed(Integer integer);

    /***
     * 未看公告人员
     * @param integer
     * @return
     */
     List<Staff> unseenNoticePerson(Integer integer);
}
