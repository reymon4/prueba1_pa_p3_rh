package com.example.demo.service;

import java.math.BigDecimal;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.CuentaBancaria;
import com.example.demo.modelo.Transferencia;
import com.example.demo.repository.ICuentaBancariaRepo;
import com.example.demo.repository.ITransferenciaRepo;

@Service
public class TransferenciaSerImpl implements ITransferenciaSer{

	@Autowired
	private ITransferenciaRepo transRepo;
	
	@Autowired 
	private ICuentaBancariaRepo cbRepo;
	

	@Override
	public Transferencia crearTransferencia(String origen, String destino, BigDecimal monto) {
		Transferencia trans = new Transferencia();
		CuentaBancaria cBOrigen = this.cbRepo.buscar(origen);
		CuentaBancaria cBDestino = this.cbRepo.buscar(destino);
		
		
		if(cBOrigen.getSaldo().compareTo(monto)==1){//Compara si el saldo de la cuenta es mayor al monto 
			BigDecimal comisionDebitar = cBOrigen.getSaldo().multiply(trans.getComision());
			//Debitamos el monto de la transferencia de la cuenta de origen, incluyendo el valor de la comisión
			cBOrigen.setSaldo(cBOrigen.getSaldo().subtract(comisionDebitar));
			
			//Añadimos el monto a la cuenta de destino
			cBDestino.setSaldo(cBDestino.getSaldo().add(monto));
			
			//Luego, añadimos las características de la trasnferencia
			trans.setDestino(destino);
			trans.setOrigen(origen);
			trans.setMonto(monto);
			trans.setFecha(LocalDateTime.now());
			
			return trans;
			
		}else {
			System.out.println("No se puede realizar la transferencia. ¡El monto es superior al saldo a debitar!");
		}
		
		
		return null;
	
	}

	@Override
	public void insertar(Transferencia trans) {
		// TODO Auto-generated method stub
	
		this.transRepo.insertar(trans);
	}

	
	
	
}
