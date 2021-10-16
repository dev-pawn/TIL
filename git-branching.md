# Git Branching



## 목차

- [들어가며](#들어가며)
- [브랜치란 무엇인가](#브랜치란-무엇인가)
- [새 브랜치 생성하기](#새-브랜치-생성하기)



## 들어가며

모든 버전 관리 시스템(VCS)은 브랜치(Branch)를 지원한다.

개발을 하다 보면 코드를 여러 개로 복사해야 하는 일이 자주 생긴다.

코드를 통째로 복사하고 나서 원래 코드와는 상관없이 독립적으로 개발을 진행할 수 있는데

이렇게 독립적으로 개발하는것이 브랜치이다.

Git의 브랜치는 매우 가볍다. 순식간에 브랜치를 새로 만들고 브랜치 사이를 이동할 수 있다.

다른 버전 관리 시스템과는 달리 Git은 브랜치를 만들어 작업하고 나중에 Merge 하는 방법을 권장한다.

심지어 하루에 수십번씩해도 괜찮다.



## 브랜치란 무엇인가

Git이 데이터를 저장하는 방식을 알아야 브랜치를 다룰 수 있다.

Git은 데이터를 일련의 스냅샷으로 기록한다는 것을 앞에서 보았다.

Git은 Commit이 일어나는 경우 현 Staging Area에 있는 데이터의 스냅샷에 대한 포인터, 저자나 Commit 메시지 같은 메타 데이터, 이전 Commit에 대한 포인터 등을 포함하는 Commit Object를 저장한다.

이전 Commit에 대한 포인터가 있어서 현재 Commit이 무엇을 기준으로 바뀌었는지를 알 수 있다.

최초 Commit을 제외한 나머지 Commit은 이전 Commit에 대한 포인터가 적어도 하나씩은 있고
브랜치를 합친 Merge Commit 같은 경우에는 이전 Commit 포인터가 여러개 있다.



```
$ git add README test.rb LICENSE
$ git commit -m 'The initial commit of my project'
```

파일이 3개가 있는 디렉토리가 하나 있고 이 파일을 Staging Area에 저장하고 Commit하는 예제를 살펴보자

파일을 Stage 하면 Git 저장소에서 파일을 저장하고(Git은 이것을 Blob이라 부른다)

Staging Area에 해당 파일의 체크섬을 저장한다.(SHA-1을 사용)



``git commit`` 으로 Commit하면 먼저 루트 디렉토리와 각 하위 디렉토리의 트리 개체를 체크섬과 함께 저장소에 저장한다.

그 다음에 Commit Object를 만들고 메타데이터와 루트 디렉토리 트리 개체를 가리키는 포인터 정보를
Commit Object에 넣어 저장한다.

그래서 필요하면 언제든지 스냅샷을 다시 만들 수 있다.



이 작업을 마치고 나면 Git 저장소에는 다섯 개의 데이터 개체가 생긴다.

각 파일에 대한 Blob 세개,

파일과 디렉토리 구조가 들어 있는 트리 개체 하나,

메타데이터와 루트 트리를 가리키는 포인터가 담긴 Commit 개체 하나이다.

![커밋과 트리 데이터](https://git-scm.com/book/en/v2/images/commit-and-tree.png)

다시 파일을 수정하고 Commit하면 이전 Commit이 무엇인지도 저장한다.

![Commit 과 이전 Commit](https://git-scm.com/book/en/v2/images/commits-and-parents.png)



Git 브랜치는 Commit 사이를 가볍게 이동할 수 있는 어떤 포인터 같은 것이다.

기본적으로 Git은 ``master`` 브랜치를 만든다. 처음 Commit하면 이 ``master`` 브랜치가 생성된 Commit을 가리킨다.

이후 Commit을 만들면 ``master`` 브랜치는 자동으로 가장 마지막 Commit을 가리킨다.

![브랜치와 Commit 히스토리](https://git-scm.com/book/en/v2/images/branch-and-history.png)

_Git에서 ``master`` 브랜치는 특별하지 않다. 다른 브랜치와 차이점이 없다.
모든 저장소에서 ``master`` 브랜치가 존재하는 이유는 ``git init`` 명령으로 초기화 할 때
자동으로 생성된 이 브랜치를 굳이 다른 이름으로 변경하지 않기 때문이다._



## 새 브랜치 생성하기

```
$ git branch testing
```

위의 명령을 이용하여 새로운 브랜치를 만들 수 있다.

새로 만들어진 브랜치도 지금 작업하고 있던 마지막 Commit을 가리킨다.

![하나의 Commit 히스토리를 가리키는 두 브랜치](https://git-scm.com/book/en/v2/images/two-branches.png)

지금 작업중인 브랜치가 무엇인지 Git은 어떻게 파악할까.

다른  버전 관리 시스템(VCS)과는 달리 Git은``HEAD`` 라는 특수한 포인터가 있다.

이 포인터는 지금 작업하고 있는 로컬 브랜치를 가리킨다.

브랜치를 새로 만들었지만, Git은 아직 ``master`` 브랜치를 가리키고 있다.

``git branch`` 명령은 브랜치를 만들기만하고 브랜치를 옮기지 않는다.

![현재 작업중인 브랜치를 가리키는 HEAD](https://git-scm.com/book/en/v2/images/head-to-master.png)

```
$ git log --oneline --decorate
f30ab (HEAD -> master, testing) add feature #32 - ability to add new formats to the central interface
34ac2 Fixed bug #1328 - stack overflow under certain conditions
98ca9 The initial commit of my project
```

``git log`` 명령에 ``--decorate`` 옵션을 사용하면 쉽게 브랜치가 가리키는 Commit을 확인 할 수 있다.

``f30ab``라는 Commit옆에 ``master``와``testing`` 이라는 브랜치가 위치하고 있는것을 확인 할 수 있다.



## 현재 작업 중인 브랜치를 가리키는 HEAD

```
$ git checkout testing
```

``git checkout`` 명령으로 다른 브랜치로 이동할 수 있다. 위 명령을 이용해 ``testing`` 브랜치로 이동해보자.

이렇게 하면 ``HEAD`` 는 ``testing`` 브랜치를 가리킨다.

![HEAD는 testing 브랜치를 가리킴](https://git-scm.com/book/en/v2/images/head-to-testing.png)

자 이제 Commit을 한번 해보자.

```
$ vim test.rb
$ git commit -a -m 'made a change'
```

![HEAD가 가리키는 testing 브랜치가 새 Commit을 가리킴](https://git-scm.com/book/en/v2/images/advance-testing.png)

새로 Commit해서 ``testing`` 브랜치는 앞으로 이동했다.

하지만, ``master`` 브랜치는 여전히 이전 Commit을 가리킨다.

``master`` 브랜치로 되돌아가보자.

```
$ git checkout master
```

![HEAD가 Checkout한 브랜치로 이동함](https://git-scm.com/book/en/v2/images/checkout-master.png)

위에서 실행한 명령이 한 일은 두가지이다.

``master`` 브랜치가 가리키는 Commit을 HEAD가 가리키게 하고,
워킹 디렉토리의 파일도 그 시점으로 되돌려 놓았다.

앞으로 Commit을 하면 다른 브랜치의 작업들과 별개로 진행 되기 때문에
``testing`` 브랜치에서 임시로 작업하고
원래``master``브랜치로 돌아와서 하던 일을 계속 할 수 있다.

_브랜치를 이동하면 워킹 디렉토리의 파일이 변경된다. 이전에 작업했던 브랜치로 이동하면 워킹 디렉토리의 파일은 그 브랜치에서 가장 마지막으로 했던 작업 내용으로 변경된다. 파일 변경시 문제가 있어 브랜치를 이동시키는게 불가능한 경우 Git은 브랜치 이동 명령을 수행하지 않는다._

