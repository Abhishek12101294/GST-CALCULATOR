import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

// Swing framework  

public class GST extends JFrame implements ActionListener {
    JLabel l1;
    JLabel l2;
    JLabel l3;
      
    JTextField t1; 
    JTextField t2; 
    JButton b1;
    JButton b2;

    JTextArea ta;

    double totalGST = 0;
    

    GST() {

         // set the icon image of the JFrame
         ImageIcon icon = new ImageIcon("icon.jpg", "GST Calculator");

        setIconImage(icon.getImage());
        //set icon  image 
        setTitle("GST Calculator");
        // set titel of gst calculator
 
        // set theme online
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        l1 = new JLabel("Enter Item Name:");
        l1.setBounds(50, 50, 100, 20);
        add(l1);

        t1 = new JTextField();
        t1.setBounds(150, 50, 100, 20);
        add(t1);

        l2 = new JLabel("Enter Item Price:");
        l2.setBounds(50, 100, 100, 20);
        add(l2);

        t2 = new JTextField();
        t2.setBounds(150, 100, 100, 20);
        add(t2);

        b1 = new JButton("Add Item");
        b1.setBounds(70, 150, 100, 20);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Calculate GST");
        b2.setBounds(180, 150, 120, 20);
        b2.addActionListener(this);
        add(b2);

        ta = new JTextArea();
        ta.setBounds(300, 50, 200, 200);
        ta.setEditable(false);
        add(ta);

        l3 = new JLabel("Gst Calculator");
        l3.setBounds(50, 250, 200, 20);
        add(l3);

        setSize(550, 350);
        setLayout(null);
        setVisible(true);

        
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String s1 = t1.getText();
            String s2 = t2.getText();

            double price = Double.parseDouble(s2);
            double gst = (price * 18) / 100;

            String result = s1 + " - " + price + " - " + gst + "\n";
            ta.append(result);

            totalGST += gst;

            t1.setText("");
            t2.setText("");
        } 
        
        else if (e.getSource() == b2) {
            String result = "Total GST: " + totalGST;
            l3.setText(result);
        }
    }

    public static void main(String[] args) {
        new GST();
    }
}