package com.test.api.module.api.bean;


import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class CompanyVO {
    String companyId;
    String companyName;
    String companyOwner;
    String description;
    int companyLevel;
    String companyAddress;
    String companyPhone;
    List<Map<String, Object>> businessTimes;
}
