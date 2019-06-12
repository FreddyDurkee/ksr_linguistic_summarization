package FuzzyLogic;

import FuzzyLogic.functions.TriangularFunction;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.Assert.assertEquals;

public class TriangularFunctionTests {

    @Test
    public void getMembership_countValueBetweenAB_membershipDoubleValue() {
        // Given
        int a = 2;
        int b = 5;
        int c = 9;
        int x = 3;
        TriangularFunction triangularFunction = new TriangularFunction( a,  b,  c);

        // When
        double result = triangularFunction.getMembership(x);

        // Then
        double expected = 1.0/3;
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void getMembership_countValueBetweenBC_membershipDoubleValue() {
        // Given
        int a = 2;
        int b = 5;
        int c = 9;
        int x = 6;
        TriangularFunction triangularFunction = new TriangularFunction( a,  b,  c);

        // When
        double result = triangularFunction.getMembership(x);

        // Then
        double expected = 0.75;
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void getMembership_initTriangularFunctionWithBSmallerThanA_Exception() {
        // Given
        int a = 5;
        int b = 2;
        int c = 9;
        int x = 6;
        TriangularFunction triangularFunction = new TriangularFunction( a,  b,  c);

        // When
        Throwable thrown = catchThrowable(()->{ triangularFunction.getMembership(x);});
        // Then
        Assertions.assertThat(thrown).hasMessageContaining("A must be smaller than B");
    }

    @Test
    public void getMembership_initTriangularFunctionWithCSmallerThanB_Exception() {
        // Given
        int a = 2;
        int b = 9;
        int c = 6;
        int x = 6;
        TriangularFunction triangularFunction = new TriangularFunction( a,  b,  c);

        // When
        Throwable thrown = catchThrowable(()->{ triangularFunction.getMembership(x);});
        // Then
        Assertions.assertThat(thrown).hasMessageContaining("B must be smaller than C");
    }
}
