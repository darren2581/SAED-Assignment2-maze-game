// Generated from MapFile.g4 by ANTLR 4.13.1
package edu.curtin.game.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MapFileParser}.
 */
public interface MapFileListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MapFileParser#mapFile}.
	 * @param ctx the parse tree
	 */
	void enterMapFile(MapFileParser.MapFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapFileParser#mapFile}.
	 * @param ctx the parse tree
	 */
	void exitMapFile(MapFileParser.MapFileContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapFileParser#sizeDecl}.
	 * @param ctx the parse tree
	 */
	void enterSizeDecl(MapFileParser.SizeDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapFileParser#sizeDecl}.
	 * @param ctx the parse tree
	 */
	void exitSizeDecl(MapFileParser.SizeDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapFileParser#startDecl}.
	 * @param ctx the parse tree
	 */
	void enterStartDecl(MapFileParser.StartDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapFileParser#startDecl}.
	 * @param ctx the parse tree
	 */
	void exitStartDecl(MapFileParser.StartDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapFileParser#goalDecl}.
	 * @param ctx the parse tree
	 */
	void enterGoalDecl(MapFileParser.GoalDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapFileParser#goalDecl}.
	 * @param ctx the parse tree
	 */
	void exitGoalDecl(MapFileParser.GoalDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapFileParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(MapFileParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapFileParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(MapFileParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapFileParser#itemDecl}.
	 * @param ctx the parse tree
	 */
	void enterItemDecl(MapFileParser.ItemDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapFileParser#itemDecl}.
	 * @param ctx the parse tree
	 */
	void exitItemDecl(MapFileParser.ItemDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapFileParser#obstacleDecl}.
	 * @param ctx the parse tree
	 */
	void enterObstacleDecl(MapFileParser.ObstacleDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapFileParser#obstacleDecl}.
	 * @param ctx the parse tree
	 */
	void exitObstacleDecl(MapFileParser.ObstacleDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapFileParser#pluginDecl}.
	 * @param ctx the parse tree
	 */
	void enterPluginDecl(MapFileParser.PluginDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapFileParser#pluginDecl}.
	 * @param ctx the parse tree
	 */
	void exitPluginDecl(MapFileParser.PluginDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapFileParser#scriptDecl}.
	 * @param ctx the parse tree
	 */
	void enterScriptDecl(MapFileParser.ScriptDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapFileParser#scriptDecl}.
	 * @param ctx the parse tree
	 */
	void exitScriptDecl(MapFileParser.ScriptDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapFileParser#atDecl}.
	 * @param ctx the parse tree
	 */
	void enterAtDecl(MapFileParser.AtDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapFileParser#atDecl}.
	 * @param ctx the parse tree
	 */
	void exitAtDecl(MapFileParser.AtDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapFileParser#messageDecl}.
	 * @param ctx the parse tree
	 */
	void enterMessageDecl(MapFileParser.MessageDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapFileParser#messageDecl}.
	 * @param ctx the parse tree
	 */
	void exitMessageDecl(MapFileParser.MessageDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapFileParser#requiresDecl}.
	 * @param ctx the parse tree
	 */
	void enterRequiresDecl(MapFileParser.RequiresDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapFileParser#requiresDecl}.
	 * @param ctx the parse tree
	 */
	void exitRequiresDecl(MapFileParser.RequiresDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapFileParser#coords}.
	 * @param ctx the parse tree
	 */
	void enterCoords(MapFileParser.CoordsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapFileParser#coords}.
	 * @param ctx the parse tree
	 */
	void exitCoords(MapFileParser.CoordsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapFileParser#coordsList}.
	 * @param ctx the parse tree
	 */
	void enterCoordsList(MapFileParser.CoordsListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapFileParser#coordsList}.
	 * @param ctx the parse tree
	 */
	void exitCoordsList(MapFileParser.CoordsListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapFileParser#stringList}.
	 * @param ctx the parse tree
	 */
	void enterStringList(MapFileParser.StringListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapFileParser#stringList}.
	 * @param ctx the parse tree
	 */
	void exitStringList(MapFileParser.StringListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MapFileParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(MapFileParser.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MapFileParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(MapFileParser.QualifiedNameContext ctx);
}