# 개발 환경 셋팅

### Intelij / SpringBoot 2.4.5 / Gradle / JDK 8 / API 테스트 (PostMan), API 문서 (Swagger2)

* build.gradle

dependencies {
implementation 'org.springframework.boot:spring-boot-starter-web'
implementation 'org.mybatis.spring.boot:mybatis-spring-boot-starter:2.1.4'
runtimeOnly 'com.h2database:h2'
compile 'org.springframework.boot:spring-boot-starter-jdbc'
compile group: 'io.springfox', name: 'springfox-swagger2', version: '2.9.2'
compile group: 'io.springfox', name: 'springfox-swagger-ui', version: '2.9.2'
compileOnly 'org.projectlombok:lombok'
annotationProcessor 'org.projectlombok:lombok' 
providedRuntime 'org.springframework.boot:spring-boot-starter-tomcat'
testImplementation 'org.springframework.boot:spring-boot-starter-test'
developmentOnly 'org.springframework.boot:spring-boot-devtools'
}

* application.yml

spring:
h2:
console:
enabled: true
datasource:
url: jdbc:h2:mem:testdb;
driverClassName: org.h2.Driver
username: sa
password:


* resources 폴더 밑에 schema.sql 생성

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

* API 가이드 (http://localhost:8080/swagger-ui.html#/)

### postStoreAddAPI(점포 추가 API)

{
"companyName": "해적수산",
"companyOwner": "박해적",
"description": "노량진 시장 광어, 참돔 등 싱싱한 고퀄 활어 전문 횟집",
"companyLevel": 1,
"companyAddress": "서울 동작구 노량진동 13-8 노량진수산시장 활어 001",
"companyPhone": "010-1234-1234",
"businessTimes": [
{
"businessDay": "Monday",
"businessOpenTime": "09:00",
"businessCloseTime": "24:00"
},
{
"businessDay": "Tuesday",
"businessOpenTime": "09:00",
"businessCloseTime": "24:00"
},
{
"businessDay": "Wednesday",
"businessOpenTime": "09:00",
"businessCloseTime": "24:00"
},
{
"businessDay": "Thursday",
"businessOpenTime": "09:00",
"businessCloseTime": "24:00"
},
{
"businessDay": "Friday",
"businessOpenTime": "09:00",
"businessCloseTime": "24:00"
},
{
"businessDay": "Saturday",
"businessOpenTime": "00:00",
"businessCloseTime": "00:01"
}
]
}



{
"companyName": "인어수산",
"companyOwner": "장인어",
"description": "인천소래포구 종합어시장 갑각류센터 인어수산",
"companyLevel": 2,
"companyAddress": "인천광역시 남동구 논현동 680-1 소래포구 종합어시장 1 층 1 호",
"companyPhone": "010-1111-2222",
"businessTimes": [
{
"businessDay": "Monday",
"businessOpenTime": "13:00",
"businessCloseTime": "23:00"
},
{
"businessDay": "Tuesday",
"businessOpenTime": "13:00",
"businessCloseTime": "23:00"
},
{
"businessDay": "Wednesday",
"businessOpenTime": "09:00",
"businessCloseTime": "18:00"
},
{
"businessDay": "Thursday",
"businessOpenTime": "09:00",
"businessCloseTime": "23:00"
},
{
"businessDay": "Friday",
"businessOpenTime": "09:00",
"businessCloseTime": "23:00"
},
{
"businessDay": "Saturday",
"businessOpenTime": "00:00",
"businessCloseTime": "00:01"
}

]
}

###postHolidayAddAPI(점포 휴무일 등록 API)

{
"companyId": 1,
"businessHolidays": [
"2021-04-30",
"2021-05-01"
]
}

###getTodayAllStatusCompanyAPI(점포 목록 조회 API)


###getCompanyDetailInfoList(점포 상세 정보 조회 API)


###postStoreDeleteAPI(점포 삭제 API)