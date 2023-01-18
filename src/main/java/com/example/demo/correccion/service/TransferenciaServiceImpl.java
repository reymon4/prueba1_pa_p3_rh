package com.example.demo.correccion.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.correccion.modelo.Cuenta;
import com.example.demo.correccion.modelo.Transferencia;
import com.example.demo.correccion.repository.ICuentaRepository;
import com.example.demo.correccion.repository.ITransferenciaRepo;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService {

	@Autowired
	private ITransferenciaRepo transferenciaRepo;

	@Autowired
	private ICuentaRepository cuentaRepository;

	@Override
	public void realizar(String numeroOrigen, String numeroDestino, BigDecimal monto) {
		// TODO Auto-generated method stub

		// ORIGEN
		Cuenta origen = this.cuentaRepository.buscar(numeroOrigen);
		// Monto a debitar
		BigDecimal comision = monto.multiply(new BigDecimal(0.05));
		BigDecimal montoDebitar = monto.add(comision);

		BigDecimal saldoActualOrigen = origen.getSaldo();

		// -1 si el de la izquierda es menor
		// 1 si el de la izquierda es mayor
		// 0 iguales

		if (saldoActualOrigen.compareTo(montoDebitar) < 0) {
			System.out.println("Monto no permitido");
		} else {
			// Se realiza la trasnferencia

			origen.setSaldo(saldoActualOrigen);

			this.cuentaRepository.actualizar(origen);
			// DESTINO
			Cuenta destino = this.cuentaRepository.buscar(numeroDestino);
			BigDecimal saldoActualDestino = destino.getSaldo();
			destino.setSaldo(saldoActualDestino.add(monto));
			this.cuentaRepository.actualizar(origen);

			// TRANSFERENCIA
			Transferencia transfer = new Transferencia();
			transfer.setComision(comision);
			transfer.setFecha(LocalDateTime.now());
			transfer.setMonto(monto);
			transfer.setNumeroDestino(numeroDestino);
			transfer.setNumeroOrigen(numeroOrigen);

			this.transferenciaRepo.insertar(transfer);
		}

	}

}
