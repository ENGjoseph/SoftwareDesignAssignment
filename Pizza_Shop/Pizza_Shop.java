package Pizza_Shop;

interface Pizza {
    void prepare();
}
class CheesePizza implements Pizza {
    public void prepare(){System.out.println("preparing cheese pizza"); }
}
class VeggiePizza implements Pizza {
    public void prepare() { System.out.println("preparing veggie pizza");}
}
abstract class PizzaShop {
    public abstract Pizza orderPizza(); 
}
class CheesePizzaShop extends PizzaShop {
    public Pizza orderPizza() { return new CheesePizza(); }
}

 class Pizza_Shop {
    public static void main(String[] args) {
        PizzaShop shop = new CheesePizzaShop();
        Pizza myPizza = shop.orderPizza();
        myPizza.prepare();
    }
}