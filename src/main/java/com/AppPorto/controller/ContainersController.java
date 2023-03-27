package com.AppPorto.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AppPorto.controller.dto.ContainersCreateDTO;
import com.AppPorto.controller.dto.ContainersDTO;
import com.AppPorto.controller.mapper.ContainersMapper;
import com.AppPorto.models.Containers;
import com.AppPorto.services.ContainersService;

@RestController
@RequestMapping("/containers")
public class ContainersController {

	private final ContainersService containersService;
	private final ContainersMapper containersMapper;

	public ContainersController(ContainersService containersService, ContainersMapper containersMapper) {
		this.containersService = containersService;
		this.containersMapper = containersMapper;
	}

	@GetMapping
	public ResponseEntity<List<ContainersDTO>> findAll() {
		List<Containers> containersList = containersService.findAll();
		List<ContainersDTO> result = containersMapper.toContainerDTOList(containersList);
		return ResponseEntity.ok(result);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ContainersDTO> findById(@PathVariable String id) {
		Containers containers = containersService.findById(id);
		ContainersDTO result = containersMapper.toContainersDTO(containers);
		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable String id) {
		containersService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping
	public ResponseEntity<ContainersDTO> create(@RequestBody ContainersCreateDTO dto) {

		var containersCreate = containersMapper.toContainersCreate(dto);
		var containers = containersService.create(containersCreate);
		var result = containersMapper.toContainersDTO(containers);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ContainersDTO> update(@PathVariable String id,
			@RequestBody ContainersCreateDTO containersCreateDTO) {

		Containers containersUpdate = containersMapper.toContainersCreate(containersCreateDTO);
		Containers containers = containersService.update(id, containersUpdate);
		return ResponseEntity.ok(containersMapper.toContainersDTO(containers));

	}

}
