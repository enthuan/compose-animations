package fr.demo.anim.model

import androidx.annotation.DrawableRes
import fr.demo.anim.R

data class Cat(
    val id: Int,
    val name: String,
    val title: String,
    // In months
    val age: Int,
    val gender: Gender,
    @DrawableRes val photoAsset:  Int,
    val temper: String,
    val abilities : Triple<Float, Float, Float>
)

enum class Gender {
    Male, Female;
    companion object {
        fun getLabel(gender: Gender)
         = when (gender) {
            Male -> "Mâle"
            Female -> "Femelle"
        }
    }
}

val catList = listOf(
    Cat(0, "Georges", "le curieux", 2, Gender.Male, R.drawable.cat_01, "Whatever tickle my belly at your own peril i will pester for food when you're in the kitchen even if it's salad for miaow then turn around and show you my bum and why dog in house?", Triple(0.5f, 0.4f, 0.3f)),
    Cat(1, "Philip", "l'aventurier", 3, Gender.Male, R.drawable.cat_02, "I'm the sole ruler of this home and its inhabitants smelly.", Triple(0.6f, 0.5f, 0.1f)),
    Cat(2, "Billy", "le dormeur", 2, Gender.Male, R.drawable.cat_03, "Stupid dogs, inferior furballs time for night-hunt, human freakout so run up and down stairs what a cat-ass-trophy!", Triple(0.7f, 0.6f, 0.1f)),
    Cat(3, "Greg", "le grognon", 4, Gender.Male, R.drawable.cat_04, "For claw your carpet in places everyone can see - why hide my amazing artistic clawing skills?", Triple(1f, 0.6f, 0.4f)),
    Cat(4, "Julia", "la boulette", 5, Gender.Female, R.drawable.cat_05, "Rub my belly hiss.", Triple(0.8f, 0.5f, 0.8f)),
    Cat(5, "Grignotte", "la timide", 2, Gender.Female, R.drawable.cat_06, "Murf pratt ungow ungow stare out cat door then go back inside stretch, and relentlessly pursues moth for see owner, run in terror and find empty spot in cupboard and sleep all day ha ha, you're funny i'll kill you last.", Triple(1f, 0.6f, 0.1f)),
    Cat(6, "Alfonso", "le comique", 4, Gender.Male, R.drawable.cat_07, "Be a nyan cat, feel great about it, be annoying 24/7 poop rainbows in litter box all day you have cat to be kitten me right meow so lick left leg for ninety minutes, still dirty allways wanting food.", Triple(0.7f, 0.9f, 0.2f)),
    Cat(7, "Bruce", "le justicier", 2, Gender.Male, R.drawable.cat_08, "Instantly break out into full speed gallop across the house for no reason make plans to dominate world and then take a nap need to chase tail, pee in human's bed until he cleans the litter box.", Triple(0.5f, 0.2f, 1f)),
    Cat(8, "Crapule", "la joueuse", 3, Gender.Female, R.drawable.cat_09, "Snob you for another person spill litter box, scratch at owner, destroy all furniture, especially couch floof tum, tickle bum, jellybean footies curly toes.", Triple(0.9f, 0.6f, 0.8f)),
    Cat(9, "Charlie", "le gymnaste", 2, Gender.Male, R.drawable.cat_10, "Stuff and things get away from me stupid dog or need to chase tail, yet walk on keyboard stare at ceiling light.", Triple(0.3f, 0.1f, 0.2f)),
    Cat(10, "Clio", "la feignasse", 2, Gender.Female, R.drawable.cat_11, "Swipe at owner's legs love me!", Triple(0.4f, 1f, 0.8f)),
    Cat(11, "Bill", "le bottier", 6, Gender.Male, R.drawable.cat_12, "Claw at curtains stretch and yawn nibble on tuna ignore human bite human hand please let me outside pouty face yay! wait, it's cold out please let me inside pouty face oh, thank you rub against mommy's leg oh it looks so nice out.", Triple(0.4f, 0.0f, 0.6f)),
    Cat(12, "Zespri", "le kiwi", 2, Gender.Male, R.drawable.cat_13, "Please let me outside again the neighbor cat was mean to me please let me back inside for sit in window and stare oooh, a bird, yum scratch leg; meow for can opener to feed me.", Triple(0.4f, 1f, 0.5f)),
    Cat(13, "Sabrina", "la sorcière", 4, Gender.Female, R.drawable.cat_14, "Throw down all the stuff in the kitchen eat my own ears.", Triple(0.8f, 0.7f, 0.6f)),
    Cat(14, "Mystique", "la planquée", 3, Gender.Female, R.drawable.cat_15, "Sleep in the bathroom sink prance along on top of the garden fence, annoy the neighbor's dog and make it bark yet make it to the carpet before i vomit mmmmmm, or lick face hiss at owner, pee a lot, and meow repeatedly scratch at fence purrrrrr eat muffins and poutine until owner comes back and step on your keyboard while you're gaming and then turn in a circle or have secret plans.", Triple(0.8f, 1f, 0.4f)),
    Cat(15, "Gaston", "le ptit chaton", 4, Gender.Male, R.drawable.cat_16, "Trip on catnip chase mice.", Triple(0.0f, 0.4f, 0.8f)),
    Cat(16, "Tigrou", "le mini félin", 2, Gender.Male, R.drawable.cat_17, "I'm the sole ruler of this home and its inhabitants smelly.", Triple(1f, 0.0f, 0.4f)),
    Cat(17, "Clémence", "le chaton des neiges", 6, Gender.Male, R.drawable.cat_18, "Instantly break out into full speed gallop across the house for no reason make plans to dominate world and then take a nap need to chase tail, pee in human's bed until he cleans the litter box.", Triple(0.4f, 0.1f, 1f)),
    Cat(18, "Matthew", "l'imposteur", 1, Gender.Male, R.drawable.cat_19, "Attempt to leap between furniture but woefully miscalibrate and bellyflop onto the floor;", Triple(0.5f, 0.5f, 0.6f)),
    Cat(19, "Fabrice", "le naturiste", 2, Gender.Female, R.drawable.cat_20, "What's your problem? I meant to do that now i shall wash myself intently walk on a keyboard or find something else more interesting find a way to fit in tiny box dismember a mouse and then regurgitate parts of it on the family room floor and miaow then turn around and show you my bum.", Triple(0.8f, 0.4f, 0.0f)),
    Cat(20, "Clarisse", "l'intrépide", 3, Gender.Female, R.drawable.cat_21, "Adventure always love me! but stuff and things.", Triple(1f, 0.2f, 0.0f)),
    Cat(21, "Félindra", "l'assistée", 2, Gender.Female, R.drawable.cat_22, "Human give me attention meow eat the fat cats food, for stare out the window kitty time stuff and things.", Triple(0.6f, 0.4f, 0.8f)),
    Cat(22, "Ahmed", "le philosophe", 7, Gender.Male, R.drawable.cat_23, "Pet right here, no not there, here, no fool, right here that other cat smells funny you should really give me all the treats because i smell the best and omg you finally got the right spot and i love you right now flee in terror at cucumber discovered on floor so scamper.", Triple(1f, 0.1f, 0.0f)),
    Cat(23, "Paola", "la championne", 2, Gender.Female, R.drawable.cat_24, "Why must they do that sniff all the things or mrow, for use lap as chair.", Triple(0.5f, 0.6f, 0.4f)),
    Cat(24, "Toupie", "le teigneux", 4, Gender.Male, R.drawable.cat_25, "Why must they do that meow but find box a little too small and curl up with fur hanging out.", Triple(0.8f, 0.7f, 0.6f)),
    Cat(25, "Gaïa", "le bon chat", 5, Gender.Male, R.drawable.cat_26, "Give attitude and sometimes switches in french and say \"miaou\" just because well why not time to go zooooom.", Triple(0.0f, 0.6f, 0.1f)),
    Cat(26, "Suki", "la tigresse", 18, Gender.Female, R.drawable.cat_27, "She like to sit on the bed, but don't dare touch her!", Triple(0.2f, 1f, 0.4f)),
)

val initialCatList = catList.filter {
    !listOf(0, 3, 7, 11, 14, 17, 22, 25).contains(it.id)
}
