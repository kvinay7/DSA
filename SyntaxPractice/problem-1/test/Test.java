import model.Result;
import service.Service;

import java.util.Arrays;

public class Test {

    private static int passed = 0;
    private static int failed = 0;

    public static void main(String[] args) {

        Service service = new Service();

        runTest(
                "Normal Input",
                () -> {
                    Result result =
                            service.process(
                                    Arrays.asList(
                                            10,20,30,40,50
                                    )
                            );

                    return result.getSum() == 150
                            && result.getAverage() == 30.0;
                }
        );

        runTest(
                "Single Element",
                () -> {
                    Result result =
                            service.process(
                                    Arrays.asList(10)
                            );

                    return result.getSum() == 10
                            && result.getAverage() == 10.0;
                }
        );

        runTest(
                "Negative Numbers",
                () -> {
                    Result result =
                            service.process(
                                    Arrays.asList(
                                            -10,-20,-30
                                    )
                            );

                    return result.getSum() == -60
                            && result.getAverage() == -20.0;
                }
        );

        runTest(
                "Empty Input",
                () -> {

                    try {

                        service.process(
                                Arrays.asList()
                        );

                        return false;

                    } catch (Exception ex) {
                        return true;
                    }
                }
        );

        System.out.println();
        System.out.println("Total  : " + (passed + failed));
        System.out.println("Passed : " + passed);
        System.out.println("Failed : " + failed);
    }

    private static void runTest(
            String testName,
            TestCase testCase) {

        boolean result = testCase.run();

        if (result) {
            passed++;
            System.out.printf(
                    "%-30s PASS%n",
                    testName
            );
        } else {
            failed++;
            System.out.printf(
                    "%-30s FAIL%n",
                    testName
            );
        }
    }

    interface TestCase {
        boolean run();
    }
}
