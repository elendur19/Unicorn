package hr.croz.unicorn.repository;

import hr.croz.unicorn.model.CarParts;
import hr.croz.unicorn.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarPartRepository extends JpaRepository<CarParts, Long> {
    @Query("select cp.part from CarParts cp left join cp.part left join cp.car where cp.car.id = :carId")
    List<Part> findPartsForCar(@Param("carId") Long carId);
}