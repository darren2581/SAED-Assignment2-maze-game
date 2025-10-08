// Generated from MapFile.g4 by ANTLR 4.13.1
package edu.curtin.game.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MapFileParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MapFileVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MapFileParser#mapFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapFile(MapFileParser.MapFileContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapFileParser#sizeDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSizeDecl(MapFileParser.SizeDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapFileParser#startDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartDecl(MapFileParser.StartDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapFileParser#goalDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoalDecl(MapFileParser.GoalDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapFileParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(MapFileParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapFileParser#itemDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItemDecl(MapFileParser.ItemDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapFileParser#obstacleDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObstacleDecl(MapFileParser.ObstacleDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapFileParser#pluginDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPluginDecl(MapFileParser.PluginDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapFileParser#scriptDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScriptDecl(MapFileParser.ScriptDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapFileParser#atDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtDecl(MapFileParser.AtDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapFileParser#messageDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessageDecl(MapFileParser.MessageDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapFileParser#requiresDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRequiresDecl(MapFileParser.RequiresDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapFileParser#coords}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoords(MapFileParser.CoordsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapFileParser#coordsList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoordsList(MapFileParser.CoordsListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapFileParser#stringList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringList(MapFileParser.StringListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MapFileParser#qualifiedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedName(MapFileParser.QualifiedNameContext ctx);
}