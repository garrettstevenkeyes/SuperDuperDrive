package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.CredentialForm;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CredentialService {

    private CredentialMapper credentialMapper;

    public CredentialService(CredentialMapper credentialMapper){
        this.credentialMapper = credentialMapper;
    }

    public void addCredential(CredentialForm credentialForm) {
        Credential newCredential = new Credential();
        newCredential.setUrl(credentialForm.getUrl());
        newCredential.setUsername(credentialForm.getUsername());
        newCredential.setPassword(credentialForm.getPassword());
        credentialMapper.insertCredential(newCredential);
    }

    public List<Credential> getPageCredentials() {
        return credentialMapper.getAllCredentials();
    }

    public void deleteCredential(Integer credentialId) {
        credentialMapper.deleteCredential(credentialId);
    }
}
