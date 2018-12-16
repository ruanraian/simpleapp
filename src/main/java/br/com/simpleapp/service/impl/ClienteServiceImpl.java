package br.com.simpleapp.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.simpleapp.domain.Cliente;
import br.com.simpleapp.domain.enums.Risco;
import br.com.simpleapp.repository.ClienteRepository;
import br.com.simpleapp.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	private final Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);
	
	private final ClienteRepository clienteRepository;
	
	public ClienteServiceImpl(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	@Override
	public Cliente save(Cliente cliente) {
		log.debug("Inicializando save com cliente {}", cliente);
		switch (cliente.getRisco()) {
		case B:
			cliente.setTaxaJuros(10d);
			break;
		case C:
			cliente.setTaxaJuros(20d);
			break;
		default:
			cliente.setTaxaJuros(0d);
			break;
		}
		return clienteRepository.save(cliente);
	}

	@Override
	public List<Cliente> findAll() {
		log.debug("Listando todos os clientes");
		return clienteRepository.findAll();
	}

}
