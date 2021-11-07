package view;

import controller.implementation.*;
import model.*;

import java.sql.SQLException;
import java.util.*;

public class MyView {
    private Map<String, String> menu;
    private Map<String, Printable> methodsMenu;
    private static Scanner scanner = new Scanner(System.in);

    private CardBonusController cardBonusController = new CardBonusController();
    private CategoryController categoryController = new CategoryController();
    private CityController cityController = new CityController();
    private DeliveryController deliveryController = new DeliveryController();
    private GenderController genderController = new GenderController();
    private ItemController itemController = new ItemController();
    private OrderController orderController = new OrderController();
    private OrderStatusController orderStatusController = new OrderStatusController();
    private RegionController regionController = new RegionController();
    private SubCategoryController subCategoryController = new SubCategoryController();
    private UserCardController userCardController = new UserCardController();
    private UserController userController = new UserController();

    public MyView() {
        menu = new HashMap<>();
        methodsMenu = new LinkedHashMap<>();

        menu.put("1", "1 - Table: Card Bonus");
        menu.put("1.1", "1.1 - Create for Card Bonus");
        menu.put("1.2", "1.2 - Find all Card Bonus");
        menu.put("1.3", "1.3 - Find by ID Card Bonus");
        menu.put("1.4", "1.4 - Update Card Bonus");
        menu.put("1.5", "1.5 - Delete Card Bonus");
        methodsMenu.put("1.1", this::createCardBonus);
        methodsMenu.put("1.2", this::findAllCardBonus);
        methodsMenu.put("1.3", this::findByIdCardBonus);
        methodsMenu.put("1.4", this::updateCardBonus);
        methodsMenu.put("1.5", this::deleteCardBonus);

        menu.put("2", "2 - Table: Category");
        menu.put("2.1", "2.1 - Create for Category");
        menu.put("2.2", "2.2 - Find all Category");
        menu.put("2.3", "2.3 - Find by ID Category");
        menu.put("2.4", "2.4 - Update Category");
        menu.put("2.5", "2.5 - Delete Category");
        methodsMenu.put("2.1", this::createCategory);
        methodsMenu.put("2.2", this::findAllCategory);
        methodsMenu.put("2.3", this::findByIdCategory);
        methodsMenu.put("2.4", this::updateCategory);
        methodsMenu.put("2.5", this::deleteCategory);

        menu.put("3", "3 - Table: City");
        menu.put("3.1", "3.1 - Create for City");
        menu.put("3.2", "3.2 - Find all City");
        menu.put("3.3", "3.3 - Find by ID City");
        menu.put("3.4", "3.4 - Update City");
        menu.put("3.5", "3.5 - Delete City");
        methodsMenu.put("3.1", this::createCity);
        methodsMenu.put("3.2", this::findAllCity);
        methodsMenu.put("3.3", this::findByIdCity);
        methodsMenu.put("3.4", this::updateCity);
        methodsMenu.put("3.5", this::deleteCity);

        menu.put("4", "4 - Table: Delivery");
        menu.put("4.1", "4.1 - Create for Delivery");
        menu.put("4.2", "4.2 - Find all Delivery");
        menu.put("4.3", "4.3 - Find by ID Delivery");
        menu.put("4.4", "4.4 - Update Delivery");
        menu.put("4.5", "4.5 - Delete Delivery");
        methodsMenu.put("4.1", this::createDelivery);
        methodsMenu.put("4.2", this::findAllDelivery);
        methodsMenu.put("4.3", this::findByIdDelivery);
        methodsMenu.put("4.4", this::updateDelivery);
        methodsMenu.put("4.5", this::deleteDelivery);

        menu.put("5", "5 - Table: Gender");
        menu.put("5.1", "5.1 - Create for Gender");
        menu.put("5.2", "5.2 - Find all Gender");
        menu.put("5.3", "5.3 - Find by ID Gender");
        menu.put("5.4", "5.4 - Update Gender");
        menu.put("5.5", "5.5 - Delete Gender");
        methodsMenu.put("5.1", this::createGender);
        methodsMenu.put("5.2", this::findAllGender);
        methodsMenu.put("5.3", this::findByIdGender);
        methodsMenu.put("5.4", this::updateGender);
        methodsMenu.put("5.5", this::deleteGender);

        menu.put("6", "6 - Table: Item");
        menu.put("6.1", "6.1 - Create for Item");
        menu.put("6.2", "6.2 - Find all Item");
        menu.put("6.3", "6.3 - Find by ID Item");
        menu.put("6.4", "6.4 - Update Item");
        menu.put("6.5", "6.5 - Delete Item");
        methodsMenu.put("6.1", this::createItem);
        methodsMenu.put("6.2", this::findAllItem);
        methodsMenu.put("6.3", this::findByIdItem);
        methodsMenu.put("6.4", this::updateItem);
        methodsMenu.put("6.5", this::deleteItem);

        menu.put("7", "7 - Table: Order");
        menu.put("7.1", "7.1 - Create for Order");
        menu.put("7.2", "7.2 - Find all Order");
        menu.put("7.3", "7.3 - Find by ID Order");
        menu.put("7.4", "7.4 - Update Order");
        menu.put("7.5", "7.5 - Delete Order");
        methodsMenu.put("7.1", this::createOrder);
        methodsMenu.put("7.2", this::findAllOrder);
        methodsMenu.put("7.3", this::findByIdOrder);
        methodsMenu.put("7.4", this::updateOrder);
        methodsMenu.put("7.5", this::deleteOrder);

        menu.put("8", "8 - Table: Order Status");
        menu.put("8.1", "8.1 - Create for Order Status");
        menu.put("8.2", "8.2 - Find all Order Status");
        menu.put("8.3", "8.3 - Find by ID Order Status");
        menu.put("8.4", "8.4 - Update Order Status");
        menu.put("8.5", "8.5 - Delete Order Status");
        methodsMenu.put("8.1", this::createOrderStatus);
        methodsMenu.put("8.2", this::findAllOrderStatus);
        methodsMenu.put("8.3", this::findByIdOrderStatus);
        methodsMenu.put("8.4", this::updateOrderStatus);
        methodsMenu.put("8.5", this::deleteOrderStatus);

        menu.put("9", "9 - Table: Region");
        menu.put("9.1", "9.1 - Create for Region");
        menu.put("9.2", "9.2 - Find all Region");
        menu.put("9.3", "9.3 - Find by ID Region");
        menu.put("9.4", "9.4 - Update Region");
        menu.put("9.5", "9.5 - Delete Region");
        methodsMenu.put("9.1", this::createRegion);
        methodsMenu.put("9.2", this::findAllRegion);
        methodsMenu.put("9.3", this::findByIdRegion);
        methodsMenu.put("9.4", this::updateRegion);
        methodsMenu.put("9.5", this::deleteRegion);

        menu.put("10", "10 - Table: Sub Category");
        menu.put("10.1", "10.1 - Create for Sub Category");
        menu.put("10.2", "10.2 - Find all Sub Category");
        menu.put("10.3", "10.3 - Find by ID Sub Category");
        menu.put("10.4", "10.4 - Update Sub Category");
        menu.put("10.5", "10.5 - Delete Sub Category");
        methodsMenu.put("10.1", this::createSubCategory);
        methodsMenu.put("10.2", this::findAllSubCategory);
        methodsMenu.put("10.3", this::findByIdSubCategory);
        methodsMenu.put("10.4", this::updateSubCategory);
        methodsMenu.put("10.5", this::deleteSubCategory);

        menu.put("11", "11 - Table: User");
        menu.put("11.1", "11.1 - Create User");
        menu.put("11.2", "11.2 - Find all User");
        menu.put("11.3", "11.3 - Find by ID User");
        menu.put("11.4", "11.4 - Update User");
        menu.put("11.5", "11.5 - Delete User");
        methodsMenu.put("11.1", this::createUser);
        methodsMenu.put("11.2", this::findAllUser);
        methodsMenu.put("11.3", this::findByIdUser);
        methodsMenu.put("11.4", this::updateUser);
        methodsMenu.put("11.5", this::deleteUser);

        menu.put("12", "12 - Table: User card");
        menu.put("12.1", "12.1 - Create for User card");
        menu.put("12.2", "12.2 - Find all User card");
        menu.put("12.3", "12.3 - Find by ID User card");
        menu.put("12.4", "12.4 - Update User card");
        menu.put("12.5", "12.5 - Delete User card");
        methodsMenu.put("12.1", this::createUserCard);
        methodsMenu.put("12.2", this::findAllUserCard);
        methodsMenu.put("12.3", this::findByIdUserCard);
        methodsMenu.put("12.4", this::updateUserCard);
        methodsMenu.put("12.5", this::deleteUserCard);
    }

    private void printMenu() {
        System.out.println("MENU:");
        for (int i = 0; i < 13; i++) {
            if (menu.containsKey(String.valueOf(i))) {
                System.out.println(menu.get(String.valueOf(i)));
            }
        }
    }

    private void printSubMenu(String str) {
        System.out.println("SubMenu:");
        for (int i = 1; i <= 5; i++) {
            if (menu.containsKey(str + "." + i)) {
                System.out.println(menu.get(str + "." + i));
            }
        }
    }

    public final void show() throws SQLException {
        String keyMenu;
        Scanner scanner1 = new Scanner(System.in);
        do {
            printMenu();
            System.out.println("Select menu point");
            keyMenu = scanner1.nextLine();
            printSubMenu(keyMenu);
            keyMenu = scanner1.nextLine();
            methodsMenu.get(keyMenu).print();
        } while (!keyMenu.equals("Q"));
    }

    private void createCardBonus() throws SQLException {
        cardBonusController.create(inputCardBonus());
    }

    private void findAllCardBonus() throws SQLException {
        cardBonusController.findAll().forEach(x -> System.out.println(x));
    }

    private void findByIdCardBonus() throws SQLException {
        System.out.println("Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.println(cardBonusController.findById(id));
    }

    private void updateCardBonus() throws SQLException {
        System.out.println("Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        CardBonus cardBonus = inputCardBonus();
        cardBonus.setId(id);
        cardBonusController.update(cardBonus);

    }

    private void deleteCardBonus() throws SQLException {
        System.out.println("Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        cardBonusController.delete(id);
    }

    private CardBonus inputCardBonus() {
        System.out.println("Name:");
        String name = scanner.nextLine();
        System.out.println("Discount");
        Double discount = Double.parseDouble(scanner.nextLine());
        return new CardBonus(name, discount);
    }

    private void createCategory() throws SQLException {
        categoryController.create(inputCategory());
    }

    private void findAllCategory() throws SQLException {
        categoryController.findAll().forEach(x -> System.out.println(x));
    }

    private void findByIdCategory() throws SQLException {
        System.out.println("Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.println(categoryController.findById(id));
    }

    private void updateCategory() throws SQLException {
        System.out.println("Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        Category category = inputCategory();
        category.setId(id);
        categoryController.update(category);

    }

    private void deleteCategory() throws SQLException {
        System.out.println("Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        categoryController.delete(id);
    }

    private Category inputCategory() {
        System.out.println("Name:");
        String name = scanner.nextLine();
        return new Category(name);
    }

    private void createCity() throws SQLException {
        cityController.create(inputCity());
    }

    private void findAllCity() throws SQLException {
        cityController.findAll().forEach(x -> System.out.println(x));
    }

    private void findByIdCity() throws SQLException {
        System.out.println("Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.println(cityController.findById(id));
    }

    private void updateCity() throws SQLException {
        System.out.println("Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        City city = inputCity();
        city.setId(id);
        cityController.update(city);
    }

    private void deleteCity() throws SQLException {
        System.out.println("Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        cityController.delete(id);
    }

    private City inputCity() {
        System.out.println("Name:");
        String name = scanner.nextLine();
        System.out.println("Region:");
        Integer region = Integer.parseInt(scanner.nextLine());
        return new City(name, region);
    }

    private void createDelivery() throws SQLException {
        deliveryController.create(inputDelivery());
    }

    private void findAllDelivery() throws SQLException {
        deliveryController.findAll().forEach(x -> System.out.println(x));
    }

    private void findByIdDelivery() throws SQLException {
        System.out.println("Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.println(deliveryController.findById(id));
    }

    private void updateDelivery() throws SQLException {
        System.out.println("Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        Delivery delivery = inputDelivery();
        delivery.setId(id);
        deliveryController.update(delivery);

    }

    private void deleteDelivery() throws SQLException {
        System.out.println("Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        deliveryController.delete(id);
    }

    private Delivery inputDelivery() {
        System.out.println("Name:");
        String name = scanner.nextLine();
        return new Delivery(name);
    }

    private void createGender() throws SQLException {
        genderController.create(inputGender());
    }

    private void findAllGender() throws SQLException {
        genderController.findAll().forEach(x -> System.out.println(x));
    }

    private void findByIdGender() throws SQLException {
        System.out.println("Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.println(genderController.findById(id));
    }

    private void updateGender() throws SQLException {
        System.out.println("Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        Gender gender = inputGender();
        gender.setId(id);
        genderController.update(gender);

    }

    private void deleteGender() throws SQLException {
        System.out.println("Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        genderController.delete(id);
    }

    private Gender inputGender() {
        System.out.println("Gender:");
        String gender = scanner.nextLine();
        return new Gender(gender);
    }

    private void createItem() throws SQLException {
        itemController.create(inputItem());
    }

    private void findAllItem() throws SQLException {
        itemController.findAll().forEach(x -> System.out.println(x));
    }

    private void findByIdItem() throws SQLException {
        System.out.println("Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.println(itemController.findById(id));
    }

    private void updateItem() throws SQLException {
        System.out.println("Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        Item item = inputItem();
        item.setId(id);
        itemController.update(item);

    }

    private void deleteItem() throws SQLException {
        System.out.println("Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        itemController.delete(id);
    }

    private Item inputItem() {
        System.out.println("Name:");
        String name = scanner.nextLine();
        System.out.println("Description:");
        String description = scanner.nextLine();
        System.out.println("ImageUrl:");
        String imageUrl = scanner.nextLine();
        System.out.println("Brand:");
        String brand = scanner.nextLine();
        System.out.println("Model:");
        String model = scanner.nextLine();
        System.out.println("Configuration:");
        String configuration = scanner.nextLine();
        System.out.println("Price:");
        Double price = Double.parseDouble(scanner.nextLine());
        System.out.println("SubCategoryId:");
        Integer subCategoryId = Integer.parseInt(scanner.nextLine());
        return new Item(name, description, imageUrl, brand, model, configuration, price, subCategoryId);
    }

    private void createOrder() throws SQLException {
        orderController.create(inputOrder());
    }

    private void findAllOrder() throws SQLException {
        orderController.findAll().forEach(x -> System.out.println(x));
    }

    private void findByIdOrder() throws SQLException {
        System.out.println("Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.println(orderController.findById(id));
    }

    private void updateOrder() throws SQLException {
        System.out.println("Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        Order order = inputOrder();
        order.setId(id);
        orderController.update(order);

    }

    private void deleteOrder() throws SQLException {
        System.out.println("Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        orderController.delete(id);
    }

    private Order inputOrder() {
        System.out.println("userId:");
        Integer userId = Integer.parseInt(scanner.nextLine());
        System.out.println("time:");
        String time = scanner.nextLine();
        System.out.println("cityId:");
        Integer cityId = Integer.parseInt(scanner.nextLine());
        System.out.println("deliveryId:");
        Integer deliveryId = Integer.parseInt(scanner.nextLine());
        System.out.println("totalPrice:");
        Double totalPrice = Double.parseDouble(scanner.nextLine());
        System.out.println("orderStatus:");
        Integer orderStatus = Integer.parseInt(scanner.nextLine());
        return new Order(userId, time, cityId, deliveryId, totalPrice, orderStatus);
    }

    private void createOrderStatus() throws SQLException {
        orderStatusController.create(inputOrderStatus());
    }

    private void findAllOrderStatus() throws SQLException {
        orderStatusController.findAll().forEach(x -> System.out.println(x));
    }

    private void findByIdOrderStatus() throws SQLException {
        System.out.println("Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.println(orderStatusController.findById(id));
    }

    private void updateOrderStatus() throws SQLException {
        System.out.println("Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        OrderStatus orderStatus = inputOrderStatus();
        orderStatus.setId(id);
        orderStatusController.update(orderStatus);

    }

    private void deleteOrderStatus() throws SQLException {
        System.out.println("Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        orderStatusController.delete(id);
    }

    private OrderStatus inputOrderStatus() {
        System.out.println("Status:");
        String status = scanner.nextLine();
        return new OrderStatus(status);
    }

    private void createRegion() throws SQLException {
        regionController.create(inputRegion());
    }

    private void findAllRegion() throws SQLException {
        regionController.findAll().forEach(x -> System.out.println(x));
    }

    private void findByIdRegion() throws SQLException {
        System.out.println("Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.println(regionController.findById(id));
    }

    private void updateRegion() throws SQLException {
        System.out.println("Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        Region region = inputRegion();
        region.setId(id);
        regionController.update(region);

    }

    private void deleteRegion() throws SQLException {
        System.out.println("Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        regionController.delete(id);
    }

    private Region inputRegion() {
        System.out.println("Region:");
        String region = scanner.nextLine();
        return new Region(region);
    }

    private void createSubCategory() throws SQLException {
        subCategoryController.create(inputSubCategory());
    }

    private void findAllSubCategory() throws SQLException {
        subCategoryController.findAll().forEach(x -> System.out.println(x));
    }

    private void findByIdSubCategory() throws SQLException {
        System.out.println("Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.println(subCategoryController.findById(id));
    }

    private void updateSubCategory() throws SQLException {
        System.out.println("Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        SubCategory subCategory = inputSubCategory();
        subCategory.setId(id);
        subCategoryController.update(subCategory);

    }

    private void deleteSubCategory() throws SQLException {
        System.out.println("Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        subCategoryController.delete(id);
    }

    private SubCategory inputSubCategory() {
        System.out.println("Category id:");
        Integer categoryId = Integer.parseInt(scanner.nextLine());
        System.out.println("Name:");
        String name = scanner.nextLine();
        return new SubCategory(categoryId, name);
    }

    private void createUser() throws SQLException {
        userController.create(inputUser());
    }

    private void findAllUser() throws SQLException {
        userController.findAll().forEach(x -> System.out.println(x));
    }

    private void findByIdUser() throws SQLException {
        System.out.println("Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.println(userController.findById(id));
    }

    private void updateUser() throws SQLException {
        System.out.println("Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        User user = inputUser();
        user.setId(id);
        userController.update(user);

    }

    private void deleteUser() throws SQLException {
        System.out.println("Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        userController.delete(id);
    }

    private User inputUser() {
        System.out.println("name:");
        String name = scanner.nextLine();
        System.out.println("surname:");
        String surname = scanner.nextLine();
        System.out.println("birthday:");
        String birthday = scanner.nextLine();
        System.out.println("genderId:");
        Integer genderId = Integer.parseInt(scanner.nextLine());
        System.out.println("cityId:");
        Integer cityId = Integer.parseInt(scanner.nextLine());
        System.out.println("streetAddress:");
        String streetAddress = scanner.nextLine();
        System.out.println("zipCode:");
        String zipCode = scanner.nextLine();
        System.out.println("phone:");
        String phone = scanner.nextLine();
        System.out.println("email:");
        String email = scanner.nextLine();
        System.out.println("registredAt:");
        String registeredAt = scanner.nextLine();
        System.out.println("userCardId:");
        Integer userCardId = Integer.parseInt(scanner.nextLine());
        return new User(name, surname, birthday, genderId, cityId, streetAddress, zipCode, phone, email, registeredAt, userCardId);
    }

    private void createUserCard() throws SQLException {
        userCardController.create(inputUserCard());
    }

    private void findAllUserCard() throws SQLException {
        userCardController.findAll().forEach(x -> System.out.println(x));
    }

    private void findByIdUserCard() throws SQLException {
        System.out.println("Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.println(userCardController.findById(id));
    }

    private void updateUserCard() throws SQLException {
        System.out.println("Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        UserCard userCard = inputUserCard();
        userCard.setId(id);
        userCardController.update(userCard);

    }

    private void deleteUserCard() throws SQLException {
        System.out.println("Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        userCardController.delete(id);
    }

    private UserCard inputUserCard() {
        System.out.println("Name:");
        String name = scanner.nextLine();
        return new UserCard(name);
    }
}
