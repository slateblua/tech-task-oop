package com.slateblua.techtask;

/**
 * The <code>Material</code> enum to represent materials that can be stored
 */

@SuppressWarnings("unused")
public enum Material implements Storable {

    COPPER("Copper", "Icon", "Material used in...") {
        @Override
        public int getMaxCapacity() {
            return COPPER_MAX_CAPACITY;
        }
    },
    BOLT("Bolt", "Icon", "Material used in...") {
        @Override
        public int getMaxCapacity() {
            return BOLT_MAX_CAPACITY;
        }
    },
    IRON("Iron", "Icon", "Material used in...") {
        @Override
        public int getMaxCapacity() {
            return IRON_MAX_CAPACITY;
        }
    };

    private static final int COPPER_MAX_CAPACITY = 20;
    private static final int IRON_MAX_CAPACITY = 20;
    private static final int BOLT_MAX_CAPACITY = 20;

    /**
     * Name of the material
     */
    private final String name;

    /**
     * Icon of the material
     */
    private final String icon;

    /**
     * Description of the material
     */
    private final String description;

    /**
     * @param name Name of the material
     * @param icon Icon of the material
     * @param description Description of the material
     */
    Material(String name, String icon, String description) {
        this.name = name;
        this.icon = icon;
        this.description = description;
    }

    /**
     * @return Name of the material
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return Icon of the material
     */
    public String getIcon() {
        return this.icon;
    }

    /**
     * @return Description of the material
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * @return <code>String</code> representation of a material
     */
    @Override
    public String toString() {
        return this.name + " " + this.description;
    }
}
