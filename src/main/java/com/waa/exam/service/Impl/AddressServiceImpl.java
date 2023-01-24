package com.waa.exam.service.Impl;

import com.waa.exam.domain.Address;
import com.waa.exam.domain.dto.AddressDto;
import com.waa.exam.repo.AddressRepo;
import com.waa.exam.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {
    private AddressRepo repo;
    private ModelMapper modelMapper;
    public AddressServiceImpl(AddressRepo repo, ModelMapper modelMapper){
        this.repo = repo;
        this.modelMapper = modelMapper;
    }
    public List<AddressDto> findAll(){
        List<Address> list = new ArrayList();
        repo.findAll().forEach(list::add);
        List<AddressDto> dtos =  list.stream().map(m -> modelMapper.map(m, AddressDto.class)).collect(Collectors.toList());

        return dtos;
    }
    public AddressDto findById(int id){
        return modelMapper.map(repo.findById(id).get(), AddressDto.class);
    }
    public void deleteByid(int id){
        repo.deleteById(id);
    }
    public void save(AddressDto dto){
        Address address = new Address();
        address.setState(dto.getState());
        address.setCity(dto.getCity());
        address.setZipcode(dto.getZipcode());
        repo.save(address);
    }
    public void update(int id, AddressDto addressDto){
        Address address = new Address();
        address.setState(addressDto.getState());
        address.setCity(addressDto.getCity());
        address.setZipcode(addressDto.getZipcode());
        //repo.update(id, address);
    }
}
