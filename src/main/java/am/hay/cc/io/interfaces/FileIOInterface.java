package am.hay.cc.io.interfaces;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;

public interface FileIOInterface {

    String save(MultipartFile file) throws IOException;

    ResponseEntity<Resource> getOne(String name) throws MalformedURLException;

    ResponseEntity<Boolean> delete(String name) throws IOException;
}
