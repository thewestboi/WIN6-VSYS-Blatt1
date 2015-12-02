package blatt1Aufgabe1;

public class MyThread_d extends MyAccount implements Runnable {
	private static final int threadMax = 10;
	private static int runCount = 0;
	private static int randomInt;

	public void run() {
		while (runCount++ < 30) {
			randomInt = Math.random() < 0.5 ? -1 : 1;
			synchronized (MyAccount.class) {
				System.out.println(Thread.currentThread().getName() + ": " + getZahl() + " + " + randomInt + " = "
						+ setZahl(getZahl() + randomInt));
			}
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < threadMax; i++) {
			Thread thread = new Thread(new MyThread_d());
			thread.start();
		}
	}
}