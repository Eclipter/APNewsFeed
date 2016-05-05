package by.bsu.dektiarev.service.impl;

import by.bsu.dektiarev.entity.NewsEntity;
import by.bsu.dektiarev.entity.NewsViewEntity;
import by.bsu.dektiarev.service.StorageFactory;
import by.bsu.dektiarev.service.StorageService;
import com.google.api.client.http.InputStreamContent;
import com.google.api.services.storage.Storage;
import com.google.api.services.storage.model.Bucket;
import com.google.api.services.storage.model.ObjectAccessControl;
import com.google.api.services.storage.model.Objects;
import com.google.api.services.storage.model.StorageObject;
import org.springframework.stereotype.Service;

import java.io.*;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by USER on 11.04.2016.
 */
@Service
public class StorageServiceImpl implements StorageService {

    @Override
    public Bucket getBucket(String bucketName) throws IOException, GeneralSecurityException {
        Storage client = StorageFactory.getService();

        Storage.Buckets.Get bucketRequest = client.buckets().get(bucketName);
        // Fetch the full set of the bucket's properties (e.g. include the ACLs in the response)
        bucketRequest.setProjection("full");
        return bucketRequest.execute();
    }

    @Override
    public List<StorageObject> listBucket(String bucketName)
            throws IOException, GeneralSecurityException {
        Storage client = StorageFactory.getService();
        Storage.Objects.List listRequest = client.objects().list(bucketName);

        List<StorageObject> results = new ArrayList<>();
        Objects objects;

        // Iterate through each page of results, and add them to our results list.
        do {
            objects = listRequest.execute();
            // Add the items in this page of results to the list we'll return.
            results.addAll(objects.getItems());

            // Get the next page, in the next iteration of this loop.
            listRequest.setPageToken(objects.getNextPageToken());
        } while (null != objects.getNextPageToken());

        return results;
    }

    @Override
    public void uploadFile(String name, String contentType, File file)
            throws IOException, GeneralSecurityException {
        InputStreamContent contentStream = new InputStreamContent(
                contentType, new FileInputStream(file));
        // Setting the length improves upload performance
        contentStream.setLength(file.length());
        StorageObject objectMetadata = new StorageObject()
                // Set the destination object name
                .setName(name)
                // Set the access control list to publicly read-only
                .setAcl(Arrays.asList(
                        new ObjectAccessControl().setEntity("allUsers").setRole("OWNER")));

        // Do the insert
        Storage client = StorageFactory.getService();
        Storage.Objects.Insert insertRequest = client.objects().insert(
                "newsfeed_data", objectMetadata, contentStream);

        insertRequest.execute();
    }

    @Override
    public StorageObject getObjectByURL(String url) throws IOException, GeneralSecurityException {
        Storage client = StorageFactory.getService();
        Storage.Objects.Get getRequest = client.objects().get("newsfeed_data", url);
        return getRequest.execute();
    }

    @Override
    public StorageObject getImageByNewsEntity(NewsEntity newsEntity) throws IOException, GeneralSecurityException {
        String imageURL = newsEntity.getImagePath();
        return getObjectByURL(imageURL);
    }

    @Override
    public String getDescription(NewsEntity newsEntity) throws IOException, GeneralSecurityException {
        String url = newsEntity.getDescriptionPath();
        Storage client = StorageFactory.getService();
        Storage.Objects.Get getRequest = client.objects().get("newsfeed_data", url);
        InputStream inputStream = getRequest.executeMediaAsInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        return bufferedReader.readLine();
    }

    @Override
    public NewsViewEntity convertNewsEntity(NewsEntity newsEntity) throws IOException, GeneralSecurityException {
        Integer id = newsEntity.getId();
        String title = newsEntity.getTitle();
        String description = getDescription(newsEntity);
        String imageUrl = getImageByNewsEntity(newsEntity).getMediaLink();
        return new NewsViewEntity(id, title, imageUrl, description);
    }
}
