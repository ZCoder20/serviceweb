package com.example.postgres.common.util;

import java.io.*;
import java.nio.ByteBuffer;

public class ByteUtil {
    public static ByteBuffer toByteBuffer(Object obj) {
        ByteBuffer retValue = null;
        try {
            retValue = ByteBuffer.wrap(convertToByte(obj));

        } catch (Exception ex) {
            //throw new InternalErrorException(ERROR);
        }
        return retValue;
    }

    private static byte[] convertToByte(Object obj) {
        byte[] bytes = null;
        try (
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outStream)){
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
            bytes = outStream.toByteArray();

            objectOutputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            // throw new InternalErrorExcption(ERROR);

        }
        return bytes;
    }

    public static Object convertToObj(byte[] bytes) throws
            IOException, ClassNotFoundException {
        Object output;
        try (
            ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)){

            output = objectInputStream.readObject();
        }
        return output;


    }
}
