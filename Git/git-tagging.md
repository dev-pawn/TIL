## Tag

Git도 태그를 지원한다.

일반적으로 릴리즈할 때 사용된다.

태그를 생성하고 조회하는 방법과 태그의 종류를 알아보자.



## 목차

- [태그 조회하기](#태그-조회하기)
- [태그 붙이기](#태그-붙이기)
- [Annotated 태그](#annotated-태그)
- [Lightweight 태그](#lightweight-태그)
- [나중에 태그하기](#나중에-태그하기)
- [태그 공유하기](#태그-공유하기)
- [태그를 Checkout 하기](#태그를-checkout-하기)
- [참고자료](#참고자료)



## 태그 조회하기

```
$ git tag
```

``git tag`` 명령으로 이미 만들어진 태그가 있는지 확인할 수 있다.

```
$ git tag -l "v1.8.5*"
v1.8.5
v1.8.5-rc0
v1.8.5-rc1
v1.8.5-rc2
v1.8.5-rc3
v1.8.5.1
v1.8.5.2
v1.8.5.3
v1.8.5.4
v1.8.5.5
```

검색 패턴을 사용해서 태그를 검색할 수 있다. 만약 1.8.5 버전의 태그만 검색하고 싶다면 위에 같이 입력한다.

_와일드카드를 사용하여 태그 목록을 검색하는 경우에는 반드시 ``-l`` 또는 ``list`` 옵션을 같이 사용해야 원하는 결과를 얻을 수 있다._



## 태그 붙이기

Git의 태그는 Lightweight 태그와 Annotated 태그의 두 종류가 있다.

Lightweight 태그 : 특정 커밋에 대한 포인터

Annotated 태그 : Git 데이터베이스에 태그를 만든 사람의 이름, 이메일, 작성 날짜, 태그 메세지를 저장한다.
								GPG(GNU Privacy Guard)로 서명할 수도 있다.

일반적으로 Annotated 태그로 만들어 모든 정보를 사용할 수 있도록 하는 것이 좋다.



## Annotated 태그

```
$ git tag -a
```

Annotated 태그를 만드는 방법은 위와 같이 간단하다. ``tag``명령에 ``-a`` 옵션만 추가해주면 된다.

```
$ git tag -a v1.4 -m "my version 1.4"
$ git tag
v0.1
v1.3
v1.4
```

``-m`` 옵션으로 태그를 저장할 때 메시지를 함께 저장할 수 있다.
만약 메시지를 입력하지 않으면 Git은 편집기를 실행시킨다.



```
$ git show
```

``git show`` 명령으로 태그 정보와 커밋 정보를 모두 확인할 수 있다.

```
$ git show v1.4
tag v1.4
Tagger: Ben Straub <ben@straub.cc>
Date:   Sat May 3 20:19:12 2014 -0700

my version 1.4

commit ca82a6dff817ec66f44342007202690a93763949
Author: Scott Chacon <schacon@gee-mail.com>
Date:   Mon Mar 17 21:52:11 2008 -0700

    changed the version number
```

Commit 정보를 보여주기 전에 먼저 태그를 만든 사람, 작성 일시, 태그 메시지를 보여준다.



## Lightweight 태그

```
$ git tag <tag-name>
```

Lightweight 태그는 ``git tag`` 명령에 이름을 붙여줘서 사용한다.

```
$ git tag v1.4-lw
$ git tag
v0.1
v1.3
v1.4
v1.4-lw
v1.5
```

Lightweight 태그는 기본적으로 파일에 Commit 체크섬을 저장하는것 뿐이다. 다른 정보는 저장하지 않는다.

```
$ git show v1.4-lw
commit ca82a6dff817ec66f44342007202690a93763949
Author: Scott Chacon <schacon@gee-mail.com>
Date:   Mon Mar 17 21:52:11 2008 -0700

    changed the version number
```

이 태그에 ``git show`` 를 실행하면 별도의 태그 정보를 확인 할 수 없다.

이 명령은 단순히 Commit 정보만을 보여준다.



## 나중에 태그하기

```
$ git tag -a <tag-name> <checksum>
```

예전 커밋에 대해서도 태그할 수 있다.

```
$ git log --pretty=oneline
15027957951b64cf874c3557a0f3547bd83b3ff6 Merge branch 'experiment'
a6b4c97498bd301d84096da251c98a07c7723e65 beginning write support
0d52aaab4479697da7686c15f77a3d64d9165190 one more thing
6d52a271eda8725415634dd79daabbc4d9b6008e Merge branch 'experiment'
0b7434d86859cc7b8c3d5e1dddfed66ff742fcbc added a commit function
4682c3261057305bdd616e23b64b0857d832627b added a todo file
166ae0c4d3f420721acbb115cc33848dfcc2121a started write support
9fceb02d0ae598e95dc970b74767f19372d61af8 updated rakefile
964f16d36dfccde844893cac5b347e7b3d44abbc commit the todo
8a5cbc430f1a9c3d00faaeffd07798508422908a updated readme
```

Commit 히스토리가 위와 같다고 할때 ``updated rakefile`` 커밋을 v1.2로 태그하지 못했다고 하더라도

나중에 태그를 붙일 수 있다.

특정 Commit에 태그하기 위해서 명령의 끝에 Commit 체크섬을 명시한다.(체크섬을 전부 사용할 필요는 없다.)

`` $ git tag -a v1.2 9fceb02``

이제 만든 태그를 확인해보자

```
$ git tag
v0.1
v1.2
v1.3
v1.4
v1.4-lw
v1.5

$ git show v1.2
tag v1.2
Tagger: Scott Chacon <schacon@gee-mail.com>
Date:   Mon Feb 9 15:32:16 2009 -0800

version 1.2
commit 9fceb02d0ae598e95dc970b74767f19372d61af8
Author: Magnus Chacon <mchacon@gee-mail.com>
Date:   Sun Apr 27 20:43:35 2008 -0700

    updated rakefile
...
```



## 태그 공유하기



``git push`` 명령은 자동으로 리모트 서버에 태그를 전송하지 않는다.

태그를 만들었으면 서버에 별도로 ``push`` 해야한다.

브랜치를 공유하는 것과 같은 방법으로 할 수 있다. 

``git push origin <tag-name>``을 실행한다.

```
$ git push origin v1.5
Counting objects: 14, done.
Delta compression using up to 8 threads.
Compressing objects: 100% (12/12), done.
Writing objects: 100% (14/14), 2.05 KiB | 0 bytes/s, done.
Total 14 (delta 3), reused 0 (delta 0)
To git@github.com:schacon/simplegit.git
 * [new tag]         v1.5 -> v1.5
```

만약 한 번에 태그를 여러 개 Push 하고 싶으면 ``--tags`` 옵션을 추가하여 ``git push`` 명령을 실행한다.

이 명령으로 리모트 서버에 없는 태그를 모두 전송할 수 있다.

```
$ git push origin --tags
Counting objects: 1, done.
Writing objects: 100% (1/1), 160 bytes | 0 bytes/s, done.
Total 1 (delta 0), reused 0 (delta 0)
To git@github.com:schacon/simplegit.git
 * [new tag]         v1.4 -> v1.4
 * [new tag]         v1.4-lw -> v1.4-lw
```



## 태그를 Checkout 하기

예를 들어 태그가 특정 버전을 가리키고 있고, 특정 버전의 파일을 체크아웃해서 확인하고 싶다면 다음과 같이 실행한다.

```
$ git checkout 2.0.0
Note: checking out '2.0.0'.

You are in 'detached HEAD' state. You can look around, make experimental
changes and commit them, and you can discard any commits you make in this
state without impacting any branches by performing another checkout.

If you want to create a new branch to retain commits you create, you may
do so (now or later) by using -b with the checkout command again. Example:

  git checkout -b <new-branch>

HEAD is now at 99ada87... Merge pull request #89 from schacon/appendix-final

$ git checkout 2.0-beta-0.1
Previous HEAD position was 99ada87... Merge pull request #89 from schacon/appendix-final
HEAD is now at df3f601... add atlas.json and cover image
```

단 브랜치가 아닌 태그를 체크아웃하면 ``Detached HEAD`` 상태가 된다.

``Detached HEAD`` 상태에서는 작업을 하고 Commit을 만들면, 태그는 그대로 있으나 새로운 Commit이 하나 쌓인

상태가 되고 새 Commit에 도달할 수 있는 방법이 따로 없게 된다.

물론 Commit의 해시값을 정확히 기억하고 있으면 가능하긴 하다.

특정 태그의 상태에서 새로 작성한 Commit이 버그 픽스와 같이 의미있도록 하려면 __반드시 브랜치를 만들어서 작업하는 것이 좋다.__

```
$ git checkout -b version2 v2.0.0
Switched to a new branch 'version2'
```

물론 이렇게 브랜치를 만든 후에 ``version2`` 브랜치에 Commit하면 브랜치는 업데이트 된다.

하지만 ``v2.0.0``이 가리키는 Commit이 변하지 않았으므로 두 내용이 가리키는 Commit이 다르다는 것을 알 수 있다.



[Detached HEAD란?](#깃의-detached-head)

일반적으로 브랜치는 특정 Commit의 ``revision number``를 가리키고 HEAD가 이 브랜치를 가리킨다.

이처럼 HEAD -> 브랜치 -> 특정 Commit 순서로 Commit을 가리키는 상태를 ``attached HEAD 상태`` 라고 한다.

``Detached HEAD`` 는 HEAD -> 특정 Commit 순서로 HEAD가 브랜치를 통해 간접적으로 Commit을 가리키지 않고

직접 Commit을 가리키는 것을 말한다.

깃에서 HEAD는 1개 뿐이고 이 HEAD는 현재 체크아웃한 Commit을 가리킨다.

추가적인 작업을 위해 다른 브랜치를 체크아웃하면 HEAD는 체크아웃한 브랜치로 이동하며

이 때, 이 전 HEAD가 ``Detached HEAD`` 였다면 커밋의 ``revision number``를 모르면 그 전으로 쉽게 돌아갈 수없고

그래프에도 표시되지 않는다.



## 참고 자료

Pro Git Book: https://git-scm.com/book/ko/v2/%EC%8B%9C%EC%9E%91%ED%95%98%EA%B8%B0-Git-%EA%B8%B0%EC%B4%88

깃의 Detached HEAD : http://sunphiz.me/wp/archives/2266
