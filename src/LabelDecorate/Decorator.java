package decorate_jy;

public class Decorator extends LabelComponent {
	protected LabelComponent decoratedComponent;

	public Decorator(LabelComponent component) {
		this.decoratedComponent = component;
	}


	@Override
	public void decorate() {
		decoratedComponent.decorate();
	}
	
	

}
