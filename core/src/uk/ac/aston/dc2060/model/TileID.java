package uk.ac.aston.dc2060.model;

/**
 * An enum describing the IDs of each tile in the tileset.
 */
public enum TileID {
    DIRT(167),
    SINGLE_TURRET(249),
    SINGLE_TURRET_BASE(180),
    SINGLE_TURRET_GUNFIRE(296),
    DOUBLE_TURRET(250),
    SOLDIER(245);

    private int id;

    TileID(int id) {
        this.id = id + 1;
    }

    public int getID() {
        return id;
    }
}
