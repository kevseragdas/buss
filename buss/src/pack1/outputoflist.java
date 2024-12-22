package pack1;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class outputoflist extends JFrame {

    private JPanel contentPane;

    public outputoflist(String ticketSummary) {
        setTitle("Ticket Summary");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextArea textArea = new JTextArea(ticketSummary);
        textArea.setBackground(SystemColor.menu);
        textArea.setFont(new Font("Calibri", Font.PLAIN, 15));
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 11, 414, 200);
        contentPane.add(scrollPane);

        JButton btnExit = new JButton("EXIT");
        btnExit.setBounds(315, 227, 89, 23);
        contentPane.add(btnExit);

        btnExit.addActionListener(e -> System.exit(0));
    }
}
