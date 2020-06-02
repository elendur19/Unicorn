package hr.croz.unicorn.controller;

import hr.croz.unicorn.model.Part;
import hr.croz.unicorn.service.PartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping
    public ResponseEntity<Part> saveNewPart(@RequestBody Part part) {
        try {
            return ResponseEntity.ok().body(partService.save(part));
        } catch (Exception e) {
            log.error("saveNewCar...Error while saving new car", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping
    @RequestMapping(path="/{id}")
    public ResponseEntity<Part> deletePartBySerialNumber(@PathVariable("id") String serialNumber) {
        try {
            return ResponseEntity.ok().body(partService.delete();)
        } catch (Exception e) {
            log.error("deleteParBySerialNumber...Error while deleting part by SN", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
