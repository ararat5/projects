import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javafx.scene.input.KeyCode.Q;

public class Secondamer {


    JFrame frame = new JFrame("Secondomer");

    JLabel lab1 = new JLabel("0.");
    JLabel  lab2 = new JLabel("0.");
    JLabel lab3 = new JLabel("0");
    JTextArea text = new JTextArea(10,7);

    JButton startButton = new JButton("Start");
    JButton stopButton = new JButton("Stop");
    JButton intervalButton = new JButton("Interval");
    JButton pauseButton = new JButton("Pause");

    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();

    Boolean start;
    Boolean stop;
    Boolean pause = false;

    long curtime;
    long time = (long) 0;
    long stoppedTime;


    int i =0;
    int j =0;
    int y=0;

    String k;
    String n="";
    String pauseButtonName;


    public  void GTO(){

        frame.setSize(300,300);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        lab1.setForeground(Color.red);
        lab2.setForeground(Color.red);
        lab3.setForeground(Color.red);
        startButton.setBackground(Color.GREEN);
        intervalButton.setBackground(Color.YELLOW);
        pauseButton.setBackground(Color.ORANGE);
        stopButton.setBackground(Color.RED);


        p1.add(lab1);
        p1.add(lab2);
        p1.add(lab3);
        p2.add(startButton);
        p2.add(intervalButton);
        p3.add(pauseButton);
        p3.add(stopButton);

        text.setSize(5,5);
        frame.add(text);

        frame.add(p1, new GridBagConstraints(1,0,1,1,1,1,
                GridBagConstraints.CENTER,GridBagConstraints.CENTER,
                new Insets(0,0,0,0),0,0));

        frame.add(p2, new GridBagConstraints(1,1,1,1,1,1,
                GridBagConstraints.CENTER,GridBagConstraints.CENTER,
                new Insets(0,0,0,0),0,0));

        frame.add(p3, new GridBagConstraints(1,2,1,4,1,1,
                GridBagConstraints.CENTER,GridBagConstraints.CENTER,
                new Insets(0,0,0,0),0,0));

        frame.add(text, new GridBagConstraints(2,0,1,1,1,1,
                GridBagConstraints.CENTER,GridBagConstraints.CENTER,
                new Insets(0,0,0,0),0,0));


        frame.pack();
        frame.setVisible(true);


        startButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                if(time==0) {
                    curtime = System.currentTimeMillis();
                    start = true;
                    stop = false;
                    lab1.setText("0.");
                    lab2.setText("0.");
                    j = 0;
                    i = 0;
                    text.setText(" ");
                    n = " ";
                }else{
                    start=true;


                }
                }

        });

        intervalButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                k = String.valueOf(j)+"."+String.valueOf(i)+"."+ String.valueOf(time);
                n=n+"\n"+k;
                text.setText(n);
                y++;
                if(y==10){ text.setText(" "); n = " "; y=0; }
            }
        });


        pauseButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {



                pause=true;

                if(pauseButton.getText()=="Pause"){

                    start=false;
                    pauseButton.setBackground(Color.green);
                    pauseButtonName= "resume";

                }if(pauseButton.getText()=="resume"){


                    start=true;
                    pauseButton.setBackground(Color.yellow);
                    pauseButtonName= "Pause";

                }



            }
        });


        stopButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                pause=false;
                start = false;
                stop= true;

            }
        });


        while(true){
            try {
                if (start) {
                    time = (System.currentTimeMillis() - curtime) / 10;
                    lab3.setText(String.valueOf(time));



                    if (time == 100) {
                        i++;
                        lab2.setText(String.valueOf(i) + ".");
                        curtime = System.currentTimeMillis();
                        if (i == 60) {
                            j++;
                            lab1.setText(String.valueOf(j) + ".");
                            lab2.setText("0.");
                            i = 0;
                        }
                    }
                }

                if(pause){

                    pauseButton.setText(pauseButtonName);



                }


                if (stop) {
                    time = 0;
                    i = 0;
                    j = 0;
                    lab3.setText(String.valueOf(time));
                    lab2.setText(String.valueOf(i) + ".");
                    lab1.setText(String.valueOf(j) + ".");
                    n=" ";
                    text.setText(n);

                }


            }
            catch(Exception e){};
        }
    }


    public static void main(String[]args){

        Secondamer ti = new Secondamer();
        ti.GTO();
    }
}