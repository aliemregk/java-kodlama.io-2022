package kodlamaio;

public class loopDemo {

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
		System.out.println("End.");

		for (int i = 0; i < 10; i += 2) {
			System.out.println(i);
		}
		System.out.println("End.");

		for (int i = 1; i < 10; i += 2) {
			System.out.println(i);
		}
		System.out.println("End.");

		int i = 0;
		while (i < 10) {
			System.out.println(i);
			i++;
		}
		System.out.println("End(while).");

		int j = 1;
		do {
			System.out.println(j);
			j += 2;
		} while (j < 10);
		System.out.println("End(do-while).");
	}

}
