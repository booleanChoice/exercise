/*
 * Ant Group
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.booleanchoice.exercise.antlr.common;

import com.booleanchoice.exercise.antlr.arrayinit.ArrayInitLexer;
import com.booleanchoice.exercise.antlr.arrayinit.ArrayInitParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;


import java.io.IOException;

/**
 * @author booleanchoice
 * @version Test.java, v 0.1 2022年11月03日 11:52 booleanchoice
 */
public class Test {

    public static void main(String[] args) throws IOException {
        CharStream is = new ANTLRInputStream(System.in);

        ArrayInitLexer lexer = new ArrayInitLexer( is );

        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        CommonParser parser = new CommonParser(new ArrayInitParser(tokenStream));


    }

}