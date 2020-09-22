# StreamingService Desktop App

## Summary
Desktop app where it's possible to create an user and afterwards browse various movies and series which can be sorted by eg. genre, rating and release. 
It is also possible to search for a specific movie or series and to add that movie/series to a custom favorite list. <br />
You can try the app by downloading and running the included .jar file.

## Pictures of the App
<p float="left">
<img  src="https://user-images.githubusercontent.com/44057369/91341336-a3306a00-e7d9-11ea-96e4-1a27f1a3ec2a.png"  width="30%" height="200"/> 
 <img src="https://user-images.githubusercontent.com/44057369/91341891-86e0fd00-e7da-11ea-806a-68dc62cb5055.png" hspace="12" width="30%" height="200"/> 
 <img src="https://user-images.githubusercontent.com/44057369/91341804-62852080-e7da-11ea-9a1d-8f4c45559b14.png" hspace="12" width="30%" height="200"/>
</p>


 ## Tech 
* Java - Class-based, object-oriented and general-purpose programming language used to develop the application.
* JavaFX - Java GUI library for creating applications that can run across multiple platforms and devices.
* H2 - Relational database management system embedded in the application.
* JUnit - Unit testing framework for Java.
* Maven - Build automation tool that manages the build and it's dependencies. 

## Setup
1. Clone the repo
```sh
git clone https://github.com/nbryn/streaming-service.git
```
2. Open an IDE like e.g. Intellij
3. Click 'Import Project' and choose the root folder of the cloned project
4. Select 'Maven' when the 'Import Project' screen opens
5. Run the application by using the following command 
```sh
mvn clean compile exec:java
```

<!--
<table >
 <tr>
     <td align="center"> <b> Overview </b> </td>
     <td align="center"> <b> Search </b> </td>
     <td align="center"> <b> Movie Info </b> </td>
  </tr>
  <tr >
<td> <img  src="https://user-images.githubusercontent.com/44057369/91341336-a3306a00-e7d9-11ea-96e4-1a27f1a3ec2a.png"  width="350" height="250"/> </td>
<td> <img  src="https://user-images.githubusercontent.com/44057369/91341891-86e0fd00-e7da-11ea-806a-68dc62cb5055.png"  width="350" height="250"/> </td>
<td> <img  src="https://user-images.githubusercontent.com/44057369/91341804-62852080-e7da-11ea-9a1d-8f4c45559b14.png"  width="350" height="250"/> </td>
</tr>
 -->
