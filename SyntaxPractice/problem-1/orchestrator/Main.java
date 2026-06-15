import logging.Logger;
import model.Result;
import service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Logger.info("Application Started");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");

        int n = scanner.nextInt();

        List<Integer> numbers = new ArrayList<>();

        System.out.println(
                "Enter " + n + " integers:"
        );

        for (int i = 0; i < n; i++) {
            numbers.add(
                    scanner.nextInt()
            );
        }

        Service service = new Service();

        Result result =
                service.process(
                        numbers
                );

        System.out.println();
        System.out.println(result);

        Logger.info(
                "Application Completed"
        );
    }
}
