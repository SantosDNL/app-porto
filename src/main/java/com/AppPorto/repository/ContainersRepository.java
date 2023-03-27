package com.AppPorto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AppPorto.models.Containers;

@Repository
public interface ContainersRepository extends JpaRepository<Containers, String>{

}
