package com.devsuperior.dsmeta.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repository.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;

	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {

		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

		LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);

		return repository.findAll(min, max, pageable);
	}

	public Sale getSaleId(Long saleId) {

		Optional<Sale> sale = Optional.of(repository.findById(saleId).orElseThrow(RuntimeException::new));

		return sale.get();
	}

}
