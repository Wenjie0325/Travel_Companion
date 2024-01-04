package service.core;

import java.util.ArrayList;
import java.util.List;

public class ClientApplication {
    private int id;
    private User_Info cakeSpec;
    private List<Order_info> cakeInvoices = new ArrayList<>();

    public ClientApplication(int id, User_Info cakeSpec, List<Order_info> cakeInvoices) {
        this.id = id;
        this.cakeSpec = cakeSpec;
        this.cakeInvoices = cakeInvoices;
    }

    public ClientApplication() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User_Info getCakeSpec() {
        return cakeSpec;
    }

    public void setCakeSpec(User_Info cakeSpec) {
        this.cakeSpec = cakeSpec;
    }

    public List<Order_info> cakeInvoices() {
        return cakeInvoices;
    }

    public void setCakeInvoices(List<Order_info> cakeInvoices) {
        this.cakeInvoices = cakeInvoices;
    }
}
