package mk.ukim.finki.wp.lab1_nova.repository;

import mk.ukim.finki.wp.lab1_nova.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab1_nova.model.Balloon;
import mk.ukim.finki.wp.lab1_nova.model.Manufacturer;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Repository
public class BalloonRepository {
//    public static List<Balloon> balloons =new ArrayList<>(10);

    public List<Balloon> findAllBalloons(){
        return DataHolder.balloons;
    }

    public List<Balloon> findAllByNameOrDescription (String text){
        return DataHolder.balloons.stream().filter(r->r.getName().contains(text) || r.getDescription().contains(text)).collect(Collectors.toList());
    }
    public Optional<Balloon> save(String name, String description, Manufacturer manufacturer){
        DataHolder.balloons.removeIf(r -> r.getName().equals(name));
        Balloon balloon = new Balloon(name, description, manufacturer);
        DataHolder.balloons.add(balloon);
        return Optional.of(balloon);
    }

    public void deleteById(Long id){
        DataHolder.balloons.removeIf(r -> r.getId().equals(id));
    }

    public Optional<Balloon> findById(Long id) {
        return DataHolder.balloons.stream().filter(r -> r.getId().equals(id)).findFirst();
    }
}
