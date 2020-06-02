package hr.croz.unicorn.service.impl;

import hr.croz.unicorn.model.Part;
import hr.croz.unicorn.repository.PartRepository;
import hr.croz.unicorn.service.AbstractService;
import hr.croz.unicorn.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartServiceImpl extends AbstractService<Part, Long> implements PartService {
    private final PartRepository partRepository;

    @Autowired
    public PartServiceImpl(PartRepository repository) {
        super(repository);
        this.partRepository = repository;
    }

    @Override
    public void deleteBySerialNumber(String serialNumber) {

    }
}
