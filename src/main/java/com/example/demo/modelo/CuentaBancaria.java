package com.example.demo.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cBancaria")
public class CuentaBancaria {
	
	@Id
	@Column (name = "cB_numero")
	private String numero;
	
	@Column (name = "cB_tipo")
	private String tipo;
	
	@Column (name = "cB_saldo")
	private BigDecimal saldo;
	
	@Column (name = "cb_cedula_propietario")
	private String cedula;

	
	
	//Getters and Setters
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	
	
}


