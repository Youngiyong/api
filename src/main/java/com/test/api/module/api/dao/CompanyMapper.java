package com.test.api.module.api.dao;
import com.test.api.module.api.bean.CompanyVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CompanyMapper {

    String getHolidayId();
    List<Map<String, Object>> getTodayAllStatusCompany(String date);
    List<CompanyVO> getCompanyDetailInfo(int id);
    List<Map<String, Object>> getBusinessDetailList(Map<String, Object> data);
    void insertCompanyData(CompanyVO data);
    void insertBusinessTimesData(Map<String,Object> data);
    void insertHolidayData(Object data);

    void updateBusinessDay(Map<String, Object> data);

    void deleteCompanyData(int id);
    void deleteBusinessTimesData(int id);
    void deleteHolidayData(int id);
}
