import javax.swing.*;
import javax.swing.JLabel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.SimpleTimeZone;
import java.util.spi.CalendarNameProvider;

public class Main {
    public static void main(String[] args) {

       Frame m = new Frame();
    }
}

class Frame extends JFrame{


    Calendar calendar ;
    SimpleTimeZone timeZone;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    CalendarNameProvider calName;
    JLabel timeLabel, dayLabel, tzlabel;
    String time,day;

    Frame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("CLOCK");
        this.setLayout(new FlowLayout());
        this.setSize(450,300);

        this.setResizable(true);

        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");
        //timeZone = new SimpleTimeZone(" ");

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana",Font.PLAIN,100));
        timeLabel.setBackground(new Color(0, 128, 128));
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setOpaque(true);

        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Verdana",Font.PLAIN,100));
        dayLabel.setBackground(new Color(70, 130, 180));
        dayLabel.setForeground(Color.RED);
        dayLabel.setOpaque(true);

        this.add(timeLabel);
        this.add(dayLabel);
        this.setVisible(true);
        setTime();

    }

    public void  setTime(){
        while(true) {
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);
            day =  dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }
}