### Model? 

좁은 의미에서는 data위주의 클래스(VO)를 모델이라고 하지만, 

넓은 의미에서는 데이터를 변화시키는 것을 모두 모델이라고 함- 비즈니스(서비스), DAO를 포함하는개념 

MVC에서 모델은 VO의 의미 



무엇을 할지 목표가 명확한 클래스(응집력이 높은 클래스)가 좋은 클래스! 



### Spring Annotation

	<?xml version="1.0" encoding="UTF-8"?>
	<beans:beans xmlns="http://www.springframework.org/schema/mvc"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xmlns:beans="http://www.springframework.org/schema/beans"
		xmlns:context="http://www.springframework.org/schema/context"
		xsi:schemaLocation="http://www.springframework.org/schema/mvc https://www.springframework.org/schema/mvc/spring-mvc.xsd
			http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans.xsd
			http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">
	
	<!-- DispatcherServlet Context: defines this servlet's request-processing infrastructure -->
	
	<!-- Enables the Spring MVC @Controller programming model -->
	<annotation-driven />
	// 어노테이션 기반으로 동작
	
	<!-- Handles HTTP GET requests for /resources/** by efficiently serving up static resources in the ${webappRoot}/resources directory -->
	<resources mapping="/resources/**" location="/resources/" />
	
	<!-- Resolves views selected for rendering by @Controllers to .jsp resources in the /WEB-INF/views directory -->
	<beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<beans:property name="prefix" value="/WEB-INF/views/" />
		<beans:property name="suffix" value=".jsp" />
	</beans:bean>
	
	<context:component-scan base-package="my.jes.web" />
	//자동으로 빈으로 만들어달라 
	</beans:beans>



컨트롤러에 @Autowired MemberVO memverVO; 또는 @Autowired MemberDAO memverDAO;

> 매우 위험, 하면 안되는 방법! 
>
> 공유되는 객체가 되어 VO가 딱 하나 생김
>
> 예를 들어 만 명이 회원가입을 하면 만 개의 VO가 생기는게 맞음. 그러나 @Autowired되면  한 개만 생김 



@RequestMapping(value = "/*Form.do") 

> Form.do라는 요청이 들어오면 해당 메소드가 일할 것이다 
>
> 화면구성시 서버로 request가 안 넘어오게 했었음 
>
> 화면은 전부 서버쪽에 있는것. html, js, css가 한장씩 있다면 클라이언트도 html, js, css한장씩 가져감
>
> 회원가입버튼을 눌렀을때 회원가입버튼을 누르면 my.js로 가도록했음 
>
> @RequestMapping(value = "/*Form.do") 요렇게주는것은 매번 서버에서 처리해야한다는뜻(과부하가 쉽게 올 수 있음)
>
> 웬만하면 클라이언트 쪽에서 처리하도록 했더니 js가 엄청나게 길어지고 메모리도 모자람. 
>
> -> 그래서 너무 길고 복잡해지는 문제를 해결하기 위한 프레임워크들이 등장. 
>
> -> 메모리 문제 해결을 위해 garbage 콜렉션을 작동시키느라 화면이 버벅댐 -> facebook의 react가 이 문제를 해결함. 메모리를 효율적으로 관리하는 framework 



클래스의 역할을 구별하기 어렵다면 @Component로 달아도 됨. 그러나 웬만하면 성격에 맞는 annotation을 달아주는것이 좋음. 



annotation이름을 주기도 함(클래스 이름과 똑같이, 그러나 소문자로 시작)

> @Repository ("memberDAO")
>
> public class MemberDAO



### web.xml - 파라미터 

1. user parameter

   > 매 요청마다. 브라우저에서 사용자들이 입력하는 정보를 얻어옴 
   >
   > request.getParameter("id")
   >
   > ```
   > <servlet-mapping>
   > 		<servlet-name>appServlet</servlet-name>
   > 		<url-pattern>*.jes</url-pattern>
   > 	</servlet-mapping>
   > ```

2. Servlet init parameter

   > 이 서블릿이 객체화될때 딱 한번 읽히고 구성됨 
   >
   > 서블릿 초기화될때 이 설정이 들어감 
   >
   > ServletConfig.getInitParameter("이름") 
   >
   > ```
   > <servlet>
   > 		<servlet-name>appServlet</servlet-name>
   > 		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
   > 		<init-param>
   > 			<param-name>contextConfigLocation</param-name>
   > 			<param-value>/WEB-INF/spring/appServlet/servlet-context.xml</param-value>
   > 		</init-param>
   > 		<load-on-startup>1</load-on-startup>
   > 	</servlet>
   > ```

3. Servlet Context parameter

   > = Web context (=/=Web Contatiner, 톰캣. 하나의 컨테이너에 여러개의 웹 컨텍스트가 붙을 수 있음 )
   >
   > 웹 컨텍스트 하나하나를  하나의 객체로 취급, 그것이 Servlet Context객체. 
   >
   > 이 객체에 초기설정할 파라미터를 다음과 같이 설정 
   >
   > ```
   > <context-param>
   > 		<param-name>contextConfigLocation</param-name>
   > 		<param-value>/WEB-INF/spring/action-mybatis.xml</param-value>
   > 	</context-param>
   > ```
   >
   > > web.xml
   >
   > 파라미터 설정을 해두면 프로젝트 실행시 가장 먼저 읽히고 구성됨. (딱 한번만)



```
<bean id="sqlSessionFactoryBean" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource"></property>
		<property name="configLocation" value="classpath:mybatis/model/modelConfig.xml"></property>
		<property name="mapperLocations" value="classpath:mybatis/mappers/*.xml"></property>
	</bean>
```

> classpath: 기본 위치. 



- 개발 과정에서 디버깅을 위해 시스템 출력을 자주 사용하지만, 시스템 출력은 성능에 매우 악영향을 주므로 개발완료후에는 다 지워야함. 

- 해킹을 추적하기 위해서 어딘가에 ip를 기록해야 함. 이때 시스템 출력이 아니라 logger를 사용해 기록. 이 기능을 제공하는 것이 log4j(많이 쓰는 라이브러리 이름. 미리 짜여진 코드!)

- 따로 다운받아서 사용해도되고 maven디펜던시를 사용하면 자동으로 다운로드됨 

- pom.xml에서 확인- > log4j 찾기 

  ```
  <groupId>log4j</groupId>
  <artifactId>log4j</artifactId>
  <version>1.2.15</version>
  <exclusions>
  ```

- 기준폴더 밑 log4j.xml에서 설정가능 (but 이클립스오류로 한번이라도 파일을 열면 x표시가 뜸.)

  ```
  <?xml version="1.0" encoding="UTF-8"?>
  <!DOCTYPE log4j:configuration PUBLIC "-//APACHE//DTD LOG4J 1.2//EN" "http://logging.apache.org/log4j/1.2/apidocs/org/apache/log4j/xml/doc-files/log4j.dtd">
  <log4j:configuration xmlns:log4j="http://jakarta.apache.org/log4j/">
  ```

  >  상단 3줄을 다음과 같이 선언하면 에러가 사라짐 

- ```
  	<!-- Application Loggers -->
   	<logger name="my.jes.web3">
  		<level value="info" />
  	</logger> 
  ```

- ```
  	<!-- Root Logger -->
  	<root>
  		<priority value="warn" />
  		<appender-ref ref="console" />
  	</root>
  ```

- ```
  	<!-- Root Logger -->
  	<root>
  		<priority value="debug" />
  		<appender-ref ref="console" />
  	</root>
  ```

- 로그 레벨들

  - FATAL: 심각한 문제 발생
  - ERROR: 문제발생 
  - WARN: 경고메시지
  - INFO: 기본. 정보메시지 출력
  - DEBUG: 디버깅 용도로 사용. 개발시에 사용, 따로 세팅이 필요 
  - TRACE: 디버깅보다 상세한 추적을 보여줌

- mapper파일에서 이 부분을 수행했다고 해 보자. 여기에 들어가는 데이터들이 제대로 들어갔는지 확인하고 싶을 때 memberVO를 DAO에서 시스템 출력하면되지만 insert 시에 제대로 바인딩되고있는지 확인하고싶다면? -> log4j에 value=debug로 주면 보임 

- 빨간색은 톰캣, 하얀색은 스프링에서 찍어주는 로그 

- ```
  [회원가입 실행후 콘솔]
  DEBUG: org.mybatis.spring.SqlSessionUtils - Creating a new SqlSession
  DEBUG: org.mybatis.spring.SqlSessionUtils - SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@7dd32a4f] was not registered for synchronization because synchronization is not active
  DEBUG: org.springframework.jdbc.datasource.DataSourceUtils - Fetching JDBC Connection from DataSource
  DEBUG: org.apache.ibatis.datasource.pooled.PooledDataSource - Checked out connection 1592061691 from pool.
  DEBUG: org.mybatis.spring.transaction.SpringManagedTransaction - JDBC Connection [oracle.jdbc.driver.T4CConnection@5ee4eefb] will not be managed by Spring
  DEBUG: mapper.member.memberInsert - ooo Using Connection [oracle.jdbc.driver.T4CConnection@5ee4eefb]
  DEBUG: mapper.member.memberInsert - ==>  Preparing: insert into member(memid,pw,memname) values(?,?,?) 
  DEBUG: mapper.member.memberInsert - ==> Parameters: kkk(String), kkk(String), 김자바(String)
  DEBUG: org.mybatis.spring.transaction.SpringManagedTransaction - Committing JDBC Connection [oracle.jdbc.driver.T4CConnection@5ee4eefb]
  DEBUG: org.mybatis.spring.SqlSessionUtils - Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@7dd32a4f]
  DEBUG: org.springframework.jdbc.datasource.DataSourceUtils - Returning JDBC Connection to DataSource
  DEBUG: org.apache.ibatis.datasource.pooled.PooledDataSource - Returned connection 1592061691 to pool.
  ```

- ```
  [주목!]
  DEBUG: mapper.member.memberInsert - ==>  Preparing: insert into member(memid,pw,memname) values(?,?,?) 
  DEBUG: mapper.member.memberInsert - ==> Parameters: kkk(String), kkk(String), 김자바(String)
  ```

  - 그러나 보안에 치명적이므로 개발완료후에는 설정 바꿔야함. 실무에가면 팀에서 미리 결정하고 가이드를 줌. 시스템출력하지말고 로그파일로 저장하도록! 매일쌓일것인지, 한 파일을 계속 업데이트할것인지 등.. 암호화 할것인지 말것인지.. 회원가입할때 정보가 다 보이면 개인정보보호법에 걸림! 



### 파일 업로드 기능

- `<input type="file" id="files" name="files" multiple>`

- 버튼 따로 안만들어도 됨! 
- 서버에서 어떻게 받아오는지 따로 해보기! 



### 썸네일 이미지 사용하기 

- 상품 목록에 이미지를 축소하여 표시 



### 스프링 이메일 사용하기 



### 스프링 인터셉터 사용하기 

- 서블릿의 필터기능: 인코딩(문자치환) 
- ex) http://ip:port/context/login.do?id=a://&pw=b 로 호출한다면? ://을 구별자로 인식하게 됨. a://를 다른문자로 치환해야 함 
- 한글검색시 인코딩하여 들어감
- 일괄처리해야하는 일이 있다면 filter를 이용! 서블릿은 인터셉트라는 컴포넌트(스프링 컴포넌트)에게 보내 일괄처리함. 
- filter는 전영역을 일괄처리한다면 intercepter는 각 컨트롤러별로 처리함(멤버컨트롤러/주문컨트롤러/제품컨트롤러/장바구니 컨트롤러등..) 



### REST

- Representational State Transfer
- 하나의 URI 가 고유한 리소스를 처리하는 공통방식
- 우리는 main으로 고정하고 sign값으로 요청을 구분했음 
- URI 예시
  - POST: /board+데이터 -> 새글등록
  - GET: /board/133  -> 133번 글 조회
  - PUT: /board/133 + 데이터 -> 133번 글 수정
  - DELETE: /board/133 -> 133번 글 삭제 
- URL로 의미를파악하는것은 보안에 굉장히 나쁨. post와 get만 그렇게할것
- put과 delete는 다른 방식으로 구별! 
- URL은 고정되어있는것이 가장 좋음. 

