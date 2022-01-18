package ru.gb.hw1;

import ru.gb.hw1.polymorphism.Circle;
import ru.gb.hw1.polymorphism.Shape;
import ru.gb.hw1.polymorphism.Square;
import ru.gb.hw1.polymorphism.Triangle;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Part 1 Builder
        Person person = Person.builder().firstName("A")
                .lastName("B")
                .middleName("C")
                .country("FR")
                .gender("XL")
                .address("Nowhere")
                .phone("1111")
                .age(95)
                .build();
        System.out.println(person);

        // Part 3 Polymorphism

        List<Shape> shapes = new ArrayList<>();
        Circle circle = new Circle();
        Square square = new Square();
        Triangle triangle = new Triangle();
        shapes.add(circle);
        shapes.add(square);
        shapes.add(triangle);
        for (Shape s: shapes){
            s.draw();
        }
    }
}
