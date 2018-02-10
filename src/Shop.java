import java.util.LinkedList;
import java.util.List;

public class Shop {
    private static int nextId = 0;

    public int id;
    public String name;
    private Location location;
    private List<ProductDetails> products;
    private List<String> type;
    private List<Service> services;
    private List<Employee> employees;

    public Shop(String name, int floor, int box, List<String> types){
        this.id = nextId++;
        this.name = name;
        this.location = new Location(floor, box);
        this.type = types;
        this.products = new LinkedList<ProductDetails>();
        this.services = new LinkedList<Service>();
        this.employees = new LinkedList<Employee>();
    }

    public Shop(String name, int floor, int box){
        this(name, floor, box, new LinkedList<String>());
    }

    void addProduct(Product product, double qualitity){
        ProductDetails currentProduct = null;
        for(int i = 0; i < products.size(); i++){
            currentProduct = products.get(i);
            if(currentProduct.product.name.equals(product.name)){
                break;
            }
        }

        if(currentProduct != null){
            currentProduct.qualitity += qualitity;
        } else {
            currentProduct = new ProductDetails(product, qualitity);
            products.add(currentProduct);
        }
    }

    void hire(Employee employee){
        employees.add(employee);
    }

    void fire(Employee employee){
        employees.remove(employee);
    }

    boolean isEmployeeAvilable(Employee employee){
        for(int i = 0; i < employees.size(); i++){
            Employee currentEmployee = employees.get(i);
            if(currentEmployee.equals(employee)){
                if(currentEmployee.isAvailable) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    boolean isProductAvailable(Product product){
        for(int i = 0; i < products.size(); i++){
            ProductDetails currentProduct = products.get(i);
            if(currentProduct.product.equals(product)){
                return true;
            }
        }
        return false;
    }

}
