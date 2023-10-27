package mk.ukim.finki.wp.lab1_nova.service.impl;

import mk.ukim.finki.wp.lab1_nova.model.Balloon;
import mk.ukim.finki.wp.lab1_nova.model.Manufacturer;
import mk.ukim.finki.wp.lab1_nova.model.exceptions.ManufacturerNotFoundException;
import mk.ukim.finki.wp.lab1_nova.repository.BalloonRepository;
import mk.ukim.finki.wp.lab1_nova.repository.ManufacturerRepository;
import mk.ukim.finki.wp.lab1_nova.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalloonServiceImpl implements BalloonService {
    private final BalloonRepository balloonRepository;
    private final ManufacturerRepository manufacturerRepository;
    public BalloonServiceImpl(BalloonRepository balloonRepository, ManufacturerRepository manufacturerRepository){
        this.balloonRepository=balloonRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Balloon> listAll() {
        return balloonRepository.findAllBalloons();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        return balloonRepository.findAllByNameOrDescription(text);
    }

    @Override
    public Optional<Balloon> saveBalloon(String name, String description, Long manufacturerId) {
        Manufacturer manufacturer = this.manufacturerRepository.findById(manufacturerId).orElseThrow(() -> new ManufacturerNotFoundException(manufacturerId));
        return this.balloonRepository.save(name,description,manufacturer);
    }

    @Override
    public void deleteById(Long id) {
        this.balloonRepository.deleteById(id);
    }

    @Override
    public Optional<Balloon> findById(Long id) {
        return this.balloonRepository.findById(id);
    }
}
