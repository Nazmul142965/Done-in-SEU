public class Car
{
    private String brand;
    private String model;
    private int year;
    private String color;

    Car(){

    }

    Car(String brand, String model, int year, String color){
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
    }
    Car(String givenBrand, String givenModel, int givenYear){
        brand = givenBrand;
        model = givenModel;
        year = givenYear;
    }

    void setBrand(String brand){
        this.brand = brand;
    }
    String getBrand(){
        return brand;
    }
    void setModel(String model){
        this.model = model;
    }
    String getModel(){
        return model;
    }
    void setYear(int year){
        this.year = year;
    }
    int getYear(){
        return year;
    }
    void setColor(String color){
        this.color = color;
    }
    String getColor(){
        return color;
    }
}
