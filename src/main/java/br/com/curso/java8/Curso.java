package br.com.curso.java8;

public class Curso {
	private String nome;
	private int alunos;

	public Curso(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public int getAlunos() {
		return alunos;
	}
	
	@Override
	public String toString() {
		String resp = "";
		
		resp += "Curso: " + this.nome;
		
		return resp;
	}
}
