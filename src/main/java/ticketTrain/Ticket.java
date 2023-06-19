package ticketTrain;

import java.math.BigDecimal;
import java.security.InvalidKeyException;

public class Ticket {
    private int km;
    private int age;
    private double priceForKm = 0.21;

    public Ticket(int km, int age) {
        this.km = km;
        this.age = age;
    }

    public double calcPrice() throws InvalidKeyException {
        if (km > 0 && age > 0) {
            if (age < 18) {
                return km * priceForKm * 0.8;
            } else if (age >= 65) {
                return km * priceForKm * 0.6;
            } else {
                return km * priceForKm;
            }
        } else {
            throw new InvalidKeyException("Inserire solo valori positivi");
        }
    }
}
