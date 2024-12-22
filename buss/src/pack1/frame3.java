package pack1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class frame3 extends JFrame {

    private JPanel contentPane;
    private JComboBox<Integer> comboBoxSeats;
    private JTextArea textAreaInfo;
    private SeatSelectionBackend seatBackend;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame3 frame = new frame3();
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
    public frame3() {
        // Initialize backend
        seatBackend = new SeatSelectionBackend();

        setTitle("Bus Ticket Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // Ensure EmptyBorder is imported
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextArea txtrSelectTheSeat = new JTextArea();
        txtrSelectTheSeat.setBackground(SystemColor.menu);
        txtrSelectTheSeat.setFont(new Font("Calibri", Font.PLAIN, 23));
        txtrSelectTheSeat.setText("Select the seat number you want to buy...");
        txtrSelectTheSeat.setBounds(10, 11, 414, 39);
        txtrSelectTheSeat.setEditable(false);
        contentPane.add(txtrSelectTheSeat);

        // Create JComboBox for seat selection
        comboBoxSeats = new JComboBox<>();
        for (int i = 1; i <= 50; i++) {
            comboBoxSeats.addItem(i); // Populate seat numbers
        }
        comboBoxSeats.setBounds(317, 54, 88, 22);
        contentPane.add(comboBoxSeats);

        JTextArea txtrifTheSeat = new JTextArea();
        txtrifTheSeat.setFont(new Font("Calibri", Font.PLAIN, 10));
        txtrifTheSeat.setBackground(SystemColor.menu);
        txtrifTheSeat.setText("(If the seat you have chosen has been selected, please choose it again...)");
        txtrifTheSeat.setBounds(10, 59, 297, 16);
        txtrifTheSeat.setEditable(false);
        contentPane.add(txtrifTheSeat);

        JLabel info = new JLabel("INFO:");
        info.setBounds(10, 147, 46, 14);
        contentPane.add(info);

        JTextArea txtrWouldYouLike = new JTextArea();
        txtrWouldYouLike.setFont(new Font("Calibri", Font.PLAIN, 16));
        txtrWouldYouLike.setBackground(SystemColor.menu);
        txtrWouldYouLike.setText("Would you like to give us additional information?");
        txtrWouldYouLike.setBounds(10, 108, 414, 28);
        txtrWouldYouLike.setEditable(false);
        contentPane.add(txtrWouldYouLike);

        textAreaInfo = new JTextArea(5, 20);
        textAreaInfo.setLineWrap(true);
        textAreaInfo.setWrapStyleWord(true);
        textAreaInfo.setBounds(20, 172, 404, 39);
        contentPane.add(textAreaInfo);

        // Exit button
        JButton btnExit = new JButton("EXIT");
        btnExit.setBounds(218, 227, 89, 23);
        contentPane.add(btnExit);
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textAreaInfo.setText(seatBackend.cancelOperation());
                System.exit(0);
            }
        });

        // Save/Book button
        JButton btnSave = new JButton("SAVE");
        btnSave.setBounds(317, 227, 89, 23);
        contentPane.add(btnSave);
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedSeat = (int) comboBoxSeats.getSelectedItem();
                if (seatBackend.bookSeat(selectedSeat)) {
                    textAreaInfo.setText("Seat " + selectedSeat + " successfully booked!");
                } else {
                    textAreaInfo.setText("Seat " + selectedSeat + " is already taken. Please select a different seat.");
                }
            }
        });
    }
}
