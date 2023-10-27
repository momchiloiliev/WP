package mk.ukim.finki.wp.lab1_nova.service.impl;


import mk.ukim.finki.wp.lab1_nova.model.Manufacturer;
import mk.ukim.finki.wp.lab1_nova.repository.ManufacturerRepository;
import mk.ukim.finki.wp.lab1_nova.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;


    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Manufacturer> findAll(){
        return this.manufacturerRepository.findAll();
    }
}
