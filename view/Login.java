package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;

public class Login implements Viewable {
	private JFrame frame;
	private JPanel pane;
	private JButton login;
	private String tier;

	private void initialize() {
		frame = new JFrame("Login");
		frame.setSize(200, 200);
		pane = new JPanel(new BorderLayout());
		login = new JButton("Login");
		frame.add(pane);
		pane.add(login);
		tier = new String();
		LoginPanel loginPanel = new LoginPanel();

		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, loginPanel,
						"Please input user data", JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					System.out.println(Controller.getController().login(
							loginPanel.loginName.getText(),
							loginPanel.password.getText()));
					if (Controller.getController().login(
							loginPanel.loginName.getText(),
							loginPanel.password.getText())) {
						if (Controller.getController().getStatus().equals("a")) {
							new SplashAdmin();
							close();
						} else if (Controller.getController().getStatus()
								.equals("b")) {
							new SplashMP();
							close();
						} else {
							new SplashPatient();
							close();
						}

					} else {
						JOptionPane.showMessageDialog(null,
								"You did not input valid user data",
								"Login Error", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		open();
	}

	@Override
	public void open() {
		frame.setVisible(true);

	}

	@Override
	public void close() {
		frame.setVisible(false);
	}

	public Login() {
		initialize();
	}

	@SuppressWarnings("serial")
	private class LoginPanel extends JPanel {
		private JTextField loginName, password;

		private LoginPanel() {
			super(new FlowLayout());
			loginName = new JTextField(10);
			password = new JTextField(10);
			this.add(new JLabel("Login:"));
			this.add(loginName);
			this.add(Box.createHorizontalStrut(this.getWidth()));
			this.add(new JLabel("Password:"));
			this.add(password);
		}
	}
}