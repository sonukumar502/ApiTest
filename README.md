# gojek API ASSIGNMENT

# Tools:
1. Java 
2. TestNG
3. Maven
4. Git

# Approach:
1. Read both the text files and get urls and store it in array of strings.
2. Count the urls in both files and run the comparison for the lower count.
3. Split the urls into 5 parts so that we can achive parallel execution
4. Run each API using UNIREST client and get teh corresponding JSON files
5. Get the data details of each JSON, If JSON has mutiple data iterate over each data node. Store the data in structured form ie Arraylist of Map.
6. If both the urls same dont get the API details and just declare the apis as equal
7. If urls are different compare the above arraylists of both the url and come to conclusion.

# Steps to run the code:
1. Maven CLEAN INSTALL runs the testng.xml file and runs the code in 5 parallel nodes


