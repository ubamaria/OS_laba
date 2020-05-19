import java.util.ArrayList;

public class Process {
	private int id;
    private int countPages;
    private ArrayList<Integer> pagesIds;

    public Process(int id, int countPages) {
        this.id = id;
        this.countPages = countPages;
        this.pagesIds = new ArrayList<>();
    }

    public int getCountPages() {
        return countPages;
    }
    
    public int getId() {
        return id;
    }

    public ArrayList<Integer> getPagesIds() {
        return pagesIds;
    }
}
