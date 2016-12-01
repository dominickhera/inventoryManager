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
public class idTooShortException extends Exception {

    /**
     * Creates a new instance of <code>idTooShortException</code> without detail
     * message.
     */
    public idTooShortException() {
    }

    /**
     * Constructs an instance of <code>idTooShortException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public idTooShortException(String msg) {
        super(msg);
    }
}
