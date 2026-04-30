package ch13.sec02.exam01;

public class GenericExample {
    public static void main(String[] args) {
        Product<TV, String > product1 = new Product<>();

        //Setter 매게값은 반드시 Tv와 string을 제공
        product1.setKind(new TV());
        product1.setModel("스마트 TV");

        //Getter 리턴값은 Tv와 String이 됨
        TV tv = product1.getKind();
        String tvModel = product1.getModel();

        Product<Car, String> product2= new Product<>();
        product2.setKind(new Car());
        product2.setModel("SUV 자동차");

        Car car = product2.getKind();
        String carModel = product2.getModel();

    }
}
