package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModifyDonut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	protected JTextField txtCenterX;
	protected JTextField txtCenterY;
	protected JTextField txtRadius;
	protected JTextField txtInnerR;
	protected boolean isOk;
	protected Color edgeColor;
	protected Color innerColor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModifyDonut dialog = new ModifyDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModifyDonut() {
		setModal(true);
		setTitle("Modify donut");
		setBounds(100, 100, 450, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.ORANGE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCenterX = new JLabel("center - x");
			lblCenterX.setForeground(Color.MAGENTA);
			GridBagConstraints gbc_lblCenterX = new GridBagConstraints();
			gbc_lblCenterX.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenterX.gridx = 1;
			gbc_lblCenterX.gridy = 0;
			contentPanel.add(lblCenterX, gbc_lblCenterX);
		}
		{
			txtCenterX = new JTextField();
			txtCenterX.setForeground(Color.MAGENTA);
			txtCenterX.setColumns(10);
			GridBagConstraints gbc_txtCenterX = new GridBagConstraints();
			gbc_txtCenterX.gridwidth = 4;
			gbc_txtCenterX.insets = new Insets(0, 0, 5, 0);
			gbc_txtCenterX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtCenterX.gridx = 4;
			gbc_txtCenterX.gridy = 0;
			contentPanel.add(txtCenterX, gbc_txtCenterX);
		}
		{
			JLabel lblCenterY = new JLabel("center - y");
			lblCenterY.setForeground(Color.MAGENTA);
			GridBagConstraints gbc_lblCenterY = new GridBagConstraints();
			gbc_lblCenterY.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenterY.gridx = 1;
			gbc_lblCenterY.gridy = 1;
			contentPanel.add(lblCenterY, gbc_lblCenterY);
		}
		{
			txtCenterY = new JTextField();
			txtCenterY.setForeground(Color.MAGENTA);
			txtCenterY.setColumns(10);
			GridBagConstraints gbc_txtCenterY = new GridBagConstraints();
			gbc_txtCenterY.gridwidth = 4;
			gbc_txtCenterY.insets = new Insets(0, 0, 5, 0);
			gbc_txtCenterY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtCenterY.gridx = 4;
			gbc_txtCenterY.gridy = 1;
			contentPanel.add(txtCenterY, gbc_txtCenterY);
		}
		{
			JLabel lblRadius = new JLabel("radius");
			lblRadius.setForeground(Color.MAGENTA);
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblRadius.gridx = 1;
			gbc_lblRadius.gridy = 2;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			txtRadius = new JTextField();
			txtRadius.setForeground(Color.MAGENTA);
			txtRadius.setColumns(10);
			GridBagConstraints gbc_txtRadius = new GridBagConstraints();
			gbc_txtRadius.insets = new Insets(0, 0, 5, 0);
			gbc_txtRadius.gridwidth = 4;
			gbc_txtRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtRadius.gridx = 4;
			gbc_txtRadius.gridy = 2;
			contentPanel.add(txtRadius, gbc_txtRadius);
		}
		{
			JLabel lblInnerR = new JLabel("inner radius");
			lblInnerR.setForeground(Color.MAGENTA);
			GridBagConstraints gbc_lblInnerR = new GridBagConstraints();
			gbc_lblInnerR.insets = new Insets(0, 0, 5, 5);
			gbc_lblInnerR.gridx = 1;
			gbc_lblInnerR.gridy = 3;
			contentPanel.add(lblInnerR, gbc_lblInnerR);
		}
		{
			txtInnerR = new JTextField();
			txtInnerR.setForeground(Color.MAGENTA);
			txtInnerR.setText("");
			GridBagConstraints gbc_txtInnerR = new GridBagConstraints();
			gbc_txtInnerR.insets = new Insets(0, 0, 5, 0);
			gbc_txtInnerR.gridwidth = 4;
			gbc_txtInnerR.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtInnerR.gridx = 4;
			gbc_txtInnerR.gridy = 3;
			contentPanel.add(txtInnerR, gbc_txtInnerR);
			txtInnerR.setColumns(10);
		}
		{
			JButton btnEdgeColor = new JButton("Change edgde color");
			btnEdgeColor.setForeground(Color.MAGENTA);
			btnEdgeColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JColorChooser jcc = new JColorChooser();
					edgeColor = jcc.showDialog(null, "Chose edge color", Color.BLACK);
				}
			});
			GridBagConstraints gbc_btnEdgeColor = new GridBagConstraints();
			gbc_btnEdgeColor.insets = new Insets(0, 0, 5, 5);
			gbc_btnEdgeColor.gridx = 3;
			gbc_btnEdgeColor.gridy = 4;
			contentPanel.add(btnEdgeColor, gbc_btnEdgeColor);
		}
		{
			JButton btnInsideOfRectangle = new JButton("Change inside color");
			btnInsideOfRectangle.setForeground(Color.MAGENTA);
			btnInsideOfRectangle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JColorChooser jcc = new JColorChooser();
					innerColor = jcc.showDialog(null, "Chose inner color", Color.WHITE);
				}
			});
			GridBagConstraints gbc_btnInsideOfRectangle = new GridBagConstraints();
			gbc_btnInsideOfRectangle.insets = new Insets(0, 0, 0, 5);
			gbc_btnInsideOfRectangle.gridx = 3;
			gbc_btnInsideOfRectangle.gridy = 5;
			contentPanel.add(btnInsideOfRectangle, gbc_btnInsideOfRectangle);
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
