select * from MEMBERTBL where MEMBERNAME = '������';

select * from MEMBERTBL;
insert into MEMBERTBL values ('Bong', '�º���', '���� ���빮�� ����'); -- ���� �÷���/������ �˰� ������ �÷��� �� �ᵵ �� 
insert into MEMBERTBL(MEMBERID, MEMBERNAME, MEMBERADDRESS) values ('Lee', '������', '���� ���빮�� ����');
insert into MEMBERTBL( MEMBERNAME, MEMBERID, MEMBERADDRESS) values ('������', 'Hoon', '��õ ���� �۵���');

select * from PRODUCTTBL;
-- UPDATE PRODUCTTBL SET AMOUNT = 100 -- ������ ���ָ� �ϰ������� ���� 

UPDATE PRODUCTTBL SET AMOUNT = 50 WHERE PRODUCTNAME = '��Ź��';
UPDATE PRODUCTTBL SET AMOUNT = 80 WHERE PRODUCTNAME = '��ǻ��';

-- DELETE from producttbl where productname = '��ǻ��';
update member 
set pw = 'c' 
where id = 'a';

delete from member
where id = 'a';