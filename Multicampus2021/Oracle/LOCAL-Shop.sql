select * from MEMBERTBL;




SELECT * FROM  PRODUCTTBL;

SELECT SYSDATE  FROM dual; -- ���糯¥ 
SELECT TO_DATE('20201231235959', 'YYYYMMDDHH24MISS') "��¥ ����" FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD HH:MM:SS') "���� ��¥" FROM DUAL;


CREATE TABLE TEST (idNum number(5));
Insert Into Test (Idnum) Values(1);
Insert Into Test (Idnum) Values('1'); 
Insert Into Test (Idnum) Values("1");  -- �ȵ�
Insert Into Test (Idnum) Values('10');
Insert Into Test (Idnum) Values('10a'); -- �ȵ� 
-- ' ' �� �ִ� ���� number�� �ν��ϰڴٴ°�. > ����! ���ڿ��� number�� �����ʴ°��� ����. 
Insert Into Test (Idnum) Values(20); 

Select * from test;

Drop Table Test; -- ���̺� ���� 

DROP TABLE USERTBL CASCADE CONSTRAINTS;
DROP TABLE BUYTBL CASCADE CONSTRAINTS;

create table USERTBL -- ȸ�� ���̺�
(userid char(8) ,
username NVARCHAR2(10) NOT NULL,
BIRTHYEAR NUMBER(4) DEFAULT -1 NOT NULL,
ADDR NCHAR(2) DEFAULT '����' NOT NULL,
MOBILE1 CHAR(3) NULL, -- �� �� ���
MOBILE2 CHAR(8) NULL, 
HEIGHT NUMBER(3) DEFAULT 170 NULL,
MDATE DATE NULL
);

ALTER TABLE USERTBL -- �����̸Ӹ�Ű�� ���߿� ���ϱ�  
ADD CONSTRAINT PK_USERTBL_USERID 
Primary Key (USERID); -- CONSTRAINT �̸� ���� 

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
ON DELETE CASCADE; -- �������̺� ID�� �������� �� ����� ���ų����� ���ش� 


Select * from USERTBL;
SELECT * FROM Buytbl;

CREATE SEQUENCE IDSEQ;

INSERT INTO USERTBL VALUES ('LSG', '�̽±�',  DEFAULT, DEFAULT, '011', '11111111', DEFAULT, '2008-8-8');
INSERT INTO USERTBL VALUES ('KBS', '�����', 1979, '�泲', '011', '22222222', 173, '2012-4-4');
INSERT INTO USERTBL VALUES ('KBS', '�����', 1979, '�泲', '011', NULL, 173, '2012-4-4'); -- NULL �� 
INSERT INTO USERTBL VALUES ('KKH', '���ȣ', 1971, '����', '019', '33333333', 177, '2007-7-7');
INSERT INTO USERTBL VALUES ('KKH', '���ȣ', 1971, '����', '019', '', 177, '2007-7-7'); -- NULL �� 
INSERT INTO USERTBL VALUES ('LJH', '������', 1997, '��õ', '019', ' ', 180, '2007-7-7'); -- ���鹮�� �� 
INSERT INTO USERTBL(USERID, USERNAME, BIRTHYEAR) VALUES ('HKD', 'ȫ�浿', 1980);
Select * from USERTBL; -- DEFAULT�� ���� ���� �������� NULL

INSERT INTO BUYTBL VALUES (IDSEQ.NEXTVAL, 'KBS', '�ȭ', NULL, 30, 2);
INSERT INTO BUYTBL VALUES (IDSEQ.NEXTVAL, 'KBS', '��Ʈ��', '����', 1000, 1);
INSERT INTO BUYTBL VALUES (IDSEQ.NEXTVAL, 'LSG', '�����', '����', 200, 1);
SELECT * FROM Buytbl;

select * from user_constraints where table_name='USERTBL' and constraint_type='P'; --������� Ȯ�� 
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

select * from user_constraints where table_name='PRODTBL' and constraint_type='P'; --������� Ȯ�� 


