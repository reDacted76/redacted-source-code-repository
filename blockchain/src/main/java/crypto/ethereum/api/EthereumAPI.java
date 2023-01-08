import io.kocamoe.ethereum.wallet.EthereumWalletService;
import org.web3j.crypto.Bip39Wallet;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.*;

import java.math.BigInteger;

public class EthereumAPI {

    public static void main(String[] args) throws Exception {


        EtherBlockchain ethereum = new EtherBlockchain();

        String path = "C:\\Source Code\\Java\\J20220606\\src\\main\\resources\\wallets\\";
        String sendersPrivateKey = "3e8fcf120a1009dfdf33d761e08f4abf1e3893be9df1abc66e2a59d3d424cd70";
        String recipient = "0x4f43f6aa563F23430728e0f865014390ccC507c2";
        String mnemonic = "dilemma average nuclear flower orchard enter blood limb flip pet sadness congress";


        System.out.println(ethereum.getWeb3ClientVersion());


        String password = "ghsjdhsjhd";

        EthereumWalletService walletService = new EthereumWalletService();

        // Bip39Wallet wallet = walletService.createBip39Wallet(password, path);
        // Credentials credentials = walletService.loadBip39Wallet(password, wallet);


        String filename = "UTC--2022-06-08T22-20-51.84371000Z--c4ccdd814ddb0502b474ae6d6bbec51947abccfa.json";

        String source = path + filename;





 //       Credentials credentials = walletService.loadBip39WalletFromSource(password, source);
//        System.out.println(credentials.getAddress());
//        System.out.println(credentials.getEcKeyPair().getPrivateKey());
//        System.out.println(credentials.getEcKeyPair().getPublicKey());
//        System.out.println(credentials.hashCode());
        //ethereum.transferEtherToAddress(
        //        "6928d37348e5ed759158d9db9dd509b400a549150c1810330cdde1b14bfc8799",
        //        "0xC4CcDD814Ddb0502B474AE6D6bbec51947aBcCFa");
        //System.out.println(wallet.getMnemonic());
        //System.out.println(wallet.getFilename());

    }
}
