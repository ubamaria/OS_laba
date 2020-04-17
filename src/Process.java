import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Process {
	Random rand = new Random();
	private List<Thread> Threads;
	private String name;
	private int maxTime = 10;
	private int currentTime;
	private int threadMaxTime;

	public Process(String name, int maxTime, int priority) {
		this.name = "process " + name + " priority: " + priority;
		Threads = new ArrayList<Thread>();
		int threadsNumber = rand.nextInt(4) + 1;
		threadMaxTime = this.maxTime / threadsNumber;
		for (int i = 0; i < threadsNumber; i++) {
			Threads.add(new Thread("" + i, rand.nextInt(10) + 1, threadMaxTime));
		}
	}

	public int getCount() {
		return Threads.size();
	}

	public String getName() {
		return name;
	}

	public int getmaxTime() {
		return maxTime;
	}

	public Thread getThread(int index) {
		return Threads.get(index);
	}

	public void removeThread(int index) {
		Threads.remove(index);
	}

	public void incrCurrentTime() {
		currentTime++;
	}

	public boolean isEmpty() {
		return (Threads.isEmpty());
	}

	public boolean haveTime() {
		return maxTime > currentTime;
	}
}