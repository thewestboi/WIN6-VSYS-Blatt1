package aufgabe3;

public class MyNonSerializableClass {
	private int id;

	MyNonSerializableClass() {
		id = 5678;
	}

	public String toString() {
		return " " + id;
	}
}
