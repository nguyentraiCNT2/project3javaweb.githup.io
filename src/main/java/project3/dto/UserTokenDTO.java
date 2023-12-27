package project3.dto;

import java.sql.Date;

public class UserTokenDTO {
    private Long usertokenid;
    private String tokenurl;
    private String userid;
    private Date datetoken;

    public Long getUsertokenid() {
        return usertokenid;
    }

    public void setUsertokenid(Long usertokenid) {
        this.usertokenid = usertokenid;
    }

    public String getTokenurl() {
        return tokenurl;
    }

    public void setTokenurl(String tokenurl) {
        this.tokenurl = tokenurl;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Date getDatetoken() {
        return datetoken;
    }

    public void setDatetoken(Date datetoken) {
        this.datetoken = datetoken;
    }
}
