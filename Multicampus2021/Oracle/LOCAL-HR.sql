select * from EMPLOYEES;
-- �� �� �ּ� 
select DEPARTMENT_ID, DEPARTMENT_NAME from DEPARTMENTS; -- �׷� ���̵�, �̸� 

select * from employees where EMPLOYEE_ID >= 120 and employee_id < 130;

select * from EMPLOYEES where SALARY > 3000 and salary < 5000; -- 3000�ʰ� 5000�̸� 

select * from EMPLOYEES where SALARY between 3000 and 5000; -- 3000�̻� 5000����

select * from employees where first_name = 'James';

select * from EMPLOYEES where FIRST_NAME like 'A%'; -- ù��° ���ڿ� A�� �ִ� ��� 
select * from EMPLOYEES where FIRST_NAME like '__a%'; -- 3��° ���ڿ� a�� �ִ� ���
select * from EMPLOYEES where FIRST_NAME like '%a%'; -- �̸��� a�� ���Ե� ��� ��� 

select * from EMPLOYEES order by SALARY; -- salary ������ ����, �⺻ ��������(�����ͺ���)
select * from EMPLOYEES order by SALARY DESC; -- �������� ���� 

select * from EMPLOYEES order by SALARY desc, EMPLOYEE_ID desc; -- ������ �������� �������� ������ ID�������� �������� ���� 

select MANAGER_ID From EMPLOYEES;
select DISTINCT MANAGER_ID From EMPLOYEES;



/* ���� �� �ּ�
select DEPARTMENT_ID, DEPARTMENT_NAME from DEPARTMENTS;
*/
