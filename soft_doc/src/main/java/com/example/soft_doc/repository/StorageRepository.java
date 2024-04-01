package com.example.soft_doc.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StorageRepository {
    public List<String[]> readAll(String filepath);

    public void writeAll(String filepath, List<String[]> data);
}
