package blatt1Aufgabe3;

import java.io.*;

public class SerializeMain {
	private static MySerializableClass myObject;
	private static MySerializer mySerializer;

	public static void main(String args[]) throws IOException, ClassNotFoundException {
		String command, text = "";
		boolean doExit = false;

		myObject = new MySerializableClass();
		mySerializer = new MySerializer(myObject);

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		printMenu();

		while (!doExit) {
			System.out.print("> ");

			command = reader.readLine();

			switch (command) {
			case "t":
				System.out.print("text> ");
				text = reader.readLine();
				System.out.println("Text: " + text);
				break;
			case "s":
				mySerializer.write(text);
				break;
			case "d":
				System.out.println(mySerializer.read());
				break;
			case "m":
				printMenu();
				break;
			case "x":
				doExit = true;
				break;
			}
		}
	}

	private static void printMenu() {
		System.out.println("--------------------");
		System.out.println("se(t) text");
		System.out.println("(s)erialize");
		System.out.println("(d)eserialize");
		System.out.println("print (m)enu");
		System.out.println("\ne(x)it");
		System.out.println("--------------------");
	}
}
