package edu.curtin.game;

import edu.curtin.game.api.*;
import org.python.core.*;
import org.python.util.PythonInterpreter;

public class ScriptEngine {
    // Python interpreter for executing scripts
    private final PythonInterpreter interpreter;
    // Reference to the game API for script access
    private final GameAPI gameAPI;

    // Constructor: Initialize the script engine
    public ScriptEngine(GameAPI gameAPI) {
        this.gameAPI = gameAPI;
        // Create a new Python interpreter instance
        this.interpreter = new PythonInterpreter();
        // Set up the execution environment
        setupEnvironment();
    }

    // Set up variables in the Python namespace
    private void setupEnvironment() {
        // Bind the game API as 'api' variable for scripts to use
        interpreter.set("api", gameAPI);
    }

    // Execute a Python script string
    public void executeScript(String script) {
        try {
            // Execute the script code in the interpreter
            interpreter.exec(script);
        } catch (PyException e) {
            // Handle Python-specific exceptions
            System.err.println("Warning: Python script error - " + e.getMessage());
            // Only print full trace in debug mode
            // e.printStackTrace();
        } catch (Exception e) {
            // Handle general exceptions
            System.err.println("Warning: Script execution error - " + e.getMessage());
            // Only print full trace in debug mode
            // e.printStackTrace();
        }
    }
}