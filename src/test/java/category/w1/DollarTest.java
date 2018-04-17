package category.w1;

import category.w1.Dollar;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DollarTest {
    @Test
    public void addTest() {
        Dollar dollar = new Dollar();
        assertEquals(5, dollar.add(5));
    }
}