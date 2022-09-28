# Write your code here:

# 연간 매출 계산
def get_yearly_revenue(monthly_revenue):
    revenus_for_a_year = monthly_revenue * 12
    return (revenus_for_a_year)

# 연간 비용 게산


def get_yearly_expenses(monthly_expenses):
    expenses_for_a_year = monthly_expenses * 12
    return (expenses_for_a_year)

# 세금 계산


def get_tax_amount(profit):
    if profit > 100000:
        tax_amount = profit * 0.25
    else:
        tax_amount = profit * 0.15
    return (tax_amount)

# 세액 공제 적용


def apply_tax_credits(tax_amount, tax_credits):
    amount_to_discount = tax_amount * tax_credits
    return (amount_to_discount)


# Don't touch anthing below this line 🙅🏻‍♂️🙅🏻‍♀️
monthly_revenue = 5500000
monthly_expenses = 2700000
tax_credits = 0.01

profit = get_yearly_revenue(monthly_revenue) - \
    get_yearly_expenses(monthly_expenses)

tax_amount = get_tax_amount(profit)

final_tax_amount = tax_amount - apply_tax_credits(tax_amount, tax_credits)

print(f"Your tax bill is: ${final_tax_amount}")
