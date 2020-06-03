package hr.croz.unicorn.controller;

import hr.croz.unicorn.model.Car;
import hr.croz.unicorn.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/car")
@Slf4j
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        try {
            return ResponseEntity.ok().body(carService.getAll());
        } catch (Exception e) {
            log.error("getAllCars...Error while getting all cars", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Car> saveNewCar(@RequestBody Car car) {
        try {
            return ResponseEntity.ok().body(carService.save(car));
        } catch (Exception e) {
            log.error("saveNewCar...Error while saving new car", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(path="/name/{brandAndCarName}")
    public ResponseEntity<Car> getByBrandAndCarName(@PathVariable("brandAndCarName") String brandAndCarName) {
        try {
            return ResponseEntity.ok().body(carService.findCarByBrandAndCarName(brandAndCarName));
        } catch (Exception e) {
            log.error("getByBrandAndCarName...Error while getting car by name", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
