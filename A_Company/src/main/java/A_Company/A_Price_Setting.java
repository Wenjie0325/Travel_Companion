package A_Company;

public class A_Price_Setting {
    //protected double num_people_price = 500;
    protected double Service_Price = 200;
    protected double destination_price;
    protected double travel_way_price;

    protected double Food_price = 500;

    protected double Insurance_price = 100;
    protected double hotel_price = 30;


    protected double num_people_rate = 0.8;
    protected double destination_rate = 1.1;
    protected double travel_way_rate = 1.2;
    protected double hotel_star_rate = 0.7;
    //protected double travel_time_rate = 0.5;
    protected double isFood_rate = 1;
    protected double isInsurance_rate = 0.9;

    protected void setDestination_Price(String des){
        if(des == "Euro"){
            this.destination_price = 1000;
        } else if (des == "EastAsian") {
            this.destination_price = 600;
        } else if (des == "SouthAmerica") {
            this.destination_price = 800;
        } else if (des == "NorthAmerica") {
            this.destination_price = 1200;
        }
    }

    protected void setTravelway_Price(String tw){
        if(tw == "air"){
            this.travel_way_price = 300;
        } else if (tw == "sea") {
            this.travel_way_price = 50;
        } else if (tw == "road") {
            this.travel_way_price = 100;
        }
    }
}
