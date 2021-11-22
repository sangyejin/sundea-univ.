# sundea-univ_semiProject
목차
---
- 프로젝트 소개 및 기획의도
- 유사프로그램 분석
- 요구사항 및 주요기능
- ERD
- 개발일정 및 개발환경
- 역할분담
- 코드리뷰_상예진
- 소감



프로젝트 소개 및 기획의도
---
수도권 인구 밀집 현상으로 인한 충북 충주시 청년층의 감소로 전통있던 휴수의 대학교 두 곳이 급작스레 폐교하는 상황에 처해있습니다. 이런 상황에서도 살아남은 순대학교를 위한 새로운 학사 정보 관리페이지가 필요합니다. 기존의 학사 관리 프로그램을 분석하여 순대학교의 자체 학사 관리 프로그램을 구현할 예정입니다(가상의 설정)



유사프로그램 분석
---
1. 충O대학교 학사 관리 시스템
2. 인O대학교 학사 관리 시스템
3. 교O대학교 학사 관리 시스템

__분석 결과__
1. 학생과 교원을 위한 성적 관리 페이지 제공
2. 교원을 위한 상담 관리 페이지 제공
3. 개인 학전 조회 페이지 제공

__차별성__
1. 불필요한 기능을 출여 간소화
2. 사용자 친화적인 UI/UX



요구사항 및 주요기능
---
- 학생
 - 상담조회/성적조회/학적조회
- 교수
 - 성적관리/상담관리/강의조회
- 관리자
 - 학생관리/교수관리/강의관리   



ERD
---
![picture](./etc/erd.png)




개발일정 및 개발환경
---
#### 개발일정
1. 기획 및 1차 보고(~8/2)
 - 기획안 작성 및 아이디어 회의
 - 유스케이스, 클래스다이어그램 작성 및 역할분담
 - Guthub 설정
2. DB설계(~8/9)
 - 테이블기술서/엔티티기술서/요구사항정의서 작성  
3. 구현(~8/27)
 - 데이터베이스 구현
 - 프로그램 구현
4. 발표준비(~9/1)
 - 프레젠테이션 및 발표영상 준비

#### 개발환경
- 운영체제 : Window 10
- 개발도구 : Eclipse
- DBMS : Oracle DB - sqldeveloper
- Server : Apache Tomcat 8.5
- Language : Java, HTML5, CSS3, Javascript, JQuery, Servlet, JSP
    
    
    
역할분담
---
- 이윤정(팀장)
  - 로그인, 로그아웃, 비밀번호 초기화 및 변경, 학번 및 교원번호 찾기
  - 메뉴바
  - 교수 페이지
- 김성대(팀원)
  - 관리자 페이지 : 강의/교수 리스트 관리
- 왕수빈(팀원)
  - 관리자 페이지 : 학생 리스트 관리, 강의 관리
  - 학생 페이지 : 학적 조회 상세보기
- 상예진(팀원)
  - 메인 페이지
  - 학생 페이지 : 학적/상담/성적 조회, 증명서 발급



코드리뷰_상예진
---
[![코드리뷰 및 시연 영상_상예진]( https://img.youtube.com/vi/eg9A1bVgywI/0.jpg)](https://youtu.be/eg9A1bVgywI?t=0s) 




소감
---
역할분담을 나누다 보니 select문만 사용한 것이 아쉬웠지만 그래도 머리에서 둥둥 떠다니던 지식들을 활용해서 실제로 무언가를 구현해내는 것에서 성취감을 많이 느꼈습니다. 본격적으로 해본 프로젝트에서 제 몫을 다하기 위해서 매일 고군분투하고 팀원들과 함께 문제를 해결해나가는 점이 힘들면서도 너무나 뿌듯했습니다. 시간이 조금만 더 주어졌다면 메인페이지를 좀 더 퀄리티있게 했으면하는 아쉬움이 남지만 이를 발판 삼아서 다음 프로젝트에서는 좀 더 다양한 기능들을 멋지게 구현해보고 싶습니다.  
