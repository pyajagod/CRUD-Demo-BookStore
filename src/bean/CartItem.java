package bean;

public class CartItem {
 private Title title;
 private int quantity;
 public Title getTitles(){
	 return title;
 }
  public void setTitles(Title titles){
	  this.title= titles;
  }
  public int getQuantity(){
	  return quantity;
  }
  public void setQuantity(int quantity){
	  this.quantity=quantity;
  }
}
