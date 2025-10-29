// Generated from MapFile.g4 by ANTLR 4.13.1
package edu.curtin.game.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MapFileParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, SCRIPT_BLOCK=17, 
		STRING=18, INT=19, ID=20, WS=21, COMMENT=22, BLOCK_COMMENT=23;
	public static final int
		RULE_mapFile = 0, RULE_declaration = 1, RULE_sizeDecl = 2, RULE_startDecl = 3, 
		RULE_goalDecl = 4, RULE_itemDecl = 5, RULE_obstacleDecl = 6, RULE_pluginDecl = 7, 
		RULE_scriptDecl = 8, RULE_atDecl = 9, RULE_messageDecl = 10, RULE_requiresDecl = 11, 
		RULE_coords = 12, RULE_coordsList = 13, RULE_stringList = 14, RULE_qualifiedName = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"mapFile", "declaration", "sizeDecl", "startDecl", "goalDecl", "itemDecl", 
			"obstacleDecl", "pluginDecl", "scriptDecl", "atDecl", "messageDecl", 
			"requiresDecl", "coords", "coordsList", "stringList", "qualifiedName"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'size'", "'start'", "'goal'", "'item'", "'{'", "'}'", "'obstacle'", 
			"'plugin'", "'script'", "'at'", "'message'", "'requires'", "'('", "','", 
			"')'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "SCRIPT_BLOCK", "STRING", "INT", "ID", 
			"WS", "COMMENT", "BLOCK_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MapFile.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MapFileParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MapFileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MapFileParser.EOF, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public MapFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapFile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapFileListener ) ((MapFileListener)listener).enterMapFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapFileListener ) ((MapFileListener)listener).exitMapFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapFileVisitor ) return ((MapFileVisitor<? extends T>)visitor).visitMapFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MapFileContext mapFile() throws RecognitionException {
		MapFileContext _localctx = new MapFileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_mapFile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(32);
				declaration();
				}
				}
				setState(35); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 926L) != 0) );
			setState(37);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public SizeDeclContext sizeDecl() {
			return getRuleContext(SizeDeclContext.class,0);
		}
		public StartDeclContext startDecl() {
			return getRuleContext(StartDeclContext.class,0);
		}
		public GoalDeclContext goalDecl() {
			return getRuleContext(GoalDeclContext.class,0);
		}
		public ItemDeclContext itemDecl() {
			return getRuleContext(ItemDeclContext.class,0);
		}
		public ObstacleDeclContext obstacleDecl() {
			return getRuleContext(ObstacleDeclContext.class,0);
		}
		public PluginDeclContext pluginDecl() {
			return getRuleContext(PluginDeclContext.class,0);
		}
		public ScriptDeclContext scriptDecl() {
			return getRuleContext(ScriptDeclContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapFileListener ) ((MapFileListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapFileListener ) ((MapFileListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapFileVisitor ) return ((MapFileVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		try {
			setState(46);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				sizeDecl();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
				startDecl();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(41);
				goalDecl();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 4);
				{
				setState(42);
				itemDecl();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 5);
				{
				setState(43);
				obstacleDecl();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 6);
				{
				setState(44);
				pluginDecl();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 7);
				{
				setState(45);
				scriptDecl();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SizeDeclContext extends ParserRuleContext {
		public CoordsContext coords() {
			return getRuleContext(CoordsContext.class,0);
		}
		public SizeDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sizeDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapFileListener ) ((MapFileListener)listener).enterSizeDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapFileListener ) ((MapFileListener)listener).exitSizeDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapFileVisitor ) return ((MapFileVisitor<? extends T>)visitor).visitSizeDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SizeDeclContext sizeDecl() throws RecognitionException {
		SizeDeclContext _localctx = new SizeDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sizeDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(T__0);
			setState(49);
			coords();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartDeclContext extends ParserRuleContext {
		public CoordsContext coords() {
			return getRuleContext(CoordsContext.class,0);
		}
		public StartDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_startDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapFileListener ) ((MapFileListener)listener).enterStartDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapFileListener ) ((MapFileListener)listener).exitStartDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapFileVisitor ) return ((MapFileVisitor<? extends T>)visitor).visitStartDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartDeclContext startDecl() throws RecognitionException {
		StartDeclContext _localctx = new StartDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_startDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(T__1);
			setState(52);
			coords();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GoalDeclContext extends ParserRuleContext {
		public CoordsContext coords() {
			return getRuleContext(CoordsContext.class,0);
		}
		public GoalDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_goalDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapFileListener ) ((MapFileListener)listener).enterGoalDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapFileListener ) ((MapFileListener)listener).exitGoalDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapFileVisitor ) return ((MapFileVisitor<? extends T>)visitor).visitGoalDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GoalDeclContext goalDecl() throws RecognitionException {
		GoalDeclContext _localctx = new GoalDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_goalDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(T__2);
			setState(55);
			coords();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ItemDeclContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(MapFileParser.STRING, 0); }
		public AtDeclContext atDecl() {
			return getRuleContext(AtDeclContext.class,0);
		}
		public MessageDeclContext messageDecl() {
			return getRuleContext(MessageDeclContext.class,0);
		}
		public ItemDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_itemDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapFileListener ) ((MapFileListener)listener).enterItemDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapFileListener ) ((MapFileListener)listener).exitItemDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapFileVisitor ) return ((MapFileVisitor<? extends T>)visitor).visitItemDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ItemDeclContext itemDecl() throws RecognitionException {
		ItemDeclContext _localctx = new ItemDeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_itemDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(T__3);
			setState(58);
			match(STRING);
			setState(59);
			match(T__4);
			setState(60);
			atDecl();
			setState(61);
			messageDecl();
			setState(62);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ObstacleDeclContext extends ParserRuleContext {
		public AtDeclContext atDecl() {
			return getRuleContext(AtDeclContext.class,0);
		}
		public RequiresDeclContext requiresDecl() {
			return getRuleContext(RequiresDeclContext.class,0);
		}
		public ObstacleDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_obstacleDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapFileListener ) ((MapFileListener)listener).enterObstacleDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapFileListener ) ((MapFileListener)listener).exitObstacleDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapFileVisitor ) return ((MapFileVisitor<? extends T>)visitor).visitObstacleDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObstacleDeclContext obstacleDecl() throws RecognitionException {
		ObstacleDeclContext _localctx = new ObstacleDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_obstacleDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(T__6);
			setState(65);
			match(T__4);
			setState(66);
			atDecl();
			setState(67);
			requiresDecl();
			setState(68);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PluginDeclContext extends ParserRuleContext {
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public PluginDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pluginDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapFileListener ) ((MapFileListener)listener).enterPluginDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapFileListener ) ((MapFileListener)listener).exitPluginDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapFileVisitor ) return ((MapFileVisitor<? extends T>)visitor).visitPluginDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PluginDeclContext pluginDecl() throws RecognitionException {
		PluginDeclContext _localctx = new PluginDeclContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_pluginDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(T__7);
			setState(71);
			qualifiedName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ScriptDeclContext extends ParserRuleContext {
		public TerminalNode SCRIPT_BLOCK() { return getToken(MapFileParser.SCRIPT_BLOCK, 0); }
		public ScriptDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scriptDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapFileListener ) ((MapFileListener)listener).enterScriptDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapFileListener ) ((MapFileListener)listener).exitScriptDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapFileVisitor ) return ((MapFileVisitor<? extends T>)visitor).visitScriptDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScriptDeclContext scriptDecl() throws RecognitionException {
		ScriptDeclContext _localctx = new ScriptDeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_scriptDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(T__8);
			setState(74);
			match(SCRIPT_BLOCK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AtDeclContext extends ParserRuleContext {
		public CoordsListContext coordsList() {
			return getRuleContext(CoordsListContext.class,0);
		}
		public AtDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapFileListener ) ((MapFileListener)listener).enterAtDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapFileListener ) ((MapFileListener)listener).exitAtDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapFileVisitor ) return ((MapFileVisitor<? extends T>)visitor).visitAtDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtDeclContext atDecl() throws RecognitionException {
		AtDeclContext _localctx = new AtDeclContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_atDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(T__9);
			setState(77);
			coordsList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MessageDeclContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(MapFileParser.STRING, 0); }
		public MessageDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_messageDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapFileListener ) ((MapFileListener)listener).enterMessageDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapFileListener ) ((MapFileListener)listener).exitMessageDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapFileVisitor ) return ((MapFileVisitor<? extends T>)visitor).visitMessageDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MessageDeclContext messageDecl() throws RecognitionException {
		MessageDeclContext _localctx = new MessageDeclContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_messageDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(T__10);
			setState(80);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RequiresDeclContext extends ParserRuleContext {
		public StringListContext stringList() {
			return getRuleContext(StringListContext.class,0);
		}
		public RequiresDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_requiresDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapFileListener ) ((MapFileListener)listener).enterRequiresDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapFileListener ) ((MapFileListener)listener).exitRequiresDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapFileVisitor ) return ((MapFileVisitor<? extends T>)visitor).visitRequiresDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RequiresDeclContext requiresDecl() throws RecognitionException {
		RequiresDeclContext _localctx = new RequiresDeclContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_requiresDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(T__11);
			setState(83);
			stringList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CoordsContext extends ParserRuleContext {
		public List<TerminalNode> INT() { return getTokens(MapFileParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(MapFileParser.INT, i);
		}
		public CoordsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coords; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapFileListener ) ((MapFileListener)listener).enterCoords(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapFileListener ) ((MapFileListener)listener).exitCoords(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapFileVisitor ) return ((MapFileVisitor<? extends T>)visitor).visitCoords(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CoordsContext coords() throws RecognitionException {
		CoordsContext _localctx = new CoordsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_coords);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(T__12);
			setState(86);
			match(INT);
			setState(87);
			match(T__13);
			setState(88);
			match(INT);
			setState(89);
			match(T__14);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CoordsListContext extends ParserRuleContext {
		public List<CoordsContext> coords() {
			return getRuleContexts(CoordsContext.class);
		}
		public CoordsContext coords(int i) {
			return getRuleContext(CoordsContext.class,i);
		}
		public CoordsListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coordsList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapFileListener ) ((MapFileListener)listener).enterCoordsList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapFileListener ) ((MapFileListener)listener).exitCoordsList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapFileVisitor ) return ((MapFileVisitor<? extends T>)visitor).visitCoordsList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CoordsListContext coordsList() throws RecognitionException {
		CoordsListContext _localctx = new CoordsListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_coordsList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			coords();
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13) {
				{
				{
				setState(92);
				match(T__13);
				setState(93);
				coords();
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StringListContext extends ParserRuleContext {
		public List<TerminalNode> STRING() { return getTokens(MapFileParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(MapFileParser.STRING, i);
		}
		public StringListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapFileListener ) ((MapFileListener)listener).enterStringList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapFileListener ) ((MapFileListener)listener).exitStringList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapFileVisitor ) return ((MapFileVisitor<? extends T>)visitor).visitStringList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringListContext stringList() throws RecognitionException {
		StringListContext _localctx = new StringListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_stringList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(STRING);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13) {
				{
				{
				setState(100);
				match(T__13);
				setState(101);
				match(STRING);
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QualifiedNameContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(MapFileParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MapFileParser.ID, i);
		}
		public QualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapFileListener ) ((MapFileListener)listener).enterQualifiedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapFileListener ) ((MapFileListener)listener).exitQualifiedName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MapFileVisitor ) return ((MapFileVisitor<? extends T>)visitor).visitQualifiedName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_qualifiedName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(ID);
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__15) {
				{
				{
				setState(108);
				match(T__15);
				setState(109);
				match(ID);
				}
				}
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0017t\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0001\u0000\u0004\u0000\"\b\u0000\u000b\u0000\f\u0000#\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001/\b\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\r\u0005\r_\b\r\n\r\f\rb\t\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0005\u000eg\b\u000e\n\u000e\f\u000ej\t\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0005\u000fo\b\u000f\n\u000f\f\u000fr\t\u000f\u0001"+
		"\u000f\u0000\u0000\u0010\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e\u0000\u0000m\u0000!\u0001\u0000\u0000"+
		"\u0000\u0002.\u0001\u0000\u0000\u0000\u00040\u0001\u0000\u0000\u0000\u0006"+
		"3\u0001\u0000\u0000\u0000\b6\u0001\u0000\u0000\u0000\n9\u0001\u0000\u0000"+
		"\u0000\f@\u0001\u0000\u0000\u0000\u000eF\u0001\u0000\u0000\u0000\u0010"+
		"I\u0001\u0000\u0000\u0000\u0012L\u0001\u0000\u0000\u0000\u0014O\u0001"+
		"\u0000\u0000\u0000\u0016R\u0001\u0000\u0000\u0000\u0018U\u0001\u0000\u0000"+
		"\u0000\u001a[\u0001\u0000\u0000\u0000\u001cc\u0001\u0000\u0000\u0000\u001e"+
		"k\u0001\u0000\u0000\u0000 \"\u0003\u0002\u0001\u0000! \u0001\u0000\u0000"+
		"\u0000\"#\u0001\u0000\u0000\u0000#!\u0001\u0000\u0000\u0000#$\u0001\u0000"+
		"\u0000\u0000$%\u0001\u0000\u0000\u0000%&\u0005\u0000\u0000\u0001&\u0001"+
		"\u0001\u0000\u0000\u0000\'/\u0003\u0004\u0002\u0000(/\u0003\u0006\u0003"+
		"\u0000)/\u0003\b\u0004\u0000*/\u0003\n\u0005\u0000+/\u0003\f\u0006\u0000"+
		",/\u0003\u000e\u0007\u0000-/\u0003\u0010\b\u0000.\'\u0001\u0000\u0000"+
		"\u0000.(\u0001\u0000\u0000\u0000.)\u0001\u0000\u0000\u0000.*\u0001\u0000"+
		"\u0000\u0000.+\u0001\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000.-\u0001"+
		"\u0000\u0000\u0000/\u0003\u0001\u0000\u0000\u000001\u0005\u0001\u0000"+
		"\u000012\u0003\u0018\f\u00002\u0005\u0001\u0000\u0000\u000034\u0005\u0002"+
		"\u0000\u000045\u0003\u0018\f\u00005\u0007\u0001\u0000\u0000\u000067\u0005"+
		"\u0003\u0000\u000078\u0003\u0018\f\u00008\t\u0001\u0000\u0000\u00009:"+
		"\u0005\u0004\u0000\u0000:;\u0005\u0012\u0000\u0000;<\u0005\u0005\u0000"+
		"\u0000<=\u0003\u0012\t\u0000=>\u0003\u0014\n\u0000>?\u0005\u0006\u0000"+
		"\u0000?\u000b\u0001\u0000\u0000\u0000@A\u0005\u0007\u0000\u0000AB\u0005"+
		"\u0005\u0000\u0000BC\u0003\u0012\t\u0000CD\u0003\u0016\u000b\u0000DE\u0005"+
		"\u0006\u0000\u0000E\r\u0001\u0000\u0000\u0000FG\u0005\b\u0000\u0000GH"+
		"\u0003\u001e\u000f\u0000H\u000f\u0001\u0000\u0000\u0000IJ\u0005\t\u0000"+
		"\u0000JK\u0005\u0011\u0000\u0000K\u0011\u0001\u0000\u0000\u0000LM\u0005"+
		"\n\u0000\u0000MN\u0003\u001a\r\u0000N\u0013\u0001\u0000\u0000\u0000OP"+
		"\u0005\u000b\u0000\u0000PQ\u0005\u0012\u0000\u0000Q\u0015\u0001\u0000"+
		"\u0000\u0000RS\u0005\f\u0000\u0000ST\u0003\u001c\u000e\u0000T\u0017\u0001"+
		"\u0000\u0000\u0000UV\u0005\r\u0000\u0000VW\u0005\u0013\u0000\u0000WX\u0005"+
		"\u000e\u0000\u0000XY\u0005\u0013\u0000\u0000YZ\u0005\u000f\u0000\u0000"+
		"Z\u0019\u0001\u0000\u0000\u0000[`\u0003\u0018\f\u0000\\]\u0005\u000e\u0000"+
		"\u0000]_\u0003\u0018\f\u0000^\\\u0001\u0000\u0000\u0000_b\u0001\u0000"+
		"\u0000\u0000`^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000a\u001b"+
		"\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000ch\u0005\u0012\u0000"+
		"\u0000de\u0005\u000e\u0000\u0000eg\u0005\u0012\u0000\u0000fd\u0001\u0000"+
		"\u0000\u0000gj\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000hi\u0001"+
		"\u0000\u0000\u0000i\u001d\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000"+
		"\u0000kp\u0005\u0014\u0000\u0000lm\u0005\u0010\u0000\u0000mo\u0005\u0014"+
		"\u0000\u0000nl\u0001\u0000\u0000\u0000or\u0001\u0000\u0000\u0000pn\u0001"+
		"\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000q\u001f\u0001\u0000\u0000"+
		"\u0000rp\u0001\u0000\u0000\u0000\u0005#.`hp";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}