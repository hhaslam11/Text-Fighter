# Testing cheat functionality:
## The following tests were performed to ensure that behavior was preserved after refactoring/changes:
 ### [Potion Tests](https://github.com/emmamickas/Text-Fighter/blob/AddingPotions/src/com/hotmail/kalebmarc/textfighter/player/PotionTest.java) including testing of the methods:
 * get(string type)
 * set(string type, int quantity, boolean add)
 * use(string type)
 * used(string type)
 * buy(string type)
 * getLevel(string type)
 * getPrice(string type)
 * brewPotion(string type)
 * fruitAvailable(string fruit, string type)
 * useFruitInPotion(string fruit)
 ### [Enemy Tests](https://github.com/emmamickas/Text-Fighter/blob/AddingPotions/src/com/hotmail/kalebmarc/textfighter/main/EnemyTest.java) including testing of the methods:
 * TakeDamage()
 * TakeDamageDie()
 ### [Settings Tests](https://github.com/emmamickas/Text-Fighter/blob/AddingPotions/src/com/hotmail/kalebmarc/textfighter/player/SettingsTest.java) including testing of the methods:
 * GetDif()
 ### [Food Tests](https://github.com/emmamickas/Text-Fighter/blob/AddingPotions/src/com/hotmail/kalebmarc/textfighter/main/FoodTest.java) including testing of the methods:
 * UseInPotion()

## Additional Notes on Testing:Testing Brewing and Adding Potion
### Of the changed classes Chest.java, Game.java, Help.java, Stats.java were menu's and UI elements that utilized Potion methods.
### No additional testing was necessary for these classes.
