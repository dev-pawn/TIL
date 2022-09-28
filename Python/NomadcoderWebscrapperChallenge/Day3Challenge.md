# Day 3 Challenge



## 코드 챌린지

- [챌린지 템플릿](#챌린지-템플릿)(클릭!)은 세금 계산기의 코드 입니다. 그러나 코드가 완성되지 않았어요.

- 여러분이 완성해주시면 됩니다!

- 아래와 같은 함수를 생성해주세요.



#### 1. `get_yearly_revenue` (연간 매출 계산)

- `monthly_revenue` (월간 매출) 취하고. revenue for a year (연간 매출)를 리턴.
- takes `monthly_revenue` and returns revenue for a year.

#### 2. `get_yearly_expenses` (연간 비용 계산)

- `monthly_expenses` (월간 비용) 취하고 expenses for a year (연간 비용)를 리턴.
- takes `monthly_expenses` returns expenses for a year.

#### 3. `get_tax_amount` (세금 계산)

- `profit` (이익) 취하고 `tax_amount` (세금 금액) 를 리턴.
- takes `profit` returns `tax_amount`.

#### 4. `apply_tax_credits` (세액 공제 적용)

- `tax_amount` (세금 금액) 그리고 `tax_credits` (세액 공제율) 취하고 amount to discount (할인된 금액)를 리턴.
- takes `tax_amount` and `tax_credits` returns amount to discount.

#### Requirements (요구사항)

- `get_tax_amount` 함수는 `if/else` 를 사용해야한다.
- 만약 (`if`) `profit`이 100,000 초과이면. 세율은 25%가 되어야한다.
- 아닌 경우에는 (`else`). 세율은 15%가 되어야한다.



## 챌린지 템플릿

```python
# Write your code here:

# Don't touch anthing below this line 🙅🏻‍♂️🙅🏻‍♀️

monthly_revenue = 5500000
monthly_expenses = 2700000
tax_credits = 0.01

profit = get_yearly_revenue(monthly_revenue) - get_yearly_expenses(monthly_expenses)

tax_amount = get_tax_amount(profit)

final_tax_amount = tax_amount - apply_tax_credits(tax_amount, tax_credits)

print(f"Your tax bill is: ${final_tax_amount}")
```

