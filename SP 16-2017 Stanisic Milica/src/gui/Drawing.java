package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Exception.DonutException;
import Exception.MyException;
import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.PnlDrawing;
import geometry.Point;
import geometry.Rectangle;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
public class Drawing extends JFrame {
	
	
	private int event;
	private Point firstPoint;
	private Point secondPoint;
	private int temp;
	private int id  ;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Drawing frame = new Drawing();
					frame.setSize(800, 600);
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
	public Drawing() {
		setBackground(Color.BLACK);
		setTitle("Stanisic Milica SP 16-2017");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(550, 100, 600, 500);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(Color.YELLOW);
		
		contentPane.add(pnlNorth, BorderLayout.NORTH);
		pnlNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
	     
		PnlDrawing pnldraw = new PnlDrawing();
		 
	      
		
		contentPane.add(pnldraw, BorderLayout.CENTER);
		
		
		
		
		
		//JFrame frame = new JFrame("PnlDrawing");
		//frame.setBounds(600,100,500,500);	
		//frame.getContentPane().add(pnldraw);
		//frame.setVisible(true);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.setBackground(Color.WHITE);
		btnSelect.setForeground(Color.RED);
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (event == 2)
				{
					firstPoint = null;
					secondPoint = null;
				}
				for (int i = 0; i< pnldraw.shapes.size();i++)
				{
					pnldraw.shapes.get(i).setSelected(false);
				}
				
					
					event = 6;
				
			}
		});
		pnlNorth.add(btnSelect);
		
		JButton btnModify = new JButton("Modify");
		btnModify.setForeground(Color.RED);
		btnModify.setBackground(Color.WHITE);
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				id = 1;
				if (event == 2)
				{
					firstPoint = null;
					secondPoint = null;
				}
				try {
				for (int i = 0;i<pnldraw.shapes.size();i++)
				{
					
					
					if (pnldraw.shapes.get(i).isSelected() ==true)
					
					{
						id = 0;
						if (pnldraw.shapes.get(i) instanceof Point)
						{
							
							ModifyPoint mp1 = new ModifyPoint();
							Point p1 = new Point();
							p1 = (Point) pnldraw.shapes.get(i);
							
							mp1.txtX.setText(String.valueOf(p1.getX()));
							mp1.txtY.setText(String.valueOf(p1.getY()));
							mp1.setVisible(true);
							if (mp1.isOk)
							{
								if (Integer.parseInt(mp1.txtX.getText()) < 0)
								{
									throw new MyException();
								}
								if (Integer.parseInt(mp1.txtY.getText()) < 0)
								{
									throw new MyException();
								}
								
								p1.setX(Integer.parseInt(mp1.txtX.getText()));
								p1.setY(Integer.parseInt(mp1.txtY.getText()));
								p1.setPointColor(mp1.pointColor);
								
								p1.setSelected(false);
								
								pnldraw.repaint();
							}
						}
							else if (pnldraw.shapes.get(i) instanceof Line)
							{
								
								ModifyLine ml1 = new ModifyLine();
								Line l1 = new Line();
								l1 = (Line) pnldraw.shapes.get(i);
								
								ml1.txtStartPointX.setText(String.valueOf(l1.getStartPoint().getX()));
								ml1.txtStartPointY.setText(String.valueOf(l1.getStartPoint().getY()));
								ml1.txtEndPointX.setText(String.valueOf(l1.getEndPoint().getX()));
								ml1.txtEndPointY.setText(String.valueOf(l1.getEndPoint().getY()));
								ml1.setVisible(true);
								
								firstPoint = new Point(Integer.parseInt(ml1.txtStartPointX.getText()),
													   Integer.parseInt(ml1.txtStartPointY.getText()));
								secondPoint = new Point(Integer.parseInt(ml1.txtEndPointX.getText()),
														Integer.parseInt(ml1.txtEndPointY.getText()));
								
								if (ml1.isOk)
								{
									if (Integer.parseInt(ml1.txtStartPointX.getText()) < 0 || Integer.parseInt(ml1.txtStartPointY.getText()) < 0 ||
										Integer.parseInt(ml1.txtEndPointX.getText()) < 0 || Integer.parseInt(ml1.txtEndPointY.getText()) < 0)
									{
										throw new MyException();
									}
									
									
									l1.setStartPoint(firstPoint);
									l1.setEndPoint(secondPoint);
									l1.setLineColor(ml1.lineColor);
									pnldraw.repaint();
								}
							}
							else if (pnldraw.shapes.get(i) instanceof Rectangle)
							{
								
								ModifyRectangle mr1 = new ModifyRectangle();
								Rectangle r1 = new Rectangle();
								r1 = (Rectangle) pnldraw.shapes.get(i);
								
								mr1.txtUpperLeftX.setText(String.valueOf(r1.getUpperLeft().getX()));
								mr1.txtUpperLeftY.setText(String.valueOf(r1.getUpperLeft().getY()));
								mr1.txtWidth.setText(String.valueOf(r1.getWidth()));
								mr1.txtHeight.setText(String.valueOf(r1.getHeight()));
								mr1.setVisible(true);
								
								Point upperLeft = new Point(Integer.parseInt(mr1.txtUpperLeftX.getText()),Integer.parseInt(mr1.txtUpperLeftY.getText()));
								
								if (mr1.isOk)
								{
									if ( Integer.parseInt(mr1.txtUpperLeftX.getText())< 0 || Integer.parseInt(mr1.txtUpperLeftY.getText()) < 0 ||
										Integer.parseInt(mr1.txtWidth.getText()) < 0 || Integer.parseInt(mr1.txtHeight.getText()) < 0)
									{
										throw new MyException();
									}
									
									r1.setUpperLeft(upperLeft);
									r1.setWidth(Integer.parseInt(mr1.txtWidth.getText()));
									r1.setHeight(Integer.parseInt(mr1.txtHeight.getText()));
									
									if (mr1.innerColor != null)
									{
										r1.setInnerColor(mr1.innerColor);
									}
									if (mr1.edgeColor != null)
									{
										r1.setEdgeColor(mr1.edgeColor);
									}
									pnldraw.repaint();
								}
							}
							else if (pnldraw.shapes.get(i) instanceof Donut)
							{
								
								ModifyDonut md1 = new ModifyDonut();
								Donut d1 = new Donut();
								d1 = (Donut) pnldraw.shapes.get(i);
								
								md1.txtCenterX.setText(String.valueOf(d1.getCenter().getX()));
								md1.txtCenterY.setText(String.valueOf(d1.getCenter().getY()));
								md1.txtRadius.setText(String.valueOf(d1.getR()));
								md1.txtInnerR.setText(String.valueOf(d1.getInnerR()));
								md1.setVisible(true);
								
								Point centerX = new Point(Integer.parseInt(md1.txtCenterX.getText()),
														  Integer.parseInt(md1.txtCenterY.getText()));
								
								if (md1.isOk)
								{
									if (Integer.parseInt(md1.txtCenterX.getText()) < 0 || Integer.parseInt(md1.txtCenterY.getText()) < 0)
									{
										throw new MyException();
									}
									if (Integer.parseInt(md1.txtRadius.getText()) < Integer.parseInt(md1.txtInnerR.getText()))
									{
										throw new DonutException();
									}
									d1.setCenter(centerX);	
									try {
									d1.setR(Integer.parseInt(md1.txtRadius.getText()));
									}
									catch (Exception e) {
										
										throw new MyException();
									}
									d1.setInnerR(Integer.parseInt(md1.txtInnerR.getText()));
									if (md1.innerColor != null)
									{
										d1.setInnerColor(md1.innerColor);
									}
									if (md1.edgeColor != null)
									{
										d1.setEdgeColor(md1.edgeColor);
									}
									
									pnldraw.repaint();
								}
							}
							
							else if (pnldraw.shapes.get(i) instanceof Circle)
							{
								
								ModifyCircle mc1 = new ModifyCircle();
								Circle c1 = new Circle();
								c1 = (Circle) pnldraw.shapes.get(i);
								
								mc1.txtCenterX.setText(String.valueOf(c1.getCenter().getX()));
								mc1.txtCenterY.setText(String.valueOf(c1.getCenter().getY()));
								mc1.txtRadius.setText(String.valueOf(c1.getR()));
								mc1.setVisible(true);
								
								Point centerX = new Point(Integer.parseInt(mc1.txtCenterX.getText()),
														  Integer.parseInt(mc1.txtCenterY.getText()));
								
								if (mc1.isOk)
								{
									if (Integer.parseInt(mc1.txtCenterX.getText()) < 0 || Integer.parseInt(mc1.txtCenterY.getText()) < 0)
									{
										throw new MyException();
									}
									
									c1.setCenter(centerX);
									try {
									c1.setR(Integer.parseInt(mc1.txtRadius.getText()));
									}
									catch(Exception e ) {
										throw new MyException();
									}
									if (mc1.innerColor != null)
									{
										c1.setInnerColor(mc1.innerColor);
									}
									if (mc1.edgeColor != null)
									{
										c1.setEdgeColor(mc1.edgeColor);
									}
									
									pnldraw.repaint();
								}
							}
						
				}
					
					
				}	
				if (id == 1)
				{
					throw new Exception();
				}
				}
				catch (MyException exc)
				{
					JOptionPane.showMessageDialog(null,"Shape parametars need be positive numbers");
				}
				catch(DonutException exc)
				{
					JOptionPane.showMessageDialog(null, "Radis must be larger positive number than inner radius");
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null,"You need to select an object");
					
				}
			}
			
			
				
		});
		pnlNorth.add(btnModify);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBackground(Color.WHITE);
		btnRemove.setForeground(Color.RED);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				id =1;
				if (event == 2)
				{
					firstPoint = null;
					secondPoint = null;
				}
				try {
				Remove rmv = new Remove();
				rmv.setVisible(true);
					if (rmv.isOk)
					{
					for (int i = 0;i < pnldraw.shapes.size();i++)
					{
						
							if (pnldraw.shapes.get(i).isSelected())
							{
								id = 0;
							pnldraw.shapes.remove(i);
							pnldraw.repaint();
							}
												
					}
					}
					if (id == 1 && rmv.isOk == true)
					{
						throw new Exception();
					}
				}catch (Exception e)
				{
					JOptionPane.showMessageDialog(null,"You need to select an object");
				}
			}
		});
		pnlNorth.add(btnRemove);
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.setBackground(Color.BLUE);
		pnlSouth.setForeground(Color.BLACK);
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		GridBagLayout gbl_pnlSouth = new GridBagLayout();
		gbl_pnlSouth.columnWidths = new int[]{0, 0, 8, 0, 97, 21, 100, 0, 0};
		gbl_pnlSouth.rowHeights = new int[]{0, 0};
		gbl_pnlSouth.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlSouth.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlSouth.setLayout(gbl_pnlSouth);
		
		JButton btnPoint = new JButton("Add point");
		btnPoint.setForeground(Color.MAGENTA);
		btnPoint.setBackground(Color.WHITE);
		btnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					if (event == 2)
					{
						firstPoint = null;
						secondPoint = null;
					}
			
					event=1;
				
			}
		});
		GridBagConstraints gbc_btnPoint = new GridBagConstraints();
		gbc_btnPoint.insets = new Insets(0, 0, 0, 5);
		gbc_btnPoint.gridx = 1;
		gbc_btnPoint.gridy = 0;
		pnlSouth.add(btnPoint, gbc_btnPoint);
		
		JButton btnNewLine = new JButton("Add line");
		btnNewLine.setForeground(Color.MAGENTA);
		btnNewLine.setBackground(Color.WHITE);
		btnNewLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				event = 2;
				
			}
		});
		GridBagConstraints gbc_btnNewLine = new GridBagConstraints();
		gbc_btnNewLine.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewLine.gridx = 2;
		gbc_btnNewLine.gridy = 0;
		pnlSouth.add(btnNewLine, gbc_btnNewLine);
		
		JButton btnNewRectangle = new JButton("Add rectangle");
		btnNewRectangle.setBackground(Color.WHITE);
		btnNewRectangle.setForeground(Color.MAGENTA);
		btnNewRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (event == 2)
				{
					firstPoint = null;
					secondPoint = null;
				}
					
					event = 3;
				
			}
		});
		GridBagConstraints gbc_btnNewRectangle = new GridBagConstraints();
		gbc_btnNewRectangle.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewRectangle.gridx = 3;
		gbc_btnNewRectangle.gridy = 0;
		pnlSouth.add(btnNewRectangle, gbc_btnNewRectangle);
		
		JButton btnNewCircle_1 = new JButton("Add circle");
		btnNewCircle_1.setForeground(Color.MAGENTA);
		btnNewCircle_1.setBackground(Color.WHITE);
		btnNewCircle_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (event == 2)
				{
					firstPoint = null;
					secondPoint = null;
				}
				
					event = 4;
				
			}
		});
		GridBagConstraints gbc_btnNewCircle_1 = new GridBagConstraints();
		gbc_btnNewCircle_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewCircle_1.gridx = 4;
		gbc_btnNewCircle_1.gridy = 0;
		pnlSouth.add(btnNewCircle_1, gbc_btnNewCircle_1);
		
		JButton txtNewDonut = new JButton("Add donut");
		txtNewDonut.setBackground(Color.WHITE);
		txtNewDonut.setForeground(Color.MAGENTA);
		txtNewDonut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (event == 2)
				{
					firstPoint = null;
					secondPoint = null;
				}
					event = 5;
				
			}
		});
		GridBagConstraints gbc_txtNewDonut = new GridBagConstraints();
		gbc_txtNewDonut.insets = new Insets(0, 0, 0, 5);
		gbc_txtNewDonut.gridx = 5;
		gbc_txtNewDonut.gridy = 0;
		pnlSouth.add(txtNewDonut, gbc_txtNewDonut);
		
		
		
		
		
		

		
		
		
		GridBagConstraints gbc_pnlPaint = new GridBagConstraints();
		gbc_pnlPaint.insets = new Insets(0, 0, 5, 0);
		gbc_pnlPaint.fill = GridBagConstraints.BOTH;
		gbc_pnlPaint.gridx = 6;
		gbc_pnlPaint.gridy = 2;
		
		
		
		pnldraw.addMouseListener(new MouseAdapter() {
           
			@Override 
			public void mousePressed(MouseEvent e) {
				//Add new point
				if (event == 1) {
					pnldraw.shapes.add(new Point(e.getX(),e.getY()));
					pnldraw.repaint();
					
				}
				//Add new line
				else if (event == 2)
				{
					if (firstPoint == null)
					{
						firstPoint = new Point(e.getX(),e.getY());
						
					}
					else if(secondPoint == null)
					{
						secondPoint = new Point(e.getX(),e.getY());
						
					}
					if (firstPoint != null && secondPoint != null) 
					{
						Line l1 = new Line(firstPoint,secondPoint);
						pnldraw.shapes.add(l1);
						pnldraw.repaint();						
						firstPoint = null;
						secondPoint = null;
					}
				}
				//Add new rectangle
				else if (event == 3) 
				{
					try
					{
					DrawRectangle drawRect = new DrawRectangle();
					drawRect.setVisible(true);
					Point upperLeft = new Point(e.getX(),e.getY());
						if(drawRect.isOk)
						{
							pnldraw.shapes.add(new Rectangle(upperLeft,Integer.parseInt(drawRect.txtWidth.getText()),Integer.parseInt(drawRect.txtHeight.getText())));
							pnldraw.repaint();
							
						}
					}catch (Exception exc)
					{
						JOptionPane.showMessageDialog(null, "Rectengle parametars are not in correct format. They need be positive numbers :)");
					}
					
				}
				//Add circle
				else if (event == 4)
				{
					try {
					DrawCircle drawCircle = new DrawCircle();
					drawCircle.setVisible(true);
					Point center = new Point(e.getX(),e.getY());
						if (drawCircle.isOk)
						{
							if (Integer.parseInt(drawCircle.txtRadius.getText()) < 0)
							{
								throw new Exception();
							}
							pnldraw.shapes.add(new Circle(center,Integer.parseInt(drawCircle.txtRadius.getText())));
							pnldraw.repaint();
							
						}
					}catch (Exception exc)
					{
						JOptionPane.showMessageDialog(null, "Circle parametars are not in correct format. They need be positive numbers :)");
					}
					
				}
				else if (event == 5)
				{
					try {
					DrawDonut drawDonut = new DrawDonut();
					drawDonut.setVisible(true);
					Point center = new Point(e.getX(),e.getY());
						if (drawDonut.isOk)
						{
							if (Integer.parseInt(drawDonut.txtRadius.getText()) < Integer.parseInt(drawDonut.txtInnerR.getText()))
							{
								throw new DonutException();
							}
							pnldraw.shapes.add(new Donut(center,Integer.parseInt(drawDonut.txtRadius.getText())
											   ,Integer.parseInt(drawDonut.txtInnerR.getText())));
							pnldraw.repaint();
							
						}
					}catch(DonutException exc)
					{
						JOptionPane.showMessageDialog(null, "Radis must be larger positive number than inner radius");
					}
					catch (Exception exc)
					{
						JOptionPane.showMessageDialog(null, "Circle parametars are not in correct format. They need be positive numbers :)");
					}
					
				}
				else if (event == 6)
				{
					
					
					for (int i = 0; i< pnldraw.shapes.size();i++)
					{
						if (pnldraw.shapes.get(i).contains(e.getX(),e.getY())) 
						{
							temp=i;
						}
					}
					pnldraw.shapes.get(temp).setSelected(true);
					pnldraw.repaint();
					event = 0;
					
				}
				
				
			}
		});
		
		
		
		
		
	}
}
