grammar Aura;

prog: statement* EOF;

statement: let_decl SEMI
         | expr_stmt SEMI
         ;

let_decl: 'let' 'mut'? IDENT ('=' expression)? ;

expr_stmt: expression ;

expression: atom (OP atom)* ;

atom: IDENT
    | NUMBER
    | STRING
    | '(' expression ')'
    ;

IDENT: [a-zA-Z_][a-zA-Z0-9_]*;
NUMBER: [0-9]+ ('.' [0-9]+)?;
STRING: '\"' (~[\"\\])* '\"' | '\\'' (~[\\'\\\\])* '\\'';

SEMI: ';' ;
OP: '+' | '-' | '*' | '/' ;
WS: [ \t\r\n]+ -> skip ;
COMMENT: '//' ~[\r\n]* -> skip ;
