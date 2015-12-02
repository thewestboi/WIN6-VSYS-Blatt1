package blatt1Aufgabe1;

public class MyThread extends Thread {
	private static final int threadMax=10;
	private static int runCount = 0;
	
	public void run() {
		while(runCount < 30) {
			output();
		}	
	}
	
	public static synchronized void output() {
		if (runCount < 30) {
			System.out.println(runCount++ + ": " + Thread.currentThread().getName());
			try {
				sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		for(int i=0; i < threadMax ; i++) {
			new MyThread().start();
		}
	}
}



/* A
 * Threads greifen gleichzeitig auf runCount und lesen bzw. verändern diese ohne Synchronisation.
 */

/* B
 * Weil output() nicht static ist und somit jeder Thread auf seine eigene output() zugreift. Somit erfolgt keine Synchronisation. 
 */

/* C
 * output() static setzen, if runCount Prüfung in output()
 */
