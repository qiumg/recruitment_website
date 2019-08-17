package com.website.server.dao;

import com.website.server.pojo.JobInfo;
import com.website.server.pojo.justforeasy.JobInfo2;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface JobInfoMapper {
    //删除 by j_id
    int deleteByPrimaryKey(Integer jId);

    int insert(JobInfo record);

    //新增职位，by c_id
    int insertSelective(JobInfo record);

    JobInfo selectByPrimaryKey(Integer jId);

    //企业曾发布简历（即招募人数为零）
    @Results(id = "jobMap",value = {
            @Result(property="jId",column="j_id",jdbcType= JdbcType.INTEGER, id=true),
            @Result(property="jName",column="j_name",jdbcType= JdbcType.VARCHAR),
            @Result(property="jCharacter",column="j_character",jdbcType= JdbcType.VARCHAR),
            @Result(property="jk2Name",column="jk2_name",jdbcType= JdbcType.VARCHAR),
            @Result(property="jMlow",column="j_mlow",jdbcType= JdbcType.INTEGER),
            @Result(property="jMhigh",column="j_mhigh",jdbcType= JdbcType.INTEGER),
            @Result(property="jExperience",column="j_experience",jdbcType= JdbcType.VARCHAR),
            @Result(property="jDate",column="j_date",jdbcType= JdbcType.TIMESTAMP),
            @Result(property="jNum",column="j_num",jdbcType= JdbcType.INTEGER),
            @Result(property="jLoc",column="j_loc",jdbcType= JdbcType.VARCHAR),
            @Result(property="jReq",column="j_req",jdbcType= JdbcType.VARCHAR),
            @Result(property="jDes",column="j_des",jdbcType= JdbcType.VARCHAR),
            @Result(property="jBenefit",column="j_benefit",jdbcType= JdbcType.VARCHAR),
            @Result(property="cId",column="c_id",jdbcType= JdbcType.INTEGER),
            @Result(property="jkName",column="jk_name"),
            @Result(property="jk1Name",column="jk1_name"),
            @Result(property="jk2Name",column="jk2_name")
    })
    @Select("select j_id,j_name,j_character,jk2.jk2_name,jk1.jk1_name,jk.jk_name,\n" +
            "j_mlow,j_mhigh,j_experience,j_date,j_num,j_loc,\n" +
            "j_req,j_des,j_benefit \n" +
            "from job_info j,job_kind1_info jk1,job_kind2_info jk2 ,job_kind_info jk\n" +
            "where c_id = 1  and j.jk2_name=jk2.jk2_name  and jk2.jk1_id=jk1.jk1_id and jk1.jk_id=jk.jk_id and j_num = 0")
    List<JobInfo2> selectHisJobByCid(int c_id);

    //企业已发布职位信息

    @Select("select j_id,j_name,j_character,jk2.jk2_name,jk1.jk1_name,jk.jk_name,\n" +
            "j_mlow,j_mhigh,j_experience,j_date,j_num,j_loc,\n" +
            "j_req,j_des,j_benefit \n" +
            "from job_info j,job_kind1_info jk1,job_kind2_info jk2 ,job_kind_info jk\n" +
            "where c_id = ?  and j.jk2_name=jk2.jk2_name  and jk2.jk1_id=jk1.jk1_id and jk1.jk_id=jk.jk_id and j_num != 0")
    List<JobInfo2> selectAllJobByCid(int c_id);

    //企业按职位名称搜索职位信息(模糊)
    @Select("select j_id,j_name,j_character,jk2.jk2_name,jk1.jk1_name,jk.jk_name,\n" +
            "            j_mlow,j_mhigh,j_experience,j_date,j_num,j_loc,\n" +
            "            j_req,j_des,j_benefit \n" +
            "from job_info j,job_kind1_info jk1,job_kind2_info jk2 ,job_kind_info jk\n" +
            "where c_id = ?  and j.jk2_name=jk2.jk2_name  and jk2.jk1_id=jk1.jk1_id and jk1.jk_id=jk.jk_id \n" +
            "and j_name like '%' ? '%' \n" +
            "and j_num != 0;")
    List<JobInfo2> selectJobByJname(String j_name, int c_id);

    //企业按工作性质搜索职位信息
    @Select("select j_id,j_name,j_character,jk2.jk2_name,jk1.jk1_name,jk.jk_name,\n" +
            "            j_mlow,j_mhigh,j_experience,j_date,j_num,j_loc,\n" +
            "            j_req,j_des,j_benefit \n" +
            "from job_info j,job_kind1_info jk1,job_kind2_info jk2 ,job_kind_info jk\n" +
            "where c_id = ?  and j.jk2_name=jk2.jk2_name  and jk2.jk1_id=jk1.jk1_id and jk1.jk_id=jk.jk_id \n" +
            "and j_character =? \n" +
            "and j_num != 0;")
    List<JobInfo2> selectJobByJcharacter(String j_character,int c_id);

    //企业按职位类别2搜索职位信息
    @Select("select j_id,j_name,j_character,jk2.jk2_name,jk1.jk1_name,jk.jk_name,\n" +
            "            j_mlow,j_mhigh,j_experience,j_date,j_num,j_loc,\n" +
            "            j_req,j_des,j_benefit \n" +
            "from job_info j,job_kind1_info jk1,job_kind2_info jk2 ,job_kind_info jk\n" +
            "where c_id = ?  and j.jk2_name=jk2.jk2_name  and jk2.jk1_id=jk1.jk1_id and jk1.jk_id=jk.jk_id \n" +
            "and j.jk2_name=?\n" +
            "and j_num != 0;")
    List<JobInfo2> selectJobByJk2name(String jk2_name,int c_id);

    //企业按职位类别1搜索职位信息
    @Select("select j_id,j_name,j_character,jk2.jk2_name,jk1.jk1_name,jk.jk_name,\n" +
            "            j_mlow,j_mhigh,j_experience,j_date,j_num,j_loc,\n" +
            "            j_req,j_des,j_benefit \n" +
            "from job_info j,job_kind1_info jk1,job_kind2_info jk2 ,job_kind_info jk\n" +
            "where c_id = ?  and j.jk2_name=jk2.jk2_name  and jk2.jk1_id=jk1.jk1_id and jk1.jk_id=jk.jk_id \n" +
            "and jk1.jk1_name=? \n" +
            "and j_num != 0;")
    List<JobInfo2> selectJobByJk1name(String jk1_name,int c_id);

    //企业按职位类别搜索职位信息
    @Select("select j_id,j_name,j_character,jk2.jk2_name,jk1.jk1_name,jk.jk_name,\n" +
            "            j_mlow,j_mhigh,j_experience,j_date,j_num,j_loc,\n" +
            "            j_req,j_des,j_benefit \n" +
            "from job_info j,job_kind1_info jk1,job_kind2_info jk2 ,job_kind_info jk\n" +
            "where c_id = ?  and j.jk2_name=jk2.jk2_name  and jk2.jk1_id=jk1.jk1_id and jk1.jk_id=jk.jk_id \n" +
            "and jk.jk_name=?\n" +
            "and j_num != 0;")
    List<JobInfo2> selectJobByJkname(String jk_name,int c_id);


    //企业按职位名称搜索职位信息（曾发布职位查询）
    @Select("select j_id,j_name,j_character,jk2.jk2_name,jk1.jk1_name,jk.jk_name,\n" +
            "            j_mlow,j_mhigh,j_experience,j_date,j_num,j_loc,\n" +
            "            j_req,j_des,j_benefit \n" +
            "from job_info j,job_kind1_info jk1,job_kind2_info jk2 ,job_kind_info jk\n" +
            "where c_id = ?  and j.jk2_name=jk2.jk2_name  and jk2.jk1_id=jk1.jk1_id and jk1.jk_id=jk.jk_id \n" +
            "and j_name like '%' ? '%' \n" +
            "and j_num = 0;")
    List<JobInfo2> selectJobHisByJname(String j_name,int c_id);

    //企业按工作性质搜索职位信息（曾发布职位查询）
    @Select("select j_id,j_name,j_character,jk2.jk2_name,jk1.jk1_name,jk.jk_name,\n" +
            "            j_mlow,j_mhigh,j_experience,j_date,j_num,j_loc,\n" +
            "            j_req,j_des,j_benefit \n" +
            "from job_info j,job_kind1_info jk1,job_kind2_info jk2 ,job_kind_info jk\n" +
            "where c_id = ?  and j.jk2_name=jk2.jk2_name  and jk2.jk1_id=jk1.jk1_id and jk1.jk_id=jk.jk_id \n" +
            "and j_character =? \n" +
            "and j_num != 0;")
    List<JobInfo2> selectJobHisByJcharacter(String j_character,int c_id);

    //企业按职位类别2搜索职位信息（曾发布职位查询）
    @Select("select j_id,j_name,j_character,jk2.jk2_name,jk1.jk1_name,jk.jk_name,\n" +
            "            j_mlow,j_mhigh,j_experience,j_date,j_num,j_loc,\n" +
            "            j_req,j_des,j_benefit \n" +
            "from job_info j,job_kind1_info jk1,job_kind2_info jk2 ,job_kind_info jk\n" +
            "where c_id = ?  and j.jk2_name=jk2.jk2_name  and jk2.jk1_id=jk1.jk1_id and jk1.jk_id=jk.jk_id \n" +
            "and j.jk2_name=?\n" +
            "and j_num = 0;")
    List<JobInfo2> selectJobHisByJk2name(String jk2_name,int c_id);

    //企业按职位类别1搜索职位信息（曾发布职位查询）
    @Select("select j_id,j_name,j_character,jk2.jk2_name,jk1.jk1_name,jk.jk_name,\n" +
            "            j_mlow,j_mhigh,j_experience,j_date,j_num,j_loc,\n" +
            "            j_req,j_des,j_benefit \n" +
            "from job_info j,job_kind1_info jk1,job_kind2_info jk2 ,job_kind_info jk\n" +
            "where c_id = ?  and j.jk2_name=jk2.jk2_name  and jk2.jk1_id=jk1.jk1_id and jk1.jk_id=jk.jk_id \n" +
            "and jk1.jk1_name=? \n" +
            "and j_num = 0;")
    List<JobInfo2> selectJobHisByJk1name(String jk1_name,int c_id);

    //企业按职位类别搜索职位信息（曾发布职位查询）
    @Select("select j_id,j_name,j_character,jk2.jk2_name,jk1.jk1_name,jk.jk_name,\n" +
            "            j_mlow,j_mhigh,j_experience,j_date,j_num,j_loc,\n" +
            "            j_req,j_des,j_benefit \n" +
            "from job_info j,job_kind1_info jk1,job_kind2_info jk2 ,job_kind_info jk\n" +
            "where c_id = ?  and j.jk2_name=jk2.jk2_name  and jk2.jk1_id=jk1.jk1_id and jk1.jk_id=jk.jk_id \n" +
            "and jk.jk_name=?\n" +
            "and j_num = 0;")
    List<JobInfo2> selectJobHisByJkname(String jk_name,int c_id);


    //更改职位信息 by j_id
    int updateByPrimaryKeySelective(JobInfo record);



    int updateByPrimaryKey(JobInfo record);
}