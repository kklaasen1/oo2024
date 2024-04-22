package ee.tlu.salat.controller;

import ee.tlu.salat.model.Omniva;
import ee.tlu.salat.model.Post;
import ee.tlu.salat.model.nordpool.Activity;
import ee.tlu.salat.model.nordpool.Nordpool;
import ee.tlu.salat.model.nordpool.TimestampPrice;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RestTemplateController {

    @GetMapping("saa-postitused")
    public List<Post> getPosts() {

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/posts";
        ResponseEntity<Post[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Post[].class);
        return List.of(response.getBody());
    }

    @GetMapping("saa-postitused/{kasutajaId}")
    public List<Post> getUserPosts(@PathVariable int kasutajaId) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/posts";
        ResponseEntity<Post[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Post[].class);

        List<Post> kasutajaPostitused = new ArrayList<>();
        for (Post p : response.getBody()) {
            if (p.getUserId() == kasutajaId) {
                kasutajaPostitused.add(p);
            }
        }

        return kasutajaPostitused;
    }

    @GetMapping("omniva")
    public List<Omniva> getOmnivaPMs() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.omniva.ee/locations.json";
        ResponseEntity<Omniva[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Omniva[].class);
        return List.of(response.getBody());
    }
    @GetMapping("omniva/{country}")
    public List<Omniva> getOmnivaPMsByCountry(@PathVariable String country) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.omniva.ee/locations.json";
        ResponseEntity<Omniva[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Omniva[].class);

        List<Omniva> omnivaPakiautomaadid = new ArrayList<>();
        for (Omniva o : response.getBody()) {
            if (o.getA0_NAME().equals(country)) {
                omnivaPakiautomaadid.add(o);
            }
        }

        return omnivaPakiautomaadid;
    }

    @GetMapping("saa-nordpooli-hinnad")
    public Nordpool getNordpooliHinnad() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://dashboard.elering.ee/api/nps/price";
        ResponseEntity<Nordpool> response = restTemplate.exchange(url, HttpMethod.GET, null, Nordpool.class);
        return response.getBody();
    }
    @GetMapping("saa-nordpooli-hinnad/{country}")
    public List<TimestampPrice> getNordpooliHinnadByCountry(@PathVariable String country) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://dashboard.elering.ee/api/nps/price";
        ResponseEntity<Nordpool> response = restTemplate.exchange(url, HttpMethod.GET, null, Nordpool.class);

        List<TimestampPrice> timestampPrices = new ArrayList<>();
        if (country.equals("ee")) {
            timestampPrices = response.getBody().getData().getEe();
        } else if (country.equals("fi")) {
            timestampPrices = response.getBody().getData().getFi();
        } else if (country.equals("lv")) {
            timestampPrices = response.getBody().getData().getLv();
        } else if (country.equals("lt")) {
            timestampPrices = response.getBody().getData().getLt();
        }

        return timestampPrices;
    }


    @GetMapping("saa-tegevus")
    public Activity getRandomActivity() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.boredapi.com/api/activity";
        ResponseEntity<Activity> response = restTemplate.exchange(url, HttpMethod.GET, null, Activity.class);
        return response.getBody();
    }

    @GetMapping("saa-tegevus/{type}")
    public Activity getRandomActivityByType() {
        RestTemplate restTemplate = new RestTemplate();
        Activity activity = null;
        String url = "https://www.boredapi.com/api/activity";
        while (true) {
            // Make the API request to fetch a random activity
            ResponseEntity<Activity> response = restTemplate.exchange(url, HttpMethod.GET, null, Activity.class);
            activity = response.getBody();

            // Check if the activity type is "cooking"
            if (activity != null && "cooking".equalsIgnoreCase(activity.getType())) {
                // Activity matches the type "cooking"
                return activity;
            }
        }
    }

    @GetMapping("saa-tegevus/koos-teistega")
    public Activity getRandomActivityWithMoreThanOneParticipant() {
        RestTemplate restTemplate = new RestTemplate();
        Activity activity = null;
        String url = "https://www.boredapi.com/api/activity";

        while (true) {
            // Make the API request to fetch a random activity
            ResponseEntity<Activity> response = restTemplate.exchange(url, HttpMethod.GET, null, Activity.class);
            activity = response.getBody();

            // Check if the activity has more than one participant
            if (activity != null && activity.getParticipants() > 1) {
                // Activity matches the criteria of more than one participant
                return activity;
            }
        }
    }
}
