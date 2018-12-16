package br.com.simpleapp.service;

import java.util.List;

import br.com.simpleapp.domain.Cliente;

public interface ClienteService {

	Cliente save(Cliente cliente);
	
	List<Cliente> findAll();
	
}
