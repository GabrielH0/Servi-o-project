package com.firstsoftware.software.repository;

import com.firstsoftware.software.entity.Uf;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UfRepository extends CrudRepository<Uf,Integer> {


}
