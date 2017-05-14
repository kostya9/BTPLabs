// Generated from C:/Users/kostya/IdeaProjects/BTPLabs/src/com/ksharovarsky/lab2\MatrixVectorExpressions.g4 by ANTLR 4.6
package com.ksharovarsky.lab2;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MatrixVectorExpressionsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, NAME=16, NUMBER=17, 
		DIGIT=18, WHITESPACE=19;
	public static final int
		RULE_start_rule = 0, RULE_end_expression = 1, RULE_assignment = 2, RULE_expression_high = 3, 
		RULE_absolute = 4, RULE_operation = 5, RULE_expression = 6, RULE_matrix = 7, 
		RULE_vector = 8, RULE_vector_sequence = 9, RULE_expression_sequence = 10, 
		RULE_operator_unary_after = 11, RULE_operator_unary_before = 12, RULE_binary_low_operator = 13, 
		RULE_binary_high_operator = 14, RULE_function = 15, RULE_variable = 16;
	public static final String[] ruleNames = {
		"start_rule", "end_expression", "assignment", "expression_high", "absolute", 
		"operation", "expression", "matrix", "vector", "vector_sequence", "expression_sequence", 
		"operator_unary_after", "operator_unary_before", "binary_low_operator", 
		"binary_high_operator", "function", "variable"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'='", "'('", "')'", "'|'", "'['", "']'", "','", "'^1'", 
		"'^T'", "'+'", "'-'", "'*'", "'/'", "'=='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "NAME", "NUMBER", "DIGIT", "WHITESPACE"
	};
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
	public String getGrammarFileName() { return "MatrixVectorExpressions.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MatrixVectorExpressionsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class Start_ruleContext extends ParserRuleContext {
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MatrixVectorExpressionsParser.EOF, 0); }
		public List<End_expressionContext> end_expression() {
			return getRuleContexts(End_expressionContext.class);
		}
		public End_expressionContext end_expression(int i) {
			return getRuleContext(End_expressionContext.class,i);
		}
		public Start_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).enterStart_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).exitStart_rule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVectorExpressionsVisitor ) return ((MatrixVectorExpressionsVisitor<? extends T>)visitor).visitStart_rule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Start_ruleContext start_rule() throws RecognitionException {
		Start_ruleContext _localctx = new Start_ruleContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start_rule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			operation();
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(35);
				end_expression();
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41);
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

	public static class End_expressionContext extends ParserRuleContext {
		public End_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_end_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).enterEnd_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).exitEnd_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVectorExpressionsVisitor ) return ((MatrixVectorExpressionsVisitor<? extends T>)visitor).visitEnd_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final End_expressionContext end_expression() throws RecognitionException {
		End_expressionContext _localctx = new End_expressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_end_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(T__0);
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
		public TerminalNode NAME() { return getToken(MatrixVectorExpressionsParser.NAME, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVectorExpressionsVisitor ) return ((MatrixVectorExpressionsVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(NAME);
			setState(46);
			match(T__1);
			setState(47);
			operation();
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

	public static class Expression_highContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Expression_highContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression_high; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).enterExpression_high(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).exitExpression_high(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVectorExpressionsVisitor ) return ((MatrixVectorExpressionsVisitor<? extends T>)visitor).visitExpression_high(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expression_highContext expression_high() throws RecognitionException {
		Expression_highContext _localctx = new Expression_highContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expression_high);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(T__2);
			setState(50);
			expression(0);
			setState(51);
			match(T__3);
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

	public static class AbsoluteContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AbsoluteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_absolute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).enterAbsolute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).exitAbsolute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVectorExpressionsVisitor ) return ((MatrixVectorExpressionsVisitor<? extends T>)visitor).visitAbsolute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AbsoluteContext absolute() throws RecognitionException {
		AbsoluteContext _localctx = new AbsoluteContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_absolute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(T__4);
			setState(54);
			expression(0);
			setState(55);
			match(T__4);
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

	public static class OperationContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public OperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).enterOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).exitOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVectorExpressionsVisitor ) return ((MatrixVectorExpressionsVisitor<? extends T>)visitor).visitOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperationContext operation() throws RecognitionException {
		OperationContext _localctx = new OperationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_operation);
		try {
			setState(59);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				expression(0);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BinaryEContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Binary_high_operatorContext binary_high_operator() {
			return getRuleContext(Binary_high_operatorContext.class,0);
		}
		public Binary_low_operatorContext binary_low_operator() {
			return getRuleContext(Binary_low_operatorContext.class,0);
		}
		public BinaryEContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).enterBinaryE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).exitBinaryE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVectorExpressionsVisitor ) return ((MatrixVectorExpressionsVisitor<? extends T>)visitor).visitBinaryE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryBeforeEContext extends ExpressionContext {
		public Operator_unary_beforeContext operator_unary_before() {
			return getRuleContext(Operator_unary_beforeContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnaryBeforeEContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).enterUnaryBeforeE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).exitUnaryBeforeE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVectorExpressionsVisitor ) return ((MatrixVectorExpressionsVisitor<? extends T>)visitor).visitUnaryBeforeE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class HighOrderEContext extends ExpressionContext {
		public Expression_highContext expression_high() {
			return getRuleContext(Expression_highContext.class,0);
		}
		public HighOrderEContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).enterHighOrderE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).exitHighOrderE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVectorExpressionsVisitor ) return ((MatrixVectorExpressionsVisitor<? extends T>)visitor).visitHighOrderE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberEContext extends ExpressionContext {
		public TerminalNode NUMBER() { return getToken(MatrixVectorExpressionsParser.NUMBER, 0); }
		public NumberEContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).enterNumberE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).exitNumberE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVectorExpressionsVisitor ) return ((MatrixVectorExpressionsVisitor<? extends T>)visitor).visitNumberE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VectorEContext extends ExpressionContext {
		public VectorContext vector() {
			return getRuleContext(VectorContext.class,0);
		}
		public VectorEContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).enterVectorE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).exitVectorE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVectorExpressionsVisitor ) return ((MatrixVectorExpressionsVisitor<? extends T>)visitor).visitVectorE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MatrixEContext extends ExpressionContext {
		public MatrixContext matrix() {
			return getRuleContext(MatrixContext.class,0);
		}
		public MatrixEContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).enterMatrixE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).exitMatrixE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVectorExpressionsVisitor ) return ((MatrixVectorExpressionsVisitor<? extends T>)visitor).visitMatrixE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryAfterEContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Operator_unary_afterContext operator_unary_after() {
			return getRuleContext(Operator_unary_afterContext.class,0);
		}
		public UnaryAfterEContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).enterUnaryAfterE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).exitUnaryAfterE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVectorExpressionsVisitor ) return ((MatrixVectorExpressionsVisitor<? extends T>)visitor).visitUnaryAfterE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AbsoluteEContext extends ExpressionContext {
		public AbsoluteContext absolute() {
			return getRuleContext(AbsoluteContext.class,0);
		}
		public AbsoluteEContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).enterAbsoluteE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).exitAbsoluteE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVectorExpressionsVisitor ) return ((MatrixVectorExpressionsVisitor<? extends T>)visitor).visitAbsoluteE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionEContext extends ExpressionContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public Expression_highContext expression_high() {
			return getRuleContext(Expression_highContext.class,0);
		}
		public FunctionEContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).enterFunctionE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).exitFunctionE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVectorExpressionsVisitor ) return ((MatrixVectorExpressionsVisitor<? extends T>)visitor).visitFunctionE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableEContext extends ExpressionContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public VariableEContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).enterVariableE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).exitVariableE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVectorExpressionsVisitor ) return ((MatrixVectorExpressionsVisitor<? extends T>)visitor).visitVariableE(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				_localctx = new HighOrderEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(62);
				expression_high();
				}
				break;
			case 2:
				{
				_localctx = new AbsoluteEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(63);
				absolute();
				}
				break;
			case 3:
				{
				_localctx = new FunctionEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(64);
				function();
				setState(65);
				expression_high();
				}
				break;
			case 4:
				{
				_localctx = new UnaryBeforeEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(67);
				operator_unary_before();
				setState(68);
				expression(8);
				}
				break;
			case 5:
				{
				_localctx = new VariableEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(70);
				variable();
				}
				break;
			case 6:
				{
				_localctx = new MatrixEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(71);
				matrix();
				}
				break;
			case 7:
				{
				_localctx = new VectorEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(72);
				vector();
				}
				break;
			case 8:
				{
				_localctx = new NumberEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(73);
				match(NUMBER);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(88);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(86);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryEContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(76);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(77);
						binary_high_operator();
						setState(78);
						expression(7);
						}
						break;
					case 2:
						{
						_localctx = new BinaryEContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(80);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(81);
						binary_low_operator();
						setState(82);
						expression(6);
						}
						break;
					case 3:
						{
						_localctx = new UnaryAfterEContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(84);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(85);
						operator_unary_after();
						}
						break;
					}
					} 
				}
				setState(90);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MatrixContext extends ParserRuleContext {
		public Vector_sequenceContext vector_sequence() {
			return getRuleContext(Vector_sequenceContext.class,0);
		}
		public MatrixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matrix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).enterMatrix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).exitMatrix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVectorExpressionsVisitor ) return ((MatrixVectorExpressionsVisitor<? extends T>)visitor).visitMatrix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatrixContext matrix() throws RecognitionException {
		MatrixContext _localctx = new MatrixContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_matrix);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(T__5);
			setState(92);
			vector_sequence();
			setState(93);
			match(T__6);
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

	public static class VectorContext extends ParserRuleContext {
		public Expression_sequenceContext expression_sequence() {
			return getRuleContext(Expression_sequenceContext.class,0);
		}
		public VectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).enterVector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).exitVector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVectorExpressionsVisitor ) return ((MatrixVectorExpressionsVisitor<? extends T>)visitor).visitVector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VectorContext vector() throws RecognitionException {
		VectorContext _localctx = new VectorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_vector);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(T__5);
			setState(96);
			expression_sequence();
			setState(97);
			match(T__6);
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

	public static class Vector_sequenceContext extends ParserRuleContext {
		public List<VectorContext> vector() {
			return getRuleContexts(VectorContext.class);
		}
		public VectorContext vector(int i) {
			return getRuleContext(VectorContext.class,i);
		}
		public Vector_sequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vector_sequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).enterVector_sequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).exitVector_sequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVectorExpressionsVisitor ) return ((MatrixVectorExpressionsVisitor<? extends T>)visitor).visitVector_sequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Vector_sequenceContext vector_sequence() throws RecognitionException {
		Vector_sequenceContext _localctx = new Vector_sequenceContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_vector_sequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			vector();
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(100);
				match(T__7);
				setState(101);
				vector();
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

	public static class Expression_sequenceContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Expression_sequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression_sequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).enterExpression_sequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).exitExpression_sequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVectorExpressionsVisitor ) return ((MatrixVectorExpressionsVisitor<? extends T>)visitor).visitExpression_sequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expression_sequenceContext expression_sequence() throws RecognitionException {
		Expression_sequenceContext _localctx = new Expression_sequenceContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expression_sequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			expression(0);
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(108);
				match(T__7);
				setState(109);
				expression(0);
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

	public static class Operator_unary_afterContext extends ParserRuleContext {
		public Operator_unary_afterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator_unary_after; }
	 
		public Operator_unary_afterContext() { }
		public void copyFrom(Operator_unary_afterContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InverseContext extends Operator_unary_afterContext {
		public InverseContext(Operator_unary_afterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).enterInverse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).exitInverse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVectorExpressionsVisitor ) return ((MatrixVectorExpressionsVisitor<? extends T>)visitor).visitInverse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TransposeContext extends Operator_unary_afterContext {
		public TransposeContext(Operator_unary_afterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).enterTranspose(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).exitTranspose(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVectorExpressionsVisitor ) return ((MatrixVectorExpressionsVisitor<? extends T>)visitor).visitTranspose(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Operator_unary_afterContext operator_unary_after() throws RecognitionException {
		Operator_unary_afterContext _localctx = new Operator_unary_afterContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_operator_unary_after);
		try {
			setState(117);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				_localctx = new InverseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				match(T__8);
				}
				break;
			case T__9:
				_localctx = new TransposeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
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

	public static class Operator_unary_beforeContext extends ParserRuleContext {
		public Operator_unary_beforeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator_unary_before; }
	 
		public Operator_unary_beforeContext() { }
		public void copyFrom(Operator_unary_beforeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UnaryPlusContext extends Operator_unary_beforeContext {
		public UnaryPlusContext(Operator_unary_beforeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).enterUnaryPlus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).exitUnaryPlus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVectorExpressionsVisitor ) return ((MatrixVectorExpressionsVisitor<? extends T>)visitor).visitUnaryPlus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryMinusContext extends Operator_unary_beforeContext {
		public UnaryMinusContext(Operator_unary_beforeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).enterUnaryMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).exitUnaryMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVectorExpressionsVisitor ) return ((MatrixVectorExpressionsVisitor<? extends T>)visitor).visitUnaryMinus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Operator_unary_beforeContext operator_unary_before() throws RecognitionException {
		Operator_unary_beforeContext _localctx = new Operator_unary_beforeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_operator_unary_before);
		try {
			setState(121);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				_localctx = new UnaryPlusContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				match(T__10);
				}
				break;
			case T__11:
				_localctx = new UnaryMinusContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				match(T__11);
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

	public static class Binary_low_operatorContext extends ParserRuleContext {
		public Binary_low_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_low_operator; }
	 
		public Binary_low_operatorContext() { }
		public void copyFrom(Binary_low_operatorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BinaryMinusContext extends Binary_low_operatorContext {
		public BinaryMinusContext(Binary_low_operatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).enterBinaryMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).exitBinaryMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVectorExpressionsVisitor ) return ((MatrixVectorExpressionsVisitor<? extends T>)visitor).visitBinaryMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryPlusContext extends Binary_low_operatorContext {
		public BinaryPlusContext(Binary_low_operatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).enterBinaryPlus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).exitBinaryPlus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVectorExpressionsVisitor ) return ((MatrixVectorExpressionsVisitor<? extends T>)visitor).visitBinaryPlus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Binary_low_operatorContext binary_low_operator() throws RecognitionException {
		Binary_low_operatorContext _localctx = new Binary_low_operatorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_binary_low_operator);
		try {
			setState(125);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				_localctx = new BinaryPlusContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				match(T__10);
				}
				break;
			case T__11:
				_localctx = new BinaryMinusContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				match(T__11);
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

	public static class Binary_high_operatorContext extends ParserRuleContext {
		public Binary_high_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_high_operator; }
	 
		public Binary_high_operatorContext() { }
		public void copyFrom(Binary_high_operatorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DivideContext extends Binary_high_operatorContext {
		public DivideContext(Binary_high_operatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).enterDivide(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).exitDivide(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVectorExpressionsVisitor ) return ((MatrixVectorExpressionsVisitor<? extends T>)visitor).visitDivide(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualsContext extends Binary_high_operatorContext {
		public EqualsContext(Binary_high_operatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).enterEquals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).exitEquals(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVectorExpressionsVisitor ) return ((MatrixVectorExpressionsVisitor<? extends T>)visitor).visitEquals(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiplyContext extends Binary_high_operatorContext {
		public MultiplyContext(Binary_high_operatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).enterMultiply(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).exitMultiply(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVectorExpressionsVisitor ) return ((MatrixVectorExpressionsVisitor<? extends T>)visitor).visitMultiply(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Binary_high_operatorContext binary_high_operator() throws RecognitionException {
		Binary_high_operatorContext _localctx = new Binary_high_operatorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_binary_high_operator);
		try {
			setState(130);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				_localctx = new MultiplyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				match(T__12);
				}
				break;
			case T__13:
				_localctx = new DivideContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				match(T__13);
				}
				break;
			case T__14:
				_localctx = new EqualsContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(129);
				match(T__14);
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

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(MatrixVectorExpressionsParser.NAME, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVectorExpressionsVisitor ) return ((MatrixVectorExpressionsVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(NAME);
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

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(MatrixVectorExpressionsParser.NAME, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixVectorExpressionsListener ) ((MatrixVectorExpressionsListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVectorExpressionsVisitor ) return ((MatrixVectorExpressionsVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(NAME);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\25\u008b\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\7\2\'\n\2\f\2\16\2*\13\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\5\7>\n\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bM\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\7\bY\n\b\f\b\16\b\\\13\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\7\13i\n\13\f\13\16\13l\13\13\3\f\3\f\3\f\7\fq\n\f\f\f\16\f"+
		"t\13\f\3\r\3\r\5\rx\n\r\3\16\3\16\5\16|\n\16\3\17\3\17\5\17\u0080\n\17"+
		"\3\20\3\20\3\20\5\20\u0085\n\20\3\21\3\21\3\22\3\22\3\22\2\3\16\23\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\2\u008c\2$\3\2\2\2\4-\3\2\2\2"+
		"\6/\3\2\2\2\b\63\3\2\2\2\n\67\3\2\2\2\f=\3\2\2\2\16L\3\2\2\2\20]\3\2\2"+
		"\2\22a\3\2\2\2\24e\3\2\2\2\26m\3\2\2\2\30w\3\2\2\2\32{\3\2\2\2\34\177"+
		"\3\2\2\2\36\u0084\3\2\2\2 \u0086\3\2\2\2\"\u0088\3\2\2\2$(\5\f\7\2%\'"+
		"\5\4\3\2&%\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)+\3\2\2\2*(\3\2\2\2"+
		"+,\7\2\2\3,\3\3\2\2\2-.\7\3\2\2.\5\3\2\2\2/\60\7\22\2\2\60\61\7\4\2\2"+
		"\61\62\5\f\7\2\62\7\3\2\2\2\63\64\7\5\2\2\64\65\5\16\b\2\65\66\7\6\2\2"+
		"\66\t\3\2\2\2\678\7\7\2\289\5\16\b\29:\7\7\2\2:\13\3\2\2\2;>\5\6\4\2<"+
		">\5\16\b\2=;\3\2\2\2=<\3\2\2\2>\r\3\2\2\2?@\b\b\1\2@M\5\b\5\2AM\5\n\6"+
		"\2BC\5 \21\2CD\5\b\5\2DM\3\2\2\2EF\5\32\16\2FG\5\16\b\nGM\3\2\2\2HM\5"+
		"\"\22\2IM\5\20\t\2JM\5\22\n\2KM\7\23\2\2L?\3\2\2\2LA\3\2\2\2LB\3\2\2\2"+
		"LE\3\2\2\2LH\3\2\2\2LI\3\2\2\2LJ\3\2\2\2LK\3\2\2\2MZ\3\2\2\2NO\f\b\2\2"+
		"OP\5\36\20\2PQ\5\16\b\tQY\3\2\2\2RS\f\7\2\2ST\5\34\17\2TU\5\16\b\bUY\3"+
		"\2\2\2VW\f\t\2\2WY\5\30\r\2XN\3\2\2\2XR\3\2\2\2XV\3\2\2\2Y\\\3\2\2\2Z"+
		"X\3\2\2\2Z[\3\2\2\2[\17\3\2\2\2\\Z\3\2\2\2]^\7\b\2\2^_\5\24\13\2_`\7\t"+
		"\2\2`\21\3\2\2\2ab\7\b\2\2bc\5\26\f\2cd\7\t\2\2d\23\3\2\2\2ej\5\22\n\2"+
		"fg\7\n\2\2gi\5\22\n\2hf\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2k\25\3\2"+
		"\2\2lj\3\2\2\2mr\5\16\b\2no\7\n\2\2oq\5\16\b\2pn\3\2\2\2qt\3\2\2\2rp\3"+
		"\2\2\2rs\3\2\2\2s\27\3\2\2\2tr\3\2\2\2ux\7\13\2\2vx\7\f\2\2wu\3\2\2\2"+
		"wv\3\2\2\2x\31\3\2\2\2y|\7\r\2\2z|\7\16\2\2{y\3\2\2\2{z\3\2\2\2|\33\3"+
		"\2\2\2}\u0080\7\r\2\2~\u0080\7\16\2\2\177}\3\2\2\2\177~\3\2\2\2\u0080"+
		"\35\3\2\2\2\u0081\u0085\7\17\2\2\u0082\u0085\7\20\2\2\u0083\u0085\7\21"+
		"\2\2\u0084\u0081\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0083\3\2\2\2\u0085"+
		"\37\3\2\2\2\u0086\u0087\7\22\2\2\u0087!\3\2\2\2\u0088\u0089\7\22\2\2\u0089"+
		"#\3\2\2\2\r(=LXZjrw{\177\u0084";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}