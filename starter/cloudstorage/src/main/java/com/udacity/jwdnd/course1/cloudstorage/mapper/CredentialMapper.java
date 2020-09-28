package com.udacity.jwdnd.course1.cloudstorage.mapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface CredentialMapper {
    @Select("SELECT * FROM CREDENTIALS")
    List<Credential> getAllCredentials();

    @Select("SELECT * FROM CREDENTIALS WHERE credentialid = #{credentialId}")
    public Credential findCredentialById(Integer credentialId);

    @Update("UPDATE CREDENTIALS SET credentialurl=#{credentialUrl}, "
                    + "username=#{username} "
                    + "password=#{password} "
                    + "where credentialId=#{credentialId")
    public void updateCredentialById(Credential credential);

    @Insert("INSERT INTO CREDENTIALS (credentialurl, username, key, password, userid) VALUES(#{credentialUrl}, #{username}, #{key}, #{password}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "credentialId")
    int insertCredential(Credential credential);

    @Delete("DELETE FROM CREDENTIALS WHERE credentialId = #{credentialId}")
    void deleteCredential(Integer credentialId);
}
