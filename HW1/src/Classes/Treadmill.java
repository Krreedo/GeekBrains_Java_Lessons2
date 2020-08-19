package Classes;

public class Treadmill extends Obstacles{
    private int treadmillDist;

    @Override
    public int getSize() {
        return treadmillDist;
    }

    public Treadmill(int treadmillDist) {
        this.treadmillDist = treadmillDist;
    }
}
