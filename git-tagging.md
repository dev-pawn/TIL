## Tag

Git도 태그를 지원한다.

일반적으로 릴리즈할 때 사용된다.

태그를 생성하고 조회하는 방법과 태그의 종류를 알아보자.



## 목차

- [태그 조회하기](#태그-조회하기)
- [태그 붙이기](#태그-붙이기)
- [Annotated 태그](#annotated-태그)
- [Lightweight 태그](#lightweight-태그)



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
