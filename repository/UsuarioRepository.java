package com.firstsoftware.software.repository;

import com.firstsoftware.software.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,String> {

    public Usuario findByCpf(String cpf);


}
