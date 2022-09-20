package projects;

public class primeNumber {

	public static void main(String[] args) {

		int num = 11;

		if (num <= 1) {
			System.out.println(num + " is not a prime number.");
			return;
		}
		if (num == 2) {
			System.out.println(num + " is a prime number.");
			return;
		}

		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				System.out.println(num + " is not a prime number.");
				return;
			} else {
				System.out.println(num + " is a prime number.");
				return;
			}
		}
	}

}
