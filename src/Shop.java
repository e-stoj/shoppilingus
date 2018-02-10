import java.util.LinkedList;
import java.util.List;

public class Shop {
    private static int nextId = 0;

    public int id;
    public String name;
    private Location location;
    public List<ProductDetails> products;
    public List<String> type;
    public List<Service> services;
    public List<Employee> employees;

    public Shop(String name, int floor, int box, List<String> types) {
        this.id = nextId++;
        this.name = name;
        this.location = new Location(floor, box);
        this.type = types;
        this.products = new LinkedList<ProductDetails>();
        this.services = new LinkedList<Service>();
        this.employees = new LinkedList<Employee>();
    }

    public Shop(String name, int floor, int box) {
        this(name, floor, box, new LinkedList<String>());
    }

    public void addProduct(Product product, double quantity) {
        ProductDetails resultProduct = null;
        for (ProductDetails currentProduct : products) {
            if (currentProduct.product.id == product.id) {
                resultProduct = currentProduct;
            }
        }

        if (resultProduct != null) {
            resultProduct.quantity += quantity;
        } else {
            resultProduct = new ProductDetails(product, quantity);
            products.add(resultProduct);
        }
    }

    public Product getProduct(int id){
        for (ProductDetails current : products) {
            if (current.product.id == id) {
                return current.product;
            }
        }
        return null;
    }

    public ProductDetails findProductDetails(int id){
        for(ProductDetails productDetails : products){
            if(productDetails.product.id == id){
                return productDetails;
            }
        }
        return null;
    }

    public void updateProduct(int id, Product product){
        ProductDetails toModify = findProductDetails(id);
        deleteProduct(id);
        product.id = id;
        toModify.product = product;
    }

    public void deleteProduct(int id) {
        ProductDetails currentProduct = null;
        for (ProductDetails product : products) {
            currentProduct = product;
            if (currentProduct.product.id == id) {
                break;
            }
        }
        if(currentProduct != null){
            products.remove(currentProduct);
        }
    }

    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void fire(Employee employee) {
        employees.remove(employee);
    }

    public void addService(Service service) {
        services.add(service);
    }

    public Service getService(int id){
        for(Service service : services){
            if(service.id == id){
                return service;
            }
        }
        return null;
    }

    public void updateService(int id, Service modifiedService){
        deleteService(id);
        modifiedService.id = id;
        addService(modifiedService);
    }

    public void deleteService(int id) {
        for (Service service : services) {
            if (service.id == id) {
                services.remove(service);
            }
        }
    }

    public boolean isEmployeeAvilable(Employee employee) {
        for (Employee currentEmployee : employees) {
            if (currentEmployee.equals(employee)) {
                return currentEmployee.isAvailable;
            }
        }
        return false;
    }

    public boolean isProductAvailable(Product product) {
        for (ProductDetails currentProduct : products) {
            if (currentProduct.product.equals(product)) {
                return true;
            }
        }
        return false;
    }
}
