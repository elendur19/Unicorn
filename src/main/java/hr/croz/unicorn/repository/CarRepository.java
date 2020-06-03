package hr.croz.unicorn.repository;

import hr.croz.unicorn.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("select c from Car c left join fetch c.brand where concat(c.brand.name, ' ', c.name) like :brandAndCarName ")
    Car findByBrandNameEqualsAndNameEquals(@Param("brandAndCarName") String brandAndCarName);
}
