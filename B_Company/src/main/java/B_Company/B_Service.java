package B_Company;

import service.core.Service;
import service.core.User_Info;

public class B_Service extends Service {
    B_Price_Setting ps = new B_Price_Setting();
    public double GeneratePrice(User_Info userInfo){
        double totalPrice = 0;
        ps.setTravelway_Price(userInfo.getTravel_way());
        ps.setDestination_Price(userInfo.getDestination());

        totalPrice += ps.Service_Price;
        totalPrice += ps.destination_price * ps.destination_rate;
        totalPrice += ps.travel_way_price * ps.travel_way_rate;
        totalPrice += ps.hotel_price * ps.hotel_star_rate * userInfo.getTravel_time() * userInfo.getHotel_star();
        if(userInfo.isFood() == true){
            totalPrice += ps.Food_price * ps.isFood_rate;
        }
        if(userInfo.isInsurance() == true){
            totalPrice += ps.Insurance_price * ps.isInsurance_rate;
        }

        totalPrice = totalPrice * ps.num_people_rate * userInfo.getNum_people();
        System.out.println("Total Price of A company is: " + totalPrice);
        return totalPrice;
    }

}
