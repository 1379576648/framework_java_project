package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.*;
import com.trkj.framework.mybatisplus.mapper.*;
import com.trkj.framework.mybatisplus.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 公告表 服务实现类
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-29
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private DeptPostMapper deptPostMapper;

    @Autowired
    private NoticeDeptMapper noticeDeptMapper;

    @Autowired
    private StaffMapper staffMapper;

    @Autowired
    private NoticeStaffMapper noticeStaffMapper;

    /****
     * 分页查询所有公告数据
     * @param notice
     * @return
     */
    @Override
    public IPage<Notice> selectNoticeAll(Notice notice) {
        //创建分页
        Page<Notice> page = new Page<Notice>(notice.getCurrenPage(), notice.getPageSize());

        //条件构造器
        QueryWrapper<Notice> queryWrapper = new QueryWrapper<>();

        //判断公告标题是否为空
        if (notice.getNoticeTitle() != null && !notice.getNoticeTitle().equals("")) {
            //公告标题模糊查询
            queryWrapper.like("NOTICE_TITLE", notice.getNoticeTitle());
        }

        //判断发布人是否为空
        if (notice.getNoticePeople() != null && !notice.getNoticePeople().equals("")) {
            //发布人模糊查询
            queryWrapper.like("NOTICE_PEOPLE", notice.getNoticePeople());
        }

        //判断公告类型是否未空
        if (notice.getNoticeType() != null) {
            //类型模糊查询
            queryWrapper.like("NOTICE_TYPE", notice.getNoticeType());
        }

        //判断传入的时间是否为空
        if (notice.getStartTime() != null || notice.getEndTime() != null) {
            //登录时间范围查询
            queryWrapper.between("CREATED_TIME", notice.getStartTime(), notice.getEndTime());
        }

        //逻辑删除查询
        queryWrapper.eq("IS_DELETED", 0);

        //按照ID降序
        queryWrapper.orderByDesc("NOTICE_ID");
        return noticeMapper.selectNoticeAll(page, queryWrapper);
    }

    @Override
    @Transactional
    public String checkNoticeDelete(ArrayList<Integer> list) {
        String s = "成功";
        //循环传过来的集合
        for (int i = 0; i < list.size(); i++) {
            //通过id进行删除公告数据
            if (noticeMapper.deleteById(list.get(i)) >= 1) {
                s = "成功";
            } else {
                s = "失败";
            }
        }
        return s;
    }

    /***
     * 查询所有被启用的部门数据
     * @return
     */
    @Override
    public List<Dept> selectDeptList() {
        //条件构造器
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        //逻辑删除 未删除
        queryWrapper.eq("IS_DELETED", 0);
        //是否禁用 启用
        queryWrapper.eq("DEPT_STATE", 0);
        return deptMapper.selectList(queryWrapper);
    }

    /***
     * 添加公告
     * @param notice
     * @return
     */
    @Override
    @Transactional
    public String insertNotice(Notice notice) {
        String s = "成功";
        //通过id查询部门职位数据
        DeptPost deptPost = deptPostMapper.selectById(notice.getDeptPostId());
        //如果部门职位实体类不为空
        if (deptPost != null) {
            //讲部门职位实体类的职位名称赋值到公告实体类中
            notice.setNoticePost(deptPost.getPostName());
            //添加到公告表
            int row = noticeMapper.insert(notice);
            //如果添加公告成功
            if (row >= 1) {
                //迭代前台传过来的部门列表数据
                for (String name : notice.getDeptNameList()) {
                    //通过部门名称查询部门信息
                    Dept dept = deptMapper.selectOne(new QueryWrapper<Dept>().eq("DEPT_NAME", name));
                    //如果部门信息不为空
                    if (dept != null) {
                        //添加到公告部门表中
                        NoticeDept noticeDept = new NoticeDept();
                        noticeDept.setDeptId(Math.toIntExact(dept.getDeptId()));
                        noticeDept.setNoticeId(notice.getNoticeId());
                        //如果添加公告部门数据成功
                        if (noticeDeptMapper.insert(noticeDept) >= 0) {
                            //查询这个部门下的所有的员工
                            List<Staff> staffList = staffMapper.selectList(new QueryWrapper<Staff>().eq("DEPT_ID", dept.getDeptId()));
                            //如果该部门下有员工
                            if (staffList != null) {
                                for (Staff staff : staffList) {
                                    if (!notice.getStaffId().equals(staff.getStaffId())) {
                                        //初始化实体类
                                        NoticeStaff noticeStaff = new NoticeStaff();
                                        //公告编号
                                        noticeStaff.setNoticeId(Long.valueOf(notice.getNoticeId()));
                                        //员工编号
                                        noticeStaff.setStaffId(staff.getStaffId());
                                        //公告员工状态 未读
                                        noticeStaff.setNoticeState(0L);
                                        if (noticeStaffMapper.insert(noticeStaff) >= 1) {
                                            s = "成功";
                                        } else {
                                            s = "添加公告员工数据失败";
                                        }
                                    }
                                }
                            }
                        } else {
                            s = "添加公告部门数据失败";
                        }
                    } else {
                        return "查无[" + name + "]部门名称";
                    }
                }
            } else {
                return "添加公告失败";
            }
        } else {
            return "查无[" + notice.getDeptPostId() + "]部门职位编号";
        }
        return s;
    }

    /***
     * 查询当前公告绑定的部门
     * @param integer
     * @return
     */
    @Override
    public List<Dept> selectPossessDeptList(Integer integer) {
        QueryWrapper<NoticeDept> queryWrapper = new QueryWrapper<NoticeDept>();
        List<Dept> deptList = new ArrayList<>();
        //公告编号
        queryWrapper.eq("NOTICE_ID", integer);
        List<NoticeDept> deptPosts = noticeDeptMapper.selectList(queryWrapper);
        //如果公告部门表有绑定的部门
        if (deptPosts != null) {
            for (NoticeDept noticeDept : deptPosts) {
                Dept dept = deptMapper.selectById(noticeDept.getDeptId());
                deptList.add(dept);
            }
        }
        return deptList;
    }

    /***
     * 修改公告
     * @param notice
     * @return
     */
    @Override
    @Transactional
    public String updateNotice(Notice notice) {
        String s = "成功";
        //修改公告表
        int row = noticeMapper.updateById(notice);
        if (row >= 1) {
            QueryWrapper<NoticeDept> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("NOTICE_ID", notice.getNoticeId());
            //先删除公告部门表数据
            if (noticeDeptMapper.deleteNoticeDept(queryWrapper) >= 1) {
                //先删除公告员工表数据
                noticeStaffMapper.deleteNoticeStaff(queryWrapper);
                for (String name : notice.getDeptNameList()) {
                    Dept dept = deptMapper.selectOne(new QueryWrapper<Dept>().eq("DEPT_NAME", name));
                    if (dept != null) {
                        //添加公告部门表
                        NoticeDept noticeDept = new NoticeDept();
                        noticeDept.setDeptId(Math.toIntExact(dept.getDeptId()));
                        noticeDept.setNoticeId(notice.getNoticeId());
                        //如果公告部门数据添加成功
                        if (noticeDeptMapper.insert(noticeDept) >= 1) {
                            //查询这个部门下的所有的员工
                            List<Staff> staffList = staffMapper.selectList(new QueryWrapper<Staff>().eq("DEPT_ID", dept.getDeptId()));
                            //如果该部门下有员工
                            if (staffList != null) {
                                for (Staff staff : staffList) {
                                    if (!notice.getStaffId().equals(staff.getStaffId())) {
                                        NoticeStaff noticeStaff = new NoticeStaff();
                                        //公告编号
                                        noticeStaff.setNoticeId(Long.valueOf(notice.getNoticeId()));
                                        //员工编号
                                        noticeStaff.setStaffId(staff.getStaffId());
                                        //公告员工状态 未读
                                        noticeStaff.setNoticeState(0L);
                                        if (noticeStaffMapper.insert(noticeStaff) >= 1) {
                                            s = "成功";
                                        } else {
                                            s = "添加公告员工数据失败";
                                        }
                                    }
                                }
                            }
                        } else {
                            s = "添加公告部门数据失败";
                        }
                    } else {
                        return "查无[" + name + "]部门名称";
                    }
                }
            } else {
                return "删除公告部门数据失败";
            }
        } else {
            return "修改公告失败";
        }
        return s;
    }

    /***
     * 已看公告人员
     * @param integer
     * @return
     */
    @Override
    public List<Staff> peropleNoticeViewed(Integer integer) {
        //定义一个集合储藏数据
        List<Staff> staffList = new ArrayList<>();
        //通过公告编号查看公告员工表的数据
        List<NoticeStaff> noticeStaffList = noticeStaffMapper.selectList(new QueryWrapper<NoticeStaff>().eq("NOTICE_ID", integer).eq("NOTICE_STATE", 1));
        if (noticeStaffList != null) {
            for (NoticeStaff noticeStaff : noticeStaffList) {
                //通过员工编号查询数据
                Staff staff = staffMapper.selectById(noticeStaff.getStaffId());
                //如果查到员工数据
                if (staff != null) {
                    staffList.add(staff);
                }
            }
        }
        return staffList;
    }

    /***
     * 未看公告人员
     * @param integer
     * @return
     */
    @Override
    public List<Staff> unseenNoticePerson(Integer integer) {
        //定义一个集合储藏数据
        List<Staff> staffList = new ArrayList<>();
        //通过公告编号查看公告员工表的数据
        List<NoticeStaff> noticeStaffList = noticeStaffMapper.selectList(new QueryWrapper<NoticeStaff>().eq("NOTICE_ID", integer).eq("NOTICE_STATE", 0));
        if (noticeStaffList != null) {
            for (NoticeStaff noticeStaff : noticeStaffList) {
                //通过员工编号查询数据
                Staff staff = staffMapper.selectById(noticeStaff.getStaffId());
                //如果查到员工数据
                if (staff != null) {
                    staffList.add(staff);
                }
            }
        }
        return staffList;
    }
}