package com.firstsoftware.software.repository;

import com.firstsoftware.software.entity.Cidade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends CrudRepository<Cidade,Integer> {
    Cidade findByNome(String name);

}
