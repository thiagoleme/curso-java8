package br.com.curso.java8;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class CursoTest {

	@Test
	public void calculaMediaDeAlunosPorCurso() throws Exception {
		List<Curso> cursos = criaCursos();

		OptionalDouble average = cursos.stream().mapToInt(c -> c.getAlunos()).average();

		System.out.println(average);
	}

	private List<Curso> criaCursos() {
		List<Curso> cursos = new ArrayList<>();

		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));

		return cursos;
	}

	@Test
	public void filtraCursosComMaisDe50Alunos() throws Exception {
		List<Curso> cursos = criaCursos();

		Stream<Curso> cursoFiltrado = cursos.stream().filter(c -> c.getAlunos() > 50);

		assertEquals(3, cursoFiltrado.count());
	}

	@Test
	public void ordenarPorQtde() {
		List<Curso> cursos = criaCursos();

		cursos.sort(Comparator.comparingInt(Curso::getAlunos));

		assertEquals(45, cursos.get(0).getAlunos());
		assertEquals(55, cursos.get(1).getAlunos());
		assertEquals(113, cursos.get(2).getAlunos());
		assertEquals(150, cursos.get(3).getAlunos());
	}

	@Test
	public void StreamParaList() throws Exception {
		List<Curso> cursos = criaCursos();

		List<Curso> collect = cursos.stream().filter(c -> c.getAlunos() > 50).collect(Collectors.toList());

		System.out.println(collect);

	}

	@Test
	public void transformaStreamDeCursoParaStreamDeString() throws Exception {
		List<Curso> cursos = criaCursos();

		Stream<String> cursoFiltrado = cursos.stream().filter(c -> c.getAlunos() > 50).map(Curso::getNome);

		cursoFiltrado.forEach(System.out::println);
	}

}
