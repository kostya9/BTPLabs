grammar MatrixVectorExpressions;

@header {
    package com.ksharovarsky.lab2
}

start_rule: (expression end_expression)* expression?;

end_expression: ';';

assignment: NAME '=' expression;

expression_high: '(' expression ')';
absolute: '|' expression '|';

expression:
    assignment
    | expression_high
    | absolute
    | function expression_high
    | operator_unary_before expression
    | expression operator_unary_after
    | expression binary_high_operator expression
    | expression binary_low_operator expression
    | variable
    | value;

operator_unary_after: '^1' | '^T';
operator_unary_before: '+' | '-';
binary_low_operator: '+' | '-';
binary_high_operator: '*' | '/';

function: NAME;
variable: NAME;

matrix: '[' vector_sequence ']';
vector: '[' number_sequence ']';
value : NUMBER | vector | matrix;

vector_sequence: vector (',' vector)*;
number_sequence : NUMBER (',' NUMBER)*;

NAME: [a-zA-Z]+;
NUMBER: DIGIT+ | DIGIT+ '.' DIGIT+ ;
DIGIT: [0-9];

WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ -> skip ;