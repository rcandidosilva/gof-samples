package flyweight;

public class StateFactory {
    public static final State CLEAN = new CleanState();
    public static final State DIRTY = new DirtyState();
    private static State currentState = CLEAN;
    
    public static State getCurrentState(){
        return currentState;
    }
    
    public static void setCurrentState(State state){
        currentState = state;
    }
}