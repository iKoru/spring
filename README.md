# spring

spring framework

1. 프레임워크 개요
2. spring 컨테이너*
 - 컨테이너란, 객체의 생성 및 관리를 담당하는 일종의 서버 개념이다.
애플리케이션 운용에 사용되는 객체의 생명주기와 객체들 간의 의존관계를 관리한다.

 -- 객체의 생명주기를 관리한다는 것은, (디폴트 설정상) 싱글톤 객체를 만들어준다는 것과
 -- 객체의 초기화 및 인스턴스화를 담당한다는 것이다.
 -- 객체들간의 의존관계를 관리한다는 것은, 뒤에서 나오는 dependency injection과 AOP를 사용한다는 말이다.
 -- 어느 객체가 다른 객체를 필요로하고(constructor-arg, property, auto-wired 등의 갖가지 방법이 있다.)
 -- 그럴 때 싱글톤 객체를 만들어주면서 이런것들을 관리한다는 말이다.

 - IoC의 등장
 -- IoC를 이용하면, 기존 프로젝트의 유지보수를 보다 편리하게 할 수 있다. 왜냐하면, 객체의 변경을 쉽게 할 수 있기 때문이다.
 -- 왜그러냐면, 빈으로 등록된 클래스만 변경하게 되면(xml 파일 수정) 연결되어 있는 객체를 바꿀 수 있기 때문이다.
 -- 실제 실행되는 인터페이스 입장에서 보자면 어떤 녀석이 연결되어있을 지 전혀 알 수 없다는 것이 특징이다. 
 -- 오직 실행을 실제로 해보아야, 알 수 있다.
 -- 이런 점 때문에 자바코드를 보면 어떤 코드가 실행될지 모르므로, 이를 애너테이션 등의 방법으로 알려주는 방법도 있다.
 -- 이렇게 외부에서 특정 클래스를 주입시켜주는 것이 바로 제어의 역전(IoC)이다.

 - 이렇게 다양한 설정파일이 필요하기 때문에 스프링을 개발할 때에는 STS를 이용하여 개발하는 것이 편리하다. 다 해주기 때문에.
3. dependency injection*
 - dependency lookup ; getBean 메서드. 주로 테스트를 위해서 사용하는 것이지만, 컨텍스트를 수동으로(즉, 자바코드에서) 로딩하여 가져올 때 사용하는 것.
 - constructor injection ; 빈을 초기화시킬 때, 디폴트생성자를 이용하는데 이를 대신하여 특정 파라미터가 있는 생성자를 이용하고자 할 때 사용하는 것.
 - setter injection ; 실질적으로 가장 많이 사용하는 것. 생성자주입의 경우 파라미터가 추가될 때마다 생성자를 바꿔줘야 한다는 단점이 있다. 
	세터의 경우 그냥 파라미터 하나 추가하고 이클립스 기본기능으로 디폴트 세터만 추가해주면 된다. 파라미터 삭제 시에도 편하다.
 - 여기에서 단순 객체 뿐만 아니라, 컬렉션 객체도 넣어줄 수 있다. 이럴 때 세팅은 <list>, <set>, <map>, <props> 등을 넣어주면 된다.

 - 이것 역시 애너테이션 기반으로 동작하도록 할 수 있다.
 - 컴포넌트 스캔!
 - 각 클래스의 역할에 따라 @Service, @Repository, @Controller 등으로 입력해도 된다. @Component와 실질적인 차이는 없다. 다만 구분하기 좋게 한다는 것.
 - 클래스의 종류를 기반으로 인젝션 해줄 객체를 선택한다. @Autowired를 쓸 때.
 - @Resource를 써도 된다.

4. spring aop*
 - 각 메서드가 실행되기 전, 후, 예외처리 시, 리턴시, 실행 전반에 걸쳐 일종의 트리거를 걸어주는 기능이다. 이 기능을 활용하면 
 다양한 부분에 걸쳐 공통적으로 사용되는 로깅, 보안처리, 트랜잭션 처리, 예외처리 등의 기능을 일괄적으로 처리해줄 수 있다.
 - 물론 여기에도 파라미터를 넘길 수 있다. joinpoint 객체가 바로 그 역할을 하는데, getSignature()메서드를 이용하면 호출한 함수를 찾을 수 있고
 getArgs()메서드를 사용하면 파라미터로 넘어가는 인풋을 확인할 수 있다.

 - 이것들도 모두 spring context에서 설정으로 처리해줄 수 있다. 트리거로 인해 실행되는 클래스를 advice라고 한다.
 - aspect, before, after, after-returning, after-throwing, around 등. POJO*가 아니다.

*POJO
plain old java object의 줄임말이다. 어떠한 클래스 상속이나 인터페이스 구현 없이 순수한 자바객체를 말한다. 다루기가 가볍기때문에 주목.

5. spring jdbc
 - template method pattern
 - datasource가 필요하다. 어떤 DB종류와 연결되어 있는지 알아야 한다.
 - transaction 관리 : 스프링에서 지원한다. aop를 이용하여 적용할 수 있다. transactionManager와 tx:advice를 이용한다.
 - select할 때에는 rowmapper라는 인터페이스를 인클루드 해야한다. 또 메서드를 구현해야함.. 불편합니다.


6. spring mvc*
 1세대에는 mvc가 따로따로 구분되어있지 않았고, view와 controller가 합쳐져있었다. jsp에서 자바코드 실행하는 것을 예로 생각하면 편하다.
 자바코드는 스크립틀릿으로 실행한다. 그러나 EL, JSTL 등의 문법을 사용하면 이를 사용하지 않을 수 있다. view와 controller를 완전히 구별한다는 의미다.
 - 서버는 web.xml을 바탕으로 서블릿 컨테이너를 생성한다. 이후에 컨텍스트 리스너를 통해 필요한 비즈니스 로직 컨테이너를 로드할 수 있다.
 - 서블릿 매핑의 url패턴에 해당하는 요청이 최초로 들어왔을 때 서블릿 설정을 바탕으로 dispatcherServlet을 생성한다. 여기에서 요청을 처리한다.
 - 이 때 컨트롤러 매핑을 하는 방식은 애너테이션을 이용하는 방법과 xml을 이용하는 방법이 있다. 두 가지 중에서 애너테이션을 이용하는 방법이 더 간편하고 좋다. 

 - EL로 get방식에 파라미터를 넘겨주고 싶을 때, 컨테이너에서 설정해준 내용을 넣고 싶다면 클래스 이름에서 첫글자만 소문자로 바꾼것을 이용한다.
 - 그게 아니라면 @ModelAttribute("name") UserVO vo 와 같이 함수 선언문 파라미터 앞에 넣어주면 된다.

 - 줄때 뿐만 아니라 받을 때에도 @RequestParam("name") String name 등과 같이 전달받을 수 있다.
 - 그렇지만 많아지면 불편하니까 그냥 VO쓰는경우가 많다. 그렇지만 defaultValue 설정을 이용해서 독자적으로 사용될 수도 있다.

 - 데이터 변환 : 크게 XML로의 변환(Object Xml Mapping), JSON으로의 변환 등이 있다.
 - java jdk에서 지원하는 JAXB를 이용하면 된다. 보통 annotation기반으로 사용한다.
 - 별도의 id를 언급해주지 않으면 xmlRootElement, Xmlelement 에서는 클래스명과 변수명을 따와서 이름으로 사용한다.
 
 - 등록해야 하는 bean은 marshaller, marshallingview 클래스이다.
 - jaxb2marshaller는, 변수로 받는 클래스 이름의 클래스에서 애너테이션을 체크한다.
 - 변환된 xml 데이터를 marshallingview클래스를 통해서 웹브라우저에서 볼 수 있다. --> xmlview타입의 뷰 객체를 하나 멤버변수로 가지고 있어야 한다.
 - json도 jsonview 클래스를 빈으로 등록해놓으면 된다. 인터페이스가 같음.

7. spring-iBatis
 - 스프링과 연동할 때에는 SqlMapClientTemplate 클래스를 이용해서 의존성 주입을 해줘야 한다.
 - autowired도 추가. 
 - template를 사용하는것과 그냥 클라이언트 사용하는것의 차이는 : exception 핸들링


8. spring-Mybatis
 - ibatis와 거의 같다. 다른 점은 : 
(1) parameterClass -> parameterType, (2) resultClass -> resultType, (3) typeAliases 설정은 sqlMapConfig에서 넣어준다.
(4) config에서 해주는 것은 모든 맵퍼에서 모두 공유할 수 있다.
(5) sqlMap -> mapper
(6) select function : queryForObject -> selectOne, queryForList -> selectList
(7) 변수 넣어주는 방법 : #name# -> #{name}
(8) mapper에 namespace를 필수로 넣어줘야 한다.
(9) autocommit이 기본으로 해제되어있다. 단 spring과 연동해서 트랜잭션 처리할 경우 안해줘도 된다.
(10) sqlSessionTemplate에는 setter injection이 불가능하다. 생성자 주입으로 처리해줘야 한다.