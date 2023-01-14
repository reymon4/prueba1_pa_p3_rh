package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.CuentaBancaria;
import com.example.demo.service.ICuentaBancariaSer;
import com.example.demo.service.ITransferenciaSer;

@SpringBootApplication
public class PruebaPaP3RhApplication implements CommandLineRunner{

	
	@Autowired
	private ICuentaBancariaSer cBService;
	
	@Autowired
	private ITransferenciaSer transService;
	
	public static void main(String[] args) {
		SpringApplication.run(PruebaPaP3RhApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		BigDecimal monto = new BigDecimal(500);
		CuentaBancaria cb1 = new CuentaBancaria();
		
		CuentaBancaria cb2 = new CuentaBancaria();
		
		//Cuenta 1
		cb1.setNumero("224015896");//Para el número de cuenta se considerará que esta tendrá nueve dígitos
		cb1.setCedula("1720589746");
		cb1.setSaldo(new BigDecimal(1000));
		cb1.setTipo("A"); //A = Cuenta de ahorros
		System.out.println("El saldo de la cuenta de origen es :" +cb1.getSaldo());
		//Cuenta 2
		cb2.setCedula("0603358997");
		cb2.setNumero("158748785");
		cb2.setSaldo(new BigDecimal(500));
		
		cb2.setTipo("C"); //C = Cuenta Corriente
		System.out.println("El monto a transferir de la cuenta de origen es: "+monto);
		
		
		
		this.transService.insertar(this.transService.crearTransferencia(cb1.getNumero(), cb2.getNumero(), monto));
		System.out.println("¡Se realizó la transferencia! El saldo actual de la cuenta de origen es de: "+cb1.getSaldo());;
	
		
		
		
		
	}

}
