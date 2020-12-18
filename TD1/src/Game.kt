fun main(args:Array<String>){
    var score=0;
    var questions= mutableListOf<String>("dormir","manger","maison","utilisation");
    var play=true;
    println("Bienvenue au jeux d'apprentissage de langue, Vous pouvez toujours quitter le jeu en tapant --")
    while (play) {
        var randomWord = getRandomItem(questions);
        println("Le mot aléatoirement choisi est: $randomWord ");
        var userInput = readLine();
        if (userInput == "--") play = false
        else {
            if (randomWord == userInput) {
                score += 5;
                println("Bravo !!!! Vous avez obtenu 5 points, le score total est : $score points");
            } else {
                println("Echec !!!! le score total est : $score points");
            }
        }
    }
    println("Au revoir!")
}

fun getRandomItem(list: List<String>):String{
    return list.random();
}