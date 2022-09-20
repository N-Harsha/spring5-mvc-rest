package guru.springfamework.bootstrap;

import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import guru.springfamework.domain.Vendor;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.repositories.CustomerRepository;
import guru.springfamework.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrap implements CommandLineRunner {
    CategoryRepository categoryRepository;
    CustomerRepository customerRepository;
    VendorRepository vendorRepository;

    public BootStrap(CategoryRepository categoryRepository,CustomerRepository customerRepository,VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCategories();
        loadCustomers();
        loadVendors();

    }

    private void loadVendors() {
        Vendor v1=Vendor.builder().name("Western Tasty Fruits Ltd.").build();
        Vendor v2=Vendor.builder().name("Exotic Fruits Company").build();
        Vendor v3=Vendor.builder().name("Home Fruits").build();
        Vendor v4=Vendor.builder().name("Fun Fresh Fruits Ltd.").build();
        Vendor v5=Vendor.builder().name( "Nuts for Nuts Company").build();
        Vendor v6=Vendor.builder().name("Cream Fruits .Co").build();

        vendorRepository.save(v1);
        vendorRepository.save(v2);
        vendorRepository.save(v3);
        vendorRepository.save(v4);
        vendorRepository.save(v5);
        vendorRepository.save(v6);

        System.out.println("Total Vendors saved : "+vendorRepository.findAll().size());

    }

    private void loadCustomers() {
        Customer c1=Customer.builder().firstName("Harsha").lastName("Nimmala").build();
        Customer c2=Customer.builder().firstName("Sam").lastName("Jackson").build();
        Customer c3=Customer.builder().firstName("John").lastName("Snow").build();
        Customer c4=Customer.builder().firstName("Daenerys").lastName("Targaryen").build();
        Customer c5=Customer.builder().firstName("Tyrion").lastName("Lanister").build();
        customerRepository.save(c1);
        customerRepository.save(c2);
        customerRepository.save(c3);
        customerRepository.save(c4);
        customerRepository.save(c5);
        System.out.println("Total customers saved : "+customerRepository.findAll().size());
    }


    private void loadCategories() {
        Category fruit = new Category();
        fruit.setName("Fruit");
        Category dired = new Category();
        dired.setName("Dried");
        Category fresh = new Category();
        fresh.setName("Fresh");
        Category nuts = new Category();
        nuts.setName("Nuts");
        Category exotic = new Category();
        exotic.setName("Exotic");

        categoryRepository.save(fruit);
        categoryRepository.save(dired);
        categoryRepository.save(fresh);
        categoryRepository.save(nuts);
        categoryRepository.save(exotic);

        System.out.println("Total saved Categories are : "+ categoryRepository.findAll().size());
    }
}
