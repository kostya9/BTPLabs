package com.ksharovarsky.lab2.calculation;

import com.ksharovarsky.lab2.MatrixVectorExpressionsBaseVisitor;
import com.ksharovarsky.lab2.MatrixVectorExpressionsParser;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by kostya on 4/10/2017.
 */
public class ExpressionCalculateVisitor extends MatrixVectorExpressionsBaseVisitor<Expression> {

    private Map<String, Expression> _memory;

    public ExpressionCalculateVisitor(Map<String, Expression> memory) {
        _memory = memory;
    }

    private Number fromNumberNodeToNumber(TerminalNode n) {
        return new Number(Double.parseDouble(n.getText()));
    }

    @Override public Expression visitNumberE(MatrixVectorExpressionsParser.NumberEContext ctx) {
        return fromNumberNodeToNumber(ctx.NUMBER());
    }

    @Override public Expression visitVector(MatrixVectorExpressionsParser.VectorContext ctx) {
        List<MatrixVectorExpressionsParser.ExpressionContext> expressionsNodes = ctx.expression_sequence().expression();
        List<Expression> expressions = expressionsNodes.stream().map(this::visit).collect(Collectors.toList());
        if(!expressions.stream().allMatch(e -> e instanceof Number))
            throw new IllegalArgumentException("Only numeric vectors are supported");
        List<Number> list = expressions.stream().map(e -> (Number)e).collect(Collectors.toList());
        Number[] numbers = list.toArray(new Number[list.size()]);
        return new Vector(numbers);
    }

    @Override public Expression visitMatrix(MatrixVectorExpressionsParser.MatrixContext ctx) {
        List<Vector> list = ctx.vector_sequence().vector().stream().map(v -> (Vector)visitVector(v)).collect(Collectors.toList());
        Vector[] vectors  = (Vector[]) list.toArray(new Vector[list.size()]);
        return new Matrix(vectors);
    }

    @Override public Expression visitAssignment(MatrixVectorExpressionsParser.AssignmentContext ctx) {
        String name = ctx.NAME().getText();
        Expression e = visitOperation(ctx.operation());
        _memory.put(name, e);
        return e;
    }

    @Override public Expression visitStart_rule(MatrixVectorExpressionsParser.Start_ruleContext ctx) {
        return visitOperation(ctx.operation());
    }

    @Override public Expression visitVariable(MatrixVectorExpressionsParser.VariableContext ctx) {
        return _memory.get(ctx.getText());
    }
    @Override public Expression visitFunctionE(MatrixVectorExpressionsParser.FunctionEContext ctx) {
        Expression e = visit(ctx.expression_high().expression());

        String name = ctx.function().NAME().getText();
        if(name.equals("rank"))
            return e.rank();
        if(name.equals("det"))
            return e.determinant();

        throw new IllegalArgumentException();

    }

    @Override public Expression visitBinaryE(MatrixVectorExpressionsParser.BinaryEContext ctx) {
        Expression left = visit(ctx.expression().get(0));
        Expression right = visit(ctx.expression().get(1));

        if(ctx.binary_high_operator() != null) {
            if(ctx.binary_high_operator().getText().equals("*"))
                return left.multiply(right);
            else if(ctx.binary_high_operator().getText().equals("/"))
                return left.divide(right);
        }
        else {
            if(ctx.binary_low_operator().getText().equals("+"))
                return left.plus(right);
            else if(ctx.binary_low_operator().getText().equals("-"))
                return left.minus(right);
        }

        throw new IllegalArgumentException();
    }

    @Override public Expression visitUnaryBeforeE(MatrixVectorExpressionsParser.UnaryBeforeEContext ctx) {
        Expression e = visit(ctx.expression());
        if(ctx.operator_unary_before().getText().equals("+"))
            return e;
        if(ctx.operator_unary_before().getText().equals("-"))
            return e.negative();

        throw new IllegalArgumentException();
    }

    @Override public Expression visitUnaryAfterE(MatrixVectorExpressionsParser.UnaryAfterEContext ctx) {
        Expression e = visit(ctx.expression());
        if(ctx.operator_unary_after().getText().equals("^1"))
            return e.inverse();
        if(ctx.operator_unary_after().getText().equals("^T"))
            return e.transpose();

        throw new IllegalArgumentException();
    }

}
