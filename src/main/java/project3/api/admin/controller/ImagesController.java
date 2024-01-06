package project3.api.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project3.service.ImagesService;
import project3.api.output.ImagesOutput;
import project3.dto.ImagesDTO;
import project3.dto.UserDTO;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/admin/images/api")
public class ImagesController {
    @Autowired
    private final ImagesService imagesService;
    public ImagesController(ImagesService imagesService) {
        this.imagesService = imagesService;
    }
    @GetMapping("/admin/images-list")
    public ImagesOutput getAll(@RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
        ImagesOutput result = new ImagesOutput();
        result.setPage(page);
        Pageable pageable = new PageRequest(page - 1, limit);
        result.setListResult(imagesService.getAll(pageable));
        result.setTotalPage((int) Math.ceil((double) (imagesService.totalItem()) / limit));
        model.addAttribute("ImagesOutput", result);
        return result;
    }
    @GetMapping("/admin/images-by-id/{imagesid}")
    public ResponseEntity<?> getByImagesid(@PathVariable Long imagesid) {
        try {
            ImagesDTO imagesDTO = imagesService.getByImagesid(imagesid);

            return new ResponseEntity<>(imagesDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>((List<UserDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/admin/images-by-productsid/{productsid}")
    public ImagesOutput getByProductsid(@PathVariable Long productsid,@RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
        ImagesOutput result = new ImagesOutput();
        result.setPage(page);
        Pageable pageable = new PageRequest(page - 1, limit);
        result.setListResult(imagesService.getByProductsid(productsid,pageable));
        result.setTotalPage((int) Math.ceil((double) (imagesService.totalItem()) / limit));
        model.addAttribute("ImagesOutput", result);
        return result;
    }

    @GetMapping("/admin/images-by-imagesurl/{imagesurl}")
    public ImagesOutput getByImagesurl(@PathVariable String imagesurl,@RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
        ImagesOutput result = new ImagesOutput();
        result.setPage(page);
        Pageable pageable = new PageRequest(page - 1, limit);
        result.setListResult(imagesService.getByImagesurl(imagesurl,pageable));
        result.setTotalPage((int) Math.ceil((double) (imagesService.totalItem()) / limit));
        model.addAttribute("ImagesOutput", result);
        return result;
    }

    @PostMapping("/admin/create-images")
    public ResponseEntity<String> createUser(@RequestBody ImagesDTO imagesDTO) {
        try {
            imagesService.createImages(imagesDTO);
            return new ResponseEntity<>("more success " , HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/admin/update-images/{imagesid}")
    public ResponseEntity<String> updateRole(@PathVariable Long imagesid, @RequestBody ImagesDTO imagesDTO) {
        try {
            imagesDTO.setImagesid(imagesid);
            imagesService.updateImages(imagesDTO);
            return new ResponseEntity<>(imagesDTO+"Cập nhật quyền người dùng thành công", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Transactional
    @DeleteMapping("/admin/delete-images/{imagesid}")
    public ResponseEntity<String> deleteUserAccount(@PathVariable Long imagesid) {
        try {
            imagesService.deleteByImagesid(imagesid);
            return new ResponseEntity<>("Xóa Ảnh thành công", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{imagesid}/upload-image")
    public ResponseEntity<Void> uploadImage(@PathVariable Long imagesid, @RequestParam("file") MultipartFile file) {
        try {
            imagesService.uploadImage(imagesid, file);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
