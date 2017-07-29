package br.com.triadworks.erp.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.triadworks.erp.dao.FuncionarioDao;
import br.com.triadworks.erp.modelo.Funcionario;
import br.com.triadworks.erp.util.FacesUtils;

@ManagedBean
public class FuncionarioBean {

	private Funcionario funcionario = new Funcionario();
	
	
	public void salvar(){
		FuncionarioDao dao = new FuncionarioDao();
		
		if(this.funcionario.getId() == null){
			dao.adiciona(this.funcionario);
		}else{
			dao.atualiza(this.funcionario);
		}
		this.funcionario = new Funcionario(); //limpa os campos
		
		new FacesUtils().adicionaMensagemDeSucesso("Funcionário gravado com sucesso!");
	}

	public List<Funcionario> getFuncionarios(){
		FuncionarioDao dao = new FuncionarioDao();
		return dao.lista();	
	}

	public void remover(Funcionario funcionario){
		FuncionarioDao dao = new FuncionarioDao();
		dao.remove(funcionario);
		
		new FacesUtils().adicionaMensagemDeSucesso("Funcionário removido com sucesso!");
	}
	
	public void cancela(){
		this.funcionario = new Funcionario();
	}
	
	public Funcionario getFuncionario() {
		return this.funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
