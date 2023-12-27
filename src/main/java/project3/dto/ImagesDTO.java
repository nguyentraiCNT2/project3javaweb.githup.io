package project3.dto;

public class ImagesDTO {
    private Long imagesid;
    private String imagesurl;
    private Long productsid;

    public Long getImagesid() {
        return imagesid;
    }

    public void setImagesid(Long imagesid) {
        this.imagesid = imagesid;
    }

    public String getImagesurl() {
        return imagesurl;
    }

    public void setImagesurl(String imagesurl) {
        this.imagesurl = imagesurl;
    }

    public Long getProductsid() {
        return productsid;
    }

    public void setProductsid(Long productsid) {
        this.productsid = productsid;
    }
}
