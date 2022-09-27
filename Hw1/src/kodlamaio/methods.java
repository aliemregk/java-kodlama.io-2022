package kodlamaio;

public class methods {

	public static void main(String[] args) {
		findNumber(2);
		findNumber(1);
		findNumber(11);
	}

	public static void findNumber(int numberToSearch) {
		int[] numbers = new int[] { 1, 2, 5, 7, 9, 0 };

		for (int number : numbers) {
			if (number == numberToSearch) {
				message(numberToSearch + " found.");
				return;
			}
		}
		message("Can not find " + numberToSearch);
	}
	
	public static void message(String message) {
		System.out.println(message);
	}

}
