package hello;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class fileReportController
{
    @Value("${virusTotalUri}")
    private String uri;

    @Value("${apiKey}")
    private String apiKey;

        @RequestMapping("/file/report")
        public String getFileReport (@RequestParam("fileDigest") String fileHash)
        {

        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri+"file/report")
                .queryParam("apikey", apiKey)
                .queryParam("resource", fileHash);

        String result = restTemplate.getForObject(builder.toUriString(), String.class);
        return result ;
    }

    @RequestMapping("/file/behaviour")
    public String getFileBehaviour (@RequestParam("fileDigest") String fileHash)
    {

        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri+"file/behaviour")
                .queryParam("apikey", apiKey)
                .queryParam("hash", fileHash);

        String result = restTemplate.getForObject(builder.toUriString(), String.class);
        return result ;
    }


    @RequestMapping("/url/report")
    public String getUrlReport (@RequestParam("url") String url)
    {

        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri+"url/report")
                .queryParam("apikey", apiKey)
                .queryParam("resource", url);

        String result = restTemplate.getForObject(builder.toUriString(), String.class);
        return result ;
    }

    @RequestMapping("/ip-address/report")
    public String getIpAddressReport (@RequestParam("ipAddress") String ipAddress)
    {

        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri+"ip-address/report")
                .queryParam("apikey", apiKey)
                .queryParam("ip", ipAddress);

        String result = restTemplate.getForObject(builder.toUriString(), String.class);
        return result ;
    }

}