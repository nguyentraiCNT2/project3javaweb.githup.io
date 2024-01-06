package project3.api.output;

import project3.dto.ImagesDTO;

import java.util.ArrayList;
import java.util.List;

public class ImagesOutput {
    private int page;
    private int totalPage;
    private List<ImagesDTO> listResult = new ArrayList<>();

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

    public List<ImagesDTO> getListResult() {
        return listResult;
    }

    public void setListResult(List<ImagesDTO> listResult) {
        this.listResult = listResult;
    }
}
