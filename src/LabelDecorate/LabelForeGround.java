package LabelDecorate;

import java.awt.Color;

import javax.swing.JLabel;

public class LabelForeGround extends LabelDecorator{
	protected int br,bg,bb;
	public LabelForeGround(LabelDecorator label,int br, int bg, int bb) {
		this.label = label.getLabel();
		this.br= br; this.bb =bb; this.bg = bg;
		decorate();
	}
	public LabelForeGround(JLabel label,int br, int bg, int bb) {
		super(label);
		this.br= br; this.bb =bb; this.bg = bg;
		decorate();
	}
	@Override
	public void decorate(){
		label.setForeground(new Color(br,bg,bb));
	}

}
