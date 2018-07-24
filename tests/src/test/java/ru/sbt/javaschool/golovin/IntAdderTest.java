package ru.sbt.javaschool.golovin;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IntAdderTest {
    @DataProvider
    Object[][] dataProvider() {
        return new Object[][] {
                new Object[] {new TestCase("small", -5, 10, 5)},
                new Object[] {new TestCase("large", 100000, 800000, 900000)}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void testItWorks(final TestCase testCase) {
        Assert.assertEquals(
                IntAdder.add(testCase.firstArg, testCase.secondArg),
                testCase.expected,
                String.format("Кейс %s провалился", testCase.name)
        );
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testOverflow() {
        final int a = Integer.MAX_VALUE - 500;
        final int b = 1000;
        IntAdder.add(a, b);
    }

    private static class TestCase {
        final String name;
        final int firstArg;
        final int secondArg;
        final int expected;

        TestCase(final String name, final int firstArg, final int secondArg, final int expected) {
            this.name = name;
            this.firstArg = firstArg;
            this.secondArg = secondArg;
            this.expected = expected;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
