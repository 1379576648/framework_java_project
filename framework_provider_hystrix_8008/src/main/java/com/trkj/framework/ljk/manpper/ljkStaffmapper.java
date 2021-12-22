package com.trkj.framework.ljk.manpper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.framework.entity.StaffEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ljkStaffmapper extends BaseMapper<StaffEntity> {
    /**
     * 查看奖励的员工
     * */
    @Select("<script> "+
            "SELECT g.GLORY_ID,g.GLORY_NAME,d.DEPT_ID,d.DEPT_NAME,s.STAFF_ID,s.STAFF_SEX,\n" +
            " s.STAFF_NAME,s.STAFF_PHONE,s.POSITION_NAME FROM GLORY g,dept d,STAFF s WHERE\n" +
            " g.STAFF_ID=s.STAFF_ID and d.DEPT_ID=s.DEPT_ID" +
            "</script>")
    List<StaffEntity> findCreated();

    @Select("<script> "+
            "SELECT g.GLORY_ID,g.GLORY_NAME,d.DEPT_ID,d.DEPT_NAME,s.STAFF_ID,s.STAFF_SEX,\n" +
            " s.STAFF_NAME,s.STAFF_PHONE,s.DEPT_ID,s.POSITION_NAME FROM GLORY g,dept d,STAFF s WHERE\n" +
            " g.STAFF_ID=s.STAFF_ID and d.DEPT_ID=s.DEPT_ID and s.STAFF_ID = #{id} " +
            "</script>")
    List<StaffEntity> findCreatedById(Long id);

    @Select("<script> "+
            "SELECT g.GLORY_ID,g.GLORY_NAME,d.DEPT_ID,d.DEPT_NAME,s.STAFF_ID,s.STAFF_SEX,\n" +
            " s.STAFF_NAME,s.STAFF_PHONE,s.DEPT_ID,s.POSITION_NAME FROM GLORY g,dept d,STAFF s WHERE\n" +
            " g.STAFF_ID=s.STAFF_ID and d.DEPT_ID=s.DEPT_ID and s.STAFF_NAME like #{name} " +
            "</script>")
    List<StaffEntity> findCreatedLikeByName(String name);

    /**
     * 查看惩罚的员工
     */
    @Select("SELECT p.PUNISH_ID,p.PUNISH_CAUSE,d.DEPT_ID,d.DEPT_NAME,s.STAFF_ID,s.STAFF_SEX," +
            "s.STAFF_NAME,s.STAFF_PHONE,s.POSITION_NAME FROM PUNISH p," +
            "dept d,STAFF s WHERE p.STAFF_ID=s.STAFF_ID and d.DEPT_ID=s.DEPT_ID ")
    List<StaffEntity> findPunish();
    @Select("<script>" +
            " SELECT p.PUNISH_ID,p.PUNISH_CAUSE,d.DEPT_ID,d.DEPT_NAME,s.STAFF_ID,s.STAFF_SEX," +
            "s.STAFF_NAME,s.STAFF_PHONE,s.POSITION_NAME FROM PUNISH p,dept d,STAFF s " +
            "WHERE p.STAFF_ID=s.STAFF_ID and d.DEPT_ID=s.DEPT_ID and s.STAFF_ID = #{id}" +
            "</script>")
    List<StaffEntity> findPunishById(Long id);

}
