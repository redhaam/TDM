package com.abdennour.exo1

object Vocabulaire {
    private val mots: List<String> = listOf(
        "bag",
        "waggish",
    )
    //impossible de tester l application avec une grande liste de mots
    // private val mots = listOf("bag", "waggish", "rail", "foot", "jog", "available", "steep", "detail", "concern", "full", "fortunate", "gifted", "defeated", "icicle", "stretch", "spurious", "famous", "squalid", "able", "muddle", "mug", "welcome", "alive", "halting", "tease", "dogs", "ablaze", "moon", "settle", "floor", "scrape", "detect", "absorbed", "holiday", "scold", "therapeutic", "profuse", "royal", "bright", "cough", "correct", "telling", "hammer", "fruit", "title", "edge", "habitual", "complete", "accidental", "meek", "invention", "tray", "temporary", "perfect", "invincible", "moor", "chess", "profit", "harmony", "program", "dime", "obscene", "zoom", "honorable", "coordinated", "rigid", "locket", "upbeat", "ragged", "guitar", "zinc", "ambiguous", "heat", "whistle", "boring", "verse", "busy", "glamorous", "tricky", "start", "sister", "thank", "detailed", "oafish", "high-pitched", "thumb", "mighty", "whole", "screw", "slow", "cycle", "reduce", "lean", "chop", "cheat", "excite", "crib", "squealing", "gusty", "fall", "ashamed", "digestion", "ready", "aromatic", "tasteful", "last", "yarn", "nonstop", "zesty", "vast", "caption", "possible", "swim", "nutty", "ill-fated", "industrious", "tall", "important", "look", "adaptable", "necessary", "determined", "jellyfish", "momentous", "spare", "theory", "loud", "degree", "foregoing", "hope", "political", "mind", "activity", "late", "real", "strap", "year", "sore", "decision", "thing", "rhythm", "land", "awful", "bike", "acid", "annoy", "swift", "ruddy", "afraid", "sneeze", "slope", "education", "wine", "happen", "mint", "station", "squeal", "secretive", "peel", "synonymous", "stimulating", "hellish", "five", "weight", "ultra", "copper", "rejoice", "mouth", "high", "fax", "table", "troubled", "next", "amazing", "finger", "nonchalant", "boundless", "vase", "trust", "cactus", "anxious", "fail", "long-term", "old-fashioned", "can", "motion", "furtive", "truthful", "refuse", "brave", "nervous", "clean", "cause", "sand", "manage", "tent", "stupendous", "cat", "direful", "ice")

    fun getMotAleatoire(): String {
        return mots.random()
    }
}