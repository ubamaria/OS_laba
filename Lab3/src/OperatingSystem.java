import java.util.ArrayList;
import java.util.Random;

public class OperatingSystem {
	private Main main;
	private ArrayList<Process> process;
	private static ArrayList<Page> pages;

	public static Memory memory = null;

	private static Random random = new Random();

	public OperatingSystem(int sizememory, int sizepage) {
		memory = new Memory(sizememory, sizepage);
		main = new Main();
		process = new ArrayList<>();
		pages = new ArrayList<>();
	}

	public static int addPage(Page page) {
		pages.add(page);
		return pages.indexOf(page);
	}

	public static Page receivePage(int pageId) {
		return pages.get(pageId);
	}

	public void addProcess() {
		Process process = new Process(this.process.size(), random.nextInt(12) + 1);
		this.process.add(process);
		System.out.printf("�������� ������ �������� %d, ��������� %d �������\n", process.receiveId(),
				process.receiveCountpages());
	}

	public Process receiveProcess(int processId) {
		for (Process process : this.process) {
			if (process.receiveId() == processId) {
				return process;
			}
		}
		return null;
	}

	public void addPage(int processId) {
		Process process = this.receiveProcess(processId);
		if (process != null) {
			int pageId = this.main.addPage(process);
			this.receivePage(processId, pageId);
			System.out.printf("�������� �������� %d ��� �������� %d\n", pageId, process.receiveId());
		}
	}

	public void receivePage(int processId, int pageId) {
		Process process = this.receiveProcess(processId);
		if (process != null) {
			if (process.receivePagesId().contains(pageId)) {
				this.main.receivePages(pageId);
				System.out.printf("������� %d �������� �������� %d\n", process.receiveId(), pageId);
			} else {
				System.out.printf("� �������� %d ��� �������� %d\n", process.receiveId(), pageId);
			}
		}
	}

	public void printMemory() {
		System.out.print("����������� ������:\n");
		System.out.print("�������� ������� R bit\n");
		for (int pageId = 0; pageId < OperatingSystem.memory.receiveCountpages(); pageId++) {
			Page page = OperatingSystem.memory.receivePage(pageId);
			if (page == null) {
				System.out.printf(" %4d\n", pageId);
			} else {
				Process process = this.receiveProcess(page.receiveProcessId());
				System.out.printf(" %4d \t%4d \t\t%s\n", pageId, process.receiveId(), page.isRecourse() ? 1 : 0);
			}
		}
	}
}