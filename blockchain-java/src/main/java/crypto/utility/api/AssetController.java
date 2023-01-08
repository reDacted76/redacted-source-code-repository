package crypto.utility.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AssetController {

    @Autowired
    private AssetService assetService;

    @RequestMapping("/add")
    public void asset() {
        Asset asset = new Asset("BTC", 1, 24000.256416, "Amila");
        assetService.saveAsset(asset);
    }
}
