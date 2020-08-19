package Classes;

public class Wall extends Obstacles{
    private int wallHeight;

    public Wall(int wallHeight) {
        this.wallHeight = wallHeight;
    }

    @Override
    public int getSize() {
        return wallHeight;
    }
}
