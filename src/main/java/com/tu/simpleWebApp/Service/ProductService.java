package com.tu.simpleWebApp.Service;
import java.util.Comparator;
import com.tu.simpleWebApp.Model.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import  java.util.List;
import java.time.LocalDate;
@Service
public class ProductService {

    List<Product> products = Arrays.asList(  new Product(101, "Iphone", 50000, "Dienthoai", 100, LocalDate.of(2025, 2, 19)),
            new Product(102, "MacBook", 30000, "Laptop", 50, LocalDate.of(2024, 12, 1)),
            new Product(103, "Samsung Galaxy", 40000, "Dienthoai", 80, LocalDate.of(2025, 1, 15)),
            new Product(104, "Dell XPS", 35000, "Laptop", 30, LocalDate.of(2024, 11, 20)),
            new Product(105, "Sony Xperia", 45000, "Dienthoai", 60, LocalDate.of(2024, 10, 10)),
            new Product(106, "HP Pavilion", 25000, "Laptop", 40, LocalDate.of(2024, 9, 5)),
            new Product(107, "Google Pixel", 48000, "Dienthoai", 70, LocalDate.of(2025, 2, 8)),
            new Product(108, "Xiaomi Redmi", 20000, "Dienthoai", 90, LocalDate.of(2024, 8, 25)),
            new Product(109, "Lenovo ThinkPad", 33000, "Laptop", 45, LocalDate.of(2024, 7, 15)),
            new Product(110, "OnePlus Nord", 32000, "Dienthoai", 85, LocalDate.of(2025, 2, 16)),
            new Product(111, "Asus ZenBook", 38000, "Laptop", 20, LocalDate.of(2024, 6, 12)));

    public List<Product> getProducts(){
        return products;
    }

    public List<Product> getProductsByCategory(String category) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                result.add(product);
            }
        }
        return result;
    }

    public List<Product> getProductsBanChay(int soLuongBan) {
        return products.stream()
                .sorted(Comparator.comparingInt(Product::getSoLuongBan).reversed()) // Sắp xếp giảm dần theo số lượng bán
                .limit(10) // Chỉ lấy 10 sản phẩm đầu tiên
                .toList(); // Chuyển về danh sách

    }

    public List<Product> getProducts7Day(LocalDate dateCreate) {
        LocalDate now = LocalDate.now();
        LocalDate sevenDaysAgo = now.minusDays(7);

        return products.stream()
                .filter(p -> !p.getDateCreate().isBefore(sevenDaysAgo)) // Ngày tạo >= 7 ngày trước
                .limit(10) // Lấy tối đa 10 sản phẩm
                .toList();

    }
}
