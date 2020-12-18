
import java.util.Locale


fun main(args:Array<String>){
    var persons:MutableList<Person> = mutableListOf(Person("2","2",55),Person("1","1",1));
    persons  = orderPersonsByAge(persons);
    println(persons);
    println(personsOlderThan(persons,20));
    println(charFrequency("hahhhahaha",'h'));
    println(numberFormat(123456789))
}


fun orderPersonsByAge(persons:MutableList<Person>):MutableList<Person>{
    var _persons=persons;
    _persons.sortBy { it.age };
    return _persons;
}

fun personsOlderThan(persons: MutableList<Person>, age:Int): List<Person> {
    return persons.filter { it.age > age };
}

fun charFrequency(string: String, char: Char):Int{
    return string.count { c -> c==char };
}

fun numberFormat(number:Long):String{
    var nf= java.text.NumberFormat.getInstance(Locale("sk", "SK"));
    nf.setGroupingUsed(true);
    return nf.format(number);
}

