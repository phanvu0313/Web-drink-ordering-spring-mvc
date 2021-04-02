package all.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name="DETAILS")
public class Detail {
	@Id
	private int iddetail;
	
	@ManyToOne
	@JoinColumn(name="idorder")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name="idcate")
	private Category category;
	public int getIddetail() {
		return iddetail;
	}
	public void setIddetail(int iddetail) {
		this.iddetail = iddetail;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}
