import os
import sys

sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))

from logging.Logger import Logger
from service.Service import Service

Logger.info(
    "Execution Started"
)

n = int(input("Enter number of elements: "))

print(
    f"Enter {n} integers:"
)

numbers = []

while len(numbers) < n:
    line = input().strip()
    if not line:
        continue
    parts = line.split()
    for part in parts:
        if len(numbers) >= n:
            break
        numbers.append(int(part))

service = Service()

result = service.process(
    numbers
)

print()
print(result)

Logger.info(
    "Execution Completed"
)
