package hr.croz.unicorn.service;

import hr.croz.unicorn.model.Part;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface PartService extends CRUDService<Part, Long> {
    Optional<Part> deleteBySerialNumber(String serialNumber);
    Optional<Part> deleteByDateProduced(LocalDate dateProduced);
    Part findBySerialNumber(String serialNumber);
    Part findByDateProduced(String dateProduced);
    List<Part> getAllPartsForCar(String brandAndCarName);
}
