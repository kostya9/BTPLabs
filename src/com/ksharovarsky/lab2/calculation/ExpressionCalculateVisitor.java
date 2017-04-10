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
        List<TerminalNode> numbersNodes = ctx.number_sequence().NUMBER();
        List<Number> list = numbersNodes.stream().map(this::fromNumberNodeToNumber).collect(Collectors.toList());
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

}
