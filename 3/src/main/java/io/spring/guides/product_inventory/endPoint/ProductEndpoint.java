package io.spring.guides.product_inventory.endPoint;
import io.spring.guides.product_inventory.GetProductRequest;
import io.spring.guides.product_inventory.GetProductResponse;
import io.spring.guides.product_inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class ProductEndpoint{
    private static final String NAMESPACE_URI = "http://spring.io/guides/product-inventory";


    private ProductRepository productRepository;

    @Autowired
    public ProductEndpoint(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductRequest")
    @ResponsePayload
    public GetProductResponse getProductResponse(@RequestPayload GetProductRequest request) {
        GetProductResponse response = new GetProductResponse();
        response.setStatus(String.valueOf(productRepository
                .checkQuantityInventory(request.getNameProduct(), request.getQuantity())));
        return response;
    }
}