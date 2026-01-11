// Generated from /Volumes/SSD_240G/blueprints/aura/parser/aura.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class auraParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		T__59=60, T__60=61, T__61=62, T__62=63, T__63=64, T__64=65, T__65=66, 
		T__66=67, T__67=68, T__68=69, T__69=70, T__70=71, T__71=72, T__72=73, 
		T__73=74, T__74=75, T__75=76, T__76=77, T__77=78, T__78=79, T__79=80, 
		T__80=81, T__81=82, T__82=83, T__83=84, T__84=85, T__85=86, T__86=87, 
		T__87=88, T__88=89, T__89=90, T__90=91, T__91=92, T__92=93, T__93=94, 
		T__94=95, T__95=96, T__96=97, T__97=98, T__98=99, T__99=100, T__100=101, 
		T__101=102, T__102=103, IDENT=104, NUMBER=105, STRING=106, WS=107, COMMENT=108, 
		BLOCK_COMMENT=109;
	public static final int
		RULE_program = 0, RULE_importDecl = 1, RULE_modulePath = 2, RULE_importItems = 3, 
		RULE_declaration = 4, RULE_varDecl = 5, RULE_constDecl = 6, RULE_funcDecl = 7, 
		RULE_typeParams = 8, RULE_parameterList = 9, RULE_parameter = 10, RULE_returnType = 11, 
		RULE_classDecl = 12, RULE_classBody = 13, RULE_methodDef = 14, RULE_propertyDef = 15, 
		RULE_traitDecl = 16, RULE_traitMember = 17, RULE_typeDecl = 18, RULE_moduleDecl = 19, 
		RULE_moduleMember = 20, RULE_decorator = 21, RULE_statement = 22, RULE_assertStmt = 23, 
		RULE_exprStmt = 24, RULE_ifStmt = 25, RULE_unlessStmt = 26, RULE_guardStmt = 27, 
		RULE_whileStmt = 28, RULE_untilStmt = 29, RULE_forStmt = 30, RULE_loopStmt = 31, 
		RULE_breakStmt = 32, RULE_continueStmt = 33, RULE_returnStmt = 34, RULE_tryStmt = 35, 
		RULE_exceptionPattern = 36, RULE_withStmt = 37, RULE_withItem = 38, RULE_matchStmt = 39, 
		RULE_matchCase = 40, RULE_blockStmt = 41, RULE_expression = 42, RULE_assignment = 43, 
		RULE_assignOp = 44, RULE_pipe = 45, RULE_ternary = 46, RULE_elvis = 47, 
		RULE_coalesce = 48, RULE_logicalOr = 49, RULE_logicalAnd = 50, RULE_bitwiseOr = 51, 
		RULE_bitwiseXor = 52, RULE_bitwiseAnd = 53, RULE_equality = 54, RULE_comparison = 55, 
		RULE_rangeExpr = 56, RULE_shift = 57, RULE_additive = 58, RULE_multiplicative = 59, 
		RULE_castExpr = 60, RULE_unary = 61, RULE_exponentiation = 62, RULE_postfix = 63, 
		RULE_call = 64, RULE_index = 65, RULE_member = 66, RULE_safeNav = 67, 
		RULE_spreadOp = 68, RULE_primary = 69, RULE_literal = 70, RULE_argumentList = 71, 
		RULE_argument = 72, RULE_listLiteral = 73, RULE_dictLiteral = 74, RULE_kvPair = 75, 
		RULE_setLiteral = 76, RULE_tupleLiteral = 77, RULE_lambdaExpr = 78, RULE_comprehension = 79, 
		RULE_comprehensionClause = 80, RULE_matchExpr = 81, RULE_blockExpr = 82, 
		RULE_pattern = 83, RULE_orPattern = 84, RULE_asPattern = 85, RULE_constructorOrLiteral = 86, 
		RULE_patternList = 87, RULE_fieldPatterns = 88, RULE_fieldPattern = 89, 
		RULE_typeAnnotation = 90, RULE_unionType = 91, RULE_primaryType = 92, 
		RULE_typeArgs = 93, RULE_fieldTypes = 94, RULE_fieldType = 95;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "importDecl", "modulePath", "importItems", "declaration", 
			"varDecl", "constDecl", "funcDecl", "typeParams", "parameterList", "parameter", 
			"returnType", "classDecl", "classBody", "methodDef", "propertyDef", "traitDecl", 
			"traitMember", "typeDecl", "moduleDecl", "moduleMember", "decorator", 
			"statement", "assertStmt", "exprStmt", "ifStmt", "unlessStmt", "guardStmt", 
			"whileStmt", "untilStmt", "forStmt", "loopStmt", "breakStmt", "continueStmt", 
			"returnStmt", "tryStmt", "exceptionPattern", "withStmt", "withItem", 
			"matchStmt", "matchCase", "blockStmt", "expression", "assignment", "assignOp", 
			"pipe", "ternary", "elvis", "coalesce", "logicalOr", "logicalAnd", "bitwiseOr", 
			"bitwiseXor", "bitwiseAnd", "equality", "comparison", "rangeExpr", "shift", 
			"additive", "multiplicative", "castExpr", "unary", "exponentiation", 
			"postfix", "call", "index", "member", "safeNav", "spreadOp", "primary", 
			"literal", "argumentList", "argument", "listLiteral", "dictLiteral", 
			"kvPair", "setLiteral", "tupleLiteral", "lambdaExpr", "comprehension", 
			"comprehensionClause", "matchExpr", "blockExpr", "pattern", "orPattern", 
			"asPattern", "constructorOrLiteral", "patternList", "fieldPatterns", 
			"fieldPattern", "typeAnnotation", "unionType", "primaryType", "typeArgs", 
			"fieldTypes", "fieldType"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'import'", "'as'", "'from'", "'.'", "','", "'*'", "'let'", "'mut'", 
			"'='", "';'", "'const'", "'async'", "'def'", "'('", "')'", "'{'", "'}'", 
			"'<'", "'>'", "'**'", "'->'", "'class'", "'extends'", "'implements'", 
			"'@'", "'staticmethod'", "'classmethod'", "'property'", "'self'", "'trait'", 
			"'type'", "'module'", "'export'", "'assert'", "'if'", "'else'", "'unless'", 
			"'guard'", "'while'", "'until'", "'for'", "'in'", "'step'", "'loop'", 
			"'break'", "'continue'", "'return'", "'try'", "'catch'", "'finally'", 
			"'with'", "'match'", "'case'", "'+='", "'-='", "'*='", "'/='", "'//='", 
			"'%='", "'**='", "'&='", "'|='", "'^='", "'<<='", "'>>='", "'??='", "'|>'", 
			"'?'", "':'", "'?:'", "'??'", "'or'", "'and'", "'|'", "'^'", "'&'", "'=='", 
			"'!='", "'is'", "'<='", "'>='", "'..'", "'..<'", "'<<'", "'>>'", "'+'", 
			"'-'", "'/'", "'//'", "'%'", "'not'", "'~'", "'['", "']'", "'?.'", "'?['", 
			"'...'", "'true'", "'false'", "'null'", "'none'", "'=>'", "'_'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "IDENT", "NUMBER", "STRING", 
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
	public String getGrammarFileName() { return "aura.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public auraParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(auraParser.EOF, 0); }
		public List<ImportDeclContext> importDecl() {
			return getRuleContexts(ImportDeclContext.class);
		}
		public ImportDeclContext importDecl(int i) {
			return getRuleContext(ImportDeclContext.class,i);
		}
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__6) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__21) | (1L << T__24) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__50) | (1L << T__51))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (T__85 - 86)) | (1L << (T__86 - 86)) | (1L << (T__90 - 86)) | (1L << (T__91 - 86)) | (1L << (T__92 - 86)) | (1L << (T__97 - 86)) | (1L << (T__98 - 86)) | (1L << (T__99 - 86)) | (1L << (T__100 - 86)) | (1L << (IDENT - 86)) | (1L << (NUMBER - 86)) | (1L << (STRING - 86)))) != 0)) {
				{
				setState(195);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(192);
					importDecl();
					}
					break;
				case 2:
					{
					setState(193);
					declaration();
					}
					break;
				case 3:
					{
					setState(194);
					statement();
					}
					break;
				}
				}
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(200);
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

	public static class ImportDeclContext extends ParserRuleContext {
		public ImportDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDecl; }
	 
		public ImportDeclContext() { }
		public void copyFrom(ImportDeclContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FromImportContext extends ImportDeclContext {
		public ModulePathContext modulePath() {
			return getRuleContext(ModulePathContext.class,0);
		}
		public ImportItemsContext importItems() {
			return getRuleContext(ImportItemsContext.class,0);
		}
		public FromImportContext(ImportDeclContext ctx) { copyFrom(ctx); }
	}
	public static class ImportModuleContext extends ImportDeclContext {
		public ModulePathContext modulePath() {
			return getRuleContext(ModulePathContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(auraParser.IDENT, 0); }
		public ImportModuleContext(ImportDeclContext ctx) { copyFrom(ctx); }
	}

	public final ImportDeclContext importDecl() throws RecognitionException {
		ImportDeclContext _localctx = new ImportDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_importDecl);
		int _la;
		try {
			setState(213);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new ImportModuleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(202);
				match(T__0);
				setState(203);
				modulePath();
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(204);
					match(T__1);
					setState(205);
					match(IDENT);
					}
				}

				}
				break;
			case T__2:
				_localctx = new FromImportContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(208);
				match(T__2);
				setState(209);
				modulePath();
				setState(210);
				match(T__0);
				setState(211);
				importItems();
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

	public static class ModulePathContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(auraParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(auraParser.IDENT, i);
		}
		public ModulePathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modulePath; }
	}

	public final ModulePathContext modulePath() throws RecognitionException {
		ModulePathContext _localctx = new ModulePathContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_modulePath);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(IDENT);
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(216);
				match(T__3);
				setState(217);
				match(IDENT);
				}
				}
				setState(222);
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

	public static class ImportItemsContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(auraParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(auraParser.IDENT, i);
		}
		public ImportItemsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importItems; }
	}

	public final ImportItemsContext importItems() throws RecognitionException {
		ImportItemsContext _localctx = new ImportItemsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_importItems);
		int _la;
		try {
			int _alt;
			setState(235);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(223);
				match(IDENT);
				setState(228);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(224);
						match(T__4);
						setState(225);
						match(IDENT);
						}
						} 
					}
					setState(230);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				}
				setState(232);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(231);
					match(T__4);
					}
				}

				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(234);
				match(T__5);
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

	public static class DeclarationContext extends ParserRuleContext {
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public ConstDeclContext constDecl() {
			return getRuleContext(ConstDeclContext.class,0);
		}
		public FuncDeclContext funcDecl() {
			return getRuleContext(FuncDeclContext.class,0);
		}
		public ClassDeclContext classDecl() {
			return getRuleContext(ClassDeclContext.class,0);
		}
		public TraitDeclContext traitDecl() {
			return getRuleContext(TraitDeclContext.class,0);
		}
		public TypeDeclContext typeDecl() {
			return getRuleContext(TypeDeclContext.class,0);
		}
		public ModuleDeclContext moduleDecl() {
			return getRuleContext(ModuleDeclContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declaration);
		try {
			setState(244);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(237);
				varDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(238);
				constDecl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(239);
				funcDecl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(240);
				classDecl();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(241);
				traitDecl();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(242);
				typeDecl();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(243);
				moduleDecl();
				}
				break;
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

	public static class VarDeclContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(auraParser.IDENT, 0); }
		public TypeAnnotationContext typeAnnotation() {
			return getRuleContext(TypeAnnotationContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_varDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(T__6);
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(247);
				match(T__7);
				}
			}

			setState(250);
			match(IDENT);
			setState(252);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__13 || _la==T__15 || _la==T__92 || _la==IDENT) {
				{
				setState(251);
				typeAnnotation();
				}
			}

			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(254);
				match(T__8);
				setState(255);
				expression();
				}
			}

			setState(258);
			match(T__9);
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

	public static class ConstDeclContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(auraParser.IDENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TypeAnnotationContext typeAnnotation() {
			return getRuleContext(TypeAnnotationContext.class,0);
		}
		public ConstDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDecl; }
	}

	public final ConstDeclContext constDecl() throws RecognitionException {
		ConstDeclContext _localctx = new ConstDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_constDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(T__10);
			setState(261);
			match(IDENT);
			setState(263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__13 || _la==T__15 || _la==T__92 || _la==IDENT) {
				{
				setState(262);
				typeAnnotation();
				}
			}

			setState(265);
			match(T__8);
			setState(266);
			expression();
			setState(267);
			match(T__9);
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

	public static class FuncDeclContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(auraParser.IDENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<DecoratorContext> decorator() {
			return getRuleContexts(DecoratorContext.class);
		}
		public DecoratorContext decorator(int i) {
			return getRuleContext(DecoratorContext.class,i);
		}
		public TypeParamsContext typeParams() {
			return getRuleContext(TypeParamsContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public ReturnTypeContext returnType() {
			return getRuleContext(ReturnTypeContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FuncDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDecl; }
	}

	public final FuncDeclContext funcDecl() throws RecognitionException {
		FuncDeclContext _localctx = new FuncDeclContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_funcDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24) {
				{
				{
				setState(269);
				decorator();
				}
				}
				setState(274);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(276);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(275);
				match(T__11);
				}
			}

			setState(278);
			match(T__12);
			setState(279);
			match(IDENT);
			setState(281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(280);
				typeParams();
				}
			}

			setState(283);
			match(T__13);
			setState(285);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5 || _la==T__19 || _la==IDENT) {
				{
				setState(284);
				parameterList();
				}
			}

			setState(287);
			match(T__14);
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(288);
				returnType();
				}
			}

			setState(301);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__15:
				{
				setState(291);
				match(T__15);
				setState(295);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__33) | (1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__50) | (1L << T__51))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (T__85 - 86)) | (1L << (T__86 - 86)) | (1L << (T__90 - 86)) | (1L << (T__91 - 86)) | (1L << (T__92 - 86)) | (1L << (T__97 - 86)) | (1L << (T__98 - 86)) | (1L << (T__99 - 86)) | (1L << (T__100 - 86)) | (1L << (IDENT - 86)) | (1L << (NUMBER - 86)) | (1L << (STRING - 86)))) != 0)) {
					{
					{
					setState(292);
					statement();
					}
					}
					setState(297);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(298);
				match(T__16);
				}
				break;
			case T__8:
				{
				setState(299);
				match(T__8);
				setState(300);
				expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class TypeParamsContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(auraParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(auraParser.IDENT, i);
		}
		public TypeParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParams; }
	}

	public final TypeParamsContext typeParams() throws RecognitionException {
		TypeParamsContext _localctx = new TypeParamsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_typeParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			match(T__17);
			setState(304);
			match(IDENT);
			setState(309);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(305);
				match(T__4);
				setState(306);
				match(IDENT);
				}
				}
				setState(311);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(312);
			match(T__18);
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

	public static class ParameterListContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			parameter();
			setState(319);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(315);
				match(T__4);
				setState(316);
				parameter();
				}
				}
				setState(321);
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

	public static class ParameterContext extends ParserRuleContext {
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
	 
		public ParameterContext() { }
		public void copyFrom(ParameterContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PositionalParamContext extends ParameterContext {
		public TerminalNode IDENT() { return getToken(auraParser.IDENT, 0); }
		public TypeAnnotationContext typeAnnotation() {
			return getRuleContext(TypeAnnotationContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PositionalParamContext(ParameterContext ctx) { copyFrom(ctx); }
	}
	public static class KwargParamContext extends ParameterContext {
		public TerminalNode IDENT() { return getToken(auraParser.IDENT, 0); }
		public KwargParamContext(ParameterContext ctx) { copyFrom(ctx); }
	}
	public static class KeywordOnlyMarkerContext extends ParameterContext {
		public KeywordOnlyMarkerContext(ParameterContext ctx) { copyFrom(ctx); }
	}
	public static class VariadicParamContext extends ParameterContext {
		public TerminalNode IDENT() { return getToken(auraParser.IDENT, 0); }
		public VariadicParamContext(ParameterContext ctx) { copyFrom(ctx); }
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_parameter);
		int _la;
		try {
			setState(335);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				_localctx = new PositionalParamContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(322);
				match(IDENT);
				setState(324);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__13 || _la==T__15 || _la==T__92 || _la==IDENT) {
					{
					setState(323);
					typeAnnotation();
					}
				}

				setState(328);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(326);
					match(T__8);
					setState(327);
					expression();
					}
				}

				}
				break;
			case 2:
				_localctx = new VariadicParamContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(330);
				match(T__5);
				setState(331);
				match(IDENT);
				}
				break;
			case 3:
				_localctx = new KeywordOnlyMarkerContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(332);
				match(T__5);
				}
				break;
			case 4:
				_localctx = new KwargParamContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(333);
				match(T__19);
				setState(334);
				match(IDENT);
				}
				break;
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

	public static class ReturnTypeContext extends ParserRuleContext {
		public TypeAnnotationContext typeAnnotation() {
			return getRuleContext(TypeAnnotationContext.class,0);
		}
		public ReturnTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnType; }
	}

	public final ReturnTypeContext returnType() throws RecognitionException {
		ReturnTypeContext _localctx = new ReturnTypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_returnType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			match(T__20);
			setState(338);
			typeAnnotation();
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

	public static class ClassDeclContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(auraParser.IDENT, 0); }
		public List<DecoratorContext> decorator() {
			return getRuleContexts(DecoratorContext.class);
		}
		public DecoratorContext decorator(int i) {
			return getRuleContext(DecoratorContext.class,i);
		}
		public TypeParamsContext typeParams() {
			return getRuleContext(TypeParamsContext.class,0);
		}
		public List<TypeAnnotationContext> typeAnnotation() {
			return getRuleContexts(TypeAnnotationContext.class);
		}
		public TypeAnnotationContext typeAnnotation(int i) {
			return getRuleContext(TypeAnnotationContext.class,i);
		}
		public List<ClassBodyContext> classBody() {
			return getRuleContexts(ClassBodyContext.class);
		}
		public ClassBodyContext classBody(int i) {
			return getRuleContext(ClassBodyContext.class,i);
		}
		public ClassDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDecl; }
	}

	public final ClassDeclContext classDecl() throws RecognitionException {
		ClassDeclContext _localctx = new ClassDeclContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_classDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24) {
				{
				{
				setState(340);
				decorator();
				}
				}
				setState(345);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(346);
			match(T__21);
			setState(347);
			match(IDENT);
			setState(349);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(348);
				typeParams();
				}
			}

			setState(353);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
				setState(351);
				match(T__22);
				setState(352);
				typeAnnotation();
				}
			}

			setState(364);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__23) {
				{
				setState(355);
				match(T__23);
				setState(356);
				typeAnnotation();
				setState(361);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(357);
					match(T__4);
					setState(358);
					typeAnnotation();
					}
					}
					setState(363);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(366);
			match(T__15);
			setState(370);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24 || _la==IDENT) {
				{
				{
				setState(367);
				classBody();
				}
				}
				setState(372);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(373);
			match(T__16);
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

	public static class ClassBodyContext extends ParserRuleContext {
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
	 
		public ClassBodyContext() { }
		public void copyFrom(ClassBodyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FieldDefContext extends ClassBodyContext {
		public TerminalNode IDENT() { return getToken(auraParser.IDENT, 0); }
		public TypeAnnotationContext typeAnnotation() {
			return getRuleContext(TypeAnnotationContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FieldDefContext(ClassBodyContext ctx) { copyFrom(ctx); }
	}
	public static class ClassMethodDefContext extends ClassBodyContext {
		public MethodDefContext methodDef() {
			return getRuleContext(MethodDefContext.class,0);
		}
		public ClassMethodDefContext(ClassBodyContext ctx) { copyFrom(ctx); }
	}
	public static class ClassPropertyDefContext extends ClassBodyContext {
		public PropertyDefContext propertyDef() {
			return getRuleContext(PropertyDefContext.class,0);
		}
		public ClassPropertyDefContext(ClassBodyContext ctx) { copyFrom(ctx); }
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_classBody);
		int _la;
		try {
			setState(385);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				_localctx = new FieldDefContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(375);
				match(IDENT);
				setState(377);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(376);
					typeAnnotation();
					}
					break;
				}
				setState(381);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(379);
					match(T__8);
					setState(380);
					expression();
					}
				}

				}
				break;
			case 2:
				_localctx = new ClassMethodDefContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(383);
				methodDef();
				}
				break;
			case 3:
				_localctx = new ClassPropertyDefContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(384);
				propertyDef();
				}
				break;
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

	public static class MethodDefContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(auraParser.IDENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public ReturnTypeContext returnType() {
			return getRuleContext(ReturnTypeContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MethodDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDef; }
	}

	public final MethodDefContext methodDef() throws RecognitionException {
		MethodDefContext _localctx = new MethodDefContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_methodDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
			match(T__24);
			setState(389);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(388);
				match(T__25);
				}
			}

			setState(391);
			match(T__24);
			setState(393);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__26) {
				{
				setState(392);
				match(T__26);
				}
			}

			setState(395);
			match(T__12);
			setState(396);
			match(IDENT);
			setState(397);
			match(T__13);
			setState(399);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5 || _la==T__19 || _la==IDENT) {
				{
				setState(398);
				parameterList();
				}
			}

			setState(401);
			match(T__14);
			setState(403);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(402);
				returnType();
				}
			}

			setState(415);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__15:
				{
				setState(405);
				match(T__15);
				setState(409);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__33) | (1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__50) | (1L << T__51))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (T__85 - 86)) | (1L << (T__86 - 86)) | (1L << (T__90 - 86)) | (1L << (T__91 - 86)) | (1L << (T__92 - 86)) | (1L << (T__97 - 86)) | (1L << (T__98 - 86)) | (1L << (T__99 - 86)) | (1L << (T__100 - 86)) | (1L << (IDENT - 86)) | (1L << (NUMBER - 86)) | (1L << (STRING - 86)))) != 0)) {
					{
					{
					setState(406);
					statement();
					}
					}
					setState(411);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(412);
				match(T__16);
				}
				break;
			case T__8:
				{
				setState(413);
				match(T__8);
				setState(414);
				expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class PropertyDefContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(auraParser.IDENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnTypeContext returnType() {
			return getRuleContext(ReturnTypeContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public PropertyDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyDef; }
	}

	public final PropertyDefContext propertyDef() throws RecognitionException {
		PropertyDefContext _localctx = new PropertyDefContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_propertyDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
			match(T__24);
			setState(418);
			match(T__27);
			setState(419);
			match(T__12);
			setState(420);
			match(IDENT);
			setState(421);
			match(T__13);
			setState(422);
			match(T__28);
			setState(423);
			match(T__14);
			setState(425);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(424);
				returnType();
				}
			}

			setState(437);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__15:
				{
				setState(427);
				match(T__15);
				setState(431);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__33) | (1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__50) | (1L << T__51))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (T__85 - 86)) | (1L << (T__86 - 86)) | (1L << (T__90 - 86)) | (1L << (T__91 - 86)) | (1L << (T__92 - 86)) | (1L << (T__97 - 86)) | (1L << (T__98 - 86)) | (1L << (T__99 - 86)) | (1L << (T__100 - 86)) | (1L << (IDENT - 86)) | (1L << (NUMBER - 86)) | (1L << (STRING - 86)))) != 0)) {
					{
					{
					setState(428);
					statement();
					}
					}
					setState(433);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(434);
				match(T__16);
				}
				break;
			case T__8:
				{
				setState(435);
				match(T__8);
				setState(436);
				expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class TraitDeclContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(auraParser.IDENT, 0); }
		public TypeParamsContext typeParams() {
			return getRuleContext(TypeParamsContext.class,0);
		}
		public List<TraitMemberContext> traitMember() {
			return getRuleContexts(TraitMemberContext.class);
		}
		public TraitMemberContext traitMember(int i) {
			return getRuleContext(TraitMemberContext.class,i);
		}
		public TraitDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_traitDecl; }
	}

	public final TraitDeclContext traitDecl() throws RecognitionException {
		TraitDeclContext _localctx = new TraitDeclContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_traitDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(439);
			match(T__29);
			setState(440);
			match(IDENT);
			setState(442);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(441);
				typeParams();
				}
			}

			setState(444);
			match(T__15);
			setState(448);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12 || _la==T__24) {
				{
				{
				setState(445);
				traitMember();
				}
				}
				setState(450);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(451);
			match(T__16);
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

	public static class TraitMemberContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(auraParser.IDENT, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public ReturnTypeContext returnType() {
			return getRuleContext(ReturnTypeContext.class,0);
		}
		public TraitMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_traitMember; }
	}

	public final TraitMemberContext traitMember() throws RecognitionException {
		TraitMemberContext _localctx = new TraitMemberContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_traitMember);
		int _la;
		try {
			setState(475);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				enterOuterAlt(_localctx, 1);
				{
				setState(453);
				match(T__12);
				setState(454);
				match(IDENT);
				setState(455);
				match(T__13);
				setState(457);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5 || _la==T__19 || _la==IDENT) {
					{
					setState(456);
					parameterList();
					}
				}

				setState(459);
				match(T__14);
				setState(461);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__20) {
					{
					setState(460);
					returnType();
					}
				}

				setState(463);
				match(T__9);
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 2);
				{
				setState(464);
				match(T__24);
				setState(465);
				match(T__27);
				setState(466);
				match(T__12);
				setState(467);
				match(IDENT);
				setState(468);
				match(T__13);
				setState(469);
				match(T__28);
				setState(470);
				match(T__14);
				setState(472);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__20) {
					{
					setState(471);
					returnType();
					}
				}

				setState(474);
				match(T__9);
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

	public static class TypeDeclContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(auraParser.IDENT, 0); }
		public TypeAnnotationContext typeAnnotation() {
			return getRuleContext(TypeAnnotationContext.class,0);
		}
		public TypeParamsContext typeParams() {
			return getRuleContext(TypeParamsContext.class,0);
		}
		public TypeDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDecl; }
	}

	public final TypeDeclContext typeDecl() throws RecognitionException {
		TypeDeclContext _localctx = new TypeDeclContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_typeDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477);
			match(T__30);
			setState(478);
			match(IDENT);
			setState(480);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(479);
				typeParams();
				}
			}

			setState(482);
			match(T__8);
			setState(483);
			typeAnnotation();
			setState(484);
			match(T__9);
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

	public static class ModuleDeclContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(auraParser.IDENT, 0); }
		public List<ModuleMemberContext> moduleMember() {
			return getRuleContexts(ModuleMemberContext.class);
		}
		public ModuleMemberContext moduleMember(int i) {
			return getRuleContext(ModuleMemberContext.class,i);
		}
		public ModuleDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moduleDecl; }
	}

	public final ModuleDeclContext moduleDecl() throws RecognitionException {
		ModuleDeclContext _localctx = new ModuleDeclContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_moduleDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(486);
			match(T__31);
			setState(487);
			match(IDENT);
			setState(488);
			match(T__15);
			setState(492);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__21) | (1L << T__24) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__50) | (1L << T__51))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (T__85 - 86)) | (1L << (T__86 - 86)) | (1L << (T__90 - 86)) | (1L << (T__91 - 86)) | (1L << (T__92 - 86)) | (1L << (T__97 - 86)) | (1L << (T__98 - 86)) | (1L << (T__99 - 86)) | (1L << (T__100 - 86)) | (1L << (IDENT - 86)) | (1L << (NUMBER - 86)) | (1L << (STRING - 86)))) != 0)) {
				{
				{
				setState(489);
				moduleMember();
				}
				}
				setState(494);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(495);
			match(T__16);
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

	public static class ModuleMemberContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ModuleMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moduleMember; }
	}

	public final ModuleMemberContext moduleMember() throws RecognitionException {
		ModuleMemberContext _localctx = new ModuleMemberContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_moduleMember);
		int _la;
		try {
			setState(505);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(498);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__32) {
					{
					setState(497);
					match(T__32);
					}
				}

				setState(500);
				declaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(502);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__32) {
					{
					setState(501);
					match(T__32);
					}
				}

				setState(504);
				statement();
				}
				break;
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

	public static class DecoratorContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(auraParser.IDENT, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public DecoratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decorator; }
	}

	public final DecoratorContext decorator() throws RecognitionException {
		DecoratorContext _localctx = new DecoratorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_decorator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(507);
			match(T__24);
			setState(508);
			match(IDENT);
			setState(514);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(509);
				match(T__13);
				setState(511);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__15) | (1L << T__51))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (T__85 - 86)) | (1L << (T__86 - 86)) | (1L << (T__90 - 86)) | (1L << (T__91 - 86)) | (1L << (T__92 - 86)) | (1L << (T__97 - 86)) | (1L << (T__98 - 86)) | (1L << (T__99 - 86)) | (1L << (T__100 - 86)) | (1L << (IDENT - 86)) | (1L << (NUMBER - 86)) | (1L << (STRING - 86)))) != 0)) {
					{
					setState(510);
					argumentList();
					}
				}

				setState(513);
				match(T__14);
				}
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

	public static class StatementContext extends ParserRuleContext {
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public ConstDeclContext constDecl() {
			return getRuleContext(ConstDeclContext.class,0);
		}
		public ExprStmtContext exprStmt() {
			return getRuleContext(ExprStmtContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public UnlessStmtContext unlessStmt() {
			return getRuleContext(UnlessStmtContext.class,0);
		}
		public GuardStmtContext guardStmt() {
			return getRuleContext(GuardStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public UntilStmtContext untilStmt() {
			return getRuleContext(UntilStmtContext.class,0);
		}
		public ForStmtContext forStmt() {
			return getRuleContext(ForStmtContext.class,0);
		}
		public LoopStmtContext loopStmt() {
			return getRuleContext(LoopStmtContext.class,0);
		}
		public BreakStmtContext breakStmt() {
			return getRuleContext(BreakStmtContext.class,0);
		}
		public ContinueStmtContext continueStmt() {
			return getRuleContext(ContinueStmtContext.class,0);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public TryStmtContext tryStmt() {
			return getRuleContext(TryStmtContext.class,0);
		}
		public WithStmtContext withStmt() {
			return getRuleContext(WithStmtContext.class,0);
		}
		public MatchStmtContext matchStmt() {
			return getRuleContext(MatchStmtContext.class,0);
		}
		public BlockStmtContext blockStmt() {
			return getRuleContext(BlockStmtContext.class,0);
		}
		public AssertStmtContext assertStmt() {
			return getRuleContext(AssertStmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_statement);
		try {
			setState(538);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(516);
				varDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(517);
				constDecl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(518);
				exprStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(519);
				ifStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(520);
				unlessStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(521);
				guardStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(522);
				whileStmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(523);
				untilStmt();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(524);
				forStmt();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(525);
				loopStmt();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(526);
				breakStmt();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(527);
				continueStmt();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(528);
				returnStmt();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(529);
				tryStmt();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(530);
				withStmt();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(531);
				matchStmt();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(532);
				returnStmt();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(533);
				tryStmt();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(534);
				withStmt();
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(535);
				matchStmt();
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(536);
				blockStmt();
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(537);
				assertStmt();
				}
				break;
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

	public static class AssertStmtContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AssertStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assertStmt; }
	}

	public final AssertStmtContext assertStmt() throws RecognitionException {
		AssertStmtContext _localctx = new AssertStmtContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_assertStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(540);
			match(T__33);
			setState(541);
			expression();
			setState(544);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(542);
				match(T__4);
				setState(543);
				expression();
				}
			}

			setState(546);
			match(T__9);
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

	public static class ExprStmtContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprStmt; }
	}

	public final ExprStmtContext exprStmt() throws RecognitionException {
		ExprStmtContext _localctx = new ExprStmtContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_exprStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(548);
			expression();
			setState(549);
			match(T__9);
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

	public static class IfStmtContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_ifStmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(551);
			match(T__34);
			setState(552);
			expression();
			setState(553);
			match(T__15);
			setState(557);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__33) | (1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__50) | (1L << T__51))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (T__85 - 86)) | (1L << (T__86 - 86)) | (1L << (T__90 - 86)) | (1L << (T__91 - 86)) | (1L << (T__92 - 86)) | (1L << (T__97 - 86)) | (1L << (T__98 - 86)) | (1L << (T__99 - 86)) | (1L << (T__100 - 86)) | (1L << (IDENT - 86)) | (1L << (NUMBER - 86)) | (1L << (STRING - 86)))) != 0)) {
				{
				{
				setState(554);
				statement();
				}
				}
				setState(559);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(560);
			match(T__16);
			setState(575);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(561);
					match(T__35);
					setState(562);
					match(T__34);
					setState(563);
					expression();
					setState(564);
					match(T__15);
					setState(568);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__33) | (1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__50) | (1L << T__51))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (T__85 - 86)) | (1L << (T__86 - 86)) | (1L << (T__90 - 86)) | (1L << (T__91 - 86)) | (1L << (T__92 - 86)) | (1L << (T__97 - 86)) | (1L << (T__98 - 86)) | (1L << (T__99 - 86)) | (1L << (T__100 - 86)) | (1L << (IDENT - 86)) | (1L << (NUMBER - 86)) | (1L << (STRING - 86)))) != 0)) {
						{
						{
						setState(565);
						statement();
						}
						}
						setState(570);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(571);
					match(T__16);
					}
					} 
				}
				setState(577);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
			}
			setState(587);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__35) {
				{
				setState(578);
				match(T__35);
				setState(579);
				match(T__15);
				setState(583);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__33) | (1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__50) | (1L << T__51))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (T__85 - 86)) | (1L << (T__86 - 86)) | (1L << (T__90 - 86)) | (1L << (T__91 - 86)) | (1L << (T__92 - 86)) | (1L << (T__97 - 86)) | (1L << (T__98 - 86)) | (1L << (T__99 - 86)) | (1L << (T__100 - 86)) | (1L << (IDENT - 86)) | (1L << (NUMBER - 86)) | (1L << (STRING - 86)))) != 0)) {
					{
					{
					setState(580);
					statement();
					}
					}
					setState(585);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(586);
				match(T__16);
				}
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

	public static class UnlessStmtContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public UnlessStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unlessStmt; }
	}

	public final UnlessStmtContext unlessStmt() throws RecognitionException {
		UnlessStmtContext _localctx = new UnlessStmtContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_unlessStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(589);
			match(T__36);
			setState(590);
			expression();
			setState(591);
			match(T__15);
			setState(595);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__33) | (1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__50) | (1L << T__51))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (T__85 - 86)) | (1L << (T__86 - 86)) | (1L << (T__90 - 86)) | (1L << (T__91 - 86)) | (1L << (T__92 - 86)) | (1L << (T__97 - 86)) | (1L << (T__98 - 86)) | (1L << (T__99 - 86)) | (1L << (T__100 - 86)) | (1L << (IDENT - 86)) | (1L << (NUMBER - 86)) | (1L << (STRING - 86)))) != 0)) {
				{
				{
				setState(592);
				statement();
				}
				}
				setState(597);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(598);
			match(T__16);
			setState(608);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__35) {
				{
				setState(599);
				match(T__35);
				setState(600);
				match(T__15);
				setState(604);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__33) | (1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__50) | (1L << T__51))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (T__85 - 86)) | (1L << (T__86 - 86)) | (1L << (T__90 - 86)) | (1L << (T__91 - 86)) | (1L << (T__92 - 86)) | (1L << (T__97 - 86)) | (1L << (T__98 - 86)) | (1L << (T__99 - 86)) | (1L << (T__100 - 86)) | (1L << (IDENT - 86)) | (1L << (NUMBER - 86)) | (1L << (STRING - 86)))) != 0)) {
					{
					{
					setState(601);
					statement();
					}
					}
					setState(606);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(607);
				match(T__16);
				}
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

	public static class GuardStmtContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public GuardStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guardStmt; }
	}

	public final GuardStmtContext guardStmt() throws RecognitionException {
		GuardStmtContext _localctx = new GuardStmtContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_guardStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(610);
			match(T__37);
			setState(611);
			expression();
			setState(612);
			match(T__35);
			setState(613);
			match(T__15);
			setState(617);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__33) | (1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__50) | (1L << T__51))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (T__85 - 86)) | (1L << (T__86 - 86)) | (1L << (T__90 - 86)) | (1L << (T__91 - 86)) | (1L << (T__92 - 86)) | (1L << (T__97 - 86)) | (1L << (T__98 - 86)) | (1L << (T__99 - 86)) | (1L << (T__100 - 86)) | (1L << (IDENT - 86)) | (1L << (NUMBER - 86)) | (1L << (STRING - 86)))) != 0)) {
				{
				{
				setState(614);
				statement();
				}
				}
				setState(619);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(620);
			match(T__16);
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

	public static class WhileStmtContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_whileStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(622);
			match(T__38);
			setState(623);
			expression();
			setState(624);
			match(T__15);
			setState(628);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__33) | (1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__50) | (1L << T__51))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (T__85 - 86)) | (1L << (T__86 - 86)) | (1L << (T__90 - 86)) | (1L << (T__91 - 86)) | (1L << (T__92 - 86)) | (1L << (T__97 - 86)) | (1L << (T__98 - 86)) | (1L << (T__99 - 86)) | (1L << (T__100 - 86)) | (1L << (IDENT - 86)) | (1L << (NUMBER - 86)) | (1L << (STRING - 86)))) != 0)) {
				{
				{
				setState(625);
				statement();
				}
				}
				setState(630);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(631);
			match(T__16);
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

	public static class UntilStmtContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public UntilStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_untilStmt; }
	}

	public final UntilStmtContext untilStmt() throws RecognitionException {
		UntilStmtContext _localctx = new UntilStmtContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_untilStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(633);
			match(T__39);
			setState(634);
			expression();
			setState(635);
			match(T__15);
			setState(639);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__33) | (1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__50) | (1L << T__51))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (T__85 - 86)) | (1L << (T__86 - 86)) | (1L << (T__90 - 86)) | (1L << (T__91 - 86)) | (1L << (T__92 - 86)) | (1L << (T__97 - 86)) | (1L << (T__98 - 86)) | (1L << (T__99 - 86)) | (1L << (T__100 - 86)) | (1L << (IDENT - 86)) | (1L << (NUMBER - 86)) | (1L << (STRING - 86)))) != 0)) {
				{
				{
				setState(636);
				statement();
				}
				}
				setState(641);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(642);
			match(T__16);
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

	public static class ForStmtContext extends ParserRuleContext {
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ForStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStmt; }
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_forStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(644);
			match(T__40);
			setState(645);
			pattern();
			setState(646);
			match(T__41);
			setState(647);
			expression();
			setState(650);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__42) {
				{
				setState(648);
				match(T__42);
				setState(649);
				expression();
				}
			}

			setState(652);
			match(T__15);
			setState(656);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__33) | (1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__50) | (1L << T__51))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (T__85 - 86)) | (1L << (T__86 - 86)) | (1L << (T__90 - 86)) | (1L << (T__91 - 86)) | (1L << (T__92 - 86)) | (1L << (T__97 - 86)) | (1L << (T__98 - 86)) | (1L << (T__99 - 86)) | (1L << (T__100 - 86)) | (1L << (IDENT - 86)) | (1L << (NUMBER - 86)) | (1L << (STRING - 86)))) != 0)) {
				{
				{
				setState(653);
				statement();
				}
				}
				setState(658);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(659);
			match(T__16);
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

	public static class LoopStmtContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public LoopStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopStmt; }
	}

	public final LoopStmtContext loopStmt() throws RecognitionException {
		LoopStmtContext _localctx = new LoopStmtContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_loopStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(661);
			match(T__43);
			setState(662);
			match(T__15);
			setState(666);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__33) | (1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__50) | (1L << T__51))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (T__85 - 86)) | (1L << (T__86 - 86)) | (1L << (T__90 - 86)) | (1L << (T__91 - 86)) | (1L << (T__92 - 86)) | (1L << (T__97 - 86)) | (1L << (T__98 - 86)) | (1L << (T__99 - 86)) | (1L << (T__100 - 86)) | (1L << (IDENT - 86)) | (1L << (NUMBER - 86)) | (1L << (STRING - 86)))) != 0)) {
				{
				{
				setState(663);
				statement();
				}
				}
				setState(668);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(669);
			match(T__16);
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

	public static class BreakStmtContext extends ParserRuleContext {
		public BreakStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStmt; }
	}

	public final BreakStmtContext breakStmt() throws RecognitionException {
		BreakStmtContext _localctx = new BreakStmtContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_breakStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(671);
			match(T__44);
			setState(672);
			match(T__9);
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

	public static class ContinueStmtContext extends ParserRuleContext {
		public ContinueStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStmt; }
	}

	public final ContinueStmtContext continueStmt() throws RecognitionException {
		ContinueStmtContext _localctx = new ContinueStmtContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_continueStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(674);
			match(T__45);
			setState(675);
			match(T__9);
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

	public static class ReturnStmtContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_returnStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(677);
			match(T__46);
			setState(679);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__15) | (1L << T__51))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (T__85 - 86)) | (1L << (T__86 - 86)) | (1L << (T__90 - 86)) | (1L << (T__91 - 86)) | (1L << (T__92 - 86)) | (1L << (T__97 - 86)) | (1L << (T__98 - 86)) | (1L << (T__99 - 86)) | (1L << (T__100 - 86)) | (1L << (IDENT - 86)) | (1L << (NUMBER - 86)) | (1L << (STRING - 86)))) != 0)) {
				{
				setState(678);
				expression();
				}
			}

			setState(681);
			match(T__9);
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

	public static class TryStmtContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<ExceptionPatternContext> exceptionPattern() {
			return getRuleContexts(ExceptionPatternContext.class);
		}
		public ExceptionPatternContext exceptionPattern(int i) {
			return getRuleContext(ExceptionPatternContext.class,i);
		}
		public TryStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryStmt; }
	}

	public final TryStmtContext tryStmt() throws RecognitionException {
		TryStmtContext _localctx = new TryStmtContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_tryStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(683);
			match(T__47);
			setState(684);
			match(T__15);
			setState(688);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__33) | (1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__50) | (1L << T__51))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (T__85 - 86)) | (1L << (T__86 - 86)) | (1L << (T__90 - 86)) | (1L << (T__91 - 86)) | (1L << (T__92 - 86)) | (1L << (T__97 - 86)) | (1L << (T__98 - 86)) | (1L << (T__99 - 86)) | (1L << (T__100 - 86)) | (1L << (IDENT - 86)) | (1L << (NUMBER - 86)) | (1L << (STRING - 86)))) != 0)) {
				{
				{
				setState(685);
				statement();
				}
				}
				setState(690);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(691);
			match(T__16);
			setState(705);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__48) {
				{
				{
				setState(692);
				match(T__48);
				setState(693);
				exceptionPattern();
				setState(694);
				match(T__15);
				setState(698);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__33) | (1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__50) | (1L << T__51))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (T__85 - 86)) | (1L << (T__86 - 86)) | (1L << (T__90 - 86)) | (1L << (T__91 - 86)) | (1L << (T__92 - 86)) | (1L << (T__97 - 86)) | (1L << (T__98 - 86)) | (1L << (T__99 - 86)) | (1L << (T__100 - 86)) | (1L << (IDENT - 86)) | (1L << (NUMBER - 86)) | (1L << (STRING - 86)))) != 0)) {
					{
					{
					setState(695);
					statement();
					}
					}
					setState(700);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(701);
				match(T__16);
				}
				}
				setState(707);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(717);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__49) {
				{
				setState(708);
				match(T__49);
				setState(709);
				match(T__15);
				setState(713);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__33) | (1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__50) | (1L << T__51))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (T__85 - 86)) | (1L << (T__86 - 86)) | (1L << (T__90 - 86)) | (1L << (T__91 - 86)) | (1L << (T__92 - 86)) | (1L << (T__97 - 86)) | (1L << (T__98 - 86)) | (1L << (T__99 - 86)) | (1L << (T__100 - 86)) | (1L << (IDENT - 86)) | (1L << (NUMBER - 86)) | (1L << (STRING - 86)))) != 0)) {
					{
					{
					setState(710);
					statement();
					}
					}
					setState(715);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(716);
				match(T__16);
				}
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

	public static class ExceptionPatternContext extends ParserRuleContext {
		public TypeAnnotationContext typeAnnotation() {
			return getRuleContext(TypeAnnotationContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(auraParser.IDENT, 0); }
		public ExceptionPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exceptionPattern; }
	}

	public final ExceptionPatternContext exceptionPattern() throws RecognitionException {
		ExceptionPatternContext _localctx = new ExceptionPatternContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_exceptionPattern);
		int _la;
		try {
			setState(725);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(719);
				typeAnnotation();
				setState(722);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(720);
					match(T__1);
					setState(721);
					match(IDENT);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
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

	public static class WithStmtContext extends ParserRuleContext {
		public List<WithItemContext> withItem() {
			return getRuleContexts(WithItemContext.class);
		}
		public WithItemContext withItem(int i) {
			return getRuleContext(WithItemContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public WithStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_withStmt; }
	}

	public final WithStmtContext withStmt() throws RecognitionException {
		WithStmtContext _localctx = new WithStmtContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_withStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(727);
			match(T__50);
			setState(728);
			withItem();
			setState(733);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(729);
				match(T__4);
				setState(730);
				withItem();
				}
				}
				setState(735);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(736);
			match(T__15);
			setState(740);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__33) | (1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__50) | (1L << T__51))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (T__85 - 86)) | (1L << (T__86 - 86)) | (1L << (T__90 - 86)) | (1L << (T__91 - 86)) | (1L << (T__92 - 86)) | (1L << (T__97 - 86)) | (1L << (T__98 - 86)) | (1L << (T__99 - 86)) | (1L << (T__100 - 86)) | (1L << (IDENT - 86)) | (1L << (NUMBER - 86)) | (1L << (STRING - 86)))) != 0)) {
				{
				{
				setState(737);
				statement();
				}
				}
				setState(742);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(743);
			match(T__16);
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

	public static class WithItemContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(auraParser.IDENT, 0); }
		public WithItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_withItem; }
	}

	public final WithItemContext withItem() throws RecognitionException {
		WithItemContext _localctx = new WithItemContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_withItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(745);
			expression();
			setState(748);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(746);
				match(T__1);
				setState(747);
				match(IDENT);
				}
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

	public static class MatchStmtContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<MatchCaseContext> matchCase() {
			return getRuleContexts(MatchCaseContext.class);
		}
		public MatchCaseContext matchCase(int i) {
			return getRuleContext(MatchCaseContext.class,i);
		}
		public MatchStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchStmt; }
	}

	public final MatchStmtContext matchStmt() throws RecognitionException {
		MatchStmtContext _localctx = new MatchStmtContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_matchStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(750);
			match(T__51);
			setState(751);
			expression();
			setState(752);
			match(T__15);
			setState(754); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(753);
				matchCase();
				}
				}
				setState(756); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__52 );
			setState(758);
			match(T__16);
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

	public static class MatchCaseContext extends ParserRuleContext {
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MatchCaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchCase; }
	}

	public final MatchCaseContext matchCase() throws RecognitionException {
		MatchCaseContext _localctx = new MatchCaseContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_matchCase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(760);
			match(T__52);
			setState(761);
			pattern();
			setState(764);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__34) {
				{
				setState(762);
				match(T__34);
				setState(763);
				expression();
				}
			}

			setState(766);
			match(T__15);
			setState(770);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__33) | (1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__50) | (1L << T__51))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (T__85 - 86)) | (1L << (T__86 - 86)) | (1L << (T__90 - 86)) | (1L << (T__91 - 86)) | (1L << (T__92 - 86)) | (1L << (T__97 - 86)) | (1L << (T__98 - 86)) | (1L << (T__99 - 86)) | (1L << (T__100 - 86)) | (1L << (IDENT - 86)) | (1L << (NUMBER - 86)) | (1L << (STRING - 86)))) != 0)) {
				{
				{
				setState(767);
				statement();
				}
				}
				setState(772);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(773);
			match(T__16);
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

	public static class BlockStmtContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStmt; }
	}

	public final BlockStmtContext blockStmt() throws RecognitionException {
		BlockStmtContext _localctx = new BlockStmtContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_blockStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(775);
			match(T__15);
			setState(779);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__33) | (1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__50) | (1L << T__51))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (T__85 - 86)) | (1L << (T__86 - 86)) | (1L << (T__90 - 86)) | (1L << (T__91 - 86)) | (1L << (T__92 - 86)) | (1L << (T__97 - 86)) | (1L << (T__98 - 86)) | (1L << (T__99 - 86)) | (1L << (T__100 - 86)) | (1L << (IDENT - 86)) | (1L << (NUMBER - 86)) | (1L << (STRING - 86)))) != 0)) {
				{
				{
				setState(776);
				statement();
				}
				}
				setState(781);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(782);
			match(T__16);
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

	public static class ExpressionContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(784);
			assignment();
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

	public static class AssignmentContext extends ParserRuleContext {
		public List<PipeContext> pipe() {
			return getRuleContexts(PipeContext.class);
		}
		public PipeContext pipe(int i) {
			return getRuleContext(PipeContext.class,i);
		}
		public List<AssignOpContext> assignOp() {
			return getRuleContexts(AssignOpContext.class);
		}
		public AssignOpContext assignOp(int i) {
			return getRuleContext(AssignOpContext.class,i);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_assignment);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(786);
			pipe();
			setState(792);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,87,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(787);
					assignOp();
					setState(788);
					pipe();
					}
					} 
				}
				setState(794);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,87,_ctx);
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

	public static class AssignOpContext extends ParserRuleContext {
		public AssignOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignOp; }
	}

	public final AssignOpContext assignOp() throws RecognitionException {
		AssignOpContext _localctx = new AssignOpContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_assignOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(795);
			_la = _input.LA(1);
			if ( !(((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & ((1L << (T__8 - 9)) | (1L << (T__53 - 9)) | (1L << (T__54 - 9)) | (1L << (T__55 - 9)) | (1L << (T__56 - 9)) | (1L << (T__57 - 9)) | (1L << (T__58 - 9)) | (1L << (T__59 - 9)) | (1L << (T__60 - 9)) | (1L << (T__61 - 9)) | (1L << (T__62 - 9)) | (1L << (T__63 - 9)) | (1L << (T__64 - 9)) | (1L << (T__65 - 9)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class PipeContext extends ParserRuleContext {
		public List<TernaryContext> ternary() {
			return getRuleContexts(TernaryContext.class);
		}
		public TernaryContext ternary(int i) {
			return getRuleContext(TernaryContext.class,i);
		}
		public PipeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pipe; }
	}

	public final PipeContext pipe() throws RecognitionException {
		PipeContext _localctx = new PipeContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_pipe);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(797);
			ternary();
			setState(802);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,88,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(798);
					match(T__66);
					setState(799);
					ternary();
					}
					} 
				}
				setState(804);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,88,_ctx);
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

	public static class TernaryContext extends ParserRuleContext {
		public ElvisContext elvis() {
			return getRuleContext(ElvisContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TernaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ternary; }
	}

	public final TernaryContext ternary() throws RecognitionException {
		TernaryContext _localctx = new TernaryContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_ternary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(805);
			elvis();
			setState(811);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,89,_ctx) ) {
			case 1:
				{
				setState(806);
				match(T__67);
				setState(807);
				expression();
				setState(808);
				match(T__68);
				setState(809);
				expression();
				}
				break;
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

	public static class ElvisContext extends ParserRuleContext {
		public List<CoalesceContext> coalesce() {
			return getRuleContexts(CoalesceContext.class);
		}
		public CoalesceContext coalesce(int i) {
			return getRuleContext(CoalesceContext.class,i);
		}
		public ElvisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elvis; }
	}

	public final ElvisContext elvis() throws RecognitionException {
		ElvisContext _localctx = new ElvisContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_elvis);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(813);
			coalesce();
			setState(818);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,90,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(814);
					match(T__69);
					setState(815);
					coalesce();
					}
					} 
				}
				setState(820);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,90,_ctx);
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

	public static class CoalesceContext extends ParserRuleContext {
		public List<LogicalOrContext> logicalOr() {
			return getRuleContexts(LogicalOrContext.class);
		}
		public LogicalOrContext logicalOr(int i) {
			return getRuleContext(LogicalOrContext.class,i);
		}
		public CoalesceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coalesce; }
	}

	public final CoalesceContext coalesce() throws RecognitionException {
		CoalesceContext _localctx = new CoalesceContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_coalesce);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(821);
			logicalOr();
			setState(826);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,91,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(822);
					match(T__70);
					setState(823);
					logicalOr();
					}
					} 
				}
				setState(828);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,91,_ctx);
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

	public static class LogicalOrContext extends ParserRuleContext {
		public List<LogicalAndContext> logicalAnd() {
			return getRuleContexts(LogicalAndContext.class);
		}
		public LogicalAndContext logicalAnd(int i) {
			return getRuleContext(LogicalAndContext.class,i);
		}
		public LogicalOrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOr; }
	}

	public final LogicalOrContext logicalOr() throws RecognitionException {
		LogicalOrContext _localctx = new LogicalOrContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_logicalOr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(829);
			logicalAnd();
			setState(834);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,92,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(830);
					match(T__71);
					setState(831);
					logicalAnd();
					}
					} 
				}
				setState(836);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,92,_ctx);
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

	public static class LogicalAndContext extends ParserRuleContext {
		public List<BitwiseOrContext> bitwiseOr() {
			return getRuleContexts(BitwiseOrContext.class);
		}
		public BitwiseOrContext bitwiseOr(int i) {
			return getRuleContext(BitwiseOrContext.class,i);
		}
		public LogicalAndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalAnd; }
	}

	public final LogicalAndContext logicalAnd() throws RecognitionException {
		LogicalAndContext _localctx = new LogicalAndContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_logicalAnd);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(837);
			bitwiseOr();
			setState(842);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,93,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(838);
					match(T__72);
					setState(839);
					bitwiseOr();
					}
					} 
				}
				setState(844);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,93,_ctx);
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

	public static class BitwiseOrContext extends ParserRuleContext {
		public List<BitwiseXorContext> bitwiseXor() {
			return getRuleContexts(BitwiseXorContext.class);
		}
		public BitwiseXorContext bitwiseXor(int i) {
			return getRuleContext(BitwiseXorContext.class,i);
		}
		public BitwiseOrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitwiseOr; }
	}

	public final BitwiseOrContext bitwiseOr() throws RecognitionException {
		BitwiseOrContext _localctx = new BitwiseOrContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_bitwiseOr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(845);
			bitwiseXor();
			setState(850);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,94,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(846);
					match(T__73);
					setState(847);
					bitwiseXor();
					}
					} 
				}
				setState(852);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,94,_ctx);
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

	public static class BitwiseXorContext extends ParserRuleContext {
		public List<BitwiseAndContext> bitwiseAnd() {
			return getRuleContexts(BitwiseAndContext.class);
		}
		public BitwiseAndContext bitwiseAnd(int i) {
			return getRuleContext(BitwiseAndContext.class,i);
		}
		public BitwiseXorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitwiseXor; }
	}

	public final BitwiseXorContext bitwiseXor() throws RecognitionException {
		BitwiseXorContext _localctx = new BitwiseXorContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_bitwiseXor);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(853);
			bitwiseAnd();
			setState(858);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,95,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(854);
					match(T__74);
					setState(855);
					bitwiseAnd();
					}
					} 
				}
				setState(860);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,95,_ctx);
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

	public static class BitwiseAndContext extends ParserRuleContext {
		public List<EqualityContext> equality() {
			return getRuleContexts(EqualityContext.class);
		}
		public EqualityContext equality(int i) {
			return getRuleContext(EqualityContext.class,i);
		}
		public BitwiseAndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitwiseAnd; }
	}

	public final BitwiseAndContext bitwiseAnd() throws RecognitionException {
		BitwiseAndContext _localctx = new BitwiseAndContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_bitwiseAnd);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(861);
			equality();
			setState(866);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,96,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(862);
					match(T__75);
					setState(863);
					equality();
					}
					} 
				}
				setState(868);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,96,_ctx);
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

	public static class EqualityContext extends ParserRuleContext {
		public List<ComparisonContext> comparison() {
			return getRuleContexts(ComparisonContext.class);
		}
		public ComparisonContext comparison(int i) {
			return getRuleContext(ComparisonContext.class,i);
		}
		public EqualityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality; }
	}

	public final EqualityContext equality() throws RecognitionException {
		EqualityContext _localctx = new EqualityContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_equality);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(869);
			comparison();
			setState(874);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,97,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(870);
					_la = _input.LA(1);
					if ( !(((((_la - 42)) & ~0x3f) == 0 && ((1L << (_la - 42)) & ((1L << (T__41 - 42)) | (1L << (T__76 - 42)) | (1L << (T__77 - 42)) | (1L << (T__78 - 42)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(871);
					comparison();
					}
					} 
				}
				setState(876);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,97,_ctx);
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

	public static class ComparisonContext extends ParserRuleContext {
		public List<RangeExprContext> rangeExpr() {
			return getRuleContexts(RangeExprContext.class);
		}
		public RangeExprContext rangeExpr(int i) {
			return getRuleContext(RangeExprContext.class,i);
		}
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_comparison);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(877);
			rangeExpr();
			setState(882);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,98,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(878);
					_la = _input.LA(1);
					if ( !(((((_la - 18)) & ~0x3f) == 0 && ((1L << (_la - 18)) & ((1L << (T__17 - 18)) | (1L << (T__18 - 18)) | (1L << (T__79 - 18)) | (1L << (T__80 - 18)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(879);
					rangeExpr();
					}
					} 
				}
				setState(884);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,98,_ctx);
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

	public static class RangeExprContext extends ParserRuleContext {
		public RangeExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rangeExpr; }
	 
		public RangeExprContext() { }
		public void copyFrom(RangeExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RangeBaseContext extends RangeExprContext {
		public AdditiveContext additive() {
			return getRuleContext(AdditiveContext.class,0);
		}
		public RangeBaseContext(RangeExprContext ctx) { copyFrom(ctx); }
	}
	public static class InfiniteRangeContext extends RangeExprContext {
		public List<AdditiveContext> additive() {
			return getRuleContexts(AdditiveContext.class);
		}
		public AdditiveContext additive(int i) {
			return getRuleContext(AdditiveContext.class,i);
		}
		public InfiniteRangeContext(RangeExprContext ctx) { copyFrom(ctx); }
	}
	public static class ExclusiveRangeContext extends RangeExprContext {
		public List<AdditiveContext> additive() {
			return getRuleContexts(AdditiveContext.class);
		}
		public AdditiveContext additive(int i) {
			return getRuleContext(AdditiveContext.class,i);
		}
		public ExclusiveRangeContext(RangeExprContext ctx) { copyFrom(ctx); }
	}
	public static class InclusiveRangeContext extends RangeExprContext {
		public List<AdditiveContext> additive() {
			return getRuleContexts(AdditiveContext.class);
		}
		public AdditiveContext additive(int i) {
			return getRuleContext(AdditiveContext.class,i);
		}
		public InclusiveRangeContext(RangeExprContext ctx) { copyFrom(ctx); }
	}

	public final RangeExprContext rangeExpr() throws RecognitionException {
		RangeExprContext _localctx = new RangeExprContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_rangeExpr);
		try {
			setState(903);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
			case 1:
				_localctx = new InclusiveRangeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(885);
				additive();
				setState(886);
				match(T__81);
				setState(887);
				additive();
				setState(890);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
				case 1:
					{
					setState(888);
					match(T__42);
					setState(889);
					additive();
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new ExclusiveRangeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(892);
				additive();
				setState(893);
				match(T__82);
				setState(894);
				additive();
				}
				break;
			case 3:
				_localctx = new InfiniteRangeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(896);
				additive();
				setState(897);
				match(T__81);
				setState(900);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
				case 1:
					{
					setState(898);
					match(T__42);
					setState(899);
					additive();
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new RangeBaseContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(902);
				additive();
				}
				break;
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

	public static class ShiftContext extends ParserRuleContext {
		public List<AdditiveContext> additive() {
			return getRuleContexts(AdditiveContext.class);
		}
		public AdditiveContext additive(int i) {
			return getRuleContext(AdditiveContext.class,i);
		}
		public ShiftContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shift; }
	}

	public final ShiftContext shift() throws RecognitionException {
		ShiftContext _localctx = new ShiftContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_shift);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(905);
			additive();
			setState(910);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__83 || _la==T__84) {
				{
				{
				setState(906);
				_la = _input.LA(1);
				if ( !(_la==T__83 || _la==T__84) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(907);
				additive();
				}
				}
				setState(912);
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

	public static class AdditiveContext extends ParserRuleContext {
		public List<MultiplicativeContext> multiplicative() {
			return getRuleContexts(MultiplicativeContext.class);
		}
		public MultiplicativeContext multiplicative(int i) {
			return getRuleContext(MultiplicativeContext.class,i);
		}
		public AdditiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additive; }
	}

	public final AdditiveContext additive() throws RecognitionException {
		AdditiveContext _localctx = new AdditiveContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_additive);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(913);
			multiplicative();
			setState(918);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,103,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(914);
					_la = _input.LA(1);
					if ( !(_la==T__85 || _la==T__86) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(915);
					multiplicative();
					}
					} 
				}
				setState(920);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,103,_ctx);
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

	public static class MultiplicativeContext extends ParserRuleContext {
		public List<CastExprContext> castExpr() {
			return getRuleContexts(CastExprContext.class);
		}
		public CastExprContext castExpr(int i) {
			return getRuleContext(CastExprContext.class,i);
		}
		public MultiplicativeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicative; }
	}

	public final MultiplicativeContext multiplicative() throws RecognitionException {
		MultiplicativeContext _localctx = new MultiplicativeContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_multiplicative);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(921);
			castExpr();
			setState(926);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,104,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(922);
					_la = _input.LA(1);
					if ( !(_la==T__5 || ((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & ((1L << (T__87 - 88)) | (1L << (T__88 - 88)) | (1L << (T__89 - 88)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(923);
					castExpr();
					}
					} 
				}
				setState(928);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,104,_ctx);
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

	public static class CastExprContext extends ParserRuleContext {
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public List<TypeAnnotationContext> typeAnnotation() {
			return getRuleContexts(TypeAnnotationContext.class);
		}
		public TypeAnnotationContext typeAnnotation(int i) {
			return getRuleContext(TypeAnnotationContext.class,i);
		}
		public CastExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castExpr; }
	}

	public final CastExprContext castExpr() throws RecognitionException {
		CastExprContext _localctx = new CastExprContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_castExpr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(929);
			unary();
			setState(934);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,105,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(930);
					match(T__1);
					setState(931);
					typeAnnotation();
					}
					} 
				}
				setState(936);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,105,_ctx);
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

	public static class UnaryContext extends ParserRuleContext {
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public ExponentiationContext exponentiation() {
			return getRuleContext(ExponentiationContext.class,0);
		}
		public UnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary; }
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_unary);
		int _la;
		try {
			setState(940);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__85:
			case T__86:
			case T__90:
			case T__91:
				enterOuterAlt(_localctx, 1);
				{
				setState(937);
				_la = _input.LA(1);
				if ( !(((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (T__85 - 86)) | (1L << (T__86 - 86)) | (1L << (T__90 - 86)) | (1L << (T__91 - 86)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(938);
				unary();
				}
				break;
			case T__13:
			case T__15:
			case T__51:
			case T__92:
			case T__97:
			case T__98:
			case T__99:
			case T__100:
			case IDENT:
			case NUMBER:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(939);
				exponentiation();
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

	public static class ExponentiationContext extends ParserRuleContext {
		public List<PostfixContext> postfix() {
			return getRuleContexts(PostfixContext.class);
		}
		public PostfixContext postfix(int i) {
			return getRuleContext(PostfixContext.class,i);
		}
		public ExponentiationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exponentiation; }
	}

	public final ExponentiationContext exponentiation() throws RecognitionException {
		ExponentiationContext _localctx = new ExponentiationContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_exponentiation);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(942);
			postfix();
			setState(947);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,107,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(943);
					match(T__19);
					setState(944);
					postfix();
					}
					} 
				}
				setState(949);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,107,_ctx);
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

	public static class PostfixContext extends ParserRuleContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public List<CallContext> call() {
			return getRuleContexts(CallContext.class);
		}
		public CallContext call(int i) {
			return getRuleContext(CallContext.class,i);
		}
		public List<IndexContext> index() {
			return getRuleContexts(IndexContext.class);
		}
		public IndexContext index(int i) {
			return getRuleContext(IndexContext.class,i);
		}
		public List<MemberContext> member() {
			return getRuleContexts(MemberContext.class);
		}
		public MemberContext member(int i) {
			return getRuleContext(MemberContext.class,i);
		}
		public List<SafeNavContext> safeNav() {
			return getRuleContexts(SafeNavContext.class);
		}
		public SafeNavContext safeNav(int i) {
			return getRuleContext(SafeNavContext.class,i);
		}
		public List<SpreadOpContext> spreadOp() {
			return getRuleContexts(SpreadOpContext.class);
		}
		public SpreadOpContext spreadOp(int i) {
			return getRuleContext(SpreadOpContext.class,i);
		}
		public PostfixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix; }
	}

	public final PostfixContext postfix() throws RecognitionException {
		PostfixContext _localctx = new PostfixContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_postfix);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(950);
			primary();
			setState(958);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,109,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(956);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__13:
						{
						setState(951);
						call();
						}
						break;
					case T__92:
						{
						setState(952);
						index();
						}
						break;
					case T__3:
						{
						setState(953);
						member();
						}
						break;
					case T__94:
					case T__95:
						{
						setState(954);
						safeNav();
						}
						break;
					case T__5:
					case T__19:
					case T__96:
						{
						setState(955);
						spreadOp();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(960);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,109,_ctx);
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

	public static class CallContext extends ParserRuleContext {
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(961);
			match(T__13);
			setState(963);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__15) | (1L << T__51))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (T__85 - 86)) | (1L << (T__86 - 86)) | (1L << (T__90 - 86)) | (1L << (T__91 - 86)) | (1L << (T__92 - 86)) | (1L << (T__97 - 86)) | (1L << (T__98 - 86)) | (1L << (T__99 - 86)) | (1L << (T__100 - 86)) | (1L << (IDENT - 86)) | (1L << (NUMBER - 86)) | (1L << (STRING - 86)))) != 0)) {
				{
				setState(962);
				argumentList();
				}
			}

			setState(965);
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

	public static class IndexContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index; }
	}

	public final IndexContext index() throws RecognitionException {
		IndexContext _localctx = new IndexContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_index);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(967);
			match(T__92);
			setState(968);
			expression();
			setState(969);
			match(T__93);
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

	public static class MemberContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(auraParser.IDENT, 0); }
		public MemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_member; }
	}

	public final MemberContext member() throws RecognitionException {
		MemberContext _localctx = new MemberContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_member);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(971);
			match(T__3);
			setState(972);
			match(IDENT);
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

	public static class SafeNavContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(auraParser.IDENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SafeNavContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_safeNav; }
	}

	public final SafeNavContext safeNav() throws RecognitionException {
		SafeNavContext _localctx = new SafeNavContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_safeNav);
		try {
			setState(980);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__94:
				enterOuterAlt(_localctx, 1);
				{
				setState(974);
				match(T__94);
				setState(975);
				match(IDENT);
				}
				break;
			case T__95:
				enterOuterAlt(_localctx, 2);
				{
				setState(976);
				match(T__95);
				setState(977);
				expression();
				setState(978);
				match(T__93);
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

	public static class SpreadOpContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(auraParser.IDENT, 0); }
		public SpreadOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_spreadOp; }
	}

	public final SpreadOpContext spreadOp() throws RecognitionException {
		SpreadOpContext _localctx = new SpreadOpContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_spreadOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(982);
			_la = _input.LA(1);
			if ( !(_la==T__5 || _la==T__19 || _la==T__96) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(983);
			match(IDENT);
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

	public static class PrimaryContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(auraParser.IDENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ListLiteralContext listLiteral() {
			return getRuleContext(ListLiteralContext.class,0);
		}
		public DictLiteralContext dictLiteral() {
			return getRuleContext(DictLiteralContext.class,0);
		}
		public SetLiteralContext setLiteral() {
			return getRuleContext(SetLiteralContext.class,0);
		}
		public TupleLiteralContext tupleLiteral() {
			return getRuleContext(TupleLiteralContext.class,0);
		}
		public LambdaExprContext lambdaExpr() {
			return getRuleContext(LambdaExprContext.class,0);
		}
		public ComprehensionContext comprehension() {
			return getRuleContext(ComprehensionContext.class,0);
		}
		public MatchExprContext matchExpr() {
			return getRuleContext(MatchExprContext.class,0);
		}
		public BlockExprContext blockExpr() {
			return getRuleContext(BlockExprContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_primary);
		try {
			setState(999);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(985);
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(986);
				match(IDENT);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(987);
				match(T__13);
				setState(988);
				expression();
				setState(989);
				match(T__14);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(991);
				listLiteral();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(992);
				dictLiteral();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(993);
				setLiteral();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(994);
				tupleLiteral();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(995);
				lambdaExpr();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(996);
				comprehension();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(997);
				matchExpr();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(998);
				blockExpr();
				}
				break;
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

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(auraParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(auraParser.STRING, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1001);
			_la = _input.LA(1);
			if ( !(((((_la - 98)) & ~0x3f) == 0 && ((1L << (_la - 98)) & ((1L << (T__97 - 98)) | (1L << (T__98 - 98)) | (1L << (T__99 - 98)) | (1L << (T__100 - 98)) | (1L << (NUMBER - 98)) | (1L << (STRING - 98)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class ArgumentListContext extends ParserRuleContext {
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public ArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentList; }
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1003);
			argument();
			setState(1008);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(1004);
				match(T__4);
				setState(1005);
				argument();
				}
				}
				setState(1010);
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

	public static class ArgumentContext extends ParserRuleContext {
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
	 
		public ArgumentContext() { }
		public void copyFrom(ArgumentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PositionalArgContext extends ArgumentContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PositionalArgContext(ArgumentContext ctx) { copyFrom(ctx); }
	}
	public static class KeywordArgContext extends ArgumentContext {
		public TerminalNode IDENT() { return getToken(auraParser.IDENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public KeywordArgContext(ArgumentContext ctx) { copyFrom(ctx); }
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_argument);
		int _la;
		try {
			setState(1015);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
			case 1:
				_localctx = new PositionalArgContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1011);
				expression();
				}
				break;
			case 2:
				_localctx = new KeywordArgContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1012);
				match(IDENT);
				setState(1013);
				_la = _input.LA(1);
				if ( !(_la==T__8 || _la==T__68) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1014);
				expression();
				}
				break;
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

	public static class ListLiteralContext extends ParserRuleContext {
		public ListLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listLiteral; }
	 
		public ListLiteralContext() { }
		public void copyFrom(ListLiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EmptyListContext extends ListLiteralContext {
		public EmptyListContext(ListLiteralContext ctx) { copyFrom(ctx); }
	}
	public static class ListComprehensionContext extends ListLiteralContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<ComprehensionClauseContext> comprehensionClause() {
			return getRuleContexts(ComprehensionClauseContext.class);
		}
		public ComprehensionClauseContext comprehensionClause(int i) {
			return getRuleContext(ComprehensionClauseContext.class,i);
		}
		public ListComprehensionContext(ListLiteralContext ctx) { copyFrom(ctx); }
	}
	public static class NonEmptyListContext extends ListLiteralContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public NonEmptyListContext(ListLiteralContext ctx) { copyFrom(ctx); }
	}

	public final ListLiteralContext listLiteral() throws RecognitionException {
		ListLiteralContext _localctx = new ListLiteralContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_listLiteral);
		int _la;
		try {
			setState(1040);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,117,_ctx) ) {
			case 1:
				_localctx = new EmptyListContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1017);
				match(T__92);
				setState(1018);
				match(T__93);
				}
				break;
			case 2:
				_localctx = new NonEmptyListContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1019);
				match(T__92);
				setState(1020);
				expression();
				setState(1025);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(1021);
					match(T__4);
					setState(1022);
					expression();
					}
					}
					setState(1027);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1028);
				match(T__93);
				}
				break;
			case 3:
				_localctx = new ListComprehensionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1030);
				match(T__92);
				setState(1031);
				expression();
				setState(1032);
				match(T__40);
				setState(1034); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1033);
					comprehensionClause();
					}
					}
					setState(1036); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__40 );
				setState(1038);
				match(T__93);
				}
				break;
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

	public static class DictLiteralContext extends ParserRuleContext {
		public DictLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dictLiteral; }
	 
		public DictLiteralContext() { }
		public void copyFrom(DictLiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EmptyDictContext extends DictLiteralContext {
		public EmptyDictContext(DictLiteralContext ctx) { copyFrom(ctx); }
	}
	public static class DictCompContext extends DictLiteralContext {
		public KvPairContext kvPair() {
			return getRuleContext(KvPairContext.class,0);
		}
		public List<ComprehensionClauseContext> comprehensionClause() {
			return getRuleContexts(ComprehensionClauseContext.class);
		}
		public ComprehensionClauseContext comprehensionClause(int i) {
			return getRuleContext(ComprehensionClauseContext.class,i);
		}
		public DictCompContext(DictLiteralContext ctx) { copyFrom(ctx); }
	}
	public static class NonEmptyDictContext extends DictLiteralContext {
		public List<KvPairContext> kvPair() {
			return getRuleContexts(KvPairContext.class);
		}
		public KvPairContext kvPair(int i) {
			return getRuleContext(KvPairContext.class,i);
		}
		public NonEmptyDictContext(DictLiteralContext ctx) { copyFrom(ctx); }
	}

	public final DictLiteralContext dictLiteral() throws RecognitionException {
		DictLiteralContext _localctx = new DictLiteralContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_dictLiteral);
		int _la;
		try {
			setState(1065);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,120,_ctx) ) {
			case 1:
				_localctx = new EmptyDictContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1042);
				match(T__15);
				setState(1043);
				match(T__16);
				}
				break;
			case 2:
				_localctx = new NonEmptyDictContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1044);
				match(T__15);
				setState(1045);
				kvPair();
				setState(1050);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(1046);
					match(T__4);
					setState(1047);
					kvPair();
					}
					}
					setState(1052);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1053);
				match(T__16);
				}
				break;
			case 3:
				_localctx = new DictCompContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1055);
				match(T__15);
				setState(1056);
				kvPair();
				setState(1057);
				match(T__40);
				setState(1059); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1058);
					comprehensionClause();
					}
					}
					setState(1061); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__40 );
				setState(1063);
				match(T__16);
				}
				break;
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

	public static class KvPairContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public KvPairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kvPair; }
	}

	public final KvPairContext kvPair() throws RecognitionException {
		KvPairContext _localctx = new KvPairContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_kvPair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1067);
			expression();
			setState(1068);
			match(T__68);
			setState(1069);
			expression();
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

	public static class SetLiteralContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ComprehensionClauseContext> comprehensionClause() {
			return getRuleContexts(ComprehensionClauseContext.class);
		}
		public ComprehensionClauseContext comprehensionClause(int i) {
			return getRuleContext(ComprehensionClauseContext.class,i);
		}
		public SetLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setLiteral; }
	}

	public final SetLiteralContext setLiteral() throws RecognitionException {
		SetLiteralContext _localctx = new SetLiteralContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_setLiteral);
		int _la;
		try {
			setState(1091);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,123,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1071);
				match(T__15);
				setState(1072);
				expression();
				setState(1075); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1073);
					match(T__4);
					setState(1074);
					expression();
					}
					}
					setState(1077); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__4 );
				setState(1079);
				match(T__16);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1081);
				match(T__15);
				setState(1082);
				expression();
				setState(1083);
				match(T__40);
				setState(1085); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1084);
					comprehensionClause();
					}
					}
					setState(1087); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__40 );
				setState(1089);
				match(T__16);
				}
				break;
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

	public static class TupleLiteralContext extends ParserRuleContext {
		public TupleLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tupleLiteral; }
	 
		public TupleLiteralContext() { }
		public void copyFrom(TupleLiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NonEmptyTupleContext extends TupleLiteralContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public NonEmptyTupleContext(TupleLiteralContext ctx) { copyFrom(ctx); }
	}
	public static class EmptyTupleContext extends TupleLiteralContext {
		public EmptyTupleContext(TupleLiteralContext ctx) { copyFrom(ctx); }
	}

	public final TupleLiteralContext tupleLiteral() throws RecognitionException {
		TupleLiteralContext _localctx = new TupleLiteralContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_tupleLiteral);
		int _la;
		try {
			setState(1106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,125,_ctx) ) {
			case 1:
				_localctx = new EmptyTupleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1093);
				match(T__13);
				setState(1094);
				match(T__14);
				}
				break;
			case 2:
				_localctx = new NonEmptyTupleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1095);
				match(T__13);
				setState(1096);
				expression();
				setState(1101);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(1097);
					match(T__4);
					setState(1098);
					expression();
					}
					}
					setState(1103);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1104);
				match(T__14);
				}
				break;
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

	public static class LambdaExprContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public LambdaExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaExpr; }
	}

	public final LambdaExprContext lambdaExpr() throws RecognitionException {
		LambdaExprContext _localctx = new LambdaExprContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_lambdaExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1108);
			match(T__13);
			setState(1110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5 || _la==T__19 || _la==IDENT) {
				{
				setState(1109);
				parameterList();
				}
			}

			setState(1112);
			match(T__14);
			setState(1113);
			match(T__101);
			setState(1123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,128,_ctx) ) {
			case 1:
				{
				setState(1114);
				expression();
				}
				break;
			case 2:
				{
				setState(1115);
				match(T__15);
				setState(1119);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__33) | (1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__50) | (1L << T__51))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (T__85 - 86)) | (1L << (T__86 - 86)) | (1L << (T__90 - 86)) | (1L << (T__91 - 86)) | (1L << (T__92 - 86)) | (1L << (T__97 - 86)) | (1L << (T__98 - 86)) | (1L << (T__99 - 86)) | (1L << (T__100 - 86)) | (1L << (IDENT - 86)) | (1L << (NUMBER - 86)) | (1L << (STRING - 86)))) != 0)) {
					{
					{
					setState(1116);
					statement();
					}
					}
					setState(1121);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1122);
				match(T__16);
				}
				break;
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

	public static class ComprehensionContext extends ParserRuleContext {
		public ComprehensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comprehension; }
	 
		public ComprehensionContext() { }
		public void copyFrom(ComprehensionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SetCompContext extends ComprehensionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<ComprehensionClauseContext> comprehensionClause() {
			return getRuleContexts(ComprehensionClauseContext.class);
		}
		public ComprehensionClauseContext comprehensionClause(int i) {
			return getRuleContext(ComprehensionClauseContext.class,i);
		}
		public SetCompContext(ComprehensionContext ctx) { copyFrom(ctx); }
	}
	public static class ListCompContext extends ComprehensionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<ComprehensionClauseContext> comprehensionClause() {
			return getRuleContexts(ComprehensionClauseContext.class);
		}
		public ComprehensionClauseContext comprehensionClause(int i) {
			return getRuleContext(ComprehensionClauseContext.class,i);
		}
		public ListCompContext(ComprehensionContext ctx) { copyFrom(ctx); }
	}

	public final ComprehensionContext comprehension() throws RecognitionException {
		ComprehensionContext _localctx = new ComprehensionContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_comprehension);
		int _la;
		try {
			setState(1145);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__92:
				_localctx = new ListCompContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1125);
				match(T__92);
				setState(1126);
				expression();
				setState(1127);
				match(T__40);
				setState(1129); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1128);
					comprehensionClause();
					}
					}
					setState(1131); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__40 );
				setState(1133);
				match(T__93);
				}
				break;
			case T__15:
				_localctx = new SetCompContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1135);
				match(T__15);
				setState(1136);
				expression();
				setState(1137);
				match(T__40);
				setState(1139); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1138);
					comprehensionClause();
					}
					}
					setState(1141); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__40 );
				setState(1143);
				match(T__16);
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

	public static class ComprehensionClauseContext extends ParserRuleContext {
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ComprehensionClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comprehensionClause; }
	}

	public final ComprehensionClauseContext comprehensionClause() throws RecognitionException {
		ComprehensionClauseContext _localctx = new ComprehensionClauseContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_comprehensionClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1147);
			match(T__40);
			setState(1148);
			pattern();
			setState(1149);
			match(T__41);
			setState(1150);
			expression();
			setState(1155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__34) {
				{
				{
				setState(1151);
				match(T__34);
				setState(1152);
				expression();
				}
				}
				setState(1157);
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

	public static class MatchExprContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<MatchCaseContext> matchCase() {
			return getRuleContexts(MatchCaseContext.class);
		}
		public MatchCaseContext matchCase(int i) {
			return getRuleContext(MatchCaseContext.class,i);
		}
		public MatchExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchExpr; }
	}

	public final MatchExprContext matchExpr() throws RecognitionException {
		MatchExprContext _localctx = new MatchExprContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_matchExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1158);
			match(T__51);
			setState(1159);
			expression();
			setState(1160);
			match(T__15);
			setState(1162); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1161);
				matchCase();
				}
				}
				setState(1164); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__52 );
			setState(1166);
			match(T__16);
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

	public static class BlockExprContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockExpr; }
	}

	public final BlockExprContext blockExpr() throws RecognitionException {
		BlockExprContext _localctx = new BlockExprContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_blockExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1168);
			match(T__15);
			setState(1172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__33) | (1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__50) | (1L << T__51))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (T__85 - 86)) | (1L << (T__86 - 86)) | (1L << (T__90 - 86)) | (1L << (T__91 - 86)) | (1L << (T__92 - 86)) | (1L << (T__97 - 86)) | (1L << (T__98 - 86)) | (1L << (T__99 - 86)) | (1L << (T__100 - 86)) | (1L << (IDENT - 86)) | (1L << (NUMBER - 86)) | (1L << (STRING - 86)))) != 0)) {
				{
				{
				setState(1169);
				statement();
				}
				}
				setState(1174);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1175);
			match(T__16);
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

	public static class PatternContext extends ParserRuleContext {
		public OrPatternContext orPattern() {
			return getRuleContext(OrPatternContext.class,0);
		}
		public PatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern; }
	}

	public final PatternContext pattern() throws RecognitionException {
		PatternContext _localctx = new PatternContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1177);
			orPattern();
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

	public static class OrPatternContext extends ParserRuleContext {
		public List<AsPatternContext> asPattern() {
			return getRuleContexts(AsPatternContext.class);
		}
		public AsPatternContext asPattern(int i) {
			return getRuleContext(AsPatternContext.class,i);
		}
		public OrPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orPattern; }
	}

	public final OrPatternContext orPattern() throws RecognitionException {
		OrPatternContext _localctx = new OrPatternContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_orPattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1179);
			asPattern();
			setState(1184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__73) {
				{
				{
				setState(1180);
				match(T__73);
				setState(1181);
				asPattern();
				}
				}
				setState(1186);
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

	public static class AsPatternContext extends ParserRuleContext {
		public ConstructorOrLiteralContext constructorOrLiteral() {
			return getRuleContext(ConstructorOrLiteralContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(auraParser.IDENT, 0); }
		public AsPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asPattern; }
	}

	public final AsPatternContext asPattern() throws RecognitionException {
		AsPatternContext _localctx = new AsPatternContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_asPattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1187);
			constructorOrLiteral();
			setState(1190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(1188);
				match(T__1);
				setState(1189);
				match(IDENT);
				}
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

	public static class ConstructorOrLiteralContext extends ParserRuleContext {
		public ConstructorOrLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorOrLiteral; }
	 
		public ConstructorOrLiteralContext() { }
		public void copyFrom(ConstructorOrLiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LiteralPatternContext extends ConstructorOrLiteralContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralPatternContext(ConstructorOrLiteralContext ctx) { copyFrom(ctx); }
	}
	public static class DictPatternContext extends ConstructorOrLiteralContext {
		public FieldPatternsContext fieldPatterns() {
			return getRuleContext(FieldPatternsContext.class,0);
		}
		public DictPatternContext(ConstructorOrLiteralContext ctx) { copyFrom(ctx); }
	}
	public static class IdentifierPatternContext extends ConstructorOrLiteralContext {
		public TerminalNode IDENT() { return getToken(auraParser.IDENT, 0); }
		public IdentifierPatternContext(ConstructorOrLiteralContext ctx) { copyFrom(ctx); }
	}
	public static class ConstructorPatternContext extends ConstructorOrLiteralContext {
		public TerminalNode IDENT() { return getToken(auraParser.IDENT, 0); }
		public PatternListContext patternList() {
			return getRuleContext(PatternListContext.class,0);
		}
		public ConstructorPatternContext(ConstructorOrLiteralContext ctx) { copyFrom(ctx); }
	}
	public static class ListPatternContext extends ConstructorOrLiteralContext {
		public PatternListContext patternList() {
			return getRuleContext(PatternListContext.class,0);
		}
		public ListPatternContext(ConstructorOrLiteralContext ctx) { copyFrom(ctx); }
	}
	public static class WildcardPatternContext extends ConstructorOrLiteralContext {
		public WildcardPatternContext(ConstructorOrLiteralContext ctx) { copyFrom(ctx); }
	}

	public final ConstructorOrLiteralContext constructorOrLiteral() throws RecognitionException {
		ConstructorOrLiteralContext _localctx = new ConstructorOrLiteralContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_constructorOrLiteral);
		int _la;
		try {
			setState(1211);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,140,_ctx) ) {
			case 1:
				_localctx = new ConstructorPatternContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1192);
				match(IDENT);
				setState(1193);
				match(T__13);
				setState(1195);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__15 || ((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (T__92 - 93)) | (1L << (T__97 - 93)) | (1L << (T__98 - 93)) | (1L << (T__99 - 93)) | (1L << (T__100 - 93)) | (1L << (T__102 - 93)) | (1L << (IDENT - 93)) | (1L << (NUMBER - 93)) | (1L << (STRING - 93)))) != 0)) {
					{
					setState(1194);
					patternList();
					}
				}

				setState(1197);
				match(T__14);
				}
				break;
			case 2:
				_localctx = new ListPatternContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1198);
				match(T__92);
				setState(1200);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__15 || ((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (T__92 - 93)) | (1L << (T__97 - 93)) | (1L << (T__98 - 93)) | (1L << (T__99 - 93)) | (1L << (T__100 - 93)) | (1L << (T__102 - 93)) | (1L << (IDENT - 93)) | (1L << (NUMBER - 93)) | (1L << (STRING - 93)))) != 0)) {
					{
					setState(1199);
					patternList();
					}
				}

				setState(1202);
				match(T__93);
				}
				break;
			case 3:
				_localctx = new DictPatternContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1203);
				match(T__15);
				setState(1205);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENT) {
					{
					setState(1204);
					fieldPatterns();
					}
				}

				setState(1207);
				match(T__16);
				}
				break;
			case 4:
				_localctx = new LiteralPatternContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(1208);
				literal();
				}
				break;
			case 5:
				_localctx = new IdentifierPatternContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(1209);
				match(IDENT);
				}
				break;
			case 6:
				_localctx = new WildcardPatternContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(1210);
				match(T__102);
				}
				break;
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

	public static class PatternListContext extends ParserRuleContext {
		public List<PatternContext> pattern() {
			return getRuleContexts(PatternContext.class);
		}
		public PatternContext pattern(int i) {
			return getRuleContext(PatternContext.class,i);
		}
		public TerminalNode IDENT() { return getToken(auraParser.IDENT, 0); }
		public PatternListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_patternList; }
	}

	public final PatternListContext patternList() throws RecognitionException {
		PatternListContext _localctx = new PatternListContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_patternList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1213);
			pattern();
			setState(1218);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,141,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1214);
					match(T__4);
					setState(1215);
					pattern();
					}
					} 
				}
				setState(1220);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,141,_ctx);
			}
			setState(1224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(1221);
				match(T__4);
				setState(1222);
				match(T__5);
				setState(1223);
				match(IDENT);
				}
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

	public static class FieldPatternsContext extends ParserRuleContext {
		public List<FieldPatternContext> fieldPattern() {
			return getRuleContexts(FieldPatternContext.class);
		}
		public FieldPatternContext fieldPattern(int i) {
			return getRuleContext(FieldPatternContext.class,i);
		}
		public FieldPatternsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldPatterns; }
	}

	public final FieldPatternsContext fieldPatterns() throws RecognitionException {
		FieldPatternsContext _localctx = new FieldPatternsContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_fieldPatterns);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1226);
			fieldPattern();
			setState(1231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(1227);
				match(T__4);
				setState(1228);
				fieldPattern();
				}
				}
				setState(1233);
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

	public static class FieldPatternContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(auraParser.IDENT, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public FieldPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldPattern; }
	}

	public final FieldPatternContext fieldPattern() throws RecognitionException {
		FieldPatternContext _localctx = new FieldPatternContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_fieldPattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1234);
			match(IDENT);
			setState(1237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__68) {
				{
				setState(1235);
				match(T__68);
				setState(1236);
				pattern();
				}
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

	public static class TypeAnnotationContext extends ParserRuleContext {
		public UnionTypeContext unionType() {
			return getRuleContext(UnionTypeContext.class,0);
		}
		public TypeAnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeAnnotation; }
	}

	public final TypeAnnotationContext typeAnnotation() throws RecognitionException {
		TypeAnnotationContext _localctx = new TypeAnnotationContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_typeAnnotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1239);
			unionType();
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

	public static class UnionTypeContext extends ParserRuleContext {
		public List<PrimaryTypeContext> primaryType() {
			return getRuleContexts(PrimaryTypeContext.class);
		}
		public PrimaryTypeContext primaryType(int i) {
			return getRuleContext(PrimaryTypeContext.class,i);
		}
		public UnionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unionType; }
	}

	public final UnionTypeContext unionType() throws RecognitionException {
		UnionTypeContext _localctx = new UnionTypeContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_unionType);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1241);
			primaryType();
			setState(1246);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,145,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1242);
					match(T__73);
					setState(1243);
					primaryType();
					}
					} 
				}
				setState(1248);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,145,_ctx);
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

	public static class PrimaryTypeContext extends ParserRuleContext {
		public PrimaryTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryType; }
	 
		public PrimaryTypeContext() { }
		public void copyFrom(PrimaryTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StructuralTypeContext extends PrimaryTypeContext {
		public FieldTypesContext fieldTypes() {
			return getRuleContext(FieldTypesContext.class,0);
		}
		public StructuralTypeContext(PrimaryTypeContext ctx) { copyFrom(ctx); }
	}
	public static class FunctionTypeContext extends PrimaryTypeContext {
		public List<TypeAnnotationContext> typeAnnotation() {
			return getRuleContexts(TypeAnnotationContext.class);
		}
		public TypeAnnotationContext typeAnnotation(int i) {
			return getRuleContext(TypeAnnotationContext.class,i);
		}
		public FunctionTypeContext(PrimaryTypeContext ctx) { copyFrom(ctx); }
	}
	public static class ListTypeContext extends PrimaryTypeContext {
		public TypeAnnotationContext typeAnnotation() {
			return getRuleContext(TypeAnnotationContext.class,0);
		}
		public ListTypeContext(PrimaryTypeContext ctx) { copyFrom(ctx); }
	}
	public static class NamedOrGenericTypeContext extends PrimaryTypeContext {
		public TerminalNode IDENT() { return getToken(auraParser.IDENT, 0); }
		public TypeArgsContext typeArgs() {
			return getRuleContext(TypeArgsContext.class,0);
		}
		public NamedOrGenericTypeContext(PrimaryTypeContext ctx) { copyFrom(ctx); }
	}
	public static class DictTypeContext extends PrimaryTypeContext {
		public List<TypeAnnotationContext> typeAnnotation() {
			return getRuleContexts(TypeAnnotationContext.class);
		}
		public TypeAnnotationContext typeAnnotation(int i) {
			return getRuleContext(TypeAnnotationContext.class,i);
		}
		public DictTypeContext(PrimaryTypeContext ctx) { copyFrom(ctx); }
	}

	public final PrimaryTypeContext primaryType() throws RecognitionException {
		PrimaryTypeContext _localctx = new PrimaryTypeContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_primaryType);
		int _la;
		try {
			setState(1284);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,150,_ctx) ) {
			case 1:
				_localctx = new NamedOrGenericTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1249);
				match(IDENT);
				setState(1251);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,146,_ctx) ) {
				case 1:
					{
					setState(1250);
					typeArgs();
					}
					break;
				}
				setState(1254);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,147,_ctx) ) {
				case 1:
					{
					setState(1253);
					match(T__67);
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new FunctionTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1256);
				match(T__13);
				setState(1257);
				typeAnnotation();
				setState(1262);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(1258);
					match(T__4);
					setState(1259);
					typeAnnotation();
					}
					}
					setState(1264);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1265);
				match(T__14);
				setState(1266);
				match(T__20);
				setState(1267);
				typeAnnotation();
				}
				break;
			case 3:
				_localctx = new ListTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1269);
				match(T__92);
				setState(1270);
				typeAnnotation();
				setState(1271);
				match(T__93);
				}
				break;
			case 4:
				_localctx = new DictTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(1273);
				match(T__92);
				setState(1274);
				typeAnnotation();
				setState(1275);
				match(T__4);
				setState(1276);
				typeAnnotation();
				setState(1277);
				match(T__93);
				}
				break;
			case 5:
				_localctx = new StructuralTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(1279);
				match(T__15);
				setState(1281);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENT) {
					{
					setState(1280);
					fieldTypes();
					}
				}

				setState(1283);
				match(T__16);
				}
				break;
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

	public static class TypeArgsContext extends ParserRuleContext {
		public List<TypeAnnotationContext> typeAnnotation() {
			return getRuleContexts(TypeAnnotationContext.class);
		}
		public TypeAnnotationContext typeAnnotation(int i) {
			return getRuleContext(TypeAnnotationContext.class,i);
		}
		public TypeArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArgs; }
	}

	public final TypeArgsContext typeArgs() throws RecognitionException {
		TypeArgsContext _localctx = new TypeArgsContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_typeArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1286);
			match(T__17);
			setState(1287);
			typeAnnotation();
			setState(1292);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(1288);
				match(T__4);
				setState(1289);
				typeAnnotation();
				}
				}
				setState(1294);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1295);
			match(T__18);
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

	public static class FieldTypesContext extends ParserRuleContext {
		public List<FieldTypeContext> fieldType() {
			return getRuleContexts(FieldTypeContext.class);
		}
		public FieldTypeContext fieldType(int i) {
			return getRuleContext(FieldTypeContext.class,i);
		}
		public FieldTypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldTypes; }
	}

	public final FieldTypesContext fieldTypes() throws RecognitionException {
		FieldTypesContext _localctx = new FieldTypesContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_fieldTypes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1297);
			fieldType();
			setState(1302);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(1298);
				match(T__4);
				setState(1299);
				fieldType();
				}
				}
				setState(1304);
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

	public static class FieldTypeContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(auraParser.IDENT, 0); }
		public TypeAnnotationContext typeAnnotation() {
			return getRuleContext(TypeAnnotationContext.class,0);
		}
		public FieldTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldType; }
	}

	public final FieldTypeContext fieldType() throws RecognitionException {
		FieldTypeContext _localctx = new FieldTypeContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_fieldType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1305);
			match(IDENT);
			setState(1306);
			match(T__68);
			setState(1307);
			typeAnnotation();
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3o\u0520\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\3\2\3\2\3\2\7\2\u00c6\n\2\f\2\16\2\u00c9\13\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\5\3\u00d1\n\3\3\3\3\3\3\3\3\3\3\3\5\3\u00d8\n\3\3\4\3\4\3\4"+
		"\7\4\u00dd\n\4\f\4\16\4\u00e0\13\4\3\5\3\5\3\5\7\5\u00e5\n\5\f\5\16\5"+
		"\u00e8\13\5\3\5\5\5\u00eb\n\5\3\5\5\5\u00ee\n\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\5\6\u00f7\n\6\3\7\3\7\5\7\u00fb\n\7\3\7\3\7\5\7\u00ff\n\7\3\7\3"+
		"\7\5\7\u0103\n\7\3\7\3\7\3\b\3\b\3\b\5\b\u010a\n\b\3\b\3\b\3\b\3\b\3\t"+
		"\7\t\u0111\n\t\f\t\16\t\u0114\13\t\3\t\5\t\u0117\n\t\3\t\3\t\3\t\5\t\u011c"+
		"\n\t\3\t\3\t\5\t\u0120\n\t\3\t\3\t\5\t\u0124\n\t\3\t\3\t\7\t\u0128\n\t"+
		"\f\t\16\t\u012b\13\t\3\t\3\t\3\t\5\t\u0130\n\t\3\n\3\n\3\n\3\n\7\n\u0136"+
		"\n\n\f\n\16\n\u0139\13\n\3\n\3\n\3\13\3\13\3\13\7\13\u0140\n\13\f\13\16"+
		"\13\u0143\13\13\3\f\3\f\5\f\u0147\n\f\3\f\3\f\5\f\u014b\n\f\3\f\3\f\3"+
		"\f\3\f\3\f\5\f\u0152\n\f\3\r\3\r\3\r\3\16\7\16\u0158\n\16\f\16\16\16\u015b"+
		"\13\16\3\16\3\16\3\16\5\16\u0160\n\16\3\16\3\16\5\16\u0164\n\16\3\16\3"+
		"\16\3\16\3\16\7\16\u016a\n\16\f\16\16\16\u016d\13\16\5\16\u016f\n\16\3"+
		"\16\3\16\7\16\u0173\n\16\f\16\16\16\u0176\13\16\3\16\3\16\3\17\3\17\5"+
		"\17\u017c\n\17\3\17\3\17\5\17\u0180\n\17\3\17\3\17\5\17\u0184\n\17\3\20"+
		"\3\20\5\20\u0188\n\20\3\20\3\20\5\20\u018c\n\20\3\20\3\20\3\20\3\20\5"+
		"\20\u0192\n\20\3\20\3\20\5\20\u0196\n\20\3\20\3\20\7\20\u019a\n\20\f\20"+
		"\16\20\u019d\13\20\3\20\3\20\3\20\5\20\u01a2\n\20\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\5\21\u01ac\n\21\3\21\3\21\7\21\u01b0\n\21\f\21\16"+
		"\21\u01b3\13\21\3\21\3\21\3\21\5\21\u01b8\n\21\3\22\3\22\3\22\5\22\u01bd"+
		"\n\22\3\22\3\22\7\22\u01c1\n\22\f\22\16\22\u01c4\13\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\5\23\u01cc\n\23\3\23\3\23\5\23\u01d0\n\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u01db\n\23\3\23\5\23\u01de\n\23"+
		"\3\24\3\24\3\24\5\24\u01e3\n\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\7\25\u01ed\n\25\f\25\16\25\u01f0\13\25\3\25\3\25\3\26\5\26\u01f5\n\26"+
		"\3\26\3\26\5\26\u01f9\n\26\3\26\5\26\u01fc\n\26\3\27\3\27\3\27\3\27\5"+
		"\27\u0202\n\27\3\27\5\27\u0205\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\5\30\u021d\n\30\3\31\3\31\3\31\3\31\5\31\u0223\n\31\3\31\3\31\3"+
		"\32\3\32\3\32\3\33\3\33\3\33\3\33\7\33\u022e\n\33\f\33\16\33\u0231\13"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\7\33\u0239\n\33\f\33\16\33\u023c\13"+
		"\33\3\33\3\33\7\33\u0240\n\33\f\33\16\33\u0243\13\33\3\33\3\33\3\33\7"+
		"\33\u0248\n\33\f\33\16\33\u024b\13\33\3\33\5\33\u024e\n\33\3\34\3\34\3"+
		"\34\3\34\7\34\u0254\n\34\f\34\16\34\u0257\13\34\3\34\3\34\3\34\3\34\7"+
		"\34\u025d\n\34\f\34\16\34\u0260\13\34\3\34\5\34\u0263\n\34\3\35\3\35\3"+
		"\35\3\35\3\35\7\35\u026a\n\35\f\35\16\35\u026d\13\35\3\35\3\35\3\36\3"+
		"\36\3\36\3\36\7\36\u0275\n\36\f\36\16\36\u0278\13\36\3\36\3\36\3\37\3"+
		"\37\3\37\3\37\7\37\u0280\n\37\f\37\16\37\u0283\13\37\3\37\3\37\3 \3 \3"+
		" \3 \3 \3 \5 \u028d\n \3 \3 \7 \u0291\n \f \16 \u0294\13 \3 \3 \3!\3!"+
		"\3!\7!\u029b\n!\f!\16!\u029e\13!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\5$\u02aa"+
		"\n$\3$\3$\3%\3%\3%\7%\u02b1\n%\f%\16%\u02b4\13%\3%\3%\3%\3%\3%\7%\u02bb"+
		"\n%\f%\16%\u02be\13%\3%\3%\7%\u02c2\n%\f%\16%\u02c5\13%\3%\3%\3%\7%\u02ca"+
		"\n%\f%\16%\u02cd\13%\3%\5%\u02d0\n%\3&\3&\3&\5&\u02d5\n&\3&\5&\u02d8\n"+
		"&\3\'\3\'\3\'\3\'\7\'\u02de\n\'\f\'\16\'\u02e1\13\'\3\'\3\'\7\'\u02e5"+
		"\n\'\f\'\16\'\u02e8\13\'\3\'\3\'\3(\3(\3(\5(\u02ef\n(\3)\3)\3)\3)\6)\u02f5"+
		"\n)\r)\16)\u02f6\3)\3)\3*\3*\3*\3*\5*\u02ff\n*\3*\3*\7*\u0303\n*\f*\16"+
		"*\u0306\13*\3*\3*\3+\3+\7+\u030c\n+\f+\16+\u030f\13+\3+\3+\3,\3,\3-\3"+
		"-\3-\3-\7-\u0319\n-\f-\16-\u031c\13-\3.\3.\3/\3/\3/\7/\u0323\n/\f/\16"+
		"/\u0326\13/\3\60\3\60\3\60\3\60\3\60\3\60\5\60\u032e\n\60\3\61\3\61\3"+
		"\61\7\61\u0333\n\61\f\61\16\61\u0336\13\61\3\62\3\62\3\62\7\62\u033b\n"+
		"\62\f\62\16\62\u033e\13\62\3\63\3\63\3\63\7\63\u0343\n\63\f\63\16\63\u0346"+
		"\13\63\3\64\3\64\3\64\7\64\u034b\n\64\f\64\16\64\u034e\13\64\3\65\3\65"+
		"\3\65\7\65\u0353\n\65\f\65\16\65\u0356\13\65\3\66\3\66\3\66\7\66\u035b"+
		"\n\66\f\66\16\66\u035e\13\66\3\67\3\67\3\67\7\67\u0363\n\67\f\67\16\67"+
		"\u0366\13\67\38\38\38\78\u036b\n8\f8\168\u036e\138\39\39\39\79\u0373\n"+
		"9\f9\169\u0376\139\3:\3:\3:\3:\3:\5:\u037d\n:\3:\3:\3:\3:\3:\3:\3:\3:"+
		"\5:\u0387\n:\3:\5:\u038a\n:\3;\3;\3;\7;\u038f\n;\f;\16;\u0392\13;\3<\3"+
		"<\3<\7<\u0397\n<\f<\16<\u039a\13<\3=\3=\3=\7=\u039f\n=\f=\16=\u03a2\13"+
		"=\3>\3>\3>\7>\u03a7\n>\f>\16>\u03aa\13>\3?\3?\3?\5?\u03af\n?\3@\3@\3@"+
		"\7@\u03b4\n@\f@\16@\u03b7\13@\3A\3A\3A\3A\3A\3A\7A\u03bf\nA\fA\16A\u03c2"+
		"\13A\3B\3B\5B\u03c6\nB\3B\3B\3C\3C\3C\3C\3D\3D\3D\3E\3E\3E\3E\3E\3E\5"+
		"E\u03d7\nE\3F\3F\3F\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\5G\u03ea"+
		"\nG\3H\3H\3I\3I\3I\7I\u03f1\nI\fI\16I\u03f4\13I\3J\3J\3J\3J\5J\u03fa\n"+
		"J\3K\3K\3K\3K\3K\3K\7K\u0402\nK\fK\16K\u0405\13K\3K\3K\3K\3K\3K\3K\6K"+
		"\u040d\nK\rK\16K\u040e\3K\3K\5K\u0413\nK\3L\3L\3L\3L\3L\3L\7L\u041b\n"+
		"L\fL\16L\u041e\13L\3L\3L\3L\3L\3L\3L\6L\u0426\nL\rL\16L\u0427\3L\3L\5"+
		"L\u042c\nL\3M\3M\3M\3M\3N\3N\3N\3N\6N\u0436\nN\rN\16N\u0437\3N\3N\3N\3"+
		"N\3N\3N\6N\u0440\nN\rN\16N\u0441\3N\3N\5N\u0446\nN\3O\3O\3O\3O\3O\3O\7"+
		"O\u044e\nO\fO\16O\u0451\13O\3O\3O\5O\u0455\nO\3P\3P\5P\u0459\nP\3P\3P"+
		"\3P\3P\3P\7P\u0460\nP\fP\16P\u0463\13P\3P\5P\u0466\nP\3Q\3Q\3Q\3Q\6Q\u046c"+
		"\nQ\rQ\16Q\u046d\3Q\3Q\3Q\3Q\3Q\3Q\6Q\u0476\nQ\rQ\16Q\u0477\3Q\3Q\5Q\u047c"+
		"\nQ\3R\3R\3R\3R\3R\3R\7R\u0484\nR\fR\16R\u0487\13R\3S\3S\3S\3S\6S\u048d"+
		"\nS\rS\16S\u048e\3S\3S\3T\3T\7T\u0495\nT\fT\16T\u0498\13T\3T\3T\3U\3U"+
		"\3V\3V\3V\7V\u04a1\nV\fV\16V\u04a4\13V\3W\3W\3W\5W\u04a9\nW\3X\3X\3X\5"+
		"X\u04ae\nX\3X\3X\3X\5X\u04b3\nX\3X\3X\3X\5X\u04b8\nX\3X\3X\3X\3X\5X\u04be"+
		"\nX\3Y\3Y\3Y\7Y\u04c3\nY\fY\16Y\u04c6\13Y\3Y\3Y\3Y\5Y\u04cb\nY\3Z\3Z\3"+
		"Z\7Z\u04d0\nZ\fZ\16Z\u04d3\13Z\3[\3[\3[\5[\u04d8\n[\3\\\3\\\3]\3]\3]\7"+
		"]\u04df\n]\f]\16]\u04e2\13]\3^\3^\5^\u04e6\n^\3^\5^\u04e9\n^\3^\3^\3^"+
		"\3^\7^\u04ef\n^\f^\16^\u04f2\13^\3^\3^\3^\3^\3^\3^\3^\3^\3^\3^\3^\3^\3"+
		"^\3^\3^\3^\5^\u0504\n^\3^\5^\u0507\n^\3_\3_\3_\3_\7_\u050d\n_\f_\16_\u0510"+
		"\13_\3_\3_\3`\3`\3`\7`\u0517\n`\f`\16`\u051a\13`\3a\3a\3a\3a\3a\2\2b\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJL"+
		"NPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e"+
		"\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6"+
		"\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be"+
		"\u00c0\2\f\4\2\13\138D\4\2,,OQ\4\2\24\25RS\3\2VW\3\2XY\4\2\b\bZ\\\4\2"+
		"XY]^\5\2\b\b\26\26cc\4\2dgkl\4\2\13\13GG\2\u058c\2\u00c7\3\2\2\2\4\u00d7"+
		"\3\2\2\2\6\u00d9\3\2\2\2\b\u00ed\3\2\2\2\n\u00f6\3\2\2\2\f\u00f8\3\2\2"+
		"\2\16\u0106\3\2\2\2\20\u0112\3\2\2\2\22\u0131\3\2\2\2\24\u013c\3\2\2\2"+
		"\26\u0151\3\2\2\2\30\u0153\3\2\2\2\32\u0159\3\2\2\2\34\u0183\3\2\2\2\36"+
		"\u0185\3\2\2\2 \u01a3\3\2\2\2\"\u01b9\3\2\2\2$\u01dd\3\2\2\2&\u01df\3"+
		"\2\2\2(\u01e8\3\2\2\2*\u01fb\3\2\2\2,\u01fd\3\2\2\2.\u021c\3\2\2\2\60"+
		"\u021e\3\2\2\2\62\u0226\3\2\2\2\64\u0229\3\2\2\2\66\u024f\3\2\2\28\u0264"+
		"\3\2\2\2:\u0270\3\2\2\2<\u027b\3\2\2\2>\u0286\3\2\2\2@\u0297\3\2\2\2B"+
		"\u02a1\3\2\2\2D\u02a4\3\2\2\2F\u02a7\3\2\2\2H\u02ad\3\2\2\2J\u02d7\3\2"+
		"\2\2L\u02d9\3\2\2\2N\u02eb\3\2\2\2P\u02f0\3\2\2\2R\u02fa\3\2\2\2T\u0309"+
		"\3\2\2\2V\u0312\3\2\2\2X\u0314\3\2\2\2Z\u031d\3\2\2\2\\\u031f\3\2\2\2"+
		"^\u0327\3\2\2\2`\u032f\3\2\2\2b\u0337\3\2\2\2d\u033f\3\2\2\2f\u0347\3"+
		"\2\2\2h\u034f\3\2\2\2j\u0357\3\2\2\2l\u035f\3\2\2\2n\u0367\3\2\2\2p\u036f"+
		"\3\2\2\2r\u0389\3\2\2\2t\u038b\3\2\2\2v\u0393\3\2\2\2x\u039b\3\2\2\2z"+
		"\u03a3\3\2\2\2|\u03ae\3\2\2\2~\u03b0\3\2\2\2\u0080\u03b8\3\2\2\2\u0082"+
		"\u03c3\3\2\2\2\u0084\u03c9\3\2\2\2\u0086\u03cd\3\2\2\2\u0088\u03d6\3\2"+
		"\2\2\u008a\u03d8\3\2\2\2\u008c\u03e9\3\2\2\2\u008e\u03eb\3\2\2\2\u0090"+
		"\u03ed\3\2\2\2\u0092\u03f9\3\2\2\2\u0094\u0412\3\2\2\2\u0096\u042b\3\2"+
		"\2\2\u0098\u042d\3\2\2\2\u009a\u0445\3\2\2\2\u009c\u0454\3\2\2\2\u009e"+
		"\u0456\3\2\2\2\u00a0\u047b\3\2\2\2\u00a2\u047d\3\2\2\2\u00a4\u0488\3\2"+
		"\2\2\u00a6\u0492\3\2\2\2\u00a8\u049b\3\2\2\2\u00aa\u049d\3\2\2\2\u00ac"+
		"\u04a5\3\2\2\2\u00ae\u04bd\3\2\2\2\u00b0\u04bf\3\2\2\2\u00b2\u04cc\3\2"+
		"\2\2\u00b4\u04d4\3\2\2\2\u00b6\u04d9\3\2\2\2\u00b8\u04db\3\2\2\2\u00ba"+
		"\u0506\3\2\2\2\u00bc\u0508\3\2\2\2\u00be\u0513\3\2\2\2\u00c0\u051b\3\2"+
		"\2\2\u00c2\u00c6\5\4\3\2\u00c3\u00c6\5\n\6\2\u00c4\u00c6\5.\30\2\u00c5"+
		"\u00c2\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c4\3\2\2\2\u00c6\u00c9\3\2"+
		"\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00ca\3\2\2\2\u00c9"+
		"\u00c7\3\2\2\2\u00ca\u00cb\7\2\2\3\u00cb\3\3\2\2\2\u00cc\u00cd\7\3\2\2"+
		"\u00cd\u00d0\5\6\4\2\u00ce\u00cf\7\4\2\2\u00cf\u00d1\7j\2\2\u00d0\u00ce"+
		"\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d8\3\2\2\2\u00d2\u00d3\7\5\2\2\u00d3"+
		"\u00d4\5\6\4\2\u00d4\u00d5\7\3\2\2\u00d5\u00d6\5\b\5\2\u00d6\u00d8\3\2"+
		"\2\2\u00d7\u00cc\3\2\2\2\u00d7\u00d2\3\2\2\2\u00d8\5\3\2\2\2\u00d9\u00de"+
		"\7j\2\2\u00da\u00db\7\6\2\2\u00db\u00dd\7j\2\2\u00dc\u00da\3\2\2\2\u00dd"+
		"\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\7\3\2\2\2"+
		"\u00e0\u00de\3\2\2\2\u00e1\u00e6\7j\2\2\u00e2\u00e3\7\7\2\2\u00e3\u00e5"+
		"\7j\2\2\u00e4\u00e2\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6"+
		"\u00e7\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00eb\7\7"+
		"\2\2\u00ea\u00e9\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec"+
		"\u00ee\7\b\2\2\u00ed\u00e1\3\2\2\2\u00ed\u00ec\3\2\2\2\u00ee\t\3\2\2\2"+
		"\u00ef\u00f7\5\f\7\2\u00f0\u00f7\5\16\b\2\u00f1\u00f7\5\20\t\2\u00f2\u00f7"+
		"\5\32\16\2\u00f3\u00f7\5\"\22\2\u00f4\u00f7\5&\24\2\u00f5\u00f7\5(\25"+
		"\2\u00f6\u00ef\3\2\2\2\u00f6\u00f0\3\2\2\2\u00f6\u00f1\3\2\2\2\u00f6\u00f2"+
		"\3\2\2\2\u00f6\u00f3\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f5\3\2\2\2\u00f7"+
		"\13\3\2\2\2\u00f8\u00fa\7\t\2\2\u00f9\u00fb\7\n\2\2\u00fa\u00f9\3\2\2"+
		"\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fe\7j\2\2\u00fd\u00ff"+
		"\5\u00b6\\\2\u00fe\u00fd\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0102\3\2\2"+
		"\2\u0100\u0101\7\13\2\2\u0101\u0103\5V,\2\u0102\u0100\3\2\2\2\u0102\u0103"+
		"\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0105\7\f\2\2\u0105\r\3\2\2\2\u0106"+
		"\u0107\7\r\2\2\u0107\u0109\7j\2\2\u0108\u010a\5\u00b6\\\2\u0109\u0108"+
		"\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010c\7\13\2\2"+
		"\u010c\u010d\5V,\2\u010d\u010e\7\f\2\2\u010e\17\3\2\2\2\u010f\u0111\5"+
		",\27\2\u0110\u010f\3\2\2\2\u0111\u0114\3\2\2\2\u0112\u0110\3\2\2\2\u0112"+
		"\u0113\3\2\2\2\u0113\u0116\3\2\2\2\u0114\u0112\3\2\2\2\u0115\u0117\7\16"+
		"\2\2\u0116\u0115\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0118\3\2\2\2\u0118"+
		"\u0119\7\17\2\2\u0119\u011b\7j\2\2\u011a\u011c\5\22\n\2\u011b\u011a\3"+
		"\2\2\2\u011b\u011c\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011f\7\20\2\2\u011e"+
		"\u0120\5\24\13\2\u011f\u011e\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0121\3"+
		"\2\2\2\u0121\u0123\7\21\2\2\u0122\u0124\5\30\r\2\u0123\u0122\3\2\2\2\u0123"+
		"\u0124\3\2\2\2\u0124\u012f\3\2\2\2\u0125\u0129\7\22\2\2\u0126\u0128\5"+
		".\30\2\u0127\u0126\3\2\2\2\u0128\u012b\3\2\2\2\u0129\u0127\3\2\2\2\u0129"+
		"\u012a\3\2\2\2\u012a\u012c\3\2\2\2\u012b\u0129\3\2\2\2\u012c\u0130\7\23"+
		"\2\2\u012d\u012e\7\13\2\2\u012e\u0130\5V,\2\u012f\u0125\3\2\2\2\u012f"+
		"\u012d\3\2\2\2\u0130\21\3\2\2\2\u0131\u0132\7\24\2\2\u0132\u0137\7j\2"+
		"\2\u0133\u0134\7\7\2\2\u0134\u0136\7j\2\2\u0135\u0133\3\2\2\2\u0136\u0139"+
		"\3\2\2\2\u0137\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u013a\3\2\2\2\u0139"+
		"\u0137\3\2\2\2\u013a\u013b\7\25\2\2\u013b\23\3\2\2\2\u013c\u0141\5\26"+
		"\f\2\u013d\u013e\7\7\2\2\u013e\u0140\5\26\f\2\u013f\u013d\3\2\2\2\u0140"+
		"\u0143\3\2\2\2\u0141\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142\25\3\2\2"+
		"\2\u0143\u0141\3\2\2\2\u0144\u0146\7j\2\2\u0145\u0147\5\u00b6\\\2\u0146"+
		"\u0145\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u014a\3\2\2\2\u0148\u0149\7\13"+
		"\2\2\u0149\u014b\5V,\2\u014a\u0148\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u0152"+
		"\3\2\2\2\u014c\u014d\7\b\2\2\u014d\u0152\7j\2\2\u014e\u0152\7\b\2\2\u014f"+
		"\u0150\7\26\2\2\u0150\u0152\7j\2\2\u0151\u0144\3\2\2\2\u0151\u014c\3\2"+
		"\2\2\u0151\u014e\3\2\2\2\u0151\u014f\3\2\2\2\u0152\27\3\2\2\2\u0153\u0154"+
		"\7\27\2\2\u0154\u0155\5\u00b6\\\2\u0155\31\3\2\2\2\u0156\u0158\5,\27\2"+
		"\u0157\u0156\3\2\2\2\u0158\u015b\3\2\2\2\u0159\u0157\3\2\2\2\u0159\u015a"+
		"\3\2\2\2\u015a\u015c\3\2\2\2\u015b\u0159\3\2\2\2\u015c\u015d\7\30\2\2"+
		"\u015d\u015f\7j\2\2\u015e\u0160\5\22\n\2\u015f\u015e\3\2\2\2\u015f\u0160"+
		"\3\2\2\2\u0160\u0163\3\2\2\2\u0161\u0162\7\31\2\2\u0162\u0164\5\u00b6"+
		"\\\2\u0163\u0161\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u016e\3\2\2\2\u0165"+
		"\u0166\7\32\2\2\u0166\u016b\5\u00b6\\\2\u0167\u0168\7\7\2\2\u0168\u016a"+
		"\5\u00b6\\\2\u0169\u0167\3\2\2\2\u016a\u016d\3\2\2\2\u016b\u0169\3\2\2"+
		"\2\u016b\u016c\3\2\2\2\u016c\u016f\3\2\2\2\u016d\u016b\3\2\2\2\u016e\u0165"+
		"\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0174\7\22\2\2"+
		"\u0171\u0173\5\34\17\2\u0172\u0171\3\2\2\2\u0173\u0176\3\2\2\2\u0174\u0172"+
		"\3\2\2\2\u0174\u0175\3\2\2\2\u0175\u0177\3\2\2\2\u0176\u0174\3\2\2\2\u0177"+
		"\u0178\7\23\2\2\u0178\33\3\2\2\2\u0179\u017b\7j\2\2\u017a\u017c\5\u00b6"+
		"\\\2\u017b\u017a\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u017f\3\2\2\2\u017d"+
		"\u017e\7\13\2\2\u017e\u0180\5V,\2\u017f\u017d\3\2\2\2\u017f\u0180\3\2"+
		"\2\2\u0180\u0184\3\2\2\2\u0181\u0184\5\36\20\2\u0182\u0184\5 \21\2\u0183"+
		"\u0179\3\2\2\2\u0183\u0181\3\2\2\2\u0183\u0182\3\2\2\2\u0184\35\3\2\2"+
		"\2\u0185\u0187\7\33\2\2\u0186\u0188\7\34\2\2\u0187\u0186\3\2\2\2\u0187"+
		"\u0188\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u018b\7\33\2\2\u018a\u018c\7"+
		"\35\2\2\u018b\u018a\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u018d\3\2\2\2\u018d"+
		"\u018e\7\17\2\2\u018e\u018f\7j\2\2\u018f\u0191\7\20\2\2\u0190\u0192\5"+
		"\24\13\2\u0191\u0190\3\2\2\2\u0191\u0192\3\2\2\2\u0192\u0193\3\2\2\2\u0193"+
		"\u0195\7\21\2\2\u0194\u0196\5\30\r\2\u0195\u0194\3\2\2\2\u0195\u0196\3"+
		"\2\2\2\u0196\u01a1\3\2\2\2\u0197\u019b\7\22\2\2\u0198\u019a\5.\30\2\u0199"+
		"\u0198\3\2\2\2\u019a\u019d\3\2\2\2\u019b\u0199\3\2\2\2\u019b\u019c\3\2"+
		"\2\2\u019c\u019e\3\2\2\2\u019d\u019b\3\2\2\2\u019e\u01a2\7\23\2\2\u019f"+
		"\u01a0\7\13\2\2\u01a0\u01a2\5V,\2\u01a1\u0197\3\2\2\2\u01a1\u019f\3\2"+
		"\2\2\u01a2\37\3\2\2\2\u01a3\u01a4\7\33\2\2\u01a4\u01a5\7\36\2\2\u01a5"+
		"\u01a6\7\17\2\2\u01a6\u01a7\7j\2\2\u01a7\u01a8\7\20\2\2\u01a8\u01a9\7"+
		"\37\2\2\u01a9\u01ab\7\21\2\2\u01aa\u01ac\5\30\r\2\u01ab\u01aa\3\2\2\2"+
		"\u01ab\u01ac\3\2\2\2\u01ac\u01b7\3\2\2\2\u01ad\u01b1\7\22\2\2\u01ae\u01b0"+
		"\5.\30\2\u01af\u01ae\3\2\2\2\u01b0\u01b3\3\2\2\2\u01b1\u01af\3\2\2\2\u01b1"+
		"\u01b2\3\2\2\2\u01b2\u01b4\3\2\2\2\u01b3\u01b1\3\2\2\2\u01b4\u01b8\7\23"+
		"\2\2\u01b5\u01b6\7\13\2\2\u01b6\u01b8\5V,\2\u01b7\u01ad\3\2\2\2\u01b7"+
		"\u01b5\3\2\2\2\u01b8!\3\2\2\2\u01b9\u01ba\7 \2\2\u01ba\u01bc\7j\2\2\u01bb"+
		"\u01bd\5\22\n\2\u01bc\u01bb\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd\u01be\3"+
		"\2\2\2\u01be\u01c2\7\22\2\2\u01bf\u01c1\5$\23\2\u01c0\u01bf\3\2\2\2\u01c1"+
		"\u01c4\3\2\2\2\u01c2\u01c0\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01c5\3\2"+
		"\2\2\u01c4\u01c2\3\2\2\2\u01c5\u01c6\7\23\2\2\u01c6#\3\2\2\2\u01c7\u01c8"+
		"\7\17\2\2\u01c8\u01c9\7j\2\2\u01c9\u01cb\7\20\2\2\u01ca\u01cc\5\24\13"+
		"\2\u01cb\u01ca\3\2\2\2\u01cb\u01cc\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01cf"+
		"\7\21\2\2\u01ce\u01d0\5\30\r\2\u01cf\u01ce\3\2\2\2\u01cf\u01d0\3\2\2\2"+
		"\u01d0\u01d1\3\2\2\2\u01d1\u01de\7\f\2\2\u01d2\u01d3\7\33\2\2\u01d3\u01d4"+
		"\7\36\2\2\u01d4\u01d5\7\17\2\2\u01d5\u01d6\7j\2\2\u01d6\u01d7\7\20\2\2"+
		"\u01d7\u01d8\7\37\2\2\u01d8\u01da\7\21\2\2\u01d9\u01db\5\30\r\2\u01da"+
		"\u01d9\3\2\2\2\u01da\u01db\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc\u01de\7\f"+
		"\2\2\u01dd\u01c7\3\2\2\2\u01dd\u01d2\3\2\2\2\u01de%\3\2\2\2\u01df\u01e0"+
		"\7!\2\2\u01e0\u01e2\7j\2\2\u01e1\u01e3\5\22\n\2\u01e2\u01e1\3\2\2\2\u01e2"+
		"\u01e3\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e5\7\13\2\2\u01e5\u01e6\5"+
		"\u00b6\\\2\u01e6\u01e7\7\f\2\2\u01e7\'\3\2\2\2\u01e8\u01e9\7\"\2\2\u01e9"+
		"\u01ea\7j\2\2\u01ea\u01ee\7\22\2\2\u01eb\u01ed\5*\26\2\u01ec\u01eb\3\2"+
		"\2\2\u01ed\u01f0\3\2\2\2\u01ee\u01ec\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef"+
		"\u01f1\3\2\2\2\u01f0\u01ee\3\2\2\2\u01f1\u01f2\7\23\2\2\u01f2)\3\2\2\2"+
		"\u01f3\u01f5\7#\2\2\u01f4\u01f3\3\2\2\2\u01f4\u01f5\3\2\2\2\u01f5\u01f6"+
		"\3\2\2\2\u01f6\u01fc\5\n\6\2\u01f7\u01f9\7#\2\2\u01f8\u01f7\3\2\2\2\u01f8"+
		"\u01f9\3\2\2\2\u01f9\u01fa\3\2\2\2\u01fa\u01fc\5.\30\2\u01fb\u01f4\3\2"+
		"\2\2\u01fb\u01f8\3\2\2\2\u01fc+\3\2\2\2\u01fd\u01fe\7\33\2\2\u01fe\u0204"+
		"\7j\2\2\u01ff\u0201\7\20\2\2\u0200\u0202\5\u0090I\2\u0201\u0200\3\2\2"+
		"\2\u0201\u0202\3\2\2\2\u0202\u0203\3\2\2\2\u0203\u0205\7\21\2\2\u0204"+
		"\u01ff\3\2\2\2\u0204\u0205\3\2\2\2\u0205-\3\2\2\2\u0206\u021d\5\f\7\2"+
		"\u0207\u021d\5\16\b\2\u0208\u021d\5\62\32\2\u0209\u021d\5\64\33\2\u020a"+
		"\u021d\5\66\34\2\u020b\u021d\58\35\2\u020c\u021d\5:\36\2\u020d\u021d\5"+
		"<\37\2\u020e\u021d\5> \2\u020f\u021d\5@!\2\u0210\u021d\5B\"\2\u0211\u021d"+
		"\5D#\2\u0212\u021d\5F$\2\u0213\u021d\5H%\2\u0214\u021d\5L\'\2\u0215\u021d"+
		"\5P)\2\u0216\u021d\5F$\2\u0217\u021d\5H%\2\u0218\u021d\5L\'\2\u0219\u021d"+
		"\5P)\2\u021a\u021d\5T+\2\u021b\u021d\5\60\31\2\u021c\u0206\3\2\2\2\u021c"+
		"\u0207\3\2\2\2\u021c\u0208\3\2\2\2\u021c\u0209\3\2\2\2\u021c\u020a\3\2"+
		"\2\2\u021c\u020b\3\2\2\2\u021c\u020c\3\2\2\2\u021c\u020d\3\2\2\2\u021c"+
		"\u020e\3\2\2\2\u021c\u020f\3\2\2\2\u021c\u0210\3\2\2\2\u021c\u0211\3\2"+
		"\2\2\u021c\u0212\3\2\2\2\u021c\u0213\3\2\2\2\u021c\u0214\3\2\2\2\u021c"+
		"\u0215\3\2\2\2\u021c\u0216\3\2\2\2\u021c\u0217\3\2\2\2\u021c\u0218\3\2"+
		"\2\2\u021c\u0219\3\2\2\2\u021c\u021a\3\2\2\2\u021c\u021b\3\2\2\2\u021d"+
		"/\3\2\2\2\u021e\u021f\7$\2\2\u021f\u0222\5V,\2\u0220\u0221\7\7\2\2\u0221"+
		"\u0223\5V,\2\u0222\u0220\3\2\2\2\u0222\u0223\3\2\2\2\u0223\u0224\3\2\2"+
		"\2\u0224\u0225\7\f\2\2\u0225\61\3\2\2\2\u0226\u0227\5V,\2\u0227\u0228"+
		"\7\f\2\2\u0228\63\3\2\2\2\u0229\u022a\7%\2\2\u022a\u022b\5V,\2\u022b\u022f"+
		"\7\22\2\2\u022c\u022e\5.\30\2\u022d\u022c\3\2\2\2\u022e\u0231\3\2\2\2"+
		"\u022f\u022d\3\2\2\2\u022f\u0230\3\2\2\2\u0230\u0232\3\2\2\2\u0231\u022f"+
		"\3\2\2\2\u0232\u0241\7\23\2\2\u0233\u0234\7&\2\2\u0234\u0235\7%\2\2\u0235"+
		"\u0236\5V,\2\u0236\u023a\7\22\2\2\u0237\u0239\5.\30\2\u0238\u0237\3\2"+
		"\2\2\u0239\u023c\3\2\2\2\u023a\u0238\3\2\2\2\u023a\u023b\3\2\2\2\u023b"+
		"\u023d\3\2\2\2\u023c\u023a\3\2\2\2\u023d\u023e\7\23\2\2\u023e\u0240\3"+
		"\2\2\2\u023f\u0233\3\2\2\2\u0240\u0243\3\2\2\2\u0241\u023f\3\2\2\2\u0241"+
		"\u0242\3\2\2\2\u0242\u024d\3\2\2\2\u0243\u0241\3\2\2\2\u0244\u0245\7&"+
		"\2\2\u0245\u0249\7\22\2\2\u0246\u0248\5.\30\2\u0247\u0246\3\2\2\2\u0248"+
		"\u024b\3\2\2\2\u0249\u0247\3\2\2\2\u0249\u024a\3\2\2\2\u024a\u024c\3\2"+
		"\2\2\u024b\u0249\3\2\2\2\u024c\u024e\7\23\2\2\u024d\u0244\3\2\2\2\u024d"+
		"\u024e\3\2\2\2\u024e\65\3\2\2\2\u024f\u0250\7\'\2\2\u0250\u0251\5V,\2"+
		"\u0251\u0255\7\22\2\2\u0252\u0254\5.\30\2\u0253\u0252\3\2\2\2\u0254\u0257"+
		"\3\2\2\2\u0255\u0253\3\2\2\2\u0255\u0256\3\2\2\2\u0256\u0258\3\2\2\2\u0257"+
		"\u0255\3\2\2\2\u0258\u0262\7\23\2\2\u0259\u025a\7&\2\2\u025a\u025e\7\22"+
		"\2\2\u025b\u025d\5.\30\2\u025c\u025b\3\2\2\2\u025d\u0260\3\2\2\2\u025e"+
		"\u025c\3\2\2\2\u025e\u025f\3\2\2\2\u025f\u0261\3\2\2\2\u0260\u025e\3\2"+
		"\2\2\u0261\u0263\7\23\2\2\u0262\u0259\3\2\2\2\u0262\u0263\3\2\2\2\u0263"+
		"\67\3\2\2\2\u0264\u0265\7(\2\2\u0265\u0266\5V,\2\u0266\u0267\7&\2\2\u0267"+
		"\u026b\7\22\2\2\u0268\u026a\5.\30\2\u0269\u0268\3\2\2\2\u026a\u026d\3"+
		"\2\2\2\u026b\u0269\3\2\2\2\u026b\u026c\3\2\2\2\u026c\u026e\3\2\2\2\u026d"+
		"\u026b\3\2\2\2\u026e\u026f\7\23\2\2\u026f9\3\2\2\2\u0270\u0271\7)\2\2"+
		"\u0271\u0272\5V,\2\u0272\u0276\7\22\2\2\u0273\u0275\5.\30\2\u0274\u0273"+
		"\3\2\2\2\u0275\u0278\3\2\2\2\u0276\u0274\3\2\2\2\u0276\u0277\3\2\2\2\u0277"+
		"\u0279\3\2\2\2\u0278\u0276\3\2\2\2\u0279\u027a\7\23\2\2\u027a;\3\2\2\2"+
		"\u027b\u027c\7*\2\2\u027c\u027d\5V,\2\u027d\u0281\7\22\2\2\u027e\u0280"+
		"\5.\30\2\u027f\u027e\3\2\2\2\u0280\u0283\3\2\2\2\u0281\u027f\3\2\2\2\u0281"+
		"\u0282\3\2\2\2\u0282\u0284\3\2\2\2\u0283\u0281\3\2\2\2\u0284\u0285\7\23"+
		"\2\2\u0285=\3\2\2\2\u0286\u0287\7+\2\2\u0287\u0288\5\u00a8U\2\u0288\u0289"+
		"\7,\2\2\u0289\u028c\5V,\2\u028a\u028b\7-\2\2\u028b\u028d\5V,\2\u028c\u028a"+
		"\3\2\2\2\u028c\u028d\3\2\2\2\u028d\u028e\3\2\2\2\u028e\u0292\7\22\2\2"+
		"\u028f\u0291\5.\30\2\u0290\u028f\3\2\2\2\u0291\u0294\3\2\2\2\u0292\u0290"+
		"\3\2\2\2\u0292\u0293\3\2\2\2\u0293\u0295\3\2\2\2\u0294\u0292\3\2\2\2\u0295"+
		"\u0296\7\23\2\2\u0296?\3\2\2\2\u0297\u0298\7.\2\2\u0298\u029c\7\22\2\2"+
		"\u0299\u029b\5.\30\2\u029a\u0299\3\2\2\2\u029b\u029e\3\2\2\2\u029c\u029a"+
		"\3\2\2\2\u029c\u029d\3\2\2\2\u029d\u029f\3\2\2\2\u029e\u029c\3\2\2\2\u029f"+
		"\u02a0\7\23\2\2\u02a0A\3\2\2\2\u02a1\u02a2\7/\2\2\u02a2\u02a3\7\f\2\2"+
		"\u02a3C\3\2\2\2\u02a4\u02a5\7\60\2\2\u02a5\u02a6\7\f\2\2\u02a6E\3\2\2"+
		"\2\u02a7\u02a9\7\61\2\2\u02a8\u02aa\5V,\2\u02a9\u02a8\3\2\2\2\u02a9\u02aa"+
		"\3\2\2\2\u02aa\u02ab\3\2\2\2\u02ab\u02ac\7\f\2\2\u02acG\3\2\2\2\u02ad"+
		"\u02ae\7\62\2\2\u02ae\u02b2\7\22\2\2\u02af\u02b1\5.\30\2\u02b0\u02af\3"+
		"\2\2\2\u02b1\u02b4\3\2\2\2\u02b2\u02b0\3\2\2\2\u02b2\u02b3\3\2\2\2\u02b3"+
		"\u02b5\3\2\2\2\u02b4\u02b2\3\2\2\2\u02b5\u02c3\7\23\2\2\u02b6\u02b7\7"+
		"\63\2\2\u02b7\u02b8\5J&\2\u02b8\u02bc\7\22\2\2\u02b9\u02bb\5.\30\2\u02ba"+
		"\u02b9\3\2\2\2\u02bb\u02be\3\2\2\2\u02bc\u02ba\3\2\2\2\u02bc\u02bd\3\2"+
		"\2\2\u02bd\u02bf\3\2\2\2\u02be\u02bc\3\2\2\2\u02bf\u02c0\7\23\2\2\u02c0"+
		"\u02c2\3\2\2\2\u02c1\u02b6\3\2\2\2\u02c2\u02c5\3\2\2\2\u02c3\u02c1\3\2"+
		"\2\2\u02c3\u02c4\3\2\2\2\u02c4\u02cf\3\2\2\2\u02c5\u02c3\3\2\2\2\u02c6"+
		"\u02c7\7\64\2\2\u02c7\u02cb\7\22\2\2\u02c8\u02ca\5.\30\2\u02c9\u02c8\3"+
		"\2\2\2\u02ca\u02cd\3\2\2\2\u02cb\u02c9\3\2\2\2\u02cb\u02cc\3\2\2\2\u02cc"+
		"\u02ce\3\2\2\2\u02cd\u02cb\3\2\2\2\u02ce\u02d0\7\23\2\2\u02cf\u02c6\3"+
		"\2\2\2\u02cf\u02d0\3\2\2\2\u02d0I\3\2\2\2\u02d1\u02d4\5\u00b6\\\2\u02d2"+
		"\u02d3\7\4\2\2\u02d3\u02d5\7j\2\2\u02d4\u02d2\3\2\2\2\u02d4\u02d5\3\2"+
		"\2\2\u02d5\u02d8\3\2\2\2\u02d6\u02d8\3\2\2\2\u02d7\u02d1\3\2\2\2\u02d7"+
		"\u02d6\3\2\2\2\u02d8K\3\2\2\2\u02d9\u02da\7\65\2\2\u02da\u02df\5N(\2\u02db"+
		"\u02dc\7\7\2\2\u02dc\u02de\5N(\2\u02dd\u02db\3\2\2\2\u02de\u02e1\3\2\2"+
		"\2\u02df\u02dd\3\2\2\2\u02df\u02e0\3\2\2\2\u02e0\u02e2\3\2\2\2\u02e1\u02df"+
		"\3\2\2\2\u02e2\u02e6\7\22\2\2\u02e3\u02e5\5.\30\2\u02e4\u02e3\3\2\2\2"+
		"\u02e5\u02e8\3\2\2\2\u02e6\u02e4\3\2\2\2\u02e6\u02e7\3\2\2\2\u02e7\u02e9"+
		"\3\2\2\2\u02e8\u02e6\3\2\2\2\u02e9\u02ea\7\23\2\2\u02eaM\3\2\2\2\u02eb"+
		"\u02ee\5V,\2\u02ec\u02ed\7\4\2\2\u02ed\u02ef\7j\2\2\u02ee\u02ec\3\2\2"+
		"\2\u02ee\u02ef\3\2\2\2\u02efO\3\2\2\2\u02f0\u02f1\7\66\2\2\u02f1\u02f2"+
		"\5V,\2\u02f2\u02f4\7\22\2\2\u02f3\u02f5\5R*\2\u02f4\u02f3\3\2\2\2\u02f5"+
		"\u02f6\3\2\2\2\u02f6\u02f4\3\2\2\2\u02f6\u02f7\3\2\2\2\u02f7\u02f8\3\2"+
		"\2\2\u02f8\u02f9\7\23\2\2\u02f9Q\3\2\2\2\u02fa\u02fb\7\67\2\2\u02fb\u02fe"+
		"\5\u00a8U\2\u02fc\u02fd\7%\2\2\u02fd\u02ff\5V,\2\u02fe\u02fc\3\2\2\2\u02fe"+
		"\u02ff\3\2\2\2\u02ff\u0300\3\2\2\2\u0300\u0304\7\22\2\2\u0301\u0303\5"+
		".\30\2\u0302\u0301\3\2\2\2\u0303\u0306\3\2\2\2\u0304\u0302\3\2\2\2\u0304"+
		"\u0305\3\2\2\2\u0305\u0307\3\2\2\2\u0306\u0304\3\2\2\2\u0307\u0308\7\23"+
		"\2\2\u0308S\3\2\2\2\u0309\u030d\7\22\2\2\u030a\u030c\5.\30\2\u030b\u030a"+
		"\3\2\2\2\u030c\u030f\3\2\2\2\u030d\u030b\3\2\2\2\u030d\u030e\3\2\2\2\u030e"+
		"\u0310\3\2\2\2\u030f\u030d\3\2\2\2\u0310\u0311\7\23\2\2\u0311U\3\2\2\2"+
		"\u0312\u0313\5X-\2\u0313W\3\2\2\2\u0314\u031a\5\\/\2\u0315\u0316\5Z.\2"+
		"\u0316\u0317\5\\/\2\u0317\u0319\3\2\2\2\u0318\u0315\3\2\2\2\u0319\u031c"+
		"\3\2\2\2\u031a\u0318\3\2\2\2\u031a\u031b\3\2\2\2\u031bY\3\2\2\2\u031c"+
		"\u031a\3\2\2\2\u031d\u031e\t\2\2\2\u031e[\3\2\2\2\u031f\u0324\5^\60\2"+
		"\u0320\u0321\7E\2\2\u0321\u0323\5^\60\2\u0322\u0320\3\2\2\2\u0323\u0326"+
		"\3\2\2\2\u0324\u0322\3\2\2\2\u0324\u0325\3\2\2\2\u0325]\3\2\2\2\u0326"+
		"\u0324\3\2\2\2\u0327\u032d\5`\61\2\u0328\u0329\7F\2\2\u0329\u032a\5V,"+
		"\2\u032a\u032b\7G\2\2\u032b\u032c\5V,\2\u032c\u032e\3\2\2\2\u032d\u0328"+
		"\3\2\2\2\u032d\u032e\3\2\2\2\u032e_\3\2\2\2\u032f\u0334\5b\62\2\u0330"+
		"\u0331\7H\2\2\u0331\u0333\5b\62\2\u0332\u0330\3\2\2\2\u0333\u0336\3\2"+
		"\2\2\u0334\u0332\3\2\2\2\u0334\u0335\3\2\2\2\u0335a\3\2\2\2\u0336\u0334"+
		"\3\2\2\2\u0337\u033c\5d\63\2\u0338\u0339\7I\2\2\u0339\u033b\5d\63\2\u033a"+
		"\u0338\3\2\2\2\u033b\u033e\3\2\2\2\u033c\u033a\3\2\2\2\u033c\u033d\3\2"+
		"\2\2\u033dc\3\2\2\2\u033e\u033c\3\2\2\2\u033f\u0344\5f\64\2\u0340\u0341"+
		"\7J\2\2\u0341\u0343\5f\64\2\u0342\u0340\3\2\2\2\u0343\u0346\3\2\2\2\u0344"+
		"\u0342\3\2\2\2\u0344\u0345\3\2\2\2\u0345e\3\2\2\2\u0346\u0344\3\2\2\2"+
		"\u0347\u034c\5h\65\2\u0348\u0349\7K\2\2\u0349\u034b\5h\65\2\u034a\u0348"+
		"\3\2\2\2\u034b\u034e\3\2\2\2\u034c\u034a\3\2\2\2\u034c\u034d\3\2\2\2\u034d"+
		"g\3\2\2\2\u034e\u034c\3\2\2\2\u034f\u0354\5j\66\2\u0350\u0351\7L\2\2\u0351"+
		"\u0353\5j\66\2\u0352\u0350\3\2\2\2\u0353\u0356\3\2\2\2\u0354\u0352\3\2"+
		"\2\2\u0354\u0355\3\2\2\2\u0355i\3\2\2\2\u0356\u0354\3\2\2\2\u0357\u035c"+
		"\5l\67\2\u0358\u0359\7M\2\2\u0359\u035b\5l\67\2\u035a\u0358\3\2\2\2\u035b"+
		"\u035e\3\2\2\2\u035c\u035a\3\2\2\2\u035c\u035d\3\2\2\2\u035dk\3\2\2\2"+
		"\u035e\u035c\3\2\2\2\u035f\u0364\5n8\2\u0360\u0361\7N\2\2\u0361\u0363"+
		"\5n8\2\u0362\u0360\3\2\2\2\u0363\u0366\3\2\2\2\u0364\u0362\3\2\2\2\u0364"+
		"\u0365\3\2\2\2\u0365m\3\2\2\2\u0366\u0364\3\2\2\2\u0367\u036c\5p9\2\u0368"+
		"\u0369\t\3\2\2\u0369\u036b\5p9\2\u036a\u0368\3\2\2\2\u036b\u036e\3\2\2"+
		"\2\u036c\u036a\3\2\2\2\u036c\u036d\3\2\2\2\u036do\3\2\2\2\u036e\u036c"+
		"\3\2\2\2\u036f\u0374\5r:\2\u0370\u0371\t\4\2\2\u0371\u0373\5r:\2\u0372"+
		"\u0370\3\2\2\2\u0373\u0376\3\2\2\2\u0374\u0372\3\2\2\2\u0374\u0375\3\2"+
		"\2\2\u0375q\3\2\2\2\u0376\u0374\3\2\2\2\u0377\u0378\5v<\2\u0378\u0379"+
		"\7T\2\2\u0379\u037c\5v<\2\u037a\u037b\7-\2\2\u037b\u037d\5v<\2\u037c\u037a"+
		"\3\2\2\2\u037c\u037d\3\2\2\2\u037d\u038a\3\2\2\2\u037e\u037f\5v<\2\u037f"+
		"\u0380\7U\2\2\u0380\u0381\5v<\2\u0381\u038a\3\2\2\2\u0382\u0383\5v<\2"+
		"\u0383\u0386\7T\2\2\u0384\u0385\7-\2\2\u0385\u0387\5v<\2\u0386\u0384\3"+
		"\2\2\2\u0386\u0387\3\2\2\2\u0387\u038a\3\2\2\2\u0388\u038a\5v<\2\u0389"+
		"\u0377\3\2\2\2\u0389\u037e\3\2\2\2\u0389\u0382\3\2\2\2\u0389\u0388\3\2"+
		"\2\2\u038as\3\2\2\2\u038b\u0390\5v<\2\u038c\u038d\t\5\2\2\u038d\u038f"+
		"\5v<\2\u038e\u038c\3\2\2\2\u038f\u0392\3\2\2\2\u0390\u038e\3\2\2\2\u0390"+
		"\u0391\3\2\2\2\u0391u\3\2\2\2\u0392\u0390\3\2\2\2\u0393\u0398\5x=\2\u0394"+
		"\u0395\t\6\2\2\u0395\u0397\5x=\2\u0396\u0394\3\2\2\2\u0397\u039a\3\2\2"+
		"\2\u0398\u0396\3\2\2\2\u0398\u0399\3\2\2\2\u0399w\3\2\2\2\u039a\u0398"+
		"\3\2\2\2\u039b\u03a0\5z>\2\u039c\u039d\t\7\2\2\u039d\u039f\5z>\2\u039e"+
		"\u039c\3\2\2\2\u039f\u03a2\3\2\2\2\u03a0\u039e\3\2\2\2\u03a0\u03a1\3\2"+
		"\2\2\u03a1y\3\2\2\2\u03a2\u03a0\3\2\2\2\u03a3\u03a8\5|?\2\u03a4\u03a5"+
		"\7\4\2\2\u03a5\u03a7\5\u00b6\\\2\u03a6\u03a4\3\2\2\2\u03a7\u03aa\3\2\2"+
		"\2\u03a8\u03a6\3\2\2\2\u03a8\u03a9\3\2\2\2\u03a9{\3\2\2\2\u03aa\u03a8"+
		"\3\2\2\2\u03ab\u03ac\t\b\2\2\u03ac\u03af\5|?\2\u03ad\u03af\5~@\2\u03ae"+
		"\u03ab\3\2\2\2\u03ae\u03ad\3\2\2\2\u03af}\3\2\2\2\u03b0\u03b5\5\u0080"+
		"A\2\u03b1\u03b2\7\26\2\2\u03b2\u03b4\5\u0080A\2\u03b3\u03b1\3\2\2\2\u03b4"+
		"\u03b7\3\2\2\2\u03b5\u03b3\3\2\2\2\u03b5\u03b6\3\2\2\2\u03b6\177\3\2\2"+
		"\2\u03b7\u03b5\3\2\2\2\u03b8\u03c0\5\u008cG\2\u03b9\u03bf\5\u0082B\2\u03ba"+
		"\u03bf\5\u0084C\2\u03bb\u03bf\5\u0086D\2\u03bc\u03bf\5\u0088E\2\u03bd"+
		"\u03bf\5\u008aF\2\u03be\u03b9\3\2\2\2\u03be\u03ba\3\2\2\2\u03be\u03bb"+
		"\3\2\2\2\u03be\u03bc\3\2\2\2\u03be\u03bd\3\2\2\2\u03bf\u03c2\3\2\2\2\u03c0"+
		"\u03be\3\2\2\2\u03c0\u03c1\3\2\2\2\u03c1\u0081\3\2\2\2\u03c2\u03c0\3\2"+
		"\2\2\u03c3\u03c5\7\20\2\2\u03c4\u03c6\5\u0090I\2\u03c5\u03c4\3\2\2\2\u03c5"+
		"\u03c6\3\2\2\2\u03c6\u03c7\3\2\2\2\u03c7\u03c8\7\21\2\2\u03c8\u0083\3"+
		"\2\2\2\u03c9\u03ca\7_\2\2\u03ca\u03cb\5V,\2\u03cb\u03cc\7`\2\2\u03cc\u0085"+
		"\3\2\2\2\u03cd\u03ce\7\6\2\2\u03ce\u03cf\7j\2\2\u03cf\u0087\3\2\2\2\u03d0"+
		"\u03d1\7a\2\2\u03d1\u03d7\7j\2\2\u03d2\u03d3\7b\2\2\u03d3\u03d4\5V,\2"+
		"\u03d4\u03d5\7`\2\2\u03d5\u03d7\3\2\2\2\u03d6\u03d0\3\2\2\2\u03d6\u03d2"+
		"\3\2\2\2\u03d7\u0089\3\2\2\2\u03d8\u03d9\t\t\2\2\u03d9\u03da\7j\2\2\u03da"+
		"\u008b\3\2\2\2\u03db\u03ea\5\u008eH\2\u03dc\u03ea\7j\2\2\u03dd\u03de\7"+
		"\20\2\2\u03de\u03df\5V,\2\u03df\u03e0\7\21\2\2\u03e0\u03ea\3\2\2\2\u03e1"+
		"\u03ea\5\u0094K\2\u03e2\u03ea\5\u0096L\2\u03e3\u03ea\5\u009aN\2\u03e4"+
		"\u03ea\5\u009cO\2\u03e5\u03ea\5\u009eP\2\u03e6\u03ea\5\u00a0Q\2\u03e7"+
		"\u03ea\5\u00a4S\2\u03e8\u03ea\5\u00a6T\2\u03e9\u03db\3\2\2\2\u03e9\u03dc"+
		"\3\2\2\2\u03e9\u03dd\3\2\2\2\u03e9\u03e1\3\2\2\2\u03e9\u03e2\3\2\2\2\u03e9"+
		"\u03e3\3\2\2\2\u03e9\u03e4\3\2\2\2\u03e9\u03e5\3\2\2\2\u03e9\u03e6\3\2"+
		"\2\2\u03e9\u03e7\3\2\2\2\u03e9\u03e8\3\2\2\2\u03ea\u008d\3\2\2\2\u03eb"+
		"\u03ec\t\n\2\2\u03ec\u008f\3\2\2\2\u03ed\u03f2\5\u0092J\2\u03ee\u03ef"+
		"\7\7\2\2\u03ef\u03f1\5\u0092J\2\u03f0\u03ee\3\2\2\2\u03f1\u03f4\3\2\2"+
		"\2\u03f2\u03f0\3\2\2\2\u03f2\u03f3\3\2\2\2\u03f3\u0091\3\2\2\2\u03f4\u03f2"+
		"\3\2\2\2\u03f5\u03fa\5V,\2\u03f6\u03f7\7j\2\2\u03f7\u03f8\t\13\2\2\u03f8"+
		"\u03fa\5V,\2\u03f9\u03f5\3\2\2\2\u03f9\u03f6\3\2\2\2\u03fa\u0093\3\2\2"+
		"\2\u03fb\u03fc\7_\2\2\u03fc\u0413\7`\2\2\u03fd\u03fe\7_\2\2\u03fe\u0403"+
		"\5V,\2\u03ff\u0400\7\7\2\2\u0400\u0402\5V,\2\u0401\u03ff\3\2\2\2\u0402"+
		"\u0405\3\2\2\2\u0403\u0401\3\2\2\2\u0403\u0404\3\2\2\2\u0404\u0406\3\2"+
		"\2\2\u0405\u0403\3\2\2\2\u0406\u0407\7`\2\2\u0407\u0413\3\2\2\2\u0408"+
		"\u0409\7_\2\2\u0409\u040a\5V,\2\u040a\u040c\7+\2\2\u040b\u040d\5\u00a2"+
		"R\2\u040c\u040b\3\2\2\2\u040d\u040e\3\2\2\2\u040e\u040c\3\2\2\2\u040e"+
		"\u040f\3\2\2\2\u040f\u0410\3\2\2\2\u0410\u0411\7`\2\2\u0411\u0413\3\2"+
		"\2\2\u0412\u03fb\3\2\2\2\u0412\u03fd\3\2\2\2\u0412\u0408\3\2\2\2\u0413"+
		"\u0095\3\2\2\2\u0414\u0415\7\22\2\2\u0415\u042c\7\23\2\2\u0416\u0417\7"+
		"\22\2\2\u0417\u041c\5\u0098M\2\u0418\u0419\7\7\2\2\u0419\u041b\5\u0098"+
		"M\2\u041a\u0418\3\2\2\2\u041b\u041e\3\2\2\2\u041c\u041a\3\2\2\2\u041c"+
		"\u041d\3\2\2\2\u041d\u041f\3\2\2\2\u041e\u041c\3\2\2\2\u041f\u0420\7\23"+
		"\2\2\u0420\u042c\3\2\2\2\u0421\u0422\7\22\2\2\u0422\u0423\5\u0098M\2\u0423"+
		"\u0425\7+\2\2\u0424\u0426\5\u00a2R\2\u0425\u0424\3\2\2\2\u0426\u0427\3"+
		"\2\2\2\u0427\u0425\3\2\2\2\u0427\u0428\3\2\2\2\u0428\u0429\3\2\2\2\u0429"+
		"\u042a\7\23\2\2\u042a\u042c\3\2\2\2\u042b\u0414\3\2\2\2\u042b\u0416\3"+
		"\2\2\2\u042b\u0421\3\2\2\2\u042c\u0097\3\2\2\2\u042d\u042e\5V,\2\u042e"+
		"\u042f\7G\2\2\u042f\u0430\5V,\2\u0430\u0099\3\2\2\2\u0431\u0432\7\22\2"+
		"\2\u0432\u0435\5V,\2\u0433\u0434\7\7\2\2\u0434\u0436\5V,\2\u0435\u0433"+
		"\3\2\2\2\u0436\u0437\3\2\2\2\u0437\u0435\3\2\2\2\u0437\u0438\3\2\2\2\u0438"+
		"\u0439\3\2\2\2\u0439\u043a\7\23\2\2\u043a\u0446\3\2\2\2\u043b\u043c\7"+
		"\22\2\2\u043c\u043d\5V,\2\u043d\u043f\7+\2\2\u043e\u0440\5\u00a2R\2\u043f"+
		"\u043e\3\2\2\2\u0440\u0441\3\2\2\2\u0441\u043f\3\2\2\2\u0441\u0442\3\2"+
		"\2\2\u0442\u0443\3\2\2\2\u0443\u0444\7\23\2\2\u0444\u0446\3\2\2\2\u0445"+
		"\u0431\3\2\2\2\u0445\u043b\3\2\2\2\u0446\u009b\3\2\2\2\u0447\u0448\7\20"+
		"\2\2\u0448\u0455\7\21\2\2\u0449\u044a\7\20\2\2\u044a\u044f\5V,\2\u044b"+
		"\u044c\7\7\2\2\u044c\u044e\5V,\2\u044d\u044b\3\2\2\2\u044e\u0451\3\2\2"+
		"\2\u044f\u044d\3\2\2\2\u044f\u0450\3\2\2\2\u0450\u0452\3\2\2\2\u0451\u044f"+
		"\3\2\2\2\u0452\u0453\7\21\2\2\u0453\u0455\3\2\2\2\u0454\u0447\3\2\2\2"+
		"\u0454\u0449\3\2\2\2\u0455\u009d\3\2\2\2\u0456\u0458\7\20\2\2\u0457\u0459"+
		"\5\24\13\2\u0458\u0457\3\2\2\2\u0458\u0459\3\2\2\2\u0459\u045a\3\2\2\2"+
		"\u045a\u045b\7\21\2\2\u045b\u0465\7h\2\2\u045c\u0466\5V,\2\u045d\u0461"+
		"\7\22\2\2\u045e\u0460\5.\30\2\u045f\u045e\3\2\2\2\u0460\u0463\3\2\2\2"+
		"\u0461\u045f\3\2\2\2\u0461\u0462\3\2\2\2\u0462\u0464\3\2\2\2\u0463\u0461"+
		"\3\2\2\2\u0464\u0466\7\23\2\2\u0465\u045c\3\2\2\2\u0465\u045d\3\2\2\2"+
		"\u0466\u009f\3\2\2\2\u0467\u0468\7_\2\2\u0468\u0469\5V,\2\u0469\u046b"+
		"\7+\2\2\u046a\u046c\5\u00a2R\2\u046b\u046a\3\2\2\2\u046c\u046d\3\2\2\2"+
		"\u046d\u046b\3\2\2\2\u046d\u046e\3\2\2\2\u046e\u046f\3\2\2\2\u046f\u0470"+
		"\7`\2\2\u0470\u047c\3\2\2\2\u0471\u0472\7\22\2\2\u0472\u0473\5V,\2\u0473"+
		"\u0475\7+\2\2\u0474\u0476\5\u00a2R\2\u0475\u0474\3\2\2\2\u0476\u0477\3"+
		"\2\2\2\u0477\u0475\3\2\2\2\u0477\u0478\3\2\2\2\u0478\u0479\3\2\2\2\u0479"+
		"\u047a\7\23\2\2\u047a\u047c\3\2\2\2\u047b\u0467\3\2\2\2\u047b\u0471\3"+
		"\2\2\2\u047c\u00a1\3\2\2\2\u047d\u047e\7+\2\2\u047e\u047f\5\u00a8U\2\u047f"+
		"\u0480\7,\2\2\u0480\u0485\5V,\2\u0481\u0482\7%\2\2\u0482\u0484\5V,\2\u0483"+
		"\u0481\3\2\2\2\u0484\u0487\3\2\2\2\u0485\u0483\3\2\2\2\u0485\u0486\3\2"+
		"\2\2\u0486\u00a3\3\2\2\2\u0487\u0485\3\2\2\2\u0488\u0489\7\66\2\2\u0489"+
		"\u048a\5V,\2\u048a\u048c\7\22\2\2\u048b\u048d\5R*\2\u048c\u048b\3\2\2"+
		"\2\u048d\u048e\3\2\2\2\u048e\u048c\3\2\2\2\u048e\u048f\3\2\2\2\u048f\u0490"+
		"\3\2\2\2\u0490\u0491\7\23\2\2\u0491\u00a5\3\2\2\2\u0492\u0496\7\22\2\2"+
		"\u0493\u0495\5.\30\2\u0494\u0493\3\2\2\2\u0495\u0498\3\2\2\2\u0496\u0494"+
		"\3\2\2\2\u0496\u0497\3\2\2\2\u0497\u0499\3\2\2\2\u0498\u0496\3\2\2\2\u0499"+
		"\u049a\7\23\2\2\u049a\u00a7\3\2\2\2\u049b\u049c\5\u00aaV\2\u049c\u00a9"+
		"\3\2\2\2\u049d\u04a2\5\u00acW\2\u049e\u049f\7L\2\2\u049f\u04a1\5\u00ac"+
		"W\2\u04a0\u049e\3\2\2\2\u04a1\u04a4\3\2\2\2\u04a2\u04a0\3\2\2\2\u04a2"+
		"\u04a3\3\2\2\2\u04a3\u00ab\3\2\2\2\u04a4\u04a2\3\2\2\2\u04a5\u04a8\5\u00ae"+
		"X\2\u04a6\u04a7\7\4\2\2\u04a7\u04a9\7j\2\2\u04a8\u04a6\3\2\2\2\u04a8\u04a9"+
		"\3\2\2\2\u04a9\u00ad\3\2\2\2\u04aa\u04ab\7j\2\2\u04ab\u04ad\7\20\2\2\u04ac"+
		"\u04ae\5\u00b0Y\2\u04ad\u04ac\3\2\2\2\u04ad\u04ae\3\2\2\2\u04ae\u04af"+
		"\3\2\2\2\u04af\u04be\7\21\2\2\u04b0\u04b2\7_\2\2\u04b1\u04b3\5\u00b0Y"+
		"\2\u04b2\u04b1\3\2\2\2\u04b2\u04b3\3\2\2\2\u04b3\u04b4\3\2\2\2\u04b4\u04be"+
		"\7`\2\2\u04b5\u04b7\7\22\2\2\u04b6\u04b8\5\u00b2Z\2\u04b7\u04b6\3\2\2"+
		"\2\u04b7\u04b8\3\2\2\2\u04b8\u04b9\3\2\2\2\u04b9\u04be\7\23\2\2\u04ba"+
		"\u04be\5\u008eH\2\u04bb\u04be\7j\2\2\u04bc\u04be\7i\2\2\u04bd\u04aa\3"+
		"\2\2\2\u04bd\u04b0\3\2\2\2\u04bd\u04b5\3\2\2\2\u04bd\u04ba\3\2\2\2\u04bd"+
		"\u04bb\3\2\2\2\u04bd\u04bc\3\2\2\2\u04be\u00af\3\2\2\2\u04bf\u04c4\5\u00a8"+
		"U\2\u04c0\u04c1\7\7\2\2\u04c1\u04c3\5\u00a8U\2\u04c2\u04c0\3\2\2\2\u04c3"+
		"\u04c6\3\2\2\2\u04c4\u04c2\3\2\2\2\u04c4\u04c5\3\2\2\2\u04c5\u04ca\3\2"+
		"\2\2\u04c6\u04c4\3\2\2\2\u04c7\u04c8\7\7\2\2\u04c8\u04c9\7\b\2\2\u04c9"+
		"\u04cb\7j\2\2\u04ca\u04c7\3\2\2\2\u04ca\u04cb\3\2\2\2\u04cb\u00b1\3\2"+
		"\2\2\u04cc\u04d1\5\u00b4[\2\u04cd\u04ce\7\7\2\2\u04ce\u04d0\5\u00b4[\2"+
		"\u04cf\u04cd\3\2\2\2\u04d0\u04d3\3\2\2\2\u04d1\u04cf\3\2\2\2\u04d1\u04d2"+
		"\3\2\2\2\u04d2\u00b3\3\2\2\2\u04d3\u04d1\3\2\2\2\u04d4\u04d7\7j\2\2\u04d5"+
		"\u04d6\7G\2\2\u04d6\u04d8\5\u00a8U\2\u04d7\u04d5\3\2\2\2\u04d7\u04d8\3"+
		"\2\2\2\u04d8\u00b5\3\2\2\2\u04d9\u04da\5\u00b8]\2\u04da\u00b7\3\2\2\2"+
		"\u04db\u04e0\5\u00ba^\2\u04dc\u04dd\7L\2\2\u04dd\u04df\5\u00ba^\2\u04de"+
		"\u04dc\3\2\2\2\u04df\u04e2\3\2\2\2\u04e0\u04de\3\2\2\2\u04e0\u04e1\3\2"+
		"\2\2\u04e1\u00b9\3\2\2\2\u04e2\u04e0\3\2\2\2\u04e3\u04e5\7j\2\2\u04e4"+
		"\u04e6\5\u00bc_\2\u04e5\u04e4\3\2\2\2\u04e5\u04e6\3\2\2\2\u04e6\u04e8"+
		"\3\2\2\2\u04e7\u04e9\7F\2\2\u04e8\u04e7\3\2\2\2\u04e8\u04e9\3\2\2\2\u04e9"+
		"\u0507\3\2\2\2\u04ea\u04eb\7\20\2\2\u04eb\u04f0\5\u00b6\\\2\u04ec\u04ed"+
		"\7\7\2\2\u04ed\u04ef\5\u00b6\\\2\u04ee\u04ec\3\2\2\2\u04ef\u04f2\3\2\2"+
		"\2\u04f0\u04ee\3\2\2\2\u04f0\u04f1\3\2\2\2\u04f1\u04f3\3\2\2\2\u04f2\u04f0"+
		"\3\2\2\2\u04f3\u04f4\7\21\2\2\u04f4\u04f5\7\27\2\2\u04f5\u04f6\5\u00b6"+
		"\\\2\u04f6\u0507\3\2\2\2\u04f7\u04f8\7_\2\2\u04f8\u04f9\5\u00b6\\\2\u04f9"+
		"\u04fa\7`\2\2\u04fa\u0507\3\2\2\2\u04fb\u04fc\7_\2\2\u04fc\u04fd\5\u00b6"+
		"\\\2\u04fd\u04fe\7\7\2\2\u04fe\u04ff\5\u00b6\\\2\u04ff\u0500\7`\2\2\u0500"+
		"\u0507\3\2\2\2\u0501\u0503\7\22\2\2\u0502\u0504\5\u00be`\2\u0503\u0502"+
		"\3\2\2\2\u0503\u0504\3\2\2\2\u0504\u0505\3\2\2\2\u0505\u0507\7\23\2\2"+
		"\u0506\u04e3\3\2\2\2\u0506\u04ea\3\2\2\2\u0506\u04f7\3\2\2\2\u0506\u04fb"+
		"\3\2\2\2\u0506\u0501\3\2\2\2\u0507\u00bb\3\2\2\2\u0508\u0509\7\24\2\2"+
		"\u0509\u050e\5\u00b6\\\2\u050a\u050b\7\7\2\2\u050b\u050d\5\u00b6\\\2\u050c"+
		"\u050a\3\2\2\2\u050d\u0510\3\2\2\2\u050e\u050c\3\2\2\2\u050e\u050f\3\2"+
		"\2\2\u050f\u0511\3\2\2\2\u0510\u050e\3\2\2\2\u0511\u0512\7\25\2\2\u0512"+
		"\u00bd\3\2\2\2\u0513\u0518\5\u00c0a\2\u0514\u0515\7\7\2\2\u0515\u0517"+
		"\5\u00c0a\2\u0516\u0514\3\2\2\2\u0517\u051a\3\2\2\2\u0518\u0516\3\2\2"+
		"\2\u0518\u0519\3\2\2\2\u0519\u00bf\3\2\2\2\u051a\u0518\3\2\2\2\u051b\u051c"+
		"\7j\2\2\u051c\u051d\7G\2\2\u051d\u051e\5\u00b6\\\2\u051e\u00c1\3\2\2\2"+
		"\u009b\u00c5\u00c7\u00d0\u00d7\u00de\u00e6\u00ea\u00ed\u00f6\u00fa\u00fe"+
		"\u0102\u0109\u0112\u0116\u011b\u011f\u0123\u0129\u012f\u0137\u0141\u0146"+
		"\u014a\u0151\u0159\u015f\u0163\u016b\u016e\u0174\u017b\u017f\u0183\u0187"+
		"\u018b\u0191\u0195\u019b\u01a1\u01ab\u01b1\u01b7\u01bc\u01c2\u01cb\u01cf"+
		"\u01da\u01dd\u01e2\u01ee\u01f4\u01f8\u01fb\u0201\u0204\u021c\u0222\u022f"+
		"\u023a\u0241\u0249\u024d\u0255\u025e\u0262\u026b\u0276\u0281\u028c\u0292"+
		"\u029c\u02a9\u02b2\u02bc\u02c3\u02cb\u02cf\u02d4\u02d7\u02df\u02e6\u02ee"+
		"\u02f6\u02fe\u0304\u030d\u031a\u0324\u032d\u0334\u033c\u0344\u034c\u0354"+
		"\u035c\u0364\u036c\u0374\u037c\u0386\u0389\u0390\u0398\u03a0\u03a8\u03ae"+
		"\u03b5\u03be\u03c0\u03c5\u03d6\u03e9\u03f2\u03f9\u0403\u040e\u0412\u041c"+
		"\u0427\u042b\u0437\u0441\u0445\u044f\u0454\u0458\u0461\u0465\u046d\u0477"+
		"\u047b\u0485\u048e\u0496\u04a2\u04a8\u04ad\u04b2\u04b7\u04bd\u04c4\u04ca"+
		"\u04d1\u04d7\u04e0\u04e5\u04e8\u04f0\u0503\u0506\u050e\u0518";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}