from logging.Logger import Logger
from service.Service import Service

Logger.info(
    "Application Started"
)

n = int(
    input("Enter number of elements: ")
)

print(
    f"Enter {n} integers:"
)

numbers = []

for _ in range(n):
    numbers.append(
        int(input())
    )

service = Service()

result = service.process(
    numbers
)

print()
print(result)

Logger.info(
    "Application Completed"
)
