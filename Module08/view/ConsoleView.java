package view;

import controller.IController;

import java.io.Console;

public class ConsoleView implements IView {
    private static final String PROMPT = "> ";
    private static final String ERROR = "Error: ";
    private static final Console console = System.console();
    private IController controller;

    public ConsoleView(IController controller) {
        this.controller = controller;
    }
    public void start() {
        displayWelcome();
        while (true) {
            String operation = getClientOperation();
            if (operation.equalsIgnoreCase("exit")) {
                break;
            }
            try {
                Number result = actions.processOperation(operation);
                displayResult(result);
            } catch (Exception e) {
                displayError(e.getMessage());
            }
        }
        close();
    }

}