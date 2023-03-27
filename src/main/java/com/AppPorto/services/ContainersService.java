package com.AppPorto.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.AppPorto.exception.ContainersNotFoundException;
import com.AppPorto.models.Containers;
import com.AppPorto.repository.ContainersRepository;

@Service
public class ContainersService {

	private final ContainersRepository containersRepository;

	public ContainersService(ContainersRepository containersRepository) {
		this.containersRepository = containersRepository;
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Containers> findAll() {
		return containersRepository.findAll();
	}

	private static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public Containers findById(String id) {
		return containersRepository.findById(id).orElseThrow(() -> new ContainersNotFoundException(id));
	}

	@Transactional
	public Containers create(Containers containersCreate) {
		String uuid = getUUID();
		containersCreate.setId(uuid);
		containersRepository.save(containersCreate);
		return containersCreate;
	}

	@Transactional
	public void delete(String id) {
		findById(id);
		containersRepository.deleteById(id);
	}

	public Containers update(String id, Containers containersCreate) {
		Containers containers = findById(id);
		containers.setCliente(containersCreate.getCliente());
		containers.setCategoria(containersCreate.getCategoria());
		containers.setNumeroContainer(containersCreate.getNumeroContainer());
		containers.setStatus(containersCreate.getStatus());
		containers.setTipo(containersCreate.getTipo());
		containersRepository.save(containers);
		return containersCreate;
	}

}
