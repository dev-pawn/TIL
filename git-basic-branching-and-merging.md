# 브랜치와 Merge 기초



## 목차

- [Branch의 기초](#branch의-기초)
- [Merge의 기초](#merge의-기초)
- [충돌의 기초](#충돌의-기초)
- [참고 자료](#참고-자료)



## Branch의 기초

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



이젠 해결해야 할 핫픽스가 생겼을 때를 살펴보자. ``hotfix`` 라는 브랜치를 만들고 새로운 이슈를 해결할 때까지 사용한다.

```
$ git checkout -b hotfix
Switched to a new branch 'hotfix'
$ vim index.html
$ git commit -a -m 'fixed the broken email address'
[hotfix 1fb7853] fixed the broken email address
 1 file changed, 2 insertions(+)
```

![``master`` 브랜치에서 갈라져 나온 ``hotfix`` 브랜치](https://git-scm.com/book/en/v2/images/basic-branching-4.png)

운영 환경에 적용하려면 문제가 고쳐졌는지 테스트하고 최정적으로 운영환경에 배포하기 위해

``hotfix`` 브랜치를 ``master`` 브랜치에 합쳐야한다.

``git merge`` 명령으로 아래와 같이 한다.

```
$ git checkout master
$ git merge hotfix
Updating f42c576..3a0874c
Fast-forward
 index.html | 2 ++
 1 file changed, 2 insertions(+)
```

Merge 메세지에서 ``Fast-forward``가 보이는가.

``hotfix`` 브랜치가 가리키는 C4 Commit이 C2 Commit에 기반한 브랜치이기 때문에

브랜치 포인터는 Merge 과정 없이 그저 최신 Commit으로 이동한다.

이런 Merge 방식을 ``Fast forward``라고 부른다.

![Merge 후 ``hotfix``와 같은 것을 가리키는 ``master`` 브랜치](https://git-scm.com/book/en/v2/images/basic-branching-5.png)

급한 문제를 해결하고 ``master``브랜치에 적용하고 나면 다시 일하던 브랜치로 돌아가야 한다.

이제 더 이상 필요 없는 ``hotfix`` 브랜치는 삭제한다.

``git branch`` 명령에 ``-d`` 옵션을 줘서 브랜치를 삭제한다.

```
$ git branch -d hotfix
Deleted branch hotfix (3a0874c).
```

자 이제 ``iss53`` 을 처리하던 환경으로 되돌아가서 작업을 마무리해보자.

```
$ git checkout iss53
Switched to branch "iss53"
$ vim index.html
$ git commit -a -m 'finished the new footer [issue 53]'
[iss53 ad82d7a] finished the new footer [issue 53]
1 file changed, 1 insertion(+)
```

![``mater``와 별개로 진행하는 ``iss53`` 브랜치](https://git-scm.com/book/en/v2/images/basic-branching-6.png)

위에서 작업한 ``hofix`` 가 ``iss53`` 브랜치에 영향을 끼치치 않는다는 점을 이해하는 것이 중요하다.

``git merge master`` 명령으로 ``master`` 브랜치를 ``iss53`` 브랜치에 Merge하면
``iss53`` 브랜치에 ``hotfix``가 적용된다.

아니면 ``iss53`` 브랜치가 ``master`` 에 Merge 할 수 있는 수준이 될 때까지 기다렸다가 Merge하면
``hotfix``와 ``iss53`` 브랜치가 합쳐진다.



## Merge의 기초

``iss53`` 을 해결하고 ``master`` 브랜치에 Merge 하는 과정을 살펴보자.

위 과정은 앞서 살펴본 ``hotfix`` 브랜치를 Merge 하는 과정과 비슷하다.

``git merge`` 명령으로 합칠 브랜치에서 합쳐질 브랜치를 Merge 하면 된다.

```
$ git checkout master
Switched to branch 'master'
$ git merge iss53
Merge made by the 'recursive' strategy.
index.html |    1 +
1 file changed, 1 insertion(+)
```

``hotfix``를 Merge 했을 때와 메시지가 다른것을 볼 수 있다.

현재 브랜치가 가리키는 Commit이 Merge 할 브랜치의 조상이 아니므로 Git은 ``Fast-forward``로 Merge 하지 않는다.

이 경우에는 Git은 각 브랜치가 가리키는 Commit 두개와 공통 조상 하나를 사용하여 ``3-way Merge``를 한다.

![Commit 3 개를 Merge](https://git-scm.com/book/en/v2/images/basic-merging-1.png)

단순히 브랜치 포인터를 최신 Commit으로 옮기는 것이 아니라
``3-way Merge``의 결과를 별도의 Commit으로 만들고 나서 해당 브랜치가 그 Commit을 가리키도록 이동시킨다.

그래서 이런 Commit은 부모가 여러 개고 Merge Commit이라고 부른다.

![Merge Commit](https://git-scm.com/book/en/v2/images/basic-merging-2.png)

``iss53`` 브랜치를 ``master``에 Merge 하고 나면 더는 ``iss53`` 브랜치가 필요 없다.

다음 명령으로 브랜치를 삭제하고 이슈의 상태를 처리 완료로 표시한다.

```
$ git branch -d iss53
```



## 충돌의 기초



## 참고 자료

Pro Git Book: https://git-scm.com/book/ko/v2/%EC%8B%9C%EC%9E%91%ED%95%98%EA%B8%B0-Git-%EA%B8%B0%EC%B4%88