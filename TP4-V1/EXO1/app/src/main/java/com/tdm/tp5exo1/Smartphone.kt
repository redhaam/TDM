import java.io.Serializable

data class Smartphone(
    override var name: String,
    override var qte: Int,
    override var price: Long,
    var brand: String,
    var model: String,
    var color: String,
    var qtePhone: Int?,
    var img:Int
) : Product(),Serializable {

    override fun getType(): String {
        return "Smartphone"
    }
}