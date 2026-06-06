# Iris Flower Classification Using K-Nearest Neighbors in Java

## Project Overview

This project is a basic implementation of the **K-Nearest Neighbors (KNN)** classification algorithm in Java.

The program uses flower measurements to predict one of three Iris flower species:

- Setosa
- Versicolor
- Virginica

The project was created as part of **DecodeLabs Artificial Intelligence Project 2: Data Classification Using AI**.

## Project Goal

The goal of this project is to demonstrate the basic supervised machine-learning process:

1. Create and understand a small labelled dataset.
2. Split the dataset into training and testing data.
3. Apply a classification algorithm.
4. Make predictions using unseen test data.
5. Evaluate the model using accuracy.

## Technologies Used

- Java
- Java Collections Framework
- K-Nearest Neighbors classification

No external machine-learning libraries are required.

## Dataset

The program uses a small Iris flower dataset stored directly in the Java file.

Each flower contains four numerical features:

- Sepal length
- Sepal width
- Petal length
- Petal width

Each flower also has a species label:

- `Setosa`
- `Versicolor`
- `Virginica`

Example:

```java
dataset.add(new Flower(5.1, 3.5, 1.4, 0.2, "Setosa"));
```

The first four values are the flower measurements, and the final value is the correct species.

## How the Program Works

### 1. Store the flower data

The `Flower` class represents one flower in the dataset.

```java
class Flower {
    double sepalLength;
    double sepalWidth;
    double petalLength;
    double petalWidth;
    String species;
}
```

### 2. Calculate the distance between flowers

The program uses Euclidean distance to measure how similar two flowers are.

A smaller distance means the flowers have more similar measurements.

```text
distance = square root of the sum of the squared feature differences
```

### 3. Store comparison results

The `Neighbor` class stores the result of comparing a training flower with a test flower.

It stores:

- The calculated distance
- The species of the training flower

### 4. Split the dataset

The dataset is shuffled and divided into:

- 80% training data
- 20% testing data

The fixed random seed `42` makes the shuffle repeatable.

```java
Collections.shuffle(dataset, new Random(42));
```

### 5. Make a prediction

For every test flower, the program:

1. Calculates its distance from every flower in the training data.
2. Sorts the results from the smallest distance to the largest distance.
3. Selects the three nearest flowers because `k = 3`.
4. Counts the species of the nearest flowers.
5. Returns the species with the most votes.

### 6. Evaluate the model

The predicted species is compared with the flower's actual species.

The program counts the number of correct predictions and calculates accuracy using:

```text
accuracy = correct predictions / total test flowers × 100
```

## Project Structure

```text
DecodeLabs-Internship/
├── IrisKNN.java
└── README.md
```

## How to Run the Project

### Requirements

Make sure Java is installed on your computer.

Check your Java installation using:

```bash
java -version
javac -version
```

### Compile the program

Open a terminal in the folder containing `IrisKNN.java` and run:

```bash
javac IrisKNN.java
```

### Run the program

```bash
java IrisKNN
```

## Example Output

The exact predictions are determined by the shuffled training and testing data.

```text
KNN Classification Results:
---------------------------
Actual: Setosa | Predicted: Setosa
Actual: Virginica | Predicted: Virginica
Actual: Versicolor | Predicted: Versicolor
---------------------------
Correct predictions: 3/3
Accuracy: 100.0%
```

## Main Java Concepts Used

- Classes and objects
- Constructors
- Methods
- Lists and `ArrayList`
- Maps and `HashMap`
- Enhanced `for` loops
- Sorting with a `Comparator`
- Conditional statements
- Type casting
- Randomisation

## Machine-Learning Concepts Used

- Classification
- Supervised learning
- Labelled data
- Training data
- Testing data
- Feature comparison
- K-Nearest Neighbors
- Majority voting
- Model accuracy

## Limitations

- The dataset contains only 15 flowers.
- The data is written directly inside the Java program instead of being loaded from a CSV file.
- The program evaluates the model using accuracy only.
- The features are not standardised before calculating distance.
- KNN can become slow with very large datasets because every test item must be compared with every training item.

These limitations are acceptable for a small beginner project designed to demonstrate the basic classification process.

## Possible Future Improvements

- Load the complete Iris dataset from a CSV file.
- Add more training and testing examples.
- Standardise the flower measurements.
- Test different values of `k`.
- Add a confusion matrix.
- Calculate precision, recall, and F1 score.
- Allow the user to enter measurements for a new flower.

## Conclusion

This project demonstrates how a basic classification algorithm can be implemented manually in Java. The KNN model compares an unknown flower with labelled training examples, selects the nearest flowers, and uses majority voting to predict the flower species.

The project provides a beginner-friendly introduction to supervised learning without requiring Python or an external machine-learning library.
