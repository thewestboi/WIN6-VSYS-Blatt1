package aufgabe3;

import java.io.*;

public class MySerializer {
	private MySerializableClass mySerializableClass;

	MySerializer(MySerializableClass serializableClass) {
		mySerializableClass = serializableClass;
	}

	private String readFilename() throws IOException {
		String filename;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("filename> ");
		filename = reader.readLine();

		return filename;
	}

	public void write(String text) throws IOException {
		mySerializableClass.set(text);
		String filename = readFilename();

		// Implementierung erforderlich
		// Serialisiere mySerializableClass in Datei
		try {
			FileOutputStream path = new FileOutputStream(System.getProperty("user.home") + "/Desktop/" + filename);
			ObjectOutputStream output = new ObjectOutputStream(path);
			output.writeObject(mySerializableClass);
			output.close();
		} catch (NotSerializableException e) {
			System.err.println("Die Klasse kann nicht in die File geschrieben werden: " + e.getMessage());
		}
	}

	public String read() throws IOException, ClassNotFoundException {
		String filename = readFilename();

		// Implementierung erforderlich
		// Serialisiere mySerializableClass von Datei
		try {
			InputStream path = new FileInputStream(System.getProperty("user.home") + "/Desktop/" + filename);
			InputStream file = new BufferedInputStream(path);
			ObjectInput input = new ObjectInputStream(file);
			mySerializableClass = (MySerializableClass) input.readObject();
			input.close();
			// if NonSer == null -> new NonSer

		} catch (IOException e) {
			System.err.println("File <" + filename + "> kann nicht gelesen werden: " + e.getMessage());
		}
		return mySerializableClass.toString();
	}
}
