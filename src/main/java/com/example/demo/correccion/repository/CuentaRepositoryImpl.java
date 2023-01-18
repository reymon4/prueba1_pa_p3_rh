package com.example.demo.correccion.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.correccion.modelo.Cuenta;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CuentaRepositoryImpl implements ICuentaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Cuenta cuentaBanciaria) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cuentaBanciaria);
	}

	@Override
	public void actualizar(Cuenta cuentaBanciaria) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cuentaBanciaria);
	}

	@Override
	public Cuenta buscar(String numero) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Cuenta.class, numero);
	}

	@Override
	public void borrar(String numero) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(numero));
	}

}
