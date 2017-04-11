grammar MatrixVectorExpressions;

//start_rule: (operation end_expression)* operation?;
start_rule: operation end_expression*;
end_expression: ';';

assignment: NAME '=' operation;

expression_high: '(' expression ')';
absolute: '|' expression '|';

operation:
    assignment
    | expression;


expression: expression_high #HighOrderE
                | absolute # AbsoluteE
                | function expression_high #FunctionE
                | operator_unary_before expression #UnaryBeforeE
                | expression operator_unary_after #UnaryAfterE
                | expression binary_high_operator expression #BinaryE
                | expression binary_low_operator expression #BinaryE
                | variable #VariableE
                | matrix #MatrixE
                | vector #VectorE
                | NUMBER #NumberE;

matrix: '[' vector_sequence ']';
vector: '[' expression_sequence ']';
vector_sequence : vector (',' vector)*;
expression_sequence : expression (',' expression)*;

operator_unary_after: '^1' #Inverse | '^T'  # Transpose;
operator_unary_before: '+' #UnaryPlus | '-' #UnaryMinus;
binary_low_operator: '+' #BinaryPlus | '-' #BinaryMinus;
binary_high_operator: '*' #Multiply | '/' #Divide;

function: NAME;
variable: NAME;

NAME: [a-zA-Z]+;
NUMBER: '-'?(DIGIT+ | DIGIT+ '.' DIGIT+) ;
DIGIT: [0-9];

WHITESPACE : ( '\t' | ' ' | '\r' | '\n' )+ -> skip ;