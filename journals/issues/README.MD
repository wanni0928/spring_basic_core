# ISSUES
## memberService 구현 중 이슈 발생.
- OrderServiceImpl에 할인정책을 주입하는 과정에서, 인터페이스와 구현 클래스를 동시에 의존하면서 `DIP` 위반
- 할인정책을 확장하면서, 클라이언트 코드에 영향을 준다. `OCP` 위반
### solution
- AppConfig 라는 설정을 담당하는 클래스를 만들어, 구현 객체를 생성, 연결하는 책임을 가지는 설정 클래스를 만듦.
    - appConfig를 통해, 구현을 위한 의존관계를 주입(Dependency Injection, DI)하고, 서비스 객체는 '실행'에만 집중할 수 있게 한다.