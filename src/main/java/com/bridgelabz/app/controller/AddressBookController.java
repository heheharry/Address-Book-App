package com.bridgelabz.app.controller;

import com.bridgelabz.appk.dto.AddressDTO;
import com.bridgelabz.app.model.AddressBookData;
import com.bridgelabz.app.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    @GetMapping
    public ResponseEntity<List<AddressBookData>> getAll() {
        return ResponseEntity.ok(addressBookService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressBookData> getById(@PathVariable int id) {
        return ResponseEntity.ok(addressBookService.getById(id));
    }

    @PostMapping
    public ResponseEntity<AddressBookData> create(@RequestBody AddressDTO dto) {
        return ResponseEntity.ok(addressBookService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressBookData> update(@PathVariable int id, @RequestBody AddressDTO dto) {
        return ResponseEntity.ok(addressBookService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        addressBookService.delete(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
}
