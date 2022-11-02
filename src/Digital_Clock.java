import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.time.LocalDateTime;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Digital_Clock extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JFrame frame;

	private final int WINDOW_HEIGHT = 500;
	private final int WINDOW_WIDTH = 500;
	private int hours;
	private int mins;
	int seconds;
	private String hoursString;
	private String secondsString;
	private String minutesString;
	public String Time = " ";
	private Font timeFont = new Font("Arial", Font.CENTER_BASELINE, 60);
	private Font titleFont = new Font("Arial", Font.CENTER_BASELINE, 30);



	public Digital_Clock() {

		setFrame();
		setLabel();
		setButton();
		updateClock();
		checkTime();
		

	}

	public static void main(String[] args) {
		new Digital_Clock();

	}

	public void paint(Graphics g) {
		
		//create a paint method that draws to the screen
		super.paint(g);
		g.setFont(timeFont);
		g.setColor(Color.BLUE);
		g.drawString(this.Time, 130, 230);

	}

	private void setLabel() {
		//set properties for the Header
		JLabel Header = new JLabel();
		Header.setText("LDot's Digital Clock");
		Header.setFont(titleFont);
		Header.setBounds(110, 0, 400, 50);
		Header.setVisible(true);
		add(Header);
	}

	private void setButton() {
		//instantiate buttons 
		Button logBtn = new Button("Log Time");
		Button quitBtn = new Button("Quit");
		Button setAlarmBtn = new Button("Set Alarm");
		Button changeBackgroundBtn = new Button("Change Background");
		//set properties of buttons
		quitBtn.setBounds(50, 400, 100, 50);
		setAlarmBtn.setBounds(350, 400, 100, 50);
		changeBackgroundBtn.setBounds(170, 300, 150, 50);
		logBtn.setBounds(200, 400, 100, 50);
		
		//add buttons to panel
		add(setAlarmBtn);
		add(changeBackgroundBtn);
		add(quitBtn);
		add(logBtn);
		
		//add a new actionlistener to button and override the action performed method which is called when 
		//the actionlistener picks up an event.
		setAlarmBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				setAlarmFrame();
			}

		});
		//add a new actionlistener to button and override the action performed method which is called when 
		//the actionlistener picks up an event.
		logBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent lb) {

				System.out.println(Time);

			}

		});
		//add a new actionlistener to button and override the action performed method which is called when 
		//the actionlistener picks up an event.
		quitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent qt) {
				// TODO Auto-generated method stub
				System.exit(0);
			}

		});

	}

	private void setFrame() {
		//instantiate frame and set properties of frame
		frame = new JFrame();
		frame.setTitle("LDot's Digital Clock");
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setLocation(100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.add(this);

	}
	
	private void setAlarmFrame() {
		//instantiate alarm_Window to open a new window when method is called
		Alarm_Window alarmWindow = new Alarm_Window("Set An Alarm");
		alarmWindow.setVisible(true);

		alarmWindow.setLocation(495, 0);

	}
	private void checkTime() {
		//needs work on
		//TODO get alarm Working
		ActionListener task2 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
			
			
		};
		Timer timer = new Timer(100,task2);
		timer.setRepeats(false);
		timer.start();
		
	}
	private void setTime() {
		//stores the current time (HHMMSS) in this classes variables.
		this.hours = LocalDateTime.now().getHour();
		this.mins = LocalDateTime.now().getMinute();
		this.seconds = LocalDateTime.now().getSecond();

	}
	//called Whenever Repaint is called.
	private void update() {
		//create action listener to perform
		ActionListener task = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				updateClock();
				
			}

		};
		Timer timer = new Timer(100, task);
		timer.setRepeats(false);
		timer.start();

	}

	private void setString() {
		//error handling and conditional statements used to ensure the right formatting of the string is done
		if (seconds < 10) {
			secondsString = "0";
		} else {
			secondsString = "";
		}

		if (mins < 10) {
			minutesString = "0";
		} else {
			minutesString = "";
		}

		if (hours < 10) {
			hoursString = "0";
		} else {
			hoursString = "";
		}
	
		secondsString += String.valueOf(seconds);
		minutesString += String.valueOf(mins);
		hoursString += String.valueOf(hours);

		Time = hoursString + ":" + minutesString + ":" + secondsString;

	}

	private void updateClock() {
		setTime();
		setString();
		update();
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
