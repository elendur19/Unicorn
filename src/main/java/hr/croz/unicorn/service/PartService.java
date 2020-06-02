package hr.croz.unicorn.service;

import hr.croz.unicorn.model.Part;


public interface PartService extends CRUDService<Part, Long> {
    void deleteBySerialNumber(String serialNumber);
}
