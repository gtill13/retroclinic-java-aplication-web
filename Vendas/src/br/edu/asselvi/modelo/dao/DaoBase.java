package br.edu.asselvi.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Random;

public class DaoBase {

	private static final ThreadLocal<Connection> context = new ThreadLocal<Connection>();
	private Statement statement;
	private ResultSet rset;

	public long getGenerationKeys() throws DaoException {
		try {
			if (rset.next())
				return rset.getLong(1);
			else
				throw new DaoException(
						"Banco de dados - Erro ao buscar generation Keys!");
		} catch (SQLException e) {
			throw new DaoException(
					"Banco de dados - Erro ao buscar generation Keys!", e);
		}
	}

	public void conectaPeloContext() throws DaoException {

		if (context.get() == null)
			throw new DaoException("Banco de dados - Erro falha no contexto!");

		Connection connection = null;
		try {
			connection = context.get();

			statement = connection.createStatement();
		} catch (SQLException e) {
			throw new DaoException("Banco de dados - Erro ao tentar conectar!",
					e);
			// System.out.println("Banco de dados - Erro ao tentar conectar!");
		}

	}

	public void novaConecao() throws DaoException {
		try {

			Connection connection = null;

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/clinicabd", "root", "1234");
			connection.setAutoCommit(false);
			context.set(connection);

			statement = connection.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			throw new DaoException("Banco de dados - Erro ao tentar conectar!",
					e);
			// System.out.println("Banco de dados - Erro ao tentar conectar!");
		}
	}

	public void conecta() throws DaoException {
		try {

			Connection connection = null;

			if (context.get() == null) {

				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager
						.getConnection("jdbc:mysql://localhost:3306/clinicabd",
								"root", "1234");
				connection.setAutoCommit(false);
				context.set(connection);

			} else {
				connection = context.get();
			}

			statement = connection.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			throw new DaoException("Banco de dados - Erro ao tentar conectar!",
					e);
			// System.out.println("Banco de dados - Erro ao tentar conectar!");
		}
	}

	public void disconecta() throws DaoException {
		try {
			if (statement != null)
				statement.close();
			if (context.get() != null) {
				context.get().close();
				context.remove();
			}
		} catch (SQLException e) {
			throw new DaoException(
					"Banco de dados - Erro ao tentar disconectar!", e);
			// System.out.println("Banco de dados - Erro ao tentar disconectar!");
		}
	}

	public void executeUpdate(String sql) throws DaoException {

		if (statement == null) {
			throw new DaoException(
					"Banco de dados - Erro ao tentar disconectar!");
			// System.out.println("Banco de dados - Não conectado!");
		}

		try {
			statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			setRset(statement.getGeneratedKeys());

		} catch (SQLException e) {
			throw new DaoException(
					"Banco de dados - Falha ao executar comando: " + sql, e);
			// System.out.println("Banco de dados - Falha ao executar comando: "
			// + sql);
		}

	}

	private void setRset(ResultSet rset) {
		this.rset = rset;
	}

	public void commit() throws DaoException {
		if (context.get() == null)
			throw new DaoException("Banco de dados - Sem conexão!");

		try {
			context.get().commit();
		} catch (SQLException e) {
			throw new DaoException("Banco de dados - Falha ao comitar!");
		}

	}

	public <T> void executeQuery(String sql, Mapeador<T> map)
			throws DaoException {

		novaConecao();

		try {
			map.mapear(statement.executeQuery(sql));
		} catch (SQLException e) {
			throw new DaoException(
					"Banco de dados - Erro ao executar comando: " + sql, e);
		} finally {
			disconecta();
		}
	}

	public void CriaBanco() throws SQLException {
		Connection Conn = DriverManager
				.getConnection("jdbc:mysql://localhost/?user=root&password=1234");
		Statement s = Conn.createStatement();
		@SuppressWarnings("unused")
		int Result = s.executeUpdate("CREATE DATABASE clinicabd");

		Result = s
				.executeUpdate("CREATE TABLE clinicabd.PACIENTE(ID INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,NOME VARCHAR(255),RG VARCHAR(20),CPF VARCHAR(20),SEXO VARCHAR(1),ID_RESPONSAVEL INTEGER,ID_CONTATO INTEGER,ID_ENDERECO INTEGER);");
		Result = s
				.executeUpdate("CREATE TABLE clinicabd.MEDICO(ID  INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,CRM VARCHAR(20),NOME VARCHAR(255),CPF VARCHAR(20),ID_CONTATO INTEGER,ID_ENDERECO INTEGER);");
		Result = s
				.executeUpdate("CREATE TABLE clinicabd.CONTATO(ID  INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,EMAIL VARCHAR(255),TELEFONE VARCHAR(20),CELULAR VARCHAR(20));");
		Result = s
				.executeUpdate("CREATE TABLE clinicabd.ENDERECO(ID  INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,ENDERECO VARCHAR(255),CIDADE VARCHAR(255),CEP VARCHAR(20),BAIRRO VARCHAR(255));");
		Result = s
				.executeUpdate("CREATE TABLE clinicabd.CONSULTA(ID  INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,ID_MEDICO INTEGER,ID_PACIENTE INTEGER,ID_MEDICAMENTO INTEGER,ID_PAGAMENTO INTEGER);");
		Result = s
				.executeUpdate("CREATE TABLE clinicabd.PAGAMENTO(ID INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,VALOR DOUBLE,DESCRICAO VARCHAR(255));");
		Result = s
				.executeUpdate("CREATE TABLE clinicabd.MEDICAMENTO(ID  INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,NOME VARCHAR(255),DESCRICAO VARCHAR(255));");

		PacienteDao pacienteDao = new PacienteDao();
		pacienteDao.CriaDemo();
		MedicoDao medicoDao = new MedicoDao();
		medicoDao.CriaDemo();
		ConsultaDao consultaDao = new ConsultaDao();
		consultaDao.CriaDemo();

	}

	public String stringAleatoria(int tamanho) {

		String letras = "ABCDEFGHIJKLMNOPQRSTUVYWXZ";

		Random random = new Random();

		String string = "";
		int index = -1;
		for (int i = 0; i < tamanho; i++) {
			index = random.nextInt(letras.length());
			string += letras.substring(index, index + 1);
		}
		
		return string; 
	}
}
