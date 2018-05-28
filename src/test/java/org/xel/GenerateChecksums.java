package org.xel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.xel.crypto.Crypto;
import org.xel.db.DbIterator;
import org.xel.util.Convert;
import org.xel.util.Logger;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Properties;

public class GenerateChecksums extends AbstractBlockchainTest {

    protected static boolean isNxtInitted = false;


    @Before
    public void init() {
        if (!isNxtInitted) {
            Properties properties = AbstractBlockchainTest.newTestProperties();
            properties.setProperty("nxt.isTestnet", "false");
            properties.setProperty("nxt.isOffline", "true");
            AbstractBlockchainTest.init(properties);
            isNxtInitted = true;
        }
    }

    private byte[] verifyChecksum(int fromHeight, int toHeight) {
        MessageDigest digest = Crypto.sha256();
        try (Connection con = Db.db.getConnection();
             PreparedStatement pstmt = con.prepareStatement(
                     "SELECT * FROM transaction WHERE height > ? AND height <= ? ORDER BY id ASC, timestamp ASC")) {
            pstmt.setInt(1, fromHeight);
            pstmt.setInt(2, toHeight);
            try (DbIterator<TransactionImpl> iterator = blockchain.getTransactions(con, pstmt)) {
                while (iterator.hasNext()) {
                    digest.update(iterator.next().bytes());
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.toString(), e);
        }
        byte[] checksum = digest.digest();
        return checksum;
    }

    protected static void shutdown() {
    }

    @Test
    public void generateChecksums(){

        {
            System.out.println("private static final byte[] CHECKSUM_100000 =\n" +
                    "            new byte[] {");
            byte[] ch = verifyChecksum(0, Constants.CHECKSUM_100000);
            for (int i = 0; i < ch.length; i++) System.out.print(ch[i] + ", ");
            System.out.println("};");
        }
        {
            System.out.println("private static final byte[] CHECKSUM_200000 =\n" +
                    "            new byte[] {");
            byte[] ch = verifyChecksum(Constants.CHECKSUM_100000, Constants.CHECKSUM_200000);
            for (int i = 0; i < ch.length; i++) System.out.print(ch[i] + ", ");
            System.out.println("};");
        }
        {
            System.out.println("private static final byte[] CHECKSUM_300000 =\n" +
                    "            new byte[] {");
            byte[] ch = verifyChecksum(Constants.CHECKSUM_200000, Constants.CHECKSUM_300000);
            for (int i = 0; i < ch.length; i++) System.out.print(ch[i] + ", ");
            System.out.println("};");
        }
        {
            System.out.println("private static final byte[] CHECKSUM_338155 =\n" +
                    "            new byte[] {");
            byte[] ch = verifyChecksum(Constants.CHECKSUM_300000, Constants.CHECKSUM_338155);
            for (int i = 0; i < ch.length; i++) System.out.print(ch[i] + ", ");
            System.out.println("};");
        }

    }



}
