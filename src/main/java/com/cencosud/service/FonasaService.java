package com.cencosud.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cencosud.dao.ConsultaDAO;
import com.cencosud.dao.PacienteAncianoDAO;
import com.cencosud.dao.PacienteJovenDAO;
import com.cencosud.dao.PacienteMainDAO;
import com.cencosud.dao.PacienteNinoDAO;
import com.cencosud.dao.SalaDeEsperaDAO;
import com.cencosud.entity.Consulta;
import com.cencosud.entity.PacienteJoven;
import com.cencosud.entity.PacienteMain;
import com.cencosud.entity.SalaDeEspera;
import com.cencosud.exception.FonasaException;
import com.cencosud.util.Variables;

@Service
public class FonasaService {
	
	@Autowired
	PacienteMainDAO pacienteMainDAO;
	@Autowired
	PacienteNinoDAO pacienteNinoDAO;
	@Autowired
	PacienteJovenDAO pacienteJovenDAO;
	@Autowired
	PacienteAncianoDAO pacienteAncianoDAO;
	@Autowired
	ConsultaDAO consultaDAO;
	@Autowired
	SalaDeEsperaDAO salaDeEsperaDAO;
	
	
	
	@Transactional
	public List<PacienteMain> obtenerPacientesMayorRiesgo(Integer nroHistoriaClinica) {
		List<PacienteMain> pacientes = pacienteMainDAO.getPacientesMayorRiesgo(nroHistoriaClinica);
		
		return pacientes;
	}
	
	@Transactional
	public List<Consulta> obtenerConsultaMasPacAtendidos() {
		List<Consulta> consultas = consultaDAO.getConsultaPacientesAtendidos();
		
		return consultas;
	}
	
	@Transactional
	public List<PacienteMain> obtenerPacienteDeMasEdad() {
		List<PacienteMain> pacientes = pacienteMainDAO.obtenerPacienteDeMasEdad();
		
		return pacientes;
	}

	@Transactional
	public void liberarConsultas() {

		consultaDAO.liberarConsultas();
	}

	@Transactional
	public List<PacienteMain> prueba() {
		return pacienteMainDAO.prueba();
	}

	@Transactional
	public List<PacienteJoven> obtenerPacientesFumadoresUrgentes() {
		List<PacienteJoven> pacientes = pacienteJovenDAO.obtenerPacientesFumadoresUrgentes();
				
		return pacientes;
	}

	/**
	 * 
	 * @return Boolean
	 * @throws FonasaException 
	 */
	@Transactional
	public void atenderPacientes() throws FonasaException {
		atiendoPacientesSalaDeEspera();
		atiendoPacientesRestantes();
	}

	private void atiendoPacientesSalaDeEspera() {
		List<PacienteMain>  pacientes = pacienteMainDAO.obtenerPacientesEnSalaDeEspera();
		List<Consulta> consultas = consultaDAO.obtenerConsultasDesocupadas();
		
		//primero atiendo pacientes que estaban en sala de espera
		for (PacienteMain paciente : pacientes) {
			BigDecimal prioridadReq = new BigDecimal(4.1);
			
			//-1 menor, 0 igual , or 1 mayor
			if (paciente.getPrioridad().compareTo(prioridadReq) < 1) {
				if (paciente.getTipo() == Variables.PACIENTE_NINO) {
					// paciente es niño con prioridad menor o igual a 4
					if (agregarPacienteAConsulta(paciente, consultas, Variables.PEDIADRIA)) {
						removerDeSalaDeEspera(paciente);
					}
				} else {
					if (agregarPacienteAConsulta(paciente, consultas, Variables.CGI)) {
						removerDeSalaDeEspera(paciente);
					}
				}
			} else {
				// para urgencias!
				if (agregarPacienteAConsulta(paciente, consultas, Variables.URGENCIA)) {
					removerDeSalaDeEspera(paciente);
				}
			}
		}
	}
	
	/**
			Segundo atiendo a los pacientes pendientes, pero...
			los pendientes son todos los registros de la entidad Paciente?
			En el punto 3 del flujo se menciona: 
				Si luego de atendidos los de la sala de espera no quedara ninguna consulta libre, entonces
				el paciente de la sala de pendiente que le corresponde ser atendido según su prioridad, pasa a la sala
				de espera, sino será atendido por la consulta adecuada.
			Menciona una sala de pendiente unicamente en este punto del ejercicio, pero no menciona como llenar dicha sala
			o si con eso se refiere a todos los pacientes ingresados en el sistema, lo cual a nivel de un hospital real
			no resulta muy logico... (el paciente existe solo si lo estan atendiendo?)
			
			para poder avanzar con el ejercicio asumire que son todos los pacientes del sistema, que no esten ya en consulta
	*/
	private void atiendoPacientesRestantes() {
		List<PacienteMain>  pacientes = pacienteMainDAO.obtenerPacientesParaAtender();
		List<Consulta> consultas = consultaDAO.obtenerConsultasDesocupadas();

		for (PacienteMain paciente : pacientes) {
			BigDecimal prioridadReq = new BigDecimal(4.1);
			
			//-1 menor, 0 igual , or 1 mayor
			if (paciente.getPrioridad().compareTo(prioridadReq) < 1) {
				if (paciente.getTipo() == Variables.PACIENTE_NINO) {
					// paciente es niño con prioridad menor o igual a 4
					if (!agregarPacienteAConsulta(paciente, consultas, Variables.PEDIADRIA)) {
						agregarASalaDeEspera(paciente);
					}
				} else {
					if (!agregarPacienteAConsulta(paciente, consultas, Variables.CGI)) {
						agregarASalaDeEspera(paciente);
					}
				}			
			} else {
				// para urgencias!
				if (!agregarPacienteAConsulta(paciente, consultas, Variables.URGENCIA)) {
					agregarASalaDeEspera(paciente);
				}
			}
		}
	}
	
	private Boolean agregarPacienteAConsulta(PacienteMain paciente, List<Consulta> consultas, Integer tipoCosulta) {
		List<Consulta> consultasPorTipo = consultas.stream()
				.filter(consulta -> consulta.getTipoConsulta().getIdTipoConsulta() == tipoCosulta
						&& consulta.getIdPaciente() == null
						&& consulta.getHospital() == paciente.getHospital())
				.collect(Collectors.toList());
		Boolean agregado = false;
		if (!consultasPorTipo.isEmpty()) {
			for (Consulta c : consultasPorTipo) {
				c.setIdPaciente(paciente.getIdPaciente());
				consultaDAO.saveOrUpdate(c);
				agregado = true;
				break;
			}
		}
		return agregado;
	}
	
	private void removerDeSalaDeEspera(PacienteMain paciente) {
		SalaDeEspera entity = new SalaDeEspera(paciente.getIdPaciente());
		salaDeEsperaDAO.remove(entity);
	}

	private void agregarASalaDeEspera(PacienteMain paciente) {
		SalaDeEspera entity = new SalaDeEspera(paciente.getIdPaciente());
		salaDeEsperaDAO.saveOrUpdate(entity);
	}

	/**
	 * Esta funcionalidad la veo como una combinacion de atender pacientes (pero organizada segun gravedad y tipo (niños y ancianos primero)
	 * igual con sala de espera pero segun prioridad y urgencia (riesgo supongo, pero el ejercicio dice urgencia)
	 */
	@Transactional
	public void optimizarAtencion() throws FonasaException {
		atiendoPacientesSalaDeEsperaPriorizados();
		atiendoPacientesRestantesPriorizados();
		//Finalmente libera todas las consultas, segun enunciado
		liberarConsultas();
	}

	private void atiendoPacientesRestantesPriorizados() {
		List<PacienteMain> pacientes = pacienteMainDAO.obtenerPacientesParaAtenderPriorizados();
		List<Consulta> consultas = consultaDAO.obtenerConsultasDesocupadas();

		for (PacienteMain paciente : pacientes) {
			BigDecimal prioridadReq = new BigDecimal(4.1);
			
			//-1 menor, 0 igual , or 1 mayor
			if (paciente.getPrioridad().compareTo(prioridadReq) < 1) {
				if (paciente.getTipo() == Variables.PACIENTE_NINO) {
					// paciente es niño con prioridad menor o igual a 4
					agregarPacienteAConsulta(paciente, consultas, Variables.PEDIADRIA);
				} else {
					agregarPacienteAConsulta(paciente, consultas, Variables.CGI);
				}			
			} else {
				// para urgencias!
				agregarPacienteAConsulta(paciente, consultas, Variables.URGENCIA);
			}
		}
	}

	private void atiendoPacientesSalaDeEsperaPriorizados() {
		List<PacienteMain>  pacientes = pacienteMainDAO.obtenerPacientesEnSalaDeEsperaPriorizados();
		List<Consulta> consultas = consultaDAO.obtenerConsultasDesocupadas();
		
		//primero atiendo pacientes que estaban en sala de espera
		for (PacienteMain paciente : pacientes) {
			BigDecimal prioridadReq = new BigDecimal(4.1);
			
			//-1 menor, 0 igual , or 1 mayor
			if (paciente.getPrioridad().compareTo(prioridadReq) < 1) {
				if (paciente.getTipo() == Variables.PACIENTE_NINO) {
					// paciente es niño con prioridad menor o igual a 4
					agregarPacienteAConsulta(paciente, consultas, Variables.PEDIADRIA);
				} else {
					agregarPacienteAConsulta(paciente, consultas, Variables.CGI);
				}			
			} else {
				// para urgencias!
				agregarPacienteAConsulta(paciente, consultas, Variables.URGENCIA);
			}
		}
	}
}
