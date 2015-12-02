package blatt1Aufgabe1;

public class MyAccount {
	private static int Zahl = 0;

	public static int getZahl() {
		return Zahl;
	}

	public static synchronized int setZahl(int zahl) {
		Zahl = zahl;
		return Zahl;
	}
}
