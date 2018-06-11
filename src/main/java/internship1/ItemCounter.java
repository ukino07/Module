package internship1;

/**
 * Created by u_kino07 on 2018. 6. 6..
 */
public class ItemCounter {
    private int itemCount;

    public ItemCounter(int itemCount) {
        this.itemCount = itemCount;
    }

    public void takeOut() throws Exception {
        if (this.itemCount < 1) {
            throw new Exception("NO ITEM");
        }
        this.itemCount--;
    }

    public int getRemainingItemCount() {
        return this.itemCount;
    }
}
