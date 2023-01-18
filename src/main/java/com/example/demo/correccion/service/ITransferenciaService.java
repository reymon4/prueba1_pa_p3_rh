package com.example.demo.correccion.service;

import java.math.BigDecimal;

public interface ITransferenciaService {

	public void realizar(String numeroOrigen, String numeroDestino, BigDecimal monto);

}
