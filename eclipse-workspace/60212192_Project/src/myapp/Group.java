package myapp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Group extends Figure{
	ArrayList<Figure> group;

	public Group(int x, int y, int x2, int y2) {
		group = new ArrayList<>();
		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
		this.width = x2 - x;
		this.height = y2 - y;
	}
	public Group(Point p1, Point p2) {
		group = new ArrayList<>();
		Point sp = p1, ep = p2;
		if (sp.x > ep.x) {
			int tmp = sp.x;
			sp.x = ep.x;
			ep.x = tmp;
		}
		if (sp.y > ep.y) {
			int tmp = sp.y;
			sp.y = ep.y;
			ep.y = tmp;
		}
		this.x = sp.x;
		this.y = sp.y;
		this.x2 = ep.x;
		this.y2 = ep.y;
		this.width = ep.x - sp.x;
		this.height = ep.y - sp.y;
	}
	public void add(Figure f) {
		group.add(f);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(this.x, this.y, width, height);
		for (Figure figure : group) {
			figure.draw(g);
		}
	}

	@Override
	public boolean isClicked(int x, int y) {
		return this.x <= x && x <= this.x2 && y <= this.y2 && y >= this.y;
	}

	@Override
	public boolean contains(Point p1, Point p2) {
		return this.x >= p1.x && this.x + this.width <= p2.x && this.y >= p1.y && this.y + this.height <= p2.y;
	}

	@Override
	public void setLocation(int x, int y, int x2, int y2) {
		this.x += x2 - x;
		this.y += y2 - y;
		for (int i = 0; i < this.group.size(); i++) {
			this.group.get(i).move(x2 - x, y2 - y);
		}
	}

	@Override
	public void move(int x, int y) {
		this.x += x;
		this.y += y;
		for (int i = 0; i < this.group.size(); i++) {
			this.group.get(i).move(x, y);
		}
	}


	@Override public String getType() {
		return "Group";
	}
	public ArrayList<Figure> getList() {
		return group;
	}
	public void setList(ArrayList<Figure> List) {
		this.group = List;
	}
	public ArrayList<Figure> listCopy(){
		ArrayList<Figure> copiedList = new ArrayList<>();
		for(Figure fig: group) {
			Figure copiedFigure;
			if(fig.getType().equals("Rect")) {
				copiedFigure = new Rect(fig.getX()+5, fig.getY()+5, fig.getWidth(), fig.getHeight());
				copiedFigure.color = fig.color;
				if(fig.isFill) {
					copiedFigure.isFill = true;
					copiedFigure.figureColor = fig.figureColor;
				}
				copiedList.add(copiedFigure);
			} else if (fig.getType().equals("Oval")) {
				copiedFigure = new Oval(fig.getX()+5, fig.getY()+5, fig.getWidth(), fig.getHeight());
				copiedFigure.color = fig.color;
				if(fig.isFill) {
					copiedFigure.isFill = true;
					copiedFigure.figureColor = fig.figureColor;
				}
				copiedList.add(copiedFigure);
			} else if (fig.getType().equals("Line")) {
				copiedFigure = new Line(((Line) fig).getLX()+5, ((Line) fig).getLY(), ((Line) fig).getLX2() + 5, ((Line) fig).getLY2());
				copiedFigure.color = fig.color;
				copiedList.add(copiedFigure);
			} else if(fig.getType().equals("Group")) {
				ArrayList<Figure> list = new ArrayList<>();
				list = ((Group)fig).listCopy();
				Figure nGroup = new Group(fig.getX() + 5, fig.getY() + 5, fig.getX2() + 5, fig.getY2() + 5);
				copiedList.add(nGroup);
				((Group) nGroup).setList(list);
			}
		}
		return copiedList;
	}
}
