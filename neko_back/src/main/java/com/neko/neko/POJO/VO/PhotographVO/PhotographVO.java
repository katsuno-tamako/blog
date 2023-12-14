package com.neko.neko.POJO.VO.PhotographVO;

import com.neko.neko.POJO.PO.photographPO.PhotographPO;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
@Component
public class PhotographVO implements Serializable {

    private String localURL;
    private List<PhotographPO> photographPOS;


    public String getLocalURL() {
        return localURL;
    }

    public void setLocalURL(String localURL) {
        this.localURL = localURL;
    }

    public List<PhotographPO> getPhotographPOS() {
        return photographPOS;
    }

    public void setPhotographPOS(List<PhotographPO> photographPOS) {
        this.photographPOS = photographPOS;
    }

    @Override
    public String toString() {
        return "PhotographVO{" +
                "localURL='" + localURL + '\'' +
                ", photographPOS=" + photographPOS +
                '}';
    }
}
