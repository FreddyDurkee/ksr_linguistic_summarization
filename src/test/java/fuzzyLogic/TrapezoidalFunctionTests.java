package fuzzyLogic;

import fuzzyLogic.functions.TrapezoidalFunction;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.assertj.core.api.Assertions.*;


public class TrapezoidalFunctionTests {

    @Test
    public void getMembership_countValueBetweenAB_membershipDoubleValue() {
        // Given
        int a = 2;
        int b = 5;
        int c = 9;
        int d = 14;
        int x = 3;
        TrapezoidalFunction trapezoidalFunction = new TrapezoidalFunction( a,  b,  c, d);

        // When
        double result = trapezoidalFunction.getMembership(x);

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
        int d = 14;
        int x = 6;
        TrapezoidalFunction trapezoidalFunction = new TrapezoidalFunction( a,  b,  c, d);

        // When
        double result = trapezoidalFunction.getMembership(x);

        // Then
        double expected = 1;
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void getMembership_countValueBetweenCD_membershipDoubleValue() {
        // Given
        int a = 2;
        int b = 5;
        int c = 9;
        int d = 14;
        int x = 11;
        TrapezoidalFunction trapezoidalFunction = new TrapezoidalFunction( a,  b,  c, d);

        // When
        double result = trapezoidalFunction.getMembership(x);

        // Then
        double expected = 0.6;
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void getMembership_initTriangularFunctionWithBSmallerThanA_Exception() {
        // Given
        int a = 5;
        int b = 2;
        int c = 9;
        int d = 14;
        int x = 11;
        TrapezoidalFunction trapezoidalFunction = new TrapezoidalFunction( a,  b,  c, d);

        // When
        Throwable thrown = catchThrowable(()->{ trapezoidalFunction.getMembership(x);});
        // Then
        assertThat(thrown).hasMessageContaining("A must be smaller than B");
    }

    @Test
    public void getMembership_initTriangularFunctionWithCSmallerThanB_Exception() {
        // Given
        int a = 2;
        int b = 9;
        int c = 5;
        int d = 14;
        int x = 11;
        TrapezoidalFunction trapezoidalFunction = new TrapezoidalFunction( a,  b,  c, d);

        // When
        Throwable thrown = catchThrowable(()->{ trapezoidalFunction.getMembership(x);});
        // Then
        assertThat(thrown).hasMessageContaining("B must be smaller than C");
    }

    @Test
    public void getMembership_initTriangularFunctionWithDSmallerThanC_Exception() {
        // Given
        int a = 2;
        int b = 5;
        int c = 14;
        int d = 9;
        int x = 11;
        TrapezoidalFunction trapezoidalFunction = new TrapezoidalFunction( a,  b,  c, d);

        // When
        Throwable thrown = catchThrowable(()->{ trapezoidalFunction.getMembership(x);});
        // Then
        assertThat(thrown).hasMessageContaining("C must be smaller than D");



    }
}
