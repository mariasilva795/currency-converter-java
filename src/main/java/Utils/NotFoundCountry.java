package Utils;

public class NotFoundCountry extends RuntimeException {

    public NotFoundCountry() {
        super("The index you entered is not correct");
    }

    public NotFoundCountry(String message) {
        super(message);
    }
}
