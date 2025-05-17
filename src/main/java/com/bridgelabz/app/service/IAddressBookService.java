package com.bridgelabz.app.service;

import com.bridgelabz.app.dto.AddressDTO;
import com.bridgelabz.app.model.AddressBookData;

import java.util.List;

public interface IAddressBookService {
    List<AddressBookData> getAll();
    AddressBookData getById(int id);
    AddressBookData create(AddressDTO dto);
    AddressBookData update(int id, AddressDTO dto);
    void delete(int id);
}
