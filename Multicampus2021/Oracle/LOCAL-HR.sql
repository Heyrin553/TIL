select * from EMPLOYEES;
-- 한 줄 주석 
select DEPARTMENT_ID, DEPARTMENT_NAME from DEPARTMENTS; -- 그룹 아이디, 이름 

select * from employees where EMPLOYEE_ID >= 120 and employee_id < 130;

select * from EMPLOYEES where SALARY > 3000 and salary < 5000; -- 3000초과 5000미만 

select * from EMPLOYEES where SALARY between 3000 and 5000; -- 3000이상 5000이하

select * from employees where first_name = 'James';

select * from EMPLOYEES where FIRST_NAME like 'A%'; -- 첫번째 글자에 A가 있는 사람 
select * from EMPLOYEES where FIRST_NAME like '__a%'; -- 3번째 글자에 a가 있는 사람
select * from EMPLOYEES where FIRST_NAME like '%a%'; -- 이름에 a가 포함된 모든 사람 

select * from EMPLOYEES order by SALARY; -- salary 순으로 정렬, 기본 오름차순(작은것부터)
select * from EMPLOYEES order by SALARY DESC; -- 내림차순 정렬 

select * from EMPLOYEES order by SALARY desc, EMPLOYEE_ID desc; -- 샐러리 기준으로 내림차순 정렬후 ID기준으로 내림차순 정렬 

select MANAGER_ID From EMPLOYEES;
select DISTINCT MANAGER_ID From EMPLOYEES;



/* 여러 줄 주석
select DEPARTMENT_ID, DEPARTMENT_NAME from DEPARTMENTS;
*/
