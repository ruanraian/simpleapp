package br.com.simpleapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.simpleapp.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
