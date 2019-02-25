package com.mitocode.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.demo.dao.IPrincipalDAO;
import com.mitocode.demo.entidad.Principal;


@Service
public class PrincipalServiceImpl implements IPrincipalService{

@Autowired
private IPrincipalDAO principalDAO;

@Override
public List<Principal> findAll() {
	// TODO Auto-generated method stub
	return (List<Principal>) principalDAO.findAll();
}

@Override
public Principal save(Principal principal) {
	return principalDAO.save(principal);
	
}

@Override
public Optional<Principal> findOne(Long id) {
	// TODO Auto-generated method stub
	
	
	
	return principalDAO.findById(id);
}

@Override
public void delete(Long id) {
	// TODO Auto-generated method stub
	principalDAO.findById(id);
}
	




}
