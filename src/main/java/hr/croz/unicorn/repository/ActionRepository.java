package hr.croz.unicorn.repository;


import hr.croz.unicorn.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepository extends JpaRepository<Action, Long> {
}
