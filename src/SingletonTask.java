import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;

public class SingletonTask implements Runnable {

	private static SingletonTask singleton = null;

	protected SingletonTask() {
		// protected singleton
	}

	public static SingletonTask getInstance() {
		if(singleton == null)
			singleton = new SingletonTask();
		return singleton;
	}
	
	/*
	 * The runnable function for the SingletonTask thread that process
	 * the task at hand.
	 */
	public void run() {
		try {
			System.out.println("2Got here: " + count);
			count++;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return;
	}	

	private final ScheduledExecutorService scheduler = Executors
			.newScheduledThreadPool(1);

	public void beepForAnHour() {
		if(task == null)
			task = this;
		else 
			return;
		
		final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(
				task, initalDelay, noramlDelay, SECONDS);
		scheduler.schedule(new Runnable() {
			public void run() {
				beeperHandle.cancel(true);
			}
		}, duration, SECONDS);
	}
	
	private Runnable task = null;;
	private int initalDelay = 3, noramlDelay = 3;
	private int duration = 3600;// Seconds
	private int count = 0;// Counts the passes through the thread
}
