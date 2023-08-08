import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class FoodGame extends JFrame {


    private int answerName;

    private List<Food> foodsStart = new ArrayList<>();

    public FoodGame() {
        startFoods();
        kick();
    }

    private void kick() {
        JOptionPane.showMessageDialog(null, "Pense em uma comida");
        int min = 0;
        int max = foodsStart.size();
        int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);

        String type = foodsStart.get(random_int).getType();
        int answerType = JOptionPane.showConfirmDialog(null, "A comida que você pensou é do tipo: " + type);
        if (answerType == 0) {
            List<Food> foodList = foodsStart.stream().filter(f -> f.getType().equals(type)).collect(Collectors.toList());
            kick(foodList, true);
        } else if (answerType == 1) {
            foodsStart.removeIf(f -> f.getType().equals(type));
            kick(foodsStart, false);
        }
    }

    private void kick(List<Food> foods, boolean hitType) {
        for (Food f : foods) {
            answerName = JOptionPane.showConfirmDialog(null, "A comida que você pensou é: " + f.getName());
            if (answerName == 0) {
                int i = JOptionPane.showConfirmDialog(null, "Acertei! Quer continuar?");
                if (i == 0) {
                    kick();
                }
                return;
            } else if (answerName == 1) {
                int i = JOptionPane.showConfirmDialog(null, "Errei! Quer continuar?");
                if (i == 0) {
                    keepPlaying(foods, hitType);
                }
                return;
            }else {
                return;
            }
        }
    }

    private void keepPlaying(List<Food> foods, boolean hitType) {
        String food = JOptionPane.showInputDialog(null, "Qual foi a comida que você pensou?");
        Optional<Food> optionalFood = foods.stream().filter(f -> f.getName().equals(food)).findFirst();
        if (optionalFood.isEmpty()) {
            if (hitType) {
                createFood(food, foods.get(0).getType());
            } else {
                String type = JOptionPane.showInputDialog(null, "Qual foi o tipo de comida que vc pensou?");
                createFood(food, type);

            }
        }
        kick();
    }

    private void createFood(String food, String type) {
        Food f = new Food(food, type);
        foodsStart.add(f);
    }

    public void startFoods() {
        Food food = new Food("pizza", "massa");
        Food food1 = new Food("lasanha", "massa");
        Food food2 = new Food("macarronada", "massa");
        Food food3 = new Food("bife", "carne");
        Food food4 = new Food("peixe", "carne");
        Food food5 = new Food("pamegiana", "carne");
        Food food6 = new Food("bolo", "doce");
        Food food7 = new Food("sorvete", "doce");
        Food food8 = new Food("pudim", "doce");
        Food food9 = new Food("maçã", "fruta");
        Food food10 = new Food("abacaxi", "fruta");
        Food food11 = new Food("morango", "fruta");
        Food food12 = new Food("uva", "fruta");
        Food food13 = new Food("banana", "fruta");

        foodsStart.add(food);
        foodsStart.add(food1);
        foodsStart.add(food2);
        foodsStart.add(food3);
        foodsStart.add(food4);
        foodsStart.add(food5);
        foodsStart.add(food6);
        foodsStart.add(food7);
        foodsStart.add(food8);
        foodsStart.add(food9);
        foodsStart.add(food10);
        foodsStart.add(food11);
        foodsStart.add(food12);
        foodsStart.add(food13);

    }

}
