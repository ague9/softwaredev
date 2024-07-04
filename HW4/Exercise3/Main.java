public class Main {
    public static void main(String[] args) {
        Context context = new Context();

        // Define strategies using lambda expressions
        Strategy strategy1 = () -> System.out.println("Executing Strategy 1");
        Strategy strategy2 = () -> System.out.println("Executing Strategy 2");
        Strategy strategy3 = () -> System.out.println("Executing Strategy 3");

        // Set and execute Strategy 1
        context.setStrategy(strategy1);
        context.executeStrategy();

        // Set and execute Strategy 2
        context.setStrategy(strategy2);
        context.executeStrategy();

        // Set and execute Strategy 3
        context.setStrategy(strategy3);
        context.executeStrategy();
    }

    /*
     Explanation
        Strategy Interface: We define a functional interface Strategy with a single abstract method execute.
        Context Class: This class holds a reference to a Strategy and can execute the strategy.
        Main Class: We create different strategies using lambda expressions and set them in the context to execute them.
     Benefits
        Minimal Code: Using lambda expressions eliminates the need for creating separate concrete strategy classes, reducing boilerplate code.
        Flexibility: Strategies can be defined and modified easily at runtime.
        Readability: The code is more concise and easier to understand.

       Shortcomings
        Debugging: Lambda expressions can sometimes be harder to debug compared to named classes because they do not have meaningful names in stack traces.
        Complexity: For more complex strategies, lambda expressions may not be sufficient, and traditional class implementations might be necessary.
        Type Safety: If not careful, lambda expressions might lead to runtime errors if the functional interface method signature is not matched correctly.
     */
}
