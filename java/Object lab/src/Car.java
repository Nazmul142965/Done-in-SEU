public class Car
{
    String brand;
    String model;
    String color;
    double price;
    private double fuel;
    int year;


    Car() {
       fuel = 10;
    }

    Car(String givenBrand, String givenModel) {
        brand = givenBrand;
        model = givenModel;
        color = "White";
    }

    Car(String brand, String model, String color) {
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    void horn() {
        System.out.println(this.brand + " " + this.model + ": Beep Beep");
    }

    void horn(String horn){
        System.out.println(this.brand + " " + this.model + ": " + horn); //eikhane kisu vull ase

    }

    void refill(double fuel){
        this.fuel = this.fuel + fuel;

    }

    void setFuel(double addFuel) {
        if (fuel > 0) {
            this.fuel = fuel;
        } else {
            System.err.println("Invalid fuel amount");
        }
    }

    double getFuel() {
        return fuel;
    }

    void setYear(int year) {
        this.year = year;
    }

//    void getYear() {
//        return year;
//    }

    void drive (int time){
        int millage = 2; //1 secend e 2 liter fuel consume korbe
        double consumeFuel = time * millage;
        this.fuel = this.fuel - consumeFuel;

    }


}