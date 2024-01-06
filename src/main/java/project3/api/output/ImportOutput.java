package project3.api.output;

import project3.dto.ImportdetailsDTO;

import java.util.ArrayList;
import java.util.List;

public class ImportOutput {
    private int page;
    private int totalPage;
    private List<ImportdetailsDTO> listsResult = new ArrayList<>();

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

    public List<ImportdetailsDTO> getListsResult() {
        return listsResult;
    }

    public void setListsResult(List<ImportdetailsDTO> listsResult) {
        this.listsResult = listsResult;
    }
}
