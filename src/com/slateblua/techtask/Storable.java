package com.slateblua.techtask;

/**
 * The <code>Storable</code> interface that every <code>Material</code> should implement
 *
 * @author Sergey Hayriyan <a href="mailto:sergey_hayriyan@edu.aua.am">sergey_hayriyan@edu.aua.am</a>
 */
public interface Storable {
    /**
     * @return the maximum amount of a material that can be stored in a warehouse
     */
    int getMaxCapacity();
}
