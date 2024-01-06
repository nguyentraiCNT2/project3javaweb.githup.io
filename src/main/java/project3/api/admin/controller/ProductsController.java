package project3.api.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project3.api.output.ProductOutput;
import project3.dto.ProductsDTO;
import project3.dto.UserDTO;
import project3.service.ProductsService;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/admin/product/api")
public class ProductsController {
    @Autowired
    private ProductsService productsService;

    @GetMapping("/admin/product-list")
    public ProductOutput getAll(@RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
        ProductOutput result = new ProductOutput();
        result.setPage(page);
        Pageable pageable = new PageRequest(page - 1, limit);
        result.setListResult(productsService.getAll(pageable));
        result.setTotalPage((int) Math.ceil((double) (productsService.totalItem()) / limit));
        model.addAttribute("userAccountOutput", result);
        return result;
    }

    @GetMapping("/admin/product-by-categoryid-list/{categoryid}")
    public ProductOutput getByCategoryid(@PathVariable Long categoryid,@RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
        ProductOutput result = new ProductOutput();
        result.setPage(page);
        Pageable pageable = new PageRequest(page - 1, limit);
        result.setListResult(productsService.getByCategoryid(categoryid,pageable));
        result.setTotalPage((int) Math.ceil((double) (productsService.totalItem()) / limit));
        model.addAttribute("userAccountOutput", result);
        return result;
    }
    @GetMapping("/admin/product-by-category-level2-id-list/{categoryLV2id}")
    public ProductOutput getByCategoryLV2id(@PathVariable Long categoryLV2id,@RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
        ProductOutput result = new ProductOutput();
        result.setPage(page);
        Pageable pageable = new PageRequest(page - 1, limit);
        result.setListResult(productsService.getByCategoryLV2id(categoryLV2id,pageable));
        result.setTotalPage((int) Math.ceil((double) (productsService.totalItem()) / limit));
        model.addAttribute("userAccountOutput", result);
        return result;
    }
    @GetMapping("/admin/product-by-love-list-id-list/{loveListid}")
    public ProductOutput getByLoveListid(@PathVariable Long loveListid,@RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
        ProductOutput result = new ProductOutput();
        result.setPage(page);
        Pageable pageable = new PageRequest(page - 1, limit);
        result.setListResult(productsService.getByLoveListid(loveListid,pageable));
        result.setTotalPage((int) Math.ceil((double) (productsService.totalItem()) / limit));
        model.addAttribute("userAccountOutput", result);
        return result;
    }
    @GetMapping("/admin/product-by-color-id-list/{colorid}")
    public ProductOutput getByColorid(@PathVariable Long colorid,@RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
        ProductOutput result = new ProductOutput();
        result.setPage(page);
        Pageable pageable = new PageRequest(page - 1, limit);
        result.setListResult(productsService.getByColorid(colorid,pageable));
        result.setTotalPage((int) Math.ceil((double) (productsService.totalItem()) / limit));
        model.addAttribute("userAccountOutput", result);
        return result;
    }
    @GetMapping("/admin/product-by-name-list/{productname}")
    public ProductOutput getByLoveListid(@PathVariable String productname,@RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
        ProductOutput result = new ProductOutput();
        result.setPage(page);
        Pageable pageable = new PageRequest(page - 1, limit);
        result.setListResult(productsService.getByProductname(productname,pageable));
        result.setTotalPage((int) Math.ceil((double) (productsService.totalItem()) / limit));
        model.addAttribute("userAccountOutput", result);
        return result;
    }
    @GetMapping("/admin/product-by-id/{productsid}")
    public ResponseEntity<?> getByProductsid(@PathVariable Long productsid) {
        try {
            ProductsDTO productsDTO = productsService.getByProductsid(productsid);

            return new ResponseEntity<>(productsDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>((List<UserDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/admin/create-product")
    public ResponseEntity<String> createProducts(@RequestBody ProductsDTO productsDTO) {
        try {
           productsService.createProducts(productsDTO);
            return new ResponseEntity<>("more success ", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }@PutMapping("/admin/update-product/{productsid}")
    public ResponseEntity<String> updateProducts(@PathVariable Long productsid, @RequestBody ProductsDTO productsDTO) {
        try {
            productsDTO.setProductsid(productsid);
            productsService.updateProducts(productsDTO);
            return new ResponseEntity<>(productsDTO+"Cập nhật quyền người dùng thành công", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // xóa dữ liệu
    @Transactional
    @DeleteMapping("/admin/delete-product/{productsid}")
    public ResponseEntity<String> deleteUserAccount(@PathVariable  Long productsid) {
        try {
            productsService.deleteByProductsid(productsid);
            return new ResponseEntity<>("Xóa Ảnh thành công", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/{productname}/upload-image-so-1")
    public ResponseEntity<Void> uploadImage1(@PathVariable String productname, @RequestParam("file") MultipartFile file) {
        try {
            productsService.uploadImage1(productname, file);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/{productname}/upload-image-so-2")
    public ResponseEntity<Void> uploadImage2(@PathVariable String productname, @RequestParam("file") MultipartFile file) {
        try {
            productsService.uploadImage2(productname, file);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/{productname}/upload-image-so-3")
    public ResponseEntity<Void> uploadImage3(@PathVariable String productname, @RequestParam("file") MultipartFile file) {
        try {
            productsService.uploadImage3(productname, file);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/{productname}/upload-image-so-4")
    public ResponseEntity<Void> uploadImage4(@PathVariable String productname, @RequestParam("file") MultipartFile file) {
        try {
            productsService.uploadImage4(productname, file);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/{productname}/upload-image-so-5")
    public ResponseEntity<Void> uploadImage5(@PathVariable String productname, @RequestParam("file") MultipartFile file) {
        try {
            productsService.uploadImage5(productname, file);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
