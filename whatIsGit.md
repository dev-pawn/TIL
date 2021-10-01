# Git



## 목차

- [들어가며](#들어가며)
- [Git 이란?](#git-이란)
- [Git 기초](#git-기초)
- [Git 저장소 만들기](#git-저장소-만들기)
- [수정하고 저장소에 저장하기](#수정하고-저장소에-저장하기)
- [파일의 상태 확인하기](#파일의-상태-확인하기)
- [READ ME 파일 만들기](#read-me-파일-만들기)
- [파일을 새로 추적하기](#파일을-새로-추적하기)
- [Modified 상태의 파일을 Stage 하기](#modified-상태의-파일을-stage-하기)
- [Short Status](#short-status)
- [Ignoring Files](#ignoring-files)
- [Staged와 Unstaged 상태의 변경 내용을 보기](#staged와-unstaged-상태의-변경-내용을-보기)
- [변경사항 커밋하기](#변경사항-커밋하기)
- [Skipping the Staging Area](#skipping-the-staging-area)
- [파일 삭제하기](#파일-삭제하기)
- [파일 이름 변경하기](#파일-이름-변경하기)

## 들어가며

깃허브 데스크롭을 이용해 클론 코딩을 하던중 깃과 깃허브에 대한 공부가 필요함을 느꼈다.

깃이 무엇인지 깃허브은 무엇인지 commit과 fetch, branch, repository에 대한 원리와 개념을

조금 더 심도있게 알아보자.



## Git 이란?

2002년에 Linux 커널에선 Bitkeeper라고 불리는 상용 *DVCS를 사용하기 시작했다.

2005년 Bitkeeper가 유료화 되면서 Git이 탄생하게 되었다.

Git은 Bitkeeper에서 얻은 교훈을 기반으로

+ 빠른속도
+ 단순한구조
+ 완벽한분산
+ 비선형적인개발(수천개의 동시 다발적인 branch)
+ Linux 커널 같은 대형 프로젝트에도 유용할 것(속도나 데이터 크기 면에서)

위와 같은 목표를 세웠으며 지금 현재까지 그 목표를 유지하고 있다.

***DVCS** (Distributed Version Control Systems ) 즉, 분산 버전 관리 입니다. 사전적 설명으로는 중앙 서버에 있는 코드를 개발자 각자의 로컬 컴퓨터에 복사한 후, 복사된 프로젝트를 가지고 작업하며 서버에 업로드를 할 수있습니다.

## Git 기초

### 차이점

다른 VCS와 Git의 가장 큰 차이점은 데이터를 다루는 방법에 있다.

큰 틀에서 봤을때 VCS 시스템의 대부분은 관리하는 정보가 파일들의 목록이다.

각 파일의 변화를 시간순으로 관리하면서 파일들의 집합을 관리한다.(일반적으로 델타 기반 VCS라고함)

![그림4](https://git-scm.com/book/en/v2/images/deltas.png)

Git은 이런식으로 데이터를 저장하지도 취급하지도 않는다.

대신 Git은 데이터를 파일 시스템 스냅샷의 연속으로 취급하고 크기가 아주 작다.

Git은 commit하거나 프로젝트의 상태를 저장할 때마다 파일이 존재하는 그 순간을 중요하게 여긴다.

파일의 변화가 없으면 Git은 성능을 위해 파일을 새로 저장하지 않는다. 단지 이전 파일에 대한 링크만 저장한다.

Git은 데이터를 __스냅샷의 스트림__ 처럼 취급한다.

![그림5](https://git-scm.com/book/en/v2/images/snapshots.png)



### Nearly Every Operation Is Local

Git의 대부분의 작업은 로컬 파일과 리소스만 있으면 작동한다.

로컬 디스크에 프로젝트의 전체 기록이 있기 때문에 대부분의 명령은 순식간에 실행된다.



### Git Has Integrity

Git은 데이터를 저장하기전에 항상 체크섬을 구하고 그 체크섬으로 데이터를 관리한다.

이것은 Git 없이는 파일이나 디렉토리의 내용을 변경하는 것이 불가능하다는 것을 의미한다.

Git은 SHA-1 해시를 사용해서 체크섬을 만든다.

체크섬은 40자길이의 16진수 문자열로 Git의 파일또는 디렉토리 구조의 내용을 기반으로 생성된다.

Git은 모든 것을 해시로 식별하기 때문에 다양한 곳에서 해시 값을 볼 수 있으며

Git은 파일을 파일의 이름으로 저장하지 않고 해당 파일의 해시 값으로 저장한다.



### Git Generally Only Adds Data

Git으로 어떤 행동을 하던 Git 데이터베이스에 데이터가 ADD된다.

되돌리거나, 삭제할 방법이 없다.

스냅샷이 커밋된 뒤에는 데이터를 잃어버리기도 어렵다.



### The Three States

Git은 파일을 Committed, Modified, Staged 이렇게 세가지 상태로 관리한다.

- Committed란 데이터가 로컬 데이터베이스에 안전하게 저장되었다는 것을 의미한다.
- Modified는 수정한 파일을 아직 로컬 데이터베이스에 커밋하지 않은 것을 말한다.
- Staged란 현재 수정한 파일을 곧 커밋할 것이라고 표시한 상태를 의미한다.

이 세가지 상태는 Git 프로젝트의 세가지 단계와 연결되어 있다. Git 디렉토리(Repository), Staging Area, Working Directory 이렇게 세가지 단계를 이해하고 넘어가자.

![워킹트리](https://git-scm.com/book/en/v2/images/areas.png)

워킹 트리는 프로젝트의 특정 버전을 Checkout한 것이다. Git 디렉토리(Repository)는 현재 작업하는 디스크에 있고 거기에 압축된 데이터베이스에서 파일을 가져와서 워킹트리를 만든다.

Git 디렉토리(Repository)는 Git이 프로젝트의 메타데이터와 객체 데이터베이스를 저장하는 곳을 말한다. 이 디렉토리가 Git의 핵심이다. 다른 컴퓨터에서 Repository를 Clone 할때 복제되는 부분이다.

Staging Area는 Git 디렉토리에 있다. 단순한 파일이고 곧 Commit할 파일에 대한 정보를 저장한다.

Git에서는 기술용어로 Index라고한다.



Git에서 하는 일은

1. 워킹트리에서 파일을 수정한다.
2. Staging Area에 파일을 Stage해서 Commit할 스냅샷을 만든다. 모든 파일을 추가 할 수도 있고 특정 파일만 선택하여 추가 할 수도 있다.
3. Staging Area에 있는 파일들을 커밋하여 Git 디렉토리(Repository)에 영구적인 스냅샷으로 저장한다.

Repository에 있는 파일들은 Commited 상태,

파일을 수정하고 Staging Area에 추가했다면 Staged상태,

아직 Staging Area에 추가하지 않았다면 Modified 상태이다.



## Git 저장소 만들기

- 기존 디렉토리를 Git 저장소로 만들기

프로젝트의 디렉토리로 이동한다.

```
$ cd /c/user/my_project
```

아래와 같은 명령을 실행한다.

```
$ git init
```

이 명령은 .git 이라는 하위 디렉토리를 만든다.

.git 디렉토리에는 저장소에 필요한 뼈대파일이 들어 있다.

이 명령만으로는 아직 프로젝트의 어떠한 파일도 관리하지 않는다.

- 기존 저장소를 Clone 하기

아래와 같은 명령으로 저장소를 Clone한다.

```
$ git clone <url>
```

예) libgit2 라이브러리 소스 코드를 Clone하려면 아래와 같이 실행한다.

```
$ git clone https://github.com/libgit2/libgit2
```

이 명령은 libgit2라는 디렉토리를 만들고 그 안에 .git 디렉토리를 만든다.

그리고 저장소의 데이터를 모두 가져와서 자동으로 가장 최신버전을 Checkout 해놓는다.

```
$ git clone https://github.com/libgit2/libgit2 mylibgit
```

만약 위와 같이 명령어를 실행하면 디렉토리 이름을 mylibgit으로 소스코드를 Clone 할 수 있다.



## 수정하고 저장소에 저장하기

파일의 라이프 사이클

![파일의 라이프사이클](https://git-scm.com/book/en/v2/images/lifecycle.png)

워킹 디렉토리의 모든 파일은 크게 Tracked, Untracked로 나눈다.

Tracked 파일은 이미 스냅샷에 포함되어 있던 파일이다.

Tracked 파일은 이미 Unmodified, Modified, Staged 상태 중 하나이다.

Untracked 파일은 스냅샷에도 Staging Area에도 포함되지 않은 파일이다.

처음 저장소를 Clone하면 모든 파일은 Tracked이면서 Unmodified 상태이다. 파일을 Checkout하고 나서 아무것도 수정하지 않았기 때문이다.

마지막 커밋 이후 Unmodified 상태에서 어떤 파일을 수정하면 Git은 그 파일을 Modified 상태로 인식한다.

Modified 파일을 Staged 상태로 만들고, Staged 상태의 파일을 Commit한다.



## 파일의 상태 확인하기

파일의 상태를 확인하기 위해선 아래와 같은 명령어를 실행한다.

```
$ git status
```

Clone한 후에 바로 이 명령을 실행하면 아래와 같은 메세지를 볼 수 있다.

```
$ git status
On branch master
Your branch is up-to-date with 'origin/master'.
nothing to commit, working directory clean
```

위의 내용은 파일을 하나도 수정하지 않았다는 것을 말해준다.

Tracked 파일들은 하나도 수정되 지않았다는 의미히다.

Untracked 파일은 아직 없어서 목록에 나타나지 않는다.

기본 브랜치가 master이기 때문에 현재 브랜치 이름이 'master'로 나온다.



## READ ME 파일 만들기

```
$ echo 'My Project' > README
$ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Untracked files:
  (use "git add <file>..." to include in what will be committed)

    README

nothing added to commit but untracked files present (use "git add" to track)
```

`README` 파일은 Untracked files 부분에 속해 있는데 이것은 아직 `README`파일이 Untracked 상태라는 것을 말한다.

Git은 Untracked 파일을 아직 스냅샷(커밋)에 넣어지지 않은 파일이라고 본다.

파일이 Tracked 상태가 되기 전까지는 Git을 절대 그 파일을 커밋하지 않는다.



## 파일을 새로 추적하기

파일을 Tracked 상태로 바꾸기 위해선 아래와 같은 명령어를 사용한다.

```
$ git add
```

`README`파일을 추적해보자

```
$ git add README

$ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

    new file:   README
```

`git status`명령을 다시 실행하면 README 파일이 Tracked 상태이면서 커밋에 추가될 Staged 상태라는 것을 확인할 수 있다.

```
Changes to be committed:
```

에 들어있는 파일은 Staged 상태라는것을 의미한다.

Commit 하면 `git add`를 실행한 시점이 파일이 Commit 되어 저장소 히스토리에 남는다.

`git add`명령은 파일 또는 디렉토리의 경로를 인수 값으로 받는다.

디렉토리면 하위파일 모두를 재귀적으로 추가한다.



## Modified 상태의 파일을 Stage 하기

Modified 상태의 파일을 Staged 상태로 바꾸기 위해선 아래와 같은 명령어를 사용한다.

```
$ git add
```

이미 Tracked 상태인 파일을 수정하는 법을 알아보자. `CONTRIBUTING.md`라는 파일을 수정하고

 `git status`명령을 다시 실행하면 결과는 아래와 같다.

```
$ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

    new file:   README

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git checkout -- <file>..." to discard changes in working directory)

    modified:   CONTRIBUTING.md
```

`CONTRIBUTING.md` 파일은 `Changes not staged for commit:` 에 있다.

이것은 수정한 파일이 Tracked 상태이지만 아직 Staged 상태는 아니라는 것이다.

Staged 상태로 만들기 위해선 `git add` 명령어를 사용해야한다.

`git add`명령은 파일을 Tracked 할때도 사용하고 Modified 상태의 파일을 Staged 상태로 만들때도 사용한다.

add의 의미는 프로젝트에 파일을 추가한다기보단 다음 Commit에 추가한다고 받아들이는게 좋다.

 `git add` 명령을 사용하여 파일을 Staged 상태로 만들어보자.

```
$ git add CONTRIBUTING.md
$ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

    new file:   README
    modified:   CONTRIBUTING.md
```

두 파일(README, CONTRIBUTING.md) 모두 Staged 상태이므로 다음 Commit에 포함된다.

만약 이 상황에서 `CONTRIBUTING.md`파일을 열고 수정하게 된다면 어떻게 될까?

```
$ vim CONTRIBUTING.md
$ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

    new file:   README
    modified:   CONTRIBUTING.md

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git checkout -- <file>..." to discard changes in working directory)

    modified:   CONTRIBUTING.md
```

`CONTRIBUTING.md` 가 Staged 인 동시에 Unstaged 상태로 나온다.

이런 일이 발생하는 이유는 `git add`명령을 실행하면 Git은 파일을 바로 Staged 상태로 만든다.

이 시점에서 커밋을 하면 `git coomit`명령을 실행하는 순간의 버전이 Commit되는 것이 아니라

`git add`명령을 실행했을때의 버전이 Commit된다.

그러므로 `git add`명령을 실행한후에 파일을 수정했다면

`git add`명령을 다시 실행하여 최신 버전을 Staged 상태로 만들어야한다.



## Short Status

`git status`명령으로 보여지는 내용을 좀 더 간단하게 보기 위해선 아래의 명령어를 사용한다.

```
$ git status -s
```

```
$ git status -short
```

이 옵션은 현재 변경한 상태를 짤막하게 보여준다.

```
$ git status -s
 M README
MM Rakefile
A  lib/git.rb
M  lib/simplegit.rb
?? LICENSE.txt
```

위 명령의 결과에서 상태정보 컬럼에는 두가지 정보를 보여준다.

왼쪽에는 Staging Area의 상태를, 오른쪽에는 Working Tree에서의 상태를 표시한다.

`README` 파일 같은 경우 내용을 변경했지만(Modified) 아직 Staged 상태로 추가하지는 않았다.

`lib/simplegit.rb`파일은 내용을 변경하고(Modified) Staged 상태로 추가까지 한 상태이다.

`Rakefile` 파일은 변경하고(Modified) Staged 상태로 추가한 후 또 내용을 변경해서(Modified)

Staged이면서 Unstaged 상태인 파일이다.

`lib/git.rb` 파일은 새로 생성한 파일을 Staged에 추가한 상태이다.

Untracked 상태인 새 파일 앞에는 `??`표시가 붙는다.



## Ignoring Files

특정 파일은 Git이 관리할 필요가 없다.

보통 로그파일이나 빌드 시스템이 자동으로 생성한 파일이 해당된다.

그런 파일들을 무시하려면 `.gitignore` 파일을 만들고 그 안에 무시할 파일 패턴을 작성한다.

작성 예시

```
$ cat .gitignore
*.[oa]
*~
```

첫번째 라인은 확장자가 `.o`나 `.a`인 파일을 Git이 무시하라는 것이고

두번째 라인은 `~`로 끝나는 모든 파일을 무시하라는 것이다.

작성 규칙

- 아무것도 없는 라인이나, \`#`으로 시작하는 라인은 무시한다.
- 표준 Glob 패턴을 사용한다. 이는 프로젝트 전체에 적용된다.
- 슬래시(/)로 시작하면 하위 디렉토리에 적용되지 않는다.
- 디렉토리는 슬래시(/)를 끝에 사용하는 것으로 표현한다.
- 느낌표(!)로 시작하는 패턴의 파일은 무시하지 않는다.

작성 예시

```
# 확장자가 .a인 파일 무시
*.a

# 윗 라인에서 확장자가 .a인 파일은 무시하게 했지만 lib.a는 무시하지 않음
!lib.a

# 현재 디렉토리에 있는 TODO파일은 무시하고 subdir/TODO처럼 하위디렉토리에 있는 파일은 무시하지 않음
/TODO

# build/ 디렉토리에 있는 모든 파일은 무시
build/

# doc/notes.txt 파일은 무시하고 doc/server/arch.txt 파일은 무시하지 않음
doc/*.txt

# doc 디렉토리 아래의 모든 .pdf 파일을 무시
doc/**/*.pdf
```



## Staged와 Unstaged 상태의 변경 내용을 보기

단순히 파일이 변경되었다는 사실이 아니라 어떤 내용이 변경되었는지 살펴 보려면

아래와 같은 명령어를 사용한다.

```
$ git diff
```

일반적으로 우리는 'Modified 됐지만, 아직 Staged 파일이 아닌 것'' 과 '어떤 파일이 Staged 상태인지'가 궁금하기 때문에 ``git status`` 명령을 사용한다.

더 자세한 내용을 보고 싶을 때는 ``git diff``명령을 사용하는데 Patch처럼 어떤 라인을 추가했고 삭제했는지 궁금할때 사용한다.

``git diff`` 명령을 실행하면 Modified 했지만 아직 Staged 상태가 아닌 파일을 비교해 볼 수 있다.

```
$ git diff
diff --git a/CONTRIBUTING.md b/CONTRIBUTING.md
index 8ebb991..643e24f 100644
--- a/CONTRIBUTING.md
+++ b/CONTRIBUTING.md
@@ -65,7 +65,8 @@ branch directly, things can get messy.
 Please include a nice description of your changes when you submit your PR;
 if we have to read the whole diff to figure out why you're contributing
 in the first place, you're less likely to get feedback and have your change
-merged in.
+merged in. Also, split your changes into comprehensive chunks if your patch is
+longer than a dozen lines.

 If you are starting to work on a particular area, feel free to submit a PR
 that highlights your work in progress (and note in the PR title that it's
```

이 명령은 워킹 디렉토리에 있는 것과 Staging Area에 있는 것을 비교한다.
즉 Modified  하고 아직 Stage하지 않는 것을 보여준다.

만약 커밋하려고 Staging Area에 넣은 파일의 변경 부분을 보고 싶으면``git diff --staged``옵션을 사용한다.

```
$ git diff --staged
diff --git a/README b/README
new file mode 100644
index 0000000..03902a1
--- /dev/null
+++ b/README
@@ -0,0 +1 @@
+My Project
```

*주의할점은 ``git diff`` 명령은 마지막 커밋후 Modified 된 것들을 전부 보여주지 않는다.

``git diff``는 Unstaged 상태인 것들만 보여준다. 만약 Modified 한 파일을 모두 Staging Area에 넣었다면

``git diff``명령은 아무것도 출력하지 않는다.

## 변경사항 커밋하기

변경사항을 커밋하기 위해선 아래와 같은 명령어를 사용한다.

```
$ git commit
```

Modified 한 것을 Commit 하기 위해 Staging Area에 정리 했다. Unstaged 파일은 Commit 되지 않는다는 것을

기억해야 한다. Git은 생성이나 수정하고 나서 ``git add`` 명령으로 추가하지 않은 파일은 Commit하지 않는다.

``git add``명령으로 추가하지 않은 파일은 여전히 Modified 상태로 남아 있다.

Commit 하기 전에 ``git status``명령으로 모든 것이 Staged 상태인지 확인할 수 있다.

``git commit``을 입력하게 되면 Git 설정에 저장된 편집기가 실행되고, 아래와 같은 텍스트가 자동으로 포함된다.

편집기는 아래와 같은 내용을 표시한다.(아래 예제는 Vim 편집기)

```
# Please enter the commit message for your changes. Lines starting
# with '#' will be ignored, and an empty message aborts the commit.
# On branch master
# Your branch is up-to-date with 'origin/master'.
#
# Changes to be committed:
#	new file:   README
#	modified:   CONTRIBUTING.md
#
~
~
~
".git/COMMIT_EDITMSG" 9L, 283C
```

자동 생성되는 커밋 메시지의 첫 라인은 비어 있고 둘째 라인부터 ``git status`` 명령의 결과가 채워진다.

내용을 저장하고 편집기를 종료하면 Git은 입력된 내용(#으로 시작하는 라인 제외)으로 새 Commit을 하나 완성한다.

``git commit -m`` 옵션을 사용하면 메시지를 인라인으로 첨부할 수도 있다.

```
$ git commit -m "Story 182: Fix benchmarks for speed"
[master 463dc4f] Story 182: Fix benchmarks for speed
 2 files changed, 2 insertions(+)
 create mode 100644 README
```

``commit``명령은 몇 가지 정보를 출력하는데 위 예제는 ``(master)`` branch에 Commit 했고 체크섬은 ``(463dc4f)`` 라고 알려준다. 그리고 수정한 파일이 몇개인지, 삭제되거나 추가된 라인이 몇 라인인지 알려준다.

## Skipping the Staging Area

``git commit`` 명령을 실행할 때 ``-a`` 옵션을 추가하면 Git은 Tracked 상태의 파일을 자동으로 Staging Area에 넣는다.

```
$ git commit -a
```

Staging Area는 Commit 할 파일을 정리한다는 점에서 매우 유용하지만 복잡하기만 하고 필요하지 않는 때도 있다.

```
$ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git checkout -- <file>..." to discard changes in working directory)

    modified:   CONTRIBUTING.md

no changes added to commit (use "git add" and/or "git commit -a")
$ git commit -a -m 'added new benchmarks'
[master 83e38c7] added new benchmarks
 1 file changed, 5 insertions(+), 0 deletions(-)
```

위 예제에서는 ``git add``명령으로 ``CONTRIBUTING.md`` 파일을 추가하지 않았다는 점을 눈여겨보자

``git commit -a`` 옵션을 사용하면 편리하긴 하지만 주의 깊게 사용해야 한다. 생각 없이 이 옵션을 사용하다 보면 추가하지 말아야 할 변경사항도 추가 될 수 있기 때문이다.



## 파일 삭제하기

Git에서 파일을 제거하려면 아래의 명령을 사용한다.

```
$ git rm
```

위 명령을 사용하여 Tracked 상태의 파일을 삭제한 후에(정확히는 Staging Area에서 삭제하는 것이다.)
커밋해야 한다.

이 명령은 워킹 디렉토리에 있는 파일도 삭제하기 때문에 실제 파일도 지워진다.

Git 명령을 사용하지 않고 워킹 디렉토리에서 파일을 삭제하고 ``git status`` 명령으로 상태를 확인하면
Git은 현재 ''Changes not staged for commit"(Unstaged상태)라고 표시해준다.

```
$ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes not staged for commit:
  (use "git add/rm <file>..." to update what will be committed)
  (use "git checkout -- <file>..." to discard changes in working directory)

        deleted:    PROJECTS.md

no changes added to commit (use "git add" and/or "git commit -a")
```

이후 ``git rm`` 명령을 실행하면 삭제한 파일은 Staged 상태가 된다.

```
$ git rm PROJECTS.md
rm 'PROJECTS.md'
$ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

    deleted:    PROJECTS.md
```

이후 Commit하면 파일은 삭제되고 Git은 PROJECTS.md 파일을 더이상 추적하지 않는다.

만약 이미 파일은 Modified 했거나 Staging Area에 추가한 상태라면 ``-f`` 옵션을 주어 강제로 삭제해야한다.

이것은 실수로 데이터를 삭제하지 못하도록 하는 안전장치이다. (Commit하지 않고 Modified 한 데이터는 Git으로 복구 할 수 없기 때문이다.)



또 Staging Area 에서만 제거하고 워킹 디렉토리에 있는 파일은 지우지 않고 남겨 둘 수 있다.
(하드디스크에 있는 파일은 그대로 두고 Git에서 추적하지 않게만 한다.)

``.gitignore``파일에 추가하는 것을 잊었거나 대용량 로그파일이나 컴파일된 파일인 ``.a``파일 같은 것을 실수로 추가했을 때 쓴다.

```
$ git rm --cached README
```



파일, 디렉토리 및 파일 Glob패턴을 ``git rm`` 명령에 전달 할 수 있다.

이 명령은 ``log/`` 디렉토리에 있는 ``.log`` 파일을 모두 삭제한다.

```
$ git rm log/\*.log
```

``*`` 앞에 ``\``를 사용한 것을 기억하자. 파일명 확장 기능은 쉘에만 있는 것이 아니라 Git 자체에도 있기 때문에 필요하다.

아래의 예제처럼 할 수 도 있다.

```
$ git rm \*~
```

이 명령은 이름이 ~로 끝나는 파일을 모두 삭제한다.



## 파일 이름 변경하기

Git에서 파일 이름을 변경하려면 아래와 같은 명령을 사용한다.

```
$ git file_from file_to
```



Git은 다른 VCS 시스템과 달리 파일 이름의 변경이나 파일의 이동을 명시적으로 관리하지 않는다.

다시 말해서 파일 이름이 변경되었다는 별도의 정보를 저장하지 않는다.

Git은 영리해서 굳이 파일 이름이 변경되었다는 것을 추적하지 않아도 아는 방법이 있다.

Git이 파일 이름의 변경을 어떻게 알아내는지 살펴보자.



이렇게 말하고 Git 에 ``mv`` 명령이 있다는게 좀 이상하겠지만, 아래와 같이 파일명을 변경할 수 있다.

```
$ git mv README.md README
```

위 명령을 실행하고 ``git status``를 보면 Git은 이름이 바뀐 사실을 알고 있다.

```
$ git mv README.md README
$ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

    renamed:    README.md -> README
```

사실 ``git mv`` 명령은 아래 명령어를 수행한 것과 완전 동일하다.

```
$ mv README.md README
$ git rm README.md
$ git add README
```

``git mv``명령은 일종의 단축 명령어 이다. ``git mv``명령을 사용해서 파일이름을 바꿔도 되고
``mv`` 명령으로 파일 이름을 직접 바꿔도 된다. 단지 ``git mv`` 명령은 세번의 명령을 한번에 실행시켜주는 것 뿐이다.

어떤 도구로 파일명을 바꿔도 상관없다. 중요한 것은 파일명을 변경하고 나서 꼭 rm/add 명령을 실행해야 한다는 것 뿐이다.



## 참고 자료

Pro Git Book: https://git-scm.com/book/ko/v2/%EC%8B%9C%EC%9E%91%ED%95%98%EA%B8%B0-Git-%EA%B8%B0%EC%B4%88

Glob 패턴 : https://ko.wikipedia.org/wiki/%EA%B8%80%EB%A1%9C%EB%B8%8C_(%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D)
