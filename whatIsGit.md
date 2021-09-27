# Git 기초



## 목차

- [들어가며](#들어가며)
- [Git 이란?](#Git-이란)
- [Git 기초](#Git-기초)

## 들어가며

깃허브 데스크롭을 이용해 클론 코딩을 하던중 깃과 깃허브에 대한 공부가 필요함을 느꼈다.

깃이 무엇인지 깃허브은 무엇인지 commit과 fetch, branch, repository에 대한 원리와 개념을

조금 더 심도있게 알아보자.



## Git 이란?

2002년에 Linux 커널에선 Bitkeeper라고 불리는 상용 *DVCS를 사용하기 시작했다.

2005년 Bitkeeper가 유료화 되면서 Git이 탄생하게 되었다.

Git은 Bitkeeper에서 얻은 교훈을 기반으로

+ 빠른속도
+ 단순한구조
+ 완벽한분산
+ 비선형적인개발(수천개의 동시 다발적인 branch)
+ Linux 커널 같은 대형 프로젝트에도 유용할 것(속도나 데이터 크기 면에서)

위와 같은 목표를 세웠으며 지금 현재까지 그 목표를 유지하고 있다.

***DVCS** (Distributed Version Control Systems ) 즉, 분산 버전 관리 입니다. 사전적 설명으로는 중앙 서버에 있는 코드를 개발자 각자의 로컬 컴퓨터에 복사한 후, 복사된 프로젝트를 가지고 작업하며 서버에 업로드를 할 수있습니다.

## Git 기초

### 차이점

다른 VCS와 Git의 가장 큰 차이점은 데이터를 다루는 방법에 있다.

큰 틀에서 봤을때 VCS 시스템의 대부분은 관리하는 정보가 파일들의 목록이다.

각 파일의 변화를 시간순으로 관리하면서 파일들의 집합을 관리한다.(일반적으로 델타 기반 VCS라고함)

![그림4](https://git-scm.com/book/en/v2/images/deltas.png)

Git은 이런식으로 데이터를 저장하지도 취급하지도 않는다.

대신 Git은 데이터를 파일 시스템 스냅샷의 연속으로 취급하고 크기가 아주 작다.

Git은 commit하거나 프로젝트의 상태를 저장할 때마다 파일이 존재하는 그 순간을 중요하게 여긴다.

파일의 변화가 없으면 Git은 성능을 위해 파일을 새로 저장하지 않는다. 단지 이전 파일에 대한 링크만 저장한다.

Git은 데이터를 __스냅샷의 스트림__ 처럼 취급한다.

![그림5](https://git-scm.com/book/en/v2/images/snapshots.png)



### Nearly Every Operation Is Local

Git의 대부분의 작업은 로컬 파일과 리소스만 있으면 작동한다.

로컬 디스크에 프로젝트의 전체 기록이 있기 때문에 대부분의 명령은 순식간에 실행된다.



### Git Has Integrity

Git은 데이터를 저장하기전에 항상 체크섬을 구하고 그 체크섬으로 데이터를 관리한다.

이것은 Git 없이는 파일이나 디렉토리의 내용을 변경하는 것이 불가능하다는 것을 의미한다.

Git은 SHA-1 해시를 사용해서 체크섬을 만든다.

체크섬은 40자길이의 16진수 문자열로 Git의 파일또는 디렉토리 구조의 내용을 기반으로 생성된다.

Git은 모든 것을 해시로 식별하기 때문에 다양한 곳에서 해시 값을 볼 수 있으며

Git은 파일을 파일의 이름으로 저장하지 않고 해당 파일의 해시 값으로 저장한다.



### Git Generally Only Adds Data

Git으로 어떤 행동을 하던 Git 데이터베이스에 데이터가 ADD된다.

되돌리거나, 삭제할 방법이 없다.

스냅샷이 커밋된 뒤에는 데이터를 잃어버리기도 어렵다.



### The Three States

Git은 파일을 Committed, Modified, Staged 이렇게 세가지 상태로 관리한다.

- Committed란 데이터가 로컬 데이터베이스에 안전하게 저장되었다는 것을 의미한다.
- Modified는 수정한 파일을 아직 로컬 데이터베이스에 커밋하지 않은 것을 말한다.
- Staged란 현재 수정한 파일을 곧 커밋할 것이라고 표시한 상태를 의미한다.

이 세가지 상태는 Git 프로젝트의 세가지 단계와 연결되어 있다. Git 디렉토리(Repository), Staging Area, Working Directory 이렇게 세가지 단계를 이해하고 넘어가자.

![워킹트리](https://git-scm.com/book/en/v2/images/areas.png)

워킹 트리는 프로젝트의 특정 버전을 Checkout한 것이다. Git 디렉토리(Repository)는 현재 작업하는 디스크에 있고 거기에 압축된 데이터베이스에서 파일을 가져와서 워킹트리를 만든다.

Git 디렉토리(Repository)는 Git이 프로젝트의 메타데이터와 객체 데이터베이스를 저장하는 곳을 말한다. 이 디렉토리가 Git의 핵심이다. 다른 컴퓨터에서 Repository를 Clone 할때 복제되는 부분이다.

Staging Area는 Git 디렉토리에 있다. 단순한 파일이고 곧 Commit할 파일에 대한 정보를 저장한다.

Git에서는 기술용어로 Index라고한다.



Git에서 하는 일은

1. 워킹트리에서 파일을 수정한다.
2. Staging Area에 파일을 Stage해서 Commit할 스냅샷을 만든다. 모든 파일을 추가 할 수도 있고 특정 파일만 선택하여 추가 할 수도 있다.
3. Staging Area에 있는 파일들을 커밋하여 Git 디렉토리(Repository)에 영구적인 스냅샷으로 저장한다.

Repository에 있는 파일들은 Commited 상태,

파일을 수정하고 Staging Area에 추가했다면 Staged상태,

아직 Staging Area에 추가하지 않았다면 Modified 상태이다.

## 참고 자료

https://git-scm.com/book/ko/v2/%EC%8B%9C%EC%9E%91%ED%95%98%EA%B8%B0-Git-%EA%B8%B0%EC%B4%88
