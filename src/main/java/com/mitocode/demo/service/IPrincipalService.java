package com.mitocode.demo.service;

import java.util.List;
import java.util.Optional;

import com.mitocode.demo.entidad.Principal;

public interface IPrincipalService extends ICRUD<Principal>{

	
	
	
	public List<Principal> findAll();
	
	public Principal save(Principal principal);

	public Principal update(Principal principal);
	
	public void delete(int id);
	
	public Principal listaporId(int id);

	
}
