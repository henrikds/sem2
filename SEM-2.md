# [Obligatory Assignment 2: “Battleship”](https://retting.ii.uib.no/inf101.v19.sem2/blob/master/SEM-2.md)

* [README](README.md) – you need to write things here
* **Assignment instructions**

## Teaching goals
- Learning to design software from scratch.
- Implementing and testing your design on your own.
- Creating documentation. Describing and motivating design choices.

## Battleship
In this assignment you're going to implement the game [Battleship](https://en.wikipedia.org/wiki/Battleship_(game)) according to the according to the [2002 Hasbro rules](https://www.hasbro.com/common/instruct/BattleShip_(2002).PDF) with one player controlled by you (the human) and the other by an AI.

You can play Battleship against strangers on the internet [here](http://en.battleship-game.org/). **Note that the rules of this implementation are different from the rules you should use.**

<img src="battleship.jpeg" alt="battleship" width="200"/>

You're going to create a program for playing Battleship. You decide yourself how to create the user interface, how to organize the code, what abstractions to use and what to call classes, interfaces etc. You've received an empty Java project that you should implement the game within. Other than that it's up to you how to implement the game. However, we'll score the assignment (0-100 points) based on how well you've used what you've learned in INF101.

We'll provide some design considerations and suggestions to help you get started as well as, for those among you craving excitement, some ideas on how to make the assignment more interesting.

**Remember that you can (and probably should!) ask for help during the project.** We spend tax money on having teaching assistants for the explicit reason of helping you when you're wondering about something, is unsure of if what you did is a good choice or if you get stuck, and they'd like nothing more than to do so. Even if you feel embarrassed asking about something you feel you should know already or if you feel completely lost (we receive emails from students explaining this is the reason they haven't asked the teaching assistants in every course). Just formulating the question helps you understand what it is you don't understand. Besides, it'd suck for you to fail the assignment just because you didn't dare ask :). You're supposed to get the game working and we're here to help you do so. We're letting you start from scratch to give you experience working in this way, not because you're supposed to know “everything”.

## Handing in
Get the code from:

    https://retting.ii.uib.no/<username>/inf101.v19.sem2.git

(Remember to replace `<username>` with your username.) This repository contains the assignment instructions and an empty Java project. You need to develop the program in this project and push to the repository as you've done previously. When grading your solution we'll look for:

* A working Battleship game that can be played against an AI.
* [README-fil](README.md) explaining design choices, how the code is organized, what abstractions are used and other things we need to know about your code.
* Tests
* Documentation (JavaDoc, comments, diagrams, README, etc.)
* Carefully named classes, interfaces, methods and variables.
* Carefully chosen abstractions and encapsulation (use of classes, interfaces, methods, etc).

You may discuss the assignment with others (in fact, we encourage it), but you have to write the code yourself and you need to write in README.md if specific design choices in your program is due to a discussion with someone. See also on [code review below](SEM-2.md#code-review)

## The program
The goal of the assignment is to create a working implementation of Battleship, where a human controls one side and an AI controls the other side. The requirements are:

* The game works according to the traditional rules for Battleship. TODO: add link to rules
* Det er spillbart, ut ifra [reglene](SEM-2.md#reglene) til det tradisjonelle Fire på Rad.
* The game has a [user interface](SEM-2.md#user-interface) that displays the necessary information to the user (where the ships are, where the player and AI has fired previously, showing if someone has won) and allows the user to input decisions. The user interface can be either text based, using e.g., println and scanner, or a graphical.
* You've implemented an AI player. The AI player doesn't have to be very intelligent. It's sufficient to have it make random valid moves.
* Your code clearly shows how you've used object-oriented programming to create an [abstraction](#abstraction) of the game using, e.g., classes, interfaces etc. Please carefully describe how things fit together in README.md.

## Grading

The number of points (0-100) we give depends on how good your implementation is. Battleship is relatively simple and *can* be implemented in one file without classes and methods (INF100 style). If you solve the assignment in this way you'll receive close to 0 points. We expect that the program works approximately as intended, but to receive a high score you also need to show that you can use object oriented programming effectively and that you can write tests and documentation. **It's better to deliver an implementation that is nicely organized and utilizes excellent abstractions in the spirit of object oriented programming that doesn't work exactly as specified than it is to hand in a fully working game that is poorly organized or is missing tests/documentation.**

We expect that the game works, that you're using classes in a way that makes sense (see below) and that these are documented and have tests. If your implementation is missing something we'll deduct fewer points if you explain in README.md what the problem is and how you'd have solved it. This is also true for design choices. If it turns out that one of your design choices gives you problems we'll deduct fewer points if you explain what you learned from the experience and what you'd have done differently, even if you don't have time to change the implementation.

## Code Review

*This part isn't mandatory, but makes you a better programmer and helps you prepare the assignment.*

Explaining how your code works to someone else and figuring out how someone else's code works are great ways to build understanding (explaining how the code works to yourself is also a fantastic way to find bugs and is referred to as [rubber duck debugging](https://rubberduckdebugging.com/)). Therefore, we recommend that you gather in groups of, say, 2-4 students and do some [lightweight](http://codingsight.com/lightweight-code-review/) [code review](https://en.wikipedia.org/wiki/Software_peer_review) of each other's code.

You can do it using the same computer, or you can give access to your repository to someone else [as in lab 4](https://retting.ii.uib.no/inf101.v19.oppgaver/inf101.v19.lab4/blob/master/LAB-4-I_GIT.md#11-tilgang) and have them clone and test your code. The point is to give constructive feedback in order to learn and improve the code quality.

Remember to comment what form of code review, if any, you used, what you changed and so on due to code review in [README.md](README.md).

## Design

In this section, we describe some abstractions often used in a project like this. You're free to do it another way, however. Remember to explain your abstractions in README.md regardless of how you choose. Helping us understand what's going on may save you from unnecessary point deductions.

The different parts of the program should be as separate as possible. For example by using different packages and avoiding unnecessary function calls between classes/packages/etc. **If you've done it well you should be able to replace any one component (e.g., the user interface or AI) without changing any other part of the code.**

### Main loop

Your program needs a core that ties it all together. The core is typically a class with a loop where each iteration corresponds to one round of the game. To write the main loop you need to be able to answer these questions. You'll save time by writing down the answers before you start writing.

* Exactly what happens in each round?
* What does each round have in common?
* What's different when the AI makes a move from when the human makes a move?
* Exactly what happens when the game starts but not in each round?

Siden alle runder (hver spiller sin) likner på hverandre, og alle hele spill (fra start til slutt) likner på hverandre, er det typisk at man lager en løkke for hver, og legger dem inni hverandre:

```java
main(){
loop until program should stop {
    initialize the game;
    loop per single game {
        reset the board to prepare for a new round;
        loop per round {
            do things required in each round;
        }
    }
}
```
By loop we mean any of for, while, do-while. You have to decide which kind of loop is right for each case. This is a good place to user iterators.

### Abstractions

Here are some abstractions that may be a good idea to use.

* Game: Contains the components that make up a game, e.g., board, players, markers.
* Ship: Stores the properties of a ship.
* Board: Contains the current state of the board and provides methods for changing the game state. Contains ships.
* Player: Contains all functionality for making a move in the game. The Game abstraction asks the Player abstraction to make a move and then changes the game state accordingly. For a human player the player abstraction would ask for user input and for an AI player the choice would be made automatically.
* Rules: Could be used to check that a given move is legal and figure out if a player has won. Separating the rules from the rest of the game allows you to  change the rules without changing anything else in your code. For example, maybe you want to implement alternative game modes.

### User interface

The user interface is the part of the program that accepts input from the player (typically string inputs or mouse clicks) and displays the program output (the current state of the game board, what happened due to something the player did and what the player should do next). You can either create a text-based interface that uses text characters in a terminal window to show what's going on or you can create a [graphical user interface](https://www.youtube.com/watch?v=lNN2i5nWJy4) in a separate window. A text based interface is fine. It's more important that you separate the user interface code cleanly from the rest of the code and that this part of your code is well documented.

How well you've managed to separate the user interface code from the rest is measured by how easy it is for you to use someone else's user interface in your game. It should be relatively easy if you have a good API and should require few changes in your code. If you agree on a good way to separate the user interface from the rest with someone else you've effectively developed a standard!

*It's not a requirement to switch user interface with someone else, but if you can do it without too much work you're in very good shape!*

#### (pro) tips

Some (pro) tips for implementing the user interface.

* ...use console-I/O with `Scanner` and `System.out.println()`.
* ...copy the graphics library from another assignment, e.g.,  [the first obligatory assignment](https://retting.ii.uib.no/inf101.v19.oppgaver/inf101.v19.sem1/tree/master/src/inf101/v19/gfx). The graphics can be drawn with text as in the obligatory assignment, with turtle graphics or shapes – see, for example, how the ducks are drawn in [Lab 6](https://retting.ii.uib.no/inf101.v19.oppgaver/inf101.v19.lab6/blob/master/src/inf101/v19/pond/Duck.java). See [the Main class](https://retting.ii.uib.no/inf101.v19.oppgaver/inf101.v19.sem1/blob/master/src/inf101/v19/rogue101/Main.java) for setup (can be made much simpler than in the first obligatory), and to see how you can register keyboard input.
* ...use [Swing](https://docs.oracle.com/javase/tutorial/uiswing/components/index.html) or [JavaFX](https://docs.oracle.com/javase/8/javafx/get-started-tutorial/jfx-overview.htm) to create an interface. You'll have to invest some time to learn how these libraries work. See, e.g., [JavaFX 8 GUI Tutorial](https://code.makery.ch/library/javafx-8-tutorial/).

I tillegg til en vanlig spiller, må du kunne lage AI-spillere. Bruk gjerne et Spiller-interface som begge disse typene implementerer, og kanskje en felles superklasse dersom de ser ut til å dele oppførsel. Eventuelt kan AI-spiller arve fra Spiller. Vurder selv hvordan du vil gjøre det, og begrunn valget ditt.

## Getting started

I (Albin) recommend that you start by implementing the game in one or two files and that you get something that sort of works. Once you have a partial implementation I recommend that you start thinking more carefully about what properties Battleship has and how you can represent these using abstractions. Think about which classes you need, what they should contain and how they should fit together. This will be made easier by you having worked on the problem for a bit already. See [the modeling part of the first obligatory](https://retting.ii.uib.no/inf101.v19.oppgaver/inf101.v19.sem1/blob/master/SEM-1_DEL-A.md#oversikt-modellering) for an example.

Once you have an idea on what abstractions you need you can start converting your current program into the one you envisioned (this process is referred to as [refactoring](https://en.wikipedia.org/wiki/Code_refactoring)). You will typically have to stop, rethink your design choices and refactor several times during the project.

### Useful INF101 concepts

***This isn't a check list of things you need and isn't complete.*** This is a list of INF101 concepts that may be useful and how to use them. You surely have to use things not on the list and you don't need to use everything on the list if it doesn't fit.

* **Interfaces**. It's natural to use interfaces to define behavior in your code. Then you can use the interface type instead of the class type in other parts of the program. This makes your program modular and allows parts of it easily.
* **Inheritance**. If objects share some functionality you can improve code re-use by having one class inherit from the other or move the common functionality into a separate class that both inherit from.
* **Factory**. If you need to create a lot of objects from some class or if you need a lot of typical objects it may be a good idea to use a factory. Typically you should use a factory if you have code (if statements etc.) that you copy around at all places you create objects.
* **Tests**. Test your code as well as you can. See previous assignments for suggestions.
* **Preconditions**. Add preconditions to methods and constructors where useful.
* **Data invariant**. Add data invariant (checking that field variables have a valid combination of values) to your classes where you can. This counts as part of the documentation.
* **Data structures**. See Grid from previous assignments.
* **Generic types**. Data structures should be generic. Perhaps also other parts of the program.
* **Iterator**. You can use iterators in several ways. For example, you can iterate over players in the round-loop and over ships to check if they've all been sunk.
* **Class diagrams** Draw a diagram over your classes and how they fit together. This is very useful both for you, for the teaching assistants when they help you.
* ***Encapsulation*** Use private modifiers where you can and hide the internals of classes (variables exact implementation) from other parts of the program as well as you can. Interfaces is a nice way to accomplish this.

## Above and beyond

These are not requirements, but suggestions on things you can develop further if you like.

### Random events
To mix things up a little, you can add random events to your game. These events are executed in each round with a certain probability and change the state of the game. Examples are the following (but it can be anything fun, be creative!):

- Ships move around.
- Storms that damage the ships.
- You get a glimpse of the other board.

### Other rules

You can add alternative game modes to the game with, e.g., special attacks or the ability to drive your ships around.

### Better AI

You can make the AI more intelligent in many ways. You can even develop several different AIs and have them compete against each other. Or crush the AI your friend developed in friendly competition.
