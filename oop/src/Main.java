import com.tss.day6.model.Box;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the dimentions of Box1:");
        double box1Width= scanner.nextDouble();
        double box1Height= scanner.nextDouble();
        double box1Depth= scanner.nextDouble();

        Box box1 = new Box(box1Width,box1Height,box1Depth);

        System.out.println("Enter the dimentions of Box2:");
        double box2Width= scanner.nextDouble();
        double box2Height= scanner.nextDouble();
        double box2Depth= scanner.nextDouble();

        Box box2 = new Box(box2Width,box2Height,box2Depth);

        System.out.println("Enter the dimentions of Box3:");
        double box3Width= scanner.nextDouble();
        double box3Height= scanner.nextDouble();
        double box3Depth= scanner.nextDouble();

        Box box3 = new Box(box3Width,box3Height,box3Depth);


    }
}