package in.sellmydevice.dto;

import in.sellmydevice.entity.Mobile;

public class MobileRequest {
    private Mobile mobile;
    private String image; // This should be a base64-encoded image

    public Mobile getMobile() {
        return mobile;
    }

    public void setMobile(Mobile mobile) {
        this.mobile = mobile;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

