package az.developia.springcore;

import org.springframework.stereotype.Component;

@Component
public class Computer {
	private String model;
	private int price;
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Computer(String model, int price) {
		super();
		this.model = model;
		this.price = price;
	}
	public Computer() {
		model="Inspiron";
		price=3000;
	}
	@Override
	public String toString() {
		return "Computer [model=" + model + ", price=" + price + "]";
	}

}
