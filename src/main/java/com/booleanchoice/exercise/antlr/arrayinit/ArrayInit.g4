// 语法文件以grammar关键字开头， 名为ArrayInit语法必须和文件名ArrayInit.g4相匹配
grammar ArrayInit;

init  : '{' value (',' value)* '}' ;
value : init
      | INT
      ;
// 语法分析器规则必须以小写字母开头， 词法分析器规则必须以大写字母开头
INT   : [0-9]+ ; // 定义词法符号INT, 也就是token，由一个或多个数字组成
WS    : [ \t\r\n]+ -> skip ; // 词法规则WS，为一个或多个空白符号，丢弃它


