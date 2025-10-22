package edu.curtin.game;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: game <input-file>");
            System.exit(1);
        }

        String filename = args[0];
        Charset encoding = determineEncoding(filename);

        try {
            GameConfig config = InputFileParser.parse(filename, encoding);
            Game game = new Game(config);
            game.run();
        } catch (IOException e) {
            System.err.println("IO Error reading file '" + filename + "': " + e.getMessage());
            System.exit(1);
        } catch (IllegalArgumentException e) {
            System.err.println("Configuration or plugin error: " + e.getMessage());
            System.exit(1);
        }
    }

    private static Charset determineEncoding(String filename) {
        if (filename.endsWith(".utf8.map")) {
            return StandardCharsets.UTF_8;
        } else if (filename.endsWith(".utf16.map")) {
            return StandardCharsets.UTF_16;
        } else if (filename.endsWith(".utf32.map")) {
            return Charset.forName("UTF-32");
        }
        return StandardCharsets.UTF_8;
    }
}