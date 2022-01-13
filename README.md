# Blackjack

## Abstract 

The game is a blackjack game which Simeon, Marco and Kimi programmed with Java and the help of JavaFx for the GUI.

The goal of the project was to make multiple Card games,
so we started with blackjack.

Later we realized that the time was running out, so we decided to only make the blackjack game,
but to make this game final and to make this the best we can make it.

## How to run our code?

If you want to run our code, you can go to the Deployments Tab and
under the Releases Tab you are able to download the .jar file which you are able to run with

```bash
java -jar PATH_TO_YOUR_JAR_FILE.jar
```

Make sure that java is installed otherwise you won't be able to use this command. 

Sometimes there is a problem with the memory usage. It should be fixed by now mostly on machines
that have not that much memory you sometimes need to give the Jar file more memory.
You can do this with

```bash
java -Xmx2048m -jar PATH_TO_YOUR_JAR_FILE.jar
```

We were already able to run it with only 1Gb of memory.
So if you are really low on memory you could replace -Xmx2024m with -Xmx1024m
But on most machines you don't even need to do this.

## Test Cases
We didn't test anything with JUnit, we just tested with Users, because its a game, and
we would let a dealer play against a dealer if that would be the case.

We tested on Windows and on Linux, since Marco and Simeon used Windows, and Kimi was using Linux.
We tested with Java version 8 Update 311.

TestID | Preparations | Description | Expected result
--- | --- | -------| ---| 
T-01 | Startscreen working | If the user clicks on the diamond-ace, he will be redirected to the blackjack-game | Scene changes to the "blackjacktable", where the user can play blackjack.
T-02 | Hitbutton working | If the user clicks on the "Hit" button, he will get another card| another card gets in the userhand and the user still can hit or hold.
T-03 | Holdbutton working| If the user clicks on the "Hold" button, the dealer makes his turn| dealer does his turn, winner gets calculated, if the player wins, he gets his bet and winnings, else he loses his bet.
T-04 | Splitbutton working, 2 times same card, didn't hit yet|The player will get the second hand cards after holding. | If the user clicks on the "Split" button, he will get another hand, and he plays with both hands against the dealer, winner of both games get announced.
T-05 | Textfield working, "Set" button working | If the player enters an amount and presses the "Set" button, the amount will be set| The amount entered will be set, and will be doubled if the player wins.
T-06 | Doublebutton working, hasn't hit yet| If the user clicks on the "Double" button, he will get a card and pays his bet again| Bet gets doubled, the user gets another card. If the user wins, the winnings will be doubled too.
T-07 | Help button working, internet connection is active | The user can get help from the web | The user will get a browsertab, which contain the rules of blackjack, and how he should play.


## Conclusion

