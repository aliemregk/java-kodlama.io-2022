package kodlamaio;

public class stringsDemo {

	public static void main(String[] args) {

		String message = "Bugün hava çok güzel.";
		System.out.println(message);

//		System.out.println("Num of elements = " + message.length());
//		System.out.println("5. element = " + message.charAt(4));
//		
//		System.out.println(message.concat(" Yaşasın!"));
//		System.out.println(message);
//		
//		System.out.println(message.startsWith("B"));
//		System.out.println(message.endsWith("."));
//		
//		char[] chars = new char[5];
//		message.getChars(0, 5, chars, 0);
//		System.out.println(chars);
//		
//		System.out.println(message.indexOf('a'));
//		System.out.println(message.lastIndexOf('a'));

		String newMessage = message.replace(" ", "-");
		System.out.println(newMessage);

		System.out.println(message.substring(2));
		System.out.println(message.substring(2, 5));
		
		for (String string : message.split(" ")) {
			System.out.println(string);
		}
		
		System.out.println(message.toLowerCase());
		System.out.println(message.toUpperCase());
		
		message = "-     Bugün hava çok güzel.      -";
		System.out.println(message);
		System.out.println(message.trim());
	}

}
