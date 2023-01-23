package com.waa.exam.controller;

import com.waa.exam.domain.dto.AddressDto;
import com.waa.exam.service.Impl.AddressServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController {
    private AddressServiceImpl service;
    public AddressController(AddressServiceImpl service){
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AddressDto> getAll(){
        List<AddressDto> list = service.findAll();
        return list;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AddressDto getById(@PathVariable(name = "id") Integer id){
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable(name = "id") Integer id){
        service.deleteByid(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody AddressDto addressDto){
        service.save(addressDto);
    }
}
