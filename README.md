# CSCI 205 - Software Engineering and Design
Bucknell University  
Lewisburg, PA

### Course Info
Instructor: King   
Semester: Spring 2023

## Team Information
**Team 04**                                   
Taylor LaMantia, Developer (Junior) - Computer Engineering, Management
<br>Eva Frankovic, Scrum Master (Junior) - Computer Science  
Ashley Albert, Product Owner (Sophomore) - Computer Science

## Project Information
We are creating a classic poker game: Blackjack! The rules of Black Jack are simple.
The object of the game is to get your cards to equal 21 to beat the dealer.  You cannot trade your
cards with the dealer or other players.  You can hit to receive another card from the dealer, or stand
to go head to head with the house. Just don't get over 21!  If you bust you lose!

This game of Black Jack was implemented with various classes, such as a card, hand, deck, dealer, user, and game class. 
Each of these classes represent what they are named, meaning, for example, the card class represents a card and a hand
represents a hand of cards (and so on).  These classes are all contained in the model portion of our coding structure, 
which is the MVC design pattern.  The controller portion of this design pattern contains a controller for each of the 
scenes we have created, such as a BlackJackPlayController for the playing screen and a BlackJackSettingsController for 
the settings screen (and so on).  All the fxml files found under our resources package contribute to the view portion of
the MVC design pattern.  These files were created using JavaFX, and are responsible for creating 
what the user sees and interacts with.

Our game of Blackjack contains enumeration and exceptions along with our classes. We also have resources that we use to 
help and improve our classes. We have testing files, images, and even a mp3 file to play as background music.
Enumerations are used to declare the suit, rank, chip, game state, and FXMLScene names.  The exceptions we have implemented are an 
EmptyDeckException, a HandIndexOutOfBoundsException, and a NegativeBalanceException.  Our testing files test the 
classes we have created to ensure they are valid and work properly.  Lastly, the "images" folder we have included 
contains images of each card's face, the back of one card, varying chips, a welcoming image, and icons, such as a home
icon, a speaker icon, and a sparkle icon.

## Package Structure
Our package structure consists of a large package in the java package labeled "org.team04.blackjackmvc".  There is also 
file labeled "module-info.java" in the java package as well.  Within the "org.team04.blackjackmvc", there is a model package,
a BlackjackGameOverController, a BlackJackLoginController, a blackjackMain with the enumeration FXMLScenes, a BlackJackPLayController,
a BlackJackSettingsController, a BlackjackWelcomeController, and a NegativeBalanceException.  Within the model package is 
a Card, Dealer, Deck, Game, Hand, and User class as well as an EmptyDeckException, HandIndexOutOfBoundsException, 
InsufficientFundsException, and a WinState enumeration.

The next main package is the resources package, which has an "org.team04.blackjackmvc" package, a back.png, and a jazz.wav.
Within the "org.team04.blackjackmvc" package, there is an images package, a scenesNotBeingUsed package, a back.png, and all the FXML files
for the welcome, settings, login, play, and game over screens.  Within the images package is a cards package and an image of 
the back arrow icon, a black chip, a blue chip, the cards for the welcome screen, a green chip, the home icon, a red chip,
a sparkle emoji, the speaker icon, and smaller welcome cards.  The cards package contains 52 images of the fronts of each card and one
for the back of the card, totaling in 53 images within the cards package.

The test package expands to a java package, which then expands to a "org.team04.blackjackmvc.model" package.  Inside of that
package is a test file for the deck, hand, and user.

All of this listed above is in the larger src package within the "csci205_final_project" package.  Under that package is also
a Design package, which contains our Use Case Diagram, CRC Cards, and Class Diagram.  Another package under the larger
"csci205_final_project" package is the docs package, which contains the user manual, the design manual, and the scrum report.


## 3rd Party Libraries
We did not use any 3rd Party Libraries in this project besides JavaFX. JavaFX is at version 17 and the link is https://openjfx.io/. 

## How to run it
Open the terminal and find where you are comfortable copying files into.  You then type in the following command: 
git clone git@gitlab.bucknell.edu:trl008/csci205_final_project.git
A folder named "csci205_final_project" should have been created.  Navigate into this folder and run the command listed below:
gradle wrapper
Once the operation completes, run the following:
./gradlew run
After this, the application should begin, so congratulations! Enjoy the game!!

## Video Presentation
Here is a link to our video presentation of this Black Jack game: ***URL goes here***