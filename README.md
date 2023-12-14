**Data Explorer**<br>
In this project, I worked with an open data set that is a collection of open data sets. Data is Plural is a project run by Jeremy Singer-Vine.The dataset
consists of six columns: edition(date), position, headline(title), text(description), links, and hattips. We are given the dataset via a CSV file <br>
The goal of this programming project is for you to master the following tasks:<br>
working with multi-file programs<br>
reading data from input files<br>
using and understanding command line arguments<br>
working with large data sets<br>
using the ArrayList class<br>
writing classes<br>
working with existing code<br>
extending existing classes (inheritance)<br>
parsing data<br>
working with exception handling<br>
Date Class: represets the edition of a dataset by mimicking a calendar date. <br>
DataSet Class: represents a dataset based on the columns in the CSV file. A valid dataset for us must contain headline, text, and links. <br>
DataSetList Class: represents a storage for multiple dataset objects. <br>
DataIsPlural Class: The actual program that contains the main method. It is responsible for opening and reading the data file, obtaining user input, 
performing some data validation and handling all errors that may occur (in particular, it should handle any exceptions thrown by my other classes and terminate 
gracefully, if need be, with a friendly error message presented to the user). The program is supposed to be given a CSV file name as a command line argument.
We parse through the CSV file, add all valid dataset objects to a list, then allows users to ussue queries. <br>
FileProcess Class: validates and parses the file, then constructs all the dataset objects and adds them to a list. <br>
UserInterface Class:Starts the user interaction and displays results from queries<br>
QueryHandler Class: processes the different types of queries that may be given. <br>
