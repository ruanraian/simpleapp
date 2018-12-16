package br.com.simpleapp.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.simpleapp.domain.Cliente;
import br.com.simpleapp.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteResource {

	private final Logger log = LoggerFactory.getLogger(ClienteResource.class);
	
	private final ClienteService clienteService;
	
	public  ClienteResource(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping
	public ResponseEntity<Cliente> criarCliente(@Valid @RequestBody Cliente cliente) throws URISyntaxException {
		log.info("Inicializando api para salvar cliente");
		Cliente savedCliente = clienteService.save(cliente);
		log.info("Cliente com id {} salvo com sucesso", savedCliente.getId());
		return ResponseEntity.created(new URI("api/clientes/" + savedCliente.getId())).body(savedCliente);

	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	public List<Cliente> obterClientes(){
		log.info("Obtendo lista com todos os clientes");
		return clienteService.findAll();
	}
}
