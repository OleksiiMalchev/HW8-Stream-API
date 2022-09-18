import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class ProductManager {
    public List<Product> getProductByTypeAndPrise(List<Product> products) {
        return products.stream()
                .filter(p -> p.getType().equals("Paper A4") && p.getPrice() > 250)
                .collect(Collectors.toList());
    }

    public List<Product> getProductByTypeAndPriseWithDiscount(List<Product> products) {
        return products.stream()
                .filter(p -> p.getType().equals("Paper A4"))
                .filter(Product::isDiscount)
                .peek(p -> p.setPrice(p.getPrice() * 0.9))
                .collect(Collectors.toList());
    }

    public Product lowPriceByType(List<Product> products) {

        return products.stream()
                .filter(p -> p.getType().equals("Book"))
                .min(Comparator.comparing(p -> p.getPrice()))
                .orElseThrow(() -> new NoSuchElementException("Product[Book] not found"));

    }

    public List<Product> getProductByDate(List<Product> products) {
        return products.stream()
                .sorted((p1, p2) -> p2.getDate().compareTo(p1.getDate()))
                .limit(3)
                .collect(Collectors.toList());
    }

    public double getSumPriceYear(List<Product> products) {
        return products.stream()
                .filter(p -> p.getDate().getYear() == 2022)
                .filter(p -> p.getType().equals("Paper A4"))
                .filter(p -> p.getPrice() < 75)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public Map<String, List<Product>> groupByType(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }
}