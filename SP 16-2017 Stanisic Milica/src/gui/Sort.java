package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Exception.MyException;
import geometry.Point;
import geometry.Rectangle;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sort extends JFrame {
	private DefaultListModel<Rectangle> dlm = new DefaultListModel<Rectangle>();
	JList lstRectangle;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sort frame = new Sort();
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
	public Sort() {
		setTitle("Milica Stanisic SP 16-2017");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlEast = new JPanel();
		pnlEast.setBackground(Color.CYAN);
		contentPane.add(pnlEast, BorderLayout.EAST);
		GridBagLayout gbl_pnlEast = new GridBagLayout();
		gbl_pnlEast.columnWidths = new int[]{95, 0};
		gbl_pnlEast.rowHeights = new int[]{25, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlEast.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlEast.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlEast.setLayout(gbl_pnlEast);
		JScrollPane scrlPaneRectangle = new JScrollPane();
		contentPane.add(scrlPaneRectangle, BorderLayout.CENTER);
		
		lstRectangle = new JList();
		lstRectangle.setForeground(Color.DARK_GRAY);
		scrlPaneRectangle.setViewportView(lstRectangle);
		lstRectangle.setModel(dlm);
		
		JButton btnAddRectangle = new JButton("Add rectangle");
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
		btnAddRectangle.setForeground(Color.ORANGE);
		btnAddRectangle.setBackground(Color.BLUE);
		GridBagConstraints gbc_btnAddRectangle = new GridBagConstraints();
		gbc_btnAddRectangle.insets = new Insets(0, 0, 10, 0);
		gbc_btnAddRectangle.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAddRectangle.gridx = 0;
		gbc_btnAddRectangle.gridy = 1;
		pnlEast.add(btnAddRectangle, gbc_btnAddRectangle);
		
		JButton btnSort = new JButton("Sort");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				if (dlm.getSize() < 2)
				{
					throw new Exception();
				}
				Rectangle temp;
				int n = dlm.getSize();
					for (int i=0; i<n-1; i++)
						for (int j = i+1; j<n; j++)
						{
							if (dlm.getElementAt(j).area()<dlm.getElementAt(i).area())
							{
								temp = dlm.getElementAt(j);
								dlm.setElementAt(dlm.getElementAt(i), j);
								dlm.setElementAt(temp, i);
								
							}
						}
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null,"You can sort only if you enter minimum two rectangles!");
				}
			}
		});
		btnSort.setForeground(Color.ORANGE);
		btnSort.setBackground(Color.BLUE);
		
		GridBagConstraints gbc_btnSort = new GridBagConstraints();
		gbc_btnSort.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSort.gridx = 0;
		gbc_btnSort.gridy = 7;
		pnlEast.add(btnSort, gbc_btnSort);
		
	}

}
