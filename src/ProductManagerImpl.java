import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProductManagerImpl implements ProductManager<Product> {
    ArrayList<Product> listProducts = new ArrayList<>();

    public ProductManagerImpl() {
    }

    @Override
    public int addProduct(Product product) {
        for (Product products: listProducts) {
            if (products.getId() == product.getId()) {
                return -1;
            } else {
                if (products.getName().equals(product.getName()) && products.getDescription().equals(product.getDescription()) && products.getPrice() == product.getPrice()) {
                    return 0;
                }
            }
        }

        listProducts.add(product);
        return 1;
    }

    @Override
    public boolean editProduct(Product product) {
        for (Product products: listProducts) {
            if(products.getId() == product.getId()) {
                products.setName(product.getName());
                products.setDescription(product.getDescription());
                products.setPrice(product.getPrice());
                products.setStatus(product.isStatus());
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean removeProduct(int id) {
        for (Product products: listProducts) {
            if(products.getId() == id) {
                listProducts.remove(products);
                return true;
            }
        }
        return false;
    }

    @Override
    public Product searchProduct(int id) {
        for (Product products: listProducts) {
            if(products.getId() == id) {
                return products;
            }
        }
        return null;
    }

    @Override
    public ArrayList displayProduct() {
        return listProducts;
    }

    @Override
    public void sortProduct() {
        Collections.sort(listProducts, new Comparator<Product>() {
            @Override
            public int compare(Product product1, Product product2) {
                if(product1.getPrice() < product2.getPrice()) {
                    return -1;
                } else if (product1.getPrice() == product2.getPrice()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

    }

}
