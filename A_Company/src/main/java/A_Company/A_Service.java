package A_Company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.core.Order_info;
import service.core.Service;
import service.core.User_Info;

import java.util.HashMap;
import java.util.Map;

@RestController
public class A_Service extends Service {

    public static final String PREFIX = "A";
    public static final String COMPANY = "A_Company";

    private Map<String, Order_info> orders = new HashMap<>();
    A_Price_Setting ps = new A_Price_Setting();

    @PostMapping(value="/order", produces="application/json")
    public ResponseEntity<Order_info> generateOrder(@RequestBody User_Info userInfo){
        Order_info orderInfo = new Order_info(COMPANY,generateReference(PREFIX),GeneratePrice(userInfo));
        orders.put(orderInfo.getReference(), orderInfo);
        String url = "http://"+8080+"/order/"
                + generateReference(PREFIX);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location", url)
                .header("Content-Location", url)
                .body(orderInfo);
    }

    @RequestMapping(value = "/order/{reference}", method = RequestMethod.GET)
    public Order_info getResource(@PathVariable("reference") String reference) {
        Order_info createdOrder = orders.get(reference);

        return createdOrder;
    }

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
