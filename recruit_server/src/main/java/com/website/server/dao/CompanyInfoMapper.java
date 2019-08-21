package com.website.server.dao;

import com.website.server.pojo.CompanyInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CompanyInfoMapper {
    int deleteByPrimaryKey(Integer cId);

    int insert(CompanyInfo record);

    int insertSelective(CompanyInfo record);

    CompanyInfo selectByPrimaryKey(Integer cId);

    int updateByPrimaryKeySelective(CompanyInfo record);

    int updateByPrimaryKey(CompanyInfo record);
//    //根据状态查询
//     CompanyInfo selectByCstatic(String cStatic) throws Exception;
//    //查所有
//    List<CompanyInfo> selectAll() throws  Exception;
//    //根据id修改
//    void updateCompanyInfoById(Integer cId) throws Exception;
}