package com.example.demo.correccion.repository;

import com.example.demo.correccion.modelo.Cuenta;

public interface ICuentaRepository {

	public void insertar(Cuenta cuentaBanciaria);

	public void actualizar(Cuenta cuentaBanciaria);

	public Cuenta buscar(String numero);

	public void borrar(String numero);

}
