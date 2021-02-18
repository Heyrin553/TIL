select * from MEMBERTBL;




SELECT * FROM  PRODUCTTBL;

SELECT SYSDATE  FROM dual; -- 현재날짜 
SELECT TO_DATE('20201231235959', 'YYYYMMDDHH24MISS') "날짜 형식" FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD HH:MM:SS') "현재 날짜" FROM DUAL;


CREATE TABLE TEST (idNum number(5));
Insert Into Test (Idnum) Values(1);
Insert Into Test (Idnum) Values('1'); 
Insert Into Test (Idnum) Values("1");  -- 안됨
Insert Into Test (Idnum) Values('10');
Insert Into Test (Idnum) Values('10a'); -- 안됨 
-- ' ' 로 넣는 것은 number로 인식하겠다는것. > 나쁨! 문자열은 number에 넣지않는것이 맞음. 
Insert Into Test (Idnum) Values(20); 

Select * from test;

Drop Table Test; -- 테이블 삭제 

DROP TABLE USERTBL CASCADE CONSTRAINTS;
DROP TABLE BUYTBL CASCADE CONSTRAINTS;

create table USERTBL -- 회원 테이블
(userid char(8) ,
username NVARCHAR2(10) NOT NULL,
BIRTHYEAR NUMBER(4) DEFAULT -1 NOT NULL,
ADDR NCHAR(2) DEFAULT '서울' NOT NULL,
MOBILE1 CHAR(3) NULL, -- 빈 값 허용
MOBILE2 CHAR(8) NULL, 
HEIGHT NUMBER(3) DEFAULT 170 NULL,
MDATE DATE NULL
);

ALTER TABLE USERTBL -- 프라이머리키를 나중에 정하기  
ADD CONSTRAINT PK_USERTBL_USERID 
Primary Key (USERID); -- CONSTRAINT 이름 짓기 

Create Table BUYTBL(
    IDNUM NUMBER(8) Primary Key,
    USERID CHAR(8) NOT NULL,
    PRODNAME NCHAR(6) NOT NULL,
    GROUPNAME NCHAR(4) NULL,
    PRICE NUMBER(8) NULL,
    AMOUNT NUMBER(3) NOT NULL
   );     

alter table BUYTBL
add constraint FK_userTBL_buyTBL 
FOREIGN KEY (USERID) 
references USERTBL(USERID)
ON DELETE CASCADE; -- 유저테이블에 ID가 없어지면 그 사람의 구매내역도 없앤다 


Select * from USERTBL;
SELECT * FROM Buytbl;

CREATE SEQUENCE IDSEQ;

INSERT INTO USERTBL VALUES ('LSG', '이승기',  DEFAULT, DEFAULT, '011', '11111111', DEFAULT, '2008-8-8');
INSERT INTO USERTBL VALUES ('KBS', '김범수', 1979, '경남', '011', '22222222', 173, '2012-4-4');
INSERT INTO USERTBL VALUES ('KBS', '김범수', 1979, '경남', '011', NULL, 173, '2012-4-4'); -- NULL 들어감 
INSERT INTO USERTBL VALUES ('KKH', '김경호', 1971, '전남', '019', '33333333', 177, '2007-7-7');
INSERT INTO USERTBL VALUES ('KKH', '김경호', 1971, '전남', '019', '', 177, '2007-7-7'); -- NULL 들어감 
INSERT INTO USERTBL VALUES ('LJH', '이재현', 1997, '인천', '019', ' ', 180, '2007-7-7'); -- 공백문자 들어감 
INSERT INTO USERTBL(USERID, USERNAME, BIRTHYEAR) VALUES ('HKD', '홍길동', 1980);
Select * from USERTBL; -- DEFAULT를 주지 않은 나머지는 NULL

INSERT INTO BUYTBL VALUES (IDSEQ.NEXTVAL, 'KBS', '운동화', NULL, 30, 2);
INSERT INTO BUYTBL VALUES (IDSEQ.NEXTVAL, 'KBS', '노트북', '전자', 1000, 1);
INSERT INTO BUYTBL VALUES (IDSEQ.NEXTVAL, 'LSG', '모니터', '전자', 200, 1);
SELECT * FROM Buytbl;

select * from user_constraints where table_name='USERTBL' and constraint_type='P'; --제약사항 확인 
select * from user_constraints where table_name='BUYTBL' and constraint_type='P';

CREATE TABLE PRODTBL(
PRODCODE CHAR(3) NOT NULL,
PRODID CHAR(4) NOT NULL,
PRODDATE DATE NOT NULL,
PRODCUR CHAR(10) NULL
);

DROP TABLE PRODTBL CASCADE CONSTRAINTS;

ALTER TABLE PRODTBL
ADD CONSTRAINT PK_PRODTBL_PRODCODE_PRODID
Primary KEY (PRODCODE, PRODID);

select * from user_constraints where table_name='PRODTBL' and constraint_type='P'; --제약사항 확인 


