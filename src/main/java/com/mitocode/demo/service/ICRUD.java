package com.mitocode.demo.service;

import java.util.List;

import com.mitocode.demo.entidad.Principal;

public interface ICRUD<T> {
	
	
	 List<T> findAll();
	
	T save(T principal);

	 T update(T principal);
	
	 void delete(int id);
	
	T listaporId(int id);


}
