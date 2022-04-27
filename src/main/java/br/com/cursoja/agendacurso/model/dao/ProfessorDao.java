package br.com.cursoja.agendacurso.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.cursoja.agendacurso.model.entidade.Curso;
import br.com.cursoja.agendacurso.model.entidade.Professor;

public class ProfessorDao extends Conexao {
	
	
	public void cadastrar (Professor p) {
		
		String sql = "insert into professor " + "(valorHora, nome, celular) values"
		+ "(?, ?, ?)";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setDouble(1, p.getValorHora());
			ps.setString(2, p.getNome());
			ps.setString(3, p.getCelular());
			ps.execute();
			
		} catch (SQLException e) {
			System.out.println("Deu problema no Insert ");
			e.printStackTrace();	
			
		}finally {
			fecharConexao();
		}
	}
	
	public ArrayList<Professor>listar(String nomeBusca) {
		ArrayList<Professor> lista = new ArrayList<Professor>();
		
		String sql = "select * from professor " + "where nome like ? "
		+ "order by nome";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setString(1, "%" + nomeBusca + "%");
			
			ResultSet rs = ps.executeQuery();
			Professor p;
			while(rs.next()) {
				p = new Professor();
				p.setId(rs.getLong("idprofessor"));
				p.setValorHora(rs.getDouble("valorHora"));
				p.setNome(rs.getString("nome"));
				p.setCelular(rs.getString("celular"));
				
				lista.add(p);
				
			}
			
		}catch(SQLException e) {
			System.out.println("Erro ao Listar");	
			e.printStackTrace();
			
		}finally {
			
			fecharConexao();
		}		
		
		return lista;		
	}
	
	public Professor buscar(long id) {
		Professor professor = null;
		
		String sql = "select * from professor " + "where idprofessor = ?";
		
		try {
			PreparedStatement ps= getConexao().prepareStatement(sql);
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				professor = new Professor();
				professor.setId(rs.getLong("idprofessor"));
				professor.setValorHora(rs.getDouble("valorHora"));
				professor.setNome(rs.getString("nome"));
				professor.setCelular(rs.getString("celular"));
			}
			
		}catch (SQLException e) {
			System.out.println("Erro ao Listar");	
			e.printStackTrace();
			
		}finally {
			fecharConexao();
	}
		
		return professor;
	}
	
	public void excluir (Professor p) {
		String sql = "delete from professor where idprofessor= ?";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setLong(1, p.getId());
			
			ps.execute();
			
		}catch(SQLException e) {
			System.out.println("Erro na exclusão");	
			e.printStackTrace();
			
		}finally {
			fecharConexao ();
		}				
		
	}

	public void alterar(Professor p) {
		String sql = "update professor set " +
					  "valorHora = ?," +
					  "nome= ?," +
					  "celular= ?" +
					  "where idprofessor= ?";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setDouble(1, p.getValorHora());
			ps.setString(2, p.getNome());
			ps.setString(3, p.getCelular());
			ps.setLong(4, p.getId());
			ps.execute();
			
		}catch(SQLException e) {
			System.out.println("Erro no Update");
			e.printStackTrace();
			
		}finally {
			fecharConexao();
		}	
		
	}
}
