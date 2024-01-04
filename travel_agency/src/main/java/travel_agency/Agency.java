package travel_agency;


import com.google.gson.Gson;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import service.core.ClientApplication;
import service.core.Order_info;
import service.core.User_Info;

import java.io.IOException;
import java.net.*;
import java.util.*;

@RestController
public class Agency {
    private Map<Integer, ClientApplication> clientApplicationHashMap = new HashMap<>();
    static int appID = 0;

    @RequestMapping(value="/applications", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String makeCake(@RequestBody User_Info userInfo) throws URISyntaxException, IOException, MalformedURLException {

        //just for checking if received cakeSpec is correct
//        System.out.println(userInfo.getCakeType());
//        System.out.println(userInfo.getCounty());

        List<URL> cakeService = new LinkedList<>();
        List<Order_info> returnedCakeInvoice = new ArrayList<>();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<User_Info> request = new HttpEntity<>(userInfo);

        //init URLs
        cakeService.add(new URL("http://localhost:8080/order"));
//        cakeService.add(new URL("http://localhost:8083/dcake"));
//        cakeService.add(new URL("http://localhost:8082/bcake"));

        //post data to URIs
        for (URL cakeServiceUrl : cakeService) {
            HttpURLConnection serviceURLConnection = null;
            try {
                //open connection
                serviceURLConnection = (HttpURLConnection) cakeServiceUrl.openConnection();
                System.out.println(" RESPONSE CODE = " + serviceURLConnection.getResponseCode());

                //the response code for running services are 405 although they are running fine. Hence the comparison against HTTP_BAD_METHOD
                if (serviceURLConnection.getResponseCode() == HttpURLConnection.HTTP_BAD_METHOD) {
                    returnedCakeInvoice.add(restTemplate.postForObject(cakeServiceUrl.toString(),
                            request, Order_info.class));
                } else if (serviceURLConnection.getResponseCode() != HttpURLConnection.HTTP_BAD_METHOD) {
                    System.out.println(cakeServiceUrl.toString() + "Connection refused");
                }
                else {
                    System.out.println("This service is available but can't be used here.");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        for (Order_info invoice : returnedCakeInvoice){
            System.out.println("service: " + invoice.getCompany());
        }

        ClientApplication clientApplication = new ClientApplication(appID, userInfo, returnedCakeInvoice);
//        System.out.println("1 costs: " + clientApplication.cakeInvoices().get(0).getPrice());
//        System.out.println("2 costs: " + clientApplication.cakeInvoices().get(1).getPrice());
//        System.out.println("3 costs: " + clientApplication.cakeInvoices().get(2).getPrice());

        String path = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString()+ "/applications/" + appID;
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(new URI(path));

        clientApplicationHashMap.put(appID,clientApplication);
        appID++;

        //using Gson here as there was a serialization issue with any form of a list with Json.
        //Which resulted the response failed to get any returned invoices.
        return new Gson().toJson(clientApplication);
    }

    @RequestMapping(value="/applications/{id}",method= RequestMethod.GET)
    public ClientApplication getApplication(@PathVariable int id){
        return clientApplicationHashMap.get(id);
    }

    @RequestMapping(value="/applications",method= RequestMethod.GET)
    public List<ClientApplication> getApplications(){
        return new ArrayList<>(clientApplicationHashMap.values());
    }

}
