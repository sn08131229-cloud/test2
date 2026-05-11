package com.example.trace.service;
import java.util.Map;
public interface ChainService { Map<String,Object> addFlowRecord(String deviceCode,String eventType,String dataHash,String operator); }
