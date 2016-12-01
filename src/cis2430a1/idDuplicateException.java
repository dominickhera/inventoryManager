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
public class idDuplicateException extends Exception {

    /**
     * Creates a new instance of <code>idDuplicateException</code> without
     * detail message.
     */
    public idDuplicateException() {
    }

    /**
     * Constructs an instance of <code>idDuplicateException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public idDuplicateException(String msg) {
        super(msg);
    }
}
