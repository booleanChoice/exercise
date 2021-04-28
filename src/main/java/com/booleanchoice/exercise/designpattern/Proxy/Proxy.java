package com.booleanchoice.exercise.designpattern.Proxy;

/**
 *
 * @author booleanchoice
 * @version $Id: Proxy.java, v 0.1 2019年05月17日 3:33 PM booleanchoice Exp $
 */
public interface Proxy<T> {

    /**
     * Get proxy target
     * @return
     */
    public T getTarget();

}