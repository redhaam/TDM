fun main(args:Array<String>) {
    var phones= mutableListOf<Smartphone>(Smartphone("redmi note 8",9,32000,"redmi","m19083cjg","black",9),Smartphone("redmi note 10",2,56000,"redmi","m21093cjg","white",2));
    var products= mutableListOf<Product>(Smartphone("samsung s5",5,35000, "samsung","s9400","white",null),Pack("Pack China",4,180000,null,null,phones));
    var productManager= ProductManager();
    println("nombre de produit de type Pack: ${productManager.getTypeNumber(products,"Pack")}");
    println("nombre de produit de type Smartphone: ${productManager.getTypeNumber(products,"Smartphone")}");

    var searchPhone="redmi note 10";
    var packs= productManager.getPacks(products,searchPhone);
    println("La liste des packs contenant le smartphone $searchPhone: ");
    packs.forEach { pack -> println(pack.name) };

    println("Le prix total de la liste des produits: ${productManager.getTotalPrice(products)}");


}