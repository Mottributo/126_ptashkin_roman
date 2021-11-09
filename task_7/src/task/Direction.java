package task;

public enum Direction {

    // Entries
    North(0, -1),
    West(-1, 0),
    South(0, 1),
    East(1, 0);

    // Fields
    private int xD, yD;

    // Constructors
    Direction(int xD, int yD) {
        this.xD = xD;
        this.yD = yD;
    }

    // Methods
    public Vector2 move(Vector2 start, double distance) {
         return new Vector2(start.getX() + distance * xD, start.getY() + distance * yD);
    }
}
