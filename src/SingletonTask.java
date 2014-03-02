
public class SingletonTask {

	private static SingletonTask task = null;

	protected SingletonTask() {
		// protected singleton
	}

	public static SingletonTask getInstance() {
		if(task == null)
			task = new SingletonTask();
		return task;
	}

	// counter for the SingletonTask
	private int count;

}
