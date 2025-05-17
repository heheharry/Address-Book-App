package com.bridgelabz.app.service;

import com.bridgelabz.app.dto.AddressDTO;
import com.bridgelabz.app.model.AddressBookData;
import com.bridgelabz.app.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {

    @Autowired
    private AddressBookRepository repository;

    @Override
    public List<AddressBookData> getAll() {
        return repository.findAll();
    }

    @Override
    public AddressBookData getById(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("ID not found"));
    }

    @Override
    public AddressBookData create(AddressDTO dto) {
        AddressBookData data = new AddressBookData();
        data.setName(dto.name);
        data.setPhone(dto.phone);
        return repository.save(data);
    }

    @Override
    public AddressBookData update(int id, AddressDTO dto) {
        AddressBookData data = getById(id);
        data.setName(dto.name);
        data.setPhone(dto.phone);
        return repository.save(data);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
