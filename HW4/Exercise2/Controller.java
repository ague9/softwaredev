public class Controller {
    private Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public void changeData(int data) {
        model.setData(data);
    }
}
