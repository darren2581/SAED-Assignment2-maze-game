grammar MapFile;

// Parser Rules

mapFile
    : declaration+ EOF
    ;

declaration
    : sizeDecl
    | startDecl
    | goalDecl
    | itemDecl
    | obstacleDecl
    | pluginDecl
    | scriptDecl
    ;

sizeDecl
    : 'size' coords
    ;

startDecl
    : 'start' coords
    ;

goalDecl
    : 'goal' coords
    ;

itemDecl
    : 'item' STRING '{' atDecl messageDecl '}'
    ;

obstacleDecl
    : 'obstacle' '{' atDecl requiresDecl '}'
    ;

pluginDecl
    : 'plugin' qualifiedName
    ;

scriptDecl
    : 'script' SCRIPT_BLOCK
    ;

atDecl
    : 'at' coordsList
    ;

messageDecl
    : 'message' STRING
    ;

requiresDecl
    : 'requires' stringList
    ;

coords
    : '(' INT ',' INT ')'
    ;

coordsList
    : coords (',' coords)*
    ;

stringList
    : STRING (',' STRING)*
    ;

qualifiedName
    : ID ('.' ID)*
    ;

// Lexer Rules

SCRIPT_BLOCK
    : '!{' .*? '}'
    ;

STRING
    : '"' ~["]* '"'
    ;

INT
    : [0-9]+
    ;

ID
    : [a-zA-Z_][a-zA-Z0-9_]*
    ;

WS
    : [ \t\r\n]+ -> skip
    ;

COMMENT
    : '//' ~[\r\n]* -> skip
    ;

BLOCK_COMMENT
    : '/*' .*? '*/' -> skip
    ;