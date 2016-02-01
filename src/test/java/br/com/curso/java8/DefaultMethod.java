package br.com.curso.java8;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DefaultMethod {

	@Test
	public void imprimeListTest() {
		List<String> palavras = criaLista();

		imprimeLista(palavras);
	}

	@Test
	public void imprimeOrdenadoTest() {
		List<String> palavras = criaLista();

		palavras.sort((palavra1, palavra2) -> Integer.compare(palavra1.length(), palavra2.length()));

		imprimeLista(palavras);
	}

	private void imprimeLista(List<String> palavras) {
		palavras.forEach(palavra -> System.out.println(palavra));
	}

	private List<String> criaLista() {
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");
		return palavras;
	}
}
