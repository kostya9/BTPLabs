package com.ksharovarsky.lab2.calculation;

import com.ksharovarsky.lab2.MatrixVectorExpressionsLexer;
import com.ksharovarsky.lab2.MatrixVectorExpressionsParser;
import org.antlr.v4.runtime.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kostya on 4/11/2017.
 */
public class ExpressionCalculator {

    private final Map<String, Expression> _memory;

    public ExpressionCalculator() {
        this._memory = new HashMap<String, Expression>();
    }

    public Expression calculate(String input) {
        ANTLRInputStream inputStream = new ANTLRInputStream(input);
        MatrixVectorExpressionsLexer lexer = new MatrixVectorExpressionsLexer(inputStream);
        lexer.removeErrorListeners();
        // Get a list of matched tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Pass the tokens to the parser
        MatrixVectorExpressionsParser parser = new MatrixVectorExpressionsParser(tokens);
        parser.setErrorHandler(new DefaultErrorStrategy() {

            @Override
            public void reportError(Parser parser, RecognitionException e) {
                throw new IllegalArgumentException("Incorrect input.");
            }

            @Override
            public Token recoverInline(Parser recognizer) {
                throw new IllegalArgumentException("Incorrect input.");
            }
        });

        ExpressionCalculateVisitor visitor = new ExpressionCalculateVisitor(_memory);

        // Specify our entry point
        return visitor.visitStart_rule(parser.start_rule());
    }

    public String calculateOutput(String input) {
        try {
            Expression e = calculate(input.replaceAll(" ", ""));
            return e.display();
        }
        catch(IllegalArgumentException e) {
            return e.getMessage();
        }
        catch (NotImplementedException e){
            return "Sorry, this operation was not implemented"  + Arrays.toString(e.getStackTrace());
        }
        catch(Exception e) {
            return "Incorrect input. Try again.";
        }
    }
}
