package edu.ucalgary.oop;

/**
 * Main app.
 * 
 * @author Stephen <a href="mailto:stephen.ravelo@ucalgary.ca">stephen.ravelo@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
 */
public class Main {
    /**
     * Creates and initializes View and Controller objects.
     * @param args Optional command-line argument.
     */
    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        controller.initController();
    }
}
