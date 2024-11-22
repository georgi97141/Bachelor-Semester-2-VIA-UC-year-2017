package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import controller.Controller;

public class SplashPatient implements Viewable {
	private JFrame frame;
	private JButton viewRecords;
	private JButton viewPrescriptions;
	private ActionListener prescriptionsListener;
	private ActionListener recordsListener;

	public void initialize() {
		frame = new JFrame();
		frame.setSize(400, 200);
		viewPrescriptions = new JButton("View Prescriptions");
		viewRecords = new JButton("View Records");
		viewRecords.addActionListener(recordsListener);
		viewPrescriptions.addActionListener(prescriptionsListener);

		recordsListener = new ActionListener() {
			RecordsPanel recordsPanel;

			@Override
			public void actionPerformed(ActionEvent e) {
				String cpr = Controller.getController().getUserCPR();

				recordsPanel = new RecordsPanel(Controller.getController()
						.getRecords(cpr));

				JOptionPane.showConfirmDialog(null, recordsPanel.pane,
						"Records", JOptionPane.OK_CANCEL_OPTION);

			}
		};

		prescriptionsListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String cpr = Controller.getController().getUserCPR();
				PrescriptionPanel prescriptionPanel = new PrescriptionPanel(
						Controller.getController().getPrescriptions(cpr));

				JOptionPane.showConfirmDialog(null, prescriptionPanel.pane,
						"Prescriptions", JOptionPane.OK_CANCEL_OPTION);
			}
		};
		viewPrescriptions.addActionListener(prescriptionsListener);
		viewRecords.addActionListener(recordsListener);
		JPanel pane;
		frame.add(pane = new JPanel());
		pane.add(viewPrescriptions);
		pane.add(viewRecords);
	}

	public SplashPatient() {
		initialize();
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

	@SuppressWarnings("serial")
	private class RecordsPanel extends JPanel {
		private JScrollPane pane;
		private JTable table;
		private final String[] col = { "Doctor", "Treated for", "Date" };

		private RecordsPanel(ArrayList<ArrayList<String>> arrayList) {
			String[][] data = new String[arrayList.size()][arrayList.get(0)
					.size()];
			for (int i = 0; i < arrayList.size(); i++) {
				for (int j = 0; j < arrayList.get(0).size(); j++)
					data[i][j] = (String) arrayList.get(i).get(j);
			}
			table = new JTable(data, col);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

			pane = new JScrollPane(table);

		}
	}

	private class PrescriptionPanel extends JPanel {
		private JScrollPane pane;
		private JTable table;
		private final String[] col = { "Medicine name", "Renewals",
				"Continuous", "Date Prescribed", "Prescriber", "Disease" };

		private PrescriptionPanel(ArrayList<ArrayList<String>> arrayList) {
			String[][] data = new String[arrayList.size()][arrayList.get(0)
					.size()];
			for (int i = 0; i < arrayList.size(); i++) {
				for (int j = 0; j < arrayList.get(0).size(); j++)
					data[i][j] = (String) arrayList.get(i).get(j);
			}
			table = new JTable(data, col);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

			pane = new JScrollPane(table);

		}
	}
}
