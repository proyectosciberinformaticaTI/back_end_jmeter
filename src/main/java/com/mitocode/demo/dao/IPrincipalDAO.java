package com.mitocode.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.mitocode.demo.entidad.Principal;

public interface IPrincipalDAO extends JpaRepository<Principal, Integer>{


}
