# 6205_Final_Project
Update: Dec 06 @ 19:00

The final result can be found under `~/FinalProject/sample.xlsx`.

Do note that, the results generated based on various sort algorithms based on user-defined pinyin order were able to yield same results as what Microsoft Excel would officially sort the names in. Only after over 25% of the input data fed into the application would our results diverse from the official results due to some Chinese characters would have different pronunciations. Pinyin4J would offer results different than what Excel has provided dynamically. 

For user-defined stroke-based sorting algorithm, we would yield same results as what the Excel has processed. 

The benchmark machine has:

|      | ID              | Specification |
| ---- | --------------- | ------------- |
| CPU  | AMD Ryzen 5800H | 4C/8T         |
| RAM  | 32GB            | DDR4 3200MHz  |



---

The project is designed to tackle with the `Final Project` requirement for `INFO 6205` course provided by `Northeastern University`.

Environment version:</br>
JDK:11.0.12</br>
Maven:3.6.0</br>
SqlLite:3.37.0</br>

Dependencies:</br>
Junit:4.11</br>
com.belerweb:2.5.0</br>
log4j:1.2.17</br>
ini4j:0.5.4</br>
junit:4.13.2</br>
pinyin4j:2.5.0</br>

Step to run this project:</br>
1.Import as an maven project</br>
2.Build the structure and update the maven dependencies</br>
3.Check the jdk version and dependencies</br>
4.Update the test resource address(all the txt are in the resource directory)</br>
5.Run the test file</br>

For the final project report, please visit the `Report.pdf` in the root directory!

Thank you for your interests and time!

