package hu.ak_akademia.lambdaexpressions;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	static Random random = new Random();

	public static void main(String[] args) {
		// 1.
		Function<String, String> camelCase = text -> {
			List<String> words = List.of(text.split(" "));

			String result = words.stream().map(word -> word.substring(0, 1).toUpperCase() + word.substring(1))
					.collect(Collectors.joining());

			return result;
		};

		System.out.println(camelCase.apply("hello world"));

		// 2.
		Function<String, String> upperCaseAndUnderlineSeparator = text -> {
			List<String> words = List.of(text.split(" "));
			String result = words.stream().map(word -> word.toUpperCase()).collect(Collectors.joining("_"));

			return result;
		};

		System.out.println(upperCaseAndUnderlineSeparator.apply("hello world"));

		// 3.
		Function<Integer, String> generatedText = number -> {
			StringBuilder result = new StringBuilder();

			for (int i = 0; i < number; i++) {
				result.append(generateLetter(random));
			}

			return result.toString();
		};

		System.out.println(generatedText.apply(5));

		// 4.
		Function<String, Integer> spaceCounter = text -> {
			List<Character> letters = text.chars().mapToObj(letter -> (char) letter).collect(Collectors.toList());

			return (int) letters.stream().filter(letter -> letter.equals(' ')).count();
		};

		System.out.println(spaceCounter.apply("a b c d"));

		// 5.
		Function<String, Boolean> palindrom = text -> {
			List<Character> letters = text.chars().mapToObj(letter -> (char) letter).collect(Collectors.toList());

			String filteredText = letters.stream().filter(letter -> letter != ' ').filter(letter -> letter != '.')
					.filter(letter -> letter != ',').filter(letter -> letter != ':').filter(letter -> letter != '?')
					.filter(letter -> letter != '!').filter(letter -> letter != '-')
					.map(letter -> letter.toString().toLowerCase()).collect(Collectors.joining());

			String normal = new StringBuilder().append(filteredText).toString();
			String reversed = new StringBuilder().append(filteredText).reverse().toString();

			return normal.equals(reversed);
		};

		System.out.println(palindrom.apply("A man, a plan, a canal - Panama."));

		// 6.
		Function<String, String> orderedText = text -> {
			List<Character> letters = text.chars().mapToObj(letter -> (char) letter).collect(Collectors.toList());
			String result = letters.stream().sorted().map(letter -> letter.toString()).collect(Collectors.joining());

			return result;
		};

		System.out.println(orderedText.apply("alma"));

		// 7.
		Consumer<Integer> countDown = number -> {
			IntStream.range(1, number).forEach(System.out::println);
		};

		countDown.accept(5);

		// 8.
		IntPredicate primeChecker = number -> {
			if (number < 2)
				return false;

			long numberOfDivisors = IntStream.rangeClosed(1, number).filter(divisor -> number % divisor == 0).count();

			if (numberOfDivisors <= 2) {
				return true;
			}

			return false;
		};

		System.out.println(primeChecker.test(2));

		// 9.
		BiFunction<Set<Character>, Set<Character>, Set<String>> cartesianProduct = (a, b) -> {
			Set<String> result = new HashSet<>();

			a.forEach(e1 -> b.forEach(e2 -> result.add(e1.toString() + e2.toString())));

			return result;
		};

		Set<Character> letters = Set.of('a', 'b', 'c');
		Set<Character> numbers = Set.of('1', '2', '3');
		System.out.println(cartesianProduct.apply(letters, numbers));

		// 10.
		Function<String, Set<String>> permutation = text -> {
			Set<String> result = new HashSet<>();

			List<Character> lettersList = text.chars().mapToObj(letter -> (char) letter).collect(Collectors.toList());

			int numberOfVariations = IntStream.rangeClosed(1, letters.size()).reduce(1, (a, b) -> a * b);
			int i = 0;

			while (i < numberOfVariations) {

				Collections.shuffle(lettersList);

				String randomizedText = letters.stream().map(letter -> letter.toString()).collect(Collectors.joining());

				if (result.add(randomizedText)) {
					i++;
				}
			}

			return result;
		};

		System.out.println(permutation.apply("azt"));
	}

	private static char generateLetter(Random random) {
		return (char) (97 + random.nextInt(122 - 97));
	}
}
