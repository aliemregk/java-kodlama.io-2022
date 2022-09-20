package kodlamaio;

public class methods2 {

	public static void main(String[] args) {

		String message = "Bugün hava çok güzel.";
		String newMessage = getCity();
		System.out.println(newMessage);

		int num = addition(15, 7);
		System.out.println(num);
		
		int num2 = multipleAddition(1,2,3,4,5,6,7);
		System.out.println(num2);
		
	}

	public static void add() {
		System.out.println("Added.");
	}

	public static void delete() {
		System.out.println("Deleted.");
	}

	public static void update() {
		System.out.println("Updated.");
	}

	public static String getCity() {
		return "Ankara";
	}

	public static int addition(int num1, int num2) {
		return num1 + num2;
	}

	public static int multipleAddition(int... nums) {
		int total = 0;
		for (int num : nums) {
			total = total + num;
		}
		return total;
	}
}
