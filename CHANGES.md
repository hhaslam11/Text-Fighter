# Changes in this branch

## This branch addresses the following issue:
### Show Specific Potion Stats, ([issue #58](https://github.com/hhaslam11/Text-Fighter/issues/58) in the source hhaslam11/Text-Fighter repository, [issue #7](https://github.com/emmamickas/Text-Fighter/issues/7) in the forked emmamickas/Text-Fighter repository)

## Desired modifications:
### In the current functionality, when a player views their stats, they are only able to view a total number of potions used, but not individual totals for different types of potions that they have used. The changes include separating the totals for individual potion types to display each total, while also keeping a total of all potions used by the player.

## Modified files:
### As viewable in the [Dependency References folder](https://github.com/emmamickas/Text-Fighter/tree/ShowSpecificPotionStats/Dependency%20References), the following files were modified in the change:
 * [Potion.java](https://github.com/emmamickas/Text-Fighter/blob/ShowSpecificPotionStats/src/com/hotmail/kalebmarc/textfighter/player/Potion.java)
 * [Stats.java](https://github.com/emmamickas/Text-Fighter/blob/ShowSpecificPotionStats/src/com/hotmail/kalebmarc/textfighter/player/Stats.java)

## Testing:
###  The following tests were performed to ensure that behavior was preserved after refactoring/changes:
 * [Potion](https://github.com/emmamickas/Text-Fighter/blob/ShowSpecificPotionStats/src/com/hotmail/kalebmarc/textfighter/player/PotionTest.java)
 #### See [here](https://github.com/emmamickas/Text-Fighter/blob/ShowSpecificPotionStats/TESTING.md) for more information on testing.
 
 ## Resolution:
 ### The branch was merged with master, closing issue #58:
 [Pull request #125](https://github.com/hhaslam11/Text-Fighter/commit/659955becfa0eb803f4b214821f18dbef9419da8)
 
 ## Additional resources:
 ### Please view the following to find additional documentation of the changes and the code involved in the changes.
  * [Class Diagrams](https://github.com/emmamickas/Text-Fighter/tree/ShowSpecificPotionStats/Class%20Diagram) of modified classes.
  * [Dependencies](https://github.com/emmamickas/Text-Fighter/tree/ShowSpecificPotionStats/Dependency%20References) of modified or dependent classes.
  * [Sequence Diagrams](https://github.com/emmamickas/Text-Fighter/tree/ShowSpecificPotionStats/Sequence%20Diagrams) of modified or dependent methods.
