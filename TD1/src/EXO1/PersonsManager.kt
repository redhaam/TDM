import java.util.Locale
import java.text.NumberFormat


fun main(args: Array<String>) {
    var persons: MutableList<Person> = mutableListOf(Person("2", "2", 55), Person("1", "1", 1))
    persons = FonctionUtile.orderPersonsByAge(persons)
    println(persons)
    println(FonctionUtile.personsOlderThan(persons, 20))
    println(FonctionUtile.charFrequency("hahhhahaha", 'h'))
    println(FonctionUtile.numberFormat(123456789))
}
//Singleton des fonctions utiles
object FonctionUtile {

    //fonction 1 qui ordonne une liste d’objets de type Person par âge.
    fun orderPersonsByAge(persons: MutableList<Person>): MutableList<Person> {
        var _persons = persons
        _persons.sortBy { it.age }
        return _persons
    }
    //fonction 2 qui retourne les personnes qui on plus d'un age donné.
    fun personsOlderThan(persons: MutableList<Person>, age: Int): List<Person> {
        return persons.filter { it.age > age }
    }

    //fonction 3 qui retourne la fréquence d’un caractère dans une chaîne.
    fun charFrequency(string: String, char: Char): Int {
        return string.count { c -> c == char }
    }
    //fonction 4 qui formate un nombre de type Long avec séparateur des milliers.
    fun numberFormat(number: Long): String {
        val nf = NumberFormat.getInstance(Locale("sk", "SK"))
        nf.setGroupingUsed(true)
        return nf.format(number)
    }
}


