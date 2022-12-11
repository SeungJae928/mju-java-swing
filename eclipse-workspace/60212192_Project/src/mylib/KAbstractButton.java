package mylib;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;




public abstract class KAbstractButton extends KComponent{
//	protected Color btnColor = Color.black;
	public KAbstractButton(String text){
		super(text);
	}
	public abstract void setBounds(int x, int y, int width, int height);
	public void addKActionListener(KActionListener kal) {
		this.kal = kal;
	}
	public void unClicked() {}
}