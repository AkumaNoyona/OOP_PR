import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task2 extends JFrame {

    public Task2() {
        super("20 Random Shapes");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.add(new DrawingPanel());
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private class DrawingPanel extends JPanel {
        private List<Shape> shapes;
        private static final int NUM_SHAPES = 20;

        public DrawingPanel() {
            shapes = new ArrayList<>();
            Random rand = new Random();
            int width = 600;
            int height = 600;

            for (int i = 0; i < NUM_SHAPES; i++) {
                int x = rand.nextInt(width - 50);
                int y = rand.nextInt(height - 50);
                int size = rand.nextInt(40) + 10;

                if (rand.nextBoolean()) {
                    shapes.add(new Circle(x, y, size));
                } else {
                    shapes.add(new Square(x, y, size));
                }
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Shape shape : shapes) {
                shape.draw(g);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Task2());
    }
}