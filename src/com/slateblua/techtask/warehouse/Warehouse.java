package com.slateblua.techtask.warehouse;

import com.slateblua.techtask.Material;
import com.slateblua.techtask.ResolveStrategy;
import com.slateblua.techtask.WarehouseOutOfBoundsException;
import java.util.ArrayList;
import java.util.List;

/**
 * The <code>Warehouse</code> class represents an inventory where players store their items
 *
 * @author Sergey Hayriyan <a href="mailto:sergey_hayriyan@edu.aua.am">sergey_hayriyan@edu.aua.am</a>
 */
@SuppressWarnings("unused")
public class Warehouse {

    /**
     * An <code>int</code> array that holds the quantities of all materials
     * Utilizes the ordinal of a <code>Material</code> as keys for
     * quick access to the materials quantities
     */
    private final int[] inventory;

    private final List<WarehouseObserver> observers = new ArrayList<>();

    public Warehouse() {
        this.inventory = new int[Material.values().length];
    }

    public void addItem(Material material) throws RuntimeException {
        addItem(material, 1);
    }

    public void removeItem(Material material) throws RuntimeException {
        removeItem(material, 1);
    }

    public void addItem(Material material, int quantity) throws WarehouseOutOfBoundsException {
        if (getQuantity(material) + quantity > material.getMaxCapacity()) {
            throw new WarehouseOutOfBoundsException("Not enough space in the warehouse");
        }
        inventory[material.ordinal()] += quantity;
        notifyObservers();
    }

    public void removeItem(Material material, int quantity) throws WarehouseOutOfBoundsException {
        if (getQuantity(material) == 0) {
            throw new WarehouseOutOfBoundsException("No such material in the warehouse");
        }
        if (getQuantity(material) - quantity < 0) {
            throw new WarehouseOutOfBoundsException("Not enough of a material in the warehouse");
        }
        inventory[material.ordinal()] -= quantity;
        notifyObservers();
    }

    public void moveTo(Warehouse other, Material material, int quantity, ResolveStrategy onConflict) throws WarehouseOutOfBoundsException {
        moveFrom(this, other, material, quantity, onConflict);
    }

    public static void moveFrom(Warehouse from, Warehouse to, Material material, int quantity, ResolveStrategy onConflict) throws WarehouseOutOfBoundsException {
        from.removeItem(material, quantity);
        if (onConflict == ResolveStrategy.PARTIAL) {
            try {
                to.addItem(material, quantity);
            } catch (WarehouseOutOfBoundsException e) {
                int quantityToMove = material.getMaxCapacity() - to.getQuantity(material);
                from.addItem(material, quantity - quantityToMove);
                to.addItem(material, quantityToMove);
            }
        }
        else if (onConflict == ResolveStrategy.FAIl) {
            to.addItem(material, quantity);
        }
    }

    public int getQuantity(Material material) {
        return inventory[material.ordinal()];
    }

    private void notifyObservers() {
        for (WarehouseObserver observer : observers) {
            observer.onWarehouseChanged(this);
        }
    }

    public void addObserver(WarehouseObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(WarehouseObserver observer) {
        observers.remove(observer);
    }

    /**
     * @return The <code>String</code> representation of a warehouse
     */
    @Override
    public String toString() {
        StringBuilder information = new StringBuilder();
        for (Material material : Material.values()) {
            information
                    .append(getQuantity(material))
                    .append(" of ")
                    .append(material.getName())
                    .append(" out of maximum ")
                    .append(material.getMaxCapacity())
                    .append("\n");
        }
        return new String(information);
    }
}