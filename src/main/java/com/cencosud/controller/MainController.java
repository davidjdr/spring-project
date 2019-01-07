package com.cencosud.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cencosud.entity.Consulta;
import com.cencosud.entity.PacienteAnciano;
import com.cencosud.entity.PacienteJoven;
import com.cencosud.entity.PacienteMain;
import com.cencosud.exception.FonasaException;
import com.cencosud.service.FonasaService;

@RestController
public class MainController {

	@Autowired
	FonasaService fonasaService;
	
	@RequestMapping(value = "/pacientesMayorRiesgo/{nroHistoriaClinica}", method = RequestMethod.GET)
	public ResponseEntity<List<PacienteMain>> getPacientesMayorRiesgo(@PathVariable(value = "nroHistoriaClinica") Integer nroHistoriaClinica) {
		ResponseEntity<List<PacienteMain>> resp = null;
		
		List<PacienteMain> pacientes = fonasaService.obtenerPacientesMayorRiesgo(nroHistoriaClinica);
		
		resp = new ResponseEntity<>(pacientes, HttpStatus.OK);

		return resp;
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/atenderPacientes", method = RequestMethod.GET)
	public String atenderPaciente() {
		try {
			fonasaService.atenderPacientes();
			return "atencion de pacientes procesada";
		} catch (FonasaException e) {
			return e.getMessage();
		}
	}
	
	@RequestMapping(value = "/liberarConsultas", method = RequestMethod.GET)
	public String liberarConsultas() {
		
		fonasaService.liberarConsultas();
		
		try {
			fonasaService.atenderPacientes();
		} catch (FonasaException e) {
			e.printStackTrace();
		}
		
		return "consultas liberadas";
	}
	
	/**
	 * según la descripción del sistema, los pacientes fumadores son los jóvenes (16-40 años)
	 * Por ello usé la clase PacienteJoven, para sacar los urgentes, si son fumadores 
	 * y ordenados por su riesgo
	 * @return ResponseEntity<List<PacienteJoven>>
	 */
	@RequestMapping(value = "/pacientesFumadoresUrgentes", method = RequestMethod.GET)
	public ResponseEntity<List<PacienteJoven>> getPacientesFumadoresUrgentes() {
		
		List<PacienteJoven> pacientes = fonasaService.obtenerPacientesFumadoresUrgentes();
		
		ResponseEntity<List<PacienteJoven>> resp = null;
		
		resp = new ResponseEntity<>(pacientes, HttpStatus.OK);
		
		return resp;
	}
	
	@RequestMapping(value = "/consulta/pacientesAtentidos", method = RequestMethod.GET)
	public ResponseEntity<List<Consulta>> getConsultaPacientesAtendidos() {
		ResponseEntity<List<Consulta>> resp = null;

		List<Consulta> consultas = fonasaService.obtenerConsultaMasPacAtendidos();
		
		resp = new ResponseEntity<>(consultas, HttpStatus.OK);
		
		return resp;
	}
	
	@RequestMapping(value = "/paciente/enEspera/masEdad", method = RequestMethod.GET)
	public ResponseEntity<List<PacienteMain>> getConsultaPacienteMayor() {
		ResponseEntity<List<PacienteMain>> resp = null;
		
		List<PacienteMain> pacientes = fonasaService.obtenerPacienteDeMasEdad();
		
		resp = new ResponseEntity<>(pacientes, HttpStatus.OK);
		
		return resp;
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/consulta/optimizarAtencion", method = RequestMethod.GET)
	public String consultaOptimizarAtencion() {
		try {
			fonasaService.optimizarAtencion();
			return "atencion optimizada de pacientes procesada";
		} catch (FonasaException e) {
			return e.getMessage();
		}
	}
}
