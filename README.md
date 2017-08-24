# ViLibra Testing Execution over a Appium Grid


### Grid test execution

1. Start Selenium grid ```java -jar selenium-server-standalone-X.XX.X.jar -role hub```
2. Access the grid console (will you see a blank page) ```http://localhost:4444/grid/console```
3. Start the fist node (device) to register over the grid  ```appium --nodeconfig conf/android-23.json -p 4722 -bp 5523 -U emulator-5554```
4. Start the second node (device) to register over the grid  ```appium --nodeconfig conf/android-24.json -p 4724 -bp 5524 -U emulator-5556```
6. Run the `suite.xml` file


### Remember
* change the device names for yours devices (E.g: emualator-5554) on the json files and suite.xml file
* the node registration to the grid (via appium) need NodeJS installed and Appium npm package
* the parameter *--nodeconfig* will get all the information in _.json_ and register the device on the grid (plataform, port, url, etc...).
* the parameter *-p* is the port used by appium to send commands to the device. Don't use a know port and set diferent ports to other nodes.
* O the parameter *-U* is the device name (same reffered as _udid_ on code and _suite.xml_).
