import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class GUI implements ActionListener{
    private JFrame mainFrame;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JLabel label;
    private JLabel pictureLabel;
    private JLabel label3;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JTextField textField1;
    private JTextArea textArea;

    private int nClicks = 0;

    public static void main(String[] args) {
        GUI myGUI= new GUI();
    }
    public GUI(){
        mainFrame = new JFrame();

        label = new JLabel("Clicks: 0");
        pictureLabel = new JLabel();
        try{
            BufferedImage myPicture = ImageIO.read(new File("Sorellina.jpg"));
            pictureLabel.setIcon(new ImageIcon(myPicture));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        button1 = new JButton("Click here");
        button1.addActionListener(this); //makes button clickable
        button2 = new JButton ();
        button2.addActionListener(this);
        pictureLabel = new JLabel ();
        panel1 = new JPanel();
        panel2= new JPanel();
        panel3 = new JPanel();
        textArea = new JTextArea();
        textField1 = new JTextField();


        int borderSize = 10;
        panel1.setBorder(BorderFactory.createEmptyBorder(borderSize,borderSize,borderSize,borderSize));
        panel1.setLayout(new BorderLayout());
//        panel1.add(panel2, BorderLayout.WEST);
//        panel1.add(panel3, BorderLayout.EAST);
        panel1.add(pictureLabel, BorderLayout.NORTH);
   //     panel1.add(textArea, BorderLayout.CENTER);

      //  panel2.setLayout(new GridLayout(3,1));

        panel2.add(textField1);
   //     panel2.add(button2);
    //    panel2.add(button3);

        panel3.setLayout(new GridLayout(3,1));
 //       panel3.add(textField1);
        textArea = new JTextArea();
        for(int i=1; i<5; i++){
            textArea.setText(textArea.getText()+"pizza " + i + "\n");
        }
//        panel1.add(textArea, BorderLayout.CENTER);
        panel1.add(pictureLabel, BorderLayout.CENTER);

        textArea.setEditable(false);

        mainFrame.add(panel1);

//        mainFrame.pack();
        mainFrame.setVisible(true);
        mainFrame.setSize(600,500);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //      System.out.println("button clicked");
  //      nClicks ++;
   //     label.setText("clicks: " + nClicks);
    }






}
