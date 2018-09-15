package hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
public class VirusTotalController {
    @Value("${virusTotalUri}")
    private String uri;

    @Value("${apiKey}")
    private String apiKey;

    @RequestMapping("/file/reports")
    public String getFileReports(@RequestParam("fileDigest") String fileHash) {

        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri + "file/report")
                .queryParam("apikey", apiKey)
                .queryParam("resource", fileHash);

        String result = restTemplate.getForObject(builder.toUriString(), String.class);
        return result;
    }


    @RequestMapping("/file/report")
    public FullFileReport getFileReport(@RequestParam("fileDigest") String fileHash) {

        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri + "file/report")
                .queryParam("apikey", apiKey)
                .queryParam("resource", fileHash);

        FullFileReport fileReport = restTemplate.getForObject(builder.toUriString(), FullFileReport.class);


        return fileReport;
    }

    @RequestMapping("/file/behaviour")
    public String getFileBehaviour(@RequestParam("fileDigest") String fileHash) {

        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri + "file/behaviour")
                .queryParam("apikey", apiKey)
                .queryParam("hash", fileHash);

        String result = restTemplate.getForObject(builder.toUriString(), String.class);
        return result;
    }

    @RequestMapping("/url/reports")
    public String getUrlReports(@RequestParam("url") String url) {

        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri + "url/report")
                .queryParam("apikey", apiKey)
                .queryParam("resource", url);

        String result = restTemplate.getForObject(builder.toUriString(), String.class);
        return result;
    }

    @RequestMapping("/url/report")
    public FullFileReport getUrlReport(@RequestParam("url") String url) {

        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri + "url/report")
                .queryParam("apikey", apiKey)
                .queryParam("resource", url);

        FullFileReport result = restTemplate.getForObject(builder.toUriString(), FullFileReport.class);
        return result;
    }


    @RequestMapping(value = "/url/scan", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)

    public String scanUrl(@RequestBody VirusTotalUrl url) {

        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri + "url/scan")
                .queryParam("apikey", apiKey)
                .queryParam("url", url.getUrl());

        String result = restTemplate.postForObject(builder.toUriString(), null, String.class);
        return result;
    }

    @RequestMapping("/domain/report")

    public String getDomainReport(@RequestParam("domain") String domain) {

        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri + "domain/report")
                .queryParam("apikey", apiKey)
                .queryParam("domain", domain);

        String result = restTemplate.getForObject(builder.toUriString(), String.class);
        return result;
    }

    @RequestMapping("/ip-address/report")
    public String getIpAddressReport(@RequestParam("ipAddress") String ipAddress) {

        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri + "ip-address/report")
                .queryParam("apikey", apiKey)
                .queryParam("ip", ipAddress);

        String result = restTemplate.getForObject(builder.toUriString(), String.class);
        return result;
    }

    @RequestMapping("/comments/get")
    public String getComments(@RequestParam("fileDigest") String fileHash) {

        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri + "/comments/get")
                .queryParam("apikey", apiKey)
                .queryParam("resource", fileHash);


        String result = restTemplate.getForObject(builder.toUriString(), String.class);
        if (result != null) {
            return result;
        } else return "No comments for " + fileHash;
    }


}