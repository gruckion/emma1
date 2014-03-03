import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

public class Main implements Runnable {

	/*
	 * main access point, that is via the Main's constructor.
	 */
	public static void main(String[] args) {
		System.out.println("Start");
		 new Main();
	}

	/*
	 * The main constructor is the initialisation point for the program.
	 */
	public Main() {
		System.out.println("Constructor call.");
		startRunnable(this, 1);
	}

	/*
	 * The runnable function for the main thread that process user input and
	 * determines how and when the SingletonTask will be started.
	 */
	public void run() {
		try {
			while (true) {
				//System.out.println("Got here: " + count);
				scheduleTask();
				count++;
				try {
					Thread.sleep(sleep);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return;
	}	
	
	/*
	 * standard process to producing a runnable thread
	 */
	public void startRunnable(Runnable runnable, int priority) {
		Thread thread = new Thread(runnable);
		thread.start();
		thread.setPriority(priority);
	}
	
	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	public void scheduleTask() {
		if(singleton.getSingletonTask() != null)
			return;
		
		final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(
				getTask(), initalDelay, noramlDelay, SECONDS);
		scheduler.schedule(new Runnable() {
			public void run() {
				beeperHandle.cancel(true);
			}
		}, duration, SECONDS);
	}

	private Runnable getTask() {
		if(singleton.getSingletonTask() == null)
			singleton.setSingletonTask(singleton);
		 
		return singleton.getSingletonTask();
	}
	
	// The final instance task of the SigletonTask.
	private final SingletonTask singleton = SingletonTask.getInstance();
	// Count the loops through the Main thread.
	private int count = 0;
	// The sleep time in milliseconds for the Main thread
	private int sleep = 1000;
	private int initalDelay = 3, noramlDelay = 3;
	private int duration = 3600;// Seconds
}
