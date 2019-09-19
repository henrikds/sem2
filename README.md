# [Obligatory Assignment 2: “Battleship”](https://retting.ii.uib.no/inf101.v19.sem2/blob/master/SEM-2.md)


**README**

This project contains [obligatory assignment 2](SEM-2.md). You can [read the assignment instructions online](https://retting.ii.uib.no/inf101.v19.oppgaver/inf101.v19.sem2/blob/master/SEM-2.md) (may contain small updates that aren't in your local copy).

### Running instructions
* To play the game, run: `Main.java`

## Overview
Made a Battleship game where you are able to play against the computer. You can place a number of ship on a board and fire shots against another board. The computer AI does also shot at you ships.

## Design Choices
I've chosen to have the game start with the player to only get to know about his/her board. I thought this would make it easier to start with. Therefore the board of the AI is not introduced before the player has placed all of the ships.

Another design that might be a little harsh, is that if the player makes a mistake when doing an input, the game will not present a new choice. This is just because the game is already pretty slow in it's progress due to the time it takes to input everything through the console. Only choices that can't be skipped are redoable. There are some inputs that if not done correctly will crash the game. An example of this is if you type anything other than a number when presented with a choice between numbered alternatives. But come on, that should'nt be so hard.

## Abstractions
I've split the program into four folders.

###### Game

This contains every class that has to do with the game logic.
- Events - contains a function to check win condition and if a ship has been sunk.
- Printer - contains some functions for printing that were used several times or not just not wanted in Main.java.
- StandardRules - contains the standard rules based on the [2002 Hasbro rules](https://www.hasbro.com/common/instruct/BattleShip_(2002).PDF).
- Steve - is the AI the plays against the player.

###### Grid

Here are every class related to positions and locations in the game logic.
- Area - is a rectangle area represented by two x-coordinates and two y-coordinates.
- Board - is the place a player or an AI place their ships and target their shots.
- Coordinate - is a class working with the input string of board locations. (Ex: "B-3")

###### Objects

Here are all the different objects that can be placed in a board.
- Carrier, Battleship, Destroyer, Submarine and PatrolBoat - are all ships to be placed into the game.
- ShipFactory - is factory to create these ships.
- Hit - is an object that is placed into a board if a shot from either a player or an AI hits a ships location.
- Miss - does the same for a misplaced shot.

###### Tests

As the name probably explains it contains the tests of the program.
- FireTest - checks if a Carrier is hit by the shot aimed at it's location.
- ShipPlacementAITest - checks if a AI is able to place ships by checking if the number of coordinates containing ships is as expected.
AppInfo and Main file lies outside of these folders.

###### AppInfo - contains basic information about the program.
###### Main - contains most of the printing to console and every input from player. As well as the core that ties all the classes together.

### Lessons learned

I had some problems with how I was referring to coordinates. In Board.put(), Area.java and Coordinates.java function I use coordinates where x ranges from [1, width] and y ranges from [1, height]. But in Board.get(), every other function using the Board.get(), I use x ranges [0, width) and y ranges [0, height). This made it harder to deal with coordinates. So I have learned that it is important to be consistent with data structures. So that the right value is returned when a parameter is entered.

## Testing
Most of the testing has been just playing the game, looking for errors. Most of the encountered problems have been possible to solve by reading the error message. And since most of the problems have been with locations and where object are placed printing the board have been the number one way to solve the errors. That being said, there have been a few times where it was needed to go into full debug mode to correct the math of the logic.

## Features / Bugs
* Feature
	One feature is that the AI (Steve) does not fire onto the same place twice. Maybe an obvious choice, but still very useful.
* Bugs
	The program will crash if the player types anything other than a number when when presented with a choice between numbered alternatives.

## Code review experience
Have only worked on this by myself. (FeelsBadMan)
