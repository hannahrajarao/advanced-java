import java.io.Serializable;
public class Product implements Serializable
{
	private int productNumber;
	private String name;
	private int quantity;
	private double cost;
	
	Product(){}
	Product(int p, String n, int q, double c)
	{
		productNumber = p;
		name = n;
		quantity = q;
		cost = c;
	}
	
	public void setProductNumber(int p){productNumber = p;}
	public int getProductNumber(){return productNumber;}
	public void setName(String n){name = n;}
	public String getName(){return name;}
	public void setQuantity(int q){quantity = q;}
	public int getQuantity(){return quantity;}
	public void setCost(double c){cost = c;}
	public double getCost(){return cost;}
}