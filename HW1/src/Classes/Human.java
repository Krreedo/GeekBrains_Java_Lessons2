package Classes;

public class Human implements Moving {
    private String name;
    private int runRestrict;
    private int jumpRestrict;

    public Human(String name, int runRestrict, int jumpRestrict) {
        this.name = name;
        this.runRestrict = runRestrict;
        this.jumpRestrict = jumpRestrict;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean run(int dist) {
        return runRestrict>=dist;

    }

    @Override
    public boolean jump(int height) {
        return jumpRestrict>=height;

    }
}
