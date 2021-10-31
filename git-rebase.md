# Rebase

Git에서 한 브랜치에서 다른 브랜치로 합치는 방법으로는 두 가지가 있다.

하나는 Merge 이고 다른 하나는 Rebase 다.

Rebase가 무엇인지, 어떻게 사용하는지, 좋은 점은 무엇이고, 어떤 상황에서 사용하고
어떤 상황에서 사용하지 말아야 하는지 알아 본다.



## 목차

- [Rebase의 기초](#rebase의-기초)
- [Rebase 활용](#rebase-활용)
- [Rebase의 위험성](#rebase의-위험성)



## Rebase의 기초

두 개의 브랜치로 나누어진 Commit 히스토리를 살펴보자

![](https://git-scm.com/book/en/v2/images/basic-rebase-1.png)

이 두 브랜치를 합치는 가장 쉬운 방법은 앞에서 살펴본 것처럼 ``Merge`` 명령을 사용하는 것이다.

두 브랜치의 마지막 Commit 두 개 (``C3``, ``C4``)와 공통 조상(``C2``)을 사용하는
3-way Merge로 새로운 Commit을 만들어 낸다.

![나뉜 브랜치를 Merge 하기](https://git-scm.com/book/en/v2/images/basic-rebase-2.png)

비슷한 결과를 만드는 다른 방식으로, ``C3`` 에서 변경된 사항을 Patch로 만들고 이를 다시 ``C4``에 적용시키는 방법이 있다. Git에서는 이런 방식을 ``Rebase`` 라고 한다. ``rebase`` 명령으로 한 브랜치에서 변경된 사항을 다른 브랜치에 적용할 수 있다.

위의 예제는 아래와 같은 명령으로 Rebase 한다.

```
$ git checkout experiment
$ git rebase master
First, rewinding head to replay your work on top of it...
Applying: added staged command
```

실제로 일어나는 일을 설명하자면 일단 두 브랜치가 나뉘기 전엔 공통 Commit으로 이동하고 나서 그 Commit부터 지금 Checkout 한 브랜치가 가리키는 Commit까지 diff를 차례로 만들어 어딘가에 임시로 저장해 놓는다.

Rebase 할 브랜치(역주 - esperiment)가 합칠 브랜치(역주 - master)가 가리키는 Commit을 가리키게 하고 아까 저장해 놓았던 변경사항을 차례대로 적용한다.

!['C4'의 변경사항을 'C3'에 적용하는 Rebase 과정](https://git-scm.com/book/en/v2/images/basic-rebase-3.png)

그리고 나서 ``master`` 브랜치를 Fast-forward 시킨다.

```
$ git checkout master
$ git merge experiment
```



![master 브랜치를 Fast-forward시키기](https://git-scm.com/book/en/v2/images/basic-rebase-4.png)

``C4``로 표시된 Commit에서의 내용은 제일 상단의 예제에서 살펴본 ``C5`` Commit에서의 내용과 같을 것이다.

Merge 든 Rebase 든 둘 다 합치는 관점에서는 서로 다를 게 없다.

하지만, Rebase가 좀 더 깨끗한 히스토리를 만든다.

Rebase한 브랜치의 Log를 살펴보면 히스토리가 선형이다.

일을 병렬로 동시에 진행해도 Rebase하고 나면 모든 작업이 차례대로 수행된 것처럼 보인다.



Rebase는 보통 리모트 브랜치에 Commit을 깔끔하게 적용하고 싶을 때 사용한다.

아마 이렇게 Rebase하는 리모트 브랜치는 직접 관리하는 것이 아니라 그냥 참여하는 브랜치일 것이다.

메인 프로젝트에 Patch를 보낼 준비가 되면 하는 것이 Rebase 니까 브랜치에서 하던 일을 완전히 마치고

``origin/master`` 로 Rebase 한다. 이렇게 Rebase 하고 나면 프로젝트 관리자는 어떠한 통합작업도 필요 없다.

그냥 master 브랜치를 Fast-forward 시키면 된다.



Rebase를 하든지, Merge를 하든지 최종 결과물은 같고 Commit 히스토리만 다르다는 것이 중요하다.

Rebase의 경우는 브랜치의 변경사항을 순서대로 다른 브랜치에 적용하면서 합치고,

Merge의 경우는 두 브랜치의 최종결과만을 가지고 합친다.



## Rebase 활용

Rebase는 단순히 브랜치를 합치는 것만 아니라 다른 용도로도 사용할 수 있다.

다른 토픽 브랜치에서 갈라져 나온 토픽 브랜치 같은 히스토리가 있다고 하자.

``server`` 브랜치를 만들어서 서버 기능을 추가하고 그 브랜치에서 다시 ``client`` 브랜치를 만들어 클라이언트 기능을 추가한다.

마지막으로 ``server`` 브랜치로 돌아가서 몇 가지 기능을 더 추가한다.

![다른 토픽 브랜치에서 갈라져 나온 토픽 브랜치](https://git-scm.com/book/en/v2/images/interesting-rebase-1.png)

이때 테스트가 덜 된 ``server`` 브랜치는 그대로 두고 ``client`` 브랜치만 ``master`` 로 합치려는 상황을 생각해보자.

``server`` 와는 아무 관련이 없는 ``client`` Commit은 ``C8`` , ``C9`` 이다.

이 두 Commit을 ``master`` 브랜치에 적용하기 위해서 ``--onto`` 옵션을 사용하여 아래와 같은 명령을 실행한다.

```
$ git rebase --onto master server client
```

이 명령은 ``master`` 브랜치부터 ``server`` 브랜치와 ``client`` 브랜치의 공통 조상까지의 Commit을 ``client`` 브랜치에서 없애고 싶을 때 사용한다.

``client`` 브랜치에서만 변경된 패치를 만들어 ``master`` 브랜치에서 ``client`` 브랜치를 기반으로 새로 만들어 적용한다.

조금 복잡하긴 해도 꽤 쓸모 있다.

![다른 토픽 브랜치에서 갈려져 나온 토픽 브랜치를 Rebase 하기](https://git-scm.com/book/en/v2/images/interesting-rebase-2.png)



이제 ``master`` 브랜치로 돌아가서 Fast-forward 시킬 수 있다.

```
$ git checkout master
$ git merge client
```

![master 브랜치를 client 브랜치 위치로 진행 시키기](https://git-scm.com/book/en/v2/images/interesting-rebase-3.png)

``server`` 브랜치의 일이 다 끝나면 ``git rebase <basebranch> <topicbranch>`` 라는 명령으로 Checkout 하지 않고 바로 ``server`` 브랜치를 ``master`` 브랜치로 Rebase 할 수 있다.

이 명령은 토픽(server) 브랜치를 Checkout 하고 베이스(master) 브랜치에 Rebase한다.

```
$ git rebase master server
```

``server`` 브랜치의 수정사항을 ``master`` 브랜치에 적용했다.

그 결과는아래 그림과 같다.

![master 브랜치에 server 브랜치의 수정 사항을 적용](https://git-scm.com/book/en/v2/images/interesting-rebase-4.png)

그리고 나서 ``master`` 브랜치를 Fast-forward 시킨다.

```
$ git checkout master
$ git merge server
```



모든 것이 ``master`` 브랜치에 통합됐기 때문에 더 필요하지 않다면 ``client`` 나 ``server``  브랜치는 삭제해도 된다.

브랜치를 삭제해도 Commit 히스토리는 최종 Commit 히스토리 같이 여전히 남아 있다.

```
$ git branch -d client
$ git branch -d server
```

![최종 Commit 히스토리](https://git-scm.com/book/en/v2/images/interesting-rebase-5.png)



## Rebase의 위험성



## 참고 자료

Pro Git Book: https://git-scm.com/book/ko/v2/%EC%8B%9C%EC%9E%91%ED%95%98%EA%B8%B0-Git-%EA%B8%B0%EC%B4%88

