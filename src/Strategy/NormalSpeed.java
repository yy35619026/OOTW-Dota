package Strategy;


public class NormalSpeed implements SpeedStrategy{

    private float speedX;
    private float speedY;

    public NormalSpeed(float speedX, float speedY) {
        this.speedX = speedX;
        this.speedY = speedY;
    }

    @Override
    public void execute() {

    }

    @Override
    public void updatePosition(float x, float y) {

    }
}
