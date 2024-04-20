package com.slateblua.techtask;

@SuppressWarnings("all")
public enum MaterialEnum implements Storable {

    GOLD("Gold", "Icon", "Material used in...") {
        @Override
        public int getMaxCapacity() {
            return 20;
        }
    },
    BOLT("Bolt", "Icon", "Material used in...") {
        @Override
        public int getMaxCapacity() {
            return 20;
        }
    },
    IRON("Iron", "Icon", "Material used in...") {
        @Override
        public int getMaxCapacity() {
            return 20;
        }
    },
    COOPER("Iron", "Icon", "Material used in...") {
        @Override
        public int getMaxCapacity() {
            return 0;
        }
    };
    /**
     *
     */
    private final String name;

    /**
     *
     */
    private final String icon;

    /**
     *
     */
    private final String description;

    /**
     * @param name
     * @param icon
     * @param description
     */
    MaterialEnum(String name, String icon, String description) {
        this.name = name;
        this.icon = icon;
        this.description = description;
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @return
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @return
     */
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name + " " + description;
    }
}
