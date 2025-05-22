public class BatteryCar extends Car
{
    double battery;
    int charge;

    void horn(){
        System.out.println("battery car : teep teep");
    }

    void refilll(double battery){
        this.battery = this.battery + battery;
    }
}
