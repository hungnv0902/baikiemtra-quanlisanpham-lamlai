import java.util.ArrayList;

public interface ProductManager<E> {
    int addProduct(E e);

    boolean editProduct(E e);

    boolean removeProduct(int id);

    Product searchProduct(int id);

    ArrayList<E> displayProduct();

    void sortProduct();
}
