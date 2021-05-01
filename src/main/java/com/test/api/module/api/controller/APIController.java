package com.test.api.module.api.controller;

import com.test.api.module.api.bean.CompanyVO;
import com.test.api.module.api.service.CompanyService;
import com.test.api.util.DateDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class APIController {

    @Autowired
    @Qualifier("CompanyServiceImpl")
    CompanyService companyService;

    //점포 상세 정보 조회 API
    @ResponseBody
    @GetMapping("/getCompanyDetailInfoList/{id}")
    public List<CompanyVO> getCompanyDetailInfoList(@PathVariable  int id) throws Exception {
        return companyService.getCompanyDetailInfo(id);
    }


    //점포 조회 API
    @ResponseBody
    @GetMapping("/getTodayAllStatusCompanyAPI")
    public List<Map<String, Object>> getTodayAllStatusCompanyAPI() {
        return companyService.getTodayAllStatusCompany(new DateDay().getToday());
    }

    //점포 등록 API
    @PostMapping("/postStoreAddAPI")
    public CompanyVO postStoreAddAPI(@RequestBody CompanyVO companyVO){
        companyService.insertCompanyData(companyVO);
        return companyVO;
    }

    //휴무 등록 API
    @PostMapping("/postHolidayAddAPI")
    public void postStoreHolidayAddAPI(@RequestBody Object data) throws Exception {
        companyService.insertHolidayData(data);
    }

    //점포 삭제 API
    @DeleteMapping("/postStoreDeleteAPI/{id}")
    public void postStoreDeleteAPI(@PathVariable int id){
        companyService.deleteBusinessTimesData(id);
    }

}
