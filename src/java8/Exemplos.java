package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Exemplos {
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();

		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");

//		Collections.sort(palavras, comparator);

		palavras.sort((String s1, String s2) -> Integer.compare(s1.length(), s2.length()));

		System.out.println(palavras);

//		for (String string : palavras) {
//			System.out.println(string);
//		}

//		Consumer<String> consumer = new ImprimePalavras();
		palavras.forEach(s -> System.out.println(s));

	}
}

//class ComparadorPorTamanho implements Comparator<String> {
//
//	@Override
//	public int compare(String s1, String s2) {
//		if (s1.length() <= s2.length())
//			return -1;
//		if (s1.length() > s2.length())
//			return 1;
//		return 0;
//	}
//}

//class ImprimePalavras implements Consumer<String>{
//
//	@Override
//	public void accept(String s) {
//		System.out.println(s);
//	}
//}
