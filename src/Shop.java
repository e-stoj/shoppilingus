import types.ShopTypes;

import java.util.LinkedList;
import java.util.List;

public class Shop {
    private static int nextId = 0;

    private int id;
    private String name;
    private Location location;
    private List<ProductDetails> products;
    private List<ShopTypes> type;
    private List<Service> services;
    private List<Employee> employees;

    public Shop(String name, int floor, int box, List<ShopTypes> types) {
        this.id = nextId++;
        this.name = name;
        this.location = new Location(floor, box);
        this.type = types;
        this.products = new LinkedList<ProductDetails>();
        this.services = new LinkedList<Service>();
        this.employees = new LinkedList<Employee>();
    }

    public Shop(String name, int floor, int box) {
        this(name, floor, box, new LinkedList<ShopTypes>());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public List<ProductDetails> getProducts() {
        return products;
    }

    public List<ShopTypes> getType() {
        return type;
    }

    public List<Service> getServices() {
        return services;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addProduct(Product product, double quantity) {
        ProductDetails resultProduct = findProductDetails(product.getId());
        if (resultProduct != null) {
            resultProduct.setQuantity(resultProduct.getQuantity() + quantity);
        } else {
            resultProduct = new ProductDetails(product, quantity);
            products.add(resultProduct);
        }
    }

    public Product getProduct(int id) {
        ProductDetails current = findProductDetails(id);
        if (current != null) {
            return current.getProduct();
        }
        return null;
    }

    public ProductDetails findProductDetails(int id) {
        for (ProductDetails productDetails : products) {
            if (productDetails.getProduct().getId() == id) {
                return productDetails;
            }
        }
        return null;
    }

    public void updateProduct(int id, Product product) {
        ProductDetails toModify = findProductDetails(id);
        if (toModify != null) {
            deleteProduct(id);
            product.setId(id);
            toModify.setProduct(product);
        }
    }

    public void deleteProduct(int id) {
        ProductDetails currentProduct = findProductDetails(id);
        if (currentProduct != null) {
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

    public Service getService(int id) {
        for (Service service : services) {
            if (service.getId() == id) {
                return service;
            }
        }
        return null;
    }

    public void updateService(int id, Service modifiedService) {
        if (getService(id) != null) {
            deleteService(id);
            modifiedService.setId(id);
            addService(modifiedService);
        }
    }

    public void deleteService(int id) {
        Service service = getService(id);
        if (service != null) {
            services.remove(service);
        }

    }

    public boolean isEmployeeAvilable(Employee employee) {
        for (Employee currentEmployee : employees) {
            if (currentEmployee.equals(employee)) {
                return currentEmployee.isAvailable();
            }
        }
        return false;
    }

    public boolean isProductAvailable(Product product) {
        for (ProductDetails currentProduct : products) {
            if (currentProduct.getProduct().equals(product)) {
                if (currentProduct.getQuantity() > 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
