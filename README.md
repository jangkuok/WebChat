WEB CHAT
------

<div align="center">
  <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=OpenJDK&logoColor=white">
  <img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
  <img src="https://img.shields.io/badge/apachemaven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white">
  <img src="https://img.shields.io/badge/postgresql-4169E1?style=for-the-badge&logo=postgresql&logoColor=white">
  <img src="https://img.shields.io/badge/apachetomcat-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=black"><br>
  <img src="https://img.shields.io/badge/mybatis-F80000?style=for-the-badge">
  <img src="https://img.shields.io/badge/redis-FF4438?style=for-the-badge&logo=redis&logoColor=white">
  <img src="https://img.shields.io/badge/intellijidea-181717?style=for-the-badge&logo=intellijidea&logoColor=white">
  <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
</div>

----
### **🙌 프로젝트 명**

- WEW CHAT
  
----

### **🙋‍♀️ 프로젝트 소개**

- 실시간 웹 채팅 애플리케이션.
- WebSocket과 Redis 학습을 위한 프로젝트.
- session 불일치 문제 해결을 위해 로그인 정보를 Redis를 통해 메모리에 저장.
- WebSocket을 이용한 실시간 채팅 구현.
- 실시간 채팅 처리를 위해 Redis의 메시지 브로커와 STOMP 사용. (진행 중)
- 다른 환경에서도 일관된 실행을 할 수 있도록 Docker를 이용하여 컨테이너로 패키징. (진행 중)

----
### **🗓 개발 기간**

- 24.11.25 ~ 진행중
  
----

### **❗ 현재 진행 상황**

- WebSocker과 SockJS 라이브러리를 사용하여 실시간 양방향 통신 가능.
- STOMP 사용 시 메세지 송수신 실패
   - STOMP와 Redis의 브로커 메시지를 통한 통신 시 구독(sub)을 하지 못하는 현상 때문에 채팅을 쳐도 발행(pub)이 안됨.
- 메시지 저장을 위한 RDBMS? NoSQL?
   - Redis의 pub인 경우 메시지를 저장하지 않음. 때문에 저장할 DB가 필요.
   - 채팅 내용까지 RDBMS(PostgreSQL)에 저장하면 너무 많은 읽고 쓰는 작업에 의해 DB에 부담이 든다고 판단.
   - 메시지는 읽고 쓰는 작업은 많이 발생하지만 수정 작업은 일어나지 않음.
   - 진행 계획 : 많은 양의 데이터를 빠르게 읽을 수 있고 DB의 부담을 최소화 하기 위해 NoSQL 사용.
   - JSON형태로 데이터를 쉽게 처리할 수 있는 MongoDB 사용 예정.
   - NoSQL(MongoDB) 사용은 이번 프로젝트에서 처음 = 학습 후 도입 예정.
  
----
