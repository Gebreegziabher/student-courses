package com.waa.exam.repo;

import com.waa.exam.domain.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepo extends CrudRepository<Address, Integer> {

}
