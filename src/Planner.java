import java.util.ArrayList;
import java.util.Random;

public class Planner {
		private static ArrayList<Process> Processes = new ArrayList<Process>();
        private static Random rand = new Random();
        private static int quant = 5;
        
        public void Implement()
        {            
            while (!Processes.isEmpty())
            {            	
                for (int i = 0; i < Processes.size(); i++)
                {               	              	
                    if (Processes.get(i).haveTime())
                    {                      
                            Processes.remove(i);
                            i--;
                    }
                    else
                    {
                        Processes.remove(i);
                        i--;
                    }
                }
            }
            System.out.println("final");
        }

        public void getInfo()
        {
            for (int i = 0; i < Processes.size(); i++)
            {
            	System.out.println(Processes.get(i).getName() + " thread: " + Processes.get(i).getCount());
            }
            System.out.println();
        }
        public void addProcesses()
        {
            for (int i = 0; i < rand.nextInt(5) + 3; i++)
            {
                int priority = rand.nextInt(3);
                Processes.add(new Process("" + i, quant * priority, priority));
            }
        }
    }

