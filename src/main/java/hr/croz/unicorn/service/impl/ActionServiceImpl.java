package hr.croz.unicorn.service.impl;

import hr.croz.unicorn.model.Action;
import hr.croz.unicorn.repository.ActionRepository;
import hr.croz.unicorn.service.AbstractService;
import hr.croz.unicorn.service.ActionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ActionServiceImpl extends AbstractService<Action, Long> implements ActionService {
    private ActionRepository actionRepository;

    public ActionServiceImpl(ActionRepository repository) {
        super(repository);
        this.actionRepository = repository;
    }
}
