package hello;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FullIpReport {

    private List<String> detected_urls;
    private String asn;
    private String country;
    private String response_code;
    private String as_owner;
    private List<Resolution> resolutions;
    private String verbose_msg;

    public List<String> getDetected_urls() {
        return detected_urls;
    }

    public void setDetected_urls(List<String> detected_urls) {

        this.detected_urls = detected_urls;
    }

    public String getAsn() {
        return asn;
    }

    public void setAsn(String asn) {
        this.asn = asn;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getResponse_code() {
        return response_code;
    }

    public void setResponse_code(String response_code) {
        this.response_code = response_code;
    }

    public String getAs_owner() {
        return as_owner;
    }

    public void setAs_owner(String as_owner) {
        this.as_owner = as_owner;
    }

    public List<Resolution> getResolutions() {
        return resolutions;
    }

    public void setResolutions(List<Resolution> resolutions) {
        this.resolutions = resolutions;
    }

    public String getVerbose_msg() {
        return verbose_msg;
    }

    public void setVerbose_msg(String verbose_msg) {
        this.verbose_msg = verbose_msg;
    }



}