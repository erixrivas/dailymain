package com.erixrivas.dailymain.domain.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICURDSERVICE<T,ID> {

	public default void save(T entity) {
		getRepository().save( entity);

	}
	public default void saveAll(Iterable<T> entities) {
		getRepository().saveAll( entities);
	}
	
	public default List<T> getAll() {
		return getRepository().findAll();

	}

	public JpaRepository<T, ID> getRepository();

}