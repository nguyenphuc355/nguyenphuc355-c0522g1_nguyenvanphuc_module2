package ss5_accessmodifile_staticmethod_staticproperty.practice.StaticProperty;

public class MainStaticProperty {
    public static void main(String[] args) {

        StaticProperty car1 = new StaticProperty("Mazda 3","Skyactiv 3");

        System.out.println(StaticProperty.numbersOfCars);

        StaticProperty car2 = new StaticProperty("Mazda 6","Skyactiv 6");

        System.out.println(StaticProperty.numbersOfCars);

    }

}
