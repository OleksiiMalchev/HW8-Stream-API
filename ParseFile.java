import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ParseFile {
    private BufferedReader br;

    public ParseFile(String pathToFile) {
        try {
            this.br = new BufferedReader(new FileReader(pathToFile));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> productsList() {
        return br.lines()
                .skip(1)
                .map(k -> Arrays.asList(k.split(",")))
                .map(k -> toProduct(k))
                .collect(toList());
    }

    private static Product toProduct(List<String> row) {
        LocalDate date = LocalDate.parse(row.get(4));
        return new Product(Integer.parseInt(row.get(0)), row.get(1), Double.parseDouble(row.get(2)), Boolean.parseBoolean(row.get(3)), date);
    }
}
