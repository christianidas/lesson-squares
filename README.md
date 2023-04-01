# Lesson Squares
A step by step guide to build an entire web service for a squares application using Java Spring Boot, Spring Data, and a MySQL database. This repo will serve as the "final" product for this application, along with lessons to break down how we got there. The goal is to start an application from scratch, and use this as a guide to get to the same product.

## Prerequisites
- This guide assumes that [IntelliJ Idea](https://www.jetbrains.com/idea/) is installed, and that you are able to create and run a Java application using the tool. A helpful tutorial can be found [here](https://www.jetbrains.com/help/idea/creating-and-running-your-first-java-application.html).
- It would be beneficial to get familiarized with [Git](https://git-scm.com/) so you can follow along and commit as you go. A helpful tutorial can be found [here](https://www.w3schools.com/git/default.asp).
  > Tip: Commit a lot. Any time you are at a point where you have made a change that accomplished something, commit that change. Then you will always have it as a reference point to revert back to if something goes wrong.

## Lessons
Click on each lesson header below to get more information.

### [Lesson 1](https://github.com/christianidas/lesson-squares/releases/tag/1)
Build a squares application with a command line interface to manage the grid.

### [Lesson 2](https://github.com/christianidas/lesson-squares/releases/tag/2)
Add services and controllers to make squares more robust.

### [Lesson 3](https://github.com/christianidas/lesson-squares/releases/tag/3)
Save data into a database.

### [Lesson 4](https://github.com/christianidas/lesson-squares/releases/tag/4)
Wrap the application in a Spring Boot web service, replacing our old Command Line Interface. After this, we should be able to make HTTP requests to control our grids and persons in the same way as our previous CLI.

### [Lesson 5](https://github.com/christianidas/lesson-squares/releases/tag/5)
Add Spring Data, and simplify our code for manipulating our data. We will have code that is very agnostic to the actual database schemas, and avoid the need to write any complicated queries to do simple things that the app needs.

### [Lesson 5.1](https://github.com/christianidas/lesson-squares/releases/tag/5.1)
Create reusable abstract classes for all of our boilerplate CRUD (Create, Retrieve, Update, Delete) operations so we can avoid duplicating code for this common functionality across all of our entities.