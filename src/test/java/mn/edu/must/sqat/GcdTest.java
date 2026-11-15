
package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GcdTest {

    @Test
    void gcdWithZeroY() {
        assertEquals(7, DataFlowTargets.gcd(7, 0));
    }

    @Test
    void gcdWithTwoIterations() {
        assertEquals(4, DataFlowTargets.gcd(12, 8));
    }

    @Test
    void gcdWithZeroX() {
        assertEquals(5, DataFlowTargets.gcd(0, 5));
    }
}
