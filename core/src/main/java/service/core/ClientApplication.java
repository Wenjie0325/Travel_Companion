package service.core;

import java.util.ArrayList;
import java.util.List;

public class ClientApplication {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User_Info getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(User_Info userinfo) {
        this.userinfo = userinfo;
    }

    public List<Order_info> getOrderinfo() {
        return orderinfo;
    }

    public void setOrderinfo(List<Order_info> orderinfo) {
        this.orderinfo = orderinfo;
    }

    private int id;
    private User_Info userinfo;
    private List<Order_info> orderinfo = new ArrayList<>();

    public ClientApplication(int id, User_Info userinfo, List<Order_info> orderinfo) {
        this.id = id;
        this.userinfo = userinfo;
        this.orderinfo = orderinfo;
    }

    public ClientApplication() {
    }


}
