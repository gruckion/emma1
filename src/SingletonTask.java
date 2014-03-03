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
	
	public void setSingletonTask(Runnable task) {
		this.task = task;
	}
	
	public Runnable getSingletonTask() {
		return task;
	}
	
	public void setActiveSingleton(boolean state) {
		activeSingleton = state;
	}
	
	public boolean getActiveSingleton() {
		return activeSingleton;
	}
	
	private static boolean activeSingleton = false;
	private static Runnable task = null;
	private int count = 0;// Counts the passes through the thread
}
