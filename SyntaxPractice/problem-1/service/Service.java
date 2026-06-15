package service;

import exception.InputValidationException;
import model.Result;

import java.util.List;

public class Service {

    public Result process(List<Integer> numbers) {

        if (numbers == null || numbers.isEmpty()) {
            throw new InputValidationException("Input list cannot be empty");
        }

        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        double average = (double) sum / numbers.size();

        return new Result(sum, average);
    }
}
