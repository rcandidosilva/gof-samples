package flyweight;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CleanState implements State{
    public void save(File file, Serializable s, int type) throws IOException{ }

    public void edit(int type){
        StateFactory.setCurrentState(StateFactory.DIRTY);
        ((DirtyState)StateFactory.DIRTY).incrementStateValue(type);
    }
}