package dan.swetraining.babysitting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BabySittingTest {
    
    @Test
    public void testWhoPaidTheMost(){

        BabySitting b = new BabySitting();

        String result = b.whoPaidTheMost("Smith $50, Johnson $30, Smith $50, Jones $40, Johnson $50, Smith $100");

        assertEquals("Smith $200", result);
        assertNotEquals("Jones $40", result);
    }

    @Test
    public void testWhoPaidTheMostNeg(){

        BabySitting b = new BabySitting();

        assertThrows(NullPointerException.class, () -> {
            b.whoPaidTheMost(null);
        });
    }
    
    @Test
    public void testWhoPaidTheMostAdditionalInput() {
        BabySitting b = new BabySitting();

        String result = b.whoPaidTheMost("Smith $50, Johnson $30, Smith $50, Jones $40, Johnson $50, Smith $100");

        assertEquals("Smith $200", result);
        
        result = b.whoPaidTheMost("Johnson $300, Gates $100");
        
        assertEquals("Johnson $380", result);
    }
}
