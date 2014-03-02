
public class SingletonTask implements Runnable {

	private static SingletonTask task = null;

	protected SingletonTask() {
		// protected singleton
	}

	public static SingletonTask getInstance() {
		if(task == null)
			task = new SingletonTask();
		return task;
	}

	/*
	 * Destroy the SingletonTask and its active thread
	 * */
	public static void destroy() {
		//Main.thread.get(getThreadId()).interrupt();
		//Main.thread.remove(getThreadId());
		//setRunning(false);
	}

	public void run() {
		try {
			//
			while(getRunning()) {
				System.out.println("The Singleton: " + count);
				if(count >= 5) {
					System.out.println("Ending the SingletonTask.");
					destroy();
				}

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
	 * @param boolean run
	 * Sets the running state of the SingletonTask.
	 * */
	public static void setThreadId(int id) {
		threadId = id;
	}

	/*
	 * returns the running state of the SingletonTask
	 * */
	public static int getThreadId() {
		return threadId;
	}

	/*
	 * @param boolean run
	 * Sets the running state of the SingletonTask.
	 * */
	public static void setRunning(boolean run) {
		running = run;
	}

	/*
	 * returns the running state of the SingletonTask
	 * */
	public static boolean getRunning() {
		return running;
	}

	// counter for the SingletonTask
	private int count;
	// The running state of the SingletonTask
	private static boolean running;
	// The sleep time in milliseconds for the SingletonThread thread
	private int sleep = 1000;
	// The threadId for the SingletonTask
	private static int threadId = 0;

}
