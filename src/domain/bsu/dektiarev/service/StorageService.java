package domain.bsu.dektiarev.service;

import com.google.api.services.storage.model.Bucket;
import com.google.api.services.storage.model.StorageObject;
import domain.bsu.dektiarev.entity.NewsEntity;
import domain.bsu.dektiarev.entity.NewsViewEntity;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.List;

/**
 * Created by USER on 11.04.2016.
 */
public interface StorageService {

    Bucket getBucket(String bucketName) throws IOException, GeneralSecurityException;
    List<StorageObject> listBucket(String bucketName) throws IOException, GeneralSecurityException;
    void uploadFile(String name, String contentType, File file)
            throws IOException, GeneralSecurityException;
    StorageObject getObjectByURL(String url) throws IOException, GeneralSecurityException;
    StorageObject getImageByNewsEntity(NewsEntity newsEntity) throws IOException, GeneralSecurityException;
    //String getDescription(NewsEntity newsEntity) throws IOException, GeneralSecurityException;
    NewsViewEntity convertNewsEntity(NewsEntity newsEntity) throws IOException, GeneralSecurityException;
    void uploadImage(String name, InputStream inputStream) throws IOException, GeneralSecurityException;
}
