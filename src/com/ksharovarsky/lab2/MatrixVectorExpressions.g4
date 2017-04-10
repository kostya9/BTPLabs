grammar MatrixVectorExpressions;

start_rule: (expression end_expression)* expression?;

end_expression: ';';

assignment: NAME '=' expression;

expression_high: '(' expression ')';
absolute: '|' expression '|';

expression:
    assignment #AssignmentE
    | expression_high #HighOrderE
    | absolute # AbsoluteE
    | function expression_high #FunctionE
    | operator_unary_before expression #UnaryBeforeE
    | expression operator_unary_after #UnaryAfterE
    | expression binary_high_operator expression #BinaryE
    | expression binary_low_operator expression #BinaryE
    | variable #VariableE
    | vector #VectorE
    | NUMBER #NumberE;

vector: '[' expression_sequence ']';
expression_sequence : expression (',' expression)*;

operator_unary_after: '^1' #Inverse | '^T'  # Transpose;
operator_unary_before: '+' #UnaryPlus | '-' #UnaryMinus;
binary_low_operator: '+' #BinaryPlus | '-' #BinaryMinus;
binary_high_operator: '*' #Multiply | '/' #Divide;

function: NAME;
variable: NAME;

NAME: [a-zA-Z]+;
NUMBER: (DIGIT+ | DIGIT+ '.' DIGIT+) ;
DIGIT: [0-9];

WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ -> skip ;