import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SMain implements Runnable {

	public static void main(String[] args) {
		new SMain();
	}
	
	public SMain() {
		System.out.println("Constructor call.");
		startRunnable(this,1);
	}
	
	public void run() {
		try {
			//
			while(true) {
				System.out.println("Got here: " + count);
				count++;
				if(!SingletonTask.getRunning()) {
					SingletonTask.setRunning(true);
					startRunnable(task,1);
					
				}
				try {
					Thread.sleep(1000);
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

	public void startRunnable(Runnable runnable, int i) {
		Thread thread = new Thread(runnable);
		thread.start();
		thread.setPriority(i);
	}
	
	private final SingletonTask task = SingletonTask.getInstance();
	private int count = 0;
}
