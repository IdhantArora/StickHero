Group Details:
IDHANT ARORA (2022220)
KUNAL (2022259)


Stick Hero Game Implementation
This project is a JavaFX implementation of a simplified version of the Stick Hero game.

Overview
Stick Hero is a game where the player navigates a character across platforms by extending a stick to bridge gaps. The aim is to cover the maximum distance without falling.

Features

Dynamic UI: Utilizes JavaFX for a user-friendly interface.
Platform Navigation: Control the character to reach the next platform.
Transition Animations: Smooth animations for character movement and stick extension.
Scene Switching: Move between different game scenes (e.g., start screen, gameplay screen).

Special Features:
We Have given multiple characters in the game that can be switched. In between the game or any instance.
We have given cherries in between the blocks so that there is a better flow of the game.
We have a special savegame button which helps save our progress before leaving the game if needed urgently.

Design Patterns Used:

1) Singleton - We have used only one hero in the main game slide. When we change the hero when top left button is pressed,
the same image gets updated and another object is not created.
Also we have used only only 1 block for standing, one block for moving and only one cherry which appears and disappears.
2) Flyweight - We have used only one user at a time for playing game and checked for it that it doesn't get entered by another person. 

Instructions For Gameplay:

Clone the repository to your local machine.
Import the project into your preferred Java IDE.
Ensure JavaFX is appropriately set up in your development environment.
Run the HelloApplication class to start the game.

How to Play:

Use mouse clicks to interact with the game elements.
Click and hold to extend the stick across platforms.
Time the stick extension to bridge gaps between platforms.
Reach as far as possible without falling to achieve a higher score.