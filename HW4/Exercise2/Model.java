import java.util.Observable;

public class Model extends Observable {
    private int data;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
        setChanged();
        notifyObservers(data);
    }
}
