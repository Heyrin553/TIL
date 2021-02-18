# JDBC 6단계

1. 드라이버 등록

   ```java
   Class.forName("드라이버 이름");  // 드라이버 객체 생성 
   ```

   - 다른 등록 방법도 있지만, 가장 안전하고 편리한 방법이다. 

   - 드라이버 이름은 ojdbc6.jar의 대표클래스 이름을 사용한다 - `oracle.jdbc.driver.OracleDriver`

   * 바로 실행하면 에러가 발생한느데, ojdbc6.jar과 연결을 안 해줬기 때문

     **경로지정하는 법**: 해당 프로젝트에서 오른클릭 - Build Path - Libraries - Add External JARs - ojdbc.jar 선택 후 Apply

     

2. 연결 

   DriverManager.getConnection("url", "user", "password");

   ```java
   Connection con = DriverManager.getConnection(String url,String user,String password)
   //리턴타입: Connection 인터페이스               
                                          		 // throws SQLException
   ```

   jdbc.url=jdbc:oracle:thin:@localhost:1521:xe

   jdbc.driver = oracle.jdbc.driver.OracleDriver

   jdbc.username = shop

   jdbc.password = 1234

   - 실제로 연결되는 것은 Connection 인터페이스이다.  

   - Driver는 전화를 받는 역할이라고 보면 된다. DriverManager는 드라이브를 사용할 수 있게 해 주는 java.sql의 클래스 중 하나이다.  

   

3. Statement 생성 (SQL 전송하기 위한 입)

   ```java
   Statement state = con.createStatement(); // 말하는 입 역할 
   ```

   > Creates a `Statement` object for sending SQL statements to the database.

   - Statement를 생성하기 위해 여러 메소드를 사용할 수 있다. 가장 많이 사용하는 것은 prepareStatement로, 뒤에서 자세히 알아보자. 

   

4. SQL문 전송 (귀 역할)

   ```java
   ResultSet result = state.excuteQuery("SQL문"); // executeQuery는 select문에 한해서 사용한다. 
   ```

   >  **Parameters:**
>
   > `sql` - an SQL statement to be sent to the database, typically a static SQL `SELECT` statement
>
   > excuteQuery의 리턴 타입은 ResultSet 타입이다. 
>
   > **`select`를 제외한 것들은 모두 Update사용**
   
   ```java
executeUpdate(String sql)
   ```

   > Executes the given SQL statement, which may be an `INSERT`, `UPDATE`, or `DELETE` statement or an SQL statement that returns nothing, such as an SQL DDL statement.

   - executeUpdate의 리턴 타입은 int이고, 변경된 행의 개수를 리턴한다. (변경된 행의 개수가 없으면 0을 리턴)

- Class는 DriverManager 하나뿐, 나머지는 다 인터페이스

- ```java
  Shape s = new Cirlcle();
  	  s = new Rectangle();
  	  s = new Triangle(); 
  ```

  이것과 비슷한 모양새 



5. 결과 얻기 

   ```java
   while(result.next()){
       int id = result.getInt("ID"); // ID컬럼을 int(컬럼타입)로 리턴
       String name = result.getString("name"); // name 컬럼을 String으로 리턴
       String addr = result.getString(3); // 컬럼순서를 안다면 순서 대입해도 됨(성능에 더 좋음!) 
   }
   ```

   > while문이  resultset을 돌면서 각 열마다 데이터를 얻어 변수에 저장한다. 이때 메소드는 각 열의 타입에 맞는 메소드를 사용한다. 

   

6. 자원 닫기 

   ```java
   result.close();
   state.close();
   con.close(); 
   ```

   > 닫는 순서는 사용한 순서의 반대로 하는 것이 안전

   ```java
   // 사용할 객체 초기화 
   Connection con = null;
   
   Statement state = null;
   
   ResultSet result = null; 
```
   
   **주의할점!**: `finally` 에서 닫기 위해 메인 메소드 바로 밑에 초기화 해두기!



# Statement의 확장

#### Statement의 상속 관계는 다음과 같다. 

CallableStatement (호출택배) ㅡ▶ PreparedStatement (전문택배) ㅡ▶Statement(일반택배) 

------

1. Statement(일반택배) 

```java
st = con.creatStatement();
```

- `execute(sql)` - 모든 것 (리턴타입: `boolean`, 결과집합이 있으면 `true` 없으면 `false`)
- `executeQuery(sql)` - `select` (리턴타입: `ResultSet`)
- `executeUpdate(sql)` - `select`제외한 모든 것 (리턴타입: 변경된 행위만 `int`로 리턴)

> 오토바이로 Java에서 DB로 그때그때 실어서 보냄



2. PreparedStatement (전문택배) - 가장 많이 사용! 

```java
PreparedStatement state = null; //준비되었다 
st = con.prepareStatement("간판"); //준비한다
// 간판 - SQL: select * from member
```

- `execute()` 
- `executeQuery()` 
- `executeUpdate()` 

> SQL문으로 간판을 달고 비어있는 오토바이를 보냄. 
>
> 간판으로 지정한 SQL만 수행하도록 Stored Procedure(function)화 됨.  
>
> 짜장면 배달 전문 오토바이 -짜장면만 배달 가능한 것처럼! 
>
> insert into membertbl values(?, ?, ?) 쿼리를 짤 때 이렇게 물음표로 줄 수 있는 능력이 있음 
>
> 데이터 타입에 맞추어 set메서드로 데이터 주기 
>
> ```java
> state = con.prepareStatement("insert into membertbl values(?, ?, ?)");
> 			state.setString(1, args[0]); // 첫번째 열에 args[0] 대입
> 			state.setString(2, args[1]); // 두번째 열에 args[1] 대입
> 			state.setString(3, args[2]); // 세번째 열에 args[2] 대입
> ```
>



3. CallableStatement (호출택배) 

   수업에서는 따로 다루지 않았다. 



Java는 Web을 타겟으로 한 언어, 기본 구조가 Web이다. 

성능을 위해  Java에서는 PreparedStatement를 사용해야 한다! 

+보안에도 좋음. 

```java
int executeUpdate()
```

Executes the SQL statement in this `PreparedStatement` object, which must be an SQL Data Manipulation Language (DML) statement, such as `INSERT`, `UPDATE` or `DELETE`; or an SQL statement that returns nothing, such as a DDL statement.

```java
public interface PreparedStatement
extends Statement
```

An object that represents a precompiled SQL statement.

A SQL statement is precompiled and stored in a `PreparedStatement` object. This object can then be used to efficiently execute this statement multiple times.





