package hr.croz.unicorn.service.impl;

import hr.croz.unicorn.model.Brand;
import hr.croz.unicorn.repository.BrandRepository;
import hr.croz.unicorn.service.AbstractService;
import hr.croz.unicorn.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl extends AbstractService<Brand, Long> implements BrandService {
    private final BrandRepository brandRepository;

    @Autowired
    public BrandServiceImpl(BrandRepository repository) {
        super(repository);
        this.brandRepository = repository;
    }


}
