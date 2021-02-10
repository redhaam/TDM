class Pack(
    override var name: String,
    override var qte: Int,
    override var price: Long,
    var giftName: String?,
    var giftQte: String?,
    var smartphonesList: List<Smartphone>
) : Product() {
    override fun getType(): String {
        return "Pack";
    }
}