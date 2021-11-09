# 리모트 브랜치



## 목차

- [리모트 브랜치](#리모트-브랜치)



## 리모트 브랜치

리모트 Refs는 리모트 저장소에 있는 포인터인 레퍼런스다.

리모트 저장소에 있는 브랜치, 태그, 등등을 의미한다.

``git ls-remote <remote>`` 명령으로 모든 리모트 Refs를 조회할 수 있다.

``git remote show <remote>`` 명령은 모든 리모트 브랜치와 그 정보를 보여준다.

리모트 Refs가 있지만 보통은 리모트 트래킹 브랜치를 사용한다.



리모트 트래킹 브랜치는 리모트 브랜치를 추적하는 레퍼런스이며 브랜치다.

리모트 트래킹 브랜치는 로컬에 있지만 임의로 움직일 수 없다.

리모트 서버에 연결할 때마다 리모트의 브랜치 업데이트 내용에 따라서 자동으로 갱신될 뿐이다.

리모트 트래킹 브랜치는 일종의 북마크라고 할 수 있다.

리모트 저장소에 마지막으로 연결했던 순간에 브랜치가 무슨 Commit을 가리키고 있었는지를 나타낸다.



리모트 트래킹 브랜치의 이름은 ``<remote>/<branch>`` 형식으로 되어 있다.

예를 들어 리모트 저장소 ``origin`` 의 ``master`` 브랜치를 보고 싶다면 ``origin/master`` 라는 이름으로 브랜치를 확인하면 된다.

다른 팀원과 함께 어떤 이슈를 구현할 때 그 팀원이 ``iss53`` 브랜치를 서버로 Push 했고 당신도 로컬에 ``iss53`` 브랜치가 있다고 가정하자. 이때 서버의 ``iss53`` 브랜치가 가리키는 Commit은 로컬에서 ``origin/iss53`` 이 가리키는 Commit이다.



다소 헷갈릴 수 있으니 예제를 좀 더 살펴보자.

``git.ourcompany.com`` 이라는 Git 서버가 있고 이 서버의 저장소를 하나 Clone 하면 Git은 자동으로 ``origin`` 이라는 이름을 붙인다.

``origin`` 으로부터 저장소 데이터를 모두 내려받고 ``master`` 브랜치를 가리키는 포인터를 만든다.

이 포인터는 ``origin/master`` 라고 부르고 멋대로 조종할 수 없다.

그리고 Git은 로컬의 ``master`` 브랜치가 ``origin/master`` 를 가리키게 한다.

이제 이 ``master`` 브랜치에서 작업을 시작할 수 있다.

![Clone 이후 서버와 로컬의 master 브랜치](https://git-scm.com/book/en/v2/images/remote-branches-1.png)



로컬 저장소에서 어떤 작업을 하고 있는데 동시에 다른 팀원이 ``git.ourcompany.com`` 서버에 Push 하고 ``master`` 브랜치를 업데이트 한다.

그러면 이제 팀원 간의 히스토리는 서로 달라진다.

서버 저장소로부터 어떤 데이터도 주고받지 않아서 ``origin/master`` 포인터는 그대로다.

![로컬과 서버의 Commit 히스토리는 독립적임](https://git-scm.com/book/en/v2/images/remote-branches-2.png)



리모트 서버로부터 저장소 정보를 동기화하려면 ``git fetch origin`` 명령을 사용한다.

명령을 실행하면 우선 ``origin`` 서버의 주소 정보(예제에서는 git.ourcompany.com)를 찾아서,

현재 로컬의 저장소가 갖고 있지 않은 새로운 정보가 있으면 모두 내려받고, 받은 데이터를 로컬 저장소에 업데이트 하고 나서, ``origin/master`` 포인터의 위치를 최신 Commit으로 이동시킨다.

![git fetch 명령은 리모트 브랜치 정보를 업데이트](https://git-scm.com/book/en/v2/images/remote-branches-3.png)



리모트 저장소를 여러 개 운영하는 상황을 이해할 수 있도록 개발용으로 사용할 Git 저장소를 팀 내부에 하나 추가해 보자.

이 저장소의 주소가 ``git.team1.ourcompany.com`` 이며 ``git remote add`` 명령으로 현재 작업 중인 프로젝트에 팀의 저장소를 추가한다.

이름을 ``teamone`` 으로 짓고 긴 서버 주소 대신 사용한다.

![서버를 리모트 저장소로 추가](https://git-scm.com/book/en/v2/images/remote-branches-4.png)



서버를 추가하고 나면 ``git fetch teamone`` 명령으로 ``teamone`` 서버의 데이터를 내려 받는다.

명령을 실행해도 ``teamone`` 서버의 데이터는 모두 ``origin`` 서버에도 있는 것들이라서 아무것도 내려받지 않는다.

하지만, 이 명령은 리모트 트래킹 브랜치 ``teamone/master`` 가 ``teamone`` 서버의 ``master`` 브랜치가 가리키는 Commit을 가리키게 한다.

![teamone/master의 리모트 트래킹 브랜치](https://git-scm.com/book/en/v2/images/remote-branches-5.png)



## Push 하기





## 참고 자료

Pro Git Book: https://git-scm.com/book/ko/v2/%EC%8B%9C%EC%9E%91%ED%95%98%EA%B8%B0-Git-%EA%B8%B0%EC%B4%88

