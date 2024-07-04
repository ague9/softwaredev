import java.util.Observable;
import java.util.Observer;

public class View implements Observer {
    private int viewId;

    public View(int viewId) {
        this.viewId = viewId;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Model) {
            System.out.println("View " + viewId + " updated: " + ((Model) o).getData());
        }
    }
}
