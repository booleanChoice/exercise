// Generated from /Users/booleanchoice/develop/gitrepo/exercise/src/main/java/com/booleanchoice/exercise/antlr/hello/grammar/Hello.g4 by ANTLR 4.10.1
package com.booleanchoice.exercise.antlr.hello.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link HelloParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface HelloVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link HelloParser#r}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitR(HelloParser.RContext ctx);
}