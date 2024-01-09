### 자바스크립트 ECMA버전으로 DOM객체 선택 및 이벤트 사용부터 리액트프로그램의 기초인 모듈 사용하기 및 웹소켓 API사용 까지
### 덤으로 스프링부트3 에서 백엔드용 채팅 API서비스 구현

####0. 개발환경 설치 : (아래)
- VS Code(자바스크립트 개발환경)
- 자정부표준프레임워크 eGov4.2.0버전(스프링부트3 백엔드 개발환경)
- 윈도우용 도커데스크탑 설치(스프링부트3 백엔드API서비스 배포용)
- Ajax 실습에 사용된 URL : https://www.kobis.or.kr/kobisopenapi/homepg/apiservice/searchServiceInfo.do 에서 사용된 예시 키(샘플키사용)\
  ajaxexam/exam16,17.html에서는 영화포스터를 가져오는 API에서 KakaoAK 인증키가 필요하고, 수업 시 개별적으로 발급을 받아본다.
  백엔드에서 날씨 정보 가져오는 기상청 RSS 서비스 사용 확인 : https://www.weather.go.kr/w/pop/rss-guide.do
- 실습에 사용되는 무료 이미지들 : (아래 캐릭터 아이콘)
  https://pixabay.com/ko/vectors/%EB%B2%88%ED%98%B8-%EC%96%91%EC%B4%88-%EC%83%9D%EC%9D%BC-%EC%B6%95%ED%95%98-2024504/
  https://pixabay.com/ko/vectors/%EC%A5%90-%EA%B7%80%EC%97%AC%EC%9A%B4-%EB%8F%99%EB%AC%BC-%EC%95%84%EA%B8%B0-1545990/
  https://pixabay.com/ko/vectors/%EC%A5%90-%EA%B7%80%EC%97%AC%EC%9A%B4-%EB%8F%99%EB%AC%BC-%EC%95%84%EA%B8%B0-1545990/
  https://pixabay.com/ko/videos/%EA%B0%80%EB%B2%BC%EC%9A%B4-%ED%9D%94%EB%93%A4%EB%A6%BC-%EA%B8%B8-%EB%8F%84%EB%A1%9C-%EC%88%B2-187612/

####1. 백엔드(스프링부트3)는 OpenJDK17 이상이 필요하기 때문에 eGovFrameDev-4.2.0 이상으로 개발 해야 한다.
- eGov4.2.0 개발환경에서 프로젝트 import 전 그래들 Home 위치는 변경했습니다 : C:\Users\USER\.gradle 에서 C:\egov\gradle
  참고로, 메이븐 작업하지 않는 분은 하실필요 없고, 저는 기존 Maven 레포지토리도 변경했습니다 : C:\Users\USER\.m2\repository 에서 C:\egov\repository
- 교사 프로젝트명을 변경하고 싶으시면, build.gradle 의 파일내용 중 archivesBaseName = 'springboot3' 과 archiveFileName = 'springboot3.jar' 으로 변경
- 교사 프로젝트명을 변경하고 싶으시면, settings.gradle 의 파일내용 중 rootProject.name = 'springboot3' 으로 변경
- eGov4.2.0 개발환경에서 import Existing Gradle Project 로 스프링부트3용 프로젝트 불러오기
- eGov4.2.0 개발환경에서 위 스프링부트3용 프로젝트를 실향하고, bootJar 만들기.

####2. VS Code 개발환경을 실행하여 Live Server 로 jsexam 폴더의 파일을 실행하며, 자바스크립트+ECMA Script 실습.
- 자바스크립트 소스는 위 백엔드 단의 workspace 폴더에 education 폴더명으로 위치하게 한다.

####3. 위 스프링부트3용 백엔드 API서비스를 기준으로 VS Code 개발환경을 실행하여 Live Server 로 ajaxexam 폴더의 파일을 실행하며, 연동 테스트시작

####Ps. 위에서 만든 springboot3.jar파일을 도커이미지로 만들고, 도커컨테이너로 실행하기(아래)
- 도커 파일이 존재하는 위치에서 다음 명령을 수행합니다.
- 내PC 로컬용(아래)
 1).현재 디렉토리에 존재하는 Dockerfile을 가지고 도커 이미지를 내 PC에 생성하는 명령
    docker build . -t springboot3
 2).도커 컨테이너 생성 및 실행
    docker run -d -p 8088:8088 springboot3
 3).결과확인 : http://localhost:8088/boards/friends