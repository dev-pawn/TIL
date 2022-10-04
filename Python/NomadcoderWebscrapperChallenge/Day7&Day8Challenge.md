# Day 7 & Day 8 Challenge



## 코드 챌린지

- 오늘의 강의: [Python으로 웹 스크래퍼 만들기: From #5.1 to #5.9](https://nomadcoders.co/python-for-beginners/lectures/3789)
- 오늘의 과제: 위의 강의를 시청하신 후, 아래 코드 챌린지를 제출하면 됩니다.
- 제출기간: 2일 챌린지 입니다. 수요일 오전 6시까지!
- This is a two day challenge.



## Challenge Goals:

- Using Beautiful Soup, build a scrapper to extract the jobs from https://remoteok.com/.
- Here is how the URLs of that website looks like when searching:
- Beautiful Soup 을 사용하여. https://remoteok.com/ 에서 jobs 를 긁어오는 스크래퍼를 만드세요.
- 검색할때 웹사이트의 URL은 아래와 같은 모습이어야 합니다.

https://remoteok.com/remote-rust-jobs https://remoteok.com/remote-golang-jobs https://remoteok.com/remote-python-jobs https://remoteok.com/remote-react-jobs



## 코드 작성

[Day7&Day8Challenge](./Day7&Day8Challenge.py)



## 후기

beautifulsoup가 웹을 어떤 방식으로 저장하고, 리스트의 구조가 어떻고, 딕셔너리 안에 리스트가 들어간 경우는 내부에 리스트를 어떻게 조작하는지 등등의 문제로 상당히 고생한 챌린지이다.  
강의 자체가 일단 만들어보면서 배우는 것에 초점이 맞춰져 있기 때문에 파이썬의 기본적인 여러 이론들을 따로 찾아서 공부하는 시간이 많이 소요됐다.  
또한 크롤링을 위한 타겟 사이트가 pay와 location을 모두 class=location으로 퉁치고 제작되어 있어 고생했다. 해결방법을 여러가지를 찾아보았으나 나중엔 class=location에 pay정보만 있는 경우, location정보3개와 pay가 한번에 있는 경우 등 너무 많은 예외가 발생하여 코드 자체가 난해해졌다.  
좀 더 파이썬에 대한 지식이 쌓이면 꼭 리펙토링 해보고 싶은 코드다.
