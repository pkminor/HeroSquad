# [HeroSquad ](https://github.com/pkminor/HeroSquad)

Author [Patrick Maina](https://github.com/pkminor)

## Brief description

HeroSquad is a java console application that enables users to assign super heroes to squads for a cause.

## User Requirements

Users can perform the following actions;
- Create a Hero.
- Create a squad.
- Assign a Hero who has not been engaged to a squad.
- View Squads and Heroes.

## How it works
On navigation to the application for the first time, users will be presented with a landing page showing that no heroes or
 squads have been created and that they can create them on the controls on the right.
 
The right side has form controls to create a new hero and a new squad. After each addition,
 the user is able to see the changes displayed. Every assigned hero is eliminated from the list of heroes to be assigned.
 
 The application has three classes
 - Hero
 - Squad
 - App
 
 The squad class contains a hero object.
 The App class is the driver class that defines end user logic with spark routes.
 
## Technology used
 - Java
 - SparkJava
 - Gradle
 - JUnit 4
 - IntelliJ IDEA Community Edition

## Known Bugs
There are no known bugs. Please submit those you find for correction.

## Contributing
Pull requests are encouraged.

## License
This project is licensed under the MIT Open Source license.
