package domain;

import repository.*;

import javax.naming.NameAlreadyBoundException;
import javax.xml.registry.DeleteException;
import java.util.Collection;
import java.util.Set;

/**
 * The type Product manager.
 */
public class ProductManager {

    private IProductDao productRepo;
    private IIngredientDao ingredientRepo;
    private IAllergenDao allergenRepo;

    /**
     * Instantiates a new Product manager.
     */
    ProductManager() {
        productRepo = new ProductDao();
        ingredientRepo = new IngredientDao();
        allergenRepo = new AllergenDao();
    }

    /**
     * Creates product in the database.
     *
     * @param name        the name
     * @param description the description (can be null)
     * @param ingredients the ingredients
     */
    public void createProduct(String name, String description, Set<Ingredient> ingredients) throws NameAlreadyBoundException {
        Product product = new Product(name.trim(), ingredients);
        if (!description.isEmpty()) {
            product.setDescription(description);
        }
        insertItem(product);
    }

    /**
     * Duplicates product from the database.
     *
     * @param product the product
     */
    public void duplicateProduct(Product product) throws NameAlreadyBoundException {
        Product duplicate = new Product();
        duplicate.setName(product.getName() + "_copy");
        duplicate.setIngredients(product.getIngredients());
        if (!product.getDescription().isEmpty())
            duplicate.setDescription(product.getDescription());
        insertItem(product);
    }

    /**
     * Removes product from the database.
     *
     * @param product the product
     */
    public void removeProduct(Product product) {
        deleteItem(product);
    }

    /**
     * Alters product in the database.
     *
     * @param oldName     the old name
     * @param newName     the new name
     * @param ingredients the ingredients
     * @param description the description
     */
    public void alterProduct(String oldName, String newName, String description, Set<Ingredient> ingredients) throws NameAlreadyBoundException {
        Product product = getProductByName(oldName);
        product.setName(newName.trim());
        if (!description.isEmpty())
            product.setDescription(description);
        product.setIngredients(ingredients);
        updateItem(oldName, product);
    }

    /**
     * Gets product by name from the database.
     *
     * @param name the name
     * @return the product by name
     */
    public Product getProductByName(String name) {
        return (Product) getItemByName("Product", name);
    }

    /**
     * Gets all products from the database.
     *
     * @return the products
     */
    public Collection<Product> getProducts() {
        GenericDao.startTransaction();
        Collection<Product> products = productRepo.findAll();
        GenericDao.commitTransaction();
        return products;
    }

    /**
     * Creates ingredient in the database.
     *
     * @param name     the name
     * @param allergen the allergen
     */
    public void createIngredient(String name, Allergen allergen) throws NameAlreadyBoundException {
        Ingredient ingredient = new Ingredient(name, allergen);
        insertItem(ingredient);
    }

    /**
     * Duplicates ingredient from the database.
     *
     * @param ingredient the ingredient
     */
    public void duplicateIngredient(Ingredient ingredient) throws NameAlreadyBoundException {
        Ingredient duplicate = new Ingredient();
        duplicate.setName(ingredient.getName() + "_copy");
        duplicate.setAllergen(ingredient.getAllergen());
        insertItem(duplicate);
    }

    /**
     * Removes ingredient from the database.
     *
     * @param ingredient the ingredient
     * @throws DeleteException if the ingredient is still being used in a product.
     */
    public void removeIngredient(Ingredient ingredient) throws DeleteException {
        for (Product product : getProducts()) {
            if (product.getIngredients().contains(ingredient))
                throw new DeleteException();
        }
        deleteItem(ingredient);
    }

    /**
     * Alters ingredient from the database.
     *
     * @param oldName  the old name
     * @param newName  the new name
     * @param allergen the allergen
     */
    public void alterIngredient(String oldName, String newName, Allergen allergen) throws NameAlreadyBoundException {
        Ingredient ingredient = getIngredientByName(oldName);
        ingredient.setName(newName.trim());
        ingredient.setAllergen(allergen);
        updateItem(oldName, ingredient);
    }

    /**
     * Gets ingredient by name from the database.
     *
     * @param name the name
     * @return the ingredient by name
     */
    public Ingredient getIngredientByName(String name) {
        return (Ingredient) getItemByName("Ingredient", name);
    }

    /**
     * Gets all ingredients from the database.
     *
     * @return the ingredients
     */
    public Collection<Ingredient> getIngredients() {
        GenericDao.startTransaction();
        Collection<Ingredient> ingredients = ingredientRepo.findAll();
        GenericDao.commitTransaction();
        return ingredients;
    }

    /**
     * Gets allergen by name from the database.
     *
     * @param name the name
     * @return the allergen by name
     */
    public Allergen getAllergenByName(String name) {
        return (Allergen) getItemByName("Allergen", name);
    }

    /**
     * Gets all allergens from the database.
     *
     * @return the allergens
     */
    public Collection<Allergen> getAllergens() {
        GenericDao.startTransaction();
        Collection<Allergen> allergens = allergenRepo.findAll();
        GenericDao.commitTransaction();
        return allergens;
    }

    // Tries to insertItem the item (depending on the kind of item), rolls back if an exception is thrown.
    private void insertItem(Object item) throws NameAlreadyBoundException {
        try {
            GenericDao.startTransaction();
            if (item instanceof Product)
                productRepo.insert((Product) item);
            if (item instanceof Ingredient)
                ingredientRepo.insert((Ingredient) item);
            GenericDao.commitTransaction();
        } catch (Exception e) {
            GenericDao.rollbackTransaction();
            throw e;
        }
    }

    // Tries to updateItem an item (depending on the kind of item), rolls back if an exception is thrown.
    private void updateItem(String oldName, Object item) throws NameAlreadyBoundException {
        try {
            GenericDao.startTransaction();
            if (item instanceof Product)
                productRepo.update((Product) item, oldName);
            if (item instanceof Ingredient)
                ingredientRepo.update((Ingredient) item, oldName);
            GenericDao.commitTransaction();
        } catch (Exception e) {
            GenericDao.rollbackTransaction();
            throw e;
        }
    }

    // Tries to get an item by name (depending on the kind of item), rolls back if an exception is thrown.
    private Object getItemByName(String type, String name) {
        Object item = new Object();
        try {
            GenericDao.startTransaction();
            switch (type) {
                case "Product":
                    item = productRepo.getProductByName(name);
                    break;
                case "Ingredient":
                    item = ingredientRepo.getIngredientByName(name);
                    break;
                case "Allergen":
                    item = allergenRepo.getAllergenByName(name);
                    break;
            }
            GenericDao.commitTransaction();
            return item;
        } catch (Exception e) {
            GenericDao.rollbackTransaction();
            throw e;
        }
    }

    // Tries to delete an item (depending on the kind of item), rolls back if an exception is thrown.
    private void deleteItem(Object item) {
        try {
            GenericDao.startTransaction();
            if (item instanceof Product)
                productRepo.delete((Product) item);
            if (item instanceof Ingredient)
                ingredientRepo.delete((Ingredient) item);
            GenericDao.commitTransaction();
        } catch (Exception e) {
            GenericDao.rollbackTransaction();
            throw e;
        }
    }

}
