package pack1;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frame4 extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldEmail;
    private JTextField textFieldName;
    private JTextField textFieldSurname;
    private JComboBox<Integer> cbAge;
    private UserInfoBackend userInfo;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame4 frame = new frame4();
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
    public frame4() {
        // Initialize the backend
        userInfo = new UserInfoBackend();

        setTitle("Bus Ticket Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Your Name:");
        lblNewLabel.setBounds(10, 24, 63, 14);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Your Surname:");
        lblNewLabel_1.setBounds(10, 58, 79, 14);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Your Age:");
        lblNewLabel_2.setBounds(10, 93, 63, 14);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_4 = new JLabel("Your E-mail:");
        lblNewLabel_4.setBounds(10, 172, 63, 14);
        contentPane.add(lblNewLabel_4);

        JLabel info2 = new JLabel("INFO:");
        info2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        info2.setBounds(228, 33, 46, 14);
        contentPane.add(info2);

        JTextArea textAreaInfo = new JTextArea();
        textAreaInfo.setEditable(false);
        textAreaInfo.setLineWrap(true); // Enable line wrapping
        textAreaInfo.setWrapStyleWord(true); // Wrap at word boundaries
        textAreaInfo.setBounds(228, 58, 196, 128);
        contentPane.add(textAreaInfo);

        JButton btnExit = new JButton("EXIT");
        btnExit.setBounds(236, 227, 89, 23);
        contentPane.add(btnExit);
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userInfo.cancelOperation();
                System.exit(0);
            }
        });

        JButton btnSave = new JButton("SAVE");
        btnSave.setBounds(335, 227, 89, 23);
        contentPane.add(btnSave);
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Save user details to the backend
                String name = textFieldName.getText();
                String surname = textFieldSurname.getText();
                String email = textFieldEmail.getText();
                int age = (int) cbAge.getSelectedItem();

                userInfo.enterUserName(name);
                userInfo.enterSurname(surname);
                userInfo.enterAge(age);
                userInfo.enterEmail(email);

                // Display user details in the info text area
                textAreaInfo.setText(userInfo.getUserDetails());
            }
        });

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(83, 169, 86, 20);
        contentPane.add(textFieldEmail);
        textFieldEmail.setColumns(10);

        textFieldName = new JTextField();
        textFieldName.setColumns(10);
        textFieldName.setBounds(83, 21, 86, 20);
        contentPane.add(textFieldName);

        textFieldSurname = new JTextField();
        textFieldSurname.setColumns(10);
        textFieldSurname.setBounds(83, 55, 86, 20);
        contentPane.add(textFieldSurname);

        // Create JComboBox and populate with age range (18-100)
        cbAge = new JComboBox<>();
        for (int age = 18; age <= 100; age++) {
            cbAge.addItem(age);
        }
        cbAge.setBounds(83, 89, 63, 22);
        contentPane.add(cbAge);
    }
}
