package in.sellmydevice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Mobile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mobile_seq_generator")
    @SequenceGenerator(name = "mobile_seq_generator", sequenceName = "mobile_seq", allocationSize = 1) // Set allocationSize to 1
	private Long id;
	
	@Column(unique = true)
	private String model;
	private String brand;
	private Long maxprice;
	private Long goodprice;
	private Long verygoodprice;
	private Long fairprice;
	
	@Column(length = 1000)
	private String image;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Long getMaxprice() {
		return maxprice;
	}
	public void setMaxprice(Long maxprice) {
		this.maxprice = maxprice;
	}
	public Long getGoodprice() {
		return goodprice;
	}
	public void setGoodprice(Long goodprice) {
		this.goodprice = goodprice;
	}
	public Long getVerygoodprice() {
		return verygoodprice;
	}
	public void setVerygoodprice(Long verygoodprice) {
		this.verygoodprice = verygoodprice;
	}
	public Long getFairprice() {
		return fairprice;
	}
	public void setFairprice(Long fairprice) {
		this.fairprice = fairprice;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
