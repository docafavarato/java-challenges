package entities;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	private Date moment;
	private OrderStatus status;
	private List<OrderItem> items = new ArrayList();
	private Client client;
	
	public Order() {}
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() { return moment; }
	
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	
	public OrderStatus getStatus() { return status; }
	
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public void addItem(OrderItem item) { 
		this.items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		this.items.remove(item);
	}
	
	public Double total() {
		double sum = 0;
		for (OrderItem item : this.items) {
			sum += item.subTotal();
		} return sum;
	}
	
	public List<OrderItem> getItems() { return this.items; }

	@Override
	public String toString() {
		return "Order [moment=" + moment + ", status=" + status + ", items=" + items + "]";
	}
}
