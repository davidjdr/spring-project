package com.cencosud.service;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cencosud.dao.ConsultaDAO;
import com.cencosud.dao.PacienteDAO;
import com.cencosud.entity.Consulta;
import com.cencosud.entity.Paciente;

@Service
public class FonasaService {

	@Autowired
	PacienteDAO pacienteDAO;

	@Autowired
	ConsultaDAO consultaDAO;
	
	@Transactional
	public List<Paciente> obtenerPacientesMayorRiesgo(BigDecimal riesgo) {
		List<Paciente> pacientes = pacienteDAO.getPacientesMayorRiesgo(riesgo);
		
		return pacientes;
	}
	
	@Transactional
	public Consulta obtenerConsultaMasPacAtendidos() {
		Consulta consulta = consultaDAO.getConsultaPacientesAtendidos();
		
		return consulta;
	}
}
