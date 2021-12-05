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
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModifyRectangle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	protected JTextField txtUpperLeftX;
	protected JTextField txtUpperLeftY;
	protected JTextField txtWidth;
	protected JTextField txtHeight;
	protected boolean isOk;
	protected Color edgeColor;
	protected Color innerColor;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModifyRectangle dialog = new ModifyRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModifyRectangle() {
		setModal(true);
		setTitle("Modify rectangle");
		setBounds(100, 100, 450, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.ORANGE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblUpperLeftX = new JLabel("upper left - X");
			lblUpperLeftX.setForeground(Color.MAGENTA);
			GridBagConstraints gbc_lblUpperLeftX = new GridBagConstraints();
			gbc_lblUpperLeftX.insets = new Insets(0, 0, 5, 5);
			gbc_lblUpperLeftX.gridx = 1;
			gbc_lblUpperLeftX.gridy = 0;
			contentPanel.add(lblUpperLeftX, gbc_lblUpperLeftX);
		}
		{
			txtUpperLeftX = new JTextField();
			txtUpperLeftX.setForeground(Color.MAGENTA);
			GridBagConstraints gbc_txtUpperLeftX = new GridBagConstraints();
			gbc_txtUpperLeftX.insets = new Insets(0, 0, 5, 0);
			gbc_txtUpperLeftX.gridwidth = 4;
			gbc_txtUpperLeftX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtUpperLeftX.gridx = 3;
			gbc_txtUpperLeftX.gridy = 0;
			contentPanel.add(txtUpperLeftX, gbc_txtUpperLeftX);
			txtUpperLeftX.setColumns(10);
		}
		{
			JLabel lblUpperLeftY = new JLabel("upper left - Y");
			lblUpperLeftY.setForeground(Color.MAGENTA);
			GridBagConstraints gbc_lblUpperLeftY = new GridBagConstraints();
			gbc_lblUpperLeftY.insets = new Insets(0, 0, 5, 5);
			gbc_lblUpperLeftY.gridx = 1;
			gbc_lblUpperLeftY.gridy = 1;
			contentPanel.add(lblUpperLeftY, gbc_lblUpperLeftY);
		}
		{
			txtUpperLeftY = new JTextField();
			txtUpperLeftY.setForeground(Color.MAGENTA);
			GridBagConstraints gbc_txtUpperLeftY = new GridBagConstraints();
			gbc_txtUpperLeftY.insets = new Insets(0, 0, 5, 0);
			gbc_txtUpperLeftY.gridwidth = 4;
			gbc_txtUpperLeftY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtUpperLeftY.gridx = 3;
			gbc_txtUpperLeftY.gridy = 1;
			contentPanel.add(txtUpperLeftY, gbc_txtUpperLeftY);
			txtUpperLeftY.setColumns(10);
		}
		{
			JLabel lblWidth = new JLabel("width");
			lblWidth.setForeground(Color.MAGENTA);
			GridBagConstraints gbc_lblWidth = new GridBagConstraints();
			gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
			gbc_lblWidth.gridx = 1;
			gbc_lblWidth.gridy = 2;
			contentPanel.add(lblWidth, gbc_lblWidth);
		}
		{
			txtWidth = new JTextField();
			txtWidth.setForeground(Color.MAGENTA);
			GridBagConstraints gbc_txtWidth = new GridBagConstraints();
			gbc_txtWidth.gridwidth = 4;
			gbc_txtWidth.insets = new Insets(0, 0, 5, 0);
			gbc_txtWidth.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtWidth.gridx = 3;
			gbc_txtWidth.gridy = 2;
			contentPanel.add(txtWidth, gbc_txtWidth);
			txtWidth.setColumns(10);
		}
		{
			JLabel lblHeight = new JLabel("Height");
			lblHeight.setForeground(Color.MAGENTA);
			GridBagConstraints gbc_lblHeight = new GridBagConstraints();
			gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
			gbc_lblHeight.gridx = 1;
			gbc_lblHeight.gridy = 3;
			contentPanel.add(lblHeight, gbc_lblHeight);
		}
		{
			txtHeight = new JTextField();
			txtHeight.setForeground(Color.MAGENTA);
			GridBagConstraints gbc_txtHeight = new GridBagConstraints();
			gbc_txtHeight.insets = new Insets(0, 0, 5, 0);
			gbc_txtHeight.gridwidth = 4;
			gbc_txtHeight.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtHeight.gridx = 3;
			gbc_txtHeight.gridy = 3;
			contentPanel.add(txtHeight, gbc_txtHeight);
			txtHeight.setColumns(10);
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
			gbc_btnEdgeColor.anchor = GridBagConstraints.NORTH;
			gbc_btnEdgeColor.insets = new Insets(0, 0, 5, 5);
			gbc_btnEdgeColor.gridx = 2;
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
			gbc_btnInsideOfRectangle.gridx = 2;
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
