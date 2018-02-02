import java.util.List;

public class Shop {
    private String name;
    private String address;
    List<ProductDetails> products;
    String[] type;
    List<Service> services;
    List<Employee> employees;

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

    void buyProduct(Product product){

    }

}
