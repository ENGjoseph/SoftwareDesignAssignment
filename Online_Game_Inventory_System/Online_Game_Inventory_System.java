import java.util.*;

interface Item extends Cloneable {
    Item clone();
    void use();
}

class Sword implements Item {
    private String name;

    public Sword(String name) {
        this.name = name;
    }

    public Item clone() {
        return new Sword(this.name);
    }

    public void use() {
        System.out.println("Using Sword: " + name);
    }
}

class Gun implements Item {
    private String name;

    public Gun(String name) {
        this.name = name;
    }

    public Item clone() {
        return new Gun(this.name);
    }

    public void use() {
        System.out.println("Using Gun: " + name);
    }
}

class Potion implements Item {
    private String name;

    public Potion(String name) {
        this.name = name;
    }

    public Item clone() {
        return new Potion(this.name);
    }

    public void use() {
        System.out.println("Using Potion: " + name);
    }
}

class ItemFactory {
    public static Item createItem(String type) {
        switch (type.toLowerCase()) {
            case "sword":
                return new Sword("Basic Sword");
            case "gun":
                return new Gun("Basic Gun");
            case "potion":
                return new Potion("Health Potion");
            default:
                System.out.println("Unknown item type!");
                return null;
        }
    }
}

class Inventory {
    private static Inventory instance;
    private List<Item> items;

    private Inventory() {
        items = new ArrayList<>();
    }

    public static Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }

    public void addItem(Item item) {
        if (item != null) {
            items.add(item);
        }
    }

    public void showItems() {
        for (Item item : items) {
            item.use();
        }
    }
}

public class Online_Game_Inventory_System {
    public static void main(String[] args) {

        Inventory inventory = Inventory.getInstance();

        Item sword = ItemFactory.createItem("sword");
        Item gun = ItemFactory.createItem("gun");
        Item potion = ItemFactory.createItem("potion");

        inventory.addItem(sword);
        inventory.addItem(gun);
        inventory.addItem(potion);

        Item clonedSword = sword.clone();
        inventory.addItem(clonedSword);

        System.out.println("Inventory Items:");
        inventory.showItems();
    }
}