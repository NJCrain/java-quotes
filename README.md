# Java Quotes
This is an application that will get a random quote from the [Ron Swanson quotes API](https://github.com/jamesseanwright/ron-swanson-quotes#ron-swanson-quotes-api) saves it to the json file in the [assets folder](assets/recentquotes.json), and prints it to the console.

If it cannot establish a connection to the API for whatever reason, it reads in and parses the json file and prints out a random quote from there.

# Install
After cloning the repo, cd into it and run `./gradlew build` from the terminal to install the dependencies for this project.

# Running and Testing
The app can be run using `./gradlew run` in the terminal, it will output a random quote in the console. To run the tests for this app, run `./gradlew test` in the terminal to run all the included test suites.