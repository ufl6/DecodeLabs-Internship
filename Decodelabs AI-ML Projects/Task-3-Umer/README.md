# AI Recommendation System

## Project Overview

This project is a simple **content-based recommendation system** written in Java.

The program asks the user to enter at least three interests, compares those interests with a set of course tags, gives each course a match score, sorts the results, and displays the top three recommendations.

This project was created for **DecodeLabs Artificial Intelligence Project 3**.

## Features

- Takes user interests as input
- Accepts interests separated by commas
- Removes duplicate interests
- Compares user interests with course tags
- Calculates a match score for each course
- Sorts courses from highest score to lowest score
- Displays the top three recommendations
- Handles cases where no matches are found

## Technologies Used

- Java
- `Scanner`
- `HashMap`
- `HashSet`
- `ArrayList`
- Loops and conditional statements

## How the Recommendation System Works

The program follows an **Input → Process → Output** structure.

### Input

The user enters interests such as:

```text
java, ai, data
```

### Process

The program:

1. Splits the input into separate interests.
2. Stores the interests in a `HashSet`.
3. Compares the interests with the tags of each course.
4. Adds one point for every matching tag.
5. Stores the score for each course in a `HashMap`.
6. Sorts the courses by score.

### Output

The program displays the three courses with the highest match scores.

Example:

```text
Top Recommendations:
1. AI Basics Course - Match Score: 2
2. Data Science Course - Match Score: 2
3. Java OOP Course - Match Score: 1
```

## Why `HashMap` Is Used

A `HashMap` stores data as key-value pairs.

In this project, it is used to connect:

```text
Course name → Course tags
```

and:

```text
Course name → Match score
```

Example:

```java
courses.put("Java OOP Course", new String[]{"java", "programming", "oop"});
```

This makes it easy to find the tags or score connected to a particular course.

## Why `HashSet` Is Used

A `HashSet` stores unique values.

It is used to store the user's interests because:

- Duplicate interests are automatically removed.
- The program can quickly check whether an interest exists.
- Repeated words do not unfairly increase a course score.

Example:

```java
HashSet<String> userInterests = new HashSet<>();
```

## Project Structure

```text
AI-Recommendation-System/
├── RecommendationSystem.java
└── README.md
```

## How to Run the Program

### 1. Check that Java is installed

Open a terminal or command prompt and run:

```bash
java -version
```

### 2. Compile the program

Navigate to the folder containing the Java file and run:

```bash
javac RecommendationSystem.java
```

### 3. Run the program

```bash
java RecommendationSystem
```

### 4. Enter your interests

Example:

```text
java, ai, data
```

## Example Run

```text
Welcome to the AI Recommendation System!
Enter at least 3 interests separated by commas.
Example: java, ai, data
Your interests: java, ai, data

Top Recommendations:
1. AI Basics Course - Match Score: 2
2. Data Science Course - Match Score: 2
3. Java OOP Course - Match Score: 1
```

## Main Recommendation Logic

The program checks every tag belonging to each course.

```java
for (String courseName : courses.keySet()) {
    String[] courseTags = courses.get(courseName);
    int score = 0;

    for (String tag : courseTags) {
        if (userInterests.contains(tag)) {
            score++;
        }
    }

    scores.put(courseName, score);
}
```

Each matching tag increases the score by one.

## Possible Improvements

Future versions could include:

- Input validation requiring at least three interests
- More courses and tags
- Percentage-based similarity scores
- Ratings from users
- A graphical user interface
- Saving course data in a file
- Cosine similarity
- TF-IDF weighting

## Author

Created as part of the DecodeLabs Internship Artificial Intelligence training project.
