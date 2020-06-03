package hr.croz.unicorn.controller;

import hr.croz.unicorn.model.Car;
import hr.croz.unicorn.model.Part;
import hr.croz.unicorn.service.PartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/part")
@Slf4j
public class PartController {

    private final PartService partService;

    public PartController(PartService partService) {
        this.partService = partService;
    }

    @GetMapping
    public ResponseEntity<List<Part>> getAllParts() {
        try {
            return ResponseEntity.ok().body(partService.getAll());
        } catch (Exception e) {
            log.error("getAllCars...Error while getting all cars", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(path="/serial/{serialNumber}")
    public ResponseEntity<Part> getPartBySerialNumber(@PathVariable("serialNumber") String serialNumber) {
        try {
            return ResponseEntity.ok().body(partService.findBySerialNumber(serialNumber));
        } catch (Exception e) {
            log.error("getBySerialNumber...Error while getting car by SN", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(path="/date/{dateProduced}")
    public ResponseEntity<Part> getPartByDateProduced(@PathVariable("dateProduced") String dateProduced) {
        try {
            return ResponseEntity.ok().body(partService.findByDateProduced(dateProduced));
        } catch (Exception e) {
            log.error("getByDateProduced...Error while getting car by DP", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping(path="/{dateProduced}")
    @Transactional
    public ResponseEntity deletePartByDateProduced(@PathVariable("dateProduced")LocalDate dateProduced) {
        try {
            return ResponseEntity.ok().body(partService.deleteByDateProduced(dateProduced));
        } catch (Exception e) {
            log.error("deleteParByDateProduced...Error while deleting part by DP", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Part> saveNewPart(@RequestBody Part part) {
        try {
            return ResponseEntity.ok().body(partService.save(part));
        } catch (Exception e) {
            log.error("saveNewCar...Error while saving new car", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping(path="/{serialNumber}")
    @Transactional
    public ResponseEntity deletePartBySerialNumber(@PathVariable("serialNumber") String serialNumber) {
        try {
            return ResponseEntity.ok().body(partService.deleteBySerialNumber(serialNumber));
        } catch (Exception e) {
            log.error("deleteParBySerialNumber...Error while deleting part by SN", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(path="/name/{brandAndCarName}")
    public ResponseEntity<List<Part>> getByBrandAndCarName(@PathVariable("brandAndCarName") String brandAndCarName) {
        try {
            return ResponseEntity.ok().body(partService.getAllPartsForCar(brandAndCarName));
        } catch (Exception e) {
            log.error("getByBrandAndCarName...Error while getting car by name", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
