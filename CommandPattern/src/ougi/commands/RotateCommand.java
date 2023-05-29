package ougi.commands;

import ougi.math.Transform;

public class RotateCommand implements Command<RotateCommand> {

    private final Transform transform;
    public double oldAngle, newAngle;

    public RotateCommand(Transform transform, double oldAngle, double newAngle) {
        this.transform = transform;
        this.oldAngle = oldAngle;
        this.newAngle = newAngle;
    }

    @Override
    public void execute() {
        this.transform.rotation = this.newAngle;
    }

    @Override
    public void undo() {
        this.transform.rotation = this.oldAngle;
    }

}
