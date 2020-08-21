package ru.geekbrains.Java_2;
import Classes.*;

import java.util.Random;

public class HW1 {


    public static void main(String[] args) {
        Random random = new Random();
        Moving challengers[] =
                {new Human("Usein", 500, 200),
                        new Human("Vasya", 300, 75),
                        new Cat("Barsik", 400, 200),
                        new Cat("Barni", 275, 175),
                        new Robot("Jarvis", 600, 45),
                        new Robot("X7-A8", 250, 175)
                };
        Obstacles obstacles[] = {
                new Treadmill(random.nextInt(400) + 200),
                new Wall(random.nextInt(180) + 20),
                new Treadmill(random.nextInt(400) + 200),
                new Wall(random.nextInt(180) + 20),
                new Treadmill(random.nextInt(400) + 200)
        };
        for (int i = 0; i < challengers.length; i++) {
            System.out.println(challengers[i].getName() + " приступает к полосе препятствий.");
            for (int j = 0; j < obstacles.length; j++) {
                if (obstacles[j] instanceof Treadmill) {
                    if (challengers[i].run(obstacles[j].getSize())) {
                        System.out.println(challengers[i].getName() + " пробежал " + obstacles[j].getSize() + " метров");
                    } else {
                        System.out.println(challengers[i].getName() + " не смог пробежать " + obstacles[j].getSize() + " метров и сходит с дистанции.");
                        break;
                    }

                }
                if (obstacles[j] instanceof Wall) {
                    if (challengers[i].run(obstacles[j].getSize())) {
                        System.out.println(challengers[i].getName() + " прыгнул " + obstacles[j].getSize() + " сантиметров");
                    } else {
                        System.out.println(challengers[i].getName() + " не смог прыгнуть " + obstacles[j].getSize() + " сантиметров и сходит с дистанции.");
                        break;
                    }

                }
            }

        }
    }
}