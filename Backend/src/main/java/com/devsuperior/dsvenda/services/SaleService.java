package com.devsuperior.dsvenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvenda.dto.SaleDTO;
import com.devsuperior.dsvenda.dto.SaleSumDTO;
import com.devsuperior.dsvenda.dto.SalesSucessDTO;
import com.devsuperior.dsvenda.entities.Sale;
import com.devsuperior.dsvenda.repositories.SaleRepository;
import com.devsuperior.dsvenda.repositories.SellerRepository;


@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		
		sellerRepository.findAll();
		Page<Sale> result=repository.findAll(pageable);
		return  result.map(x->new SaleDTO(x));
	}
	
	
	@Transactional(readOnly = true)
	public 	List<SaleSumDTO> amountGroupedBySeller(){
		return repository.amountGroupedBySeller();
	};
	
	@Transactional(readOnly = true)
	public List<SalesSucessDTO> sucessGroupedBySeller(){
		return repository.sucessGroupedBySeller();
		
	}
	
}