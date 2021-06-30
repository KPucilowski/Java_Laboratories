package pl.puci.owski.springbootsoap;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pl.puci.owski.springbootsoap.mypackage.GetKlient;
import pl.puci.owski.springbootsoap.mypackage.GetResponse;
import pl.puci.owski.springbootsoap.mypackage.Klient;
import pl.puci.owski.springbootsoap.mypackage.KlientService;

@Endpoint
public class KlientEndpoint {
    private KlientService klientService;

    public KlientEndpoint(KlientService klientService) {
        this.klientService = klientService;
    }

    @PayloadRoot(namespace = "http://pucilowski.pl/soap-example",localPart = "getKlient")
    @ResponsePayload
    public GetResponse getKlientById(@RequestPayload GetKlient getKlient){
        Klient klientById = klientService.getKlientById(getKlient.getId());
        GetResponse getResponse = new GetResponse();
        getResponse.setKlient(klientById);
        return getResponse;
    }
}
