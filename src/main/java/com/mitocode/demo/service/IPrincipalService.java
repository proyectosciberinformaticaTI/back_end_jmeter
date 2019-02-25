package com.mitocode.demo.service;

import java.util.List;
import java.util.Optional;

import com.mitocode.demo.entidad.Principal;

public interface IPrincipalService {

	
	
	
	public List<Principal> findAll();
	
	public Principal save(Principal principal);
	
	public Optional<Principal> findOne(Long id);

	public void delete(Long id);
	
}
