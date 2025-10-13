package edu.curtin.game;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {
    // Entry point of the application
    public static void main(String[] args) {
        // Check if exactly one command-line argument (input file) is provided
        if (args.length != 1) {
            // Print usage instructions and exit with error code 1
            System.err.println("Usage: game <input-file>");
            System.exit(1);
        }

        // Store the filename from the first argument
        String filename = args[0];
        // Determine the character encoding based on the file extension
        Charset encoding = determineEncoding(filename);

        try {
            // Parse the input file to create a GameConfig object
            GameConfig config = InputFileParser.parse(filename, encoding);
            // Create a new Game instance with the parsed configuration
            Game game = new Game(config);
            // Start the game loop
            game.run();
        } catch (Exception e) {
            // Handle any exceptions during parsing or running
            System.err.println("Error: " + e.getMessage());
            // Print stack trace for debugging
            e.printStackTrace();
            // Exit with error code 1
            System.exit(1);
        }
    }

    // Helper method to determine the charset encoding from the filename extension
    private static Charset determineEncoding(String filename) {
        // Check if filename ends with .utf8.map
        if (filename.endsWith(".utf8.map")) {
            // Use UTF-8 encoding
            return StandardCharsets.UTF_8;
        } else if (filename.endsWith(".utf16.map")) {
            // Use UTF-16 encoding
            return StandardCharsets.UTF_16;
        } else if (filename.endsWith(".utf32.map")) {
            // Use UTF-32 encoding (requires explicit charset lookup)
            return Charset.forName("UTF-32");
        }
        // Default to UTF-8 if no specific extension matches
        return StandardCharsets.UTF_8; // Default
    }
}