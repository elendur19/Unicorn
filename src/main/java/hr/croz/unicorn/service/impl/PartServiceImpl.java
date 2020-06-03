package hr.croz.unicorn.service.impl;

import hr.croz.unicorn.model.Car;
import hr.croz.unicorn.model.Part;
import hr.croz.unicorn.repository.CarPartRepository;
import hr.croz.unicorn.repository.PartRepository;
import hr.croz.unicorn.service.AbstractService;
import hr.croz.unicorn.service.CarService;
import hr.croz.unicorn.service.PartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PartServiceImpl extends AbstractService<Part, Long> implements PartService {
    private final PartRepository partRepository;
    private final CarPartRepository carPartRepository;
    private final CarService carService;

    @Autowired
    public PartServiceImpl(PartRepository partRepository, CarPartRepository carPartRepository, CarService carService) {
        super(partRepository);
        this.partRepository = partRepository;
        this.carPartRepository = carPartRepository;
        this.carService = carService;
    }

    @Override
    public Optional<Part> deleteBySerialNumber(String serialNumber) {
        return this.partRepository.deleteBySerialNumber(serialNumber);
    }

    @Override
    public Part findBySerialNumber(String serialNumber) {
        return this.partRepository.findBySerialNumber(serialNumber);
    }

    public Optional<Part> deleteByDateProduced(LocalDate dateProduced) {
        return this.partRepository.deleteByDateProduced(dateProduced);
    }

    @Override
    public Part findByDateProduced(String dateProduced) {
        return this.partRepository.findByDateProduced(LocalDate.parse(dateProduced));
    }

    @Override
    public List<Part> getAllPartsForCar(String brandAndCarName) {

        Car car = carService.findCarByBrandAndCarName(brandAndCarName);
        if(car == null){
            log.info("Car not found");
            return null;
        }
        return carPartRepository.findPartsForCar(car.getId());
    }
}
