class Result:

    def __init__(self, total, average):
        self.total = total
        self.average = average

    def __str__(self):
        return (
            f"Sum = {self.total}\n"
            f"Average = {self.average}"
        )
