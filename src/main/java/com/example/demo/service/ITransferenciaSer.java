package com.example.demo.service;

import java.math.BigDecimal;

import com.example.demo.modelo.Transferencia;

public interface ITransferenciaSer {
	
	public Transferencia crearTransferencia(String origen, String destino, BigDecimal monto);
	public void insertar(Transferencia trans);
	


}
