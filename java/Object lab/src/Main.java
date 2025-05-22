public class Main {
    public static void main(String[] args)
    {
        Car car = new Car();
        car.brand = " Habijabi ";
        car.model = " UwU ";
        car.color = " Black ";
        car.price = 200000.99;
        car.setFuel(20);
//        if (fuel > 0){
//            car.fuel = fuel;
//    }

        car.year = 2025;
        System.out.println("Hello, Introducing the brand new car " + car.brand + ".\n Model Name " + car.model +
                ".\n Color is " + car.color + ".\n Price is " + car.price + ".\n Fuel is " + car.getFuel() + ".\n Year is " + car.year );
        car.horn();
        car.refill(22);
        System.out.println(car.brand + " " + car.model + " " + car.getFuel());
        car.drive(5);
        System.out.println(car.brand + " " + car.model + " " + car.getFuel());

        Car c2 = new Car(" lklo"," UwU ");
        c2.setFuel(30);
        c2.setYear(2010);
        System.out.println(c2.brand + " " + c2.model + " " + c2.color + " " + c2.getFuel());
        c2.horn(" peep peep ");

        Car c3 = new Car(" Honda ", " Civic ", "Black");
        System.out.println(c3.brand + " " + c3.model + " " + c3.color);
        c3.horn();

        BatteryCar batteryCar = new BatteryCar();
        batteryCar.brand = " Tesla ";
        batteryCar.battery = 50;
        System.out.println(batteryCar.brand + " " + batteryCar.battery + " " + batteryCar.getFuel() );
        batteryCar.horn();
        batteryCar.refilll(50);
        System.out.println(batteryCar.brand + " " + batteryCar.model + " " + batteryCar.getFuel());


    }
}