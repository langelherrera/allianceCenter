package com.allianceenterprise.allianceCenter.health;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping("/live")
    public ResponseEntity<?> healthLive(){
        return  new ResponseEntity<>("Service is alive", HttpStatus.OK);
    }

    @GetMapping("/ready")
        public ResponseEntity<String> checkReadiness() {
        boolean filesystemAccessible = checkFileSystem();
        if (filesystemAccessible) {
            return  new ResponseEntity<>("Service is ready to process files",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Service is not ready: Filesystem is inaccessible", HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    private boolean checkFileSystem() {
        try {
            File tempFile = File.createTempFile("healthcheck", ".txt");
            tempFile.delete();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
