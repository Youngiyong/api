create table company (
    company_id INT NOT NULL AUTO_INCREMENT,
    company_name VARCHAR(100) NOT NULL,
    company_owner VARCHAR(50) NOT NULL,
    description VARCHAR(4000) NOT NULL,
    company_level INT NOT NULL,
    company_address VARCHAR(500) NOT NULL,
    company_phone VARCHAR(13) NOT NULL,
    primary key(company_id)
);


create table business_holiday(
    holiday_id INT NOT NULL AUTO_INCREMENT,
    holiday TIMESTAMP,
    company_id INT,
    FOREIGN KEY (company_id) REFERENCES COMPANY(company_id)
);

create table business_times(
    business_id INT NOT NULL AUTO_INCREMENT,
    business_day VARCHAR(30) NOT NULL,
    business_open_time VARCHAR(20) NOT NULL,
    business_close_time VARCHAR(20) NOT NULL,
    company_id INT,
    holiday_id INT,
    FOREIGN KEY (holiday_id) REFERENCES BUSINESS_HOLIDAY(holiday_id),
    FOREIGN KEY (company_id) REFERENCES COMPANY(company_id)
);


