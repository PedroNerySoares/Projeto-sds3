package com.devsuperior.dsvenda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvenda.dto.SaleDTO;
import com.devsuperior.dsvenda.dto.SaleSumDTO;
import com.devsuperior.dsvenda.dto.SalesSucessDTO;
import com.devsuperior.dsvenda.services.SaleService;


@RestController
@RequestMapping(value="/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
		Page<SaleDTO>list =service.findAll(pageable);
		return ResponseEntity.status(200).body(list);
		
	}
	

	@GetMapping(value="/amount-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller(){
		List<SaleSumDTO> list = service.amountGroupedBySeller();
		return ResponseEntity.status(200).body(list);
		
	}
	
	@GetMapping(value="/succes-by-seller")
	public ResponseEntity<List<SalesSucessDTO>> sucessGroupedBySeller(){
		List<SalesSucessDTO> list = service.sucessGroupedBySeller();
		return ResponseEntity.status(200).body(list);
		
	}
	
	
}
