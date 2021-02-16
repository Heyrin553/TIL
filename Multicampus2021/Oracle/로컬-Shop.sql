select * from MEMBERTBL where MEMBERNAME = '지운이';

select * from MEMBERTBL;
insert into MEMBERTBL values ('Bong', '태봉이', '서울 서대문구 연희동'); -- 원래 컬럼명/순서를 알고 있으면 컬럼명 안 써도 됨 
insert into MEMBERTBL(MEMBERID, MEMBERNAME, MEMBERADDRESS) values ('Lee', '재현이', '서울 서대문구 연희동');
insert into MEMBERTBL( MEMBERNAME, MEMBERID, MEMBERADDRESS) values ('영훈이', 'Hoon', '인천 부평구 송도동');

select * from PRODUCTTBL;
-- UPDATE PRODUCTTBL SET AMOUNT = 100 -- 조건을 없애면 일괄적으로 변경 

UPDATE PRODUCTTBL SET AMOUNT = 50 WHERE PRODUCTNAME = '세탁기';
UPDATE PRODUCTTBL SET AMOUNT = 80 WHERE PRODUCTNAME = '컴퓨터';

-- DELETE from producttbl where productname = '컴퓨터';
update member 
set pw = 'c' 
where id = 'a';

delete from member
where id = 'a';