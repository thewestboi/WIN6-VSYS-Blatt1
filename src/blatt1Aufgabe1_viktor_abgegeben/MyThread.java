package blatt1Aufgabe1_viktor_abgegeben;

public class MyThread extends Thread {
	private static final int threadMax = 10;
	private static int runCount = 1;
	private static Object lock = new Object();
	private static MyAccount acc = new MyAccount();
	
	public void run() {
			
		/*synchronized (lock) {
			while(runCount < 30) {
				output();
			}
			//runCount = 0;
		}*/
		
		while(runCount <= 30) {
			//synchronized (lock) {
			output();
		}
		//runCount = 0;
	}
//}
		
	
	private static void output() {

		int zahl;
		int alt;
		int neu;
		
		if (Math.random() < 0.5){
			zahl = -1;
		}else{
			zahl = 1;
		}
		synchronized (lock) {
			alt = acc.getVariable();
			acc.setVariable(acc.getVariable() + zahl);
			neu = acc.getVariable();
			System.out.println(Thread.currentThread().getName() + ": " + alt + " + " + zahl + " = " + neu);
			runCount++;
		}
		
	
			//System.out.println(Thread.currentThread().getName() + ": " + alt + " + " + zahl + " = " + neu);
			//runCount++;
		}
	
	/*private static synchronized void output() {

	System.out.println(runCount + ": " + Thread.currentThread().getName());
	runCount++;
	try {
		sleep(300);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
} */
	
	public static void main(String args[]) {
		for (int i = 0; i < threadMax; i++) {
			new MyThread().start();
		}
	}
}