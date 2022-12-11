package myapp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import mylib.*;
//여기는 응용
class PainterKFrame extends KFrame{
	private Point sp, ep;
	private String FigureType = null;
	private ArrayList<Figure> FigureList = new ArrayList<>();
	private Figure f;
	private String color = "Black";
	public PainterKFrame() {
		kmb = new KMenuBar();
		ktb = new KToolBar();
		KButton kb1 = new KButton("Rect");
		KButton kb2 = new KButton("Oval");
		KButton kb3 = new KButton("Line");
		KButton kb4 = new KButton("Group");
		KCheckBox kb5 = new KCheckBox("Fill");
		KButton kb6 = new KButton("Copy");
		KCheckBox kb7 = new KCheckBox("Remove");
		KButton kb8 = new KButton("Clear");
		KMenu km1 = new KMenu("File");
		KMenu km2 = new KMenu("Color");
		KMenuItem kmi1 = new KMenuItem("Save");
		KMenuItem kmi2 = new KMenuItem("Load");
		KMenuItem kmi3 = new KMenuItem("Red");
		KMenuItem kmi4 = new KMenuItem("Green");
		KMenuItem kmi5 = new KMenuItem("Blue");
		KMenuItem kmi6 = new KMenuItem("Black");
		setKMenuBar(kmb);
		add(ktb);
		ktb.add(kb1);
		ktb.add(kb2);
		ktb.add(kb3);
		ktb.add(kb4);
		ktb.add(kb5);
		ktb.add(kb6);
		ktb.add(kb7);
		ktb.add(kb8);
		kmb.add(km1);
		kmb.add(km2);
		km1.add(kmi1);
		km1.add(kmi2);
		km2.add(kmi3);
		km2.add(kmi4);
		km2.add(kmi5);
		km2.add(kmi6);
		kmb.addKActionListener(new MyBtnListener());
		ktb.addKActionListener(kmb.getKActonListener());
	}
	class MyBtnListener implements KActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == "Save") {
				System.out.print("filename : ");
				Scanner sc = new Scanner(System.in);
				String fileName = sc.next();
				if(fileName.equals("N")) {
					System.out.println("Cancled");
				} else {
					try {
						ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream("C:\\Users\\USER\\Desktop\\pic\\" + fileName + ".txt"));
						oss.writeObject(FigureList);
						oss.close();
						System.out.println("Saved!");
						FigureList.clear();
					} catch (IOException e1) {
						System.out.println("Save Failed");
					}
				}
			} else if(e.getSource() == "Load") {
				System.out.print("filename : ");
				Scanner sc = new Scanner(System.in);
				String fileName = sc.next();
				if(fileName.equals("N")) {
					System.out.println("Cancled");
				} else {
					try {
						ObjectInputStream is = new ObjectInputStream(new FileInputStream("C:\\Users\\USER\\Desktop\\pic\\" + fileName + ".txt"));
						FigureList = (ArrayList<Figure>) is.readObject();
						System.out.println("Loaded!");
					} catch (Exception e1) {
						System.out.println("Load Failed");
					}
				}
			} else if(e.getSource() == "Black") {
				color = "Black";
				Figure.color_in = Color.black;
			} else if(e.getSource() == "Red") {
				color = "Red";
				Figure.color_in = Color.red;
			} else if(e.getSource() == "Green") {
				color = "Green";
				Figure.color_in = Color.green;
			} else if(e.getSource() == "Blue") {
				color = "Blue";
				Figure.color_in = Color.blue;
			} else if(e.getSource() == "Rect") {
				FigureType = "Rect";
			} else if(e.getSource() == "Oval") {
				FigureType = "Oval";
			} else if(e.getSource() == "Line") {
				FigureType = "Line";
			} else if(e.getSource() == "Group") {
				FigureType = "Group";
			} else if(e.getSource().equals("Filltrue")) {
				FigureType = "Fill";
			} else if(e.getSource().equals("Fillfalse")) {
				FigureType = null;
			} else if(e.getSource() == "Clear") {
				FigureList.clear();
				repaint();
			} else if(e.getSource().equals("Removetrue")) {
				FigureType = "Remove";
			} else if(e.getSource().equals("Removefalse")) {
				FigureType = null;
			} else if(e.getSource() == "Copy") {
				FigureType = "Copy";
			}
		}
		
	}
	@Override public void paint(Graphics g) {
		super.paint(g);
		g.drawString("State : " + FigureType, kmb.getX() + kmb.getBarWidth() + 10, 50);
		g.drawString("Color : " + color, kmb.getX() + kmb.getBarWidth() + 10, 65);
		for(Figure fig: FigureList) {
			fig.draw(g);
		}
	}
	@Override public void processMouseEvent(MouseEvent e){
		super.processMouseEvent(e);
		switch(e.getID()) {
		case MouseEvent.MOUSE_CLICKED:
			if(e.getButton() == MouseEvent.BUTTON3) {
				for(Figure fig : FigureList) {
					if (fig.isClicked(e.getX(), e.getY())) {
						FigureType = "Move";
						f = fig;
						System.out.println("Selected Object : " + fig);
						break;
					}
				}
			}
			repaint();
			break;
		case MouseEvent.MOUSE_PRESSED:
			if(FigureType == null) {
				break;
			}
			sp = e.getPoint();
			break;
		case MouseEvent.MOUSE_RELEASED:
			if(FigureType == null) {
				break;
			}
			ep = e.getPoint();
			if(FigureType.equals("Line")) {
				FigureList.add(new Line(sp, ep));
				repaint();
			} else if (FigureType.equals("Move")) {
				f.setLocation(sp.x, sp.y, ep.x, ep.y);
				repaint();
			} else if(FigureType.equals("Remove")) {
				for(Figure fig: FigureList) {
					if(fig.isClicked(ep.x, ep.y)) {
						FigureList.remove(fig);
						break;
					}
				}
				repaint();
			} else if (FigureType.equals("Copy")) {
				for(Figure fig: FigureList) {
					if(fig.isClicked(ep.x, ep.y)) {
						Figure copiedFigure;
						if(fig.getType().equals("Rect")) {
							copiedFigure = new Rect(fig.getX() + 5, fig.getY() + 5, fig.getWidth(), fig.getHeight());
							copiedFigure.color = fig.color;
							if(fig.isFill) {
								copiedFigure.isFill = true;
								copiedFigure.figureColor = fig.figureColor;
							}
							FigureList.add(copiedFigure);
						} else if(fig.getType().equals("Oval")) {
							copiedFigure = new Oval(fig.getX() + 5, fig.getY() + 5, fig.getWidth(), fig.getHeight());
							copiedFigure.color = fig.color;
							if(fig.isFill) {
								copiedFigure.isFill = true;
								copiedFigure.figureColor = fig.figureColor;
							}
							FigureList.add(copiedFigure);
						} else if(fig.getType().equals("Line")) {
							copiedFigure = new Line(fig.getX() + 5, fig.getY() + 5, fig.getX2() + 5, fig.getY2() + 5);
							copiedFigure.color = fig.color;
							FigureList.add(copiedFigure);
						} else if(fig.getType().equals("Group")) {
							ArrayList<Figure> list = new ArrayList<>();
							list = ((Group) fig).listCopy();
							copiedFigure = new Group(fig.getX() + 5, fig.getY() + 5, fig.getX2()+5, fig.getY2()+5);
							((Group) copiedFigure).setList(list);
							FigureList.add(copiedFigure);
						}
						System.out.println("Copied!");
						FigureType = null;
						break;
					}
					repaint();
				}
			} else if(FigureType.equals("Rect")) {
				FigureList.add(new Rect(sp, ep));
				repaint();
			} else if(FigureType.equals("Oval")) {
				FigureList.add(new Oval(sp, ep));
				repaint();
			} else if(FigureType.equals("Fill")) {
				for(Figure fig: FigureList) {
					if(fig.isClicked(e.getX(), e.getY())) {
						fig.fill();
						break;
					}
				}
				repaint();
			} else if(FigureType.equals("Group")) {
				ArrayList remove = new ArrayList();
				int minX, minY, maxX, maxY;
				minX = -1;
				minY = -1;
				maxX = -1;
				maxY = -1;
				for(Figure fig: FigureList) {
					if(fig.contains(sp, ep)) {
						if (fig.getX() < minX || minX == -1) {
							minX = fig.getX();
						}
						if (fig.getY() < minY || minY == -1) {
							minY = fig.getY();
						}
						if (fig.getX2() > maxX || maxX == -1) {
							maxX = fig.getX2();
						}
						if (fig.getY2() > maxY || maxY == -1) {
							maxY = fig.getY2();
						}
					}
				}
				f = new Group(minX, minY, maxX, maxY);
				for (Figure fig: FigureList) {
					if (fig.contains(sp, ep)) {
						remove.add(fig);
						f.add(fig);
					}
				}
				FigureList.add(f);
				for(int i = 0; i < remove.size(); i++) {
                    for(int j1 = 0; j1 < FigureList.size(); j1++) {
                    	if(remove.get(i) == FigureList.get(j1)) {
                    		FigureList.remove(FigureList.get(j1));
                    	}
                    }
				}
				repaint();
			}
			break;
		}
	}
}

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KAdapterFrame frame = new KAdapterFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,600);
		frame.setKFrame(new PainterKFrame());
		frame.setVisible(true);
	}

}

