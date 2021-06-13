package LabelDecorate;

import java.awt.Color;

import javax.swing.JLabel;

public class LabelBackGround extends LabelDecorator{
	protected int br,bg,bb;
	public LabelBackGround(LabelDecorator label,int br, int bg, int bb) {
		this.label = label.getLabel();
		this.br= br; this.bb =bb; this.bg = bg;
		decorate();
	}
	public LabelBackGround(JLabel label,int br, int bg, int bb) {
		super(label);
		this.br= br; this.bb =bb; this.bg = bg;
		decorate();
	}
	@Override
	public void decorate(){
		label.setBackground(new Color(br,bg,bb));
	}

}
