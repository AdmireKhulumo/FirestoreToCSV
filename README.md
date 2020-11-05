# Firestore To CSV

## Description
A Java app to read all documents in a Cloud Firestore collection and export them to a .CSV file.

### The Problem
I have had plenty of trouble exporting my firstore collections to excel files in the past. Generally, Google prefers we use BigQuery and the like, but those are torublesome and weren't really the solution I needed. Sometimes, I just want all my data in a .CSV file that I can open with Excel and show the client, print out or perform simple data analysis on.

### The Solution
Build a Java app that reads though a Cloud Firestore collection and writes the data to a .CSV file as desired. Technically, I can write to a text file if I want.

This is also a step towards establishing a workflow that will allow me to train my Machine Learning models online without using proprietary tools from database vendors.

#### Notes
* The program writes to a document tilted Users.csv in the app's home directory. This is because I was reading from a users collection on Firestore.


## Future Improvements
* Dynamically assign column names instead of explicitly programming them
* Dynamically read through all the fields and save their data, independent of data type
* Experiment with more Firestore data types such as timestamp, arrays and objects



