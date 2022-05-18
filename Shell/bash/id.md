# ID

- 개요

  id [user] id -A id -F [user] id -G [-n] [user] id -M id -P [user] id -g [-nr] [user] id -p [user] id -u [-nr] [user]

- 설명

  id 는 유저와 그룹네임 그리고 numeric(숫자) Id들을 표준출력으로 출력하기 위한 유틸리티 입니다.

  실제 아이디(real ID) 및 effective IDs 인 경우 둘다 표시되며, 그렇지 않으면 실제 아이디(real ID)만 표시됩니다.

  사용자(login name or user ID)가 지정된 경우, 해당 사용자의 사용자 및 그룹 ID가 표시됩니다.

  이 경우 실제 ID(real ID)와 유효한 ID(effective ID)는 동일한 것으로 가정합니다.

- 옵션

  - A : 권한이 필요한 프로세스 감사 사용자 ID 및 기타 프로세스 감사 속성을 표시합니다.

  - F : user의 풀네임을 표시합니다.

  - G : 서로 다른 그룹 ID(유효한 그룹 ID(effective), 실제 그룹 ID(real) 및 보충 그룹 ID)를 공백으로 구분된 숫자로 특별한 순서 없이 표시합니다.

  - M : 현재 프로세스의 MAC label을 표시합니다.

  - P : ID를 password file entry로 표시합니다.

  - a : Ignored for compatibility with other id implementations.

  - g : effective group ID를 숫자로 표시합니다.

  - n : 숫자 대신 -G, -g 및 -u 옵션에 대한 user 또는 group ID를 표시합니다. ID 번호를 이름으로 매핑할 수 없는 경우, ID 번호는 평상시와 같이 표시됩니다.

  - P : 출력을 사람이 읽을 수 있도록 합니다. getlogin(2)에서 반환된 사용자 이름이 사용자 ID 에서 참조한 로그인 이름과 다를 경우 getlogin(2)에서 반환된 이름이 ''login'' 키워드 앞에 표시됩니다.사용자 ID 가 ''uid'' 키워드 앞에 이름으로 표시됩니다.

    유효 사용자 ID가 실제 사용자 ID와 다를 경우 실제 사용자 ID 는 'euid' 키워드 앞에 이름으로 표시됩니다.

    유효한 그룹 ID가 실제 그룹 ID와 다를 경우, 실제 그룹 ID는 키워드 'rgid' 앞에 이름으로 표시됩니다.

    그런 다음 사용자가 속한 그룹 목록이 ''groups'' 키워드 앞에 이름으로 표시됩니다. 각 디스플레이는 별도의 라인에 있습니다.

  - r : effective ID 대신 -g 및 -u 옵션의 실제 ID를 표시합니다.

  - u : effective ID를 숫자로 표시합니다.