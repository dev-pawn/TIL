## Working with Remotes

협업을 위해선 리모트 저장소를 관리할 줄 알아야 한다.

리모트 저장소는 인터넷이나 네트워크 어딘가에 있는 저장소를 말하며 여러 개가 존재 할 수 있다.

리모트 저장소를 관리한다는 것은 저장소를 추가, 삭제하는것 뿐만 아니라 브랜치를 관리하고 추적 여부를 관리하는 것을 말한다.

_remote 저장소라도 같은 로컬 시스템 내에 존재 할 수도 있다. remote라는 이름은 반드시 저장소가 네트워크나 인터넷을 통해 멀리 떨어져있어야 한다는 것을 의미하지 않는다._



## 목차

- [Showing Your Remotes](#showing-your-remotes)
- [리모트 저장소 추가하기](#리모트-저장소-추가하기)
- [리모트 저장소를 Pull 하거나 Fetch 하기](#리모트-저장소를-pull-하거나-fetch-하기)
- [리모트 저장소에 Push 하기](#리모트-저장소에-push-하기)
- [Inspecting a Remote](#inspecting-a-remote)
- [리모트 저장소 이름을 바꾸거나 리모트 저장소를 삭제하기](#리모트-저장소-이름을-바꾸거나-리모트-저장소를-삭제하기)



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

```
$ git fetch <remote>
```

이 명령은 로컬에는 없지만, 리모트 저장소에는 있는 데이터를 모두 가져온다.

그렇게되면 리모트 저장소의 모든 브랜치를 로컬에서 접근할 수 있어서 언제든지 Merge를 하거나 내용을 살펴 볼 수 있다.

저장소를 ``Clone``하면 명령은 자동으로 리모트 저장소를 ``origin`` 이라는 이름으로 추가한다.

나중에 ``$ git fetch origin`` 명령을 실행하면 Clone 한 이후에(혹은 마지막으로 가져온 이후에) 수정된 것을 모두 가져온다.

``git fetch`` 명령은 리모트 저장소의 데이터를 모두 로컬로 가져오지만, 자동으로 Merge 하지 않는다.
그래서 당신이 로컬에서 하던 작업을 정리하고 수동으로 Merge 해야한다.

간단하게 ``git pull`` 명령으로 리모트 저장소 브랜치에서 데이터를 가져올 뿐만 아니라 자동으로 브랜치와 Merge 시킬수 있다. 

``git clone`` 명령은 자동으로 로컬의 master 브랜치가 리모트 저장소의 master 브랜치르 추적하도록 한다.

``git pull`` 명령은 Clone 한 서버에서 데이터를 가져오고 그 데이터를 자동으로 현재 작업하는 코드와 Merge한다.



## 리모트 저장소에 Push 하기

```
$ git push <리모트 저장소 이름> <브랜치 이름>
```

프로젝트를 공유하고 싶을 때 Upstream 저장소에 Push 할 수 있다.

```
$ git push origin master
```

위 명령은 master 브랜치를 origin 서버에 Push 한다.

``push`` 명령은 Clone 한 리모트 저장소에 쓰기 권한이 있고, Clone 하고 난 이후 아무도 Upstream 저장소에 Push 하지 않았을 때만 사용할 수 있다. 다시 말해서 Clone 한 사람이 여러 명 있을 때, 다른 사람이 Push 한 이후 Push하려고 하면 Push 할 수 없다.

먼저 다른 사람이 Push 한 것을 가져와서 Merge 한 다음에 다시 Push 할 수 있다.



## Inspecting a Remote

```
$ git remote show <리모트 저장소 이름>
```

이 명령으로 리모트 저장소의 구체적인 정보를 확인 할 수 있다.

```
$ git remote show origin
* remote origin
  Fetch URL: https://github.com/schacon/ticgit
  Push  URL: https://github.com/schacon/ticgit
  HEAD branch: master
  Remote branches:
    master                               tracked
    dev-branch                           tracked
  Local branch configured for 'git pull':
    master merges with remote master
  Local ref configured for 'git push':
    master pushes to master (up to date)
```

``origin`` 으로 실행하면 위에 같은 정보를 볼 수 있다.

리모트 저장소의 URL과 추적하는 브랜치를 출력한다.

이 명령은 ``git pull`` 명령을 실행할 때 master 브랜치와 Merge 할 브랜치가 무엇인지 보여준다.

-> ``Local branch configured for 'git pull':    master merges with remote master``

``git pull`` 명령은 리모트 저장소 브랜치의 데이터를 모두 가져오고 나서 Merge 할 것이다.

그리고 가져온 모든 리모트 저장소 정보도 출력한다.



## 리모트 저장소 이름을 바꾸거나 리모트 저장소를 삭제하기

```
$ git remote rename
```

만약 ``pb``를 ``paul``로 변경하고자 한다면 아래와 같이 한다.

```
$ git remote rename pb paul
$ git remote
origin
paul
```

로컬에서 관리하던 리모트 저장소의 브랜치 이름도 바뀐다는 점을 기억하자.

지금까지 ``pb/master`` 로 리모트 저장소 브랜치를 사용했으면

이제는 ``paul/master`` 라고 사용해야 한다.



```
$ git remote remove
$ gir remote rm
```

리모트 저장소를 삭제해야 한다면 ``remove`` 나 ``rm`` 명령을 사용한다.

서버 정보가 바뀌었을 때, 더는 별도의 미러가 필요하지 않을 때, 더는 기여자가 활동하지 않을 때 필요하다.

```
$ git remote remove paul
$ git remote
origin
```

위와 같은 방법으로 리모트 저장소를 삭제하면 해당 리모트 저장소에 관련된 추적 브랜치 정보나 모든 설정 내용도 함께 삭제된다.