package hr.croz.unicorn.repository;

import hr.croz.unicorn.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;

public interface PartRepository extends JpaRepository<Part, Long> {
    @Query("select p from Part p where p.serialNumber like :serialNumber ")
    Part findBySerialNumber(@Param("serialNumber") String serialNumber);

    @Query("select p from Part p where p.dateProduced = :dateProduced")
    Part findByDateProduced(@Param("dateProduced") LocalDate dateProduced);

    Optional<Part> deleteBySerialNumber(String serialNumber);
    Optional<Part> deleteByDateProduced(LocalDate dateProduced);
}
