package com.waa.exam.service;

import com.waa.exam.domain.dto.AddressDto;
import java.util.List;

public interface AddressService {
    List<AddressDto> findAll();
    AddressDto findById(int id);
    void deleteByid(int id);
    void save(AddressDto addressDto);
    void update(int id, AddressDto addressDto);
}
