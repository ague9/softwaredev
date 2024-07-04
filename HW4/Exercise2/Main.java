public class Main {
    public static void main(String[] args) {
        Model model = new Model();

        // Create three views
        View view1 = new View(1);
        View view2 = new View(2);
        View view3 = new View(3);

        // Register views with the model
        model.addObserver(view1);
        model.addObserver(view2);
        model.addObserver(view3);

        // Create a controller
        Controller controller = new Controller(model);

        // Simulate user changing data
        controller.changeData(10);
        controller.changeData(20);
        controller.changeData(30);
    }
}
