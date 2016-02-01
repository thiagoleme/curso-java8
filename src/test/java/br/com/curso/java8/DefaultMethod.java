package br.com.curso.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

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

		Comparator<String> comparator = new Comparator<String>() {
			@Override
			public int compare(String palavra1, String palavra2) {
				if (palavra1.length() < palavra2.length())
					return -1;
				if (palavra1.length() > palavra2.length())
					return 1;
				return 0;
			}
		};
		palavras.sort(comparator);

		imprimeLista(palavras);
	}

	private void imprimeLista(List<String> palavras) {
		Consumer<String> consumer = new Consumer<String>() {

			@Override
			public void accept(String palavra) {
				System.out.println(palavra);
			}
		};
		palavras.forEach(consumer);
	}

	private List<String> criaLista() {
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");
		return palavras;
	}
}
