package com.firstsoftware.software.repository;

import com.firstsoftware.software.entity.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria,Integer> {
    Categoria findByNome(String nome);
}
