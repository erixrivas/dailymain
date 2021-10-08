package com.erixrivas.dailymain.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erixrivas.dailymain.domain.entyties.Marca;
import com.erixrivas.dailymain.domain.repository.MarcaRepository;

@Service
@Transactional
public class MarcaService implements ICURDSERVICE<Marca,Integer> {
	private MarcaRepository marcaRepository;

	@Autowired
	public MarcaService(MarcaRepository marcaRepository) {
		super();
		this.marcaRepository = marcaRepository;
	}

	@Override
	public JpaRepository<Marca, Integer> getRepository() {
		return marcaRepository;
	}
}