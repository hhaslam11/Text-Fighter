# Testing cheat functionality:
## The following tests were performed to ensure that behavior was preserved after refactoring/changes:
 ### [Cheats](https://github.com/emmamickas/Text-Fighter/blob/CheatsIndexOutOfBoundsFix/src/com/hotmail/kalebmarc/textfighter/main/CheatsTest.java) Tests including testing of the methods:
 * cheatGateway()
 ** This method is tested for the 'givemeitall' cheat, the 'weaponstash' cheat, and the 'thirstforfood' cheat.

## Additional Notes on Testing:
### N/A
### All tests may be run as normal through JUnit

# Testing array access modifier functionality:
## The following tests were performed to ensure that behavior was preserved after refactoring/changes:
 ### [Armour Tests](https://github.com/emmamickas/Text-Fighter/blob/AddConstantArraylistAccessModifiers/src/com/hotmail/kalebmarc/textfighter/item/ArmourTest.java) including testing of the methods:
 * choose()
 * getArmours()
 ### [Weapon Tests](https://github.com/emmamickas/Text-Fighter/blob/AddConstantArraylistAccessModifiers/src/com/hotmail/kalebmarc/textfighter/main/WeaponTest.java) including testing of the methods:
 * set(int i)
 * choose()
 * getWeapons()
 ### [Enemy Tests](https://github.com/emmamickas/Text-Fighter/blob/AddConstantArraylistAccessModifiers/src/com/hotmail/kalebmarc/textfighter/main/EnemyTest.java) including testing of the methods:
 * set(int i)
 * get()
 * getIndex(Enemy i)
 * findEnemy()
 * getEnemies()
 ### [Food Tests](https://github.com/emmamickas/Text-Fighter/blob/AddConstantArraylistAccessModifiers/src/com/hotmail/kalebmarc/textfighter/main/FoodTest.java) including testing of the methods:
 * choose()
 * getFoods()
 ### [Cheats Tests](https://github.com/emmamickas/Text-Fighter/blob/AddConstantArraylistAccessModifiers/src/com/hotmail/kalebmarc/textfighter/main/CheatsTest.java) including testing of the methods:
 * cheatGateway()
** This method is tested for the 'givemeitall' cheat, the 'weaponstash' cheat, and the 'thirstforfood' cheat.
 ### [Debug Tests](https://github.com/emmamickas/Text-Fighter/blob/AddConstantArraylistAccessModifiers/src/com/hotmail/kalebmarc/textfighter/main/DebugTest.java) including testing of the methods:
 * menu()
** This method is tested for weapon and food debugging

## Additional Notes on Testing:Testing constant array access modifier functionality:
### The testing of the Armour, Weapon, Food, Enemy, Debug, and Cheat class require UI interaction.
### As such, each test requiring UI interaction including:
* ArmourTest: testChooseOnly, testChooseFirst, testChooseMiddle, testChooseLast
* CheatsTest: testCheatGatewaygivemeitall, testCheatGatewayweaponstash, testCheatGatewaythirstforfood
* DebugTest: testMenuWeapon, testMenuFood
* FoodTest: testListChooseFirst, testListChooseMiddle, testListChooseLast
* WeaponTest: testChooseFirst, testChooseMiddle, testChooseLast
### Must be run individually rather than running all tests in the class at once.

# Testing potion functionality:
## The following tests were performed to ensure that behavior was preserved after refactoring/changes:
 ### [Potion](https://github.com/emmamickas/Text-Fighter/blob/ShowSpecificPotionStats/src/com/hotmail/kalebmarc/textfighter/player/PotionTest.java) Tests including testing of the methods:
 * get(String kind)
 * set(String kind, int amount, boolean add)
 * use(String k)
 * used(String kind)

## Additional Notes on Testing:
### The potion tests are built to work when run all at once or separately except for the testUsed() test case.
### This test case keeps track of all previous actions of the class, and thus will be accurate when only when run with the other tests.
### If you wish to perform only the unit test for the used function, you may reenable the testUsedAlone test and run all tests, or only the testUsedAlone test.
