package project3.api.output;

import project3.dto.ProductsDTO;

import java.util.ArrayList;
import java.util.List;

public class ProductOutput {
    private int page;
    private int totalPage;
    private List<ProductsDTO> listResult = new ArrayList<>();

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<ProductsDTO> getListResult() {
        return listResult;
    }

    public void setListResult(List<ProductsDTO> listResult) {
        this.listResult = listResult;
    }
}
