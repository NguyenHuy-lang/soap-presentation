package io.spring.guides.credit.endPoint;//package io.spring.guides.gs_producing_web_service.endPoint;

import io.spring.guides.credit.GetCreditRequest;
import io.spring.guides.credit.GetCreditResponse;
import io.spring.guides.credit.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Endpoint
public class CreditEndpoint {

    private static final String NAMESPACE_URI = "http://spring.io/guides/credit";
    private CreditRepository orderRepository;

    @Autowired
    public CreditEndpoint(CreditRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCreditRequest")
    @ResponsePayload
    public GetCreditResponse getOrderResponse(@RequestPayload GetCreditRequest request) throws ParseException {
        GetCreditResponse response = new GetCreditResponse();
        response.setStatus(orderRepository
                .checkValidCredit(
                        request.getCreditName(),
                        request.getCreditType(),request.getCreditNum(), request.getCreditCvc(),
                        stringToDate(request.getCreditExpire()), request.getCreditAmountTransfer()
                        ));
        return response;
    }
    public static Date stringToDate(String dateString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.parse(dateString);
    }

}