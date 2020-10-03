# org.springframework.beans.BeanInstantiationException
- detail
```java
Error creating bean with name 'memberRepository' defined in 
class path resource [appConfig.xml]: Instantiation of bean failed;
 nested exception is org.springframework.beans.BeanInstantiationException: 
Failed to instantiate [com.spring.basic.spring_demo.member.MemberRepository]:
 Specified class is an interface
org.springframework.beans.factory.BeanCreationException:
 Error creating bean with name 'memberRepository' defined in class path
 resource [appConfig.xml]: Instantiation of bean failed
; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate
 [com.spring.basic.spring_demo.member.MemberRepository]: Specified class is an interface
```

- ApplicationContext를 xml로 불러오는 과정을 진핸하던 중 생긴 오류
    - memberRepository를 매핑한 클래스 대상이, '구현'체가 아니라 '역할'을 담당하는 Interface 였기 때문에, 생긴 오류
    -`class="com.spring.basic.spring_demo.member.MemberRepository"` -> `class="com.spring.basic.spring_demo.member.MemoryMemberRepository"` 로 고쳐 이슈 해결.

# org.opentest4j.AssertionFailedError:
- detail
```java
Expecting:
 <com.spring.basic.spring_demo.member.MemberServiceImpl@39e02fb8>
to be equal to:
 <com.spring.basic.spring_demo.member.MemberService>
but was not.
	at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
	at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
	at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
```

- Junit을 통해 xml로 config한 ApplicationContext로 빈을 제대로 가리키고 있는지 확인하는 과정에서 생긴 이슈
- `isEqualsTo()` 로 사용하면, `MemberServiceImpl` 이 `MemberService`에 의존하는지 확인하는 것이 아니라 `MemberService` 자체의 인스턴스인지 아니니지를 확인하기 때문에 생기는 오류.
- `isEqualsTo()` -> `isInstanceOf()` 로 고쳐 이슈 해결.