package am.hay.cc.io.manager;

import am.hay.cc.io.interfaces.FileIOInterface;
import am.hay.cc.io.interfaces.FileIoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;

@Component
@PropertySource("classpath:io.properties")
public class FileIOManager implements FileIOInterface {

    private FileIoService fileIoService;

    @Value("${BASE_URL}")
    private String BASE_URL;

    @Autowired
    public FileIOManager(FileIoService fileIoService) {
        this.fileIoService = fileIoService;
    }

    @Override
    public String save(MultipartFile file) throws IOException {
        String filePath = fileIoService.store(file);
        return BASE_URL + ("/file/" + filePath);
    }

    @Override
    public ResponseEntity<Resource> getOne(String name) throws MalformedURLException {
        Resource resource = fileIoService.loadAsResource(name);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + resource.getFilename() + "\"").body(resource);
    }

    @Override
    public ResponseEntity<Boolean> delete(String name) throws IOException {
        return new ResponseEntity<>(fileIoService.deleteByName(name), HttpStatus.FOUND);
    }
}