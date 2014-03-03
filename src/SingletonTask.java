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
			System.out.println("Singleton Task: " + count);
			if(count == 5) {
				System.out.println("Singleton Counter reached 5 cancel future tasks");
				closeSingletonTask();
			}
			count++;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return;
	}
	
	public void setSingletonRunnable(Runnable task) {
		this.task = task;
	}
	
	public Runnable getSingletonRunnable() {
		return task;
	}
	
	public void setActiveSingleton(boolean state) {
		activeSingleton = state;
	}
	
	public boolean getActiveSingleton() {
		return activeSingleton;
	}
	
	private void closeSingletonTask() {
		Main.getFutureTask().cancel(true);
		task = null;
		count = 0;
	}
	
	private static boolean activeSingleton = false;
	private static Runnable task = null;
	private int count = 0;// Counts the passes through the thread
}
