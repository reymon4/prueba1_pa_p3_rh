package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Transferencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class TransferenciaRepoImpl implements ITransferenciaRepo{

	
	@PersistenceContext
	private EntityManager eM;
	@Override
	public void insertar(Transferencia trans) {
		// TODO Auto-generated method stub
		this.eM.persist(trans);
	}

}
