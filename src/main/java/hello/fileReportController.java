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

    String uri = "https://www.virustotal.com/vtapi/v2/file/";
    String apiKey = "ca2f0d1535e2289ff920b142f3f5981fbcfd03b8f46c7da62c722a3ada989321";

  /*     @Value("${app.apiKey}")
       private String apiKey;
*/
        @RequestMapping("/file/report")
        public String getReport (@RequestParam("fileDigest") String fileHash)
        {

        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri+"report")
                .queryParam("apikey", apiKey)
                .queryParam("resource", fileHash);

        String result = restTemplate.getForObject(builder.toUriString(), String.class);
        return result ;
    }

    @RequestMapping("/file/behaviour")
    public String getBehaviour (@RequestParam("fileDigest") String fileHash)
    {

        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri+"behaviour")
                .queryParam("apikey", apiKey)
                .queryParam("hash", fileHash);

        String result = restTemplate.getForObject(builder.toUriString(), String.class);
        return result ;
    }

}