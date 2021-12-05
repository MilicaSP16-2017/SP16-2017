package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Rectangle;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import Exception.MyException;
import net.miginfocom.swing.MigLayout;

public class Stack extends JFrame {
	private DefaultListModel<Rectangle> dlm = new DefaultListModel<Rectangle>();
	JList lstRectangle;
	private int split;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stack frame = new Stack();
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
	public Stack() {
		setTitle("Milica Stanisic SP 16-2017");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel pnlWest = new JPanel();
		pnlWest.setBackground(Color.MAGENTA);
		getContentPane().add(pnlWest, BorderLayout.WEST);
		GridBagLayout gbl_pnlWest = new GridBagLayout();
		gbl_pnlWest.columnWidths = new int[]{95, 0};
		gbl_pnlWest.rowHeights = new int[]{25, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlWest.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlWest.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlWest.setLayout(gbl_pnlWest);
		
		JScrollPane scrlPaneRectangle = new JScrollPane();
		getContentPane().add(scrlPaneRectangle, BorderLayout.CENTER);
		
		lstRectangle = new JList();
		lstRectangle.setForeground(Color.BLACK);
		scrlPaneRectangle.setViewportView(lstRectangle);
		lstRectangle.setModel(dlm);
		
		
		JButton btnAddRectangle = new JButton("Add rectangle");
		btnAddRectangle.setBackground(Color.WHITE);
		btnAddRectangle.setForeground(Color.GREEN);
		btnAddRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			RectangleParams rectangleParams = new RectangleParams();
				
				rectangleParams.setVisible(true);
				if (rectangleParams.isOk) {
					try {
						if (Integer.parseInt(rectangleParams.txtUpperLeftX.getText()) < 0 || Integer.parseInt(rectangleParams.txtUpperLeftY.getText()) < 0 ||
							Integer.parseInt(rectangleParams.txtWidth.getText()) < 0 || Integer.parseInt(rectangleParams.txtHeight.getText()) < 0)
						{
							throw new MyException(); 
						}
						
						
					Point upperLeft = new Point(Integer.parseInt(rectangleParams.txtUpperLeftX.getText()),
												Integer.parseInt(rectangleParams.txtUpperLeftY.getText()));
					
					dlm.add(0,new Rectangle(upperLeft,Integer.parseInt(rectangleParams.txtWidth.getText()),
											Integer.parseInt(rectangleParams.txtHeight.getText())));
					}
					catch(MyException e) {
						JOptionPane.showMessageDialog(null, "You have entered negative number. Rectengle parametars need be positive numbers");
					}
					catch(Exception e) {
						JOptionPane.showMessageDialog(null, "Rectengle parametars are not in correct format. They need be positive numbers");
					}
				}
			}
		});
		GridBagConstraints gbc_btnAddRectangle = new GridBagConstraints();
		gbc_btnAddRectangle.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAddRectangle.insets = new Insets(0, 0, 10, 0);
		gbc_btnAddRectangle.anchor = GridBagConstraints.NORTH;
		gbc_btnAddRectangle.gridx = 0;
		gbc_btnAddRectangle.gridy = 1;
		pnlWest.add(btnAddRectangle, gbc_btnAddRectangle);
		
		JButton btnRemoveRectangle = new JButton("Remove rectangle");
		btnRemoveRectangle.setBackground(Color.WHITE);
		btnRemoveRectangle.setForeground(Color.GREEN);
		btnRemoveRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					RectangleParams rectangleParams = new RectangleParams();
					
					Rectangle selectedRectangle = dlm.getElementAt(lstRectangle.getSelectedIndex());
					rectangleParams.txtUpperLeftX.setText(String.valueOf(selectedRectangle.getUpperLeft().getX()));
					rectangleParams.txtUpperLeftY.setText(String.valueOf(selectedRectangle.getUpperLeft().getY()));
					rectangleParams.txtWidth.setText(String.valueOf(selectedRectangle.getWidth()));
					rectangleParams.txtHeight.setText(String.valueOf(selectedRectangle.getHeight()));
					rectangleParams.txtUpperLeftX.setEditable(false);
					rectangleParams.txtUpperLeftY.setEditable(false);
					rectangleParams.txtHeight.setEditable(false);
					rectangleParams.txtWidth.setEditable(false);
					rectangleParams.setVisible(true);
					
					
					if (rectangleParams.isOk) {
						dlm.removeElementAt(lstRectangle.getSelectedIndex());		
						
					}			
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Rectangle must be selected!");
				}
			}
		});
		GridBagConstraints gbc_btnRemoveRectangle = new GridBagConstraints();
		gbc_btnRemoveRectangle.gridx = 0;
		gbc_btnRemoveRectangle.gridy = 7;
		pnlWest.add(btnRemoveRectangle, gbc_btnRemoveRectangle);
		
	}

}
