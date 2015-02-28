package flyweight;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public interface State{
    public static final int CONTACTS = 1;
    public static final int ADDRESSES = 2;
    public static final int MAXIMUM_STATE_VALUE = 2;
    public void save(File f, Serializable s, int type) throws IOException;
    public void edit(int type);
}