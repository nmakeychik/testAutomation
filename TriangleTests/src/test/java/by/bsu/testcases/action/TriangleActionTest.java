package by.bsu.testcases.action;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.bsu.testcases.exception.TriangleException;

public class TriangleActionTest {
    TriangleAction triangleAction;

    @BeforeMethod
    public void initTriangleAction() {
        triangleAction = new TriangleAction();
    }

    @DataProvider
    public Double[][] nullSides() {
        return new Double[][] { { null, null, null }, { 1.0, null, null }, { null, 1.0, null }, { null, null, 1.0 },
                { 1.0, 1.0, null }, { 1.0, null, 1.0 }, { null, 1.0, 1.0 } };
    }

    @Test(dataProvider = "nullSides", expectedExceptions = { TriangleException.class })
    public void isThrowsExceptionWhenNullPassed(Double[] nullSides) {
        triangleAction.checkTriangle(nullSides[0], nullSides[1], nullSides[2]);
    }

    @DataProvider
    public Double[][] impossibleTriangleSides() {
        return new Double[][] { { 1.5, 0.5, 2.0 }, { 1.5, 2.0, 0.5 }, { 2.0, 1.5, 0.5 } };
    }

    @Test(dataProvider = "impossibleTriangleSides")
    public void isAbleToFilterOutImpossibleTriagle(Double[] impossibleTriangleSides) {
        Assert.assertFalse(triangleAction.checkTriangle(impossibleTriangleSides[0], impossibleTriangleSides[1],
                impossibleTriangleSides[2]));
    }

    @DataProvider
    public Double[][] zeroSides() {
        return new Double[][] { { 0.0, 1.0, 2.0 }, { 1.0, 0.0, 2.0 }, { 2.0, 1.0, 0.0 } };
    }

    @Test(dataProvider = "zeroSides", expectedExceptions = { TriangleException.class })
    public void isThrowsExceptionWhenZeroPassed(Double[] zeroSides) {
        triangleAction.checkTriangle(zeroSides[0], zeroSides[1], zeroSides[2]);
    }

    @DataProvider
    public Double[][] positiveInfinitySides() {
        return new Double[][] { { Double.POSITIVE_INFINITY, 1.0, 2.0 }, { 1.0, Double.POSITIVE_INFINITY, 2.0 },
                { 2.0, 1.0, Double.POSITIVE_INFINITY } };
    }

    @Test(dataProvider = "positiveInfinitySides", expectedExceptions = { TriangleException.class })
    public void isThrowsExceptionWhenPositiveInfinityPassed(Double[] positiveInfinitySides) {
        triangleAction.checkTriangle(positiveInfinitySides[0], positiveInfinitySides[1], positiveInfinitySides[2]);
    }

    @DataProvider
    public Double[][] negativeInfinitySides() {
        return new Double[][] { { Double.NEGATIVE_INFINITY, 1.0, 2.0 }, { 1.0, Double.NEGATIVE_INFINITY, 2.0 },
                { 2.0, 1.0, Double.NEGATIVE_INFINITY } };
    }

    @Test(dataProvider = "negativeInfinitySides", expectedExceptions = { TriangleException.class })
    public void isThrowsExceptionWhenNegativeInfinityPassed(Double[] negativeInfinitySides) {
        triangleAction.checkTriangle(negativeInfinitySides[0], negativeInfinitySides[1], negativeInfinitySides[2]);
    }

    @DataProvider
    public Double[][] equilateralSides() {
        return new Double[][] { { 1.0, 1.0, 1.0 }, { 1.0, 2.0, 2.0 } };
    }

    @Test(dataProvider = "equilateralSides")
    public void isAbleToWorkWithEquilateralSides(Double[] equilateralSides) {
        Assert.assertTrue(triangleAction.checkTriangle(equilateralSides[0], equilateralSides[1], equilateralSides[2]));
    }

    @DataProvider
    public Double[][] negativeSides() {
        return new Double[][] { { -1.0, 1.0, 1.0 }, { 1.0, -1.0, 1.0 }, { 1.0, 1.0, -1.0 }, { -1.0, -1.0, 1.0 },
                { -1.0, 1.0, -1.0 }, { 1.0, -1.0, -1.0 }, { -1.0, -1.0, -1.0 } };
    }

    @Test(dataProvider = "negativeSides", expectedExceptions = { TriangleException.class })
    public void isAbleToFilterOutNegativeSides(Double[] negativeSides) {
        triangleAction.checkTriangle(negativeSides[0], negativeSides[1], negativeSides[2]);
    }

    @DataProvider
    public Double[][] possibleTriangle() {
        return new Double[][] { { 1.5, 1.0, 1.0 }, { 2.0, 2.5, 2.0 }, { 3.0, 3.0, 3.5 } };
    }

    @Test(dataProvider = "possibleTriangle")
    public void isAbleToRecognizePossibleTriangle(Double[] possibleTriangle) {
        Assert.assertTrue(triangleAction.checkTriangle(possibleTriangle[0], possibleTriangle[1], possibleTriangle[2]));
    }

    @DataProvider
    public Double[][] linearSides() {
        return new Double[][] { { 1.5, 3.0, 1.5 }, { 2.0, 1.0, 1.0 }, { 1.0, 1.0, 2.0 } };
    }

    @Test(dataProvider = "linearSides")
    public void isAbleToFilterOutLinearTriangles(Double[] linearSides) {
        Assert.assertFalse(triangleAction.checkTriangle(linearSides[0], linearSides[1], linearSides[2]));
    }
}
