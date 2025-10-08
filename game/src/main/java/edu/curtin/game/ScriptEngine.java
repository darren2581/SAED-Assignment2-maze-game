package edu.curtin.game;

import edu.curtin.game.api.*;
import org.python.core.*;
import org.python.util.PythonInterpreter;

public class ScriptEngine {
    private final PythonInterpreter interpreter;
    private final GameAPI gameAPI;

    public ScriptEngine(GameAPI gameAPI) {
        this.gameAPI = gameAPI;
        this.interpreter = new PythonInterpreter();
        setupEnvironment();
    }

    private void setupEnvironment() {
        interpreter.set("api", gameAPI);
    }

    public void executeScript(String script) {
        try {
            interpreter.exec(script);
        } catch (PyException e) {
            System.err.println("Python script error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Script execution error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}