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
import com.cencosud.entity.Paciente;
import com.cencosud.service.FonasaService;

@RestController
public class MainController {

	@Autowired
	FonasaService fonasaService;
	
	@RequestMapping(value = "/pacientesMayorRiesgo/{nroHistoriaClinica}", method = RequestMethod.GET)
	public ResponseEntity<List<Paciente>> getPacientesMayorRiesgo(@PathVariable(value = "nroHistoriaClinica") Integer nroHistoriaClinica) {
		ResponseEntity<List<Paciente>> resp = null;
		
		List<Paciente> pacientes = fonasaService.obtenerPacientesMayorRiesgo(nroHistoriaClinica);
		
		resp = new ResponseEntity<>(pacientes, HttpStatus.OK);

		return resp;
	}
	
	@RequestMapping(value = "/atenderPaciente", method = RequestMethod.GET)
	public String atenderPaciente() {
		//TODO: por implementar
		
		return null;
	}
	
	@RequestMapping(value = "/liberarConsultas", method = RequestMethod.GET)
	public String liberarConsultas() {
		//TODO: por implementar
		
		return null;
	}
	
	@RequestMapping(value = "/pacientesFumadoresUrgentes", method = RequestMethod.GET)
	public ResponseEntity<List<Paciente>> getPacientesFumadoresUrgentes() {
		//TODO: por implementar
		
		return null;
	}
	
	@RequestMapping(value = "/consulta/pacientesAtentidos", method = RequestMethod.GET)
	public ResponseEntity<List<Consulta>> getConsultaPacientesAtendidos() {
		ResponseEntity<List<Consulta>> resp = null;

		List<Consulta> consultas = fonasaService.obtenerConsultaMasPacAtendidos();
		
		resp = new ResponseEntity<>(consultas, HttpStatus.OK);
		
		return resp;
	}
	
	@RequestMapping(value = "/paciente/enEspera/masEdad", method = RequestMethod.GET)
	public ResponseEntity<List<Paciente>> getConsultaPacienteMayor() {
		ResponseEntity<List<Paciente>> resp = null;
		
		List<Paciente> pacientes = fonasaService.obtenerPacienteDeMasEdad();
		
		resp = new ResponseEntity<>(pacientes, HttpStatus.OK);
		
		return resp;
	}
	
	@RequestMapping(value = "/consulta/optimizarAtencion", method = RequestMethod.GET)
	public ResponseEntity<List<Paciente>> consultaOptimizarAtencion() {
		//TODO: por implementar
		
		return null;
	}
	
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
