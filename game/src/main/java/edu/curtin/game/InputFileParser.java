package edu.curtin.game;

import edu.curtin.game.api.*;
import edu.curtin.game.parser.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

public class InputFileParser {

    public static GameConfig parse(String filename, Charset encoding) throws IOException {
        CharStream input = CharStreams.fromFileName(filename, encoding);

        MapFileLexer lexer = new MapFileLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        edu.curtin.game.parser.MapFileParser parser = new edu.curtin.game.parser.MapFileParser(tokens);

        ParseTree tree = parser.mapFile();

        MapFileVisitorImpl visitor = new MapFileVisitorImpl();
        return (GameConfig) visitor.visit(tree);
    }

    private static class MapFileVisitorImpl extends MapFileBaseVisitor<Object> {
        private final GameConfig config = new GameConfig();

        @Override
        public GameConfig visitMapFile(edu.curtin.game.parser.MapFileParser.MapFileContext ctx) {
            visitChildren(ctx);
            return config;
        }

        @Override
        public Object visitSizeDecl(edu.curtin.game.parser.MapFileParser.SizeDeclContext ctx) {
            int[] coords = (int[]) visit(ctx.coords());
            config.setSize(coords[0], coords[1]);
            return null;
        }

        @Override
        public Object visitStartDecl(edu.curtin.game.parser.MapFileParser.StartDeclContext ctx) {
            int[] coords = (int[]) visit(ctx.coords());
            config.setStart(coords[0], coords[1]);
            return null;
        }

        @Override
        public Object visitGoalDecl(edu.curtin.game.parser.MapFileParser.GoalDeclContext ctx) {
            int[] coords = (int[]) visit(ctx.coords());
            config.setGoal(coords[0], coords[1]);
            return null;
        }

        @Override
        public Object visitItemDecl(edu.curtin.game.parser.MapFileParser.ItemDeclContext ctx) {
            String itemName = stripQuotes(ctx.STRING().getText());
            List<Location> locations = (List<Location>) visit(ctx.atDecl());
            config.addItem(itemName, locations);
            return null;
        }

        @Override
        public Object visitObstacleDecl(edu.curtin.game.parser.MapFileParser.ObstacleDeclContext ctx) {
            List<Location> locations = (List<Location>) visit(ctx.atDecl());
            List<String> required = (List<String>) visit(ctx.requiresDecl());
            Obstacle obstacle = new Obstacle(required);
            config.addObstacle(obstacle, locations);
            return null;
        }

        @Override
        public Object visitPluginDecl(edu.curtin.game.parser.MapFileParser.PluginDeclContext ctx) {
            String className = ctx.qualifiedName().getText();
            config.addPlugin(className);
            return null;
        }

        @Override
        public Object visitScriptDecl(edu.curtin.game.parser.MapFileParser.ScriptDeclContext ctx) {
            String scriptBlock = ctx.SCRIPT_BLOCK().getText();
            String script = scriptBlock.substring(2, scriptBlock.length() - 1);
            config.addScript(script);
            return null;
        }

        @Override
        public Object visitAtDecl(edu.curtin.game.parser.MapFileParser.AtDeclContext ctx) {
            return visit(ctx.coordsList());
        }

        @Override
        public Object visitRequiresDecl(edu.curtin.game.parser.MapFileParser.RequiresDeclContext ctx) {
            return visit(ctx.stringList());
        }

        @Override
        public Object visitCoords(edu.curtin.game.parser.MapFileParser.CoordsContext ctx) {
            int row = Integer.parseInt(ctx.INT(0).getText());
            int col = Integer.parseInt(ctx.INT(1).getText());
            return new int[]{row, col};
        }

        @Override
        public Object visitCoordsList(edu.curtin.game.parser.MapFileParser.CoordsListContext ctx) {
            List<Location> locations = new ArrayList<>();
            for (var coordsCtx : ctx.coords()) {
                int[] coords = (int[]) visit(coordsCtx);
                locations.add(new Location(coords[0], coords[1]));
            }
            return locations;
        }

        @Override
        public Object visitStringList(edu.curtin.game.parser.MapFileParser.StringListContext ctx) {
            List<String> strings = new ArrayList<>();
            for (var stringToken : ctx.STRING()) {
                strings.add(stripQuotes(stringToken.getText()));
            }
            return strings;
        }

        private String stripQuotes(String s) {
            if (s.length() >= 2 && s.startsWith("\"") && s.endsWith("\"")) {
                return s.substring(1, s.length() - 1);
            }
            return s;
        }
    }
}