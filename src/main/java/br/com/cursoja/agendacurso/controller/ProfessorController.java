package br.com.cursoja.agendacurso.controller;

import java.util.ArrayList;

import br.com.cursoja.agendacurso.model.dao.ProfessorDao;
import br.com.cursoja.agendacurso.model.entidade.Professor;


public class ProfessorController {
	ProfessorDao da = new ProfessorDao();
	
	public void cadastrar (Professor p) {
		da.cadastrar(p);		
	}
	
	public ArrayList<Professor> listar(String nome) {
		return da.listar(nome);
	}
	
	public Professor buscar(long id) {
		return da.buscar(id);
	}
	
	public void excluir(Professor p) {
		da.excluir(p);
	}

	public void alterar(Professor p) {
		da.alterar(p);
		
	}
	
	

}
