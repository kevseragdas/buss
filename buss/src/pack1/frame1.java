package pack1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class frame1 extends JFrame {

    private JPanel contentPane;
    private RouteSelectionBackend routeBackend;
    private TicketSummaryBackend ticketBackend;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame1 frame = new frame1();
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
    public frame1() {
        // Initialize backends
        routeBackend = new RouteSelectionBackend();
        ticketBackend = new TicketSummaryBackend();

        setTitle("Bus Ticket Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel startPoint = new JLabel("Choose a Departure City:");
        startPoint.setFont(new Font("Tahoma", Font.PLAIN, 15));
        startPoint.setBounds(10, 11, 200, 34);
        contentPane.add(startPoint);

        JComboBox<String> cbStartPoint = new JComboBox<>();
        cbStartPoint.setBounds(220, 19, 150, 22);
        contentPane.add(cbStartPoint);
        cbStartPoint.addItem("İstanbul");
        cbStartPoint.addItem("İzmir");
        cbStartPoint.addItem("Ankara");
        cbStartPoint.addItem("Gümüşhane");
        cbStartPoint.addItem("Sivas");

        JLabel endPoint = new JLabel("Choose a Destination City:");
        endPoint.setFont(new Font("Tahoma", Font.PLAIN, 15));
        endPoint.setBounds(10, 54, 200, 20);
        contentPane.add(endPoint);

        JComboBox<String> cbEndPoint = new JComboBox<>();
        cbEndPoint.setBounds(220, 52, 150, 22);
        contentPane.add(cbEndPoint);
        cbEndPoint.addItem("İstanbul");
        cbEndPoint.addItem("İzmir");
        cbEndPoint.addItem("Ankara");
        cbEndPoint.addItem("Gümüşhane");
        cbEndPoint.addItem("Sivas");

        JLabel selectDate = new JLabel("Select Date:");
        selectDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
        selectDate.setBounds(10, 98, 141, 14);
        contentPane.add(selectDate);

        JComboBox<String> cbDay = new JComboBox<>();
        cbDay.setBounds(109, 125, 50, 22);
        contentPane.add(cbDay);
        for (int i = 1; i <= 31; i++) {
            cbDay.addItem(String.valueOf(i));
        }

        JComboBox<String> cbMonth = new JComboBox<>();
        cbMonth.setBounds(247, 125, 50, 22);
        contentPane.add(cbMonth);
        for (int i = 1; i <= 12; i++) {
            cbMonth.addItem(String.valueOf(i));
        }

        JComboBox<String> cbYear = new JComboBox<>();
        cbYear.setBounds(368, 125, 70, 22);
        contentPane.add(cbYear);
        for (int i = 2023; i <= 2030; i++) {
            cbYear.addItem(String.valueOf(i));
        }

        JLabel selectTime = new JLabel("Select Time:");
        selectTime.setFont(new Font("Tahoma", Font.PLAIN, 13));
        selectTime.setBounds(10, 187, 86, 14);
        contentPane.add(selectTime);

        JComboBox<String> cbTimeDetails = new JComboBox<>();
        cbTimeDetails.setBounds(114, 187, 100, 22);
        contentPane.add(cbTimeDetails);
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 60; j += 30) {
                cbTimeDetails.addItem(String.format("%02d:%02d", i, j));
            }
        }

        JButton btnSave = new JButton("SAVE");
        btnSave.setBounds(320, 290, 100, 30);
        contentPane.add(btnSave);

        JButton btnExit = new JButton("EXIT");
        btnExit.setBounds(200, 290, 100, 30);
        contentPane.add(btnExit);

        // Save Button Action
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String start = (String) cbStartPoint.getSelectedItem();
                String end = (String) cbEndPoint.getSelectedItem();
                String date = cbDay.getSelectedItem() + "/" + cbMonth.getSelectedItem() + "/" + cbYear.getSelectedItem();
                String time = (String) cbTimeDetails.getSelectedItem();

                if (start.equals(end)) {
                    JOptionPane.showMessageDialog(contentPane, "Departure and destination cities must be different.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                routeBackend.selectRoute(start + " to " + end);
                routeBackend.selectDate(date);
                routeBackend.selectTime(time);

                if (routeBackend.isSelectionComplete()) {
                    String ticketDetails = "Route: " + start + " to " + end + "\nDate: " + date + "\nTime: " + time;
                    ticketBackend.generateTicketID();
                    ticketBackend.setTicketDetails(ticketDetails);

                    // Open the outputoflist frame
                    outputoflist outputFrame = new outputoflist(ticketBackend.getTicketSummary());
                    outputFrame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Error: Please complete all selections.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Exit Button Action
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
