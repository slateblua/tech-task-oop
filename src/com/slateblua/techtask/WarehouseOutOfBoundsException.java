package com.slateblua.techtask;

/**
 * The <code>WarehouseOutOfBoundsException</code> custom exception class
 *
 * @author Sergey Hayriyan <a href="mailto:sergey_hayriyan@edu.aua.am">sergey_hayriyan@edu.aua.am</a>
 */
@SuppressWarnings("unused")
public class WarehouseOutOfBoundsException extends RuntimeException {
    public WarehouseOutOfBoundsException() {
        super("Unable to perform the operation");
    }
    public WarehouseOutOfBoundsException(String message) {
        super(message);
    }
}
