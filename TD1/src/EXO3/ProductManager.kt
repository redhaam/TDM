class ProductManager {

    fun getTypeNumber(products:List<Product>, type:String):Int{
        return products.count { product -> product.getType()==type };
    }

    fun getPacks(products: List<Product>,name:String):List<Pack>{
        var packs=  products.filter {  product -> product.getType()== "Pack"} as List<Pack> ;

        return packs.filter { p -> p.smartphonesList.find { s -> s.name ==name } != null  };
    }

    fun getTotalPrice(products: List<Product>):Long{
        var totalPrice:Long=0;
        products.forEach { product -> totalPrice+=product.price* product.qte };
        return totalPrice;

    }
}