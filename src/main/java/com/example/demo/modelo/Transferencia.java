package com.example.demo.modelo;

import java.math.BigDecimal;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table ( name ="transferencia")
public class Transferencia {

	@Id
	@Column (name = "trans_id")
	@SequenceGenerator(name="trans_sec", sequenceName= "trans_sec", allocationSize =1)
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "trans_sec")
	private Integer id;
	
	@Column (name = "trans_fecha")
	private LocalDateTime fecha; //Tipo de dato para la fecha en SQL
	
	@Column (name = "trans_origen")
	private String origen;
	
	@Column (name = "trans_destino")
	private String destino;
	
	@Column (name ="trans_monto")
	private BigDecimal monto;
	
	@Column (name = "trans_comision")
	private BigDecimal comision = new BigDecimal(0.05);

	
	//Getters and Setters
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public BigDecimal getComision() {
		return comision;
	}

	
	
	
	
	
	
	
	
	
	
}
