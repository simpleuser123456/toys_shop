package com.toy_shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyStorage {
    private List<String> name;
    private List<Integer> id;
    private List<Integer> weight;
    private Random random;

    public ToyStorage(String... toyData) {
        name = new ArrayList<>();
        id = new ArrayList<>();
        weight = new ArrayList<>();
        random = new Random();

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
    }

    public String get() {
        int totalWeight = weight.stream().mapToInt(Integer::intValue).sum();
        int randomNum = random.nextInt(totalWeight) + 1;
        int cumulativeWeight = 0;
        
        for (int i = 0; i < weight.size(); i++) {
            cumulativeWeight += weight.get(i);
            
            if (randomNum <= cumulativeWeight) {
                // Выбираем текущую игрушку на основе ее веса
                double probability = (double) weight.get(i) / totalWeight;
                double randomProbability = random.nextDouble();
    
                if (randomProbability <= probability) {
                    return name.get(i);
                } else {
                    // Если случайное число не входит в вероятность текущей игрушки,
                    // продолжаем поиск следующей игрушки
                    continue;
                }
            }
        }
        
        return null; // Этого не должно произойти, если веса установлены корректно
    }
}