package com.devorld.order;
import org.springframework.web.bind.annotation.*; import org.springframework.http.ResponseEntity; import org.springframework.security.access.prepost.PreAuthorize; import java.util.Map;
@RestController @RequestMapping("/api") public class OrderController {
 @PostMapping("/orders") public ResponseEntity<?> createOrder(){return ResponseEntity.status(501).body(Map.of("message","COD order service is scaffolded for implementation after JWT identity and transactional stock/order rules are configured."));}
 @GetMapping("/orders/my") public ResponseEntity<?> myOrders(){return ResponseEntity.status(501).body(Map.of("message","Requires authenticated order service."));}
 @GetMapping("/admin/orders") @PreAuthorize("hasRole('ADMIN')") public ResponseEntity<?> adminOrders(){return ResponseEntity.status(501).body(Map.of("message","Admin order service is scaffolded."));}
 @PatchMapping("/admin/orders/{id}/status") @PreAuthorize("hasRole('ADMIN')") public ResponseEntity<?> updateStatus(@PathVariable Long id,@RequestBody Map<String,String> body){return ResponseEntity.status(501).body(Map.of("message","Add validated status transition service before enabling delivery updates."));}
}
