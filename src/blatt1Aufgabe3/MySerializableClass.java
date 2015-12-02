package blatt1Aufgabe3;

import java.io.Serializable;

public class MySerializableClass implements Serializable {
	private static final long serialVersionUID = 1;
	private int id;
	private String string;

	private transient MyNonSerializableClass myNonSerializableClass = new MyNonSerializableClass();

	MySerializableClass() {
		id = 1234;
	}

	public void set(String string) {
		this.string = string;
	}

	public String toString() {
		return "ID: " + id + "; string: " + string + "; NonSer: " + myNonSerializableClass;
	}
}
