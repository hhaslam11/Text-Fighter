# Changes in this branch

## This branch addresses the following issue:
### Potion Brewing and more options, ([issue #87](https://github.com/hhaslam11/Text-Fighter/issues/87) in the source hhaslam11/Text-Fighter repository, [issue #8](https://github.com/emmamickas/Text-Fighter/issues/8) in the forked emmamickas/Text-Fighter repository)

## Desired modifications:
### In the current implementation, there are only two potion types and the player can only purchase potions. In the updated version there are now three types of potions and players can brew potions.

## Modified files:
### As viewable in the [Dependency References folder](https://github.com/emmamickas/Text-Fighter/tree/AddConstantArraylistAccessModifiers/Dependency%20References), the following files were modified in the change:
 * [Chest.java](https://github.com/emmamickas/Text-Fighter/blob/AddingPotions/src/com/hotmail/kalebmarc/textfighter/item/Chest.java)
 * [Food.java](https://github.com/emmamickas/Text-Fighter/blob/AddingPotions/src/com/hotmail/kalebmarc/textfighter/main/Food.java)
 * [Game.java](https://github.com/emmamickas/Text-Fighter/blob/AddingPotions/src/com/hotmail/kalebmarc/textfighter/main/Game.java)
 * [Help.java](https://github.com/emmamickas/Text-Fighter/blob/AddingPotions/src/com/hotmail/kalebmarc/textfighter/main/Help.java)
 * [Saves.java](https://github.com/emmamickas/Text-Fighter/blob/AddingPotions/src/com/hotmail/kalebmarc/textfighter/main/Saves.java)
 * [Shop.java](https://github.com/emmamickas/Text-Fighter/blob/AddingPotions/src/com/hotmail/kalebmarc/textfighter/main/Shop.java)
 * [Potion.java](https://github.com/emmamickas/Text-Fighter/blob/AddingPotions/src/com/hotmail/kalebmarc/textfighter/player/Potion.java)
 * [Settings.java](https://github.com/emmamickas/Text-Fighter/blob/AddingPotions/src/com/hotmail/kalebmarc/textfighter/player/Settings.java)
 * [Stats.java](https://github.com/emmamickas/Text-Fighter/blob/AddingPotions/src/com/hotmail/kalebmarc/textfighter/player/Stats.java)

## Testing:
###  The following tests were performed to ensure that behavior was preserved after refactoring/changes:
 * [Potion](https://github.com/emmamickas/Text-Fighter/blob/AddingPotions/src/com/hotmail/kalebmarc/textfighter/player/PotionTest.java)
 * [Settings](https://github.com/emmamickas/Text-Fighter/blob/AddingPotions/src/com/hotmail/kalebmarc/textfighter/player/SettingsTest.java)
 * [Enemy](https://github.com/emmamickas/Text-Fighter/blob/AddingPotions/src/com/hotmail/kalebmarc/textfighter/main/EnemyTest.java)

 #### See [here](https://github.com/emmamickas/Text-Fighter/blob/AddConstantArraylistAccessModifiers/TESTING.md) for more information on testing.
 
 ## Additional resources:
 ### Please view the following to find additional documentation of the changes and the code involved in the changes.
  * [Class Diagrams](https://github.com/emmamickas/Text-Fighter/tree/AddConstantArraylistAccessModifiers/Class%20Diagram) of modified classes.
  * [Dependencies](https://github.com/emmamickas/Text-Fighter/tree/AddConstantArraylistAccessModifiers/Dependency%20References) of modified or dependent classes.
  * [Sequence Diagrams](https://github.com/emmamickas/Text-Fighter/tree/AddConstantArraylistAccessModifiers/Sequence%20Diagrams) of modified or dependent methods.
