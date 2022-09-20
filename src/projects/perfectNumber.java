package projects;

public class perfectNumber {

	public static void main(String[] args) {

		int num = 28;
		int total = 0;

		for (int i = 1; i < num; i++) {
			if (num % i == 0) {
				total = total + i;
			}
		}
		if (total == num) {
			System.out.println(num + " is a perfect number.");
		} else {
			System.out.println(num + " is not a perfect number.");
		}
	}

}
