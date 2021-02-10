abstract class Product()  {
    abstract var name: String
    abstract var qte: Int
    abstract var price: Long

    abstract fun getType(): String
}