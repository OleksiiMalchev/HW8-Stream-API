import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException {
        ParseFile parseFile = new ParseFile("src\\ProductOfOfficeShop.CVS");
        List<Product> products = parseFile.productsList();
        ProductManager productManager = new ProductManager();
        List<Product> productByTypeAndPrise = productManager.getProductByTypeAndPrise(products);
        System.out.println(productByTypeAndPrise);
        List<Product> productByTypeAndPriseWithDiscount = productManager.getProductByTypeAndPriseWithDiscount(products);
        System.out.println(productByTypeAndPriseWithDiscount);
        Product lowPriceByType = productManager.lowPriceByType(products);
        System.out.println(lowPriceByType);
        List<Product> productByDate = productManager.getProductByDate(products);
        System.out.println(productByDate);
        double sumPriceYear = productManager.getSumPriceYear(products);
        System.out.println(sumPriceYear);
        Map<String, List<Product>> stringListMap = productManager.groupByType(products);
        System.out.println(stringListMap);
    }
}