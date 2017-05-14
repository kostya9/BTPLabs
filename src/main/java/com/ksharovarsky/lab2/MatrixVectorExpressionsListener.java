// Generated from C:/Users/kostya/IdeaProjects/BTPLabs/src/com/ksharovarsky/lab2\MatrixVectorExpressions.g4 by ANTLR 4.6
package com.ksharovarsky.lab2;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MatrixVectorExpressionsParser}.
 */
public interface MatrixVectorExpressionsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MatrixVectorExpressionsParser#start_rule}.
	 * @param ctx the parse tree
	 */
	void enterStart_rule(MatrixVectorExpressionsParser.Start_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatrixVectorExpressionsParser#start_rule}.
	 * @param ctx the parse tree
	 */
	void exitStart_rule(MatrixVectorExpressionsParser.Start_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatrixVectorExpressionsParser#end_expression}.
	 * @param ctx the parse tree
	 */
	void enterEnd_expression(MatrixVectorExpressionsParser.End_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatrixVectorExpressionsParser#end_expression}.
	 * @param ctx the parse tree
	 */
	void exitEnd_expression(MatrixVectorExpressionsParser.End_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatrixVectorExpressionsParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(MatrixVectorExpressionsParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatrixVectorExpressionsParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(MatrixVectorExpressionsParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatrixVectorExpressionsParser#expression_high}.
	 * @param ctx the parse tree
	 */
	void enterExpression_high(MatrixVectorExpressionsParser.Expression_highContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatrixVectorExpressionsParser#expression_high}.
	 * @param ctx the parse tree
	 */
	void exitExpression_high(MatrixVectorExpressionsParser.Expression_highContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatrixVectorExpressionsParser#absolute}.
	 * @param ctx the parse tree
	 */
	void enterAbsolute(MatrixVectorExpressionsParser.AbsoluteContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatrixVectorExpressionsParser#absolute}.
	 * @param ctx the parse tree
	 */
	void exitAbsolute(MatrixVectorExpressionsParser.AbsoluteContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatrixVectorExpressionsParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterOperation(MatrixVectorExpressionsParser.OperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatrixVectorExpressionsParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitOperation(MatrixVectorExpressionsParser.OperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryE}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryE(MatrixVectorExpressionsParser.BinaryEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryE}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryE(MatrixVectorExpressionsParser.BinaryEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryBeforeE}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryBeforeE(MatrixVectorExpressionsParser.UnaryBeforeEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryBeforeE}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryBeforeE(MatrixVectorExpressionsParser.UnaryBeforeEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HighOrderE}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterHighOrderE(MatrixVectorExpressionsParser.HighOrderEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HighOrderE}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitHighOrderE(MatrixVectorExpressionsParser.HighOrderEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumberE}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumberE(MatrixVectorExpressionsParser.NumberEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumberE}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumberE(MatrixVectorExpressionsParser.NumberEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VectorE}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVectorE(MatrixVectorExpressionsParser.VectorEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VectorE}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVectorE(MatrixVectorExpressionsParser.VectorEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixE}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixE(MatrixVectorExpressionsParser.MatrixEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixE}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixE(MatrixVectorExpressionsParser.MatrixEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryAfterE}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryAfterE(MatrixVectorExpressionsParser.UnaryAfterEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryAfterE}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryAfterE(MatrixVectorExpressionsParser.UnaryAfterEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AbsoluteE}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAbsoluteE(MatrixVectorExpressionsParser.AbsoluteEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AbsoluteE}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAbsoluteE(MatrixVectorExpressionsParser.AbsoluteEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionE}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionE(MatrixVectorExpressionsParser.FunctionEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionE}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionE(MatrixVectorExpressionsParser.FunctionEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableE}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVariableE(MatrixVectorExpressionsParser.VariableEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableE}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVariableE(MatrixVectorExpressionsParser.VariableEContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatrixVectorExpressionsParser#matrix}.
	 * @param ctx the parse tree
	 */
	void enterMatrix(MatrixVectorExpressionsParser.MatrixContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatrixVectorExpressionsParser#matrix}.
	 * @param ctx the parse tree
	 */
	void exitMatrix(MatrixVectorExpressionsParser.MatrixContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatrixVectorExpressionsParser#vector}.
	 * @param ctx the parse tree
	 */
	void enterVector(MatrixVectorExpressionsParser.VectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatrixVectorExpressionsParser#vector}.
	 * @param ctx the parse tree
	 */
	void exitVector(MatrixVectorExpressionsParser.VectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatrixVectorExpressionsParser#vector_sequence}.
	 * @param ctx the parse tree
	 */
	void enterVector_sequence(MatrixVectorExpressionsParser.Vector_sequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatrixVectorExpressionsParser#vector_sequence}.
	 * @param ctx the parse tree
	 */
	void exitVector_sequence(MatrixVectorExpressionsParser.Vector_sequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatrixVectorExpressionsParser#expression_sequence}.
	 * @param ctx the parse tree
	 */
	void enterExpression_sequence(MatrixVectorExpressionsParser.Expression_sequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatrixVectorExpressionsParser#expression_sequence}.
	 * @param ctx the parse tree
	 */
	void exitExpression_sequence(MatrixVectorExpressionsParser.Expression_sequenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Inverse}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#operator_unary_after}.
	 * @param ctx the parse tree
	 */
	void enterInverse(MatrixVectorExpressionsParser.InverseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Inverse}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#operator_unary_after}.
	 * @param ctx the parse tree
	 */
	void exitInverse(MatrixVectorExpressionsParser.InverseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Transpose}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#operator_unary_after}.
	 * @param ctx the parse tree
	 */
	void enterTranspose(MatrixVectorExpressionsParser.TransposeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Transpose}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#operator_unary_after}.
	 * @param ctx the parse tree
	 */
	void exitTranspose(MatrixVectorExpressionsParser.TransposeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryPlus}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#operator_unary_before}.
	 * @param ctx the parse tree
	 */
	void enterUnaryPlus(MatrixVectorExpressionsParser.UnaryPlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryPlus}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#operator_unary_before}.
	 * @param ctx the parse tree
	 */
	void exitUnaryPlus(MatrixVectorExpressionsParser.UnaryPlusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryMinus}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#operator_unary_before}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinus(MatrixVectorExpressionsParser.UnaryMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryMinus}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#operator_unary_before}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinus(MatrixVectorExpressionsParser.UnaryMinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryPlus}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#binary_low_operator}.
	 * @param ctx the parse tree
	 */
	void enterBinaryPlus(MatrixVectorExpressionsParser.BinaryPlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryPlus}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#binary_low_operator}.
	 * @param ctx the parse tree
	 */
	void exitBinaryPlus(MatrixVectorExpressionsParser.BinaryPlusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryMinus}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#binary_low_operator}.
	 * @param ctx the parse tree
	 */
	void enterBinaryMinus(MatrixVectorExpressionsParser.BinaryMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryMinus}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#binary_low_operator}.
	 * @param ctx the parse tree
	 */
	void exitBinaryMinus(MatrixVectorExpressionsParser.BinaryMinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Multiply}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#binary_high_operator}.
	 * @param ctx the parse tree
	 */
	void enterMultiply(MatrixVectorExpressionsParser.MultiplyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Multiply}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#binary_high_operator}.
	 * @param ctx the parse tree
	 */
	void exitMultiply(MatrixVectorExpressionsParser.MultiplyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Divide}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#binary_high_operator}.
	 * @param ctx the parse tree
	 */
	void enterDivide(MatrixVectorExpressionsParser.DivideContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Divide}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#binary_high_operator}.
	 * @param ctx the parse tree
	 */
	void exitDivide(MatrixVectorExpressionsParser.DivideContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Equals}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#binary_high_operator}.
	 * @param ctx the parse tree
	 */
	void enterEquals(MatrixVectorExpressionsParser.EqualsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Equals}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#binary_high_operator}.
	 * @param ctx the parse tree
	 */
	void exitEquals(MatrixVectorExpressionsParser.EqualsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatrixVectorExpressionsParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(MatrixVectorExpressionsParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatrixVectorExpressionsParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(MatrixVectorExpressionsParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatrixVectorExpressionsParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(MatrixVectorExpressionsParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatrixVectorExpressionsParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(MatrixVectorExpressionsParser.VariableContext ctx);
}