package hello;

import hello.Model.FullFileReport;
import hello.Model.FullIpReport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Service
public class VirusTotalService
{
    @Value("${virusTotalUri}")
    private String uri;

    @Value("${apiKey}")
    private String apiKey;

    public FullFileReport getVirusTotalFileReport(String fileHash)
    {
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri + "file/report")
                .queryParam("apikey", apiKey)
                .queryParam("resource", fileHash);

        FullFileReport fileReport = restTemplate.getForObject(builder.toUriString(), FullFileReport.class);

        return fileReport;
    }

    public FullFileReport getVirusTotalUrlReport(String url)
    {
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri + "url/report")
                .queryParam("apikey", apiKey)
                .queryParam("resource", url);

        FullFileReport urlReport = restTemplate.getForObject(builder.toUriString(), FullFileReport.class);

        return urlReport;
    }

    public String sumbitVirusTotalUrlForScan(VirusTotalUrl url)
    {
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri + "url/scan")
                .queryParam("apikey", apiKey)
                .queryParam("url", url.getUrl());

        String result = restTemplate.postForObject(builder.toUriString(), null, String.class);
        return result;
    }


    public String getVirusTotalDomainReport(String domain)
    {
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri + "domain/report")
                .queryParam("apikey", apiKey)
                .queryParam("domain", domain);

        String result = restTemplate.getForObject(builder.toUriString(), String.class);
        return result;
    }

    public FullIpReport getVirusTotalIpAddressReport(String ipAddress)
    {
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri + "ip-address/report")
                .queryParam("apikey", apiKey)
                .queryParam("ip", ipAddress);

        FullIpReport result = restTemplate.getForObject(builder.toUriString(), FullIpReport.class);
        return result;
    }

    public String getVirusTotalComments(String fileHash)
    {
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri + "/comments/get")
                .queryParam("apikey", apiKey)
                .queryParam("resource", fileHash);

        String result = restTemplate.getForObject(builder.toUriString(), String.class);
        if (result != null)
        {
            return result;
        } else return "No comments for " + fileHash;
    }

}
