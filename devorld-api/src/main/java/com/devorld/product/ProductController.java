package com.devorld.product; import org.springframework.web.bind.annotation.*; import org.springframework.http.ResponseEntity; import org.springframework.security.access.prepost.PreAuthorize; import jakarta.validation.Valid; import java.util.List;
@RestController @RequestMapping("/api/products") public class ProductController { private final ProductRepository repo; public ProductController(ProductRepository r){repo=r;}
 @GetMapping public List<Product> all(@RequestParam(required=false) String q,@RequestParam(required=false) String category){return repo.search(blank(q),blank(category));}
 @GetMapping("/{id}") public ResponseEntity<Product> one(@PathVariable Long id){return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());}
 @PostMapping @PreAuthorize("hasRole('ADMIN')") public Product create(@Valid @RequestBody Product p){p.setName(p.getName().trim());return repo.save(p);}
 @PutMapping("/{id}") @PreAuthorize("hasRole('ADMIN')") public ResponseEntity<Product> update(@PathVariable Long id,@RequestBody Product p){return repo.findById(id).map(old->{old.setName(p.getName());old.setCategory(p.getCategory());old.setPrice(p.getPrice());old.setRating(p.getRating());old.setDiscountPercent(p.getDiscountPercent());old.setImageUrl(p.getImageUrl());return ResponseEntity.ok(repo.save(old));}).orElse(ResponseEntity.notFound().build());}
 @DeleteMapping("/{id}") @PreAuthorize("hasRole('ADMIN')") public ResponseEntity<Void> delete(@PathVariable Long id){if(!repo.existsById(id))return ResponseEntity.notFound().build();repo.deleteById(id);return ResponseEntity.noContent().build();}
 private String blank(String s){return s==null||s.isBlank()?null:s.trim();}
}
