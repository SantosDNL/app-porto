package com.AppPorto.controller.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.AppPorto.controller.dto.ContainersCreateDTO;
import com.AppPorto.controller.dto.ContainersDTO;
import com.AppPorto.models.Containers;

@Component
public class ContainersMapper {

	private static final ModelMapper MODEL_MAPPER = new ModelMapper();

	public ContainersDTO toContainersDTO(Containers containers) {
		return MODEL_MAPPER.map(containers, ContainersDTO.class);
	}

	public List<ContainersDTO> toContainerDTOList(List<Containers> containersList) {
		return containersList.stream().map(this::toContainersDTO).collect(Collectors.toList());
	}

	public Containers toContainers(ContainersDTO dto) {
		return MODEL_MAPPER.map(dto, Containers.class);
	}

	public Containers toContainersCreate(ContainersCreateDTO dto) {
		return MODEL_MAPPER.map(dto, Containers.class);
	}

}
