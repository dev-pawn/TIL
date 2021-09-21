# 깃 커밋 메시지 컨벤션

커밋 메시지 컨벤션 스타일을 미리 정리하여 협업을 준비하고 가독성을 높인다.

## 목차

---

- [들어가며](#들어가며)
- [커밋메시지스타일가이드](#커밋메시지스타일가이드)

## 들어가며

본격적으로 깃허브를 사용하게 되면서 커밋 작성을 표준화된 스타일로 하기 위해 공부하게 되었다.

## 커밋 메세지 스타일 가이드

- 메세지 구조

```sh
type: Subject

body

footer
'''
- 타입
 - feat: 새로운 기능
 - fix: 버그 수정
 - docs: 문서 수정
 - style: 코드 포맷 변경, 세미콜론 누락, 코드 수정이 없는 경우
 - refactor: Refactoring production code
 - test: 테스트추가, 리펙토링 테스트(no production code change)
 - chore: 빌드 테스크 업데이트, 패키지 매니저 설정(no production code change)

```
