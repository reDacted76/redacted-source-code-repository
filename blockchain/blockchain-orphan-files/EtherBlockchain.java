import org.web3j.crypto.*;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterNumber;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class EtherBlockchain {

    final private Web3j web3Client = Web3j.build(new HttpService("HTTP://127.0.0.1:8545"));

    public String getWeb3ClientVersion() throws IOException {
        Web3ClientVersion clientVersion = web3Client.web3ClientVersion().send();
        return clientVersion.getWeb3ClientVersion();
    }

    public EthBlock getEthBlock(BigInteger blockNumber, boolean b) throws IOException {
        DefaultBlockParameter defaultBlockParameter = new DefaultBlockParameterNumber(blockNumber);
        EthBlock block;
        return block = web3Client.ethGetBlockByNumber(defaultBlockParameter, b).send();
    }

    public TransactionReceipt transferEtherToAddress(String sendersPrivateKey, String recipientsAddress) throws Exception {
        TransactionReceipt transactionReceipt;
        Credentials credentialsByPrivateKey = Credentials.create(sendersPrivateKey);
        TransactionManager transactionManager = new RawTransactionManager(web3Client, credentialsByPrivateKey );
        Transfer transfer = new Transfer(web3Client, transactionManager);
        transactionReceipt = transfer.sendFunds(recipientsAddress, BigDecimal.ONE, Convert.Unit.ETHER).send();
        return transactionReceipt;
    }

    //OVER LOADED METHOD
    public TransactionReceipt transferEtherToAddress(String sendersPrivateKey, String recipientsAddress,
                                                     BigInteger GAS_PRICE, BigInteger GAS_LIMIT ) throws Exception {
        TransactionReceipt transactionReceipt;
        Credentials credentialsByPrivateKey = Credentials.create(sendersPrivateKey);
        TransactionManager transactionManager = new RawTransactionManager(web3Client, credentialsByPrivateKey );
        Transfer transfer = new Transfer(web3Client, transactionManager);
        transactionReceipt = transfer.sendFunds(recipientsAddress, BigDecimal.ONE, Convert.Unit.ETHER, GAS_PRICE, GAS_LIMIT).send();
        return transactionReceipt;
    }

    public BigInteger getEtherUnscaledBalance(String address) throws ExecutionException, InterruptedException, TimeoutException {
        EthGetBalance ethGetBalance = web3Client
                .ethGetBalance(address, DefaultBlockParameter.valueOf("latest"))
                .sendAsync()
                .get(10, TimeUnit.SECONDS);
        final BigInteger unscaledBalance ;
        return unscaledBalance = ethGetBalance.getBalance();
    }

    public BigDecimal getEthScaledBalance(String address) throws ExecutionException, InterruptedException, TimeoutException {
        BigDecimal scaledBalance;
        return scaledBalance= new BigDecimal(getEtherUnscaledBalance(address))
                .divide(new BigDecimal(1000000000000000000L), 18, RoundingMode.HALF_UP);
    }

    public EthTransaction getEthTransactionReceipt(String transactionHash) throws IOException {
       EthTransaction transactionReceipt;
       transactionReceipt= web3Client.ethGetTransactionByHash(transactionHash).send();
        return transactionReceipt;
    }
}
