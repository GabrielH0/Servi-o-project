package com.firstsoftware.software.repository;

import com.firstsoftware.software.entity.Local;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalRepository extends CrudRepository<Local,Integer> {

}
