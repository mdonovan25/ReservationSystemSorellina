
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Restaurant implements ActionListener {

    private ArrayList<Reservation> reservations = new ArrayList<>();

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


    public Restaurant(){
        for(int i=0; i<5; i++){
            reservations.add(i, new Reservation());
        }
        setUpGUI();
 //       addReservation();

   //            displayReservations();
   //            sortByNPeople();
    //                sortByTimePlaced();
   //     sortByTimeFor();
        displayReservations();
        displayOnGUI();


    }

    public void setUpGUI() {
        mainFrame = new JFrame();
        panel1 = new JPanel();
        panel2 = new JPanel();
        pictureLabel = new JLabel();
        textField1 = new JTextField();
        textArea = new JTextArea();
        label = new JLabel();
        label3 = new JLabel();
        button1 = new JButton("# people");
        button2 = new JButton("timePlaced");
        button3 = new JButton("timeFor");
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);

        int borderSize = 10;
        panel1.setBorder(BorderFactory.createEmptyBorder(borderSize, borderSize, borderSize, borderSize));
        panel1.setLayout(new BorderLayout());
//        panel1.add(panel2, BorderLayout.WEST);
//        panel1.add(panel3, BorderLayout.EAST);
        panel1.add(pictureLabel, BorderLayout.NORTH);

        label = new JLabel("Clicks: 0");
        pictureLabel = new JLabel();
        try {
            BufferedImage myPicture = ImageIO.read(new File("Sorellina.jpg"));
            pictureLabel.setIcon(new ImageIcon(myPicture));
        } catch (Exception e) {
            e.printStackTrace();
        }
        textArea = new JTextArea();
        for (int i = 0; i < reservations.size(); i++) {

            textArea.setText(textArea.getText() + "reservation " + i + ": " + (int)reservations.get(i).getNPeople() + ",  " + reservations.get(i).getTimePlacedString() + ",  " + reservations.get(i).getTimeForString() + "\n\n");
        }

        //     textField1 = new JTextField();


        panel1.add(label3, BorderLayout.CENTER);
        panel1.add(pictureLabel, BorderLayout.NORTH);
        panel1.add(textArea, BorderLayout.WEST);
        panel1.add(textField1, BorderLayout.EAST);
        //      panel1.add(button1, BorderLayout.EAST);

        label3.setLayout(new GridLayout (3,1));
        label3.add(button1);
        button1.setSize(100,100);
        label3.add(button2);
        button2.setSize(100,100);
        label3.add(button3);
        button3.setSize(100,100);
        //     label3.add(textField1);


        pictureLabel.setSize(200, 100);
        textField1.setSize(100,30);

        textArea.setEditable(false);

        mainFrame.add(panel1);

//        mainFrame.pack();
        mainFrame.setVisible(true);
        mainFrame.setSize(800, 800);
    }

    public void actionPerformed(ActionEvent e) {
        Object buttonClicked = e.getSource();
        //      if(buttonClicked == button1){
        //         System.out.println("button clicked");
        //         String nPeople = textField1.getText();
        //         System.out.println("new reservation for " + Integer.parseInt(nPeople) + " people");
        if(buttonClicked == button1) {
            //        textArea.setText("");
            sortByNPeople();
            //      textArea.setText(textArea.getText() + "reservation " + i + ": " + (int)reservations.get(i).getNPeople() + " " + reservations.get(i).getTimePlacedString() + " " + reservations.get(i).getTimeForString() + "\n");

            displayOnGUI();
        }
        if(buttonClicked == button2){
            sortByTimePlaced();
            displayOnGUI();
        }

        if(buttonClicked == button3){
            sortByTimeFor();
            displayOnGUI();
        }

        //      System.out.println("button clicked");
        //      nClicks ++;
        //     label.setText("clicks: " + nClicks);


    }

    public void displayReservations(){
        //       for(int i=0; i<reservations.size(); i++){
        //         reservations.get(i).printInfo();
        //     }
        //     System.out.println("****");
        for(Reservation r : reservations){
            r.printInfo();
        }

    } //might delete after GUI exists

    public void displayOnGUI(){

        textArea.setText("");
        for(int i = 0; i< 5; i++)
        textArea.setText(textArea.getText()+ reservations.get(i).getInfo() + "\n");

    //    textArea.setText(reservations.get(i).getInfo());
    }

 //   public void addReservation(){
 //       reservations.add(new Reservation());

        //       System.out.println(reservations.get(0).getNPeople()+" people ");
        //      System.out.println(reservations.get(0).getTimePlaced()+", time placed");
        //      System.out.println(reservations.get(0).getTimeFor()+", time for");
 //   }

    public void nameSort(){


    }

    public void sortByNPeople(){
        //insertion sort
        for(int i=1; i<reservations.size(); i++){
            int j = i;
            while(j>0 && reservations.get(j).getNPeople()<reservations.get(j-1).getNPeople()){
                Reservation temp = reservations.get(j-1);
                reservations.set(j-1,reservations.get(j));
                reservations.set(j, temp);
                j--;
            }

        }
    }

    public void sortByTimePlaced(){
        //selection sort
        int min;
        for(int j=0; j<reservations.size()-1; j++){
            min=j;
            for(int i =j+1; i<reservations.size(); i++){
                if (reservations.get(i).getTimePlaced()<reservations.get(min).getTimePlaced()){
                    min = i;
                }
            }
            if(min != j){
                Reservation temp = reservations.get(j);
                reservations.set(j, reservations.get(min));
                reservations.set(min, temp);
            }
        }



    }

    public void sortByTimeFor(){
        //bubble sort

        boolean madeSwap = false;
        for(int j=1; j<reservations.size(); j++) {
            madeSwap=false;
            for (int i = 1; i < reservations.size()-(j-1); i++) {
                if (reservations.get(i-1).getTimeFor() > reservations.get(i).getTimeFor()) {
                    Reservation temp = reservations.get(i);
                    reservations.set(i, reservations.get(i-1));
                    reservations.set(i-1, temp);
                    madeSwap=true;
                }

            }
            if(madeSwap==false){
                break;
            }
            //      printArray();
        }



 //       for(int i=1; i<reservations.size(); i++){
 //           int j = i;
  //          while(j>0 && reservations.get(j).getTimeFor()<reservations.get(j-1).getTimeFor()){
   //             Reservation temp = reservations.get(j-1);
   //             reservations.set(j-1,reservations.get(j));
    //            reservations.set(j, temp);
    //            j--;
     //       }

        }



    public static void main(String[] args) {
        Restaurant Sorellina = new Restaurant();
    }

}
