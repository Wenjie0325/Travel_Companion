package service.core;

public class User_Info implements java.io.Serializable{
    private int num_people;

    private String destination;

    private String travel_way;

    private int hotel_star;

    private int travel_time;

    private boolean isFood;

    private boolean isInsurance;

    public User_Info(int num_people, String destination, String travel_way, int hotel_star, int travel_time, boolean isFood, boolean isInsurance){
        this.num_people = num_people;
        this.destination = destination;
        this.travel_way = travel_way;
        this.hotel_star = hotel_star;
        this.travel_time = travel_time;
        this.isFood = isFood;
        this.isInsurance = isInsurance;
    }

    public User_Info(){}


    public int getNum_people() {
        return num_people;
    }

    public void setNum_people(int num_people) {
        this.num_people = num_people;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTravel_way() {
        return travel_way;
    }

    public void setTravel_way(String travel_way) {
        this.travel_way = travel_way;
    }

    public int getHotel_star() {
        return hotel_star;
    }

    public void setHotel_star(int hotel_star) {
        this.hotel_star = hotel_star;
    }

    public int getTravel_time() {
        return travel_time;
    }

    public void setTravel_time(int travel_time) {
        this.travel_time = travel_time;
    }

    public boolean isFood() {
        return isFood;
    }

    public void setFood(boolean food) {
        isFood = food;
    }

    public boolean isInsurance() {
        return isInsurance;
    }

    public void setInsurance(boolean insurance) {
        isInsurance = insurance;
    }
}
