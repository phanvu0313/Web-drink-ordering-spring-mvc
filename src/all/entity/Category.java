package all.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORIES")
public class Category {
	@Id
	private int idcate;
	private String namecate;
	private float prices;
	private int discount;
	private boolean newitems;
	private String reviews;
	
	@ManyToOne
	@JoinColumn(name="idtype")
	private Type type;

	public int getIdcate() {
		return idcate;
	}

	public void setIdcate(int idcate) {
		this.idcate = idcate;
	}

	public String getNamecate() {
		return namecate;
	}

	public void setNamecate(String namecate) {
		this.namecate = namecate;
	}

	public float getPrices() {
		return prices;
	}

	public void setPrices(float prices) {
		this.prices = prices;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public boolean isNewitems() {
		return newitems;
	}

	public void setNewitems(boolean newitems) {
		this.newitems = newitems;
	}

	public String getReviews() {
		return reviews;
	}

	public void setReviews(String reviews) {
		this.reviews = reviews;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}
