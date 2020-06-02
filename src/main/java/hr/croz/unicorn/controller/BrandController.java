package hr.croz.unicorn.controller;

import hr.croz.unicorn.model.Brand;
import hr.croz.unicorn.model.Car;
import hr.croz.unicorn.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brand")
@Slf4j
public class BrandController {
    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public ResponseEntity<List<Brand>> getAllBrands() {
        try {
            return ResponseEntity.ok().body(brandService.getAll());
        } catch (Exception e) {
            log.error("getAllBrands...Error while getting all brands", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Brand> saveNewCar(@RequestBody Brand brand) {
        try {
            return ResponseEntity.ok().body(brandService.save(brand));
        } catch (Exception e) {
            log.error("saveNewCar...Error while saving new car", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
