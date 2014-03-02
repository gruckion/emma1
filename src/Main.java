import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main implements Runnable {
	
	/*
	 * main access point, that is via the Main's constructor.
	 * */
	public static void main(String[] args) {
		new Main();
	}
	
	/*
	 * The main constructor is the initialisation point for the program.
	 * */
	public Main() {
		System.out.println("Constructor call.");
		startRunnable(this,1);
	}
	
	/*
	 * The runnable function for the main thread that process user input and
	 * determines how and when the SingletonTask will be started.
	 * */
	public void run() {
		try {
			//
			while(true) {
				System.out.println("Got here: " + count);
				count++;
				try {
					Thread.sleep(sleep);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			//
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return;
	}

	/*
	 * standard process to producing a runnable thread
	 * */
	public void startRunnable(Runnable runnable, int priority) {
		Thread thread = new Thread(runnable);
		thread.start();
		thread.setPriority(priority);
	}
	
	// The final instance task of the SigletonTask.
	private final SingletonTask task = SingletonTask.getInstance();
	// Count the loops through the Main thread.
	private int count = 0;
	// The sleep time in milliseconds for the Main thread
	private int sleep = 1000;
}
