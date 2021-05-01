package com.test.api.module.api.service;

import com.test.api.module.api.bean.CompanyVO;

import java.util.List;
import java.util.Map;

public interface CompanyService {

    String getHolidayId();
    List<Map<String, Object>> getTodayAllStatusCompany(String date);
    List<CompanyVO> getCompanyDetailInfo(int id) throws Exception;
    List<Map<String, Object>> getBusinessDetailList(Map<String, Object> data);

    void insertCompanyData(CompanyVO data);
    void insertBusinessTimesData(Map<String,Object> data);
    void insertHolidayData(Object data) throws Exception;

    void updateBusinessDay(Map<String, Object> data);

    void deleteCompanyData(int id);
    void deleteBusinessTimesData(int id);
    void deleteHolidayData(int id);

}
