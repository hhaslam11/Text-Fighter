# Changes in this branch

## This branch addresses the following issue:
### Show Specific Potion Stats, ([issue #46](https://github.com/hhaslam11/Text-Fighter/issues/46) in the source hhaslam11/Text-Fighter repository, [issue #4](https://github.com/emmamickas/Text-Fighter/issues/4) in the forked emmamickas/Text-Fighter repository)

## Desired modifications:
### In the current implementation, when accessing an array from a static class including Weapon, Enemy, and Food, the array is accessed directly. The changes include implementing an access modifier to these arrays.

## Modified files:
### As viewable in the [Dependency References folder](https://github.com/emmamickas/Text-Fighter/tree/AddConstantArraylistAccessModifiers/Dependency%20References), the following files were modified in the change:
 * [Armour.java](https://github.com/emmamickas/Text-Fighter/blob/AddConstantArraylistAccessModifiers/src/com/hotmail/kalebmarc/textfighter/item/Armour.java)
 * [Weapon.java](https://github.com/emmamickas/Text-Fighter/blob/AddConstantArraylistAccessModifiers/src/com/hotmail/kalebmarc/textfighter/main/Weapon.java)
 * [Enemy.java](https://github.com/emmamickas/Text-Fighter/blob/AddConstantArraylistAccessModifiers/src/com/hotmail/kalebmarc/textfighter/main/Enemy.java)
 * [Food.java](https://github.com/emmamickas/Text-Fighter/blob/AddConstantArraylistAccessModifiers/src/com/hotmail/kalebmarc/textfighter/main/Food.java)

## Testing:
###  The following tests were performed to ensure that behavior was preserved after refactoring/changes:
 * [Armour](https://github.com/emmamickas/Text-Fighter/blob/AddConstantArraylistAccessModifiers/src/com/hotmail/kalebmarc/textfighter/item/ArmourTest.java)
 * [Weapon](https://github.com/emmamickas/Text-Fighter/blob/AddConstantArraylistAccessModifiers/src/com/hotmail/kalebmarc/textfighter/main/WeaponTest.java)
 * [Enemy](https://github.com/emmamickas/Text-Fighter/blob/AddConstantArraylistAccessModifiers/src/com/hotmail/kalebmarc/textfighter/main/EnemyTest.java)
 * [Food](https://github.com/emmamickas/Text-Fighter/blob/AddConstantArraylistAccessModifiers/src/com/hotmail/kalebmarc/textfighter/main/FoodTest.java)
 * [Cheats](https://github.com/emmamickas/Text-Fighter/blob/AddConstantArraylistAccessModifiers/src/com/hotmail/kalebmarc/textfighter/main/CheatsTest.java)
 * [Debug](https://github.com/emmamickas/Text-Fighter/blob/AddConstantArraylistAccessModifiers/src/com/hotmail/kalebmarc/textfighter/main/DebugTest.java)
 #### See [here](https://github.com/emmamickas/Text-Fighter/blob/AddConstantArraylistAccessModifiers/TESTING.md) for more information on testing.
 
 ## Resolution:
 ### The branch was merged with master:
 [Pull request #127](https://github.com/hhaslam11/Text-Fighter/commit/555f73191bb4e5476f82c6f481dd3b8190866159)
 
 ## Additional resources:
 ### Please view the following to find additional documentation of the changes and the code involved in the changes.
  * [Class Diagrams](https://github.com/emmamickas/Text-Fighter/tree/AddConstantArraylistAccessModifiers/Class%20Diagram) of modified classes.
  * [Dependencies](https://github.com/emmamickas/Text-Fighter/tree/AddConstantArraylistAccessModifiers/Dependency%20References) of modified or dependent classes.
  * [Sequence Diagrams](https://github.com/emmamickas/Text-Fighter/tree/AddConstantArraylistAccessModifiers/Sequence%20Diagrams) of modified or dependent methods.
