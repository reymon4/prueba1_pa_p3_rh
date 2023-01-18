package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.correccion.modelo.Cuenta;
import com.example.demo.correccion.service.ICuentaService;
import com.example.demo.correccion.service.ITransferenciaService;



@SpringBootApplication
public class PruebaPaP3RhApplication implements CommandLineRunner{

	@Autowired
	private ICuentaService bancariaService;

	@Autowired
	private ITransferenciaService transferenciaService;

	public static void main(String[] args) {
		SpringApplication.run(PruebaPaP3RhApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// Opcion 1
		Cuenta cuentaOrigen = new Cuenta();
		cuentaOrigen.setNumero("0123456789");
		cuentaOrigen.setCedula("1725840538");
		cuentaOrigen.setTipo("A");
		cuentaOrigen.setSaldo(new BigDecimal(200));

		this.bancariaService.crear(cuentaOrigen);

		Cuenta cuentaDestino = new Cuenta();
		cuentaDestino.setNumero("9876543210");
		cuentaDestino.setCedula("1725840538");
		cuentaDestino.setTipo("C");
		cuentaDestino.setSaldo(new BigDecimal(100));

		this.bancariaService.crear(cuentaDestino);

		// Opcion 2
		this.transferenciaService.realizar("0123456789", "9876543210", new BigDecimal(10));

		// Opcion 3
		System.out.println("El saldo actual es: ");
		System.out.println(this.bancariaService.buscar("0123456789").getSaldo());

	}

}
