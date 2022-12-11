package mylib;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class KContainer extends KComponent{
	public ArrayList<KComponent> compoList = new ArrayList<>();
	public KContainer() {}
	public KContainer(String text) {
		super(text);
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setName(String name) {
		this.text = name;
	}
	public void add(KComponent component) {
		compoList.add(component);
	}
}