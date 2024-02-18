import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FahrToCelTest {

    @Test
    void fahrToCel() {
        assertEquals(0, FahrToCel.fahrToCel(32));
        assertEquals(100, FahrToCel.fahrToCel(212));
        assertEquals(-40, FahrToCel.fahrToCel(-40));
    }

    @Test
    void celToFahr() {
        assertEquals(32, FahrToCel.celToFahr(0));
        assertEquals(212, FahrToCel.celToFahr(100));
        assertEquals(-40, FahrToCel.celToFahr(-40));
    }

    @Test
    void kelvinToCel() {
        assertEquals(0, FahrToCel.kelvinToCel(273.15));
        assertEquals(-273.15, FahrToCel.kelvinToCel(0));
    }
}