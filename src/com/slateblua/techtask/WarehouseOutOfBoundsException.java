package com.slateblua.techtask;

public class WarehouseOutOfBoundsException extends RuntimeException {
    public WarehouseOutOfBoundsException() {
        super("Unable to perform the operation");
    }
    public WarehouseOutOfBoundsException(String message) {
        super(message);
    }
}
