from service.Service import Service

passed = 0
failed = 0

service = Service()


def run_test(name, test_func):

    global passed, failed

    try:

        result = test_func()

        if result:
            passed += 1
            print(f"{name:<30} PASS")
        else:
            failed += 1
            print(f"{name:<30} FAIL")

    except Exception:
        failed += 1
        print(f"{name:<30} FAIL")


run_test(
    "Normal Input",
    lambda:
    service.process(
        [10,20,30,40,50]
    ).total == 150
)

run_test(
    "Single Element",
    lambda:
    service.process(
        [10]
    ).total == 10
)

run_test(
    "Negative Numbers",
    lambda:
    service.process(
        [-10,-20,-30]
    ).total == -60
)


def empty_input_test():

    try:
        service.process([])
        return False
    except Exception:
        return True


run_test(
    "Empty Input",
    empty_input_test
)

print()
print(f"Total  : {passed + failed}")
print(f"Passed : {passed}")
print(f"Failed : {failed}")
