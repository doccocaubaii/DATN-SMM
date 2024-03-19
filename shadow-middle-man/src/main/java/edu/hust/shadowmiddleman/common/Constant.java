package edu.hust.shadowmiddleman.common;

public interface Constant {
    int STATUS_ACTIVE = 1;
    int STATUS_INACTIVE = 0;

    String HTTP_OK = "200";

    interface RESPONSE{
        interface MESSAGE {

            String OK = "Thực hiện thành công";
        }
    }
}
