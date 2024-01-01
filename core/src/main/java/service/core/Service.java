package service.core;

public abstract class Service {
    private int counter = 1000;
    protected String generateReference(String prefix) {
        String ref = prefix;
        int length = 100000;
        while (length > 1000) {
            if (counter / length == 0) ref += "0";
            length = length / 10;
        }
        return ref + counter++;
    }
}
