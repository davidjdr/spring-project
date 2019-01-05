package com.cencosud.controller;

import java.math.BigDecimal;
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

import com.cencosud.dao.ConsultaDAO;
import com.cencosud.dao.PacienteDAO;
import com.cencosud.entity.Consulta;
import com.cencosud.entity.Paciente;
import com.cencosud.service.FonasaService;
import com.fasterxml.jackson.annotation.JsonIgnore;

@RestController
public class MainController {

	@Autowired
	FonasaService fonasaService;
	
	@RequestMapping(value = "/pacientesMayorRiesgo/{riesgo}", method = RequestMethod.GET)
	public ResponseEntity<List<Paciente>> getPacientesMayorRiesgo(@PathVariable(value = "riesgo") BigDecimal riesgo) {
		ResponseEntity<List<Paciente>> resp = null;
		
		List<Paciente> pacientes = fonasaService.obtenerPacientesMayorRiesgo(riesgo);
		
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
	public ResponseEntity<Consulta> getConsultaPacientesAtendidos() {
		ResponseEntity<Consulta> resp = null;

		Consulta consulta = fonasaService.obtenerConsultaMasPacAtendidos();
		
		resp = new ResponseEntity<>(consulta, HttpStatus.OK);
		
		return resp;
	}
	
	@RequestMapping(value = "/paciente/mayor", method = RequestMethod.GET)
	public ResponseEntity<List<Paciente>> getConsultaPacienteMayor() {
		//TODO: por implementar
		
		return null;
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
