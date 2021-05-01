package com.test.api.module.api.service.Impl;

import com.test.api.module.api.bean.CompanyVO;
import com.test.api.module.api.dao.CompanyMapper;
import com.test.api.module.api.service.CompanyService;
import com.test.api.util.DateDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("CompanyServiceImpl")
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyMapper mapper;

    public String getHolidayId(){
        return mapper.getHolidayId();
    }

    public List<Map<String, Object>> getTodayAllStatusCompany(String date){
        return mapper.getTodayAllStatusCompany(date);
    }

    public List<CompanyVO> getCompanyDetailInfo(int id) throws Exception {
        List<CompanyVO> vo = mapper.getCompanyDetailInfo(id);
        Map<String, Object> dataMap = new HashMap<>();
        DateDay date = new DateDay();
        dataMap.put("companyId", vo.get(0).getCompanyId());
        dataMap.put("days", date.getThreeDay());
        for(CompanyVO v: vo){
            v.setBusinessTimes(getBusinessDetailList(dataMap));
        }
        return vo;
    }

    public List<Map<String, Object>> getBusinessDetailList(Map<String, Object> data){
        return mapper.getBusinessDetailList(data);
    }


    public void insertCompanyData(CompanyVO data){
        mapper.insertCompanyData(data);
        List<Map<String, Object>> temp = data.getBusinessTimes();
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("companyId", data.getCompanyId());
        for(Map<String, Object> m : temp){
            dataMap.put("businessDay", m.get("businessDay"));
            dataMap.put("businessOpenTime", m.get("businessOpenTime"));
            dataMap.put("businessCloseTime", m.get("businessCloseTime"));
            insertBusinessTimesData(dataMap);
        }

    }

    public void insertBusinessTimesData(Map<String, Object> data){
         mapper.insertBusinessTimesData(data);
    }

    public void insertHolidayData(Object data) throws Exception {
        Map<String, Object> temp = (HashMap)data;
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("companyId", temp.get("companyId"));
        List<String> dataList = (List<String>) temp.get("businessHolidays");
        DateDay date = new DateDay();
        for(String strDate: dataList){
            dataMap.put("businessDay",date.getDateDay(strDate));
            dataMap.put("holiday", strDate);
            mapper.insertHolidayData(dataMap);
            dataMap.put("holidayId", getHolidayId());
            updateBusinessDay(dataMap);
        }
    }
    public void updateBusinessDay(Map<String, Object> data){
        mapper.updateBusinessDay(data);
    }


    public void deleteCompanyData(int id){
        mapper.deleteCompanyData(id);
    }

    public void deleteBusinessTimesData(int id){
        mapper.deleteBusinessTimesData(id);
        deleteHolidayData(id);
        deleteCompanyData(id);
    }

    public void deleteHolidayData(int id){
        mapper.deleteHolidayData(id);

    }
}

