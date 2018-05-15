public class GroceryItem
{
	private int itemCode;
	private int shelfLife;
	
	GroceryItem(){}
	
	GroceryItem(int i, int s)
	{
		itemCode = i;
		shelfLife = s;
	}
	
	public void setItemCode(int i){itemCode = i;}
	public int getItemCode(){return itemCode;}
	public void setShelfLife(int s){shelfLife = s;}
	public int getShelfLife(){return shelfLife;}
	
	public void display()
	{
		System.out.println(itemCode+"\t"+shelfLife);
	}
}