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
Source version v1.0.0
We didn't test anything with the library JUnit. We just tested with Users, because its a game,
which has some randomness involved (shuffling the stack).

But if we would test to do so, we would try to make a dealer
(player with the rules, which a dealer has) play against another dealer.

We tested our game on Windows and on Linux, since Marco and Simeon used Windows, and Kimi was using Linux -> Arch btw.
We tested with Java Runtime version 8 Update 311.

TestID | Preparations | Description | Expected result
--- | --- | -------| --- | 
T-01 | Game started | If the user clicks on the diamond-ace, he will be redirected to the blackjack-game | Scene changes to the "blackjacktable", where the user can play blackjack.
T-02 | Blackjack must be selected | If the user enters an amount and presses the "Set" button, the amount will be set and cards get revealed | The amount entered will be set, and will be doubled and returned if the user wins, aswell as the cards get revealed to the user.
T-03 | Bet placed | If the user clicks on the "Hit" button, he will get another card | Another card gets in the userhand and the user still can hit or hold.
T-04 | User doesn't wanna hit anymore | If the user clicks on the "Hold" button, the dealer makes his turn | Dealer does his turn, winner gets calculated, if the user wins, he gets his bet and winnings, else he loses his bet.
T-05 | 2 times the same card and didn't hit yet |If the user uses the "Split" button, the user will get the second hand cards after holding. | The user will get another hand of cards, after he holded with the first one and he plays with both hands against the dealer. The winners of both games get announced.
T-06 | hasn't hit yet | If the user clicks on the "Double" button, he will get a card and pays his bet again | Bet gets doubled, the user gets another card. If the user wins, the winnings will be doubled too.
T-07 | internet connection is active, in blackjackscene | The user can get help from the web, through clicking on the "Help" button | The user will get a browsertab, which contain the rules of blackjack, and how he should play.

TestID | Successful | Comments
--- | --- | --- |
T-01 | Yes | You have to wait a few seconds, but it works.
T-02 | Yes | Works perfectly fine
T-03 | Yes | Must be pressed if the user doesnt press double.
T-04 | Yes | It works.
T-05 | Yes | I got the right output.
T-06 | Yes | Works like it's intended to do.
T-07 | Yes | Works great.

## Conclusion

Fortunately, we were able to deliver our project on time. 
Everyone had a task (Kimi = allrounder, Simeon = backend, Marco = frontend) and had to complete it.
So we were able to move forward very efficiently and well. 
If someone had a question, we first asked each other in our group. 
If we had no idea at all, we asked our coach. 
We are also very satisfied with our program and were able to do everything.