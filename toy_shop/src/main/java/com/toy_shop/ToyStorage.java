package com.toy_shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.PriorityQueue;

class Toy {
    int id;
    String name;
    int frequency;

    public Toy(int id, String name, int frequency) {
        this.id = id;
        this.name = name;
        this.frequency = frequency;
    }

    public int getId() {
        return id;
    }

    public int getFrequency() {
        return frequency;
    }
}

public class ToyStorage {
    private List<String> name;
    private List<Integer> id;
    private List<Integer> weight;
    private Random random;
    private PriorityQueue<Toy> queue;

    public ToyStorage(String... toyData) {
        name = new ArrayList<>();
        id = new ArrayList<>();
        weight = new ArrayList<>();
        random = new Random();
        queue = new PriorityQueue<>((t1, t2) -> t2.getFrequency() - t1.getFrequency());

        for (String data : toyData) {
            String[] parts = data.split(" ");
            if (parts.length == 3) {
                try {
                    int id_data = Integer.parseInt(parts[0]);
                    int weight_data = Integer.parseInt(parts[1]);
                    String name_data = parts[2];
                    put(id_data, weight_data, name_data);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid format for toy data: " + data);
                }
            } else {
                System.err.println("Invalid format for toy data: " + data);
            }

        }
    }

    public void put(int id_data, int weight_data, String name_data) {
        id.add(id_data);
        name.add(name_data);
        weight.add(weight_data);
        Toy toy = new Toy(id_data, name_data, weight_data * 10);
        queue.offer(toy);
    }

    public int get() {
        int randomNumber = random.nextInt(100) + 1;
        int sum = 0;
        for (Toy toy : queue) {
            sum += toy.getFrequency();
            if (randomNumber <= sum) {
                return toy.getId();
            }
        }
        return -1; // This should not happen if frequencies are properly set
    }
}