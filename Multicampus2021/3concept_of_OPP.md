### OOP의 3대 컨셉

1. **캡슐화**

   > Data는 private하게, method(setter/getter)는 public하게. (default/protcted도 사용 가능하지만 public이 일반적)

   - 유효성 검사를 반드시 거치도록 해야 함 
   - 캡슐화=데이터 보호 정책 
   - 객체지향에서는 data를 function보다 중요하게 생각! 

   ##### 접근지정자

   - `private`: 자기 클래스 내에서만 접근가능(자식도 접근 불가능) `like 금고`

   - `default`: 같은 패키지 내에서만 접근가능 `like 냉장고`

   - `protected`: 다른 패키지라도 상속 관계라면 접근 가능 `like 장롱`

   - `public`: 어디서나 접근 가능 

     

2. **inheritance(상속)**

   > 부모(super)의 member(data/method)를 상속. 
   >
   >  data를 상속받는것은 지양, method를 상속받는것을 지향! 

   - 상속관계는 `extends`로 표현하지만 단일 상속을 의미(단일 부모). 명확한 계층도를 갖기 위해 단일상속을 규칙으로 함. 

   - Object가 루트!(모든 것의 뿌리) 

   - 다른 언어들은 다중 상속을 가짐. 

   - but 상속 지향을 하다 보면 shadow effect를 우회하기 위해 if를 사용함으로써 성능을 떨어트리게 될 수 있음. 

     - `shadow effect`: `super type`으로 선언된 객체는 그 `super type`으로만 취급하는 것. == 하위 타입의 멤버가 가려짐. 
     - 이 규칙을 위반하는 것이 `overriding`
     - `overriding`: `super`(아버지객체)의 메서드를 `sub`(자식객체)에서 **재정의**했을 때 `super type`으로 선언했어도 **재정의된 메소드**가 가려지지 않는 규칙! => 즉 `shadow effect`를 벗어나기 위해서 super와 같은 이름의 메소드를 선언(재정의)하는 것. 
     - 성능과 확장성을 높이기 위한 방법 -> 아래 다형성에 관한 설명에서 계속!

     

3. **polymorphism**(다형성)

   1. 다형적 변수(polymorphic variable) 

      >  super type으로 선언된 변수. **확장성**을 위해 사용 

      ```java
      public void print (Shape s) { // 정의 
      // 모든 shape의 하위 객체를 가리키는 변수! 
      
      }
      ```

      - 다형적 변수의 최고봉은 Object o

      ```java
      main(){
      Object O;
      o=new Circle();
      o=new Rectangle();
      o="java";
      o=new String("java");
      }
      ```

   2. override (재정의) -구조가 아닌 **내용**의 재정의!

      > super의 메소드를 sub에서 다시 정의하는 것! 
      >
      > shadow effect를 우회하기 위해 사용 
      >
      > 왜 shadow effect를 우회해야 하는가? **확장성, 성능 향상**을 위해서

      |                       | object                   |                           |
      | --------------------- | ------------------------ | ------------------------- |
      |                       | shape----area(){}        |                           |
      | Circle<br>area(){r^2} | Rectangle<br>area(){w*h} | Triangle<br>area(){w*h/2} |

      - 컴파일 시점

      ```java
      Shape s;
      s.area();
      ```

      - 실행 시점

      ```java
      s.area();
      //실제객체(sub), 다양하게 수행됨 
      ```

   3. overloading (오버로딩) 

      > 한 클래스 내에 같은 이름의 메소드가 다수 존재하는 것. 
      >
      > 사용성을 높이기 위함. (확장성은 여전히 떨어짐)
      >
      > 확장성과 사용성을 동시에 갖추기 위해 overloading과 overriding을 동시에 사용한다. 

      ```java
      class Printer{
          public void printCircle(Circle c){
              c.radius=5;
          	c.area();
      }
          public void printRectangle(Rectangle r){
              r.w=6;
              r.h=7;
              r.area();
          }
      }
      //성능에는 괜찮음
      //확장성과 사용성이 떨어짐! 
      ```

      ```java
      class Printer{
          public void print(Circle c){
              c.radius=5;
          	c.area();
      }
          public void print(Rectangle r){
              r.w=6;
              r.h=7;
              r.area();
          }
      }
      //오버로딩
      //아규먼트 리스트가 달라야 함! 리턴 타입이 달라도 됨.  
      //오버라이딩-아규먼트 리스트, 리턴 타입 완전히 같아야 함! 
      ```

      ```java
      class Printer{
          public void print(Circle c){ //circle만을 특별히 제어하고 싶은 의도를 반영
              c.radius=5;
          	c.area();
      }
          public void print(Rectangle r){ //Rectangle만을 특별히 제어하고 싶은 의도를 반영
              r.w=6;
              r.h=7;
              r.area();
          }
          public void print(Shape s){ //면적을 가지는 애들을 계산하겠다는 의도 
              s.area(); // 실행시 객체의 area()수행하는 것이 오버라이딩. 
          }
          
      }
      ```

      