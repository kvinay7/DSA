from model.Result import Result
from exception.InputValidationException import InputValidationException


class Service:

    def process(self, numbers):

        if numbers is None or len(numbers) == 0:
            raise InputValidationException(
                "Input list cannot be empty"
            )

        total = sum(numbers)

        average = (
            total / len(numbers)
        )

        return Result(
            total,
            average
        )
