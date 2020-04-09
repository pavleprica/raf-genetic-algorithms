# Basic info and how to use

- Most of the program is in Kotlin, beside the Main run class. But as you hopefully already know, Kotlin is basically Java
- To run this program, you need Maven installed on your local machine
- That also means that you have to have Java installed.
- Maven is required for dependency handling if you are running it from your IDE and
for building the jar file if you are running it _manually_
- On start-up the program will ask you to choose the file which contains configuration data
in case you don't provide the file correctly it will go with default values

## Please provide a file with a following naming convention
```$json
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

---
Maven is required for running because of build plug-ins and dependencies used. Only Java can't suffice. 
Plugins and dependencies required: 
```xml
 <plugins>
            <plugin>
                <groupId>org.jetbrains.kotlin</groupId>
                <artifactId>kotlin-maven-plugin</artifactId>
                <version>${kotlin.version}</version>
                <executions>
                    <execution>
                        <id>compile</id>
                        <phase>compile</phase>
                        <goals>
                            <goal>compile</goal>
                        </goals>
                    </execution>
                    <execution>
                        <id>test-compile</id>
                        <phase>test-compile</phase>
                        <goals>
                            <goal>test-compile</goal>
                        </goals>
                    </execution>
                </executions>
                <configuration>
                    <jvmTarget>1.8</jvmTarget>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <executions>
                    <execution>
                        <id>compile</id>
                        <phase>compile</phase>
                        <goals>
                            <goal>compile</goal>
                        </goals>
                    </execution>
                    <execution>
                        <id>testCompile</id>
                        <phase>test-compile</phase>
                        <goals>
                            <goal>testCompile</goal>
                        </goals>
                    </execution>
                </executions>
                <configuration>
                    <source>11</source>
                    <target>11</target>
                </configuration>
            </plugin>
        </plugins>


        <dependencies>
                <dependency>
                    <groupId>org.json</groupId>
                    <artifactId>json</artifactId>
                    <version>20190722</version>
                </dependency>
                <dependency>
                    <groupId>org.projectlombok</groupId>
                    <artifactId>lombok</artifactId>
                    <version>1.18.6</version>
                    <scope>provided</scope>
                </dependency>
                <dependency>
                    <groupId>org.jetbrains.kotlin</groupId>
                    <artifactId>kotlin-stdlib-jdk8</artifactId>
                    <version>${kotlin.version}</version>
                </dependency>
                <dependency>
                    <groupId>org.jetbrains.kotlin</groupId>
                    <artifactId>kotlin-test</artifactId>
                    <version>${kotlin.version}</version>
                    <scope>test</scope>
                </dependency>
            </dependencies>
```