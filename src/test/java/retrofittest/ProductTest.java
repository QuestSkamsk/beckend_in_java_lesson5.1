package retrofittest;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import retrofit.DTO.Product;
import retrofit.Enums.CategoryType;
import retrofit.RestApi.CategoryService;
import retrofit.RestApi.ProductService;
import retrofit.Utils.RetrofitUtils;
import retrofit2.Retrofit;
import java.io.IOException;

public class ProductTest {

    static Retrofit client;
    static ProductService productService;
    static CategoryService categoryService;
    Faker faker = new Faker();
    Product product;

    @BeforeAll
    static void beforeAll() {
        client = RetrofitUtils.getRetrofit();
        productService = client.create(ProductService.class);
        categoryService = client.create(CategoryService.class);
    }
    @BeforeEach
    void setUp() throws IOException {
        product = new Product()
                .withTitle(faker.book().author())
                .withPrice((int) ((Math.random() + 1) * 100))
                .withCategoryTitle(CategoryType.FURNITURE.getTitle());
    }

}

