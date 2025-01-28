import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounter {

    public static void main(String[] args) {
        // Create the main JFrame (window)
        JFrame frame = new JFrame("Simple Word Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Create a text area for input
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Create a panel for buttons and label
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());

        // Create a label to display the word count
        JLabel wordCountLabel = new JLabel("Word Count: 0");
        bottomPanel.add(wordCountLabel);

        // Create a button to count words
        JButton countButton = new JButton("Count Words");
        bottomPanel.add(countButton);

        // Add action listener to the button
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the text from the text area
                String text = textArea.getText().trim();

                if (!text.isEmpty()) {
                    // Split the text using spaces
                    String[] words = text.split(" ");
                    int wordCount = 0;

                    // Count non-empty words
                    for (String word : words) {
                        if (!word.isEmpty()) {
                            wordCount++;
                        }
                    }

                    // Update the word count label
                    wordCountLabel.setText("Word Count: " + wordCount);
                } else {
                    // If the text area is empty
                    wordCountLabel.setText("Word Count: 0");
                }
            }
        });

        // Add the bottom panel to the frame
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Make the frame visible
        frame.setVisible(true);
    }
}
