package com.firstsoftware.software.repository;

import com.firstsoftware.software.entity.Rua;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuaRepository extends CrudRepository<Rua,Integer> {
    Rua findByNome(String nome);
}
