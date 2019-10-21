package demo.fizzbuzz;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class CalculatorTest {
    @Test
    public void two_number_add_test(){
        Calculator cal = new Calculator();
        int result = cal.add(1,2);
        assertThat(result,is(3));
    }

}
