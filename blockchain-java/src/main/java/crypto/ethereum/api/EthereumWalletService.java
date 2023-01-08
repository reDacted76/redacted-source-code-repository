package crypto.ethereum.api;

import org.web3j.crypto.*;

import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class EthereumWalletService {

    public void createWallet(String password, String path) throws InvalidAlgorithmParameterException,
            CipherException, NoSuchAlgorithmException, IOException, NoSuchProviderException {
        File file  = new File(path);
        WalletUtils.generateNewWalletFile(password,file);
    }

    public void createLightWallet(String password, String path) throws InvalidAlgorithmParameterException,
            CipherException, NoSuchAlgorithmException, IOException, NoSuchProviderException {
        File file  = new File(path);
        WalletUtils.generateLightNewWalletFile(password, file);
    }

    public static void createFullWallet(String password, String path) throws InvalidAlgorithmParameterException,
            CipherException, NoSuchAlgorithmException, IOException, NoSuchProviderException {
        File file  = new File(path);
        WalletUtils.generateFullNewWalletFile(password,file);
    }

    public Bip39Wallet createBip39Wallet(String password, String path) throws CipherException, IOException {
        File file  = new File(path);
        Bip39Wallet wallet;
        return wallet = WalletUtils.generateBip39Wallet(password, file);
    }

    public Credentials loadBip39Wallet(String password, Bip39Wallet wallet) {
        Credentials credentials;
        return  credentials = WalletUtils.loadBip39Credentials(password, wallet.getMnemonic());
    }

    public Credentials loadBip39WalletFromSource(String password, String source) throws CipherException, IOException {
        return  WalletUtils.loadCredentials(password, new File(source));
    }

    public Credentials restoreBip39Wallet(String password, String mnemonic) {
        return WalletUtils.loadBip39Credentials(password, mnemonic);
    }

}
