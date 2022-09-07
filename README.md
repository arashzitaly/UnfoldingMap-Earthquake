# UnfoldingMap-Earthquake
The UCSD Earthquake Project using UnfoldingMaps.

# Info:
### Name and Surname: Arash Ziaee
### Email: arash.ziaee@stud.unifi.it
### University of Firenze - Computer Science Bachelor
### Individual Project

# Introduction:
A GUI created by using Processing and Unfolding Maps library functions in Eclipse IDE to display and print out the earthquakes data which have occured all over the world.
This is a project that I have created with the help of the Object Oriented Programming in Java using data visualization, The course offered by UC San Diego through on Coursera. The project was half created and the other half was asked to implement throughout the course.

## Processing and UnfoldingMaps Libraries:
Processing library: an open-source graphical library and integrated development environment (IDE) built for the electronic arts, new media art, and visual design communities with the purpose of teaching non-programmers the fundamentals of computer programming in a visual context. Processing uses the Java language, with additional simplifications such as additional classes and aliased mathematical functions and operations. It also provides a graphical user interface for simplifying the compilation and execution stage.

Unfolding maps library: Enables you to quickly create interactive maps. Simply create geo-positioned markers to display data on a map. The library supports loading and displaying user-defined shapes, such as points, lines, or polygons.

# Description and Results
### Figure 1
This Figure is the final GUIT visualization of the Project and it will demonstrate our data about the erathquakes around the world.

The map is interactive, so teh User by clcking on the data showed on the map can get the information about that specific earthquake.

![Figure1](https://user-images.githubusercontent.com/58035198/188841000-7f0fc4f5-fb5d-4f38-9de4-cf3615cdd3f5.png)
### Figure 2
The result showed in the console are the quakes happened.

![Figure2](https://user-images.githubusercontent.com/58035198/188841041-2e823c52-1afc-4698-bb52-591762e77449.png)
### Figure 3
In this figure the result showed in the console are the depth and magnitude of the quakes, The result is sorted and printed by the helper method in the corrispond class.


![Figure3](https://user-images.githubusercontent.com/58035198/188841079-ddb227a5-4bb7-45be-b744-d695812acd80.png)


# Class Desciption

## EartquakeCityMarker Class ;
It is the main class which extends PApplet in order to create a GUI. This class includes some methods and helper methods. addKey() is a helper method which draws key in GUI and isInCountry() is another helper method which is used to test whether a given earthquake is in a given country or not. It also adds the country property to the properties of the earthquake feature if it's in one of the countries. Moreover, there is a method called printQuakes() which prints out countries with number of earthquakes.

## CityMarker Class ;
This class extends SimplePointMarker to mark the cities on the map. SimplePointMarker is a class of UnfoldingMaps library which represents marker on a single location.

## Earthquake Marker Class ;
An abstract class which implements a visual marker for earthquakes on an earthquake map. It has two subclasses: LandQuakeMarker and OceanQuakeMarker. EarthquakeMarker class allows these two classes to implement abstract method drawEarthquake() differently. Moreover, class includes method colorDetermine() which allows the derived classes to determine color of marker from depth of the earthquake.

## LandQuakeMarker and OceanQuakeMarker Classes ;
The main difference between these two child classes is that they both implement markers on different places. LandQuakeMarker implements quakes markers on the land; however, OceanQuakeMarker implements them on the ocean.



















