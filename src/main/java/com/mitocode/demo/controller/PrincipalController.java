package com.mitocode.demo.controller;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.mitocode.demo.entidad.Principal;
import com.mitocode.demo.service.IPrincipalService;
import com.proyecto.demo.exception.ModeloNotFoundException;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/principal")
public class PrincipalController {

	@Autowired
	private IPrincipalService principalService;

	@GetMapping(value = "/saludo")
	public List<Principal> principal() {	

		return principalService.findAll();
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> crearprincipal(@Valid @RequestBody Principal principal) {
		Principal pr = new Principal();
		pr = principalService.save(principal);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codigo}").buildAndExpand(pr.getCodigo()).toUri();
		return ResponseEntity.created(location).build();

	}
	
	
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@Valid @RequestBody Principal paciente) {		
		principalService.update(paciente);
		return new ResponseEntity<Object>(HttpStatus.OK);
	
	}
	
	
	
	@GetMapping(value = "/{id}")
	public Resource<Principal> listarId(@PathVariable("id") Integer id) {
	
		Principal pac = principalService.listaporId(id);
		
		if (pac == null) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		
		Resource<Principal> resource = new Resource<Principal>(pac);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarId(id));
		resource.add(linkTo.withRel("paciente-resource"));
		
		return resource;
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable Integer id) {
		Principal pac = principalService.listaporId(id);
		System.out.println("Entro"+id);
		if (pac == null) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			principalService.delete(id);
		}
	}
	
}
