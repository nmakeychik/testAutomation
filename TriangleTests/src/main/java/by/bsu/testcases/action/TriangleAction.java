package by.bsu.testcases.action;

import by.bsu.testcases.exception.TriangleException;

public class TriangleAction {
    public boolean checkTriangle(Double a, Double b, Double c) {
        if (a == null || b == null || c == null) {
            throw new TriangleException("Null side passed");
        }
        if (a == 0 || b == 0 || c == 0) {
            throw new TriangleException("Zero side passed");
        }
        if (a < 0 || b < 0 || c < 0) {
            throw new TriangleException("Negative side passed");
        }
        if (a.compareTo(Double.POSITIVE_INFINITY) == 0 || b.compareTo(Double.POSITIVE_INFINITY) == 0
                || c.compareTo(Double.POSITIVE_INFINITY) == 0) {
            throw new TriangleException("Positive infinity side passed");
        }
        if (a.compareTo(Double.NEGATIVE_INFINITY) == 0 || b.compareTo(Double.NEGATIVE_INFINITY) == 0
                || c.compareTo(Double.NEGATIVE_INFINITY) == 0) {
            throw new TriangleException("Negative infinity side passed");
        }
        return a + b > c && b + c > a && a + c > b;
    }
}
