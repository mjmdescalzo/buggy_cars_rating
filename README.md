# READ ME

## Outcome:
1. Test Approach - please see TestApproach.md
2. Documentation of Bugs - please see Bugs.md
3. Top 3 critical functionalities of BuggyCars to Automate should be
   
| Functionality |
| ------------- |
| Registration  |
| Login         |
| Logout        |

## Prerequisites to running
1. Install Intellij IDEA
2. In the Settings/Preferences dialog Ctrl+Alt+S, select Plugins.
3. Switch to the Installed tab and make sure that the following plugins are enabled (the plugins must be enabled in the specified order):
   * Gherkin
   * Cucumber for Java
4. If the plugins are not installed, switch to the Marketplace tab, type their names in the search field in the specified order, and click Install next to each of them.
5. Apply the changes and close the dialog. Restart the IDE if prompted.

## To run the test
### Using Maven
1. On the right side on IDEA, click Maven
2. In the expanded menu, navigate to surefire-report:report and double click it <br/>
   testframework > Plugins > surefire-report > surefire-report:report

This will run the test and the report generated can be found on **target/site/surefire-report.html**

### Using JUnit
1. Navigate to src/test/java/testframework/RunCucumberTest.java
2. A green Play icon will appear on the left side of the classname, click it
3. Results will display in the Run window