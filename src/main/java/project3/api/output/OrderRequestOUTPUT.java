package project3.api.output;

import project3.dto.OrderOTD;
import project3.dto.OrderRequestDTO;

import java.util.ArrayList;
import java.util.List;

public class OrderRequestOUTPUT {
    private int page;
    private int totalPage;
    private List<OrderRequestDTO> listResult = new ArrayList<>();

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

    public List<OrderRequestDTO> getListResult() {
        return listResult;
    }

    public void setListResult(List<OrderRequestDTO> listResult) {
        this.listResult = listResult;
    }
}
