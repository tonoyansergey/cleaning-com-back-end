package am.hay.cc.io.impl;

import am.hay.cc.io.interfaces.FileIoService;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
@Validated
@PropertySource("classpath:io.properties")
public class FileIoServiceImpl implements FileIoService {

    private String filePath = "upload";

    private Path rootLocation = Paths.get(Objects.requireNonNull(filePath));

    @Override
    public String store(MultipartFile file) throws IOException {
        Files.createDirectories(rootLocation);
        String filename = String.valueOf(System.currentTimeMillis());
        filename = filename + file.getOriginalFilename();
        Files.copy(file.getInputStream(), rootLocation.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
        return filename;
    }

    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) throws MalformedURLException {
        Path path = load(filename);
        return new UrlResource(path.toUri());
    }

    @Override
    public Boolean deleteByName(String filename) throws IOException {
        return FileSystemUtils.deleteRecursively(load(filename));
    }
}
