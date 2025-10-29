package edu.curtin.game;

import edu.curtin.game.api.*;
import edu.curtin.game.parser.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

public class InputFileParser {

    // Parse the map file and return a GameConfig object
    public static GameConfig parse(String filename, Charset encoding) throws IOException {
        // Read the file into a character stream with specified encoding
        CharStream input = CharStreams.fromFileName(filename, encoding);

        // Create lexer to tokenize the input
        MapFileLexer lexer = new MapFileLexer(input);
        // Create token stream from lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // Create parser with token stream
        MapFileParser parser = new MapFileParser(tokens);

        // Parse the entire file into a parse tree
        ParseTree tree = parser.mapFile();

        // Create visitor to traverse and build config
        MapFileVisitorImpl visitor = new MapFileVisitorImpl();
        // Visit the tree to populate config
        return (GameConfig) visitor.visit(tree);
    }

    // Inner class: ANTLR visitor implementation to build GameConfig
    private static class MapFileVisitorImpl extends MapFileBaseVisitor<Object> {
        // Configuration object being built
        private final GameConfig config = new GameConfig();

        // Visit the root mapFile rule and return the config
        @Override
        public GameConfig visitMapFile(MapFileParser.MapFileContext ctx) {
            // Visit all child nodes to populate config
            visitChildren(ctx);
            return config;
        }

        // Handle size declaration
        @Override
        public Object visitSizeDecl(MapFileParser.SizeDeclContext ctx) {
            // Extract row and col from coords
            int[] coords = (int[]) visit(ctx.coords());
            // Set grid dimensions in config
            config.setSize(coords[0], coords[1]);
            return null;
        }

        // Handle start position declaration
        @Override
        public Object visitStartDecl(MapFileParser.StartDeclContext ctx) {
            // Extract row and col from coords
            int[] coords = (int[]) visit(ctx.coords());
            // Set player start position in config
            config.setStart(coords[0], coords[1]);
            return null;
        }

        // Handle goal position declaration
        @Override
        public Object visitGoalDecl(MapFileParser.GoalDeclContext ctx) {
            // Extract row and col from coords
            int[] coords = (int[]) visit(ctx.coords());
            // Set goal position in config
            config.setGoal(coords[0], coords[1]);
            return null;
        }

        // Handle item declaration
        @Override
        public Object visitItemDecl(MapFileParser.ItemDeclContext ctx) {
            // Extract item name from quoted string
            String itemName = stripQuotes(ctx.STRING().getText());
            // Get list of locations for this item
            List<Location> locations = (List<Location>) visit(ctx.atDecl());
            // Add item and its positions to config
            config.addItem(itemName, locations);
            return null;
        }

        // Handle obstacle declaration
        @Override
        public Object visitObstacleDecl(MapFileParser.ObstacleDeclContext ctx) {
            // Get list of locations for this obstacle
            List<Location> locations = (List<Location>) visit(ctx.atDecl());
            // Get list of required items for this obstacle
            List<String> required = (List<String>) visit(ctx.requiresDecl());
            // Create new obstacle with requirements
            Obstacle obstacle = new Obstacle(required);
            // Add obstacle and its positions to config
            config.addObstacle(obstacle, locations);
            return null;
        }

        // Handle plugin declaration
        @Override
        public Object visitPluginDecl(MapFileParser.PluginDeclContext ctx) {
            // Extract fully qualified class name
            String className = ctx.qualifiedName().getText();
            // Add plugin class to config
            config.addPlugin(className);
            return null;
        }

        // Handle script declaration
        @Override
        public Object visitScriptDecl(MapFileParser.ScriptDeclContext ctx) {
            // Extract script block text
            String scriptBlock = ctx.SCRIPT_BLOCK().getText();
            // Remove delimiters (<<< >>>) to get raw script
            String script = scriptBlock.substring(2, scriptBlock.length() - 1);
            // Add script to config
            config.addScript(script);
            return null;
        }

        // Handle 'at' declaration (redirects to coords list)
        @Override
        public Object visitAtDecl(MapFileParser.AtDeclContext ctx) {
            return visit(ctx.coordsList());
        }

        // Handle 'requires' declaration (redirects to string list)
        @Override
        public Object visitRequiresDecl(MapFileParser.RequiresDeclContext ctx) {
            return visit(ctx.stringList());
        }

        // Parse coordinates (row, col)
        @Override
        public Object visitCoords(MapFileParser.CoordsContext ctx) {
            // Parse first INT as row
            int row = Integer.parseInt(ctx.INT(0).getText());
            // Parse second INT as col
            int col = Integer.parseInt(ctx.INT(1).getText());
            // Return as array
            return new int[]{row, col};
        }

        // Parse list of coordinates into Location objects
        @Override
        public Object visitCoordsList(MapFileParser.CoordsListContext ctx) {
            // Create list to hold locations
            List<Location> locations = new ArrayList<>();
            // For each coords child
            for (var coordsCtx : ctx.coords()) {
                // Visit to get row/col array
                int[] coords = (int[]) visit(coordsCtx);
                // Create Location and add to list
                locations.add(new Location(coords[0], coords[1]));
            }
            return locations;
        }

        // Parse list of quoted strings
        @Override
        public Object visitStringList(MapFileParser.StringListContext ctx) {
            // Create list to hold strings
            List<String> strings = new ArrayList<>();
            // For each STRING token
            for (var stringToken : ctx.STRING()) {
                // Strip quotes and add to list
                strings.add(stripQuotes(stringToken.getText()));
            }
            return strings;
        }

        // Helper: Remove surrounding quotes from a string
        private String stripQuotes(String s) {
            // Check if string is quoted
            if (s.length() >= 2 && s.startsWith("\"") && s.endsWith("\"")) {
                // Return substring without quotes
                return s.substring(1, s.length() - 1);
            }
            // Return original if not quoted
            return s;
        }
    }
}