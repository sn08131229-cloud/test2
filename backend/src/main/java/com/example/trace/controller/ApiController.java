package com.example.trace.controller;

import com.example.trace.entity.Device;
import com.example.trace.repo.BorrowOrderRepo;
import com.example.trace.repo.FlowRecordRepo;
import com.example.trace.repo.PurchaseOrderRepo;
import com.example.trace.repo.UserRepo;
import com.example.trace.service.BusinessService;
import com.example.trace.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {
    private final UserRepo userRepo;
    private final BusinessService service;
    private final PurchaseOrderRepo purchaseRepo;
    private final BorrowOrderRepo borrowRepo;
    private final FlowRecordRepo flowRepo;

    @PostMapping("/login")
    public ApiResponse<?> login(@RequestBody Map<String, String> req) {
        return userRepo.findByUsername(req.get("username"))
                .filter(u -> u.getPassword().equals(req.get("password")))
                .<ApiResponse<?>>map(ApiResponse::ok)
                .orElse(ApiResponse.fail("用户名或密码错误"));
    }

    @GetMapping("/devices") public ApiResponse<?> devices() { return ApiResponse.ok(service.devices()); }
    @PostMapping("/devices") public ApiResponse<?> addDevice(@RequestBody Device d,@RequestHeader(value="X-User",defaultValue="system") String op){ try{return ApiResponse.ok(service.register(d,op));}catch(Exception e){ return ApiResponse.fail(e.getMessage()); }}
    @GetMapping("/devices/{code}") public ApiResponse<?> device(@PathVariable String code){ return service.device(code).<ApiResponse<?>>map(ApiResponse::ok).orElse(ApiResponse.fail("not found")); }
    @GetMapping("/devices/{code}/flows") public ApiResponse<?> flowsByDevice(@PathVariable String code){ return ApiResponse.ok(service.flows(code)); }

    @PostMapping("/purchase/apply") public ApiResponse<?> purchaseApply(@RequestBody Map<String,String> req){ return ApiResponse.ok(service.purchaseApply(Long.valueOf(req.get("deviceId")),Long.valueOf(req.get("hospitalId")),req.get("hospitalName"),req.getOrDefault("operator","hospital"))); }
    @PostMapping("/purchase/approve") public ApiResponse<?> purchaseApprove(@RequestBody Map<String,String> req){ return ApiResponse.ok(service.purchaseApprove(Long.valueOf(req.get("orderId")),Boolean.parseBoolean(req.get("pass")),req.getOrDefault("operator","supplier"))); }
    @PostMapping("/purchase/reject") public ApiResponse<?> purchaseReject(@RequestBody Map<String,String> req){ req.put("pass","false"); return purchaseApprove(req); }
    @PostMapping("/purchase/receive") public ApiResponse<?> receive(@RequestBody Map<String,String> req){ return ApiResponse.ok(service.purchaseReceive(Long.valueOf(req.get("orderId")),req.getOrDefault("operator","hospital"))); }
    @GetMapping("/purchase/list") public ApiResponse<?> purchaseList(){ return ApiResponse.ok(purchaseRepo.findAll()); }

    @PostMapping("/borrow/apply") public ApiResponse<?> borrowApply(@RequestBody Map<String,String> req){ return ApiResponse.ok(service.borrowApply(req)); }
    @PostMapping("/borrow/approve") public ApiResponse<?> borrowApprove(@RequestBody Map<String,String> req){ return ApiResponse.ok(service.borrowApprove(req, true)); }
    @PostMapping("/borrow/reject") public ApiResponse<?> borrowReject(@RequestBody Map<String,String> req){ return ApiResponse.ok(service.borrowApprove(req, false)); }
    @PostMapping("/borrow/lend") public ApiResponse<?> borrowLend(@RequestBody Map<String,String> req){ return ApiResponse.ok(service.borrowLend(req)); }
    @PostMapping("/borrow/receive") public ApiResponse<?> borrowReceive(@RequestBody Map<String,String> req){ return ApiResponse.ok(service.borrowReceive(req)); }
    @PostMapping("/borrow/return/apply") public ApiResponse<?> returnApply(@RequestBody Map<String,String> req){ return ApiResponse.ok(service.returnApply(req)); }
    @PostMapping("/borrow/return/confirm") public ApiResponse<?> returnConfirm(@RequestBody Map<String,String> req){ return ApiResponse.ok(service.returnConfirm(req)); }
    @GetMapping("/borrow/list") public ApiResponse<?> borrowList(){ return ApiResponse.ok(borrowRepo.findAll()); }

    @GetMapping("/flows") public ApiResponse<?> flows(){ return ApiResponse.ok(service.allFlows()); }
    @GetMapping("/flows/byTxHash/{txHash}") public ApiResponse<?> byTx(@PathVariable String txHash){ return flowRepo.findByTxHash(txHash).<ApiResponse<?>>map(ApiResponse::ok).orElse(ApiResponse.fail("not found")); }
    @GetMapping("/flows/verify/{flowId}") public ApiResponse<?> verify(@PathVariable Long flowId){ return ApiResponse.ok(service.verify(flowId)); }
    @GetMapping("/dashboard/stats") public ApiResponse<?> stats(){ return ApiResponse.ok(service.stats()); }
}
