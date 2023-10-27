package mk.ukim.finki.wp.lab1_nova.bootstrap;

import mk.ukim.finki.wp.lab1_nova.model.Balloon;
import mk.ukim.finki.wp.lab1_nova.model.Manufacturer;
import mk.ukim.finki.wp.lab1_nova.model.Order;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
@Component
public class DataHolder {
    public static List<Balloon> balloons = new ArrayList<>();
    public static List<Manufacturer> manufacturers = new ArrayList<>();
    public static List<Order> orders = new ArrayList<>();
    public static List<User> users = new ArrayList<>();



    @PostConstruct
    public void init(){


        Manufacturer manufacturer1 = new Manufacturer("BalloonFactory1","USA","Address");
        Manufacturer manufacturer2 = new Manufacturer("BalloonFactory2","USA","Address");
        Manufacturer manufacturer3 = new Manufacturer("BalloonFactory3","USA","Address");
        Manufacturer manufacturer4 = new Manufacturer("BalloonFactory4","USA","Address");
        Manufacturer manufacturer5 = new Manufacturer("BalloonFactory5","USA","Address");
        manufacturers.add(manufacturer1);
        manufacturers.add(manufacturer2);
        manufacturers.add(manufacturer3);
        manufacturers.add(manufacturer4);
        manufacturers.add(manufacturer5);

        balloons.add(new Balloon("Balloon1", "Red Balloon",manufacturer1));
        balloons.add(new Balloon("Balloon2", "Green Balloon",manufacturer2));
        balloons.add(new Balloon("Balloon3", "Purple Balloon",manufacturer3));
        balloons.add(new Balloon("Balloon4", "Yellow Balloon",manufacturer4));
        balloons.add(new Balloon("Balloon5", "White Balloon",manufacturer5));

        orders.add(new Order("Blue","Big","Momchilo","Address"));
        orders.add(new Order("Red","Extra Big","Pero","Address"));
        orders.add(new Order("Green","Small","Stefan","Address"));
        orders.add(new Order("Yellow","Medium","Sani","Address"));
        orders.add(new Order("White","Big","Laze","Address"));

    }



}
