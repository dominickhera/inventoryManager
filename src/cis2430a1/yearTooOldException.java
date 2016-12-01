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
public class yearTooOldException extends Exception {

    /**
     * Creates a new instance of <code>yearTooOldException</code> without detail
     * message.
     */
    public yearTooOldException() {
    }

    /**
     * Constructs an instance of <code>yearTooOldException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public yearTooOldException(String msg) {
        super(msg);
    }
}
