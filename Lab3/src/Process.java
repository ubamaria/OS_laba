import java.util.ArrayList;

public class Process {
	private int id;
	private int countPages;
	private ArrayList<Integer> pagesId;
	private ArrayList<Page> processes;

	public Process(int identifier, int amountPages) {
		id = identifier;
		countPages = amountPages;
		pagesId = new ArrayList<>();
		processes = new ArrayList<>();
	}

	public ArrayList<Integer> receivePagesId() {
		return pagesId;
	}

	public int receiveCountpages() {
		return countPages;
	}

	public int receiveId() {
		return id;
	}

	public Page receivePage(int pageid) {
		return processes.get(pageid);
	}

	public int addPage(Page page) {
		processes.add(page);
		return processes.indexOf(page);
	}
}