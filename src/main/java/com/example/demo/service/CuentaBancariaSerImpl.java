package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.CuentaBancaria;
import com.example.demo.repository.ICuentaBancariaRepo;

@Service
public class CuentaBancariaSerImpl implements ICuentaBancariaSer {

	
	@Autowired
	private ICuentaBancariaRepo cBRepo;
	
	
	
	@Override
	public CuentaBancaria buscar(String numero) {
		// TODO Auto-generated method stub
		return this.cBRepo.buscar(numero);
	}

}
