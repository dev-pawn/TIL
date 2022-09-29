playing = True

a = int(input("Choose a number:\n"))
b = int(input("Choose another one:\n"))
operation = input(
    "Choose an operation:\n    Options are: + , - , * or /.\n    Write 'exit' to finish.\n"
)

# add your code here!

while playing:
    if operation == "+":
        result = a + b
        print(a + b)
    elif operation == "-":
        result = a - b
        print(a - b)
    elif operation == "*":
        result = a * b
        print(a * b)
    elif operation == "/":
        result = a / b
        print(a / b)
    elif operation == "exit":
        playing = False
        break
    else:
        print("ERROR: Wrong operation")

    a = int(input("Choose a number:\n"))
    b = int(input("Choose another one:\n"))
    operation = input(
        "Choose an operation:\n    Options are: + , - , * or /.\n    Write 'exit' to finish.\n"
    )
