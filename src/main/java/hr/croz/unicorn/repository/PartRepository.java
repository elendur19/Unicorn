package hr.croz.unicorn.repository;

import hr.croz.unicorn.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartRepository extends JpaRepository<Part, Long> {
}
