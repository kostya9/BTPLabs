// Generated from C:/Users/kostya/IdeaProjects/BTPLabs/src/com/ksharovarsky/lab2\MatrixVectorExpressions.g4 by ANTLR 4.6
package com.ksharovarsky.lab2;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MatrixVectorExpressionsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MatrixVectorExpressionsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MatrixVectorExpressionsParser#start_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart_rule(MatrixVectorExpressionsParser.Start_ruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MatrixVectorExpressionsParser#end_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnd_expression(MatrixVectorExpressionsParser.End_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MatrixVectorExpressionsParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(MatrixVectorExpressionsParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MatrixVectorExpressionsParser#expression_high}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_high(MatrixVectorExpressionsParser.Expression_highContext ctx);
	/**
	 * Visit a parse tree produced by {@link MatrixVectorExpressionsParser#absolute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbsolute(MatrixVectorExpressionsParser.AbsoluteContext ctx);
	/**
	 * Visit a parse tree produced by {@link MatrixVectorExpressionsParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperation(MatrixVectorExpressionsParser.OperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryE}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryE(MatrixVectorExpressionsParser.BinaryEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryBeforeE}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryBeforeE(MatrixVectorExpressionsParser.UnaryBeforeEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code HighOrderE}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHighOrderE(MatrixVectorExpressionsParser.HighOrderEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumberE}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberE(MatrixVectorExpressionsParser.NumberEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VectorE}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVectorE(MatrixVectorExpressionsParser.VectorEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MatrixE}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatrixE(MatrixVectorExpressionsParser.MatrixEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryAfterE}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryAfterE(MatrixVectorExpressionsParser.UnaryAfterEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AbsoluteE}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbsoluteE(MatrixVectorExpressionsParser.AbsoluteEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionE}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionE(MatrixVectorExpressionsParser.FunctionEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VariableE}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableE(MatrixVectorExpressionsParser.VariableEContext ctx);
	/**
	 * Visit a parse tree produced by {@link MatrixVectorExpressionsParser#matrix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatrix(MatrixVectorExpressionsParser.MatrixContext ctx);
	/**
	 * Visit a parse tree produced by {@link MatrixVectorExpressionsParser#vector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVector(MatrixVectorExpressionsParser.VectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MatrixVectorExpressionsParser#vector_sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVector_sequence(MatrixVectorExpressionsParser.Vector_sequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MatrixVectorExpressionsParser#expression_sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_sequence(MatrixVectorExpressionsParser.Expression_sequenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Inverse}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#operator_unary_after}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInverse(MatrixVectorExpressionsParser.InverseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Transpose}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#operator_unary_after}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTranspose(MatrixVectorExpressionsParser.TransposeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryPlus}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#operator_unary_before}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryPlus(MatrixVectorExpressionsParser.UnaryPlusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryMinus}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#operator_unary_before}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMinus(MatrixVectorExpressionsParser.UnaryMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryPlus}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#binary_low_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryPlus(MatrixVectorExpressionsParser.BinaryPlusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryMinus}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#binary_low_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryMinus(MatrixVectorExpressionsParser.BinaryMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Multiply}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#binary_high_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiply(MatrixVectorExpressionsParser.MultiplyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Divide}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#binary_high_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivide(MatrixVectorExpressionsParser.DivideContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Equals}
	 * labeled alternative in {@link MatrixVectorExpressionsParser#binary_high_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquals(MatrixVectorExpressionsParser.EqualsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MatrixVectorExpressionsParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(MatrixVectorExpressionsParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MatrixVectorExpressionsParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(MatrixVectorExpressionsParser.VariableContext ctx);
}