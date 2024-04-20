package com.slateblua.techtask.warehouse;

/**
 * The <code>WarehouseLogger</code> class to keep track of a warehouse
 *
 * @author Sergey Hayriyan <a href="mailto:sergey_hayriyan@edu.aua.am">sergey_hayriyan@edu.aua.am</a>
 */
@SuppressWarnings("unused")
public class WarehouseLogger implements WarehouseObserver {
    @Override
    public void onWarehouseChanged(Warehouse warehouse) {
        System.out.println("Warehouse changed:");
        System.out.println(warehouse);
    }
}
