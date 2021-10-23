Testing constant array access modifier functionality:

The testing of the Armour, Weapon, Food, Enemy, Debug, and Cheat class require UI interaction.
As such, each test requiring UI interaction including:
* ArmourTest: testChooseOnly, testChooseFirst, testChooseMiddle, testChooseLast
* CheatsTest: testCheatGatewaygivemeitall, testCheatGatewayweaponstash, testCheatGatewaythirstforfood
* DebugTest: testMenuWeapon, testMenuFood
* FoodTest: testListChooseFirst, testListChooseMiddle, testListChooseLast
* WeaponTest: testChooseFirst, testChooseMiddle, testChooseLast
Must be run individually rather than running all tests in the class at once.