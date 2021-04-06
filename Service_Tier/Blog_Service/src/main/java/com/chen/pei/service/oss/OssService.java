package com.chen.pei.service.oss;

import org.springframework.web.multipart.MultipartFile;

public interface OssService {
    String uploadFileAvatar(MultipartFile file);

    void deleteImage(String fileName);
}
