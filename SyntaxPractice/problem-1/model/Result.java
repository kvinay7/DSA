package model;

public class Result {

    private final int sum;
    private final double average;

    public Result(int sum, double average) {
        this.sum = sum;
        this.average = average;
    }

    public int getSum() {
        return sum;
    }

    public double getAverage() {
        return average;
    }

    @Override
    public String toString() {
        return "Sum = " + sum +
                "\nAverage = " + average;
    }
}
