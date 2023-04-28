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

## 3rd Party Libraries

## How to run it
*IMPORTANT -Update this with information about how to build and run your 
project!

## Video Presentation
Here is a link to our video presentation of this Black Jack game: ***URL goes here***