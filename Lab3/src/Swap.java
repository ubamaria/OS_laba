import java.util.ArrayList;

public class Swap {
	private ArrayList<Page> pages;

    public Swap() {
        this.pages = new ArrayList<>();
    }

    public int addPage(Page page) {
        this.pages.add(page);
        return this.pages.indexOf(page);
    }
	
	public Page receivePage(int pageId) {
		return pages.get(pageId);
	}
}
