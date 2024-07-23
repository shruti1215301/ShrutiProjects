package product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MyProduct {
	@Id
	@GeneratedValue
	private int Pid;
	public int getPid() {
		return Pid;
	}
	public String getTitle() {
		return title;
	}
	public String getQuantity() {
		return quantity;
	}
	public String getSize() {
		return size;
	}
	public String getImagesrc() {
		return imagesrc;
	}
	public void setPid(int pid) {
		Pid = pid;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public void setImagesrc(String imagesrc) {
		this.imagesrc = imagesrc;
	}
	private String title;
	private String quantity;
	private String size;
	private String imagesrc;
	private String uploader;
	
	MyProduct(){
		
	}
	
	public MyProduct(String t,String q,String s, String img,String uploader){
		this.title=t;
		this.quantity=q;
		this.size=s;
		this.imagesrc=img;
		this.setUploader(uploader);
	}
	public String getUploader() {
		return uploader;
	}
	public void setUploader(String uploader) {
		this.uploader = uploader;
	}
	

}
