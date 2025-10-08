grammar MapFile;

mapFile
    : sizeDecl startDecl goalDecl declaration* EOF
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

declaration
    : itemDecl
    | obstacleDecl
    | pluginDecl
    | scriptDecl
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
    : IDENTIFIER ('.' IDENTIFIER)*
    ;

STRING
    : '"' ~["\r\n]* '"'
    ;

SCRIPT_BLOCK
    : '!{' .*? '}'
    ;

INT
    : [0-9]+
    ;

IDENTIFIER
    : [a-zA-Z_][a-zA-Z0-9_]*
    ;

WS
    : [ \t\r\n]+ -> skip
    ;

COMMENT
    : '//' ~[\r\n]* -> skip
    ;