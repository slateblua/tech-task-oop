package com.slateblua.techtask.warehouse;

/**
 * The <code>WarehouseObserver</code> interface that every observer should implement
 *
 * @author Sergey Hayriyan <a href="mailto:sergey_hayriyan@edu.aua.am">sergey_hayriyan@edu.aua.am</a>
 */
public interface WarehouseObserver {
    void onWarehouseChanged(Warehouse warehouse);
}
