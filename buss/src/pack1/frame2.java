package pack1;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frame2 extends JFrame {

    private JPanel contentPane;
    private CompanySelectionBackend backend;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame2 frame = new frame2();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public frame2() {
        // Initialize backend instance
        backend = new CompanySelectionBackend();

        setTitle("Bus Ticket Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextArea txtrTheBusesAccording = new JTextArea();
        txtrTheBusesAccording.setFont(new Font("Calibri", Font.PLAIN, 12));
        txtrTheBusesAccording.setText("The buses according to the route, date and time you have selected are listed ");
        txtrTheBusesAccording.setBounds(0, 11, 424, 19);
        contentPane.add(txtrTheBusesAccording);

        JTextArea txtrBelowPleaseChoose = new JTextArea();
        txtrBelowPleaseChoose.setFont(new Font("Calibri", Font.PLAIN, 13));
        txtrBelowPleaseChoose.setText("below. Please choose the one that suits you...");
        txtrBelowPleaseChoose.setBounds(0, 27, 424, 26);
        contentPane.add(txtrBelowPleaseChoose);

        JRadioButton rdbtnCompany1 = new JRadioButton("Company1");
        rdbtnCompany1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        rdbtnCompany1.setBounds(27, 72, 119, 31);
        contentPane.add(rdbtnCompany1);

        JRadioButton rdbtnCompany2 = new JRadioButton("Company2");
        rdbtnCompany2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        rdbtnCompany2.setBounds(27, 119, 119, 31);
        contentPane.add(rdbtnCompany2);

        JRadioButton rdbtnCompany3 = new JRadioButton("Company3");
        rdbtnCompany3.setFont(new Font("Tahoma", Font.PLAIN, 13));
        rdbtnCompany3.setBounds(27, 167, 119, 31);
        contentPane.add(rdbtnCompany3);

        // Group radio buttons
        ButtonGroup group = new ButtonGroup();
        group.add(rdbtnCompany1);
        group.add(rdbtnCompany2);
        group.add(rdbtnCompany3);

        JButton btnSave2 = new JButton("SAVE");
        btnSave2.setBounds(335, 227, 89, 23);
        contentPane.add(btnSave2);

        JButton btnExit = new JButton("EXIT");
        btnExit.setBounds(230, 227, 89, 23);
        contentPane.add(btnExit);

        // Add action listeners
        rdbtnCompany1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backend.selectCompany("Company1");
            }
        });

        rdbtnCompany2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backend.selectCompany("Company2");
            }
        });

        rdbtnCompany3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backend.selectCompany("Company3");
            }
        });

        btnSave2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCompany = backend.getSelectedCompany();
                if (selectedCompany != null) {
                    JOptionPane.showMessageDialog(frame2.this, "Saved! You selected: " + selectedCompany);
                } else {
                    JOptionPane.showMessageDialog(frame2.this, "Please select a company first.");
                }
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = backend.cancelOperation();
                JOptionPane.showMessageDialog(frame2.this, message);
                System.exit(0);
            }
        });
    }
}
