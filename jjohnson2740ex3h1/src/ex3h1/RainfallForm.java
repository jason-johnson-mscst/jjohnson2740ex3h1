package ex3h1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class RainfallForm extends JFrame {

	private JPanel contentPane;
	private JList rainfallList;
	private JLabel lowLabel;
	private JLabel highLabel;
	private JLabel avgLabel;
	private JLabel totLabel;
	private JTextField inputMonthTextField;
	private String[] strRainfall = {"1.1", "2.2", "3.3", "4.4", "5.5", "6.6", "7.7", "8.8", "9.9", "10.0", "11.1", "12.2"};
	private JButton btnUpdate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RainfallForm frame = new RainfallForm();
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
	public RainfallForm() {
		setTitle("JJohnson Exercise 3H1: Rainfall Arrays");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 437);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("ColorChooser.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMonthlyRainfall = new JLabel("Monthly Rainfall:");
		lblMonthlyRainfall.setBounds(0, 0, 94, 14);
		contentPane.add(lblMonthlyRainfall);
		
		JList monthList = new JList();
		monthList.setBackground(UIManager.getColor("ColorChooser.background"));
		monthList.setEnabled(false);
		monthList.setModel(new AbstractListModel() {
			String[] values = new String[] {"01 Jan", "02 Feb", "03 Mar", "04 Apr", "05 May", "06 June", "07 July", "08 Aug", "09 Sept", "10 Oct", "11 Nov", "12 Dec"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		monthList.setBounds(27, 46, 49, 222);
		contentPane.add(monthList);
		
		rainfallList = new JList(strRainfall);
		rainfallList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				do_rainfallList_valueChanged(arg0);
			}
		});
		rainfallList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		rainfallList.setBounds(93, 44, 54, 224);
		contentPane.add(rainfallList);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(175, 51, 54, 14);
		contentPane.add(lblTotal);
		
		JLabel lblAverage = new JLabel("Average:");
		lblAverage.setBounds(175, 76, 54, 14);
		contentPane.add(lblAverage);
		
		JLabel lblHighest = new JLabel("Highest:");
		lblHighest.setBounds(175, 101, 54, 14);
		contentPane.add(lblHighest);
		
		JLabel lblLowest = new JLabel("Lowest:");
		lblLowest.setBounds(175, 126, 54, 14);
		contentPane.add(lblLowest);
		
		totLabel = new JLabel("0.0");
		lblTotal.setLabelFor(totLabel);
		totLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		totLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		totLabel.setBounds(237, 45, 61, 18);
		contentPane.add(totLabel);
		
		avgLabel = new JLabel("0.0");
		lblAverage.setLabelFor(avgLabel);
		avgLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		avgLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		avgLabel.setBounds(237, 74, 61, 18);
		contentPane.add(avgLabel);
		
		highLabel = new JLabel("0.0");
		lblHighest.setLabelFor(highLabel);
		highLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		highLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		highLabel.setBounds(237, 99, 61, 18);
		contentPane.add(highLabel);
		
		lowLabel = new JLabel("0.0");
		lblLowest.setLabelFor(lowLabel);
		lowLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lowLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lowLabel.setBounds(237, 124, 61, 18);
		contentPane.add(lowLabel);
		
		JButton calculateButton = new JButton("Calculate");
		calculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_calculateButton_actionPerformed(arg0);
			}
		});
		calculateButton.setBounds(225, 155, 89, 23);
		contentPane.add(calculateButton);
		
		inputMonthTextField = new JTextField();
		inputMonthTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		inputMonthTextField.setText("0.00");
		inputMonthTextField.setBounds(93, 292, 54, 20);
		contentPane.add(inputMonthTextField);
		inputMonthTextField.setColumns(10);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setEnabled(false);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnUpdate_actionPerformed(e);
			}
		});
		btnUpdate.setBounds(76, 323, 89, 23);
		contentPane.add(btnUpdate);
	}
	protected void do_calculateButton_actionPerformed(ActionEvent arg0) {
		//create rainfall object store pass it array
		Rainfall rainfall = new Rainfall(strRainfall);
		// create new decimal format object
		DecimalFormat fmt = new DecimalFormat("#0.0");
		//display pass rainfall to getTotal
		totLabel.setText(fmt.format(rainfall.getTotal()));
		avgLabel.setText(fmt.format(rainfall.getAvg()));
		highLabel.setText(fmt.format(rainfall.getHigh()));
		lowLabel.setText(fmt.format(rainfall.getLow()));
	}
	
	
	protected void do_btnUpdate_actionPerformed(ActionEvent e) {
		// go to JList, get selected value (so we know where to place the new value), store in selected INDEX variable. 
		int selectedIndex = rainfallList.getSelectedIndex();
		
		//go to text field, get text, convert to double, store in variable newValue
		double newValue = Double.parseDouble(inputMonthTextField.getText());
		/* 
		   take newValue and convert the double back to a string, then use it to populate
		   the selected index of the array identified above. 
		*/ 
		strRainfall[selectedIndex] = Double.toString(newValue);
		// refresh the JList
		rainfallList.repaint();
		
		//set update button to disabled, and set corresponding textbox value to 0.0
		btnUpdate.setEnabled(false);
		inputMonthTextField.setText("0.0");
		
		//reset values at right:
		totLabel.setText("");
		avgLabel.setText("");
		highLabel.setText("");
		lowLabel.setText("");
	}
	
	
	protected void do_rainfallList_valueChanged(ListSelectionEvent arg0) {
		//Set button to enabled
		btnUpdate.setEnabled(true);
		//go to JList, get selected VALUE, typecast to string, set as label value.
		inputMonthTextField.setText((String) rainfallList.getSelectedValue());
		//Request focus bring focus to text field.
		inputMonthTextField.requestFocus();
		//Select all text field so user can just type.
		inputMonthTextField.selectAll();
	}
}
