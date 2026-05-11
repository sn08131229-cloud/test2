package com.example.trace.service.impl;
import com.example.trace.service.ChainService;import org.springframework.stereotype.Service;import java.util.*;
@Service("mockChainService")
public class MockChainService implements ChainService {
 public Map<String,Object> addFlowRecord(String deviceCode,String eventType,String dataHash,String operator){
  String tx="0x"+UUID.randomUUID().toString().replace("-","")+UUID.randomUUID().toString().replace("-","").substring(0,24);
  return Map.of("txHash",tx.substring(0,66),"chainStatus","MOCK_SUCCESS","blockNumber",Math.abs(new Random().nextLong()%100000));
 }
}
