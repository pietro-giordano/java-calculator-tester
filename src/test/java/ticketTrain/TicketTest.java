package ticketTrain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.InvalidKeyException;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {
    @Test
    void calcPriceUnder() throws InvalidKeyException {
        Ticket ticket = new Ticket(10, 10);
        assertEquals(new BigDecimal(1.68).setScale(2, RoundingMode.HALF_UP), new BigDecimal(ticket.calcPrice()).setScale(2, RoundingMode.HALF_UP), "Il prezzo è uguale a 1.68");
    }

    @Test
    void calcPriceAdult() throws InvalidKeyException {
        Ticket ticket = new Ticket(10, 30);
        assertEquals(2.10, ticket.calcPrice(), "Il prezzo è uguale a 2.10");
    }

    @Test
    void calcPriceOver() throws InvalidKeyException {
        Ticket ticket = new Ticket(10, 70);
        assertEquals(1.26, ticket.calcPrice(), "Il prezzo è uguale a 1.26");
    }

    @Test
    void testNegKm() {
        Ticket ticket = new Ticket(-10, 30);
        assertThrows(InvalidKeyException.class, () -> ticket.calcPrice(), "Deve tirare InvalidKeyException se km è negativo");
    }

    @Test
    void testNegAge() {
        Ticket ticket = new Ticket(10, -30);
        assertThrows(InvalidKeyException.class, () -> ticket.calcPrice(), "Deve tirare InvalidKeyException se age è negativo");
    }

    @Test
    void testZeroKm() {
        Ticket ticket = new Ticket(0, 30);
        assertThrows(InvalidKeyException.class, () -> ticket.calcPrice(), "Deve tirare InvalidKeyException se km è uguale a 0");
    }

    @Test
    void testZeroAge() {
        Ticket ticket = new Ticket(30, 0);
        assertThrows(InvalidKeyException.class, () -> ticket.calcPrice(), "Deve tirare InvalidKeyException se age è uguale a 0");
    }
}