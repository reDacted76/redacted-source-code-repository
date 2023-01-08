package crypto.utility.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService {

    @Autowired
    private AssetRepository assetRepository;

    public void saveAsset(Asset asset) {
      assetRepository.save(asset);
    }

    public void editAsset(long id, Asset asset) {
        assetRepository.save(asset);
    }

    public void deleteAsset(long id) {
        assetRepository.deleteById(id);
    }

    public void deleteAllAsset() {
        assetRepository.deleteAll();
    }

    public Asset getAssetById(long id) {
        return assetRepository.getReferenceById(id);
    }

    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }
}
