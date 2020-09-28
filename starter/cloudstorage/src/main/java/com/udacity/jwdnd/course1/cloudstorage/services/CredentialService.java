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
        Credential credentials = credentialMapper.findCredentialById(credentialForm.getCredentialId());
        if(credentials != null) {
            credentials.setUrl(credentialForm.getCredentialUrl());
            credentials.setUsername(credentialForm.getUsername());
            credentials.setPassword(credentialForm.getPassword());
            credentialMapper.updateCredentialById(credentials);
        } else {
            credentials = new Credential();
            credentials.setUrl(credentialForm.getUrl());
            credentials.setUsername(credentialForm.getUsername());
            credentials.setPassword(credentialForm.getPassword());
            credentialMapper.insertCredential(credentials);
        }
    }

    public Credential getCredential(Integer credentialId) {
        return credentialMapper.findCredentialById(credentialId);
    }

    public List<Credential> getPageCredentials() {
        return credentialMapper.getAllCredentials();
    }

    public void deleteCredential(Integer credentialId) {
        credentialMapper.deleteCredential(credentialId);
    }
}
