import java.util.Random;

public class Main {
		private static Random rand = new Random();

		   public static void main(String[] args) {
		           OperatingSystem operatingSystem = new OperatingSystem(256, 32);
		           for (int processId = 0 ; processId < rand.nextInt(1) + 5; processId++) {
		               operatingSystem.addProcess();
		               for (int pageId = 0; pageId < operatingSystem.getProcess(processId).getCountPages(); pageId++) {
		                   operatingSystem.addPage(processId);
		               }
		               operatingSystem.printMemory();
		           }
		           operatingSystem.printMemory();
		   }
}
