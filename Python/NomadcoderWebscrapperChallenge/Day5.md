## Day 5



## Methods

우리가 배워야 할 데이터 구조에는 Lists, Tuples, Dictionary가 있다.

Method는 데이터에 결합된 function이다.

> 사용 예

```python
name = "Hyun"
print(name.startswith("H"))
print(name.replace("u", "d"))
print(name.capitalize())
```



## Lists

list를 만들땐 []를 사용

method를 이용해 다양하게 list에 접근이 가능함

```python
days_of_week = ["Mon", "Tue", "Wed", "Thur", "Fri"]

print(days_of_week.count("Wed"))	## 리스트에서 Wed의 갯수를 반환
days_of_week.clear()				## 리스트의 아이템들을 삭제
print(days_of_week.reverse())		## 리스트의 아이템들을 반전

days_of_week.append("Sun")			## 리스트에 아이템을 추가

print(days_of_week[0])				## 리스트의 첫 번째 아이템
print(days_of_week[-1])				## 리스트의 뒤에서 첫 번째 아이템
```



## Tuples

tuple을 만들땐 ()를 사용

list와의 차이점은 tuple은 값을 수정할 수 없음(불변)

```python
days = ("Mon","Tue","Wed")

print(days[0])			## 투플의 첫 번째 아이템
print(days[-1])			## 투플의 뒤에서 첫 번째 아이템
```



## Dicts

dict을 만들땐 {}를 사용

dictionary내부엔 다양한 데이터 타입을 동시에 넣을수 있음

dictionary는 key와 value를 한 쌍으로 갖는 자료형

```python
player = {
    'name': 'nico',
    'age' : 12,
    'alive' : True
    'fav_food' : ["Pizza", "Bugger"]
}
print(player.get('age'))			## 딕셔너리의 age의 값을 가져옴
print(player['fav_food'])			## 딕셔너리의 fav_food의 값을 가져옴
player.pop('age')					## 딕셔너리의 age를 삭제
player['xp'] = 1500					## 딕셔너리에 xp : 1500을 추가
player['fav_food'].append("noodle") ## 딕셔너리의 값 fav_food에 noodle을 추가
```

