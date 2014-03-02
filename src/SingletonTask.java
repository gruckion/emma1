
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
	
	public void run() {
		try {
			//
			while(true) {
				System.out.println("The Singleton: " + count);
				count++;
				try {
					Thread.sleep(3000);
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
	
	public static void setRunning(boolean run) {
		running = run;
	}
	
	public static boolean getRunning() {
		return running;
	}
	
	private int count;
	private static boolean running;

}
