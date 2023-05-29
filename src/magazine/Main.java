package magazine;

public class Main {
    public static void main(String[] args) {
        //Initialize the repository (Magazine)
        Magazine magazine = new Magazine("Zara", 20);

        //Initialize entity (Cloth)
        Cloth cloth1 = new Cloth("red", 36, "dress");

        //Print Cloth
        System.out.println(cloth1); //Product: dress with size 36, color red

        //Add Cloth
        magazine.addCloth(cloth1);

        //Remove Cloth
        System.out.println(magazine.removeCloth("black")); //false

        Cloth cloth2 = new Cloth("brown", 34, "t-shirt");
        Cloth cloth3 = new Cloth("blue", 32, "jeans");

        //Add Cloth
        magazine.addCloth(cloth2);
        magazine.addCloth(cloth3);

        //Get smallest cloth
        Cloth smallestCloth = magazine.getSmallestCloth(); //Product: jeans with size 32, color blue

        System.out.println(smallestCloth);

        //Get cloth
        Cloth getCloth = magazine.getCloth("brown"); //Product: t-shirt with size 34, color brown
        System.out.println(getCloth);


        System.out.println(magazine.report());
        //Zara magazine contains:
        //Product: dress with size 36, color red
        //Product: t-shirt with size 34, color brown
        //Product: jeans with size 32, color blue

    }
}