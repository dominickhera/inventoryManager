/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis2430a1;

/**
 *
 * @author Dominick
 */
public class emptyFieldException extends Exception {

    /**
     * Creates a new instance of <code>emptyFieldException</code> without detail
     * message.
     */
    public emptyFieldException() {
    }

    /**
     * Constructs an instance of <code>emptyFieldException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public emptyFieldException(String msg) {
        super(msg);
    }
}
