package com.mitocode.demo.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mitocode.demo.entidad.Principal;
import com.mitocode.demo.service.IPrincipalService;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
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
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pr.getCodigo())
				.toUri();
		return ResponseEntity.created(location).build();

	}
}
