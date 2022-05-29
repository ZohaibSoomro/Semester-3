import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class StopWatch {

	private JFrame frmStopWatchBy;
	private JTextField hmsTF;
	private JTextField msecsTf;
	private JLabel mainLbl;
	private JMenuItem exitItem;
	private int miliSeconds = 0;
	private int seconds = 0;
	private int mins = 0;
	private int hours = 0;
	private Thread thread = null;
	private boolean started = false;
	private boolean stopped = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StopWatch window = new StopWatch();
					window.frmStopWatchBy.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e, "Error", 0);
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StopWatch() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmStopWatchBy = new JFrame();
		frmStopWatchBy.setResizable(false);
		frmStopWatchBy.setTitle("Mini Project By Zohaib Hassan Soomro");
		frmStopWatchBy.getContentPane().setBackground(new Color(224, 255, 255));
		frmStopWatchBy.setBounds(100, 30, 957, 595);
		frmStopWatchBy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStopWatchBy.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 220));
		panel.setBounds(80, 116, 468, 330);
		frmStopWatchBy.getContentPane().add(panel);
		panel.setLayout(null);

		hmsTF = new JTextField();
		hmsTF.setBackground(new Color(255, 250, 250));
		hmsTF.setText("00:00:00");
		hmsTF.setEditable(false);
		hmsTF.setFont(new Font("Jokerman", Font.BOLD, 40));
		hmsTF.setBounds(88, 92, 216, 97);
		panel.add(hmsTF);
		hmsTF.setColumns(10);

		msecsTf = new JTextField();
		msecsTf.setBackground(new Color(255, 250, 250));
		msecsTf.setText("00");
		msecsTf.setEditable(false);
		msecsTf.setFont(new Font("Jokerman", Font.BOLD, 40));
		msecsTf.setColumns(10);
		msecsTf.setBounds(303, 92, 79, 97);
		panel.add(msecsTf);

		JButton startBtn = new JButton("Start");
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (!started && stopped) {
						thread = new Thread(new Runnable() {

							@Override
							public void run() {
								while (true) {
									// increment conditions
									if (miliSeconds == 60) {
										seconds++;
										miliSeconds = 0;
									}
									if (seconds == 60) {
										mins++;
										seconds = 0;
									}
									if (mins == 60) {
										hours++;
										mins = 0;
									}

									// spam conditions
									if (miliSeconds <= 9) {
										msecsTf.setText("0" + miliSeconds);
									} else {
										msecsTf.setText(Integer.toString(miliSeconds));
									}

									if (seconds <= 9) {
										hmsTF.setText(hours + ":" + mins + ":0" + seconds);
									} else {
										hmsTF.setText(hours + ":" + mins + ":" + seconds);
									}

									if (mins <= 9) {
										hmsTF.setText(hours + ":0" + mins + ":" + seconds);
										if (seconds <= 9) {
											hmsTF.setText(hours + ":0" + mins + ":0" + seconds);
										}
									}

									if (hours <= 9) {
										hmsTF.setText("0" + hours + ":" + mins + ":" + seconds);
										if (mins <= 9) {
											hmsTF.setText("0" + hours + ":0" + mins + ":" + seconds);
											if (seconds <= 9) {
												hmsTF.setText("0" + hours + ":0" + mins + ":0" + seconds);
											}
										}

									}

									// 1 milliseconds gap
									miliSeconds++;
									try {
										Thread.sleep(16);
									} catch (InterruptedException e) {
										JOptionPane.showMessageDialog(frmStopWatchBy, e);
									}

								}

							}
						});
						thread.start();
						started = true;
						stopped = false;
					} else {
						JOptionPane.showMessageDialog(frmStopWatchBy, "Already Started");
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frmStopWatchBy, e);
				}

			}
		});
		startBtn.setFont(new Font("Jokerman", Font.BOLD, 20));
		startBtn.setForeground(new Color(0, 0, 255));
		startBtn.setBackground(new Color(250, 250, 210));
		startBtn.setBounds(74, 205, 135, 48);
		panel.add(startBtn);

		JButton stopBtn = new JButton("Stop");
		stopBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (started && !stopped) {
						thread.stop();
						stopped = true;
						started = false;
					} else {
						JOptionPane.showMessageDialog(frmStopWatchBy, "Already Stopped!");
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frmStopWatchBy, e);
				}
			}
		});
		stopBtn.setForeground(Color.BLUE);
		stopBtn.setFont(new Font("Jokerman", Font.BOLD, 20));
		stopBtn.setBackground(new Color(250, 250, 210));
		stopBtn.setBounds(247, 205, 135, 48);
		panel.add(stopBtn);

		JButton resetBtn = new JButton("Reset");
		resetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hmsTF.setText("00:00:00");
				msecsTf.setText("00");
				miliSeconds = 0;
				seconds = 0;
				mins = 0;
				hours = 0;
				try {
					if (started && !stopped) {
						thread.stop();
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frmStopWatchBy, e);
				}
				started = false;
				stopped = true;
				thread=null;
				JOptionPane.showMessageDialog(frmStopWatchBy, "Reset Done");
			}
		});
		resetBtn.setBounds(169, 266, 135, 48);
		panel.add(resetBtn);
		resetBtn.setForeground(Color.BLUE);
		resetBtn.setFont(new Font("Jokerman", Font.BOLD, 20));
		resetBtn.setBackground(new Color(250, 250, 210));
		
		JLabel hourLbl = new JLabel("Hour");
		hourLbl.setToolTipText("Hours");
		hourLbl.setFont(new Font("Jokerman", Font.BOLD, 16));
		hourLbl.setBounds(103, 51, 57, 37);
		panel.add(hourLbl);
		
		JLabel lblMinutes = new JLabel("Mins");
		lblMinutes.setToolTipText("Minutes");
		lblMinutes.setFont(new Font("Jokerman", Font.BOLD, 16));
		lblMinutes.setBounds(177, 51, 57, 37);
		panel.add(lblMinutes);
		
		JLabel lblSeconds = new JLabel("Sec");
		lblSeconds.setToolTipText("Seconds");
		lblSeconds.setFont(new Font("Jokerman", Font.BOLD, 16));
		lblSeconds.setBounds(259, 51, 36, 37);
		panel.add(lblSeconds);
		
		JLabel lblMiliSecs = new JLabel("Milisec");
		lblMiliSecs.setToolTipText("Mili Seconds");
		lblMiliSecs.setFont(new Font("Jokerman", Font.BOLD, 16));
		lblMiliSecs.setBounds(312, 51, 62, 37);
		panel.add(lblMiliSecs);

		mainLbl = new JLabel("STOP WATCH BY 19SW42");
		mainLbl.setForeground(new Color(0, 0, 255));
		mainLbl.setFont(new Font("Jokerman", Font.BOLD, 30));
		mainLbl.setBounds(225, 16, 468, 84);
		mainLbl.setOpaque(true);
		mainLbl.setBackground(new Color(224, 255, 255));
		frmStopWatchBy.getContentPane().add(mainLbl);

		JLabel imgLbl = new JLabel("");
		imgLbl.setBounds(607, 116, 260, 300);
		//imgLbl.setIcon(new ImageIcon(getClass().getResource("/th.jpg")));
		frmStopWatchBy.getContentPane().add(imgLbl);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 99, 71));
		frmStopWatchBy.setJMenuBar(menuBar);

		JMenu mnMenu = new JMenu("Menu");
		mnMenu.setFont(new Font("Jokerman", Font.BOLD, 20));
		mnMenu.setForeground(Color.BLACK);
		menuBar.add(mnMenu);

		JMenuItem chngeBgItem = new JMenuItem("Change Background Color");
		chngeBgItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JColorChooser colorChooser = new JColorChooser();

				Color color = JColorChooser.showDialog(null, "Pick a color", Color.BLACK);
				frmStopWatchBy.getContentPane().setBackground(color);
				panel.setBackground(color);
				mainLbl.setBackground(color);

			}
		});
		chngeBgItem.setForeground(Color.BLUE);
		chngeBgItem.setFont(new Font("Jokerman", Font.BOLD, 20));
		mnMenu.add(chngeBgItem);

		exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?");
				if (answer == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 255));
		mnMenu.add(separator);

		JMenuItem chngeSwLbl = new JMenuItem("Change Stop Watch Label");
		chngeSwLbl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String changeLbl = JOptionPane.showInputDialog(null, "Enter text here", "Change Stop Watch Label",
						JOptionPane.INFORMATION_MESSAGE);
				if (!changeLbl.equals("")) {
					mainLbl.setText(changeLbl);
					JOptionPane.showMessageDialog(frmStopWatchBy, "Label Changed...", "Change Stop Watch Label",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(frmStopWatchBy, "PLease Enter something", "Label Change failed",
							JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		chngeSwLbl.setForeground(Color.BLUE);
		chngeSwLbl.setFont(new Font("Jokerman", Font.BOLD, 20));
		mnMenu.add(chngeSwLbl);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(0, 0, 255));
		mnMenu.add(separator_1);
		exitItem.setForeground(new Color(220, 20, 60));
		exitItem.setFont(new Font("Jokerman", Font.BOLD, 20));
		mnMenu.add(exitItem);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(new Color(0, 0, 255));
		mnMenu.add(separator_2);

		

	}
}
