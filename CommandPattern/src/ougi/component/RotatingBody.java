package ougi.component;

import ougi.commands.CommandHistory;
import ougi.commands.RotateCommand;

public class RotatingBody extends Component<RotatingBody> {

    private boolean isRotating;
    private double rotationSpeed;

    public RotatingBody(boolean isRotating, double rotationSpeed) {
        super("RotatingBody");
        this.isRotating = isRotating;
        this.rotationSpeed = rotationSpeed;
    }

    @Override
    public void update(double deltaTime) {
        CommandHistory.addCommand(
                new RotateCommand(
                    this.entity.transform,
                    this.entity.transform.rotation,
                    this.entity.transform.rotation + this.rotationSpeed * deltaTime
                )
        );
    }

    public boolean isRotating() {
        return isRotating;
    }

    public double getRotationSpeed() {
        return rotationSpeed;
    }

    public void setRotationSpeed(double rotationSpeed) {
        this.rotationSpeed = rotationSpeed;
    }

    public void setRotating(boolean rotating) {
        isRotating = rotating;
    }

    @Override
    public String toString() {
        return "RotatingBody{" +
                "isRotating=" + isRotating +
                ", rotationSpeed=" + rotationSpeed +
                '}';
    }
}
