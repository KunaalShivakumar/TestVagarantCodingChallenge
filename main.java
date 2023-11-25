class Product{
 public String production;
 public int unitprice;
 public int GST;
 public int quantity;

   public Product(String production, int unitprice, int GST, int quantity)
   {
     this.production=production;
     this.unitprice=unitprice;
     this.GST=GST;
     this.quantity=quantity;
   }
     
}

public class main{
    public static void main(String[] args)
    {
     Product leather = new Product("leather wallet",1100,18,1);
     Product umbrella= new Product("Umbrella",900,12,4);
     Product cigratte= new Product("Cigratte",200,28,3);
     Product honey= new Product("Honey",100,0,2);

     Product maxGst=  GST(leather,umbrella,cigratte,honey);
     System.out.println("The product with Maximum GST amount is :" +maxGst.production);
     int totalAmount = calculateTotalAmount(leather,umbrella,cigratte,honey);
     System.out.println("The total amount to be paid to the shopkeeper is: " +totalAmount);
    }
    
    private static Product  GST (Product... products)
    {
        Product maxGst=null;
        double maxGSTamount = 0;

        for(Product product : products)
        {
            double getamt=(product.unitprice * product.GST/100.0);

            if(getamt> maxGSTamount)
            {
                maxGSTamount=getamt;
                maxGst=product;
            }
        }
        return maxGst;
    }
    private static int calculateTotalAmount(Product... products)
    {
        int totalAmount=0;
        for(Product product: products)
        {
            double getamt=(product.unitprice*product.GST)/100;
            double discountedPrice =  product.unitprice - (product.unitprice>=500 ? 0.05*product.unitprice:0);
            totalAmount+= (discountedPrice+getamt)*product.quantity;

        }
        return totalAmount;
    }
}
