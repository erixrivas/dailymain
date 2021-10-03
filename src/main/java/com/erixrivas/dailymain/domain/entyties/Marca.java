package com.erixrivas.dailymain.domain.entyties;

public class Marca {
	private Integer id;
	private String descripcion;
	private String alias;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public Marca() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Marca(Integer id, String descripcion, String alias) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.alias = alias;
	}
	
	
	
}
