# Assignment 2 - Temperature Converter

## Author - Andy Cullen

## Description

Create a temperature converter application.
The application should look like the screen shots I have provided.
The application should do the calculation and display the formula that was used to do the calculation.
The calculation of the conversion should take place in a seperate class
The application should handle errors gracefully.
The application should have a different layout for landscape form that looks like the one pictured here.
The application must retain it's information on the screen when rotated to lanscape.

Solution Requirements:

* Seperate class for calculation
* Handle errors gracefully
* Seperate Layout for landscape
* Retain information across rotation

![alt text](http://barnesbrothers.homeserver.com/cis298/assignmentImages/assignment2a.jpg "Application Portrait Layout")
![alt text](http://barnesbrothers.homeserver.com/cis298/assignmentImages/assignment2b.jpg "Application Landscape Layout")
### Notes

The book does not cover how to do work with Radio Buttons. I will talk about it as needed in class. If you are stuck or have questions about it, ask.

## Outside Resources Used

https://en.wikipedia.org/wiki/Conversion_of_units_of_temperature
The webpage above showed me the formulas needed to convert between temperature scales.

http://stackoverflow.com/questions/5179686/restoring-state-of-textview-after-screen-rotation
The webpage above showed me a far easier method of restoring values on screen rotation:

	android:freezesText="true"

"If set, the text view will include its current complete text inside of its frozen icicle in addition to meta-data such as the current cursor position. By default this is disabled; it can be useful when the contents of a text view is not stored in a persistent place such as a content provider."

(I used this instead of the saveInstanceState/restoreInstanceState methods.)

## Known Problems, Issues, And/Or Errors in the Program

Works fine!
