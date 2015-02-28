package bridge;

public class NumberedList extends BaseList{
    public String get(int index){
        return (index + 1) + ". " + super.get(index);
    }
}