import java.util.ArrayList;
import java.util.Random;

public class OperatingSystem {
	private static Random rand = new Random();
	   
    public static Memory memory = null;
    public static Swap swap = null;

    private MemoryManagement MMU;
    private ArrayList<Process> processes;

    public OperatingSystem(int memorySize, int pageSize) {
        OperatingSystem.memory = new Memory(memorySize, pageSize);
        OperatingSystem.swap = new Swap();
        this.MMU = new MemoryManagement();
        this.processes = new ArrayList<>();
    }

    public void addProcess() {
        Process process = new Process(this.processes.size(), rand.nextInt(2) +1);
        this.processes.add(process);
        System.out.printf("Создание нового процесса %d требует %d страниц\n", process.getId(), process.getCountPages());
    }

    public Process getProcess(int processId) {
        for (Process process : this.processes) {
            if (process.getId() == processId) {
                return process;
            }
        }
        return null;
    }

    public void addPage(int processId) {
        Process process = this.getProcess(processId);
        if (process != null) {
            int pageId = this.MMU.addPage(process);
            this.getPage(processId, pageId);
            System.out.printf("Создание страницы %d для процесса %d\n", pageId, process.getId());
        }
    }

    public void getPage(int processId, int pageId) {
        Process process = this.getProcess(processId);
        if (process != null) {
            if (process.getPagesIds().contains(pageId)) {
                this.MMU.getPage(pageId);
                System.out.printf("Процесс %d запрашиваемая страница %d\n", process.getId(), pageId);
            }
            else {
                System.out.printf("У процесса %d нет страницы %d\n", process.getId(), pageId);
            }
        }
    }

    public void printMemory() {
        System.out.print("Оперативная память:\n");
        System.out.print("   Страница Процесс   R bit   VirtualTime\n");
        for (int pageId = 0; pageId < OperatingSystem.memory.getPagesCount(); pageId++) {
            Page page = OperatingSystem.memory.getPage(pageId);
            if (page == null) {
                System.out.printf(" %4d\n", pageId);
            }
            else {
                Process process = this.getProcess(page.getProcessId());
                System.out.printf(" %4d |\t%4d | \t\t%s |     %4d\n", pageId, process.getId(), page.isRecourse() ? 1 : 0, page.getvirtualTime());
            }
        }
    }
}
