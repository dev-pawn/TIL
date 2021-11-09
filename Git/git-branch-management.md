# 브랜치 관리

브랜치를 관리하는 여러가지 명령을 알아보자.



## 목차

- 브랜치 관리
- 참고 자료



## 브랜치 관리

```
$ git branch
```

``git branch`` 명령은 단순히 브랜치를 만들고 삭제하는 것이 아니다.

아무런 옵션 없이 입력하면 브랜치의 목록을 보여준다.

```
$ git branch
  iss53
* master
  testing
```

``*`` 기호가 붙어 있는 ``master`` 브랜치는 현재 Checkout 해서 작업하는 브랜치를 나타낸다.

즉 지금 수정한 내용을 Commit 하면 ``master`` 브랜치에 Commit 되고 포인터가 앞으로 한 단계 나아간다.



```
$ git branch -v
```

``git branch -v`` 명령을 실행하면 브랜치마다 마지막 Commit 메시지도 함께 보여준다.

```
$ git branch -v
  iss53   93b412c fix javascript issue
* master  7a98805 Merge branch 'iss53'
  testing 782fd34 add scott to the author list in the readmes
```



```
$ git branch --merged
```

``--merged`` 와 ``--no-merged`` 옵션을 사용하여 Merge 된 브랜치인지 그렇지 않은지 필터링해 볼 수 있다.

``git branch --merged`` 명령으로 이미 Merge 한 브랜치 목록을 확인한다.

```
$ git branch --merged
  iss53
* master
```

``iss53`` 브랜치는 앞에서 이미 Merge 했기 때문에 목록에 나타난다.

``*`` 기호가 붙어 있지 않은 브랜치는 ``git branch -d`` 명령으로 삭제해도 되는 브랜치이다.

이미 다른 브랜치와 Merge 했기 때문에 삭제해도 정보를 잃지 않는다.

```
$ git branch --no-merged
```

반대로 현재 Checkout 한 브랜치에 Merge 하지 않은 브랜치를 살펴보려면
``git branch --no-merged`` 명령을 사용한다.

```
$ git branch --no-merged
  testing
```

위에는 없었던 다른 브랜치가 보인다. 아직 Merge 하지 않은 Commit을 담고 있기 때문에
``git branch -d`` 명령으로 삭제되지 않는다.

```
$ git branch -d testing
error: The branch 'testing' is not fully merged.
If you are sure you want to delete it, run 'git branch -D testing'.
```

Merge 하지 않은 브랜치를 강제로 삭제하려면 ``-d`` 옵션으로 삭제한다.



_위에서 설명한 ``--merged``, ``no-merged`` 옵션을 사용할 때 Commit이나 브랜치 이름을 지정해주지 않으면 현재 브랜치를 기준으로 Merge 되거나 Merge 되지 않은 내용을 출력한다._

_위 명령을 사용할 때 특정 브랜치를 기준으로 Merge  되거나 혹은 Merge 되지 않은 브랜치 정보를 살펴보려면
명령에 브랜치 이름을 지정해주면 된다._

_예를 들어 ``master`` 브랜치에 아직 Merge되지 않은 브랜치를 살펴보려면 다음과 같은 명령을 실행한다._

```
$ git checkout testing
$ git branch --no-merged master
  topicA
  featureB
```



## 참고 자료

Pro Git Book: https://git-scm.com/book/ko/v2/%EC%8B%9C%EC%9E%91%ED%95%98%EA%B8%B0-Git-%EA%B8%B0%EC%B4%88
