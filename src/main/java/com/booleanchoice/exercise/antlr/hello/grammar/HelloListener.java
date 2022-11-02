// Generated from /Users/booleanchoice/develop/gitrepo/exercise/src/main/java/com/booleanchoice/exercise/antlr/hello/grammar/Hello.g4 by ANTLR 4.10.1
package com.booleanchoice.exercise.antlr.hello.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HelloParser}.
 */
public interface HelloListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HelloParser#r}.
	 * @param ctx the parse tree
	 */
	void enterR(HelloParser.RContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#r}.
	 * @param ctx the parse tree
	 */
	void exitR(HelloParser.RContext ctx);
}