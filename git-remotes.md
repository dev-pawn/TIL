## Working with Remotes

협업을 위해선 리모트 저장소를 관리할 줄 알아야 한다.

리모트 저장소는 인터넷이나 네트워크 어딘가에 있는 저장소를 말하며 여러 개가 존재 할 수 있다.

리모트 저장소를 관리한다는 것은 저장소를 추가, 삭제하는것 뿐만 아니라 브랜치를 관리하고 추적 여부를 관리하는 것을 말한다.

*remote 저장소라도 같은 로컬 시스템 내에 존재 할 수도 있다. remote라는 이름은 반드시 저장소가 네트워크나 인터넷을 통해 멀리 떨어져있어야 한다는 것을 의미하지 않는다.



## 목차

- [Showing Your Remotes](#showing-your-remotes)
- [리모트 저장소 추가하기]
- [리모트 저장소를 Pull 하거나 Fetch 하기]
- [리모트 저장소에 Push 하기]
- [Inspecting a Remote]
- [리모트 저장소 이름을 바꾸거나 리모트 저장소를 삭제하기]



## Showing Your Remotes

```
$ git remote
```

``git remote`` 명령으로 현재 프로젝트에 등록된 리모트 저장소를 확인할 수 있다.

이 명령은 리모트 저장소의 단축 이름을 보여준다.

```
$ git clone https://github.com/schacon/ticgit
Cloning into 'ticgit'...
remote: Reusing existing pack: 1857, done.
remote: Total 1857 (delta 0), reused 0 (delta 0)
Receiving objects: 100% (1857/1857), 374.35 KiB | 268.00 KiB/s, done.
Resolving deltas: 100% (772/772), done.
Checking connectivity... done.
$ cd ticgit
$ git remote
origin
```

저장소를 Clone하면 'origin'이라는 리모트 저장소가 자동등록되기 때문에 'origin'이라는 이름을 볼 수있다.

```
$ git remote -v
origin	https://github.com/schacon/ticgit (fetch)
origin	https://github.com/schacon/ticgit (push)
```

``-v`` 옵션을 주어 단축이름과 URL을 함께 볼 수 있다.

```
$ git remote -v
bakkdoor  https://github.com/bakkdoor/grit (fetch)
bakkdoor  https://github.com/bakkdoor/grit (push)
cho45     https://github.com/cho45/grit (fetch)
cho45     https://github.com/cho45/grit (push)
defunkt   https://github.com/defunkt/grit (fetch)
defunkt   https://github.com/defunkt/grit (push)
koke      git://github.com/koke/grit.git (fetch)
koke      git://github.com/koke/grit.git (push)
origin    git@github.com:mojombo/grit.git (fetch)
origin    git@github.com:mojombo/grit.git (push)
```

만약 리모트 저장소가 여러개 있다면 이 명령은 등록된 전부를 보여준다. 여러 사람과 함께 작업하는 리모트 저장소가 여러개라면 위와 같은 결과를 얻을 수 있다.

이렇게 여러개의 리모트 저장소가 등록되어 있다면 다른 사람이 기여한 내용(Contributions)을 쉽게 가져올 수 있다. 어떤 저장소에서는 Push 권한까지 제공하기도 한다.



## 리모트 저장소 추가하기

```
$ git remote add <단축이름> <URL>
```

``git remote add`` 명령으로 기존 워킹 디렉토리에 새 리모트 저장소를 추가한다.

```
$ git remote
origin
$ git remote add pb https://github.com/paulboone/ticgit
$ git remote -v
origin	https://github.com/schacon/ticgit (fetch)
origin	https://github.com/schacon/ticgit (push)
pb	https://github.com/paulboone/ticgit (fetch)
pb	https://github.com/paulboone/ticgit (push)
```

이제 URL 대신에 ``pb`` 라는 이름을 사용할 수 있다.

paulboone의 저장소에 있는 것을 가져와 보자

```
$ git fetch pb
remote: Counting objects: 43, done.
remote: Compressing objects: 100% (36/36), done.
remote: Total 43 (delta 10), reused 31 (delta 5)
Unpacking objects: 100% (43/43), done.
From https://github.com/paulboone/ticgit
 * [new branch]      master     -> pb/master
 * [new branch]      ticgit     -> pb/ticgit
```

로컬에서 ``pb/master``가 paulboone의 master 브랜치이다.



## 리모트 저장소를 Pull 하거나 Fetch 하기



