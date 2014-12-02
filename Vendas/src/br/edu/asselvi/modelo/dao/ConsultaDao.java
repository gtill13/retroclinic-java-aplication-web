package br.edu.asselvi.modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.edu.asselvi.modelo.entidade.Consulta;
import br.edu.asselvi.modelo.entidade.Medicamento;
import br.edu.asselvi.modelo.entidade.Pagamento;

public class ConsultaDao extends DaoBase {
	
	public void inserirPadrao(Consulta consulta) throws DaoException {

		conecta();
		
		executeUpdate("insert into consulta (id_medico, id_paciente, id_medicamento, id_pagamento) values ( '"
				+ consulta.getMedico().getId()           + "', '" + consulta.getPaciente().getId()  + "', '"
				+ consulta.getMedicamento().getId()      + "', '" + consulta.getPagamento().getId() + "' ) ");
		
		commit();

		disconecta();
	}

	public void atualizar(Consulta consulta) throws DaoException {

		PacienteDao pacienteDao = new PacienteDao();
		MedicoDao medicoDao = new MedicoDao();
		MedicamentoDao medicamentoDao = new MedicamentoDao();
		PagamentoDao pagamentoDao = new PagamentoDao();
		conecta();

		pacienteDao.atualizar(consulta.getPaciente());
		medicoDao .atualizar(consulta.getMedico());
		medicamentoDao .atualizar(consulta.getMedicamento());
		pagamentoDao .atualizar(consulta.getPagamento());
		
		commit();

		disconecta();

	}
	
	public void deletar(Consulta consulta) throws DaoException {

		deletar(consulta.getId());
	}

	public void deletar(long id) throws DaoException {

		//EnderecoDao enderecoDao = new EnderecoDao();
		//ContatoDao contatoDao = new ContatoDao();
		conecta();

		executeUpdate("delete from consulta where id = '" + id + "' "); 

		//enderecoDao.deletar(paciente.getEndereco());
		//contatoDao.deletar(paciente.getContato());

		commit();

		disconecta();
	}

	
	public List<Consulta> buscaTodos () {
		
		final PacienteDao pacienteDao = new PacienteDao();
		final MedicoDao medicoDao = new MedicoDao();
		final MedicamentoDao medicamentoDao = new MedicamentoDao();
		final PagamentoDao pagamentoDao = new PagamentoDao();
		final List<Consulta> listConsultas = new ArrayList<Consulta>();
		
		executeQuery("select * from consulta", new Mapeador<Consulta>() {
			public void mapear(ResultSet rset) throws DaoException {
				try {
					while (rset.next()) {
						Consulta consulta = new Consulta();
						
						consulta.setId(rset.getLong("id"));
						
						consulta.setPaciente   (pacienteDao   .buscaPacientePeloId   (rset.getLong("id_paciente"   )));
						consulta.setMedico     (medicoDao     .buscaMedicoPeloId     (rset.getLong("id_medico"     )));
						consulta.setMedicamento(medicamentoDao.buscaMedicamentoPeloId(rset.getLong("id_medicamento")));
						consulta.setPagamento  (pagamentoDao  .buscaPagamentoPeloId  (rset.getLong("id_pagamento"  )));
										
						listConsultas.add(consulta);
					}
				} catch (SQLException e) {
					throw new DaoException("Banco de dados - Erro ao criar lista em " + this.getClass().toString(), e);
				} 
			}
		});
		
		return listConsultas;
	}
	
	public Consulta buscaConsultaPeloId(long id) {

		final Consulta consulta = new Consulta();

		executeQuery("select * from consulta where id = '" + id + "' ",
				new Mapeador<Consulta>() {
					public void mapear(ResultSet rset) throws DaoException {
						try {
							if (rset.next()) {

								PacienteDao pacienteDao = new PacienteDao();
								MedicoDao medicoDao = new MedicoDao();
								MedicamentoDao medicamentoDao = new MedicamentoDao();
								PagamentoDao pagamentoDao = new PagamentoDao();
								
								consulta.setId(rset.getLong("id"));
								
								consulta.setPaciente   (pacienteDao   .buscaPacientePeloId   (rset.getLong("id_paciente"   )));
								consulta.setMedico     (medicoDao     .buscaMedicoPeloId     (rset.getLong("id_medico"     )));
								consulta.setMedicamento(medicamentoDao.buscaMedicamentoPeloId(rset.getLong("id_medicamento")));
								consulta.setPagamento  (pagamentoDao  .buscaPagamentoPeloId  (rset.getLong("id_pagamento"  )));
							}
						} catch (SQLException e) {
							throw new DaoException(
									"Banco de dados - Erro ao criar lista em "
											+ this.getClass().toString(), e);
						} 
					}
				});

		return consulta;
	}

	public void CriaDemo() {
		Consulta consulta = new Consulta();
		MedicoDao medicoDao = new MedicoDao();
		PacienteDao pacienteDao = new PacienteDao();
		Medicamento medicamento = new Medicamento();
		Pagamento pagamento = new Pagamento();
		Random random = new Random();
	
		for(int i = 0; i < 10; ++i)
		{
			
			long idMedico = 0;
			
			while (idMedico == 0)
			{
				idMedico = Math.abs(random.nextInt()%11);
			}
						
			consulta.setMedico(medicoDao.buscaMedicoPeloId(idMedico));

			long idPaciente = 0;
			
			while (idPaciente == 0)
			{
				idPaciente = Math.abs(random.nextInt()%11);
			}
						
			consulta.setPaciente(pacienteDao.buscaPacientePeloId(idPaciente));
			
			medicamento.setNome(stringAleatoria(12));
			medicamento.setDescricao(stringAleatoria(18));
			
			pagamento.setValor(random.nextDouble());
			
			consulta.setMedicamento(medicamento);
			consulta.setPagamento(pagamento);
			
			inserirPadrao(consulta);
		}
		
	}
	
}
