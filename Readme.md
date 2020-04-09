# Basic info and how to use

- Most of the program is in Kotlin, beside the Main run class. But as you hopefully already know, Kotlin is basically Java
- To run this program, you need Maven installed on your local machine
- That also means that you have to have Java installed.
- Maven is required for dependency handling if you are running it from your IDE and
for building the jar file if you are running it _manually_
- On start-up the program will ask you to choose the file which contains configuration data
in case you don't provide the file correctly it will go with default values

## Please provide a file with a following naming convention
```$xslt
{
  "rate": 0.2,
  "populationSize": 50,
  "populationSizeNew": 50,
  "tournament": 3,
  "outputFile": "resultOutput.txt",
  "maxIteration": 100
}
```
If you don't it will take default values.

#### Running it manually
- Please enter the directory of the folder, run `mvn clean install` and in the target folder
you can find the .jar file.
#### Running it with your IDE (Recommended)
- Please open it as a Maven project. Import the dependencies with your IDE and simply
start from the Main class. 