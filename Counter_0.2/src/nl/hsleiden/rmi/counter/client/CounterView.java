package nl.hsleiden.rmi.counter.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.bluewalrus.ExceptionDialog;

import nl.hsleiden.rmi.counter.server.Countable;

/**
 * This is the view who is responsible for showing the correct information of
 * the model Counter. Because this class extends UnicastRemoteObject it can
 * receive callbacks from the RMI server.
 * 
 * @author Alex van Manen
 * @version 0.2, June 2015
 *
 */
public class CounterView extends UnicastRemoteObject implements ActionListener,
		CounterObserver {

	private boolean enabled = false;
	private JFrame frame = new JFrame();
	private CounterController cc;
	private JLabel label = new JLabel();
	private JTextField textField1 = new JTextField();
	private JButton plusButton = new JButton("+");

	/**
	 * @param cc
	 *            CounterController object that needs to be linked to this view
	 * @param c
	 *            Counter object that needs to be linked to this view
	 * @throws RemoteException
	 *             when the connection between RMI client and server is
	 *             compromised
	 */
	public CounterView(CounterController cc, Countable c) throws RemoteException {
		try {
			c.addObserver(this);
		} catch (RemoteException e) {
			showException(e);
			e.printStackTrace();
		}
		this.cc = cc;
		frame.setBounds(50, 50, 200, 200);
		frame.setVisible(true);
		frame.setTitle("Rekenmachine");
		frame.setLayout(null);

		
		plusButton.setBounds(120, 10, 60, 40);
		frame.add(plusButton);

		plusButton.addActionListener(this);
		textField1.setBounds(10, 10, 100, 40);
		frame.add(textField1);
		frame.repaint();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setEnabled(false);
	}

	public void showNewValue(String value) {
		textField1.setText(value);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * nl.hsleiden.rmi.calculator.client.CounterObserver#modelChanged(nl.hsleiden
	 * .rmi.calculator.server.Counter)
	 */
	public void modelChanged(Countable t) throws RemoteException {
		String value = Integer.toString(t.getValue());
		showNewValue(value);
		plusButton.setEnabled(isEnabled()); // Enables this button if it is the turn of this View else it disables the button.
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			cc.cmdAddOne();
		} catch (RemoteException e2) {
			showException(e2);
			e2.printStackTrace();
		}
	}

	/**
	 * shows exception in a customized JDialog
	 * 
	 * @param e
	 *            exception that needs to be shown in the JDialog
	 */
	private void showException(Exception e) {
		ExceptionDialog ld = new ExceptionDialog("Unexpected System Error!",
				"Something hugely badly unexpectadly went awfully wrong", e);
		ld.setVisible(true);
	}
	
	/* (non-Javadoc)
	 * @see nl.hsleiden.rmi.counter.client.CounterObserver#isEnabled()
	 */
	public boolean isEnabled(){
		return enabled;
	}
	
	/* (non-Javadoc)
	 * @see nl.hsleiden.rmi.counter.client.CounterObserver#setEnabled(boolean)
	 */
	public void setEnabled(boolean enabled){
		this.enabled = enabled;
	}
}
