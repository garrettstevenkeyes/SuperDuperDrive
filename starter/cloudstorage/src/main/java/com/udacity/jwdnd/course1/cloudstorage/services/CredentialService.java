package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credential;

import org.springframework.stereotype.Service;

@Service
public class CredentialService {
    private final CredentialMapper credentialMapper;

    /*constructor*/
    public CredentialService(CredentialMapper credentialMapper) {
        this.credentialMapper = credentialMapper;
    }

    /*Use this method to check whether a username is available or has already been taken*/
    public boolean isCredentialUrlAvailable(String url) {
        return credentialMapper.getUrl(url) == null;
    }

    /*Use this method to create a new note*/
    public int createNote(Credential credential) {
        return credentialMapper.insert(new Credential(null, credential.getCredentialUrl(), credential.getCredentialUsername(), credential.getCredentialKey(), credential.getCredentialPassword(), credential.getCredentialUserId()));
    }

    /*Use this method to delete a note*/
    public void deleteCredential(Credential credential) {
        credentialMapper.delete(credential);
        /*build something that checks if the object exists, put this in the credential controller*/

    }
}
