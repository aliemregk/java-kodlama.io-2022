package projects;

public class findNumber {

	public static void main(String[] args) {

		int[] numbers = new int[] { 1, 2, 5, 7, 9, 0 };
		int numberToSearch = 1;

		for (int number : numbers) {
			if (number == numberToSearch) {
				System.out.println(numberToSearch + " found.");
				return;
			}
		}
		System.out.println("Can not find " + numberToSearch);
	}

}
