package com.devsuperior.dsvenda.dto;

import java.io.Serializable;

import com.devsuperior.dsvenda.entities.Seller;

public class SellerDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long Id;
	private String Name;
	
	public SellerDTO() {}

	public SellerDTO(Long id, String name) {
		Id = id;
		Name = name;
	}
	
	public SellerDTO(Seller entity) {
		Id = entity.getId();
		Name = entity.getName();
	}

	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	};
	
	
	
	
}
