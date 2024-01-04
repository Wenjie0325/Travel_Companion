package service.core;

public class Order_info implements java.io.Serializable{

    private String company;
    private String reference;
    private double price;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public Order_info() {
    }

    public Order_info(String company, String reference, double price) {
        this.company = company;
        this.reference = reference;
        this.price = price;
    }
}
