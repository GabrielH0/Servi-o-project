package com.firstsoftware.software.repository;

import com.firstsoftware.software.entity.Servico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoReposiory extends CrudRepository<Servico,Integer> {

}
