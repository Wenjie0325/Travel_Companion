package A_Company;

import service.core.User_Info;

public class Main {
    public static void main(String[] args) {
        User_Info userInfo = new User_Info(2,"Euro","air",4,7,true,true);

        A_Service aService = new A_Service();

        aService.GeneratePrice(userInfo);
    }
}
