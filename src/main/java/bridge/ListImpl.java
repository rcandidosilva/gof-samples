package bridge;

public interface ListImpl{
    public void addItem(String item);
    public void addItem(String item, int position);
    public void removeItem(String item);
    public int getNumberOfItems();
    public String getItem(int index);
    public boolean supportsOrdering();
}