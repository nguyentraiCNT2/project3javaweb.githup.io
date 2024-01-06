package project3.api.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project3.api.output.ImportOutput;
import project3.dto.ImportdetailsDTO;
import project3.service.ImportdetailsService;

import java.util.Date;

@RestController
@RequestMapping("/admin/import/api")
public class ImportController {
    @Autowired
    private ImportdetailsService importdetailsService;
    @GetMapping("/admin/import-list")
    public ImportOutput getByImportProductsid(@RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
        ImportOutput result = new ImportOutput();
        result.setPage(page);
        Pageable pageable = new PageRequest(page - 1, limit);
        result.setListsResult(importdetailsService.getAll(pageable));
        result.setTotalPage((int) Math.ceil((double) (importdetailsService.totalItem()) / limit));
        model.addAttribute("ImportOutput", result);
        return result;
    }

    @PostMapping("/admin/create-import-product")
    public ResponseEntity<String> createImportdetails(@RequestBody ImportdetailsDTO importdetailsDTO) {
        try {
            Date date = new Date();
            importdetailsDTO.setImportdate(date);
            importdetailsService.createImportdetails(importdetailsDTO);
            return new ResponseEntity<>("more success ", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
