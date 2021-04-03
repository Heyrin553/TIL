# TIL 나의 다짐💪

- 매일 21시-23시 사이에 commit&push 한다. 
- 간단하게라도 그날 배운 내용을 적는다! 
- 일주일에 한 번 tistory에 그 주에 배운 내용을 보기 쉽게 포스팅한다. ([tistory는 여기](https://beforerin.tistory.com/))



## Today I Learned

-  DBMS 개요와 Oracle소개, Oracle XE설치, SQL기본 문법을 배웠다. 
- SQL기본 구문 **CRUD**
  - C: Create / Insert (회원가입)
  - R: Read / Select (로그인)
  - U: Update (회원정보 수정) 
  - D: Delete (회원 탈퇴)
- 각종 프로그램 Syntax를 연습할 수 있는 사이트를 알게 되었다.(링크는 여기 [w3school](https://www.w3schools.com/sql/default.asp) )

-----

- JDBC 6단계를 배우고 코드로 구현했다. 

- **JDBC**(Java Database Connectivity)는 자바에서 데이터베이스에 접속할 수 있도록 하는 자바 API이다. **JDBC**는 데이터베이스에서 자료를 쿼리하거나 업데이트하는 방법을 제공한다.

- 구현 방법을 단계별로 보면 다음과 같다. 

  1. Driver 등록 : `Class forName("드라이버 이름");`

  2. 연결: `Connection con = DriverManager.getConnection(url, user, pw);`

  3. Statement 생성: PreparedStatement stmt = con.preparestatement("SQL문")

  4. SQL전송: `Result rs = stmt.executeQuery();`

     ​				`int i = stmt.executeUpdate();`

  5. 결과 얻기: `while (rs.next()){String id = rs.getString("칼럼명" or 칼럼번호)

     ​												 int point = rs.getInt("칼럼명" or 칼럼번호) };

  6. 자원 종료: `rs.close();`

     ​		 	 	`stmt.close();`

     ​			  	`con.close();`

     
