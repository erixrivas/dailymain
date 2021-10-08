package com.erixrivas.dailymain.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erixrivas.dailymain.domain.entyties.Marca;



public interface MarcaRepository extends JpaRepository<Marca, Integer> {
}
