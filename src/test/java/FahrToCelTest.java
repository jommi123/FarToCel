import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FahrToCelTest {
    FahrToCel converter = new FahrToCel();

    @Test
    void fahrToCel() {
        assertEquals(0, converter.fahrToCel(32));
        assertEquals(100, converter.fahrToCel(212));
        assertEquals(-40, converter.fahrToCel(-40));
    }

    @Test
    void celToFahr() {
        assertEquals(32, converter.celToFahr(0));
        assertEquals(212, converter.celToFahr(100));
        assertEquals(-40, converter.celToFahr(-40));
    }

    @Test
    void kelvinToCel() {
        assertEquals(0, converter.kelvinToCel(273.15));
        assertEquals(-273.15, converter.kelvinToCel(0));
    }

    @Test
    void kelvinToFahr() {
        assertEquals(32, converter.kelvinToFahr(273.15), 0.1);
        assertEquals(-459.67, converter.kelvinToFahr(0), 0.1);
        assertEquals(80.51, converter.kelvinToFahr(300.1), 0.1);
    }
}