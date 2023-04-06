package io.spring.guides.gs_producing_web_service.endPoint;

import io.spring.guides.gs_producing_web_service.GetOrderRequest;
import io.spring.guides.gs_producing_web_service.GetOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import io.spring.guides.gs_producing_web_service.repository.OrderRepository;

@Endpoint
public class CountryEndpoint {

    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
    private OrderRepository orderRepository;

    @Autowired
    public CountryEndpoint(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOrderRequest")
    @ResponsePayload
    public GetOrderResponse getOrderResponse(@RequestPayload GetOrderRequest request) {
        GetOrderResponse response = new GetOrderResponse();
        response.setStatus(orderRepository
                .findOrderByOrderNumberAndCompanyId(request.getOrderNumber(), request.getCompanyId()));
        return response;
    }

//    @CrossOrigin(origins = "*")
//    @PostMapping(path = "/getOrder", consumes = "application/soap+xml", produces = "application/soap+xml")
//    @ResponsePayload
//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOrderRequest")
//    public GetOrderResponse getOrder(@RequestBody GetOrderRequest request) {
//        return getOrderResponse(request);
//    }
}