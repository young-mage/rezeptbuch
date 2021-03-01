import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class RezeptbuchTest {
    @Test public void testZutatNotNull() {
        var foo = new Rezeptbuch.Zutat("", 10);
        assertNotNull(foo);
    }
}
