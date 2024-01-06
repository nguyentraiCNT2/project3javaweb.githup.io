package project3.api.output;

import project3.dto.LoveListDTO;
import project3.dto.OrderdetailsDTO;

import java.util.ArrayList;
import java.util.List;

public class Orderdetailsoutput {
    private int page;
    private int totalPage;
    private List<OrderdetailsDTO> listResult = new ArrayList<>();

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

    public List<OrderdetailsDTO> getListResult() {
        return listResult;
    }

    public void setListResult(List<OrderdetailsDTO> listResult) {
        this.listResult = listResult;
    }
}
