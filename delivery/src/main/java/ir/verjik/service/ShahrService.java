package ir.verjik.service;

import ir.verjik.entity.Shahr;

import java.util.List;

public interface ShahrService {
    List<Shahr> getInfo(Long ostanId);
}
