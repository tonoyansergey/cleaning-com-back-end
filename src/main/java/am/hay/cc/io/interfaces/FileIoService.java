package am.hay.cc.io.interfaces;


import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;


public interface FileIoService {

    String store(MultipartFile file) throws IOException;

    Path load(String filename);

    Resource loadAsResource(String filename) throws MalformedURLException;

    Boolean deleteByName(String filename) throws IOException;
}
