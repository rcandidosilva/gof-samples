package flyweight;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public class DirtyState implements State{
    private int stateFlags;
    
    public void save(File file, Serializable data, int stateType) throws IOException{
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream out = new ObjectOutputStream(fos);
        out.writeObject(data);
        decrementStateValue(stateType);
        if (stateFlags == 0){
            StateFactory.setCurrentState(StateFactory.CLEAN);
        }
    }

    public void edit(int type){
        incrementStateValue(type);
    }
    
    public void incrementStateValue(int stateType){
        if ((stateType > 0) && (stateType <= MAXIMUM_STATE_VALUE)){
            stateFlags = stateFlags | stateType;
        }
    }
    public void decrementStateValue(int stateType){
        if ((stateType > 0) && (stateType <= MAXIMUM_STATE_VALUE)){
            stateFlags = stateFlags ^ stateType;
        }
    }
}