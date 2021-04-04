import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Alarm_Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panel = new JPanel();

	private final int ALARM_WINDOW_HEIGHT = 400;

	private final int ALARM_WINDOW_WIDTH = 400;
	private JComboBox<String> hourCombo;
	private JComboBox<String> minCombo;
	private Font timeFont = new Font("Arial", Font.CENTER_BASELINE, 21);

	private String[] hourCombos = new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11",
			"12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "" + "23", "24" };
	private String[] minutesCombos = new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
			"11", "" + "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
			"28", "29", "30" + "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45",
			"46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" };

	private boolean clicked = false;
	private String alarmHour;
	private String alarmMinute;
	private String alarmTime;

	protected Graphics g;

	Alarm_Window(String title) {
		setSize(ALARM_WINDOW_HEIGHT, ALARM_WINDOW_WIDTH);

		setResizable(false);
		init();
		add(panel);
	}

	private void init() {
		panel.setLayout(null);
		panel.setSize(ALARM_WINDOW_HEIGHT, ALARM_WINDOW_WIDTH);
		panel.setBackground(Color.gray);
		setWindow();
		

	}

	public void paint(Graphics g) {
		super.paint(g);
		if (clicked) {
			g.setFont(timeFont);
			g.drawString("An alarm has been set for " + alarmTime, 50, 70);
		}

	}

	private void setWindow() {
		JButton setAlarmBtn2 = new JButton("Set Alarm");
		hourCombo = new JComboBox<String>(hourCombos);
		minCombo = new JComboBox<String>(minutesCombos);

		setAlarmBtn2.setBounds(200, 150, 100, 40);

		hourCombo.setBounds(100, 150, 40, 40);
		minCombo.setBounds(150, 150, 40, 40);

		hourCombo.setForeground(Color.black);
		hourCombo.setBackground(Color.white);

		setAlarmBtn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clicked = true;
				alarmHour = (String) hourCombo.getSelectedItem();
				alarmMinute = (String) minCombo.getSelectedItem();
				alarmTime = alarmHour + ":" + alarmMinute;
				

				repaint();

			}
		});
		hourCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		minCombo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});

		panel.add(hourCombo);
		panel.add(minCombo);
		panel.add(setAlarmBtn2);
	}
	public String getAlarmTime() {
		return alarmTime; 
	}


}
