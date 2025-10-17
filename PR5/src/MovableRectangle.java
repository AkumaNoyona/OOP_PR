public class MovableRectangle implements Movable {
    private MovablePoint topLeft;
    private MovablePoint bottomRight;

    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        this.topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
        this.bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
    }

    private boolean speedsEqual() {
        return topLeft.xSpeed == bottomRight.xSpeed && topLeft.ySpeed == bottomRight.ySpeed;
    }

    @Override
    public void moveUp() {
        if (speedsEqual()) {
            topLeft.moveUp();
            bottomRight.moveUp();
        } else {
            throw new IllegalStateException("Points have different speeds.");
        }
    }

    @Override
    public void moveDown() {
        if (speedsEqual()) {
            topLeft.moveDown();
            bottomRight.moveDown();
        } else {
            throw new IllegalStateException("Points have different speeds.");
        }
    }

    @Override
    public void moveLeft() {
        if (speedsEqual()) {
            topLeft.moveLeft();
            bottomRight.moveLeft();
        } else {
            throw new IllegalStateException("Points have different speeds.");
        }
    }

    @Override
    public void moveRight() {
        if (speedsEqual()) {
            topLeft.moveRight();
            bottomRight.moveRight();
        } else {
            throw new IllegalStateException("Points have different speeds.");
        }
    }

    @Override
    public String toString() {
        return "MovableRectangle{topLeft=" + topLeft + ", bottomRight=" + bottomRight + '}';
    }
}

