package com.example.demo.correccion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.correccion.modelo.Cuenta;
import com.example.demo.correccion.repository.ICuentaRepository;

@Service
public class CuentaServiceImpl implements ICuentaService {

	@Autowired
	private ICuentaRepository iCuentaBancariaRepository;

	@Override
	public void crear(Cuenta cuentaBanciaria) {
		// TODO Auto-generated method stub
		this.iCuentaBancariaRepository.insertar(cuentaBanciaria);
	}

	@Override
	public void modificar(Cuenta cuentaBanciaria) {
		// TODO Auto-generated method stub
		this.iCuentaBancariaRepository.actualizar(cuentaBanciaria);
	}

	@Override
	public Cuenta buscar(String numero) {
		// TODO Auto-generated method stub
		Cuenta bancaria = this.iCuentaBancariaRepository.buscar(numero);
		System.out.println("El saldo de la cuenta es: " + bancaria.getSaldo());
		return bancaria;

	}

	@Override
	public void borrar(String numero) {
		// TODO Auto-generated method stub
		this.iCuentaBancariaRepository.borrar(numero);
	}

}
