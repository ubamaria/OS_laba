public class Thread
    {
        private String name;
        private int max_time;
        private int currentTime;
        private int requiredTime;

        public Thread(String thread, int requiredTime, int max_time)
        {
            this.max_time = max_time;
            this.requiredTime = requiredTime;
            this.currentTime = 0;
            this.name = "thread " + thread;
        }
        public void execute()
        {
            currentTime++;
            
        }
        public String getName()
        {
           return name;
        }

        public boolean needTime()
        {
            return requiredTime > currentTime;
        }

        public boolean haveTime()
        {
            return max_time > currentTime;
        }
        
    }