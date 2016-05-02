package by.bsu.dektiarev.service;

import com.google.api.services.storage.model.Bucket;
import com.google.api.services.storage.model.StorageObject;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.io.File;

/**
 * Created by USER on 11.04.2016.
 */
public interface StorageService {

    Bucket getBucket(String bucketName) throws IOException, GeneralSecurityException;
    List<StorageObject> listBucket(String bucketName) throws IOException, GeneralSecurityException;
    void uploadFile(String name, String contentType, File file, String bucketName)
            throws IOException, GeneralSecurityException;
}
