package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExemplosStream {
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
//		cursos.sort(Comparator.comparingInt(c -> c.getAlunos()));
//		cursos.sort(Comparator.comparingInt(Curso::getAlunos));
//		cursos.forEach(c -> System.out.println(c.getNome()));
		
//		Stream<Curso> streamCurso = cursos.stream().filter(c -> c.getAlunos() >= 100);
		cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
//			.forEach(c -> System.out.println(c.getNome()));
			.map(Curso::getAlunos)            // ou .map(c -> c.getAlunos())
			.forEach(System.out::println);    // ou .forEach(total -> System.out.println(total));
		
		int soma = cursos.stream()
				   .filter(c -> c.getAlunos() > 100)
				   .mapToInt(Curso::getAlunos)
				   .sum();
		
//		Optional<Curso> optionalCurso = cursos.stream()
//			.filter(c -> c.getAlunos() >= 100)
//			.findAny();
		
//		Curso curso = optionalCurso.get();
//		Curso curso = optionalCurso.orElse(null);
//		optionalCurso.ifPresent(c -> System.out.println(c.getNome()));
		
		cursos.stream()
				.filter(c -> c.getAlunos() >= 100)
				.findAny()
				.ifPresent(c -> System.out.println(c.getNome()));
		
		List<Curso> listaCursos = cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.collect(Collectors.toList());
		
		listaCursos.forEach(c -> System.out.println(c.getNome()));
		
		Map<String, Integer> mapCursos = cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()));
		
		mapCursos.forEach((nome, valor) -> System.out.println("o nome é" + nome + ", e o valor é " + valor));
		
		cursos.stream()
			.mapToDouble(c -> c.getAlunos())
			.average().ifPresent(average -> System.out.println(average));
		
		
	}
}
