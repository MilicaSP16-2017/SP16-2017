package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;

public class ModifyLine extends JDialog {

	private final JPanel contentPanel = new JPanel();
	protected JTextField txtStartPointX;
	protected JTextField txtEndPointX;
	protected boolean isOk;
	protected JTextField txtStartPointY;
	protected JTextField txtEndPointY;
	protected Color lineColor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModifyLine dialog = new ModifyLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModifyLine() {
		setModal(true);
		setTitle("Modify Line");
		setBounds(100, 100, 450, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.ORANGE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblStartPointX = new JLabel("start point- x ");
			lblStartPointX.setForeground(Color.MAGENTA);
			GridBagConstraints gbc_lblStartPointX = new GridBagConstraints();
			gbc_lblStartPointX.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartPointX.gridx = 1;
			gbc_lblStartPointX.gridy = 0;
			contentPanel.add(lblStartPointX, gbc_lblStartPointX);
		}
		{
			txtStartPointX = new JTextField();
			txtStartPointX.setForeground(Color.MAGENTA);
			GridBagConstraints gbc_txtStartPointX = new GridBagConstraints();
			gbc_txtStartPointX.insets = new Insets(0, 0, 5, 0);
			gbc_txtStartPointX.gridwidth = 4;
			gbc_txtStartPointX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtStartPointX.gridx = 3;
			gbc_txtStartPointX.gridy = 0;
			contentPanel.add(txtStartPointX, gbc_txtStartPointX);
			txtStartPointX.setColumns(10);
		}
		{
			JLabel lblStartPointY = new JLabel("start point - y");
			lblStartPointY.setForeground(Color.MAGENTA);
			GridBagConstraints gbc_lblStartPointY = new GridBagConstraints();
			gbc_lblStartPointY.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartPointY.gridx = 1;
			gbc_lblStartPointY.gridy = 1;
			contentPanel.add(lblStartPointY, gbc_lblStartPointY);
		}
		{
			txtStartPointY = new JTextField();
			txtStartPointY.setForeground(Color.MAGENTA);
			GridBagConstraints gbc_txtStartPointY = new GridBagConstraints();
			gbc_txtStartPointY.gridwidth = 4;
			gbc_txtStartPointY.insets = new Insets(0, 0, 5, 0);
			gbc_txtStartPointY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtStartPointY.gridx = 3;
			gbc_txtStartPointY.gridy = 1;
			contentPanel.add(txtStartPointY, gbc_txtStartPointY);
			txtStartPointY.setColumns(10);
		}
		{
			JLabel lblEndPointX = new JLabel("end point - x");
			lblEndPointX.setForeground(Color.MAGENTA);
			GridBagConstraints gbc_lblEndPointX = new GridBagConstraints();
			gbc_lblEndPointX.insets = new Insets(0, 0, 5, 5);
			gbc_lblEndPointX.gridx = 1;
			gbc_lblEndPointX.gridy = 2;
			contentPanel.add(lblEndPointX, gbc_lblEndPointX);
		}
		{
			txtEndPointX = new JTextField();
			txtEndPointX.setForeground(Color.MAGENTA);
			GridBagConstraints gbc_txtEndPointX = new GridBagConstraints();
			gbc_txtEndPointX.insets = new Insets(0, 0, 5, 0);
			gbc_txtEndPointX.gridwidth = 4;
			gbc_txtEndPointX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtEndPointX.gridx = 3;
			gbc_txtEndPointX.gridy = 2;
			contentPanel.add(txtEndPointX, gbc_txtEndPointX);
			txtEndPointX.setColumns(10);
		}
		{
			JLabel lblEndPointY = new JLabel("end point - y");
			lblEndPointY.setForeground(Color.MAGENTA);
			GridBagConstraints gbc_lblEndPointY = new GridBagConstraints();
			gbc_lblEndPointY.insets = new Insets(0, 0, 5, 5);
			gbc_lblEndPointY.gridx = 1;
			gbc_lblEndPointY.gridy = 3;
			contentPanel.add(lblEndPointY, gbc_lblEndPointY);
		}
		{
			txtEndPointY = new JTextField();
			txtEndPointY.setForeground(Color.MAGENTA);
			GridBagConstraints gbc_txtEndPointY = new GridBagConstraints();
			gbc_txtEndPointY.gridwidth = 4;
			gbc_txtEndPointY.insets = new Insets(0, 0, 5, 0);
			gbc_txtEndPointY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtEndPointY.gridx = 3;
			gbc_txtEndPointY.gridy = 3;
			contentPanel.add(txtEndPointY, gbc_txtEndPointY);
			txtEndPointY.setColumns(10);
		}
		{
			JButton btnLineColor = new JButton("Change line color");
			btnLineColor.setForeground(Color.MAGENTA);
			btnLineColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JColorChooser jcc = new JColorChooser();
					lineColor = jcc.showDialog(null, "Chose line color", Color.WHITE);
				}
			});
			GridBagConstraints gbc_btnLineColor = new GridBagConstraints();
			gbc_btnLineColor.insets = new Insets(0, 0, 5, 5);
			gbc_btnLineColor.gridx = 2;
			gbc_btnLineColor.gridy = 4;
			contentPanel.add(btnLineColor, gbc_btnLineColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.ORANGE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setForeground(Color.MAGENTA);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						isOk = true;
						setVisible(false);
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setForeground(Color.MAGENTA);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
