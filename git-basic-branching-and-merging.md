# 브랜치와 Merge 기초



## 목차

- [브랜치의 기초](#브랜치의-기초)
- 
- [참고 자료](#참고-자료)



## 브랜치의 기초

현재 작업중인 프로젝트에서 ``master`` 브랜치에 Commit을 몇 번 했다고 가정한다.

![현재 Commit 히스토리](https://git-scm.com/book/en/v2/images/basic-branching-1.png)

만약 이슈 관리 시스템에 등록된 53번 이슈를 처리한다고 가정하면

이 이슈에 집중할 수 있는 브랜치를 새로 하나 만든다.

```
$ git checkout -b iss53
Switched to a new branch "iss53"
```

브랜치를 만들면서 Checkout까지 한 번에 하려면 ``git checkout`` 명령에 ``-b`` 라는 옵션을 추가한다.

위 명령은 밑에 보이는 명령을 한번에 실행한 것과 같다.

```
$ git branch iss53
$ git checkout iss53
```

``iss53`` 브랜치를 Checkout 했기 때문에 (``HEAD``는 ``iss53`` 브랜치를 가리킨다.)

작업을 하고 Commit 하면 ``iss53`` 브랜치가 앞으로 나아간다.

![진행 중인 ``iss53`` 브랜치](https://git-scm.com/book/en/v2/images/basic-branching-3.png)



또 다른 상황을 생각해보자.

사이트에 문제가 생겨서 즉시 고쳐야 한다.

버그를 해결한 Hotfix에 ``iss53``이 섞이는 것을 방지하기 위해 ``iss53`` 과 관련된 코드를 어딘가에 저장해두고

원래 운영 환경의 소스로 복구해야 한다.

Git을 사용하면 이런 노력을 들일 필요 없이 그냥 ``master``브랜치로 돌아가면 된다.

하지만 브랜치를 이동하려면 해야 할 일이 있다.

아직 Commit 하지 않은 파일이 Checkout 할 브랜치와 충돌 나면 브랜치를 변경 할 수 없다.

브랜치를 변경할 때는 워킹 디렉토리를 정리하는 것이 좋다.

작업하던 것을 모두 Commit 하고 ``master`` 브랜치로 옮긴다.

```
$ git checkout master
Switched to branch 'master'
```

이때 워킹 디렉토리는 53번 이슈를 시작하기 이전 모습으로 되돌려지기 때문에
새로운 문제에 집중할 수 있는 환경이 만들어진다.

Git은 자동으로 워킹 디렉토리에 파일들을 추가하고, 지우고, 수정해서
Checkout 한 브랜치의 마지막 스냅샷으로 되돌려 놓는다는 것을 기억해야 한다.

## 참고 자료

Pro Git Book: https://git-scm.com/book/ko/v2/%EC%8B%9C%EC%9E%91%ED%95%98%EA%B8%B0-Git-%EA%B8%B0%EC%B4%88