import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Scoreboard extends JFrame implements ActionListener {

    private int milanScore = 0;
    private int madridScore = 0;

    private JLabel resultLabel;
    private JLabel lastScorerLabel;
    private JLabel winnerLabel;

    private JButton milanButton;
    private JButton madridButton;

    public Scoreboard() {
        super("Football Scoreboard");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 250);
        this.setLayout(new BorderLayout(10, 10));
        this.setLocationRelativeTo(null);

        resultLabel = new JLabel("Result: 0 X 0", JLabel.CENTER);
        lastScorerLabel = new JLabel("Last Scorer: N/A", JLabel.CENTER);
        winnerLabel = new JLabel("Winner: DRAW", JLabel.CENTER);

        Font scoreFont = new Font("Arial", Font.BOLD, 18);
        resultLabel.setFont(scoreFont);
        lastScorerLabel.setFont(scoreFont);
        winnerLabel.setFont(scoreFont);

        milanButton = new JButton("AC Milan");
        madridButton = new JButton("Real Madrid");

        milanButton.addActionListener(this);
        madridButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 10, 0));
        buttonPanel.add(milanButton);
        buttonPanel.add(madridButton);

        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(3, 1));
        labelPanel.add(resultLabel);
        labelPanel.add(lastScorerLabel);
        labelPanel.add(winnerLabel);

        this.add(buttonPanel, BorderLayout.NORTH);
        this.add(labelPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String lastScorer = "N/A";

        if (e.getSource() == milanButton) {
            milanScore++;
            lastScorer = "AC Milan";
        } else if (e.getSource() == madridButton) {
            madridScore++;
            lastScorer = "Real Madrid";
        }

        updateLabels(lastScorer);
    }

    private void updateLabels(String lastScorer) {
        resultLabel.setText("Result: " + milanScore + " X " + madridScore);

        lastScorerLabel.setText("Last Scorer: " + lastScorer);

        String winner;
        if (milanScore > madridScore) {
            winner = "AC Milan";
        } else if (madridScore > milanScore) {
            winner = "Real Madrid";
        } else {
            winner = "DRAW";
        }
        winnerLabel.setText("Winner: " + winner);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Scoreboard());
    }
}