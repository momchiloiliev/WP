package mk.ukim.finki.wp.lab1_nova.service;

import mk.ukim.finki.wp.lab1_nova.model.Balloon;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface BalloonService {
    List<Balloon> listAll();
    List<Balloon> searchByNameOrDescription(String text);
    Optional<Balloon> saveBalloon(String name, String description, Long manufacturerId);
    void deleteById(Long id);

    Optional<Balloon> findById(Long id);
}

