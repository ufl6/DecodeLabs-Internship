
import java.util.*;

class Flower {

    double sepalLength;
    double sepalWidth;
    double petalLength;
    double petalWidth;
    String species;

    Flower(double sepalLength, double sepalWidth, double petalLength, double petalWidth, String species) {
        this.sepalLength = sepalLength;
        this.sepalWidth = sepalWidth;
        this.petalLength = petalLength;
        this.petalWidth = petalWidth;
        this.species = species;
    }
}

class Neighbor { // represents RESULT of comparing with another flower, not just the flower

    double distance;
    String species;

    Neighbor(double distance, String species) {
        this.distance = distance;
        this.species = species;
    }
}

public class IrisKNN {

    public static double calculateDistance(Flower a, Flower b) { // smaller distance = more similar
        return Math.sqrt(
                Math.pow(a.sepalLength - b.sepalLength, 2)
                + Math.pow(a.sepalWidth - b.sepalWidth, 2)
                + Math.pow(a.petalLength - b.petalLength, 2)
                + Math.pow(a.petalWidth - b.petalWidth, 2)
        );
    }

    public static String predict(List<Flower> trainingData, Flower testFlower, int k) {
        List<Neighbor> neighbors = new ArrayList<>();

        for (Flower flower : trainingData) {
            double distance = calculateDistance(flower, testFlower);
            neighbors.add(new Neighbor(distance, flower.species));
        }

        neighbors.sort(Comparator.comparingDouble(n -> n.distance));

        Map<String, Integer> votes = new HashMap<>();

        for (int i = 0; i < k; i++) {
            String species = neighbors.get(i).species;
            votes.put(species, votes.getOrDefault(species, 0) + 1);
        }

        String predictedSpecies = "";
        int maxVotes = 0;

        for (String species : votes.keySet()) {
            if (votes.get(species) > maxVotes) {
                maxVotes = votes.get(species);
                predictedSpecies = species;
            }
        }

        return predictedSpecies;
    }

    public static void main(String[] args) {

        List<Flower> dataset = new ArrayList<>();

        dataset.add(new Flower(5.1, 3.5, 1.4, 0.2, "Setosa"));
        dataset.add(new Flower(4.9, 3.0, 1.4, 0.2, "Setosa"));
        dataset.add(new Flower(4.7, 3.2, 1.3, 0.2, "Setosa"));
        dataset.add(new Flower(4.6, 3.1, 1.5, 0.2, "Setosa"));
        dataset.add(new Flower(5.0, 3.6, 1.4, 0.2, "Setosa"));

        dataset.add(new Flower(7.0, 3.2, 4.7, 1.4, "Versicolor"));
        dataset.add(new Flower(6.4, 3.2, 4.5, 1.5, "Versicolor"));
        dataset.add(new Flower(6.9, 3.1, 4.9, 1.5, "Versicolor"));
        dataset.add(new Flower(5.5, 2.3, 4.0, 1.3, "Versicolor"));
        dataset.add(new Flower(6.5, 2.8, 4.6, 1.5, "Versicolor"));

        dataset.add(new Flower(6.3, 3.3, 6.0, 2.5, "Virginica"));
        dataset.add(new Flower(5.8, 2.7, 5.1, 1.9, "Virginica"));
        dataset.add(new Flower(7.1, 3.0, 5.9, 2.1, "Virginica"));
        dataset.add(new Flower(6.3, 2.9, 5.6, 1.8, "Virginica"));
        dataset.add(new Flower(6.5, 3.0, 5.8, 2.2, "Virginica"));

        Collections.shuffle(dataset, new Random(42));

        int trainingSize = (int) (dataset.size() * 0.8);

        List<Flower> trainingData = dataset.subList(0, trainingSize);
        List<Flower> testingData = dataset.subList(trainingSize, dataset.size());

        int k = 3; // model checks 3 nearest flowers before deciding
        int correct = 0;

        System.out.println("KNN Classification Results:");
        System.out.println("---------------------------");

        for (Flower testFlower : testingData) {
            String prediction = predict(trainingData, testFlower, k);

            System.out.println("Actual: " + testFlower.species + " | Predicted: " + prediction);

            if (prediction.equals(testFlower.species)) {
                correct++;
            }
        }

        double accuracy = (double) correct / testingData.size() * 100;

        System.out.println("---------------------------");
        System.out.println("Correct predictions: " + correct + "/" + testingData.size());
        System.out.println("Accuracy: " + accuracy + "%");
    }
}
