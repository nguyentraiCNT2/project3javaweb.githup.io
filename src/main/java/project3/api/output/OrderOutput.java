package project3.api.output;

import project3.dto.LoveListDTO;
import project3.dto.OrderOTD;

import java.util.ArrayList;
import java.util.List;

public class OrderOutput {
    private int page;
    private int totalPage;
    private List<OrderOTD> listResult = new ArrayList<>();

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

    public List<OrderOTD> getListResult() {
        return listResult;
    }

    public void setListResult(List<OrderOTD> listResult) {
        this.listResult = listResult;
    }
}
