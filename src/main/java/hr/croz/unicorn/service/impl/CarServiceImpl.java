package hr.croz.unicorn.service.impl;

import hr.croz.unicorn.model.Car;
import hr.croz.unicorn.repository.CarRepository;
import hr.croz.unicorn.service.AbstractService;
import hr.croz.unicorn.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CarServiceImpl extends AbstractService<Car, Long> implements CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository repository) {
        super(repository);
        this.carRepository = repository;
    }

    @Override
    public Car findCarByBrandAndCarName(String brandAndCarName) {

        return carRepository.findByBrandNameEqualsAndNameEquals(brandAndCarName);
    }
}
